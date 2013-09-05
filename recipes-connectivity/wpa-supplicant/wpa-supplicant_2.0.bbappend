THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATH =. "${@base_set_filespath(["${THISDIR}/${PN}"], d)}:"

SRC_URI += "file://wpa_supplicant.conf.legacy"

do_install_append () {
    install -d ${D}${sysconfdir}/wpa_supplicant/ 
    install -m 600 ${WORKDIR}/wpa_supplicant.conf.legacy ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant.conf
}
