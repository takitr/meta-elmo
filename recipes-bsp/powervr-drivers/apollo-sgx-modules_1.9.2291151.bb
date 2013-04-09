DESCRIPTION = "Kernel drivers for the PowerVR SGX chipset found in the Apollo"
LICENSE = "GPLv2"

# download required binary distribution from:
# http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/latest/index_FDS.html
# see libgles-omap3.inc for detailed installation instructions

IMGPV = "1.9.2291151"

inherit module
LIC_FILES_CHKSUM = "file://apollo_sgx_license_1.9.2291151.txt;md5=dae9aa9e7cab424074752142fbedbe43"
#MACHINE_KERNEL_PR_append = "i"

SRC_URI = "file://apollo.sgx.modules_1.9.2291151.tar.gz	\
	   file://apollo_sgx_license_1.9.2291151.txt \
          "

S = "${WORKDIR}"

PVRBUILD = "release"

PACKAGE_STRIP = "no"

do_configure() {
}

do_compile() {
}

do_install() {
	mkdir -p ${D}/lib/modules/${KERNEL_VERSION}/extra
	cp ${S}/etc ${D}/etc -av
	cp ${S}/usr ${D}/usr -av
	cp ${S}/lib ${D}/lib -av
}
