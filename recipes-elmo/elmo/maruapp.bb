DESCRIPTION = "Marusys M/W Application for ELMO"

LICENSE = "proprietary"

LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

PV = "1.1.10"

SRCDATE = "20130830"


SRC_URI = "http://update.prismcube.com/Ruby/elmo-maruapp-${PV}-${SRCDATE}.tar.gz "
SRC_URI += "file://runstb.sh \
	    file://defaultchannel.xml \
	    file://check_script.sh \
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
	install -d ${D}/app/pre-maruapp
	install -d ${D}/app/post-maruapp
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

SRC_URI[md5sum] = "a2365597d121b144af171f57aa3d6836"
SRC_URI[sha256sum] = "30446d813305c2dce8397b4282ff0909574d8cc86410812bf380a5c51f4a7d21"

PACKAGE_ARCH := "${MACHINE_ARCH}"
PACKAGE := "${PN} ${PN}-dbg "
FILES_${PN} = "/ "
