DESCRIPTION = "Marusys M/W Application for ELMO"

LICENSE = "proprietary"

LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

PV = "1.1.13"
PR = "r2"
SRCDATE = "20130927"
INHIBIT_PACKAGE_STRIP = "1"

SRC_URI = "http://update.prismcube.com/Ruby/elmo-maruapp-${PV}-${SRCDATE}.tar.gz "
SRC_URI += "file://runstb.sh \
	    file://defaultchannel.xml \
	    file://check_script.sh \
	    file://checkswap \
	    file://none.html \
	    file://icons.tar.gz	\
	    file://upnp_xml.tar.gz \
	    file://release.info.${PV} \
	"

S = "${WORKDIR}"

do_install() {
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

}

do_package_qa() {
}
#HACK! These are binaries, so we can't guarantee that LDFLAGS match :(
INSANE_SKIP_${PN} = "ldflags"

SRC_URI[md5sum] = "0b58bcff669eca416a0eac3002c3da12"
SRC_URI[sha256sum] = "ef9fad43c67b71f37fdb0679bd63b94aa7e82e15615aac03650e840304e09949"


PACKAGE_ARCH := "${MACHINE_ARCH}"
PACKAGE := "${PN} ${PN}-dbg "
FILES_${PN} = "/ "
