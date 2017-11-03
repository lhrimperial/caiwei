# caiwei
#### 一、项目结构

    -caiwei
        -channel            //渠道
            -weixin         //微信渠道（公众号、小程序。。）
                +applet
                +wechat
        -framework          //框架集成
            -archetype      //集成骨架
            +common         //业务无关组件封装
            -dependence     //三方JAR统一版本管理
            -starters       //springboot集成
                +readwritesplit //读写分离集成
                +druid      //Druid数据源集成
                +multi-datasource   //多数据源集成
                +mybatis    //mybatis集成
            -test           //集成测试
            -util           //工具封装
            
            
#### 二、使用说明
1. druid和mybatis使用
[配置说明](https://github.com/lhrimperial/caiwei/blob/master/framework/framework-starters/framework-starter-druid/README.md)
2. 读写分离
[配置说明](https://github.com/lhrimperial/caiwei/blob/master/framework/framework-starters/framework-start-readwritesplit/README.md)
3. 多数据源
[配置说明](https://github.com/lhrimperial/caiwei/blob/master/framework/framework-starters/framework-starter-multi-datasource/README.md)

            
            
        
