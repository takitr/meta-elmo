require systemd-image.bb

PV = "1.2"
PR = "r1"

IMAGE_INSTALL += " \
	packagegroup-elmo-drivers-test \
	packagegroup-xbmc-test \
	packagegroup-base \
	${@base_contains("MACHINE_FEATURES", "wifi", "packagegroup-elmo-wlan", "", d)} \
	mtd-utils \
	emergency-update-test \
	packagegroup-elmo-legacy \
"

export IMAGE_BASENAME = "elmo-nand-image-test"

