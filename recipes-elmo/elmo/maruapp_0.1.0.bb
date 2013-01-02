DESCRIPTION = "Marusys M/W Application for ELMO"
#SECTION = "base"
#PRIORITY = "required"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

PV = "0.5.0"

SRCDATE = "20121207"


PR = "${PV}-${SRCDATE}"


SRC_URI = "http://192.168.103.200/download/app/elmo/elmo-maruapp-${PR}.tar.gz "
SRC_URI += "file://runstb.sh \
	    file://defaultchannel.xml \
	    file://checkswap \
	    file://none.html \
	    file://maruapp.service \
	    file://icons.tar.gz	\
	"

S = "${WORKDIR}"

do_install() {
        install -d ${D}/app
        install -d ${D}/app/tmp
	cp ${WORKDIR}/release/* ${D}/app/ -av 
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/runstb.sh ${D}${sysconfdir}/init.d/
	#install -d ${D}${sysconfdir}/rc5.d
	#cd ${D}${sysconfdir}/rc5.d
	#ln -s ../init.d/runstb.sh S40runstb
	install -d ${D}/lib/systemd/system/basic.target.wants
	cp ${WORKDIR}/maruapp.service  ${D}/lib/systemd/system/
	cd ${D}/lib/systemd/system/basic.target.wants
	ln -sf /lib/systemd/system/maruapp.service maruapp.service

	install -m 0755 ${WORKDIR}/defaultchannel.xml ${D}/app/
	install -m 0777 ${WORKDIR}/checkswap ${D}/app/
	install -m 0777 ${WORKDIR}/none.html ${D}/app/tmp/
	install -d ${D}/config
	install -d ${D}/devel
	install -d ${D}/devel2
	install -d ${D}/var/CI
	install -d ${D}/home/root/
	cp ${WORKDIR}/icons  ${D}/home/root/ -a
	

}

do_package_qa() {
}
#HACK! These are binaries, so we can't guarantee that LDFLAGS match :(
INSANE_SKIP_${PN} = "ldflags"

SRC_URI[md5sum] = "0d12917309567a5d2731f1f552401ebd"
SRC_URI[sha256sum] = "066ff17480a53c46bc8c163dba98c6d559852cb6d5664e7badc658f0d8239a7c"

PACKAGE_ARCH := "${MACHINE_ARCH}"
PACKAGE := "${PN} ${PN}-dbg "
FILES_${PN} = "/ "
