SUMMARY = "LIBNFS is a client library for accessing NFS shares over a network."
SECTION = "network"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=a8375400e512ca525d061f32fb28b83a"

inherit autotools

PR = "ruby-r0"

SRCREV="8733f38d23deabd7422b85b74c8e51e32e5ea51c"

SRC_URI = "git://github.com/sahlberg/libnfs;protocol=git;branch=master;tag=${SRCREV} \
"
S = "${WORKDIR}/git"
