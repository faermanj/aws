mount -t glusterfs node01.yourdomain.net:/gv0 /mnt
for i in `seq -w 1 100`; do cp -rp /var/log/messages /mnt/copy-test-$i; done
