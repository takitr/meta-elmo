DESCRIPTION = "script.mbox addon for Ruby"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"
DEPENDS = "xbmc"
COMPATIBLE_MACHINE = "(elmo)"

RV = "1.6.1"
PR = "r14"
TAG = "5d5acb8a1d141711b83eafb542608eb6cd56dec3"
SRC_URI = "git://update.prismcube.com/script.module.elisinterface;protocol=git;tag=${TAG} \
          "

S = "${WORKDIR}/git"
do_configure() {
}
do_compile() {
}

do_install() {
        install -d ${D}/usr/share/xbmc/addons/
	rm ${S}/.git -rf
        cp ${S} ${D}/usr/share/xbmc/addons/script.module.elisinterface -a
}
do_package_qa() {
}


SRC_URI[md5sum] = "1aa60f28a6701edb967751fd2db53aa8"
PACKAGES = "${PN} ${PN}-dbg "
FILES_${PN} = "/usr/*"
FILES_${PN}-dbg = "/usr/*"
