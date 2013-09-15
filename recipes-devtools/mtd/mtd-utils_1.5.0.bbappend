PR .= "-Prismcube"
FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

SRC_URI += "file://mkfs.ubifs-allow-output-file-creation-on-different-device.patch"

PACKAGES_DYNAMIC = "mtd-utils-*"

ALLOW_EMPTY_${PN} = "1"

