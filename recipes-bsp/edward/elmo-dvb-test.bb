DESCRIPTION = "Hardware drivers and M/W for ELMO"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

PV = "1.7.0"
SRCDATE = "20140415"
PR = "r20"

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

}
do_package_qa() {
}

#HACK! These are binaries, so we can't guarantee that LDFLAGS match :(
INSANE_SKIP_${PN} = "ldflags dev-so" 

SRC_URI[md5sum] = "2a480eba55bd6ff3dd6fb604c1ce4f9d"
SRC_URI[sha256sum] = "3f40915c82126dd59967d638b9ac131241925d9bbe9aa5731445797a0314c15f"

PACKAGE_ARCH := "${MACHINE_ARCH}"
PACKAGE := "${PN} ${PN}-dbg "
FILES_${PN} = "/ "
FILES_${PN} += "/opt/.appfs "

