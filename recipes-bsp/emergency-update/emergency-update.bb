DESCRIPTION = "Emergency update using usb memory for ELMO"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

COMPATIBLE_MACHINE = "(elmo)"
SRCDATE = "20131119"
PR="r4"

SRC_URI = "http://update.prismcube.com/Ruby/emergency-update-${SRCDATE}.tar.gz \
          "

S = "${WORKDIR}"

do_install() {
	install -d ${D}/boot
	cp ${WORKDIR}/update_ruby ${D}/boot/ -a
}

SRC_URI[md5sum] = "9b2b26925461445daddf2a837784893e"
SRC_URI[sha256sum] = "5bae8beb5cc7775ad9cfc509ee2bb1972f8e9fb739681d237c1db643fa62bc71"

FILES_${PN} = "/boot"
