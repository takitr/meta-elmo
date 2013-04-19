DESCRIPTION = "driver for Realtek USB wireless devices"
SECTION = "kernel/modules"
LICENSE = "GPLv2"

inherit module 

SRC_URI = " \
	http://archive.vuplus.com/download/rtl8192CU_linux_v${PV}.tar.gz \
"	

SRC_URI_vuplus += "file://makefile.patch;patch=1;apply=yes "

S = "${WORKDIR}/rtl8192CU_linux_v${PV}"

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
SRC_URI[md5sum] = "3abad58740f7191d7f59f389ac28037f"
SRC_URI[sha256sum] = "e591af10b1408d8948ecf852bd58a5f2f90f730dfe2889c1b79df584c693371d"
