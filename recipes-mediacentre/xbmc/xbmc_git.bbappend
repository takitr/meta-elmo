#for FILESPATH update
THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATH =. "${@base_set_filespath(["${THISDIR}/${PN}"], d)}:"

DEPENDS = "libusb1 libcec libplist expat yajl gperf-native libxmu fribidi mpeg2dec ffmpeg samba fontconfig curl python libass libmodplug libmicrohttpd wavpack libmms cmake-native libsdl-image libsdl-mixer virtual/egl mysql5 sqlite3 libmms faad2 libcdio libpcre boost lzo enca avahi libsamplerate0 libxinerama libxrandr libxtst bzip2 virtual/libsdl jasper zip-native zlib libtinyxml taglib libpostproc"

#beta3
SRCREV = "ae60d24346e99e6e67d68e247ebaea8e6acb185c"

PV = "12.0"
PR = "beta3"

SRC_URI = "git://github.com/xbmc/xbmc.git;tag=Frodo_beta3;protocol=git \
	"
SRC_URI += "file://Lircmap.xml \
                file://autoexec.py \
                file://home.xbmc.tar.gz "

EXTRA_OECONF = " \
 --disable-rpath \
 --enable-gles \
 --enable-libusb \
 --enable-airplay \
 --disable-optical-drive \
 --enable-external-libraries \
 --disable-ssh \
 --disable-external_ffmpeg \
 --disable-x11 \
 --disable-sdl \
 --disable-joystick \
 --disable-alsa \
 --with-platform=prismcube-ruby \
 --enable-player=omxplayer \
"
do_install_append() {
        cp ${WORKDIR}/Lircmap.xml ${D}${datadir}/xbmc/system/Lircmap.xml
        #cp ${WORKDIR}/autoexec.py ${D}${datadir}/xbmc/scripts/autoexec.py
        install -d ${D}/home/root/.xbmc/userdata
        cp ${WORKDIR}/xbmc/* ${D}/home/root/.xbmc/ -av
        cp ${WORKDIR}/autoexec.py ${D}/home/root/.xbmc/userdata/autoexec.py
}

FILES_${PN}_append = " /home/root/.xbmc/"

PARALLEL_MAKE = " -j8 "

EXTRA_OECONF_append_armv7a = "--cpu=cortex-a9"
