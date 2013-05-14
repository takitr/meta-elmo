THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATH =. "${@base_set_filespath(["${THISDIR}/${PN}"], d)}:"

PR_append = "ruby"

SRC_URI = "file://LICENSE \
           file://serial-getty@.service"

