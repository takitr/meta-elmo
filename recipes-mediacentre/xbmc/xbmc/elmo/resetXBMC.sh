#!/bin/sh

if [ -e /config/resetXBMC ]
then
	mount /dev/sda3 /mnt/hdd0/program/
	rm -rf /mnt/hdd0/program/.xbmc/*
	rm -rf /usr/local/xbmc.addons/*
	umount /mnt/hdd0/program/
	rm /config/resetXBMC
fi

