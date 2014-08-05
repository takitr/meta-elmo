DESCRIPTION = "script.crossepg addon for Ruby"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"
RDEPENDS = "crossepg-core"

COMPATIBLE_MACHINE = "(elmo)"

PR = "r7"
TAG = "f9a76ef06b1e9247f2a762ed2eada365ff8aad06"
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
