require linux-firmware.inc
LICENSE = "Unknown"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"
SRCREV = "46c66487a85cd05a4acbd5eb4828f72783d1be4c"

do_install() {
        install -d ${D}${base_libdir}/firmware
        install -m 0644 rt2561.bin ${D}/${base_libdir}/firmware/
}
