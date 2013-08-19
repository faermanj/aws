mkfs.xfs -i size=512 /dev/xvdf
mkdir -p /export/brick1
echo "/dev/xvdf /export/brick1 xfs defaults 1 2" >> /etc/fstab
mount -a && mount
mkdir /export/brick1/xvdf
chkconfig glusterd on
service glusterd start