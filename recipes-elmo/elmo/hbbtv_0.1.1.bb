DESCRIPTION = "HBBTV Appication for Marusys"

LICENSE = "proprietary"

LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

PV = "0.1.1"
PR = "r1"
SRCDATE = "20140407"


#SRC_URI = "http://update.prismcube.com/Ruby/elmo-maruapp-${PV}-${SRCDATE}.tar.gz "
SRC_URI = " file://dfb2.sh \
		file://dfb.sh \
		file://directfbrc \
		file://GtkLauncher \
		file://run.hbbtv.sh \
		file://none.html \
		file://libhbbtvplugin.so \
		file://DirectFB-1.4.3_ruby.tar.gz \
	"
S = "${WORKDIR}"

do_install() {
	install -d ${D}/mnt/
	install -d ${D}/webkit/
        install -d ${D}/mnt/webkit/bin/
	install -m 0755 ${WORKDIR}/none.html ${D}/mnt/webkit/bin/
	install -d ${D}${sysconfdir}/
	install -m 0755 ${WORKDIR}/directfbrc ${D}${sysconfdir}/
	
	install -d ${D}/opt/bin/
	install -m 0755 ${WORKDIR}/run.hbbtv.sh ${D}/opt/bin/
	install -m 0755 ${WORKDIR}/GtkLauncher ${D}/opt/bin/
	install -m 0755 ${WORKDIR}/dfb2.sh ${D}/opt/bin/
	install -m 0755 ${WORKDIR}/dfb.sh ${D}/opt/bin/
	install -d ${D}/usr/lib/mozilla/plugins
	install -m 0755 ${WORKDIR}/libhbbtvplugin.so ${D}/usr/lib/mozilla/plugins/
	cp ${WORKDIR}/usr/* ${D}/usr/ -a
}

do_package_qa() {
}
#HACK! These are binaries, so we can't guarantee that LDFLAGS match :(
INSANE_SKIP_${PN} = "ldflags"

#SRC_URI[md5sum] = "a6cbaba110d17b63f1009b12e3002fe9"
#SRC_URI[sha256sum] = "d198ee5452a84626a876d3203c178935344cf51802b73298da2409fd14a46c0b"

PACKAGE_ARCH := "${MACHINE_ARCH}"
PACKAGE := "${PN} ${PN}-dbg "
FILES_${PN} = "/ "
