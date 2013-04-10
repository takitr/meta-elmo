#for FILESPATH update
THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATH =. "${@base_set_filespath(["${THISDIR}/${PN}"], d)}:"

DEPENDS = "libusb1 libcec libplist expat yajl gperf-native libxmu fribidi mpeg2dec ffmpeg samba fontconfig curl python libass libmodplug libmicrohttpd wavpack libmms cmake-native libsdl-image libsdl-mixer virtual/egl mysql5 sqlite3 libmms faad2 libcdio libpcre boost lzo enca avahi libsamplerate0 libxinerama libxrandr libxtst bzip2 virtual/libsdl jasper zip-native zlib libtinyxml taglib libpostproc libbluray"

SRCREV = "fb595f23fbf4f4a4bc9297373f5f0138a1e01a9f"


PV = "12.0"
PR = "r0"

SRC_URI = "git://github.com/xbmc/xbmc.git;tag=12.0-Frodo;protocol=git \
	"
SRC_URI += "file://autoexec.py \
	"

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
        install -d ${D}/mnt/hdd0/program/.xbmc/userdata
	cp ${WORKDIR}/autoexec.py ${D}/usr/share/xbmc/autoexec.py
}

do_package_qa(){
}


PARALLEL_MAKE = " -j8 "

EXTRA_OECONF_append_armv7a = "--cpu=cortex-a9"
