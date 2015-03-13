DESCRIPTION = "script.mbox addon for Ruby"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"
DEPENDS = "gotham"
COMPATIBLE_MACHINE = "(elmo)"

RV = "2.1.8"
PR = "r26"
TAG = "78b7e50701093b0f7b9b9e6ae3c45df0a17c1041"
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
