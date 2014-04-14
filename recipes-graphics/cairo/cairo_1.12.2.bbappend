PRINC = "2"

THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATH =. "${@base_set_filespath(["${THISDIR}/${PN}"], d)}:"

PACKAGECONFIG[gtk-directfb] = "--enable-xlib=no --enable-xcb=no --enable-xlib-xrender=no --enable-xlib-xcb=no --enable-qt=no --enable-quartz=no --enable-win32=no --enable-directfb=yes,,directfb"

FILES_${PN} += " ${libdir}/pkgconfig/* "
FILES_${PN} += " ${STAGING_LIBDIR}/* "

do_install_append () {
	install -d ${D}/${STAGING_LIBDIR}/
	cp ${D}/$libdir/* ${D}/${STAGING_LIBDIR}/ | true

}
