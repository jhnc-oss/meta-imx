FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_imxgpu2d = " \
    file://0018-xwayland-Fix-crash-when-run-with-no-input-device.patch \
"

PACKAGECONFIG_append_mx8   = " cairo-glesv2"

DEPENDS_IMX_TO_APPEND = ""
DEPENDS_IMX_TO_APPEND_imxgpu2d = "virtual/libg2d"
DEPENDS_append = " ${DEPENDS_IMX_TO_APPEND}"
DEPENDS_append_mx8 = " virtual/libg2d"

EXTRA_OECONF_append_mx8   = " ${EXTRA_OECONF_IMX}"

EXTRA_OEMAKE_append_mx8 = " \
    COMPOSITOR_CFLAGS="-I ${STAGING_INCDIR}/pixman-1 -DLINUX=1 -DEGL_API_FB -DEGL_API_WL" \
    FB_COMPOSITOR_CFLAGS="-DLINUX=1 -DEGL_API_FB -DEGL_API_WL" \
    SIMPLE_EGL_CLIENT_CFLAGS="-DLINUX -DEGL_API_FB -DEGL_API_WL" \
    EGL_TESTS_CFLAGS="-DLINUX -DEGL_API_FB -DEGL_API_WL" \
    CLIENT_CFLAGS="-I ${STAGING_INCDIR}/cairo -I ${STAGING_INCDIR}/pixman-1 -DLINUX -DEGL_API_FB -DEGL_API_WL" \
    COMPOSITOR_LIBS="-lGLESv2 -lEGL -lGAL -lwayland-server -lxkbcommon -lpixman-1" \
    FB_COMPOSITOR_LIBS="-lGLESv2 -lEGL -lwayland-server -lxkbcommon" \
"
