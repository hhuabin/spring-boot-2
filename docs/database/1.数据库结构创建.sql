-- 1. 创建数据库
CREATE DATABASE IF NOT EXISTS `spring_boot_2`
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_0900_ai_ci;

USE `spring_boot_2`;

-- 2. 创建普通用户表
CREATE TABLE IF NOT EXISTS `user` (
  `user_id`       BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name`      VARCHAR(50)  NOT NULL COMMENT '登录名',     # 没有 DEFAULT 需要创建用户时需要指定用户名
  `password`      VARCHAR(100) NOT NULL DEFAULT '' COMMENT '密码哈希',
  `real_name`     VARCHAR(50)  NOT NULL DEFAULT '' COMMENT '真实姓名',
	`phone`         VARCHAR(20)  NOT NULL DEFAULT '' COMMENT '手机号',
  `birthday`      DATE         DEFAULT NULL COMMENT '生日',
	`gender`        CHAR(1)      NOT NULL DEFAULT '0' COMMENT '0未知1男2女',
  `email`         VARCHAR(50)  NOT NULL DEFAULT '' COMMENT '邮箱',
  `address`       VARCHAR(255) NOT NULL DEFAULT '' COMMENT '地址',
	`avatar`        VARCHAR(255) NOT NULL DEFAULT '' COMMENT '头像URL',
  `signature`     VARCHAR(255) NOT NULL DEFAULT '' COMMENT '个性签名',
  `status`        TINYINT      NOT NULL DEFAULT 1 COMMENT '0禁用1正常2封禁',
  `last_login_time` DATETIME   DEFAULT NULL COMMENT '最后登录时间',
  `last_login_ip`   VARCHAR(45) DEFAULT NULL COMMENT '最后登录IP',
  `create_time`   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time`   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted`    CHAR(1)      NOT NULL DEFAULT '0' COMMENT '0正常1删除',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `uk_username` (`user_name`),
  UNIQUE KEY `uk_phone` (`phone`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  COMMENT = '普通用户表';

