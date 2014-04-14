DESCRIPTION="AiO screenshot grabber"
MAINTAINER = "Black Hole team"
LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"
 
DEPENDS = "jpeg libpng zlib"
#LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"
 
PV = "1.0"
PR = "r3"
SRCREV = "8cbda477e73b2d8647810450aef98e7ad2323159"
BRANCH = "prismcube"

SRC_URI = "git://git.prismcube-community.net/git/blackhole/aio-grab.git;protocol=http;branch=${BRANCH};tag=${SRCREV}"

S = "${WORKDIR}/git"

inherit autotools

#FILES_${PN} = "/"

CFLAGS += "-DMACH_ELMO=1"

