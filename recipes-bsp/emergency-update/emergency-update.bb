DESCRIPTION = "Emergency update using usb memory for ELMO"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

COMPATIBLE_MACHINE = "(elmo)"
DEPENDS = "u-boot-mkimage-native"
SRCDATE = "20131008"

SRC_URI = "http://update.prismcube.com/Ruby/emergency-update-${SRCDATE}.tar.gz \
          "

S = "${WORKDIR}"

do_install() {
	install -d ${D}/boot
	cp ${WORKDIR}/update_ruby ${D}/boot/ -a
}

SRC_URI[md5sum] = "e074ee02822d31b7c6aa38381764a194"
SRC_URI[sha256sum] = "faa07df8083bd45e04c46527a3f08a0adc6610499dc207d22c7e0efd71fd3f3f"

FILES_${PN} = "/boot"
