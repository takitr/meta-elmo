#for FILESPATH update
THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATH =. "${@base_set_filespath(["${THISDIR}/${PN}"], d)}:"

SRC_URI += " \
	file://dummythreadafterfork2.patch    \
	file://0000-subprocess-memory-error.patch    \
	"
