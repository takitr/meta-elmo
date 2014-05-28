DESCRIPTION = "script.crossepg addon for Ruby"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"
DEPENDS = "crossepg-core"
COMPATIBLE_MACHINE = "(elmo)"

PR = "r2"
TAG = "3df0cd80ec7715e654eedf46aeed69cb9ba054a1"
SRC_URI = "git://update.prismcube.com/script.crossepg.git;protocol=git;tag=${TAG} \
          "

S = "${WORKDIR}/git"

do_configure() {
}

do_compile() {
}

do_install() {
	install -d ${D}/usr/share/xbmc/addons/
	rm ${S}/.git -rf
	cp ${S} ${D}/usr/share/xbmc/addons/script.crossepg -a
}

do_package_qa() {
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
PACKAGES = "${PN}"
FILES_${PN} = "/usr/*"
