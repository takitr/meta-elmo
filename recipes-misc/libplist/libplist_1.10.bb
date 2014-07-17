DESCRIPTION = "A library to handle Apple Property List format whereas it's binary or XML"

LICENSE = "GPLv2 & LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=ebb5c50ab7cab4baeffba14977030c07 \
                    file://COPYING.LESSER;md5=6ab17b41640564434dda85c06b7124f7"

DEPENDS = "libxml2 glib-2.0 swig python"

inherit cmake pkgconfig

SRC_URI = "http://www.libimobiledevice.org/downloads/libplist-${PV}.tar.bz2 \
           file://fix-parallel-make.patch \
"

SRC_URI[md5sum] = "fe642d0c8602d70c408994555c330dd1"
SRC_URI[sha256sum] = "f44c52a0f8065d41d44772a7484f93bc5e7da21a8f4a9ad3f38a36b827eeff0b"

PACKAGES =+ "${PN}-utils ${PN}++"
FILES_${PN} = "${libdir}/libplist${SOLIBS}"
FILES_${PN}++ = "${libdir}/libplist++${SOLIBS}"
FILES_${PN}-utils = "${bindir}/*"

