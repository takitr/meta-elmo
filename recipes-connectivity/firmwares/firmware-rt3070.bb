require linux-firmware.inc
LICENSE = "Unknown"
LIC_FILES_CHKSUM = "file://Marvell-Licence.txt;md5=4725db20ee6d3466bfc15f27076df560"
SRCREV = "46c66487a85cd05a4acbd5eb4828f72783d1be4c"

do_install() {
        install -d ${D}${base_libdir}/firmware
        install -m 0644 rt2870.bin ${D}/${base_libdir}/firmware/
        install -m 0644 rt3070.bin ${D}/${base_libdir}/firmware/
}

