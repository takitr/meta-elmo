DESCRIPTION = "Emergency update using usb memory for ELMO"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

DEPENDS = "u-boot-mkimage-native"
COMPATIBLE_MACHINE = "(elmo)"
SRCDATE = "20131213"
PR="r6"

SRC_URI = "http://update.prismcube.com/Ruby/emergency-update-${SRCDATE}.tar.gz \
          "

S = "${WORKDIR}"

do_install() {
	install -d ${D}/boot
	cp ${WORKDIR}/update_ruby ${D}/boot/ -a
}

SRC_URI[md5sum] = "9d0560e26f1ce546f0123f7a339ce1ba"
SRC_URI[sha256sum] = "ed9267db94038ae23bd6f6d70f47a2deb07c117e1c6e5d9edd9ac61a35dd32b0"

FILES_${PN} = "/boot"
