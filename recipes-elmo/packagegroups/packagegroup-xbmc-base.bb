DESCRIPTION = "Task for a base packages for xbmc"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

PR = "r0"

inherit packagegroup

# for backwards compatibility
RPROVIDES_${PN} += "packagegroup-xbmc-base"

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
	libupnp \
	nfs-utils-client \
	libomxil-elmo	\
"
