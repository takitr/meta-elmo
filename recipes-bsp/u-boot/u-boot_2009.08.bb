PR = "r2"
require u-boot.inc

DEPENDS = "mtd-utils u-boot-hw-header"

DEFAULT_PREFERENCE = "-1"
LIC_FILES_CHKSUM="file://COPYING;md5=4c6cde5df68eff615d36789dc18edd3b"
SRC_URI = "\
    ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2 \
"

#    file://dont-inline-weak-symbols.patch \

UBOOT_MACHINE = "vpe_apollo_config"

SRC_URI_append_elmo = " \
        file://100-u-boot_apollo_R1.4.patch;apply=yes;striplevel=1 \
        file://101-apollo_stb_r1.4.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_alpha2.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_network.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_mysti.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_nor.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_timer.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_cleanmarker.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_flash_map.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_appfs.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_phy_autodetect.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_nandenv.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_nand_trace.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_bootfile_len.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_bootm_lzma.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_mtdparts.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_sfc.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_uartboot.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_apollo_m1.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_altsfc.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_compile_fix.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_memcpy.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_perf_improvement.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_hdcp_key.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_nand_gcs.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_uart_config_sfc32M.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_nand2.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_sfc_jffs2_fix.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_sfc_lockup_fix.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_sfc_timout.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_nand_output.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_gcs_reset.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_bootm_perf.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_env_fix.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_mtdparts_fix.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_kal.patch;apply=yes;striplevel=1 \
        file://apollo_sfc_quad_mode.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_usb.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_gcc_4.5_support.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_thumb_kernel.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_numonyx.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_usb_filesize.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_nfs_timeout.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_timer_auto_reload.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_nand_pagesize.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_sfc8M.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_nand_pagesize2.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_gmac0_rgmii.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_formatting.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_flash_write_size.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_gcs_headers.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_nand_4k.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_sfc_macronix_dma.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_nandwrite_ubi.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_nand_erase.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_new_spi_flash.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_nand_TC58NVG0S3EBAI4.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_splash_update.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_ubiparam.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_envforuimage.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_usb_storage.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_cmdline.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_mkupdate_splash_env_watchdog.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_update_check.patch;apply=yes;striplevel=1 \
        file://apollo_stb_r1.4_env_range.patch;apply=yes;striplevel=1 \
           "


TARGET_LDFLAGS = ""

inherit base

do_compile () {
       export _TMROOT=${STAGING_INCDIR}
       export _TMTGTBUILDROOT=${STAGING_INCDIR}
       export STB_HW_CONFIG=elmo
       export STB_SW_CONFIG=bare
       oe_runmake ${UBOOT_MACHINE}
       oe_runmake all
}

#must be override
do_deploy () {
        install -d ${DEPLOY_DIR_IMAGE}
        install ${S}/${UBOOT_BINARY} ${DEPLOY_DIR_IMAGE}/${UBOOT_IMAGE}
        #package_stagefile_shell ${DEPLOY_DIR_IMAGE}/${UBOOT_IMAGE}

        #cd ${DEPLOY_DIR_IMAGE}
        #rm -f ${UBOOT_SYMLINK}
        #ln -sf ${UBOOT_IMAGE} ${UBOOT_SYMLINK}
        #package_stagefile_shell ${DEPLOY_DIR_IMAGE}/${UBOOT_SYMLINK}
}


SRC_URI[md5sum] = "cd4788ea1c6ac4f9b100b888a1063a6b"
SRC_URI[sha256sum] = "858fd04efd5b98e99fd1a074998b1a8ac5fbd07b176de1d20d8eb148492d949d"
