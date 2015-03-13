#!/bin/sh
export EDITOR='/bin/vi'
export HOME='/home/root'
export LOGNAME='root'
export OPIEDIR
export PATH='/usr/local/bin:/usr/bin:/bin:/usr/local/sbin:/usr/sbin:/sbin'
export PS1='\u@\h:\w\$ '
export PWD='/home/root'
export QPEDIR
export QTDIR
export SHELL='/bin/sh'
export TERM='linux'
export TSLIB_TSDEVICE='/dev/input/touchscreen0'
export TZ='UTC'
export USER='root'
export LD_LIBRARY_PATH=/opt/lib
PATH=/sbin:/bin:/usr/sbin:/usr/bin
export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/opt/lib

while true
do
	if [ -e /mtmp/runMaru ]; then
		/etc/init.d/transmission restart &
		modprobe usb_storage
		echo "Find runMaru, so Run XBMC"
		mkdir /mnt/hdd0/program/.xbmc/userdata/addon_data/script.mbox -p
		cp /usr/share/xbmc/autoexec.py /mnt/hdd0/program/.xbmc/userdata/ -a
		cp /config/guisettings.xml /mnt/hdd0/program/.xbmc/userdata/ -a
		cp /config/settings.xml /mnt/hdd0/program/.xbmc/userdata/addon_data/script.mbox/ -a
		/app/check_script.sh post &

		if [ ! -d /usr/share/xbmc/userdata/Database ]; then
			mkdir /usr/share/xbmc/userdata/Database -p
			if [ -d /home/root/.xbmc/userdata/Database ]; then
				if [ -L /home/root/.xbmc/userdata/Database ]; then
		                        if [ -d /mnt/hdd0/program/Database ]; then
                                		cp -a /mnt/hdd0/program/Database/* /usr/share/xbmc/userdata/Database
					fi                
				else
					cp -a /home/root/.xbmc/userdata/Database/* /usr/share/xbmc/userdata/Database
				fi
			fi
			rm -rf /home/root/.xbmc/userdata/Database
		        ln -s /usr/share/xbmc/userdata/Database /home/root/.xbmc/userdata/Database
			sync
		else
			if [ -d /home/root/.xbmc/userdata/Database ]; then                                  
				if [ -L /home/root/.xbmc/userdata/Database ]; then                                          
                                	echo "Symbolic link exists"                                                         
                                fi                                                                                  
                        else
				rm -rf /usr/share/xbmc/userdata/Database/*                                  
				cp -a /home/root/.xbmc/userdata/Database/* /usr/share/xbmc/userdata/Database
			fi  
	                rm -rf /home/root/.xbmc/userdata/Database
        	        ln -s /usr/share/xbmc/userdata/Database /home/root/.xbmc/userdata/Database
                	sync
		fi
		
		if [ -e /app/check_pyo ]; then
			python /app/compile.py
			rm -rf /app/check_pyo
			sync
		fi

		ulimit -s 1024
		while true
		do
			xbmc
			sleep 1
		done
	fi
	sleep 1
done
