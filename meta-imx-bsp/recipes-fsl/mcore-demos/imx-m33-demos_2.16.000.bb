# Copyright 2023-2024 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

require imx-mcore-demos.inc

LIC_FILES_CHKSUM:mx8ulp-nxp-bsp = "file://COPYING;md5=10c0fda810c63b052409b15a5445671a"
LIC_FILES_CHKSUM:mx93-nxp-bsp = "file://COPYING;md5=44a8052c384584ba09077e85a3d1654f"

SRC_URI[imx8ulp.md5sum] = "87140a8f7a0f60d76dad9f2e84c85d1a"
SRC_URI[imx8ulp.sha256sum] = "97c7748814bf163bd3b263c8b91e480f6c898c490a1d2db21061ecb0a67fe623"

SRC_URI[imx93.md5sum] = "b1fe2e0ed0f7e5094e0c8129f44f80a8"
SRC_URI[imx93.sha256sum] = "6a94fc318b0948483d542ca1deedaf4bf2397462942d389f4fcbb22ab484064b"

COMPATIBLE_MACHINE = "(mx8ulp-nxp-bsp|mx93-nxp-bsp)"
