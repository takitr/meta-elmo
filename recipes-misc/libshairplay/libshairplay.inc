DESCRIPTION = "libshairplay for oe."
SECTION = "misc"
HOMEPAGE = "http://xbmc.org/"
DEPENDS = ""
LICENSE = "GPLv2"
INC_PR = "r4"
S="${WORKDIR}/git"
SRC_URI = "git://github.com/Memphiz/shairplay;tag=HEAD;protocol=git \
		"

#do_patch(){
#	cd ${S}; patch -p0 < ../001_add_ao.patch
#        cd ${S}; patch -p0 < ../002_fix_install_header.patch
#        cd ${S}; patch -p0 < ../003_fix_deadlock.patch
#        cd ${S}; patch -p0 < ../004_fix_bad_access.patch
#        cd ${S}; patch -p0 < ../005_fix_shutdown.patch
#        cd ${S}; patch -p0 < ../006_no_printf.patch
#        cd ${S}; patch -p0 < ../007_fix_syslog_defines.patch
#        cd ${S}; patch -p0 < ../008-add-missing-libs.patch
#        cd ${S}; patch -p0 < ../009_fix_ipv6.patch
#        cd ${S}; patch -p0 < ../010_handle_metadata.patch
#        cd ${S}; patch -p0 < ../011_fix_ipv4_fallback.patch
#}
inherit autotools


PACKAGES += "${PN}"

FILES_${PN} = "/"
