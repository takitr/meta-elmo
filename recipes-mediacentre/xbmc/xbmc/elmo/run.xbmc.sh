#!/bin/sh
export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/opt/lib
/etc/init.d/transmission restart &

while true
do
	if [ -e /mtmp/runMaru ]; then
		/etc/init.d/transmission restart &
		modprobe usb_storage
		echo "Find runMaru, so Run XBMC"
		mkdir /mnt/hdd0/program/.xbmc/userdata -p
		if [ -f /mnt/hdd0/program/.xbmc/userdata/autoexec.py ]; then
		        echo "autoexec.py exist!!"
		else
		        cp /usr/share/xbmc/autoexec.py /mnt/hdd0/program/.xbmc/userdata/ -a
		fi
		while true
		do
			xbmc
			sleep 3
		done
	fi
	sleep 1
done
