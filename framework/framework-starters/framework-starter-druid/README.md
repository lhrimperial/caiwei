##使用说明
1. 引入依赖

        <dependency>
            <groupId>com.lvmama.boot</groupId>
            <artifactId>lmm-boot-starter-druid</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        
2. 配置说明
>- 配置必须以spring.datasource.作为前缀
>- driver、url、username、password为必填配置
        
- 配置模板
        
        #数据库配置 
        spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
        spring.datasource.url=jdbc:mysql://host:3306/database
        spring.datasource.username=root
        spring.datasource.password=root
        spring.datasource.driver-class-name=com.mysql.jdbc.Driver
        
        #初始化大小，最小，最大
        spring.datasource.initialSize=5
        spring.datasource.minIdle=5
        spring.datasource.maxActive=20
        
        #配置获取连接等待超时的时间
        spring.datasource.maxWait=60000
        
        #配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        spring.datasource.timeBetweenEvictionRunsMillis=60000
        
        #配置一个连接在池中最小生存的时间，单位是毫秒
        spring.datasource.minEvictableIdleTimeMillis=300000
        
        spring.datasource.validationQuery=SELECT 1 FROM DUAL
        spring.datasource.testWhileIdle=true
        spring.datasource.testOnBorrow=false
        spring.datasource.testOnReturn=false
        
        #打开PSCache，并且指定每个连接上PSCache的大小
        spring.datasource.poolPreparedStatements=true
        spring.datasource.maxPoolPreparedStatementPerConnectionSize=20
        
        #配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
        spring.datasource.filters=stat,wall,log4j
        
        #通过connectProperties属性来打开mergeSql功能；慢SQL记录
        spring.datasource.connectionProperties=druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000
        
        #合并多个DruidDataSource的监控数据
        spring.datasource.useGlobalDataSourceStat=true
        
        # StatViewServlet 监控配置
        spring.datasource.statViewServlet.loginUsername=admin
        spring.datasource.statViewServlet.loginPassword=admin
        spring.datasource.statViewServlet.urlPattern=/druid/*
        spring.datasource.statViewServlet.allow=IP
        spring.datasource.statViewServlet.deny=IP
        spring.datasource.statViewServlet.resetEnable=true
        spring.datasource.statViewServlet.enabled=true
        
        # WebStatFilter 配置
        spring.datasource.WebStatFilter.enabled=true
        spring.datasource.WebStatFilter.urlPattern=/*
        spring.datasource.WebStatFilter.exclusions=*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*
        spring.datasource.WebStatFilter.sessionStatMaxCount=
        spring.datasource.WebStatFilter.sessionStatEnable=
        spring.datasource.WebStatFilter.principalSessionName=
        spring.datasource.WebStatFilter.principalCookieName=
        spring.datasource.WebStatFilter.profileEnable=