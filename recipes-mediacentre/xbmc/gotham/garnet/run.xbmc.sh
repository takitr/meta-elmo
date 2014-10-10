#!/bin/sh
export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/opt/lib

while true
do
	if [ -e /mtmp/runMaru ]; then
		/etc/init.d/transmission restart &
		modprobe usb_storage
		echo "Find runMaru, so Run XBMC"
		mkdir /mnt/hdd0/program/.xbmc/userdata -p
		cp /usr/share/xbmc/autoexec.py /mnt/hdd0/program/.xbmc/userdata/ -a
		/app/check_script.sh post &
		ulimit -s 1024
		while true
		do
			xbmc 
			sleep 1
		done
	fi
	sleep 1
done
