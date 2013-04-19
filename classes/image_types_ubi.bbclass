inherit image_types

UBI_VOLNAME = "rootfs"

IMAGEDIR ?= "${MACHINE}"

IMAGE_CMD_ubi_prepend = " \
        cp ${IMAGE_ROOTFS}/boot/update_ruby ${DEPLOY_DIR_IMAGE}/ -a; \
	cp ${IMAGE_ROOTFS}/boot/vmlinux.bin ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.vmlinux.bin -a; \
	gzip -c9 ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.vmlinux.bin > ${IMAGE_NAME}.vmlinux.gz; \
        rm -rf ${IMAGE_ROOTFS}/boot/*; \
"

IMAGE_CMD_ubi_append = " \
	cp ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ubi update_ruby/rootfs.ubi -a; \
	zip -v ${IMAGE_NAME}_update.zip update_ruby/*; \
"
