#for FILESPATH update
THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATH =. "${@base_set_filespath(["${THISDIR}/${PN}"], d)}:"

DEPENDS = "libusb1 libcec libplist expat yajl gperf-native fribidi mpeg2dec samba fontconfig curl python libass libmodplug libmicrohttpd wavpack libmms cmake-native libsdl-image libsdl-mixer virtual/egl mysql5 sqlite3 libmms faad2 libcdio libpcre boost lzo enca avahi libsamplerate0  bzip2 virtual/libsdl jasper zip-native zlib libtinyxml taglib libbluray libshairport librtmp libomxil-elmo zlib libnfs"

SRCREV = "fb595f23fbf4f4a4bc9297373f5f0138a1e01a9f"

PV = "12.0"
PR = "r19"
RV = "1.6.1"
SRCDATE = "20131129"
TAG = "45b81bb4a6e85e99b7251e5a44fce13e9cc4bebc"
SRC_URI = "git://update.prismcube.com/frodo.git;protocol=git;tag=${TAG} \
"

SRC_URI += "file://autoexec.py \
	    file://run.xbmc.sh \
	    file://xbmc.service \
	    file://resetXBMC.sh \
	"

S = "${WORKDIR}/git"

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
 --enable-rtmp	\
 --with-platform=prismcube-ruby \
 --enable-player=omxplayer \
"
do_configure_prepend() {
        if [ ! -e ${S}/pvr-addons ]; then
                git clone git://update.prismcube.com/pvr-addons.git ${S}/pvr-addons
                cd ${S}/pvr-addons
                git checkout -b ruby remotes/origin/ruby
        else
                cd ${S}/pvr-addons
                git pull
        fi
        cd -
}

do_install_append() {
        install -d ${D}/mnt/hdd0/program/.xbmc/userdata
	install -d ${D}/usr/lib/xbmc/glslbin
	install -d ${D}/app/
	install -d ${D}/home/root
	cp ${WORKDIR}/autoexec.py ${D}/usr/share/xbmc/autoexec.py
	cp ${WORKDIR}/run.xbmc.sh ${D}/app/run.xbmc.sh
	cp ${WORKDIR}/resetXBMC.sh ${D}/app/resetXBMC.sh
	ln -sf /mnt/hdd0/program/.xbmc ${D}/home/root/.xbmc
	rm ${D}/usr/share/xbmc/addons/repository.xbmc.org -rf
        install -d ${D}/lib/systemd/system/graphical.target.wants
        cp ${WORKDIR}/xbmc.service ${D}/lib/systemd/system/
        cd ${D}/lib/systemd/system/graphical.target.wants
        ln -sf /lib/systemd/system/xbmc.service xbmc.service
}

do_package_qa(){
}


PARALLEL_MAKE = " -j8 "

EXTRA_OECONF_append_armv7a = "--cpu=cortex-a9"
FILES_${PN} += "/app /mnt /home /lib"
