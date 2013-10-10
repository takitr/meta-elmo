DESCRIPTION = "Task for extra drivers for Elmo ( Ruby )"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit packagegroup

RPROVIDES_${PN} += "packagegroup-elmo-drivers"

RDEPENDS_${PN} = "\
	apollo-sgx-modules \
	libgles-apollo \
	elmo-dvb-modules \
	kernel-vmlinux \
	kernel-module-dvb-core \
	kernel-module-usbserial \
	kernel-module-ftdi-sio \
	kernel-module-pl2303 \
	"

RRECOMMENDS_${PN} = "\
	\
	"


