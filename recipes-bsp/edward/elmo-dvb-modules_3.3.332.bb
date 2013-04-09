DESCRIPTION = "Hardware drivers for ELMO"
#SECTION = "base"
#PRIORITY = "required"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

#def get_modules_extension(bb, d):
#	if bb.data.getVar('GLIBC_ADDONS', d, 1) in ['nptl']:
#		return "-gcc4.4"
#	return ""

KV = "2.6.37"


PV = "3.3.0"

SRCDATE = "20130408"


#RDEPENDS = "kernel"
PR = "SDK.GA330.${SRCDATE}"


SRC_URI = "http://192.168.103.100/download/drivers/elmo/elmo-dualhd-gcc-4.4.2_glibc-linux-debug-${PR}.tar.gz "
SRC_URI += "file://S10_stb_sys_startup.sh \
	    file://S15_stb_dev_node.sh \
	    file://S50_stb_load_app.sh \
	    file://lircd.conf \
	    file://cnxt.service \
	    file://entropic.target \
	    file://cnxt_init \
		"

S = "${WORKDIR}"

do_configure() {
}
do_compile() {
}
do_install() {
        install -d ${D}/opt
	cp ${WORKDIR}/opt/* ${D}/opt/ -av 
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/S*_stb_*.sh ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/cnxt_init ${D}${sysconfdir}/init.d/
	install -d ${D}${sysconfdir}/rcS.d
	#cd ${D}${sysconfdir}/rcS.d	
	#ln -sf ../init.d/S10_stb_sys_startup.sh S52stb1
	#ln -sf ../init.d/S15_stb_dev_node.sh S52stb2
	#ln -sf ../init.d/S50_stb_load_app.sh S52stb3
	touch ${WORKDIR}/opt/.appfs
	install -d ${D}/app/
	install -m 0755 ${WORKDIR}/lircd.conf ${D}${sysconfdir}/
	install -d ${D}/lib
	install -d ${D}/lib/firmware
	cd ${D}/lib/firmware
	ln -sf /opt/lib/firmware/apollo_vfw.bin apollo_vfw.bin
	ln -sf /opt/lib/firmware/tmasAFWFramework.mi tmasAFWFramework.mi
	install -d ${D}/lib/systemd/system/entropic.target.wants
	install -d ${D}/lib/systemd/system/basic.target.wants
	cp ${WORKDIR}/cnxt.service ${D}/lib/systemd/system/
	cp ${WORKDIR}/entropic.target ${D}/lib/systemd/system/
	cd ${D}/lib/systemd/system/entropic.target.wants
	ln -sf /lib/systemd/system/cnxt.service cnxt.service
	cd ${D}/lib/systemd/system/basic.target.wants
	ln -sf /lib/systemd/system/cnxt.service cnxt.service
}
do_package_qa() {
}

#HACK! These are binaries, so we can't guarantee that LDFLAGS match :(
INSANE_SKIP_${PN} = "ldflags dev-so" 

SRC_URI[md5sum] = "70a77d42c51605bab424330df3869526"
SRC_URI[sha256sum] = "bc9cd18406ca89ee034bb161d9dbb242a16c9b28396e2af68e1626a26fa70d0a"

#PACKAGE_ARCH := "${MACHINE_ARCH}"
PACKAGE := "${PN} ${PN}-dbg "
FILES_${PN} = "/ "
FILES_${PN} += "/opt/.appfs "

