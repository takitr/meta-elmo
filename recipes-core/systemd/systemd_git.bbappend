THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATH =. "${@base_set_filespath(["${THISDIR}/${PN}"], d)}:"


SRC_URI += 	" \
		file://0001-patch-for-oom_score_adj.patch \
		"
