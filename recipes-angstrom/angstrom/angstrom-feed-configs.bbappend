PR = "r20"

FEED_VERSION = "1.0.0.beta10"
FEED_PREFIX = "collateral"
FEED_URI = "http://update.prismcube.com/prismcube-feeds/${MACHINE_ARCH}/${FEED_VERSION}/stable"

TARGET_ARCH_IPK = "armv7a-vfp"

do_compile() {
	mkdir -p ${S}/${sysconfdir}/opkg
	for feed in all ${TARGET_ARCH_IPK} ${MACHINE_ARCH}; do
		echo "src/gz ${FEED_PREFIX}-${feed} ${FEED_URI}/${feed}" > ${S}/${sysconfdir}/opkg/${feed}-feed.conf
	done
}

do_install() {
	install -d ${D}${sysconfdir}/opkg
	install -m 0644  ${S}/${sysconfdir}/opkg/* ${D}${sysconfdir}/opkg/
}

FILES_${PN} = '${@ " ".join( [ ( "${sysconfdir}/opkg/%s-feed.conf" % feed ) for feed in "all ${TARGET_ARCH_IPK} ${MACHINE_ARCH}".split() ] ) }'
CONFFILES_${PN} = '${@ " ".join( [ ( "${sysconfdir}/opkg/%s-feed.conf" % feed ) for feed in "all ${TARGET_ARCH_IPK} ${MACHINE_ARCH}".split() ] ) }'

