DESCRIPTION = "Hardware drivers and M/W for ELMO"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

PV = "2.0.5"
SRCDATE = "20150515"
PR = "r41"

INHIBIT_PACKAGE_STRIP = "1"

SRC_URI = "http://update.prismcube.com/Ruby/elmo-dvb-${PV}.${SRCDATE}.tar.gz"
SRC_URI += "file://S10_stb_sys_startup.sh \
	    file://S15_stb_dev_node.sh \
	    file://S50_stb_load_app.sh \
	    file://lircd.conf \
	    file://cnxt.service \
	    file://cnxt_init \
	    file://runstb.sh \
            file://defaultchannel.xml \
            file://check_script.sh \
            file://checkswap \
            file://none.html \
            file://icons.tar.gz \
            file://upnp_xml.tar.gz \
            file://release.info.${PV} \
            file://maruapp.service \
	    file://check_pyo \
	    "

S = "${WORKDIR}"

do_configure() {
}
do_compile() {
}
do_install() {
        install -d ${D}/opt
	cp ${WORKDIR}/opt/* ${D}/opt/ -a
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/S*_stb_*.sh ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/cnxt_init ${D}${sysconfdir}/init.d/
	install -d ${D}${sysconfdir}/rcS.d
	touch ${WORKDIR}/opt/.appfs
	install -d ${D}/app/
	install -m 0755 ${WORKDIR}/lircd.conf ${D}${sysconfdir}/
	install -d ${D}/lib
	install -d ${D}/lib/firmware
	cd ${D}/lib/firmware
	ln -sf /opt/lib/firmware/apollo_vfw.bin apollo_vfw.bin
	ln -sf /opt/lib/firmware/tmasAFWFramework.mi tmasAFWFramework.mi
	install -d ${D}/lib/systemd/system/basic.target.wants
	cp ${WORKDIR}/cnxt.service ${D}/lib/systemd/system/
	cd ${D}/lib/systemd/system/basic.target.wants
	ln -sf /lib/systemd/system/cnxt.service cnxt.service

        install -d ${D}/app
        install -d ${D}/app/tmp
        cp ${WORKDIR}/release/* ${D}/app/ -a
        install -d ${D}${sysconfdir}/init.d
        install -m 0755 ${WORKDIR}/runstb.sh ${D}${sysconfdir}/init.d/
        install -m 0755 ${WORKDIR}/defaultchannel.xml ${D}/app/
        install -m 0777 ${WORKDIR}/checkswap ${D}/app/
        install -m 0777 ${WORKDIR}/none.html ${D}/app/tmp/
        install -m 0777 ${WORKDIR}/check_script.sh ${D}/app/
        install -d ${D}/config
        install -d ${D}/devel
        install -d ${D}/var/CI
        install -d ${D}/home/root/
        cp ${WORKDIR}/icons  ${D}/home/root/ -a
        install -d ${D}/usr/local
        cp ${WORKDIR}/share ${D}/usr/local -a
        install -m 0755 ${WORKDIR}/release.info.${PV} ${D}${sysconfdir}/release.info
        install -d ${D}/lib/systemd/system/multi-user.target.wants
        cp ${WORKDIR}/maruapp.service ${D}/lib/systemd/system/
        cd ${D}/lib/systemd/system/multi-user.target.wants
        ln -sf /lib/systemd/system/maruapp.service maruapp.service
        install -d ${D}/webkit/usr/lib/
        install -m 0777 ${WORKDIR}/release/libhtml5_video.so ${D}/webkit/usr/lib/
}
do_package_qa() {
}

#HACK! These are binaries, so we can't guarantee that LDFLAGS match :(
INSANE_SKIP_${PN} = "ldflags dev-so" 

SRC_URI[md5sum] = "a53a16d0b4bd1088513e2f2112aa0b24"
SRC_URI[sha256sum] = "41eb3da461070a4f05c1edb2699b067cfa524ec26807c727be4e7f39dea617bd"

PACKAGE_ARCH := "${MACHINE_ARCH}"
PACKAGE := "${PN} ${PN}-dbg "
FILES_${PN} = "/ "
FILES_${PN} += "/opt/.appfs "

