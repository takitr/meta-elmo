#!/bin/sh

if [ -e /config/resetXBMC ]
then
	rm -rf /usr/share/xbmc/userdata/Database/*
	mount /dev/sda3 /mnt/hdd0/program/
	rm -rf /mnt/hdd0/program/.xbmc/*
	rm -rf /usr/local/xbmc.addons/*
	rm -rf /config/xbmc.addons/*
	umount /mnt/hdd0/program/
	rm /config/resetXBMC
fi

