PRINC = "2"

THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATH =. "${@base_set_filespath(["${THISDIR}/${PN}"], d)}:"

SRC_URI += " file://gdk_window_ensure_native.patch;apply=yes;striplevel=1 \
		"
