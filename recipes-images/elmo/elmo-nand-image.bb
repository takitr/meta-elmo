require systemd-image.bb

PV = "1.1.12"
PR = "r1"

IMAGE_INSTALL += " \
	packagegroup-elmo-drivers \
	packagegroup-elmo-maruapp \
	packagegroup-xbmc \
	packagegroup-base \
	${@base_contains("MACHINE_FEATURES", "wifi", "packagegroup-elmo-wlan", "", d)} \
	mtd-utils \
	emergency-update \
	packagegroup-elmo-legacy \
"
ROOTFS_POSTPROCESS_COMMAND += " legacy_network_files ; "

legacy_network_files (){
        mv ${IMAGE_ROOTFS}/app/run.elmo.sh.legacy ${IMAGE_ROOTFS}/app/run.elmo.sh
        mv ${IMAGE_ROOTFS}/lib/systemd/system/connman.service.legacy ${IMAGE_ROOTFS}/lib/systemd/system/connman.service
        mv ${IMAGE_ROOTFS}/etc/network/interfaces.legacy ${IMAGE_ROOTFS}/etc/network/interfaces
        mv ${IMAGE_ROOTFS}/app/setMac.sh.legacy ${IMAGE_ROOTFS}/app/setMac.sh
}



export IMAGE_BASENAME = "elmo-nand-image"

