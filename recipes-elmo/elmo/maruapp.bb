DESCRIPTION = "Marusys M/W Application for ELMO"

LICENSE = "proprietary"

LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

PV = "1.0.0.beta8"

SRCDATE = "20130414"


SRC_URI = "http://update.prismcube.com/Ruby/elmo-maruapp-${PV}-${SRCDATE}.tar.gz "
SRC_URI += "file://runstb.sh \
	    file://defaultchannel.xml \
	    file://checkswap \
	    file://none.html \
	    file://icons.tar.gz	\
	    file://upnp_xml.tar.gz \
	"

S = "${WORKDIR}"

do_install() {
        install -d ${D}/app
        install -d ${D}/app/tmp
	cp ${WORKDIR}/release/* ${D}/app/ -av 
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/runstb.sh ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/defaultchannel.xml ${D}/app/
	install -m 0777 ${WORKDIR}/checkswap ${D}/app/
	install -m 0777 ${WORKDIR}/none.html ${D}/app/tmp/
	install -d ${D}/config
	install -d ${D}/devel
	install -d ${D}/var/CI
	install -d ${D}/home/root/
	cp ${WORKDIR}/icons  ${D}/home/root/ -a
	install -d ${D}/usr/local
	cp ${WORKDIR}/share ${D}/usr/local -a

}

do_package_qa() {
}
#HACK! These are binaries, so we can't guarantee that LDFLAGS match :(
INSANE_SKIP_${PN} = "ldflags"

SRC_URI[md5sum] = "58f2d4bff61e45d21a935c68aff0fdb1"
SRC_URI[sha256sum] = "b19768e435e020028a7ead8f3ac6a59ab44a1fc251ebebeef8f6ff92b995cb3c"

PACKAGE_ARCH := "${MACHINE_ARCH}"
PACKAGE := "${PN} ${PN}-dbg "
FILES_${PN} = "/ "
