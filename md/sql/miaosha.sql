DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `goods_name` varchar(16) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '商品名称',
  `goods_title` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '商品标题',
  `goods_img` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '商品的图片',
  `goods_detail` longtext CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '商品的详情介绍',
  `goods_price` decimal(10,2) DEFAULT 0.00 COMMENT '商品单价',
  `goods_stock` int(11) DEFAULT 0 COMMENT '商品库存',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '小米Mix2', '小米Mix2（黑科技十足）', '/img/小米Mix2.png', '小米Mix2s', '3499.00', '10');
INSERT INTO `goods` VALUES ('2', 'huawei mate10', 'Huawei华为', '/img/huawei.png', 'Huwei Mate10', '4800.00', '10');
INSERT INTO `goods` VALUES ('3', 'honor10', '荣耀10', '/img/荣耀10.png', 'Honor 10', '2799.00', '10');
INSERT INTO `goods` VALUES ('4', '三星s9', 'Sanxing S9', '/img/三星.png', 'sanxing S9', '6899.00', '10');
INSERT INTO `goods` VALUES ('5', 'iPhone X', 'iphoneX(全网通)', '/img/iPhoneX.png', 'iphoneX', '8848.00', '8');
INSERT INTO `goods` VALUES ('6', '小米8', '黑科技十足', '/img/小米8.png', '小米8', '3499.00', '10');



DROP TABLE IF EXISTS `miaosha_goods`;
CREATE TABLE `miaosha_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '秒杀的商品表',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品的ID',
  `miaosha_price` decimal(10,2) DEFAULT 0.00 COMMENT '秒杀价',
  `stock_count` int(11) DEFAULT NULL COMMENT '库存数量',
  `start_date` datetime DEFAULT NULL COMMENT '秒杀开始时间',
  `end_date` datetime DEFAULT NULL COMMENT '秒杀结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of miaosha_goods
-- ----------------------------
INSERT INTO `miaosha_goods` VALUES ('1', '1', '300.00', '6', '2018-05-26 11:33:59', '2018-05-26 11:34:08');
INSERT INTO `miaosha_goods` VALUES ('2', '2', '150.00', '5', '2018-05-25 11:34:32', '2018-07-19 11:34:40');
INSERT INTO `miaosha_goods` VALUES ('3', '3', '100.00', '10', '2018-06-14 10:24:04', '2018-07-19 10:24:21');
INSERT INTO `miaosha_goods` VALUES ('4', '4', '200.00', '6', '2018-05-25 10:24:42', '2018-07-19 10:24:47');
INSERT INTO `miaosha_goods` VALUES ('5', '5', '800.00', '5', '2018-05-25 11:11:42', '2018-06-15 11:11:50');
INSERT INTO `miaosha_goods` VALUES ('6', '6', '1.00', '10', '2018-05-31 09:15:13', '2018-06-30 09:15:18');

DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `delivery_addr_id` bigint(20) DEFAULT NULL COMMENT '收货地址ID',
  `goods_name` varchar(16) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '冗余过来的商品名称',
  `goods_count` int(11) DEFAULT 0 COMMENT '商品数量',
  `goods_price` decimal(10,2) DEFAULT 0.00 COMMENT '商品价格',
  `order_channel` tinyint(4) DEFAULT 0 COMMENT '1pc,2android,3ios',
  `status` tinyint(4) DEFAULT 0 COMMENT '订单状态，0新建来支付，1已经支付，2已经发货，3已经收货，4已退款，5已完成',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `pay_date` datetime DEFAULT NULL COMMENT '支付时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `miaosha_order`;
CREATE TABLE `miaosha_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单ID',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
