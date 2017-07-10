/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : sevenshop

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-07-10 00:56:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `buy`
-- ----------------------------
DROP TABLE IF EXISTS `buy`;
CREATE TABLE `buy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `goodsId` int(11) NOT NULL,
  `fare` float DEFAULT NULL,
  `buyTime` varchar(32) DEFAULT NULL,
  `address` varchar(32) NOT NULL,
  `number` int(5) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_buy` (`userId`),
  KEY `goods_buy` (`goodsId`),
  CONSTRAINT `goods_buy` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`),
  CONSTRAINT `user_buy` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of buy
-- ----------------------------
INSERT INTO `buy` VALUES ('1', '1', '1', null, 'rt', '', '0');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `prices` float NOT NULL,
  `typeid` int(11) NOT NULL,
  `productor` varchar(32) DEFAULT NULL,
  `description` text,
  `img1` varchar(64) DEFAULT NULL,
  `img2` varchar(64) DEFAULT NULL,
  `img3` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `goods_type` (`typeid`),
  CONSTRAINT `goods_type` FOREIGN KEY (`typeid`) REFERENCES `type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '联想', '5999', '2', '联想', '高性能', null, null, null);
INSERT INTO `goods` VALUES ('2', '联想', '5999', '2', '华硕', '高颜值', null, null, null);
INSERT INTO `goods` VALUES ('3', '??', '59', '2', null, null, null, null, null);
INSERT INTO `goods` VALUES ('4', '联想', '5999', '2', null, null, null, null, null);
INSERT INTO `goods` VALUES ('5', 'lianxiang', '5999', '2', null, null, null, null, null);
INSERT INTO `goods` VALUES ('6', '??', '5999', '2', null, null, null, null, null);
INSERT INTO `goods` VALUES ('7', '联想', '5999', '2', null, null, null, null, null);
INSERT INTO `goods` VALUES ('8', '联想', '5999', '2', null, null, null, null, null);

-- ----------------------------
-- Table structure for `goodscart`
-- ----------------------------
DROP TABLE IF EXISTS `goodscart`;
CREATE TABLE `goodscart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `goodsId` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `goodscart_userId` (`userId`),
  KEY `goodcart_goodId` (`goodsId`),
  CONSTRAINT `goodcart_goodId` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`),
  CONSTRAINT `goodscart_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of goodscart
-- ----------------------------

-- ----------------------------
-- Table structure for `personinfo`
-- ----------------------------
DROP TABLE IF EXISTS `personinfo`;
CREATE TABLE `personinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `adress` varchar(64) NOT NULL,
  `phone` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_adress` (`userId`),
  CONSTRAINT `user_adress` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of personinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `type`
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(11) NOT NULL,
  `typename` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('0', 'luan');
INSERT INTO `type` VALUES ('1', '手机数码');
INSERT INTO `type` VALUES ('2', '电脑办公');
INSERT INTO `type` VALUES ('3', '数码相机');
INSERT INTO `type` VALUES ('4', '智能便携');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `sex` int(11) DEFAULT NULL COMMENT '1男；0女',
  `isadmin` int(11) NOT NULL DEFAULT '0' COMMENT '1管理员；0普通用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'xiaoma', 'xiaoma', '1', '1');
INSERT INTO `user` VALUES ('2', 'xiaoma', 'xiaoma', '1', '1');
