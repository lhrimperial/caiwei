####多数据源 1主2从

     datasource:
      #从库数量
      readSize: 2
       # 使用druid数据源
      type: com.alibaba.druid.pool.DruidDataSource
      #主库
      write:
        url: jdbc:mysql://localhost:3306/master?useUnicode=true&characterEncoding=utf-8
        username: root
        password: root
        driver-class-name: com.mysql.jdbc.Driver
        filters: stat
        maxActive: 20
        initialSize: 1
        maxWait: 60000
        minIdle: 1
        timeBetweenEvictionRunsMillis: 60000
        minEvictableIdleTimeMillis: 300000
        validationQueryTimeout: 900000
        validationQuery: SELECT SYSDATE() from dual
        testWhileIdle: true
        testOnBorrow: false
        testOnReturn: false
        poolPreparedStatements: true
        maxOpenPreparedStatements: 20
      read1:
        url: jdbc:mysql://localhost:3306/slave1?useUnicode=true&characterEncoding=utf-8
        username: root
        password: root
        driver-class-name: com.mysql.jdbc.Driver
        filters: stat
        maxActive: 20
        initialSize: 1
        maxWait: 60000
        minIdle: 1
        timeBetweenEvictionRunsMillis: 60000
        minEvictableIdleTimeMillis: 300000
        validationQueryTimeout: 900000
        validationQuery: SELECT SYSDATE() from dual
        testWhileIdle: true
        testOnBorrow: false
        testOnReturn: false
        poolPreparedStatements: true
        maxOpenPreparedStatements: 20
      read2:
        url: jdbc:mysql://localhost:3306/slave2?useUnicode=true&characterEncoding=utf-8
        username: root
        password: root
        driver-class-name: com.mysql.jdbc.Driver
        filters: stat
        maxActive: 20
        initialSize: 1
        maxWait: 60000
        minIdle: 1
        timeBetweenEvictionRunsMillis: 60000
        minEvictableIdleTimeMillis: 300000
        validationQueryTimeout: 900000
        validationQuery: SELECT SYSDATE() from dual
        testWhileIdle: true
        testOnBorrow: false
        testOnReturn: false
        poolPreparedStatements: true
        maxOpenPreparedStatements: 20