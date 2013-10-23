DESCRIPTION = "Emergency update using usb memory for ELMO"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

COMPATIBLE_MACHINE = "(elmo)"
SRCDATE = "20131023"
PR="r1"

SRC_URI = "http://update.prismcube.com/Ruby/emergency-update-${SRCDATE}.tar.gz \
          "

S = "${WORKDIR}"

do_install() {
	install -d ${D}/boot
	cp ${WORKDIR}/update_ruby ${D}/boot/ -a
}

SRC_URI[md5sum] = "58882df5518d2e201bcd0465fd7cf2a5"
SRC_URI[sha256sum] = "4a3c7769ec1144a7aa5cb1024ac87081e434a17a8a0cbd02c5777254306be79e"

FILES_${PN} = "/boot"
