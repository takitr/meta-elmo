#!/bin/sh
############################################################################
#                      NXP PROPRIETARY AND CONFIDENTIAL                    #
#                        SOFTWARE FILE/MODULE HEADER                       #
#                      Copyright NXP Semiconductors 2009                   #
#                            All Rights Reserved                           #
############################################################################
#
# Filename:        stb_sys_startup.sh
#
# Description:     Simple script to startup a development system
#
# Author:          Nitin Garg
#
############################################################################
# $Id: S10_stb_sys_startup.sh 167977 2010-07-22 07:23:07Z asethi $
############################################################################

#set -x


PATH=/sbin:/bin:/usr/sbin:/usr/bin
KERNEL_VERSION=`uname -r`
INSMOD_DEBUG=FALSE

insmod_module() {
        if [ "$INSMOD_DEBUG" = TRUE ]; then
                echo "insmod " $1 > /dev/ttyS1 2>&1
                if [ -f /opt/lib/modules/$KERNEL_VERSION/extra/$1 ]; then
                        time insmod /opt/lib/modules/$KERNEL_VERSION/extra/$1 > /dev/ttyS1 2>&1
                fi
        else
                if [ -f /opt/lib/modules/$KERNEL_VERSION/extra/$1 ]; then
			echo insmod /opt/lib/modules/$KERNEL_VERSION/extra/$1
                        insmod /opt/lib/modules/$KERNEL_VERSION/extra/$1
                fi
        fi
}

insmod_group() {
        args="$@";
        echo $args
        for i in $args
        do
                echo insmod $i
               insmod_module $i
        done;
}



foundNTSC="False"

check_tvtype() {
	for X in $CMDLINE
	do
       	 #echo $X
        case $X in
                videomode=NTSC)
                        echo found ntsc value = $X
                        foundNTSC="True"
        esac
	done
}

module_group_platnative="lnxplatnativeDrv.ko"
module_group_KAL="lnxKKALDrv.ko lnxnotifyqDrv.ko"



if [ -f /opt/.appfs ] ; then
echo "Running insmod now ......."

if [ $INSMOD_DEBUG = "TRUE" ]
then
	time /app/mount.sh > /dev/ttyS1 2>&1 &
else
	/app/mount.sh &
fi
mount_pid=$!

insmod_group $module_group_platnative &
pid_platnative=$!
wait $pid_platnative
insmod_group $module_group_KAL &
pid_KAL=$!

wait $pid_KAL

insmod_module lnxplatDrv.ko
insmod_module lnxscsDrv.ko

insmod_group_fss="lnxfssDrv.ko"
insmod_group_av="lnxcssDrv.ko lnxtmasDrv.ko lnxtmvssDrv.ko lnxpvrDrv.ko"

insmod_group $insmod_group_fss &
pid_fss=$!
insmod_group $insmod_group_av &
pid_av=$1

check_tvtype &

wait $pid_fss
wait $pid_av


insmod_vpmfb() {
	if [ $foundNTSC = "True" ]
	then
		echo "found NTSC Mode"
		insmod /opt/lib/modules/$KERNEL_VERSION/extra/vpmfbDrv.ko cnxtfb_hdwidth=1280 cnxtfb_hdheight=720 cnxtfb_start_unblanked=1 cnxtfb_sddevice=0 cnxtfb_autoscale_sd=2 ntscmode=1
		#insmod /opt/lib/modules/$KERNEL_VERSION/extra/vpmfbDrv_g.ko cnxtfb_hdwidth=1280 cnxtfb_hdheight=720 cnxtfb_start_unblanked=0 cnxtfb_sddevice=0 cnxtfb_autoscale_sd=1 ntscmode=1
	else
		echo "found PAL Mode"
		if [ $INSMOD_DEBUG = "TRUE" ]
		then 
			time insmod /opt/lib/modules/$KERNEL_VERSION/extra/vpmfbDrv.ko cnxtfb_hdwidth=1280 cnxtfb_hdheight=720 cnxtfb_start_unblanked=1 cnxtfb_sddevice=0 cnxtfb_autoscale_sd=2 ntscmode=0 > /dev/ttyS1 2>&1 
		else
			insmod /opt/lib/modules/$KERNEL_VERSION/extra/vpmfbDrv.ko cnxtfb_hdwidth=1280 cnxtfb_hdheight=720 cnxtfb_start_unblanked=1 cnxtfb_sddevice=0 cnxtfb_autoscale_sd=2 ntscmode=0 
		fi
		insmod /opt/lib/modules/$KERNEL_VERSION/extra/vpmfbDrv_g.ko cnxtfb_hdwidth=1280 cnxtfb_hdheight=720 cnxtfb_start_unblanked=0 cnxtfb_sddevice=0 cnxtfb_autoscale_sd=1 ntscmode=0 > /dev/ttyS1 2>&1 
	fi
}

insmod_module lnxIpfeDrv.ko &
insmod_module lnxdvbciDrv.ko &
insmod_module fusion.ko &
insmod_vpmfb &

insmod_linuxdvb() {
	echo "insmod LinuxDVB" > /dev/ttyS1 2>&1
	if [ -f /mtmp/run.testprogram.sh ]; then
		echo "run.testprogram.sh found. Do not insmod DVB"
	else
		modprobe dvb-core > /dev/ttyS1 2>&1
		insmod /lib/modules/2.6.34/kernel/drivers/media/dvb/dvb-core/dvb-core.ko
		if [ $INSMOD_DEBUG = "TRUE" ]; then
		time insmod /opt/lib/modules/2.6.34/extra/LinuxDVB.ko > /dev/ttyS1 2>&1
		time insmod /opt/lib/modules/2.6.34/extra/LinuxDVBSC.ko > /dev/ttyS1 2>&1
		else
		insmod /opt/lib/modules/2.6.34/extra/LinuxDVB.ko 
		insmod /opt/lib/modules/2.6.34/extra/LinuxDVBSC.ko 
		fi
		mknod /dev/sci0 c 230 0
		mknod /dev/sci1 c 230 1
	fi
}

insmod_linuxdvb &

echo "Driver modules loaded, please start the app now"
wait $mount_pid

if [ -f /media/sdb1/run.checkusb.sh ]; then
	echo "TEST LOG !!"
	cd /media/sdb1
	./run.checkusb.sh 
elif [ -f /media/sda1/run.checkusb2.sh ]; then
	cd /media/sda1
	./run.checkusb2.sh 
else
	echo "Test File not found"
fi

fi
