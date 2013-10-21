DESCRIPTION = "Hardware header file for ELMO u-boot"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

PR="1.0_20131021"


SRC_URI += "file://u-boot-hw-header.tar.gz \
		"

S = "${WORKDIR}"

do_configure() {
}
do_compile() {
}
do_install() {
}

sysroot_stage_all() {
        sysroot_stage_dir ${WORKDIR}/inc ${STAGING_INCDIR}/inc
        sysroot_stage_dir ${WORKDIR}/cfgtoh ${STAGING_INCDIR}/cfgtoh
        #install -d ${STAGING_INCDIR}
	#cp ${WORKDIR}/inc ${STAGING_INCDIR} -a
	#cp ${WORKDIR}/cfgtoh ${STAGING_INCDIR} -a
}

do_package_qa() {
}

#HACK! These are binaries, so we can't guarantee that LDFLAGS match :(
INSANE_SKIP_${PN} = "ldflags dev-so" 

SRC_URI[md5sum] = "ba4a7002b9efb1f9ff36dfcbbffd5d50"
SRC_URI[sha256sum] = "5a5daf8c38739e783fb6af0666c821f6f6c888f1e6157fc2733173e1c14e0183"

#PACKAGE_ARCH := "${MACHINE_ARCH}"
PACKAGE := "${PN} ${PN}-dbg "
FILES_${PN} = "/ "

