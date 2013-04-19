DESCRIPTION = "Kernel drivers for the PowerVR SGX chipset found in the Apollo"
LICENSE = "proprietary"

# download required binary distribution from:
# http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/latest/index_FDS.html
# see libgles-omap3.inc for detailed installation instructions

IMGPV = "1.9.2291151"

inherit module

INHIBIT_PACKAGE_STRIP = "1"

LIC_FILES_CHKSUM = "file://apollo_sgx_license_1.9.2291151.txt;md5=dae9aa9e7cab424074752142fbedbe43"
#MACHINE_KERNEL_PR_append = "i"

SRC_URI = "http://update.prismcube.com/Ruby/apollo.sgx.modules_1.9.2291151.tar.gz	\
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
        cp ${S}/lib/modules/${KERNEL_VERSION}/extra/* ${D}/lib/modules/${KERNEL_VERSION}/extra/
}

FILES_${PN} = "/*"
