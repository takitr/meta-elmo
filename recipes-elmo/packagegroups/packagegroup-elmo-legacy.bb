DESCRIPTION = "Task for extra drivers for Elmo ( Ruby )"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit packagegroup

RPROVIDES_${PN} += "packagegroup-elmo-legacy"

RDEPENDS_${PN} = "\
  wireless-tools \
  wpa-supplicant \
  python-wifi \
  elmo-legacy-network \
"


