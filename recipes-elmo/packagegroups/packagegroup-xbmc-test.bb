DESCRIPTION = "Task for XBMC test version"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

PR = "r0"

inherit packagegroup

# for backwards compatibility
DEPEND_${PN} += "packagegroup-xbmc-base-test packagegroup-gconv-list"
RPROVIDES_${PN} += "packagegroup-xbmc-test"

RDEPENDS_${PN} = " \
	packagegroup-xbmc-base-test \
	packagegroup-gconv-list \
	gotham \
	script-mbox-test \
	script-module-elisinterface-test \
	script-module-elementtree \
	script-module-beatifulsoup \
	script-crossepg \
	crossepg-core \
"
