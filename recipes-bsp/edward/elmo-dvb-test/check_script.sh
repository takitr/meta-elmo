#!/bin/sh

trap ":" INT QUIT TSTP

startup() {

  case "$1" in
        *.sh)
                # Source shell script for speed.
                (
                        trap - INT QUIT TSTP
                        scriptname=$1
                        shift
                        . $scriptname
                )
                ;;
        *)
                "$@"
                ;;
  esac
}

if [ ! -e /config/$1-maruapp ]; then
	mkdir /config/$1-maruapp
fi

for i in /config/$1-maruapp/S*
do
	[ ! -f $i ] && continue

	startup $i start
done
