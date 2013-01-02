DESCRIPTION = "Task for XBMC"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

PR = "r0"

inherit packagegroup

# for backwards compatibility
DEPEND_${PN} += "packagegroup-xbmc-base"
RPROVIDES_${PN} += "packagegroup-xbmc"

RDEPENDS_${PN} = " \
	packagegroup-xbmc-base \
	xbmc \
"
