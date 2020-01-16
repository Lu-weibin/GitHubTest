## 安装与启动（windows）

1. 下载安装Erlang

2. 下载安装rabbitmq

3. 安装管理界面（插件）

   进入安装目录的sbin目录，执行命令`rabbitmq-plugins enable rabbitmq_management`

4. 重新启动服务

5. 访问 `http://127.0.0.1:15672`，即可看到管理登陆页

6. 用户名密码均为 `guest`