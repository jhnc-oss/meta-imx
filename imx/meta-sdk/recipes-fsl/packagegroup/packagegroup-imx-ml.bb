# Copyright 2019 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Add packages for AI/ML build"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit packagegroup

ML_PKGS = " \
    armnn \
    tensorflow-lite \
    tensorflow \
    onnxruntime \
"
RDEPENDS_${PN} = " \
    ${ML_PKGS} \
"
# arm-compute-library failed to build with gcc 9 and armnn depends on it so remove it temporarily
RDEPENDS_${PN}_remove = "armnn"
