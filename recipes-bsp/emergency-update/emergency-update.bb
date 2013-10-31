DESCRIPTION = "Emergency update using usb memory for ELMO"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

COMPATIBLE_MACHINE = "(elmo)"
SRCDATE = "20131101"
PR="r3"

SRC_URI = "http://update.prismcube.com/Ruby/emergency-update-${SRCDATE}.tar.gz \
          "

S = "${WORKDIR}"

do_install() {
	install -d ${D}/boot
	cp ${WORKDIR}/update_ruby ${D}/boot/ -a
}

SRC_URI[md5sum] = "506f381fbe0d99869bae26c827404ae4"
SRC_URI[sha256sum] = "41620005f0a6ef6d702ffaffd4111d3e4b792926839d8185cf12abf6a7722d36"

FILES_${PN} = "/boot"
