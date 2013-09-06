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

if [ -f /opt/.appfs ] ; then
echo "Running insmod now ......."

if [ -f /opt/lib/modules/$KERNEL_VERSION/extra/lnxplatnativeDrv.ko ]; then
insmod /opt/lib/modules/$KERNEL_VERSION/extra/lnxplatnativeDrv.ko
fi
insmod /opt/lib/modules/$KERNEL_VERSION/extra/lnxKKALDrv.ko
if [ -f /opt/lib/modules/$KERNEL_VERSION/extra/lnxnotifyqDrv.ko ]; then
insmod /opt/lib/modules/$KERNEL_VERSION/extra/lnxnotifyqDrv.ko
fi
if [ -f /opt/lib/modules/$KERNEL_VERSION/extra/lnxplatDrv.ko ]; then
insmod /opt/lib/modules/$KERNEL_VERSION/extra/lnxplatDrv.ko
fi
if [ -f /opt/lib/modules/$KERNEL_VERSION/extra/lnxscsDrv.ko ]; then
insmod /opt/lib/modules/$KERNEL_VERSION/extra/lnxscsDrv.ko
fi
if [ -f /opt/lib/modules/$KERNEL_VERSION/extra/lnxfssDrv.ko ]; then
insmod /opt/lib/modules/$KERNEL_VERSION/extra/lnxfssDrv.ko
fi
if [ -f /opt/lib/modules/$KERNEL_VERSION/extra/lnxcssDrv.ko ]; then
insmod /opt/lib/modules/$KERNEL_VERSION/extra/lnxcssDrv.ko
fi
if [ -f /opt/lib/modules/$KERNEL_VERSION/extra/lnxtmasDrv.ko ]; then
insmod /opt/lib/modules/$KERNEL_VERSION/extra/lnxtmasDrv.ko
fi

#mount stotage Device
/app/mount.sh

if [ -f /opt/lib/modules/$KERNEL_VERSION/extra/lnxtmvssDrv.ko ]; then
insmod /opt/lib/modules/$KERNEL_VERSION/extra/lnxtmvssDrv.ko
fi
if [ -f /opt/lib/modules/$KERNEL_VERSION/extra/lnxpvrDrv.ko ]; then
insmod /opt/lib/modules/$KERNEL_VERSION/extra/lnxpvrDrv.ko
fi
if [ -f /opt/lib/modules/$KERNEL_VERSION/extra/vpmfbDrv.ko ]; then
CMDLINE=`cat /proc/cmdline`

echo $CMDLINE

foundNTSC="False"
for X in $CMDLINE
do
        #echo $X
        case $X in
                videomode=NTSC)
                        echo found ntsc value = $X
                        foundNTSC="True"
        esac
done

if [ $foundNTSC = "True" ]
then
echo "found NTSC Mode"
insmod /opt/lib/modules/$KERNEL_VERSION/extra/vpmfbDrv.ko cnxtfb_hdwidth=1280 cnxtfb_hdheight=720 cnxtfb_start_unblanked=1 cnxtfb_sddevice=0 cnxtfb_autoscale_sd=2 ntscmode=1
insmod /opt/lib/modules/$KERNEL_VERSION/extra/vpmfbDrv_g.ko cnxtfb_hdwidth=1280 cnxtfb_hdheight=720 cnxtfb_start_unblanked=1 cnxtfb_sddevice=0 cnxtfb_autoscale_sd=1 ntscmode=1
else
echo "found PAL Mode"
insmod /opt/lib/modules/$KERNEL_VERSION/extra/vpmfbDrv.ko cnxtfb_hdwidth=1280 cnxtfb_hdheight=720 cnxtfb_start_unblanked=1 cnxtfb_sddevice=0 cnxtfb_autoscale_sd=2 ntscmode=0
insmod /opt/lib/modules/$KERNEL_VERSION/extra/vpmfbDrv_g.ko cnxtfb_hdwidth=1280 cnxtfb_hdheight=720 cnxtfb_start_unblanked=1 cnxtfb_sddevice=0 cnxtfb_autoscale_sd=1 ntscmode=0
fi
fi
if [ -f /opt/lib/modules/$KERNEL_VERSION/extra/lnxIPfeDrv.ko ]; then
insmod /opt/lib/modules/$KERNEL_VERSION/extra/lnxIPfeDrv.ko
fi

if [ -f opt/lib/modules/$KERNEL_VERSION/extra/lnxdvbciDrv.ko ]; then
insmod opt/lib/modules/$KERNEL_VERSION/extra/lnxdvbciDrv.ko
fi

if [ -f /opt/lib/modules/$KERNEL_VERSION/fuse.ko ]; then
insmod /opt/lib/modules/$KERNEL_VERSION/fuse.ko
fi

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

if [ -f /mtmp/run.testprogram.sh ]; then
	echo "run.testprogram.sh found. Do not insmod DVB"
else
	insmod /opt/lib/modules/2.6.34/extra/dvb-core.ko
	insmod /opt/lib/modules/2.6.34/extra/LinuxDVB.ko
	insmod /opt/lib/modules/2.6.34/extra/LinuxDVBSC.ko
	mknod /dev/sci0 c 230 0
	mknod /dev/sci1 c 230 1
fi


echo "Driver modules loaded, please start the app now"

fi
