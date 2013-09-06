DESCRIPTION = "script.mbox addon for Ruby"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"
RDEPENDS_${PN} = "netbase connman maruapp elmo-dvb-modules"
inherit pkgconfig
COMPATIBLE_MACHINE = "(elmo)"

PR = "r1"

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
	if [ -f /app/run.elmo.sh.legacy ];then 
		mv /app/run.elmo.sh.legacy /app/run.elmo.sh
	fi
	if [ -f /lib/systemd/system/connman.service.legacy ];then
		mv /lib/systemd/system/connman.service.legacy /lib/systemd/system/connman.service
	fi
	if [ -f /etc/network/interfaces.legacy ];then
		mv /etc/network/interfaces.legacy /etc/network/interfaces
	fi
	if [ -f /app/setMac.sh.legacy ];then
		mv /app/setMac.sh.legacy /app/setMac.sh
	fi
}

PACKAGES = "${PN} "
FILES_${PN} = "/*"
