DESCRIPTION = "Task for Marusys DVB M/W ( Ruby )"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit packagegroup

RPROVIDES_${PN} += "packagegroup-elmo-maruapp"

RDEPENDS_${PN} = "\
	maruapp \
	libexif \
	util-linux-sfdisk \
	e2fsprogs-mke2fs \
	hdparm \
	"
