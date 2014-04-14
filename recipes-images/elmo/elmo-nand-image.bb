require systemd-image.bb

PV = "1.2"
PR = "r1"

IMAGE_INSTALL += " \
	packagegroup-elmo-drivers \
	packagegroup-xbmc \
	packagegroup-base \
	${@base_contains("MACHINE_FEATURES", "wifi", "packagegroup-elmo-wlan", "", d)} \
	mtd-utils \
	emergency-update \
	packagegroup-elmo-legacy \
	packagegroup-elmo-hbbtv \
"

export IMAGE_BASENAME = "elmo-nand-image"

