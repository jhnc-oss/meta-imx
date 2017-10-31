# Copyright 2017 NXP

require recipes-bsp/firmware-imx/firmware-imx.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=08fd295cce89b0a9c74b9b83ed74f671"

#BRCM firmware v1.141.100.6
IMX_FIRMWARE_SRC ?= "git://git.freescale.com/proprietary/imx-firmware.git;protocol=git"
SRC_URI = "${FSL_MIRROR}/firmware-imx-${PV}.bin;fsl-eula=true \
           ${IMX_FIRMWARE_SRC};branch=${SRCBRANCH};destsuffix=${S}/git "

SRC_URI[md5sum] = "679ccac4c70362b305653aa517ed0a6a"
SRC_URI[sha256sum] = "0b8acef77ce665ab4504a4c5863ab69bf4e8de22ec6377ec31624bac9f7c4d2a"

#BRCM firmware git
SRCREV = "8ce9046f5058fdd2c5271f86ccfc61bc5a248ae3"

do_install_append() {
    # No need to do install for ddr & hdmi binaries
    if [ -d ${D}${base_libdir}/firmware/ddr ]; then
        rm -rf ${D}${base_libdir}/firmware/ddr
    fi
    if [ -d ${D}${base_libdir}/firmware/hdmi ]; then
        rm -rf ${D}${base_libdir}/firmware/hdmi
    fi

    # Don't install hifi4 related binary
    if [ -d ${D}${base_libdir}/firmware/hifi4 ]; then
        rm -rf ${D}${base_libdir}/firmware/hifi4
    fi

    #1FD_BCM89359
    install -d ${D}${base_libdir}/firmware/bcm/1FD_BCM89359
    cp -rfv git/brcm/1FD_BCM89359/*.bin ${D}${base_libdir}/firmware/bcm/1FD_BCM89359
    cp -rfv git/brcm/1FD_BCM89359/*.hcd ${D}${sysconfdir}/firmware/

    #1CX_BCM4356
    install -d ${D}${base_libdir}/firmware/bcm/1CX_BCM4356
    cp -rfv git/brcm/1CX_BCM4356/fw_bcmdhd.bin ${D}${base_libdir}/firmware/bcm/1CX_BCM4356
}

do_install_append_mx8 () {
    #ddr/synopsys
    install -d ${STAGING_DIR}/boot
    cp -rfv firmware/ddr/synopsys/lpddr4_pmu_train_*.bin ${STAGING_DIR}/boot

    #hdmi/cadence
    cp -rfv firmware/hdmi/cadence/hdmi_imx8m.bin ${STAGING_DIR}/boot
}

IS_8MQ = "0"
IS_8MQ_mx8mq = "1"
inherit deploy
addtask deploy before do_build after do_install
do_deploy () {
    #
    if [ "${IS_8MQ}" = "1" ]; then
    install -m 0644 ${S}/firmware/ddr/synopsys/lpddr4_pmu_train_*.bin ${DEPLOYDIR}
    install -m 0644 ${S}/firmware/hdmi/cadence/hdmi_imx8m.bin ${DEPLOYDIR}
    fi
}
