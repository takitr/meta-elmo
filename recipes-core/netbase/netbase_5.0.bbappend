THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATH =. "${@base_set_filespath(["${THISDIR}/${PN}"], d)}:"

PR="ruby-r1"

SRC_URI += "file://interfaces.ruby "

do_install_append () {
    mkdir ${D}/etc/network/ -p
    cp ${WORKDIR}/interfaces.ruby ${D}/etc/network/interfaces -a
}

