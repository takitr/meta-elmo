# Kernel Modules
#


KERNEL_WIFI_MODULES = " \
        kernel-module-ath9k-htc \
        kernel-module-carl9170 \
        kernel-module-prism2-usb \
        kernel-module-rt73usb \
        kernel-module-rt2500usb \
        kernel-module-r8192u-usb \
        kernel-module-rtl8192cu \
        kernel-module-rtl8187 \
        kernel-module-r8712u \
        kernel-module-w35und \
        kernel-module-zd1211rw \
        ${@base_contains("MACHINE_FEATURES", "rt3070-legacy", "", "kernel-module-rt2800usb", d)} \
        "

