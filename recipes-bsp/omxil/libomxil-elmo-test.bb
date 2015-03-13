DESCRIPTION = "OpenMax IL for  ELMO"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://apollo_openmax_license.txt;md5=acab3b4aaa7ba59cdcaef95fd877d6d6"

COMPATIBLE_MACHINE = "(elmo)"

KV = "2.6.34"


PV = "${KV}"
SRCDATE = "20150227"
PR = "r14"

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
SRC_URI[md5sum] = "ef8ee8d1600883e627fb09286dde7f94"
SRC_URI[sha256sum] = "ac776cb0d2f507beecd2b232babbd79c88f9ac4a535b40aaba7c9f50cf1836ea"

#PACKAGE_ARCH := "${MACHINE_ARCH}"
PACKAGES = "${PN} ${PN}-dbg "
FILES_${PN} = "/usr/lib/* /usr/lib/pkgconfig/*"
FILES_${PN}-dbg = "/usr/lib/* /usr/lib/pkgconfig/*"

