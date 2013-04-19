SOC_FAMILY = "omap3"
TARGET_ARCH = "arm"
inherit image_types_ubi

#require conf/machine/include/tune-cortexa9.inc
#require conf/machine/include/tune-cortexa8.inc
require conf/machine/include/tune-cortexa9apollo.inc
PREFERRED_PROVIDER_virtual/kernel ?= "linux-apollo-elmo"
# Increase this everytime you change something in the kernel
MACHINE_KERNEL_PR = "r101"

KERNEL_IMAGETYPE = "uImage"

UBOOT_ENTRYPOINT = "0x80008000"
UBOOT_LOADADDRESS = "0x80008000"

#EXTRA_IMAGEDEPENDS += "u-boot x-load"
#EXTRA_IMAGEDEPENDS += "u-boot"

