DROP TABLE IF EXISTS t_sys_ip;
CREATE TABLE t_sys_ip (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ip_address` varchar(64) NOT NULL COMMENT 'IP地址',
  `data_center_id` bigint(20) NOT NULL COMMENT '数据中心ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_ip_address_data_center_id` (`ip_address`,`data_center_id`) COMMENT '同一IP同一数据中心的应用唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应用IP信息表';

DROP TABLE IF EXISTS t_order_0;
CREATE TABLE t_order_0 (
	id bigint(20) PRIMARY KEY COMMENT '主键',
	user_id bigint(20) NOT NULL COMMENT '用户ID',
	state tinyint(4) NOT NULL COMMENT '状态',
	update_time datetime DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

DROP TABLE IF EXISTS t_order_1;
CREATE TABLE t_order_1 (
	id bigint(20) PRIMARY KEY COMMENT '主键',
	user_id bigint(20) NOT NULL COMMENT '用户ID',
	state tinyint(4) NOT NULL COMMENT '状态',
	update_time datetime DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

DROP TABLE IF EXISTS t_order_2;
CREATE TABLE t_order_2 (
	id bigint(20) PRIMARY KEY COMMENT '主键',
	user_id bigint(20) NOT NULL COMMENT '用户ID',
	state tinyint(4) NOT NULL COMMENT '状态',
	update_time datetime DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

DROP TABLE IF EXISTS t_order_3;
CREATE TABLE t_order_3 (
	id bigint(20) PRIMARY KEY COMMENT '主键',
	user_id bigint(20) NOT NULL COMMENT '用户ID',
	state tinyint(4) NOT NULL COMMENT '状态',
	update_time datetime DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

DROP TABLE IF EXISTS t_order_item_0;
CREATE TABLE t_order_item_0 (
	id bigint(20) PRIMARY KEY COMMENT 'ID',
	order_id bigint(20) NOT NULL COMMENT '订单ID',
	user_id bigint(20) NOT NULL COMMENT '用户ID',
	state tinyint(4) NOT NULL COMMENT '状态',
	update_time datetime DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单明细表';

DROP TABLE IF EXISTS t_order_item_1;
CREATE TABLE t_order_item_1 (
	id bigint(20) PRIMARY KEY COMMENT 'ID',
	order_id bigint(20) NOT NULL COMMENT '订单ID',
	user_id bigint(20) NOT NULL COMMENT '用户ID',
	state tinyint(4) NOT NULL COMMENT '状态',
	update_time datetime DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单明细表';

DROP TABLE IF EXISTS t_order_item_2;
CREATE TABLE t_order_item_2 (
	id bigint(20) PRIMARY KEY COMMENT 'ID',
	order_id bigint(20) NOT NULL COMMENT '订单ID',
	user_id bigint(20) NOT NULL COMMENT '用户ID',
	state tinyint(4) NOT NULL COMMENT '状态',
	update_time datetime DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单明细表';

DROP TABLE IF EXISTS t_order_item_3;
CREATE TABLE t_order_item_3 (
	id bigint(20) PRIMARY KEY COMMENT 'ID',
	order_id bigint(20) NOT NULL COMMENT '订单ID',
	user_id bigint(20) NOT NULL COMMENT '用户ID',
	state tinyint(4) NOT NULL COMMENT '状态',
	update_time datetime DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单明细表';

DROP TABLE IF EXISTS t_order_item_4;
CREATE TABLE t_order_item_4 (
	id bigint(20) PRIMARY KEY COMMENT 'ID',
	order_id bigint(20) NOT NULL COMMENT '订单ID',
	user_id bigint(20) NOT NULL COMMENT '用户ID',
	state tinyint(4) NOT NULL COMMENT '状态',
	update_time datetime DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单明细表';