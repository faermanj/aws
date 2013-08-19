gluster peer probe <other>
gluster volume create gv0 replica 2 node01.mydomain.net:/export/brick1/sdb1 node02.mydomain.net:/export/brick1/sdb1
gluster volume start gv0
