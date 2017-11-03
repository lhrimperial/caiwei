####读写分离配置
1. 数据源(application.yml)

        druid:
            type: com.alibaba.druid.pool.DruidDataSource
            master:
                url: jdbc:mysql://192.168.204.128:3306/frame?characterEncoding=UTF-8&autoReconnect=true&zeroDateTimeBehavior=convertToNull&useUnicode=true
                driver-class-name: com.mysql.jdbc.Driver
                username: root
                password: root
                initial-size: 5
                min-idle: 1
                max-active: 100
                test-on-borrow: true
            slave:
                url: jdbc:mysql://192.168.204.129:3306/frame?characterEncoding=UTF-8&autoReconnect=true&zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf-8
                driver-class-name: com.mysql.jdbc.Driver
                username: root
                password: root
                initial-size: 5
                min-idle: 1
                max-active: 100
                test-on-borrow: true

2. Mybatis配置
        
        mybatis.configLocation=
        mybatis.basePackage=
        mybatis.mapperLocations=
        
        
####MySQL 主从复制配置
1. 创建复制帐号
在Master的数据库中建立一个备份帐户：每个slave使用标准的MySQL用户名和密码连接master。进行复制操作的用户会授予REPLICATION SLAVE权限。用户名的密码都会存储在文本文件master.info中
命令如下：
`mysql > GRANT REPLICATION SLAVE,RELOAD,SUPER ON *.* TO backup@’192.168.157.130’ IDENTIFIED BY ‘backup’;`
建立一个帐户backup，并且只能允许从192.168.157.130这个地址上来登陆，密码是backup。

2. 拷贝数据
（假如是你完全新安装mysql主从服务器，这个一步就不需要。因为新安装的master和slave有相同的数据）
关停Master服务器，将Master中的数据拷贝到B服务器中，使得Master和slave中的数据同步，并且确保在全部设置操作结束前，禁止在Master和slave服务器中进行写操作，使得两数据库中的数据一定要相同！

3. 配置master
接下来对master进行配置，包括打开二进制日志，指定唯一的servr ID。例如，在配置文件加入如下值：

        [mysqld]
        server_id=1
        log_bin=mysql-bin
server_id：为主服务器A的ID值
log_bin：二进制变更日值
重启master，运行SHOW MASTER STATUS，输出如下：

>有时候server_id不生效，通过 SHOW VARIABLES LIKE 'server_id';查看，可以重新设置


4. 配置slave
Slave的配置与master类似，你同样需要重启slave的MySQL。如下：

        log_bin           = mysql-bin
        server_id         = 2
        relay_log         = mysql-relay-bin
        log_slave_updates = 1
        read_only         = 1
    server_id是必须的，而且唯一。slave没有必要开启二进制日志，但是在一些情况下，必须设置，例如，如果slave为其它slave的master，必须设置bin_log。在这里，我们开启了二进制日志，而且显示的命名(默认名称为hostname，但是，如果hostname改变则会出现问题)。
relay_log配置中继日志，log_slave_updates表示slave将复制事件写进自己的二进制日志(后面会看到它的用处)。
有些人开启了slave的二进制日志，却没有设置log_slave_updates，然后查看slave的数据是否改变，这是一种错误的配置。所以，尽量使用read_only，它防止改变数据(除了特殊的线程)。但是，read_only并是很实用，特别是那些需要在slave上创建表的应用。

5. 启动slave
接下来就是让slave连接master，并开始重做master二进制日志中的事件。你不应该用配置文件进行该操作，而应该使用CHANGE MASTER TO语句，该语句可以完全取代对配置文件的修改，而且它可以为slave指定不同的master，而不需要停止服务器。如下：

        change master to master_host='192.168.157.129',
            -> master_user='backup',
            -> master_password='backup',
            -> master_log_file='mysql-bin.000003',
            -> master_log_pos=0;
MASTER_LOG_POS的值为0，因为它是日志的开始位置。
你可以用SHOW SLAVE STATUS语句查看slave的设置是否正确：
mysql> SHOW SLAVE STATUS\G
	
	*************************** 1. row ***************************
	             Slave_IO_State:
	                Master_Host: server1
	                Master_User: repl
	                Master_Port: 3306
	              Connect_Retry: 60
	            Master_Log_File: mysql-bin.000001
	        Read_Master_Log_Pos: 4
	             Relay_Log_File: mysql-relay-bin.000001
	              Relay_Log_Pos: 4
	      Relay_Master_Log_File: mysql-bin.000001
	           Slave_IO_Running: No
	          Slave_SQL_Running: No
	                             ...omitted...
	      Seconds_Behind_Master: NULL

Slave_IO_State, Slave_IO_Running, 和Slave_SQL_Running是No
表明slave还没有开始复制过程。日志的位置为4而不是0，这是因为0只是日志文件的开始位置，并不是日志位置。实际上，MySQL知道的第一个事件的位置是4。
为了开始复制，你可以运行：
mysql> START SLAVE;
运行SHOW SLAVE STATUS查看输出结果：
mysql> SHOW SLAVE STATUS\G

	*************************** 1. row ***************************
             Slave_IO_State: Waiting for master to send event
                Master_Host: server1
                Master_User: repl
                Master_Port: 3306
              Connect_Retry: 60
            Master_Log_File: mysql-bin.000001
        Read_Master_Log_Pos: 164
             Relay_Log_File: mysql-relay-bin.000001
              Relay_Log_Pos: 164
      Relay_Master_Log_File: mysql-bin.000001
           Slave_IO_Running: Yes
          Slave_SQL_Running: Yes
                             ...omitted...
      Seconds_Behind_Master: 0

在这里主要是看:
                  
	Slave_IO_Running=Yes
	Slave_SQL_Running=Yes
slave的I/O和SQL线程都已经开始运行，而且Seconds_Behind_Master不再是NULL。日志的位置增加了，意味着一些事件被获取并执行了。如果你在master上进行修改，你可以在slave上看到各种日志文件的位置的变化，同样，你也可以看到数据库中数据的变化。