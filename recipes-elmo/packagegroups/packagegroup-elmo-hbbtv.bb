DESCRIPTION = "Task for Marusys WEBKIT "
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit packagegroup

RPROVIDES_${PN} += "packagegroup-elmo-webkit"

RDEPENDS_${PN} = "	\
	pango-modules \
	mime-support \
	webkit-gtk \
	webkit-gtk-launcher \
	hbbtv \
	glib-networking \
	libproxy \
	"
