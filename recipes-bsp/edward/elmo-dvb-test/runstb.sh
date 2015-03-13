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

USB_PATH="/media/sdb1"
CP_PATH="/mtmp"
./usr/sbin/telnetd -l /bin/sh
echo "Check Test Program"
mkdir /media/sda2/thumbnail
if [ -f $CP_PATH/run.testprogram.sh ]; then
        cd $CP_PATH
        ./run.testprogram.sh 
else
        echo "TestProgram NOT found"
        cd /app/
        ./StandbyProgram > /dev/null 2>&1 &
        ./run.elmo.sh > /dev/null 2>&1
fi
