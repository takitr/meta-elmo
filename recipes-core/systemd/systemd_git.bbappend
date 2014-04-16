THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATH =. "${@base_set_filespath(["${THISDIR}/${PN}"], d)}:"

DEPENDS += "e2fsprogs"

SRC_URI += 	" \
		file://0001-patch-for-oom_score_adj.patch \
		file://0003-patch-for-header-version.patch \
		file://journald.conf  \
		"
do_install_append(){
	install -d ${D}/etc/systemd
	cp ${WORKDIR}/journald.conf ${D}/etc/systemd/ -a
}

RRECOMMENDS_${PN}-analyze = ""

