DESCRIPTION = "Kernel drivers for the PowerVR SGX chipset found in the Apollo"
LICENSE = "proprietary"

# download required binary distribution from:
# http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/latest/index_FDS.html
# see libgles-omap3.inc for detailed installation instructions

IMGPV = "1.1.16.3977"

inherit module
LIC_FILES_CHKSUM = "file://apollo_sgx_license.txt;md5=6eda5903bc02b275a1ae5ab76c1eeadf"
#MACHINE_KERNEL_PR_append = "i"

SRC_URI = "file://apollo.sgx.modules.tar.gz	\
	   file://apollo_sgx_license.txt \
          "

S = "${WORKDIR}/2.6.34"

PVRBUILD = "release"

PACKAGE_STRIP = "no"

do_configure() {
}

do_compile() {
}

do_install() {
	mkdir -p ${D}/lib/modules/${KERNEL_VERSION}/extra
	cp ${S}/extra/pvrsrvkm.ko ${D}/lib/modules/${KERNEL_VERSION}/extra/
	cp ${S}/extra/pvrnxpdc.ko ${D}/lib/modules/${KERNEL_VERSION}/extra/
	cp ${S}/extra/pvrvssbc.ko  ${D}/lib/modules/${KERNEL_VERSION}/extra/
}
