DESCRIPTION = "License for Marvel 8686 wifi chipsets"
LICENSE = "Unknown"
LIC_FILES_CHKSUM = "file://Marvell-Licence.txt;md5=4725db20ee6d3466bfc15f27076df560"
SRC_URI = "file://Marvell-Licence.txt"

RDEPENDS_${PN} += "marvell-license"

do_install() {

	install -d ${D}${base_libdir}/firmware
	install -m 0644 ${WORKDIR}/Marvell-Licence.txt ${D}${base_libdir}/firmware
}

PACKAGES = "${PN}"
FILES_${PN} += "${base_libdir}/firmware"

PACKAGE_ARCH = "all"
