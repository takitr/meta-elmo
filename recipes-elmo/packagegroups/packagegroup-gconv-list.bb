DESCRIPTION = "Task for gconv list"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit packagegroup

# for backwards compatibility
RPROVIDES_${PN} += "packagegroup-gconv-list"

RDEPENDS_${PN} = " \
	eglibc-gconv-cp1125 \
	eglibc-gconv-cp1250 \
	eglibc-gconv-cp1251 \
	eglibc-gconv-cp1252 \
	eglibc-gconv-cp1253 \
	eglibc-gconv-cp1254 \
	eglibc-gconv-cp1255 \
	eglibc-gconv-cp1256 \
	eglibc-gconv-cp1257 \
	eglibc-gconv-cp1258 \
	eglibc-gconv-cp737  \
	eglibc-gconv-cp770  \
	eglibc-gconv-cp771  \
	eglibc-gconv-cp772  \
	eglibc-gconv-cp773  \
	eglibc-gconv-cp774  \
	eglibc-gconv-cp775  \
	eglibc-gconv-cp932  \
	eglibc-gconv-utf-32 \
        eglibc-gconv-euc-kr \
        eglibc-gconv-big5   \
        eglibc-gconv-big5hkscs  \
        eglibc-gconv-iso8859-2  \
        eglibc-gconv-iso8859-3  \
        eglibc-gconv-iso8859-4  \
        eglibc-gconv-iso8859-5  \
        eglibc-gconv-iso8859-6  \
        eglibc-gconv-iso8859-7  \
        eglibc-gconv-iso8859-8  \
        eglibc-gconv-iso8859-9  \
        eglibc-gconv-iso8859-11 \
        eglibc-gconv-gbk        \
        eglibc-gconv-euc-jp     \
"
