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
cd /app/
./run.elmo.sh > /dev/null 2&>1 &
cd /opt/bin
. ./alsa.sh

export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/opt/lib
xbmc &
