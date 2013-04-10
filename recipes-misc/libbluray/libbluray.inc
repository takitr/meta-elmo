DESCRIPTION = "libbluray for oe."
SECTION = "misc"
HOMEPAGE = "http://videolan.org"
DEPENDS = ""
LICENSE = "GPLv2"
INC_PR = "r4"
S="${WORKDIR}/git"
SRC_URI = "git://git.videolan.org/libbluray.git;branch=master;protocol=git \
		"

inherit autotools


PACKAGES += "${PN}"

FILES_${PN} = "/"
