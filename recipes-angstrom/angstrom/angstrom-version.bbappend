
PR = "r11"

do_install() {
	install -d ${D}${sysconfdir}

	echo "NAME=Angstrom" > ${D}${sysconfdir}/os-release
	echo "ID=angstrom" >> ${D}${sysconfdir}/os-release
	echo "PRETTY_NAME=The Angstrom Distribution" >> ${D}${sysconfdir}/os-release
	echo "ANSI_COLOR=1;35" >> ${D}${sysconfdir}/os-release
	
}
