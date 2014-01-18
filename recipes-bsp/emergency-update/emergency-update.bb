DESCRIPTION = "Emergency update using usb memory for ELMO"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

DEPENDS = "u-boot-mkimage-native u-boot-native"
COMPATIBLE_MACHINE = "(elmo)"
SRCDATE = "20140117"
PR="r10"

SRC_URI = "http://update.prismcube.com/Ruby/emergency-update-${SRCDATE}.tar.gz \
	   file://update-command.sh \
          "

S = "${WORKDIR}"

do_install() {
	install -d ${D}/boot
	cp ${WORKDIR}/update_ruby ${D}/boot/ -a
	cp ${WORKDIR}/update-command.sh ${D}/boot/
}

SRC_URI[md5sum] = "63939fa39655a32a870430d287437b03"
SRC_URI[sha256sum] = "0c269f819697ac27753c4df6e026272af393c0f8e3fb0ac22e2189b01e1a3b00"

FILES_${PN} = "/boot"
