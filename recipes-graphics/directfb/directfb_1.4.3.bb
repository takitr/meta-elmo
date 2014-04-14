require directfb.inc

RV = "1.4-0"
PR = "${INC_PR}.0"

DEPENDS += "sysfsutils"

SRC_URI = " \
    file://DirectFB-1.4.3.tar.gz \
	"

LEAD_SONAME = "libdirectfb-1.4.so.0"

do_install(){
	install -d ${D}/usr
        cp ${WORKDIR}/usr/* ${D}/usr/ -av 
}
#HACK! These are binaries, so we can't guarantee that LDFLAGS match :(
INSANE_SKIP_${PN} = "ldflags dev-so"

PACKAGE_ARCH := "${MACHINE_ARCH}"
PACKAGE := "${PN} ${PN}-dbg "
FILES_${PN} = "/usr/lib/ "
FILES_${PN} += "/usr/share/  "

SRC_URI[md5sum] = "223e036da906ceb4bd44708026839ff1"
SRC_URI[sha256sum] = "1435aae4f0eb70252dc25ee50e51aecfdc4527f2651db5f35b34eb833fa7e978"

