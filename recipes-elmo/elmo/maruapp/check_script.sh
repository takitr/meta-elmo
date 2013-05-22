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

for i in /app/$1-maruapp/S*
do
	[ ! -f $i ] && continue

	startup $i start
done
