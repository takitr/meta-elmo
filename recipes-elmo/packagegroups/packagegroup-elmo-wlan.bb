DESCRIPTION = "Task for extra drivers for Elmo ( Ruby )"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit packagegroup
DEPENDS = "linux-apollo-elmo"
RPROVIDES_${PN} += "packagegroup-elmo-wlan"

RDEPENDS_${PN} = "\
  wireless-tools \
  wpa-supplicant \
  kernel-module-tunnel4 \
  kernel-module-psnap \
  kernel-module-p8022 \
  kernel-module-stp \
  kernel-module-8021q \
  kernel-module-bridge \
  kernel-module-pktgen \
  kernel-module-llc \
  kernel-module-hostap \
  kernel-module-libertas \
  kernel-module-ath9k \
  kernel-module-scsi-wait-scan \
  kernel-module-sr-mod \
  kernel-module-p54common \
"

WLAN_CRYPTO_MODULES = "\
   kernel-module-lib80211-crypt-ccmp \
   kernel-module-lib80211-crypt-tkip \
   kernel-module-lib80211-crypt-wep \
"

WLAN_PCI_MODULES = "\
  kernel-module-ath5k \
"

WLAN_USB_MODULES = "\
  rt73-firmware \
  zd1211-firmware \
  r8192cu \
  firmware-htc9271 \
  firmware-rt2561 \
  firmware-rtl8721u \
  ${@base_contains("MACHINE_FEATURES", "rt3070-legacy", "rt3070", "rt2870sta firmware-rt3070 ", d)} \
"

WLAN_USB_MODULES_LEGACY = "\
  zd1211b \
  wlan-rt73 \
  r8712u \
  rt3070 \
  r8192cu \
"

RDEPENDS_${PN}_append = "\
  ${WLAN_CRYPTO_MODULES} \
  ${WLAN_USB_MODULES} \
"

