/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : sevenshop

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-07-07 23:42:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `buy`
-- ----------------------------
DROP TABLE IF EXISTS `buy`;
CREATE TABLE `buy` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `goodsId` int(11) NOT NULL,
  ` fare` float DEFAULT NULL,
  `buyTime` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_buy` (`userId`),
  KEY `goods_buy` (`goodsId`),
  CONSTRAINT `goods_buy` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`),
  CONSTRAINT `user_buy` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of buy
-- ----------------------------

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for `goodscart`
-- ----------------------------
DROP TABLE IF EXISTS `goodscart`;
CREATE TABLE `goodscart` (
  `userId` int(11) NOT NULL,
  `goodsId` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`userId`,`goodsId`),
  KEY `goodId_goodsCat` (`goodsId`),
  CONSTRAINT `goodId_goodsCat` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`),
  CONSTRAINT `userId_goodscat` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of goodscart
-- ----------------------------

-- ----------------------------
-- Table structure for `personinfo`
-- ----------------------------
DROP TABLE IF EXISTS `personinfo`;
CREATE TABLE `personinfo` (
  `id` int(11) NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
