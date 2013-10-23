inherit image_types

UBI_VOLNAME = "rootfs"

IMAGEDIR ?= "${MACHINE}"

IMAGE_CMD_ubi_prepend = " \
	rm -rf ${DEPLOY_DIR_IMAGE}/update_ruby ; \
        cp ${IMAGE_ROOTFS}/boot/update_ruby ${DEPLOY_DIR_IMAGE}/ -a; \
	cp ${IMAGE_ROOTFS}/boot/vmlinux.bin ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.vmlinux.bin -a; \
	gzip -c9 ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.vmlinux.bin > ${IMAGE_NAME}.vmlinux.gz; \
	uboot-mkimage -A ${TARGET_ARCH} -O linux -T kernel -C gzip -a ${UBOOT_LOADADDRESS} -e ${UBOOT_ENTRYPOINT} -n "uImage" -d ${IMAGE_NAME}.vmlinux.gz kernel.uImage; \
	cp kernel.uImage update_ruby/kernel.uImage -a; \
	rm -rf ${IMAGE_ROOTFS}/boot/*; \
"

IMAGE_CMD_ubi_append = " \
	cp ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ubi update_ruby/rootfs.rootfs.ubi -a; \
	cp ${DEPLOY_DIR_IMAGE}/${UBOOT_IMAGE} update_ruby/u-boot.bin -a; \
	md5sum update_ruby/u-boot.bin > update_ruby/u-boot.bin.md5; \
	md5sum update_ruby/kernel.uImage > update_ruby/kernel.uImage.md5; \
	md5sum update_ruby/rootfs.rootfs.ubi > update_ruby/rootfs.rootfs.ubi.md5; \
	zip -v ${IMAGE_NAME}_update.zip update_ruby/*; \
"
