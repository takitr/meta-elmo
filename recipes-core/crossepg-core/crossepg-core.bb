DESCRIPTION = "CrossEPG Core"
LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

SRCDATE = "20140527"
PR = "r1"

INHIBIT_PACKAGE_STRIP = "1"

SRC_URI = "http://update.prismcube.com/Ruby/crossepg-core-${SRCDATE}.tar.gz"

S = "${WORKDIR}"

do_configure() {
}
do_compile() {
}
do_install() {
        install -d ${D}/usr
	cp ${WORKDIR}/usr/* ${D}/usr/ -a
}
do_package_qa() {
}

#HACK! These are binaries, so we can't guarantee that LDFLAGS match :(
INSANE_SKIP_${PN} = "ldflags dev-so" 

SRC_URI[md5sum] = "af5679fe3985b6eaebc1c368eb0b2dc3"
SRC_URI[sha256sum] = "f865d4f08128e3a958110221610623a5589d264d41e8df9fdd9f88fd85611cff"

PACKAGE := "${PN}"
FILES_${PN} = "/ "

