DESCRIPTION = "GNU libmicrohttpd is a small C library that is supposed to make it easy to run an HTTP server as part of another application."
HOMEPAGE = "http://www.gnu.org/software/libmicrohttpd/"
LICENSE = "LGPL-2.1+"

LIC_FILES_CHKSUM = "file://COPYING;md5=9331186f4f80db7da0e724bdd6554ee5"
ECTION = "net"
DEPENDS = "gnutls libgcrypt"

SRC_URI = "http://ftp.gnu.org/gnu/libmicrohttpd/${BPN}-${PV}.tar.gz"
SRC_URI[md5sum] = "013b10f9de1cda5448b29c81305354a3"
SRC_URI[sha256sum] = "d9587e8497548f820650cd607daf3615ea3272435779378983032c570f1cd559"

inherit autotools
EXTRA_OECONF += "--disable-dependency-tracking --enable-largefile \
                 --enable-curl --enable-messages --with-pic"
