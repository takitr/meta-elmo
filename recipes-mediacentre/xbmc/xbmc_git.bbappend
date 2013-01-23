#for FILESPATH update
THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATH =. "${@base_set_filespath(["${THISDIR}/${PN}"], d)}:"

DEPENDS += " taglib "
PV = "12.0"
PR = "rc3"
SRC_URI = "git://github.com/xbmc/xbmc.git;branch=eden;protocol=git \
		file://Lircmap.xml \
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
