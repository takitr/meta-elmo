#require linux.inc
#Configuration in linux.inc

SECTION = "kernel"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel siteinfo

DESCRIPTION = "Linux kernel for Krome processors"
KERNEL_IMAGETYPE = "vmlinux"

COMPATIBLE_MACHINE = "(garnet)"

PR = "r0"
PV = "2.6.34"

MODULE = "linux-2.6.34"
KERNEL_VERSION = "2.6.34"


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

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.34.tar.bz2;name=kernel \
				file://100-arm-linux.patch;apply=yes;striplevel=1 \
				file://101-apollo_stb.patch;apply=yes;striplevel=1 \
				file://102-unionfs-2.5.4.patch;apply=yes;striplevel=1 \
				file://103-apollo_usb.patch;apply=yes;striplevel=1 \
				file://104-apollo_spi_callbackfix.patch;apply=yes;striplevel=1 \
				file://105-apollo_sata_fuse_fix.patch;apply=yes;striplevel=1 \
				file://106-kronos_stb.patch;apply=yes;striplevel=1 \
				file://107-apollo_linux_warning_fix.patch;apply=yes;striplevel=1 \
				file://108-apollo_spi_dmac_rf4cefix.patch;apply=yes;striplevel=1 \
				file://109-apollo_serialwrapperfix.patch;apply=yes;striplevel=1 \
				file://110-apollo_sfc_div_u64_fix.patch;apply=yes;striplevel=1 \
				file://111-apollo_mtd_define_fix.patch;apply=yes;striplevel=1 \
				file://112-apollo_usb_code_from_28kernel.patch;apply=yes;striplevel=1 \
				file://113-apollo_active_standby.patch;apply=yes;striplevel=1 \
				file://114-apollo_sfc32M.patch;apply=yes;striplevel=1 \
				file://115-apollo_sfc_jffs2_fix.patch;apply=yes;striplevel=1 \
				file://116-apollo_ip3106_kgdb.patch;apply=yes;striplevel=1 \
				file://117-apollo_sfc_jffs2_32M.patch;apply=yes;striplevel=1 \
				file://118-apollo_syscall.patch;apply=yes;striplevel=1 \
				file://119-apollo_perf_events.patch;apply=yes;striplevel=1 \
				file://120-apollo_cortexa9_errata.patch;apply=yes;striplevel=1 \
				file://121-apollo_bzImage_support.patch;apply=yes;striplevel=1 \
				file://122-apollo_cortexa9_freq_detect.patch;apply=yes;striplevel=1 \
				file://123-apollo_usb_ehci_handlers.patch;apply=yes;striplevel=1 \
				file://124-apollo_iic_greset_fix.patch;apply=yes;striplevel=1 \
				file://125-apollo-otg_redesign.patch;apply=yes;striplevel=1 \
				file://126-apollo_various_fixes.patch;apply=yes;striplevel=1 \
				file://127-apollo_squashfs_lzma.patch;apply=yes;striplevel=1 \
				file://128-apollo_gcc_4.5_support.patch;apply=yes;striplevel=1 \
				file://129-apollo_kronos_emu.patch;apply=yes;striplevel=1 \
				file://130-apollo_ethernet_AnDSP_changes.patch;apply=yes;striplevel=1 \
				file://131-apollo_thumb2_support.patch;apply=yes;striplevel=1 \
				file://132-apollo-mtd_devices.patch;apply=yes;striplevel=1 \
				file://133-apollo-numonyx_flash.patch;apply=yes;striplevel=1 \
				file://135-apollo-spi_gp500.patch;apply=yes;striplevel=1 \
				file://136-apollo-gpio_apis.patch;apply=yes;striplevel=1 \
				file://137-apollo_chip_rev_detect.patch;apply=yes;striplevel=1 \
				file://138-apollo_sfc_quad_mode.patch;apply=yes;striplevel=1 \
				file://139-apollo_usb_gadget_fshs.patch;apply=yes;striplevel=1 \
				file://140-kronos_i2c.patch;apply=yes;striplevel=1 \
				file://141-apollo_usb_gadget_flag_cleanup.patch;apply=yes;striplevel=1 \
				file://142-kronos_usb.patch;apply=yes;striplevel=1 \
				file://143-apollo_sfc8M.patch;apply=yes;striplevel=1 \
				file://144-nand_pagesize.patch;apply=yes;striplevel=1 \
				file://145-apollo_usb_gadget_plugfest_fixes.patch;apply=yes;striplevel=1 \
				file://146-apollo_usb_no_otg_usbcv_fix.patch;apply=yes;striplevel=1 \
				file://147-apollo_gmac0_rgmii.patch;apply=yes;striplevel=1 \
				file://148-apollo_usb_vid_pid_fix.patch;apply=yes;striplevel=1 \
				file://149-apollo_uart_isr.patch;apply=yes;striplevel=1 \
				file://150-apollo_macronix_sfc_quad_mode.patch;apply=yes;striplevel=1 \
				file://151-apollo_find_next_zero_bit.patch;apply=yes;striplevel=1 \
				file://152-apollo_usb_host_tpl.patch;apply=yes;striplevel=1 \
				file://153-apollo_nand4k.patch;apply=yes;striplevel=1 \
				file://154-apollo_network_config.patch;apply=yes;striplevel=1 \
				file://155-apollo_bzImage_lzma.patch;apply=yes;striplevel=1 \
				file://156-apollo_sdio_pci_support.patch;apply=yes;striplevel=1 \
				file://157-apollo_linux_dvb_extension.patch;apply=yes;striplevel=1 \
				file://158-kronos_bzImage.patch;apply=yes;striplevel=1 \
				file://159-apollo_onfi_nand_support.patch;apply=yes;striplevel=1 \
				file://160-apollo_usb_reset_fix.patch;apply=yes;striplevel=1 \
				file://161-apollo_sfc_macronix_dma.patch;apply=yes;striplevel=1 \
				file://162-apollo_arm_errata.patch;apply=yes;striplevel=1 \
				file://163-apollo_nand_onfi_chipsize.patch;apply=yes;striplevel=1 \
				file://164-kronos_nand.patch;apply=yes;striplevel=1 \
				file://165-kronos_sdio.patch;apply=yes;striplevel=1 \
				file://166-apollo_nand_block_erase_err.patch;apply=yes;striplevel=1 \
				file://167-apollo_mtd_nand_bbt.patch;apply=yes;striplevel=1 \
				file://168-kronos_mmioaddr.patch;apply=yes;striplevel=1 \
				file://169-kronos_gpioconfig.patch;apply=yes;striplevel=1 \
				file://170-kronos_nor_dma_config.patch;apply=yes;striplevel=1 \
				file://171-kronos_usb_bringup.patch;apply=yes;striplevel=1 \
				file://172-kronos_gmac.patch;apply=yes;striplevel=1 \
				file://173-kronos_gpio.patch;apply=yes;striplevel=1 \
				file://174-kronos_sfc_ext_id.patch;apply=yes;striplevel=1 \
				file://175-kronos_l2cache.patch;apply=yes;striplevel=1 \
				file://176-kronos_nand_bringup.patch;apply=yes;striplevel=1 \
				file://177-apollo_uart_dma.patch;apply=yes;striplevel=1 \
				file://178-kronos_sata_bringup.patch;apply=yes;striplevel=1 \
				file://179-kronos_spi_bringup.patch;apply=yes;striplevel=1 \
				file://181-krome_stb.patch;apply=yes;striplevel=1 \
				file://182-kronos_active_stby.patch;apply=yes;striplevel=1 \
				file://183-apollo_sdio_versionfix.patch;apply=yes;striplevel=1 \
				file://184-kronos_sdio_bringup.patch;apply=yes;striplevel=1 \
				file://185-kronos_mmc_subsys_2.6.39.1.patch;apply=yes;striplevel=1 \
				file://186-kronos_rtc.patch;apply=yes;striplevel=1 \
				file://187-kronos_active_standby_irq_fix.patch;apply=yes;striplevel=1 \
				file://188-kronos_sdio_wr_fix.patch;apply=yes;striplevel=1 \
				file://189-apollo_dcs_bus_ntwk_driver.patch;apply=yes;striplevel=1 \
				file://190-apollo_kronos_eth_leak.patch;apply=yes;striplevel=1 \
				file://191-kronos_splash_screen.patch;apply=yes;striplevel=1 \
				file://192-apollo_nand_224B_oob.patch;apply=yes;striplevel=1 \
				file://193-krome_affinity_symbol_export.patch;apply=yes;striplevel=1 \
				file://194-krome_ep_build.patch;apply=yes;striplevel=1 \
				file://195-krome_ep_bringup.patch;apply=yes;striplevel=1 \
				file://196-krome_gmac0_base.patch;apply=yes;striplevel=1 \
				file://197-krome_active_stby.patch;apply=yes;striplevel=1 \
				file://198-krome_sdio_bringup.patch;apply=yes;striplevel=1 \
				file://199-krome_a9_clk_fix.patch;apply=yes;striplevel=1 \
				file://200-krome_dualcore.patch;apply=yes;striplevel=1 \
				file://201-mxl_d2f_support.patch;apply=yes;striplevel=1 \
				file://202-kronos_krome_nand_ecc.patch;apply=yes;striplevel=1 \
				file://203-krome_uart_fix.patch;apply=yes;striplevel=1 \
				file://204-kronos-krome_sfc_quadread.patch;apply=yes;striplevel=1 \
				file://205-krome_gmac_timer_fix.patch;apply=yes;striplevel=1 \
				file://206-apollo_gpl_header.patch;apply=yes;striplevel=1 \
				file://207-krome_gpio.patch;apply=yes;striplevel=1 \
				file://208-sfc_micron_quad_mode.patch;apply=yes;striplevel=1 \
				file://209-i2c_locking.patch;apply=yes;striplevel=1 \
				file://210-kronos_sddata4_7_pins_disable.patch;apply=yes;striplevel=1 \
				file://211-nand_oob_write.patch;apply=yes;striplevel=1 \
				file://212-kronos-krome_detect_arm_freq.patch;apply=yes;striplevel=1 \
				file://213-kronos-krome_nand_224oob.patch;apply=yes;striplevel=1 \
				file://214-kronos-krome_vmalloc_increase.patch;apply=yes;striplevel=1 \
				file://215-kronos_active_standby_fix.patch;apply=yes;striplevel=1 \
				file://216-krome_sdio_cdwp_cfg.patch;apply=yes;striplevel=1 \
				file://217-kronos-krome_nand_read_uldr.patch;apply=yes;striplevel=1 \
				file://218-kronos-krome_highmem_support.patch;apply=yes;striplevel=1 \
				file://219-kronos-krome_rev.patch;apply=yes;striplevel=1 \
				file://220-kronos-krome_max_vmalloc_area.patch;apply=yes;striplevel=1 \
				file://221-kronos-krome_gmac_lnkstatusint.patch;apply=yes;striplevel=1 \
				file://222-kronos_print_cortexa9_freq.patch;apply=yes;striplevel=1 \
				file://223-apollo_sata_coherency_issue_fix.patch;apply=yes;striplevel=1 \
				file://224-kronosrevb_krome_splash.patch;apply=yes;striplevel=1 \
				file://225-krome-balboa.patch;apply=yes;striplevel=1 \
				file://226-krome_print_arm_freq.patch;apply=yes;striplevel=1 \
				file://227-sd_fallback_normalspeed.patch;apply=yes;striplevel=1 \
				file://228-kronos-krome_8k_nand.patch;apply=yes;striplevel=1 \
				file://229-splashlogo_sfc_mx_spi.patch;apply=yes;striplevel=1 \
				file://230-splashlogo.patch;apply=yes;striplevel=1 \
				file://231-krome_spi_fix.patch;apply=yes;striplevel=1 \
				file://232-krome_gmac_fix.patch;apply=yes;striplevel=1 \
				file://krome_stb597_debug_defconfig \
				file://krome_stb597_defconfig \
				file://krome_stb597_mc_debug_defconfig \
				file://krome_stb597_mc_defconfig \
				file://krome_stb597_mc_highmem_debug_defconfig \
			"




#			${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/longterm/v2.6.34/patch-${PV}.8.bz2;apply=yes;name=stablepatch \

S = "${WORKDIR}/linux-2.6.34"

#inherit kernel
EXTRA_OEMAKE = "${PARALLEL_MAKE} "

do_configure() {
        oe_machinstall -m 0644 ${WORKDIR}/defconfig_wireless.systemd.linuxtv ${S}/.config
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
        gzip ${D}/boot/vmlinux
	oe_runmake headers_install INSTALL_HDR_PATH=${D}${exec_prefix}/src/linux-${KERNEL_VERSION} ARCH=$ARCH
}
#do_configure_prepend() {
#	install -m 0644 ${WORKDIR}/pnx8473_dvbs2_debug_defconfig ${S}/.config
#	yes '' | oe_runmake oldconfig
#}

#do_install_append() {
#	${OBJCOPY} -O binary -R .note.gnu.build-id ${S}/vmlinux ${S}/vmlinux.bin
#}
PACKAGES =+ "kernel-headers"
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
