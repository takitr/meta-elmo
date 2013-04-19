require libgles-apollo.inc

# download required binary distribution from:
# http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/latest/index_FDS.html
# see libgles-omap3.inc for detailed installation instructions
#
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"
IMGPV = "1.9.2291151"
LIBGLESWINDOWSYSTEM = "libpvrPVR2D_BLITWSEGL.so"

SRC_URI += "file://apollo.sgx.modules_1.9.2291151.tar.gz \
	   file://apollo_sgx_license_1.9.2291151.txt \
	  "
INHIBIT_PACKAGE_STRIP = "1"

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
	echo "ParamBufferSize=33554432" >> ${D}${sysconfdir}/powervr.ini
	echo "MaxParamBufferSize=33554432" >> ${D}${sysconfdir}/powervr.ini
	echo "DisableHWTextureUpload=1" >> ${D}${sysconfdir}/powervr.ini


	# The ES2.x, ES3.x, ES5.x and ES6.x CPUs have different SGX hardware, so we need to install multiple sets of userspace

	# Delete objects and linker scripts hidden between the headers
	find ${D} -name "*.o" -delete
	find ${D} -name "*.o.cmd" -delete

	install -d ${D}${sysconfdir}/udev/rules.d
	#install -m 0644 ${WORKDIR}/99-bufferclass.rules ${D}${sysconfdir}/udev/rules.d/

	install -d ${D}/usr/local/bin
	install -d ${D}/usr/bin
	cp ${WORKDIR}/usr/local/bin/* ${D}/usr/local/bin/ -a

}
