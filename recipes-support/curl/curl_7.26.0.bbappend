THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATH =. "${@base_set_filespath(["${THISDIR}/${PN}"], d)}:"


PR = "ruby_r1"

SRC_URI += "file://youtube-seek.patch"

