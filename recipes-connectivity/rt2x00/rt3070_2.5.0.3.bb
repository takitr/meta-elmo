DESCRIPTION = "Driver for Ralink RT8070/RT3070/RT3370 USB 802.11abgn WiFi sticks"
SECTION = "kernel/modules"
LICENSE = "GPL"
SRCNAME = "rt3070"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit module

PR = "r0"

SRC_URI = "file://2011_0719_RT3070_RT3370_RT5370_RT5372_Linux_STA_V2.5.0.3_DPO.tar.bz2 \
		file://makefile_2.5.0.3.patch;apply=yes \
		file://config_2.5.0.3.patch;apply=yes \
	"

FILES_${PN} += " /lib/firmware/rt2870.bin"

S = "${WORKDIR}/2011_0719_RT3070_RT3370_RT5370_RT5372_Linux_STA_V${PV}_DPO"

EXTRA_OEMAKE = "LINUX_SRC=${STAGING_KERNEL_DIR}"

do_install() {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
	install -d ${D}${sysconfdir}/Wireless/RT2870STA
	install -m 0644 ${S}/*sta${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
	install -m 0644 ${S}/RT2870STA.dat ${D}${sysconfdir}/Wireless/RT2870STA/
  install -d ${D}/lib/firmware
  install -m 0644 ${S}/common/rt2870.bin ${D}/lib/firmware/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
