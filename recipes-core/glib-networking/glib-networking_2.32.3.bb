DESCRIPTION = "glib-networking contains the implementations of certain GLib networking features that cannot be implemented directly in GLib itself because of their dependencies."
HOMEPAGE = "http://git.gnome.org/browse/glib-networking/"
BUGTRACKER = "http://bugzilla.gnome.org"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5f30f0716dfdd0d91eb439ebec522ec2"

SECTION = "libs"
DEPENDS = "glib-2.0 gnutls intltool-native"

PR = "r3"

SRC_URI = "${GNOME_MIRROR}/${BPN}/2.32/${BPN}-${PV}.tar.xz"

SRC_URI[md5sum] = "bbad85de0a1466fdfd696e06d84b8f0d"
SRC_URI[sha256sum] = "39fe23e86a57bb7a8a67c65668394ad0fbe2d43960c1f9d68311d5d13ef1e5cf"

EXTRA_OECONF = "--without-ca-certificates"

inherit autotools pkgconfig

FILES_${PN} += "${libdir}/gio/modules/libgio*.so ${datadir}/dbus-1/services/"
FILES_${PN}-dbg += "${libdir}/gio/modules/.debug/"
FILES_${PN}-dev += "${libdir}/gio/modules/libgio*.la"
FILES_${PN}-staticdev += "${libdir}/gio/modules/libgio*.a"
