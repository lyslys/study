上传文件命令： `rz -by`

添加端口
firewall-cmd --zone=public --add-port=80/tcp --permanent
重启防火墙
firewall-cmd  --reload

nohup java -jar xxx.jar&命令，则程序会在后台一直运行，
