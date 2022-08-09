CREATE TABLE addUserCase(
    `id` BIGINT NOT NULL AUTO_INCREMENT  COMMENT '',
    `userName` VARCHAR(64) DEFAULT NULL COMMENT '用户名 用户名',
    `password` VARCHAR(64) DEFAULT NULL COMMENT '密码 密码',
    `sex` INT(1) DEFAULT 0 COMMENT '性别',
    `age` INT DEFAULT 0 COMMENT '年龄',
    `permission` INT(1) DEFAULT 0 COMMENT '权限',
    `isDelete` INT(1) DEFAULT 0 COMMENT '删除',
    `expected` BOOLEAN DEFAULT true COMMENT '期望结果',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='添加用户表';

CREATE TABLE getUserInfoCase(
        `id` BIGINT NOT NULL AUTO_INCREMENT  COMMENT '',
        `userId` BIGINT NOT NULL COMMENT '用户id',
        `expected` VARCHAR(64) DEFAULT NULL COMMENT '期望结果',
        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='获取用户信息表';



CREATE TABLE getUserListCase(
        `id` BIGINT NOT NULL AUTO_INCREMENT  COMMENT '',
        `userName` VARCHAR(64) DEFAULT NULL COMMENT '用户名 用户名',
        `age` INT DEFAULT 0 COMMENT '年龄',
        `sex` INT(1) DEFAULT 0 COMMENT '性别',
        `expected` VARCHAR(64) DEFAULT NULL COMMENT '期望结果',
        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='获取用户列表表';

CREATE TABLE loginCase(
        `id` BIGINT NOT NULL AUTO_INCREMENT  COMMENT '',
        `userName` VARCHAR(64) DEFAULT NULL COMMENT '用户名 用户名',
        `password` VARCHAR(64) DEFAULT NULL COMMENT '密码 密码',
        `expected` BOOLEAN DEFAULT true COMMENT '期望结果',
        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='登录信息表';



CREATE TABLE updateUserInfoCase(
      `id` BIGINT NOT NULL AUTO_INCREMENT  COMMENT '',
      `userId` BIGINT NOT NULL COMMENT '用户id',
      `userName` VARCHAR(64) DEFAULT NULL COMMENT '用户名 用户名',
      `sex` INT(1) DEFAULT 0 COMMENT '性别',
      `age` INT DEFAULT 0 COMMENT '年龄',
      `permission` INT(1) DEFAULT 0 COMMENT '权限',
      `isDelete` INT(1) DEFAULT 0 COMMENT '删除',
      `expected` VARCHAR(64) DEFAULT NULL COMMENT '期望结果',
      PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户信息更新表';