DESCRIPTION = "script.mbox addon for Ruby"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"
RDEPENDS_${PN} = "netbase connman maruapp elmo-dvb-modules"
inherit pkgconfig
COMPATIBLE_MACHINE = "(elmo)"

SRC_URI = " file://iftest.sh \
	    file://run.elmo.sh.legacy \
	    file://connman.service.legacy \
	    file://interfaces.legacy \
	    file://setMac.sh.legacy \
          "
S = "${WORKDIR}"

do_configure() {
}

do_compile() {
}

do_install() {
	install -d ${D}/app
	install -d ${D}/lib/systemd/system/
	install -d ${D}/etc/network/
	cp ${WORKDIR}/iftest.sh ${D}/app/ -a
	cp ${WORKDIR}/run.elmo.sh.legacy ${D}/app/ -a
	cp ${WORKDIR}/connman.service.legacy ${D}/lib/systemd/system/ -a
	cp ${WORKDIR}/interfaces.legacy ${D}/etc/network/ -a
	cp ${WORKDIR}/setMac.sh.legacy ${D}/app/ -a
}

pkg_postinst(){
	mv /app/run.elmo.sh.legacy /app/run.elmo.sh
	mv /lib/systemd/system/connman.service.legacy /lib/systemd/system/connman.service
	mv /etc/network/interfaces.legacy /etc/network/interfaces
	mv /app/setMac.sh.legacy /app/setMac.sh
}

PACKAGES = "${PN} "
FILES_${PN} = "/*"
