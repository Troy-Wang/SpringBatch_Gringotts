# Gringotts

A batch-processing system based on Spring Boot and Sping Batch.

## Introduction

这是一个基于Spring boot和Spring batch的批处理系统。
你或许可以从这得到：
1. How to construct a simple spring boot system
2. How to integrate spring batch into spring boot
3. How to use most spring batch components (Validator, Partitioner, Listener, etc.)
4. How to make a Mybatis quick start.

## Database configuration

### MysqlServer

1. install mysql server
2. start mysql server
3. log in with *mysql -u root -p*
4.  
```sql
create database gringotts_db CHARACTER SET 'utf8';
create user 'gringotts'@'localhost' IDENTIFIED BY 'gringotts';
grant all privileges on gringotts_db.* to gringotts@localhost;
```

### Tables

首先需要创建Spring Batch所需的表，可以在spring batch的core jar包中找到。

另外，我创建了三张表:
1. **batch\_file\_config** 文件处理配置表，用于配置需要处理的文件，到达expect\_time之后，创建今日的batch\_schedule，然后导出文件至local\_file\_path。我在最后insert了一条示例
2. **batch\_schedule** 批处理调度表，用于记录导出文件的调度情况，每天一个调度，记录调度状态
3. **batch\_detail** 批处理明细表，用于记录导入导出的明细

```sql
CREATE TABLE `batch_file_config` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
`enabled` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '1 - 可用，2 - 不可用',
`item_id` varchar(32) NOT NULL DEFAULT '' COMMENT '产品id',
`schedule_freq` varchar(32) NOT NULL DEFAULT '' COMMENT '调度频率',
`remote_file_path` varchar(256) NOT NULL DEFAULT '' COMMENT '文件远程路径',
`local_file_path` varchar(256) NOT NULL DEFAULT '' COMMENT '文件本地路径',
`expect_time` datetime NOT NULL DEFAULT '2001-01-01 02:00:00' COMMENT '预计处理时间',
`extension` varchar(256) NOT NULL DEFAULT '' COMMENT '扩展信息',
`description` varchar(128) NOT NULL DEFAULT '' COMMENT '配置描述',
`create_time` datetime NOT NULL DEFAULT '2000-00-00 00:00:00' COMMENT '创建时间',
`modify_time` datetime NOT NULL DEFAULT '2000-00-00 00:00:00' COMMENT '修改时间',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='文件配置表';

CREATE TABLE `batch_schedule` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
`enabled` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '1 - 可用，2 - 不可用',
`config_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '配置id',
`schedule_no` varchar(64) NOT NULL DEFAULT '' COMMENT '调度编号',
`schedule_date` varchar(32) NOT NULL DEFAULT '' COMMENT '调度日期',
`schedule_status` varchar(64) NOT NULL DEFAULT '' COMMENT '批次状态',
`memo` varchar(128) NOT NULL DEFAULT '' COMMENT '备注',
`total_count` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '总笔数',
`excp_count` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '异常笔数',
`extension` varchar(256) NOT NULL DEFAULT '' COMMENT '扩展字段',
`create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
`modify_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
PRIMARY KEY (`id`),
UNIQUE KEY  `uk_schedule_no` (`schedule_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='批处理调度表';

CREATE TABLE `batch_detail` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
`enabled` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '1 - 可用，2 - 不可用',
`schedule_no` varchar(64) NOT NULL DEFAULT '' COMMENT '批次号',
`record_no` varchar(64) NOT NULL DEFAULT '' COMMENT '记录编号',
`record_type` varchar(32) NOT NULL DEFAULT '' COMMENT '记录类型',
`item_id` varchar(32) NOT NULL DEFAULT '' COMMENT 'item id',
`user_id` varchar(32) NOT NULL DEFAULT '' COMMENT '用户ID',
`record_state` varchar(32) NOT NULL DEFAULT '' COMMENT '记录状态',
`extension` varchar(5120) NOT NULL DEFAULT '' COMMENT '扩展字段',
`memo` varchar(128) NOT NULL DEFAULT '' COMMENT '备注',
`create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
`modify_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
PRIMARY KEY (`id`),
UNIQUE KEY  `uk_schedule_record` (`schedule_no`,`record_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='批处理明细表';

INSERT INTO `batch_file_config` (`enabled`, `item_id`, `schedule_freq`, `remote_file_path`, `local_file_path`, `expect_time`, `extension`, `description`, `create_time`, `modify_time`) VALUES (1, '11', 'everyday', '', '/Users/troywang/TestSchedule1_YYYYMMDD.txt', '2018-04-02 11:00:00', '', 'TestSchedule1', now(), now);
```



### Spring boot properties

```java
spring.datasource.url=jdbc:mysql://localhost:3306/gringotts_db?characterEncoding=utf8&useUnicode=true&useSSL=false
spring.datasource.username=gringotts
spring.datasource.password=gringotts
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.batch.initialize-schema=always
spring.batch.job.enabled=false
```

### MyBatis

使用mybatis_gen文件夹下的gen.sh生成DAO层。

```bash
sh gen.sh
```


## Logback configuration
```java
logging.file=foo.log
logging.level.com.troywang=DEBUG
```

## Tomcat configuration

```java
server.port=8089
server.servlet.context-path=/
```


## FileProcessJob

#### datasource配置
见 BatchDbConfiguration

#### Job构成

![flow](https://github.com/Troy-Wang/Gringotts/blob/master/imgs/flow.jpg)

#### Let's get started

```bash
curl -X GET "http://localhost:8089/jobLauncher?jobName=demoJob&date=20180405"
```

## Tips

> Caused by: java.lang.NullPointerException: null
	at com.mysql.jdbc.ConnectionImpl.getServerCharset(ConnectionImpl.java:2997) ~[mysql-connector-java-5.1.40.jar:5.1.40]

upgrade mysql-connector-java version


> Invalid default value for 'create_time'

```sql
show variables like 'sql_mode';
set session sql_mode='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
```
