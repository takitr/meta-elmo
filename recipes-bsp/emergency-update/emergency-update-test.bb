DESCRIPTION = "Emergency update using usb memory for ELMO"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

DEPENDS = "u-boot-mkimage-native u-boot-native"

COMPATIBLE_MACHINE = "(elmo)"
SRCDATE = "20140305"
PR="r11"

SRC_URI = "http://update.prismcube.com/Ruby/emergency-update-${SRCDATE}.tar.gz \
	   file://update-command.sh \
          "

S = "${WORKDIR}"

do_install() {
	install -d ${D}/boot
	cp ${WORKDIR}/update_ruby ${D}/boot/ -a
	cp ${WORKDIR}/update-command.sh ${D}/boot/
}

SRC_URI[md5sum] = "e9b8a1ff9d540ede8c3f3373f9343e33"
SRC_URI[sha256sum] = "80b353da8c34eeaf3c91085c3cba8f12c82e7df7c79064658d03b9925caf967c"

FILES_${PN} = "/boot"

