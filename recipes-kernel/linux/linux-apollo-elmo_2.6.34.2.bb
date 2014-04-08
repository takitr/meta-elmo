#require linux.inc

DESCRIPTION = "Linux kernel for Apollo processors"
KERNEL_IMAGETYPE = "vmlinux"

COMPATIBLE_MACHINE = "beagleboard|omap3evm|am3517-evm"
SECTION = "kernel"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel siteinfo

DESCRIPTION = "Linux kernel for Apollo processors"
KERNEL_IMAGETYPE = "vmlinux"

COMPATIBLE_MACHINE = "(elmo)"

PR = "r12"
PV = "2.6.34.2"

MODULE = "linux-2.6.34"
KERNEL_VERSION = "2.6.34"

module_autoload_ohci-hcd_omap5912osk = "ohci-hcd"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_calamari = "1"
DEFAULT_PREFERENCE_qemuarm = "1"
DEFAULT_PREFERENCE_qemuppc = "1"
DEFAULT_PREFERENCE_qemush4 = "1"
DEFAULT_PREFERENCE_qemumips = "1"
DEFAULT_PREFERENCE_qemumipsel = "1"
DEFAULT_PREFERENCE_qemux86 = "1"
DEFAULT_PREFERENCE_lite5200 = "1"
DEFAULT_PREFERENCE_omap5912osk = "1"
DEFAULT_PREFERENCE_tqm8540 = "1"
DEFAULT_PREFERENCE_ts72xx = "-1"
DEFAULT_PREFERENCE_om-gta01 = "1"
DEFAULT_PREFERENCE_om-gta02 = "1"

SRC_URI = "git://git.infradead.org/~dedekind/ubifs-v2.6.34.git;protocol=git;tag=5f94704684739bba7ae75b4043ed953cfd0fe0ec \
			file://Apollo_Driver_Patch.patch;apply=yes;striplevel=1 \
			file://173-apollo_gmac.patch;apply=yes;striplevel=1 \
			file://174-apollo_change_logo.patch \
			file://200-systemd-patch-for-systemd.patch;apply=yes;striplevel=1 \
			file://201-apollo_L2Cache_Disable.patch;apply=yes;striplevel=1 \
			file://300-LIPP_6300ETH-ifup-ifdown-bugs-when-ethernet-is-unplu.patch;apply=yes;striplevel=1 \
			file://400-Dvb-core.patch;apply=yes;striplevel=1 \
			file://defconfig_wireless \
			file://defconfig_wireless.systemd \
			file://defconfig_wireless.systemd.linuxtv \
			file://defconfig_wireless.systemd.memorydebug \
			file://defconfig_wireless.systemd.linuxtv.release \
			"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "${PARALLEL_MAKE} "

do_configure() {
        oe_machinstall -m 0644 ${WORKDIR}/defconfig_wireless.systemd.linuxtv.release ${S}/.config
        oe_runmake oldconfig
}

do_install_prepend() {
	install -m 0755 ${S}/vmlinux ${S}/arch/arm/boot/vmlinux
	install -d 0755 ${S}/arch/arm/boot/.debug
	install -m 0755 ${S}/vmlinux ${S}/arch/arm/boot/.debug/vmlinux
}

do_install_append () {
        install -d ${D}/boot
        install -m 0755 vmlinux ${D}/boot/vmlinux
        ${OBJCOPY} -O binary -R .note.gnu.build-id vmlinux vmlinux.bin
	cp ${S}/vmlinux.bin ${D}/boot/ -a
        gzip ${D}/boot/vmlinux
	oe_runmake headers_install INSTALL_HDR_PATH=${D}${exec_prefix}/src/linux-${KERNEL_VERSION} ARCH=$ARCH
}
CKAGES =+ "kernel-headers"
FILES_kernel-headers = "${exec_prefix}/src/linux*"

do_devicetree_image() {
    if test -n "${KERNEL_DEVICETREE}" ; then
        dtc -I dts -O dtb ${KERNEL_DEVICETREE_FLAGS} -o devicetree ${KERNEL_DEVICETREE}
        install -d ${D}/boot
        install -m 0644 devicetree ${D}/boot/devicetree-${KERNEL_VERSION}
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 devicetree ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_BASE_NAME}.dtb
        package_stagefile_shell ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_BASE_NAME}.dtb
        cd ${DEPLOY_DIR_IMAGE}
        rm -f ${KERNEL_IMAGE_SYMLINK_NAME}.dtb
        ln -sf ${KERNEL_IMAGE_BASE_NAME}.dtb ${KERNEL_IMAGE_SYMLINK_NAME}.dtb
        package_stagefile_shell ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_SYMLINK_NAME}.dtb
    fi
}

addtask devicetree_image after do_install before do_package do_deploy

pkg_postinst_kernel-devicetree () {
        cd /${KERNEL_IMAGEDEST}; update-alternatives --install /${KERNEL_IMAGEDEST}/devicetree devicetree devicetree-${KERNEL_VERSION} ${KERNEL_PRIORITY} || true
}

pkg_postrm_kernel-devicetree () {
        cd /${KERNEL_IMAGEDEST}; update-alternatives --remove devicetree devicetree-${KERNEL_VERSION} || true
}

# Automatically depend on lzop-native if CONFIG_KERNEL_LZO is enabled
python () {
    try:
        defconfig = bb.fetch2.localpath('file://defconfig', d)
    except bb.fetch2.FetchError:
        return

    try:
        configfile = open(defconfig)
    except IOError:
        return

    if 'CONFIG_KERNEL_LZO=y\n' in configfile.readlines():
        depends = d.getVar('DEPENDS', False)
        d.setVar('DEPENDS', depends + ' lzop-native')
}
# Sadly perf is broken:
# #| util/hist.c: In function '__hists__add_entry':
# #| util/hist.c:240:27: error: invalid type argument of '->' (have 'struct hist_entry')
# #| util/hist.c:241:23: error: invalid type argument of '->' (have 'struct hist_entry')
do_compile_perf() {
         :
}

do_install_perf() {
         :
}
do_package_qa() {
}
SRC_URI[kernel.md5sum] = "10eebcb0178fb4540e2165bfd7efc7ad"
SRC_URI[kernel.sha256sum] = "fa395fec7de633df1cb85b6248b8f35af98380ed128a8bc465fb48bc4d252633"
SRC_URI[stablepatch.md5sum] = "de755877dbd32ed783067987c095c278"
SRC_URI[stablepatch.sha256sum] = "1fb5cb404ab2b2aa57e967a34c2882a9a9df40fa2e4de8c1463f22ac82d5c9bf"
