require systemd-image.bb

IMAGE_INSTALL += " \
	packagegroup-elmo-drivers \
	packagegroup-elmo-maruapp \
	packagegroup-xbmc \
	packagegroup-base \
	${@base_contains("MACHINE_FEATURES", "wifi", "packagegroup-elmo-wlan", "", d)} \
	mtd-utils \
	emergency-update \
"


export IMAGE_BASENAME = "elmo-nand-image"

