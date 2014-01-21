DESCRIPTION = "Task for extra drivers for Elmo ( Ruby ) development version"
THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATH =. "${@base_set_filespath(["${THISDIR}/${PN}"], d)}:"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit packagegroup

RPROVIDES_${PN} += "packagegroup-elmo-drivers-test"

RDEPENDS_${PN} = "\
	apollo-sgx-modules \
	libgles-apollo \
	elmo-dvb-test \
	kernel-vmlinux \
	kernel-module-dvb-core \
	kernel-module-usbserial \
	kernel-module-ftdi-sio \
	kernel-module-pl2303 \
        libexif \
        util-linux-sfdisk \
        e2fsprogs-mke2fs \
        hdparm \
        vsftpd \
	"

RRECOMMENDS_${PN} = "\
	\
	"


