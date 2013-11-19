# /etc/network/interfaces -- configuration file for ifup(8), ifdown(8)
 
# The loopback interface
auto lo
iface lo inet loopback
# Wireless interfaces
#
# Example of an unencrypted (no WEP or WPA) wireless connection
# that connects to any available access point:
#
#auto wlan0
iface wlan0 inet dhcp
	pre-up wpa_supplicant -iwlan0 -c /etc/wpa_supplicant/wpa_supplicant.conf -B -Dwext
        post-down wpa_cli terminate
	#wireless_mode managed
	#wireless_essid any

#auto wlan1
iface wlan1 inet dhcp
	pre-up wpa_supplicant -iwlan1 -c /etc/wpa_supplicant/wpa_supplicant.conf -B -Dwext
        post-down wpa_cli terminate

#auto wlan2
iface wlan2 inet dhcp
	pre-up wpa_supplicant -iwlan2 -c /etc/wpa_supplicant/wpa_supplicant.conf -B -Dwext
        post-down wpa_cli terminate

#auto wlan3
iface wlan3 inet dhcp
	pre-up wpa_supplicant -iwlan3 -c /etc/wpa_supplicant/wpa_supplicant.conf -B -Dwext
        post-down wpa_cli terminate

#auto ra0
iface ra0 inet dhcp
	pre-up wpa_supplicant -ira0 -c /etc/wpa_supplicant/wpa_supplicant.conf -B -Dwext
        post-down wpa_cli terminate
#
# Same as above but locked to a specific access point:
#
#iface wlan0 inet dhcp  
#	wireless_mode managed
#	wireless-essid some-essid
#
# A WEP encrypted connection locked to a specific access point:
#
#iface wlan0 inet dhcp  
#	wireless-essid some-essid
#	wireless-key s:My-PlainText-Password
#	wireless-mode managed                  
#
# A WPA1 or WPA2 encrypted connection locked to a specific access point.
# This is the best option for non-roaming, single-network usage.
# Note that your card may require a firmware update to use WPA. 
# Some distributions install a temporary volatile firmware update on ifup.
#
#iface wlan0 inet dhcp                                                   
#	wpa-essid some-essid                                          
#	wpa-psk My-PlainText-Password                                              
#
# A WPA1 or WPA2 encrypted connection using an external configuration file
# for wpa-supplicant. This is the way to go if you need to configure multiple
# networks with different keys and / or WPA settings and roaming support.
#
# iface wlan0 inet dhcp
#    wpa-conf /etc/wpa_supplicant.conf
#    wpa-driver hostap



iface atml0 inet dhcp

# Wired or wireless interfaces
auto eth0
iface eth0 inet dhcp
iface eth1 inet dhcp

# Ethernet/RNDIS gadget (g_ether) or LAN9514
auto usb0
iface usb0 inet dhcp

# Bluetooth networking
iface bnep0 inet dhcp

