require systemd-image.bb

IMAGE_INSTALL += " \
	packagegroup-elmo-drivers \
	packagegroup-elmo-maruapp \
	packagegroup-xbmc \
"

#	packagegroup-gnome \
#	packagegroup-gnome-apps \
#	packagegroup-gnome-themes \
#	packagegroup-gnome-xserver-base \
#	packagegroup-core-x11-xserver \
#	packagegroup-gnome-fonts \


export IMAGE_BASENAME = "elmo-nand-image"

