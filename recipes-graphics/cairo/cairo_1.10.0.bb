require cairo.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=e73e999e0c72b5ac9012424fa157ad77"

PR = "r1"

PACKAGECONFIG[gtk-directfb] = "--enable-xlib=no --enable-xcb=no --enable-xlib-xrender=no --enable-xlib-xcb=no --enable-qt=no --enable-quartz=no --enable-win32=no --enable-directfb=yes,,directfb"
SRC_URI = "http://cairographics.org/releases/cairo-${PV}.tar.gz "

#for cnxt hw limit
SRC_URI += "file://0001_patch_cairo_directfb_surface_c_for_cnxt_hw_limit.patch;apply=yes;striplevel=1 "

SRC_URI[md5sum] = "70a2ece66cf473d976e2db0f75bf199e"
SRC_URI[sha256sum] = "0f2ce4cc4615594088d74eb8b5360bad7c3cc3c3da9b61af9bfd979ed1ed94b2"

PACKAGES =+ "cairo-gobject cairo-script-interpreter cairo-perf-utils"

SUMMARY_${PN} = "The Cairo 2D vector graphics library"
DESCRIPTION_${PN} = "Cairo is a multi-platform library providing anti-aliased \
vector-based rendering for multiple target backends. Paths consist \
of line segments and cubic splines and can be rendered at any width \
with various join and cap styles. All colors may be specified with \
optional translucence (opacity/alpha) and combined using the \
extended Porter/Duff compositing algebra as found in the X Render \
Extension."

SUMMARY_cairo-gobject = "The Cairo library GObject wrapper library"
DESCRIPTION_cairo-gobject = "A GObject wrapper library for the Cairo API."

SUMMARY_cairo-script-interpreter = "The Cairo library script interpreter"
DESCRIPTION_cairo-script-interpreter = "The Cairo script interpreter implements \
CairoScript.  CairoScript is used by tracing utilities to enable the ability \
to replay rendering."

DESCRIPTION_cairo-perf-utils = "The Cairo library performance utilities"

FILES_${PN} = "${libdir}/libcairo.so.*"
FILES_${PN}-dev += "${libdir}/cairo/*.la ${libdir}/cairo/*.so"
#FILES_${PN}-dbg += "${libdir}/cairo/.debug"
#FILES_${PN}-staticdev += "${libdir}/cairo/*.a"
FILES_cairo-gobject = "${libdir}/libcairo-gobject.so.*"
FILES_cairo-script-interpreter = "${libdir}/libcairo-script-interpreter.so.*"
FILES_cairo-perf-utils = "${bindir}/cairo-trace ${libdir}/cairo/libcairo-trace.so.*"

do_install_append () {
	rm -rf ${D}${bindir}/cairo-sphinx
	rm -rf ${D}${libdir}/cairo/cairo-fdr*
	rm -rf ${D}${libdir}/cairo/cairo-sphinx*
	rm -rf ${D}${libdir}/cairo/.debug/cairo-fdr*
	rm -rf ${D}${libdir}/cairo/.debug/cairo-sphinx*
}
