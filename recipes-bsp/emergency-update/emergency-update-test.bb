DESCRIPTION = "Emergency update using usb memory for ELMO"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

DEPENDS = "u-boot-mkimage-native u-boot-native"

COMPATIBLE_MACHINE = "(elmo)"
SRCDATE = "20131222"
PR="r8"

SRC_URI = "http://update.prismcube.com/Ruby/emergency-update-${SRCDATE}.tar.gz \
	   file://update-command.sh \
          "

S = "${WORKDIR}"

do_install() {
	install -d ${D}/boot
	cp ${WORKDIR}/update_ruby ${D}/boot/ -a
	cp ${WORKDIR}/update-command.sh ${D}/boot/
}

SRC_URI[md5sum] = "2f92eedb690c55d3fdf723b1b2f62639"
SRC_URI[sha256sum] = "6877df6e57bebc67b64bddbb5b80af9685e1c63bd16a02cded14d95a147ab155"

FILES_${PN} = "/boot"
