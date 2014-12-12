DESCRIPTION = "script.crossepg addon for Ruby"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"
RDEPENDS = "crossepg-core"

COMPATIBLE_MACHINE = "(elmo)"

PR = "r8"
TAG = "2faad61ba1e60a4fe42d74dedd6df47d945c5beb"
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
