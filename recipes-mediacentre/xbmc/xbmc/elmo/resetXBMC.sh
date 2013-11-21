#!/bin/sh

if [ -e /config/resetXBMC ]
then
        rm -rf /mnt/hdd0/program/.xbmc/*
        rm /config/resetXBMC
fi

