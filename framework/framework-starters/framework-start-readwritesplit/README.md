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