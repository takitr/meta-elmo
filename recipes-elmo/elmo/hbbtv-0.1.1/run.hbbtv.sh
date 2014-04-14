cd /opt/bin
. ./dfb2.sh
LD_LIBRARY_PATH=/opt/lib
export MOZ_PLUGIN_PATH="/usr/lib/mozilla/plugins/"
insmod /opt/lib/modules/2.6.34/extra/HbbTvProc.ko
export HBB_BROWSER_IP=127.0.0.1
export HBB_SYSTEM_IP=127.0.0.1
LD_PRELOAD=/opt/lib/liblnxUKAL.so:/opt/lib/liblnxnotifyqUsr.so:/opt/lib/liblnxcssUsr.so:/opt/lib/liblnxtmvssUsr.so:/opt/lib/liblnxpvrUsr.so:/opt/lib/liblnxplatUsr.so ./GtkLauncher \
--enable-spatial-navigation=true \
--enable-page-cache=false \
--enable-caret-browsing=false \
--enable-default-context-menu=false \
--enable-offline-web-application-cache=false \
--enable-html5-database=false \
--enable-html5-local-storage=false \
file:///mnt/webkit/bin/none.html \
