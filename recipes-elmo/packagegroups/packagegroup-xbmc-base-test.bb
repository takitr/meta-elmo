DESCRIPTION = "Task for a base packages for xbmc development version"
LICENSE = "MIT"
THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATH =. "${@base_set_filespath(["${THISDIR}/${PN}"], d)}:"

LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"
PR = "r1"

inherit packagegroup

# for backwards compatibility
RPROVIDES_${PN} += "packagegroup-xbmc-base-test"

RDEPENDS_${PN} = " \
	python \
	python-threading \
	python-shell	\
	python-zlib \
	python-sqlite3 \
	python-json \
	python-xml \
	python-subprocess \
	python-html	\
	python-netserver	\
	python-misc	\
	connman-tests	\
	python-pygobject	\
	python-pygobject-lib	\
	python-textutils	\
	python-dbus	\
	dbus-glib	\
	libupnp \
	nfs-utils-client \
	libomxil-elmo-test	\
	hddtemp \
	transmission \
	libplist	\
	libshairport	\
	librtmp	\
	libbluray \
 	python-simplejson \
	python-textutils \
	python-subprocess \
	python-xmlrpc   \
	python-pprint \
	python-robotparser \
	python-difflib \
	python-email \
	python-compression \
"
