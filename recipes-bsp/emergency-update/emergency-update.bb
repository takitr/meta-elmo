DESCRIPTION = "Emergency update using usb memory for ELMO"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

COMPATIBLE_MACHINE = "(elmo)"
DEPENDS = "u-boot-mkimage"
SRCDATE = "20130906"

SRC_URI = "http://update.prismcube.com/Ruby/emergency-update-${SRCDATE}.tar.gz \
          "

S = "${WORKDIR}"

do_install() {
	install -d ${D}/boot
	cp ${WORKDIR}/update_ruby ${D}/boot/ -a
}

SRC_URI[md5sum] = "ec2b85cc1203f3e4aac99faf55741934"
SRC_URI[sha256sum] = "c226bb7a1c1ed203ed181e6db898b23a92e643b845cab10fd409dae354c14b65"

FILES_${PN} = "/boot"
