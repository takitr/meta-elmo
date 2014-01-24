set loadaddr 0x28000000
nand read update

if test $ldver < 4
	then display_strings "bootloader is lower than v1.0.4"
	display_strings "updating bootloader..."
	set loadaddr 0x28100080
	nand erase uldr
	nand write uldr 
        set mtdparts 'mtdparts=nx_2017:1024k@0k(uldr),1792k@1024k(u-boot),20m@3m(configure),6m@23m(kernel),350m@29m(root),45m@381m(update),5m@426m(uImage),35m@431m(ramdisk),-(extra)'
        set nandparts 'mtdparts=nx_2017:1024k@0k(uldr),1792k@1024k(u-boot),20m@3m(configure),6m@23m(kernel),350m@29m(root),45m@381m(update),5m@426m(uImage),35m@431m(ramdisk),-(extra)'
	set loadaddr 0x28200080
	nand erase u-boot
	nand write u-boot 0x180000
	set ldver 4
	display_strings "restarting box..."
	saveenv
	sleep 5
	reset
else
	cleare_display_strings
	display_strings "starting update..."
        set mtdparts 'mtdparts=nx_2017:1024k@0k(uldr),1792k@1024k(u-boot),20m@3m(configure),6m@23m(kernel),350m@29m(root),45m@381m(update),5m@426m(uImage),35m@431m(ramdisk),-(extra)'
        set nandparts 'mtdparts=nx_2017:1024k@0k(uldr),1792k@1024k(u-boot),20m@3m(configure),6m@23m(kernel),350m@29m(root),45m@381m(update),5m@426m(uImage),35m@431m(ramdisk),-(extra)'
	mtenv 28100040 4 uldrsize 0
	mtenv 28100044 4 ubootsize 0
	mtenv 28100048 4 kernelsize 0
	mtenv 2810004c 4 uimagesize 0
	mtenv 28100050 4 ramdisksize 0
	mtenv 28100060 4 uldrstartaddr $loadaddr
	mtenv 28100064 4 ubootstartaddr $loadaddr
	mtenv 28100068 4 kernelstartaddr $loadaddr
	mtenv 2810006c 4 uimagestartaddr $loadaddr
	mtenv 28100070 4 ramstartaddr $loadaddr
	set loadaddr 0x$uldrstartaddr
	nand erase uldr
	nand write uldr
	set loadaddr 0x$ubootstartaddr
	nand erase u-boot
	nand write u-boot 0x$ubootsize
	set ldver 4
	display_strings "updating kernel..."
	set loadaddr 0x$kernelstartaddr
	nand erase kernel
	nand write kernel $kernelsize
	set loadaddr 0x$uimagestartaddr
	nand erase uImage
	nand write uImage $uimagesize
	set loadaddr 0x$ramstartaddr
	nand erase ramdisk
	nand write ramdisk $ramdisksize
	set loadaddr 0x4400000
	set bootargs "noinitrd console=ttyS1,115200n8 ${mtdparts} ubi.mtd=4 root=ubi0:rootfs rootfstype=ubifs rw rootflags=sync"
	set bootcmd 'run nandboot'
	set nandboot "nand read kernel; bootm 0x4400000"
	nand erase update
	saveenv
	set bootargs "console=ttyS1,115200n8 ${mtdparts} root=/dev/ram rw initrd=0x$ramstartaddr,64M  ramdisk_size=65536 init=/sbin/init"
	display_strings "updating root file system..."
	bootm 0x$uimagestartaddr
		
fi
