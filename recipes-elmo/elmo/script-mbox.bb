DESCRIPTION = "script.mbox addon for Ruby"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"
DEPENDS = "xbmc"
COMPATIBLE_MACHINE = "(elmo)"

KV = "2.6.34"

PV = "${KV}"

SRCDATE = "20130408"

PR = "${SRCDATE}"

SRC_URI = "http://192.168.103.100/download/addons/script.mbox-${SRCDATE}.tar.gz \
          "

S = "${WORKDIR}"
do_configure() {
}
do_compile() {
}

do_install() {
	install -d ${D}/usr/share/xbmc/addons/
	cp ${WORKDIR}/script.mbox ${D}/usr/share/xbmc/addons/ -av 
}

do_package_qa() {
}


SRC_URI[md5sum] = "21c9f12e9cf4b8df95707957bd52818d"
PACKAGES = "${PN} ${PN}-dbg "
FILES_${PN} = "/usr/*"
FILES_${PN}-dbg = "/usr/*"
