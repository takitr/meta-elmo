FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

PR = "ruby_r1"

SRC_URI += "file://1000-Fixed-resolve-query-error.patch;striplevel=2"
