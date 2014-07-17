

create_fusion_node()
{
  device=$1
  
  rm -f /dev/${device}
  major=`awk "\\$2==\"$device\" {print \\$1}" /proc/devices`
  
  if [ ${major} ]; then
     echo Creating device node for $1
                mknod /dev/${device} c $major 0
  fi
}

KERNEL_VERSION=`uname -r`

mkdir -p /var/run/lirc

insmod /opt/lib/modules/$KERNEL_VERSION/extra/lirc_dev.ko
insmod /opt/lib/modules/$KERNEL_VERSION/extra/lnxplatLirc.ko
insmod /opt/lib/modules/$KERNEL_VERSION/extra/fusion.ko
create_fusion_node "fusion0"
/bin/mkdir  /dev/shm
/bin/mount tmpfs /dev/shm -ttmpfs
/bin/echo -e "depth=32\nvsync-after\npixelformat=ARGB\nno-debug\n" > /etc/directfbrc
#/bin/echo -e "mode \"720x720 60Hz 32bit\"\n# D: 31.50 MHz, H: 37.500 kHz, V: 75.00 Hz\ngeometry 720 720 720 1440 32\ntimings 13468 242 0 45 0 118 20\nendmode" > /etc/fb.modes

export PATH=$PATH:/opt/bin

export LD_LIBRARY_PATH=/lib:/opt/lib:/opt/lib/directfb-1.4-0/systems:/opt/lib/directfb-1.4-0/inputdrivers:/opt/lib/directfb-1.4-0/gfxdrivers:/opt/lib/directfb-1.4-0/interfaces/IDirectFBFont:/opt/lib/directfb-1.4-0/interfaces/IDirectFBImageProvider:/opt/lib/directfb-1.4-0/wm:/opt/lib/directfb-1.4-0/interfaces/IDirectFBVideoProvider

cp -pR /opt/etc/fb.modes /etc

cp -pR /opt/directfb/bin/lircd.conf /etc

cd /opt/bin

./lircd --device=/dev/lirc0


