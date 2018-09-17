
### 关于文件命令
上传文件命令： `rz -by`
创建文件夹：  `mkdir`
创建文件：  `touch`

### 关于端口命令
添加端口
firewall-cmd --zone=public --add-port=80/tcp --permanent
重启防火墙
firewall-cmd  --reload

### 关于硬盘空间的命令
`df -lh`
用df 命令查看查看目录所在分区, 例如查看/root目录所在分区
`df -h /root`

nohup java -jar xxx.jar&命令，则程序会在后台一直运行，


