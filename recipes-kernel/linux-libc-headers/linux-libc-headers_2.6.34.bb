require linux-libc-headers.inc

PR = "r1"

SRC_URI += " file://connector-msg-size-fix.patch"
SRC_URI[md5sum] = "10eebcb0178fb4540e2165bfd7efc7ad"
SRC_URI[sha256sum] = "fa395fec7de633df1cb85b6248b8f35af98380ed128a8bc465fb48bc4d252633"
