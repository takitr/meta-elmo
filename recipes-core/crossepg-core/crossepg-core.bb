DESCRIPTION = "CrossEPG Core"
LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

SRCDATE = "20140611"
PR = "r2"

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

SRC_URI[md5sum] = "8aa5dfc3df0b8d529524932e12cb96c7"
SRC_URI[sha256sum] = "0d3ce4d8f5547fd27ec8fdc2a1d5403a5a181441db72ce9dfc127bc613400a62"

PACKAGE := "${PN}"
FILES_${PN} = "/ "

