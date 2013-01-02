DESCRIPTION = "libGLES for the Apollo"
LICENSE = "proprietary-binary"

PR = "r10"

COMPATIBLE_MACHINE = "(omap3)"

DEPENDS = "virtual/libx11 libxau libxdmcp"

PROVIDES += "virtual/egl"

SRC_URI = "http://archive.marusys.com/SDK_OGLES2_LINUX_APOLLO_2.08.28.0634.tar.gz	\
		file://debug-sgxpack.tar.gz \
		file://apollo.sgx.etc.tar.gz \
		"

S = "${WORKDIR}/SDKPackage_OGLES2"

# Logic to unpack installjammer file

LIBLOCATION ?="${WORKDIR}/usr/lib"
BINLOCATION ?= "${WORKDIR}/usr/local/bin"

LIBGLESWINDOWSYSTEM ?= "libpvrPVR2D_FRONTWSEGL.so.1"

do_configure() {
	# Attempt to fix up the worst offenders for file permissions
	for i in $(find ${S} -name "*.h") $(find ${S} -name "*.c") $(find ${S} -name "Make*") ; do
		chmod 0644 $i
	done 

	# Attempt to create proper library softlinks
	for sofile in $(find ${S} -name "lib*Open*.so") $(find ${S} -name "lib*srv*.so") $(find ${S} -name "lib*gl*.so") $(find ${S} -name "libpvr*.so") $(find ${S} -name "lib*GL*.so"); do
		if [ "$(readlink -n ${sofile})" = "" ] ; then
			mv $sofile ${sofile}.${IMGPV}
			ln -sf $(basename ${sofile}.${IMGPV}) ${sofile}
			ln -sf $(basename ${sofile}.${IMGPV}) ${sofile}$(echo ${IMGPV} | awk -F. '{print "." $1}')
			ln -sf $(basename ${sofile}.${IMGPV}) ${sofile}$(echo ${IMGPV} | awk -F. '{print "." $1 "." $2}')
		fi
	done

	# Due to recursive make PLAT_* isn''t always passed down correctly, so use sed to fix those
	for mak in $(find ${S} -name "*.mak") ; do
		sed -i -e s:arm-none-linux-gnueabi-:${TARGET_PREFIX}:g $mak
	done

	# clear out old stuff
	find Binaries/ | xargs rm -f || true

}

# Force in GNU_HASH and paths to libs
#TARGET_CC_ARCH += " ${TARGET_LINK_HASH_STYLE} -Wl,-rpath-link,${BINLOCATION} -L${BINLOCATION} \
#-L${STAGING_DIR_TARGET}${libdir} -Wl,-rpath-link,${STAGING_DIR_TARGET}${libdir}"
#PARALLEL_MAKE = ""

do_compile() {
	export X11ROOT="${STAGING_DIR_HOST}/usr"
	export TOOLCHAIN="${TOOLCHAIN_PATH}"
	export PLATFORM="LinuxApollo"

	export PLAT_CC="${CC}"
	export PLAT_CPP="${CXX}"
	export PLAR_AR="${AR}"

}

do_install () {
	install -d ${D}${libdir}
	cp -pPR ${LIBLOCATION}/*.so* ${D}${libdir}
	#install -m 0644 ${LIBLOCATION}/*.a ${D}${libdir}

	install -d ${D}${bindir}/
	#install -m 0755 ${WORKDIR}/cputype ${D}${bindir}/

	install -m 0755 ${BINLOCATION}/*_test ${D}${bindir}/
	install -m 0755 ${BINLOCATION}/gl* ${D}${bindir}/
	install -m 0755 ${BINLOCATION}/p[dv]* ${D}${bindir}/
	#install -m 0755 ${BINLOCATION}/xgles1test1 ${D}${bindir}/

	install -d ${D}${includedir}

	cp -pPR ${S}/Builds/OGLES2/Include/* ${D}${includedir}/
	cp -pPR ${S}/Builds/OGLES/Include/* ${D}${includedir}/ || true
	cp -pPR ${S}/Builds/OGLES/LinuxApollo/Include/GLES/* ${D}${includedir}/GLES/ || true
	cp -pPr ${S}/Builds/OGLES2/LinuxApollo/Include/GLES/* ${D}${includedir}/GLES2/ || true
	cp -pPr ${S}/Builds/OVG/Include/v* ${D}${includedir}/ || true
	cp -pPr ${S}/Builds/OVG/Include/V* ${D}${includedir}/ || true
	cp -pPr ${S}/include/*.h ${D}${includedir} || true
	cp -pPr ${S}/include/wsegl/*.h ${D}${includedir} || true
	
	install -d ${D}${sysconfdir}/init.d/
	cp -pP ${WORKDIR}/etc/init.d/rc.pvr ${D}${sysconfdir}/init.d/pvr-init

	install -d ${D}${sysconfdir}
	echo "[default]" > ${D}${sysconfdir}/powervr.ini
	echo "WindowSystem=${LIBGLESWINDOWSYSTEM}" >> ${D}${sysconfdir}/powervr.ini

	# The ES2.x, ES3.x, ES5.x and ES6.x CPUs have different SGX hardware, so we need to install multiple sets of userspace

	# Delete objects and linker scripts hidden between the headers
	find ${D} -name "*.o" -delete
	find ${D} -name "*.o.cmd" -delete

	install -d ${D}${sysconfdir}/udev/rules.d
	#install -m 0644 ${WORKDIR}/99-bufferclass.rules ${D}${sysconfdir}/udev/rules.d/

	install -d ${D}/usr/local/bin
	ln -s ../../bin/pvrsrvinit ${D}/usr/local/bin/pvrsrvinit

}

PACKAGES =+ "${PN}-blitwsegl ${PN}-flipwsegl "

FILES_${PN}-blitwsegl = "${libdir}/libpvrPVR2D_BLITWSEGL.so.* ${libdir}/*/libpvrPVR2D_BLITWSEGL.so.*"
FILES_${PN}-flipwsegl = "${libdir}/libpvrPVR2D_FLIPWSEGL.so.* ${libdir}/*/libpvrPVR2D_FLIPWSEGL.so.*"

CONFFILES_${PN} = "${sysconfdir}/powervr.ini"

FILES_${PN} = "${sysconfdir} ${libdir}/lib*.so.* ${bindir}/pvrsrvinit ${bindir}/*/* /usr/local/bin/*"
FILES_${PN}-tests = "${bindir}/*"
FILES_${PN}-dbg = ""

# The libs need the kernel-modules
RRECOMMENDS_${PN} = "apollo-sgx-modules"

# The initscript calls fbset, cputype calls devmem2
#RDEPENDS_${PN} += "fbset devmem2"

#HACK! These are binaries, so we can't guarantee that LDFLAGS match :(
INSANE_SKIP_${PN} = True
INSANE_SKIP_${PN}-blitwsegl = True
INSANE_SKIP_${PN}-flipwsegl = True
INSANE_SKIP_${PN}-tests = True

# Quality control is really poor on these SDKs, so hack around the latest madness:
FILES_${PN} += "${libdir}/*.so "
FILES_${PN}-dev = "${includedir}"

inherit update-rc.d

INITSCRIPT_NAME = "pvr-init"
INITSCRIPT_PARAMS = "start 30 5 2 . stop 40 0 1 6 ."

# Append to update-rc.d postinst
pkg_postinst_${PN}_append() {
	oenote  "pkg_postinst...."
	rm -f /etc/powervr-esrev
}

SRC_URI[md5sum] = "9c53542814c17e1a8bf45ae7e2b449c8"
SRC_URI[sha256sum] = "898047042452000703a3276a7c3ef5f9b245ecc521a41ac467972aa1e26a33ac"
