DESCRIPTION = "Emergency update using usb memory for ELMO"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

DEPENDS = "u-boot-mkimage-native u-boot-native"

COMPATIBLE_MACHINE = "(elmo)"
SRCDATE = "20140123"
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

SRC_URI[md5sum] = "204d06a336356d2717045ca38c9ae4ce"
SRC_URI[sha256sum] = "90bce995ac90beeec4dc6a150f7a4334286584a235cb053036581fe9302d82f6"

FILES_${PN} = "/boot"

