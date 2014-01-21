THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATH =. "${@base_set_filespath(["${THISDIR}/${PN}"], d)}:"

inherit systemd
PR = "ruby-r1"

SRC_URI +="file://connman.service_for_ruby.patch;strip=1;apply=yes"

PRINC := "${@int(PRINC) + 1}"

EXTRA_OECONF += "--with-systemdunitdir=${systemd_unitdir}/system/"

SYSTEMD_PACKAGES = "${PN}-systemd"
SYSTEMD_SERVICE_${PN}-systemd = "connman.service"
