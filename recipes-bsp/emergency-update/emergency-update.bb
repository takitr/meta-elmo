DESCRIPTION = "Emergency update using usb memory for ELMO"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

COMPATIBLE_MACHINE = "(elmo)"
DEPENDS = "u-boot-mkimage"
SRCDATE = "20130802"

SRC_URI = "http://update.prismcube.com/Ruby/emergency-update-${SRCDATE}.tar.gz \
          "

S = "${WORKDIR}"

do_install() {
	install -d ${D}/boot
	cp ${WORKDIR}/update_ruby ${D}/boot/ -a
}

SRC_URI[md5sum] = "06c2a295612b05cb2a1f1fb60a6c3a2c"
SRC_URI[sha256sum] = "9695ed642115fd19619e09c6a32f7b5ab93a5849bb07937c4930332dec54c816"

FILES_${PN} = "/boot"
