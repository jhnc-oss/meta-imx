require recipes-kernel/kernel-modules/kernel-module-imx-gpu-viv_6.2.4.p4.0.bb

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRCBRANCH = "next"
KERNEL_SRC  = "git://bitbucket.sw.nxp.com/lfac/linux-nxp.git;protocol=ssh"

SRCREV = "42a1427db5664e6105591a74cbea67fd566f5a7c"

LOCALVERSION = "-5.4-zeus-${KERNEL_BRANCH}"
