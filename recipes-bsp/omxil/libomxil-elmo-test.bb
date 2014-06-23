DESCRIPTION = "OpenMax IL for  ELMO"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://apollo_openmax_license.txt;md5=acab3b4aaa7ba59cdcaef95fd877d6d6"

COMPATIBLE_MACHINE = "(elmo)"

KV = "2.6.34"


PV = "${KV}"
SRCDATE = "20140623"
PR = "r12"

SRC_URI = "http://update.prismcube.com/Ruby/libomxil-elmo-debug-${SRCDATE}-dev.tar.gz \
	   file://apollo_openmax_license.txt \
	   file://libomxil-elmo.pc	\
          "

S = "${WORKDIR}"
do_configure() {
}
do_compile() {
}

do_install() {
        install -d ${D}/usr/include/OpenMAX/IL/
	cp ${WORKDIR}/libomxil-elmo-debug/include/khronos/* ${D}/usr/include/OpenMAX/IL/ -a 
	install -d ${D}/usr/lib/pkgconfig
	install -m 0755 ${WORKDIR}/libomxil-elmo-debug/libtopenmax.so ${D}/usr/lib/
	cp ${WORKDIR}/libomxil-elmo.pc ${D}/usr/lib/pkgconfig/ -a
}
do_package_qa() {
}

INSANE_SKIP_${PN} = "ldflags dev-so" 
SRC_URI[md5sum] = "92cc879d4126dd24956a02535df3e568"
SRC_URI[sha256sum] = "8d353d539068c4695d174c2448234d42363db5ffaec0cbb1e390cf05a2b6a69c"

#PACKAGE_ARCH := "${MACHINE_ARCH}"
PACKAGES = "${PN} ${PN}-dbg "
FILES_${PN} = "/usr/lib/* /usr/lib/pkgconfig/*"
FILES_${PN}-dbg = "/usr/lib/* /usr/lib/pkgconfig/*"

