DESCRIPTION = "Emergency update using usb memory for ELMO"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

COMPATIBLE_MACHINE = "(elmo)"
DEPENDS = "u-boot-mkimage"
SRCDATE = "20130415"

SRC_URI = "http://update.prismcube.com/Ruby/emergency-update-${SRCDATE}.tar.gz \
          "

S = "${WORKDIR}"

do_install() {
	install -d ${D}/boot
	cp ${WORKDIR}/update_ruby ${D}/boot/ -a
}


SRC_URI[md5sum] = "6a952bda04bdbff59915a6dbc823a366"
SRC_URI[sha256sum] = "f68efdcf9ed4a2c7bdf44dae1ee9be657ceccef4ec8ffef76e5d8172ea12f342"

FILES_${PN} = "/boot"
