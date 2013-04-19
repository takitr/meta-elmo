DESCRIPTION = "driver for Realtek USB wireless devices"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit module 

SRC_URI = " \
	file://rtl8192_8188CU_linux_v3.1.2590.20110922.tar.gz \
	file://makefile.patch;patch=1 \
	file://linux_3.1.patch;patch=1 \
"	

S = "${WORKDIR}/rtl8192_8188CU_linux_v${PV}"

PR = "r0"

do_compile () {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS CC LD CPP
        oe_runmake ${MODULE_MAKE_FLAGS}
}

do_install() {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
	install -m 0644 ${S}/8192cu.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
}

MODULE_MAKE_FLAGS += " \
	CROSS_COMPILE=${TARGET_PREFIX} \
	KVER=${KERNEL_VERSION} \
	KSRC=${STAGING_KERNEL_DIR} \
	KDIR=${STAGING_KERNEL_DIR} \
"

