yum install -y binutils xfsprogs
wget -P /etc/yum.repos.d http://download.gluster.org/pub/gluster/glusterfs/LATEST/EPEL.repo/glusterfs-epel.repo
sed -i 's/$releasever/6/g' /etc/yum.repos.d/glusterfs-epel.repo 
yum install -y glusterfs{-fuse,-server}


