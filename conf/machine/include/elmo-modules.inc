# Kernel Modules
#


KERNEL_WIFI_MODULES = " \
        kernel-module-rt73usb \
        kernel-module-rt2500usb \
        kernel-module-rtl8187 \
        kernel-module-zd1211rw \
        kernel-module-rt73usb \
        kernel-module-zd1211rw \
	r8192cu \
        ${@base_contains("MACHINE_FEATURES", "rt3070-legacy", "", "kernel-module-rt2800usb", d)} \
        "
#	kernel-module-w35und * 	kernel-module-r8192u-usb * 	kernel-module-ath9k-htc * 	kernel-module-prism2-usb * 	kernel-module-r8712u * 	kernel-module-rtl8192cu * 	kernel-module-carl9170 *

