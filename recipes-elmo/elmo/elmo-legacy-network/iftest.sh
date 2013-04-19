while true
do 
	if [ -e /mtmp/iftest_eth0 ]
	then
		echo ifdown.....
		ifdown eth0
		sleep 1
		ifdown ra0
		sleep 1
		echo ifup ......
		ifup eth0
		echo done....
		rm /mtmp/iftest_eth0
	fi
	
	if [ -e /mtmp/iftest_ra0 ]
	then
		echo ifdown.....
		ifdown eth0
		sleep 1
		ifdown ra0
		echo ifup ......
		ifup ra0
		echo done....
		rm /mtmp/iftest_ra0
	fi
	
	if [ -e /mtmp/iftest_wlan0 ]
	then
		echo ifdown.....
		ifdown eth0
		ifdown ra0
		ifdown wlan0
		ifdown wlan1
		echo ifup ......
		ifup wlan0
		echo done....
		rm /mtmp/iftest_wlan0
	fi
	
	if [ -e /mtmp/iftest_ra0_down ]
	then
		echo ifdown ra0....
		ifdown ra0
		echo done.....
		rm /mtmp/iftest_ra0_down
	fi
	
	if [ -e /mtmp/iftest_ra0_up ]
	then
		echo ifup ra0......
		ifup ra0
		echo done......
		rm /mtmp/iftest_ra0_up
	fi

echo check.....	
sleep 1
done


