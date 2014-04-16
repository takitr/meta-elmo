DESCRIPTION = "script.mbox addon for Ruby development version"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"
DEPENDS = "xbmc"
COMPATIBLE_MACHINE = "(elmo)"

RV = "1.7.0"
PR = "r20"
TAG = "05f54fae21c07943830cca9fa85b6e9d3123679f"
SRC_URI = "git://update.prismcube.com/script.mbox.git;protocol=git;tag=${TAG} \
          "

S = "${WORKDIR}/git"

do_configure() {
}

do_compile() {
}

do_install() {
	install -d ${D}/usr/share/xbmc/addons/
	rm ${S}/.git -rf
	cp ${S} ${D}/usr/share/xbmc/addons/script.mbox -a
	install -d ${D}/usr/share/xbmc/addons/skin.confluence/
	cp ${S}/confluence_texture_cache.xml ${D}/usr/share/xbmc/addons/skin.confluence/_texture_cache.xml -a
}

do_package_qa() {
}


SRC_URI[md5sum] = "21c9f12e9cf4b8df95707957bd52818d"
PACKAGES = "${PN} ${PN}-dbg "
FILES_${PN} = "/usr/*"
FILES_${PN}-dbg = "/usr/*"
