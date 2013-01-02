# apollo platform has no neon unit
#original
#TARGET_CC_ARCH = "-march=armv7-a -mtune=cortex-a9 -mfpu=vfpv3-d16 -mfloat-abi=softfp"
#BASE_PACKAGE_ARCH = "armv7a"
#FEED_ARCH = "armv7a"
#PACKAGE_EXTRA_ARCHS += "armv4 armv4t armv5te armv6 armv7 armv7a armv7a-vfp"

DEFAULTTUNE ?= "cortexa9"

require conf/machine/include/arm/arch-armv7a.inc

TUNEVALID[cortexa9] = "Enable Cortex-A9 specific processor optimizations"
TUNE_CCARGS += "${@bb.utils.contains("TUNE_FEATURES", "cortexa9", "-march=armv7-a -mtune=cortex-a9 -mfpu=vfpv3-d16 -mfloat-abi=softfp", "", d)}"

# Little Endian base configs
AVAILTUNES += "cortexa9"
TUNE_FEATURES_tune-cortexa9 = "${TUNE_FEATURES_tune-armv7a} cortexa9"
PACKAGE_EXTRA_ARCHS_tune-cortexa9 = "${PACKAGE_EXTRA_ARCHS_tune-armv7a}"

# VFP Tunes
AVAILTUNES += "cortexa9hf cortexa9thf cortexa9hf-neon"
TUNE_FEATURES_tune-cortexa9hf ?= "${TUNE_FEATURES_tune-armv7ahf} cortexa9"
TUNE_FEATURES_tune-cortexa9thf ?= "${TUNE_FEATURES_tune-armv7athf} cortexa9"
TUNE_FEATURES_tune-cortexa9hf-neon ?= "${TUNE_FEATURES_tune-armv7ahf-neon} cortexa9"
PACKAGE_EXTRA_ARCHS_tune-cortexa9hf = "${PACKAGE_EXTRA_ARCHS_tune-armv7ahf}"
PACKAGE_EXTRA_ARCHS_tune-cortexa9thf = "${PACKAGE_EXTRA_ARCHS_tune-armv7athf}"
PACKAGE_EXTRA_ARCHS_tune-cortexa9hf-neon = "${PACKAGE_EXTRA_ARCHS_tune-armv7ahf-neon}"
