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
if [ -f /opt/lib/modules/$KERNEL_VERSION/extra/lnxtmvssDrv.ko ]; then
insmod /opt/lib/modules/$KERNEL_VERSION/extra/lnxtmvssDrv.ko
fi
if [ -f /opt/lib/modules/$KERNEL_VERSION/extra/lnxpvrDrv.ko ]; then
insmod /opt/lib/modules/$KERNEL_VERSION/extra/lnxpvrDrv.ko
fi
if [ -f /opt/lib/modules/$KERNEL_VERSION/extra/vpmfbDrv.ko ]; then
insmod /opt/lib/modules/$KERNEL_VERSION/extra/vpmfbDrv.ko cnxtfb_hdwidth=1280 cnxtfb_hdheight=720 cnxtfb_start_unblanked=1 cnxtfb_sddevice=0 cnxtfb_autoscale_sd=2
insmod /opt/lib/modules/$KERNEL_VERSION/extra/vpmfbDrv_g.ko cnxtfb_hdwidth=1280 cnxtfb_hdheight=720 cnxtfb_start_unblanked=1 cnxtfb_sddevice=0 cnxtfb_autoscale_sd=1
fi
if [ -f /opt/lib/modules/$KERNEL_VERSION/extra/lnxIPfeDrv.ko ]; then
insmod /opt/lib/modules/$KERNEL_VERSION/extra/lnxIPfeDrv.ko
fi

if [ -f /opt/lib/modules/$KERNEL_VERSION/extra/lnxdvbciDrv.ko ]; then
insmod /opt/lib/modules/$KERNEL_VERSION/extra/lnxdvbciDrv.ko
fi

if [ -f /opt/lib/modules/$KERNEL_VERSION/fuse.ko ]; then
insmod /opt/lib/modules/$KERNEL_VERSION/fuse.ko
fi

if [ -f /opt/lib/modules/$KERNEL_VERSION/tntfs.ko ]; then
insmod /opt/lib/modules/$KERNEL_VERSION/tntfs.ko
fi

echo "Driver modules loaded, please start the app now"

fi
