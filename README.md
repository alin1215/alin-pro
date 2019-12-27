# alin-pro
纯手写的一个权限控制系统。
整体的框架是springboot+mybatisplus+druid。这里提醒下，druid+mybatisplus插件有个不兼容，主要是针对的时间类，坐等druid更新。也是因为这个原因，后续去掉了druid的数据连接池，转而用原生的数据库连接池。

jta-atomikos项目，支持对数据源，分布式事务。

master-slave项目，支持数据库读写分离，开启事务后，只有在master的数据源上起作用。
