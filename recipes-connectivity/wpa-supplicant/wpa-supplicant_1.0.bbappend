THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATH =. "${@base_set_filespath(["${THISDIR}/${PN}"], d)}:"

SRC_URI += "file://wpa_supplicant.conf.legacy"

do_install_append () {
    mkdir ${D}/etc/wpa_supplicant/ -p
    cp ${WORKDIR}/wpa_supplicant.conf.legacy ${D}/etc/wpa_supplicant/wpa_supplicant.conf -a
}
