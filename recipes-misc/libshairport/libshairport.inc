DESCRIPTION = "libshairport for oe."
SECTION = "misc"
HOMEPAGE = "http://xbmc.org/"
DEPENDS = "openssl"
LICENSE = "GPLv2"
INC_PR = "r4"
S="${WORKDIR}/${PN}-${PV}_lib"
SRC_URI = "http://mirrors.xbmc.org/build-deps/darwin-libs/${PN}-${PV}_lib.tar.gz;name=archive \
           file://001_add_ao.patch;apply=yes;striplevel=0 \
           file://002_fix_install_header.patch;apply=yes;striplevel=0 \
           file://003_fix_deadlock.patch;apply=yes;striplevel=0 \
           file://004_fix_bad_access.patch;apply=yes;striplevel=0 \
           file://005_fix_shutdown.patch;apply=yes;striplevel=0 \
           file://006_no_printf.patch;apply=yes;striplevel=0 \
           file://007_fix_syslog_defines.patch;apply=yes;striplevel=0 \
           file://008-add-missing-libs.patch;apply=yes;striplevel=0 \
           file://009_fix_ipv6.patch;apply=yes;striplevel=0 \
           file://010_handle_metadata.patch;apply=yes;striplevel=0 \
           file://011_fix_ipv4_fallback.patch;apply=yes;striplevel=0 \
	   file://0001-xbmc-patch-for-xbmc.patch;apply=yes;striplevel=1 \
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
