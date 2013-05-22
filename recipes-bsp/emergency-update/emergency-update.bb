DESCRIPTION = "Emergency update using usb memory for ELMO"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

COMPATIBLE_MACHINE = "(elmo)"
DEPENDS = "u-boot-mkimage"
SRCDATE = "20130519"

SRC_URI = "http://update.prismcube.com/Ruby/emergency-update-${SRCDATE}.tar.gz \
          "

S = "${WORKDIR}"

do_install() {
	install -d ${D}/boot
	cp ${WORKDIR}/update_ruby ${D}/boot/ -a
}


SRC_URI[md5sum] = "6e5960b43437df5d430447fdd7796454"
SRC_URI[sha256sum] = "0dee045092eb91c10eb6cf342e7e3a1706dc88c34d1552d31b3f3161f513ecb0"

FILES_${PN} = "/boot"
