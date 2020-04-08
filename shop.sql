/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50554
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2019-12-19 11:46:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `aname` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `apwd` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`aname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', 'a');

-- ----------------------------
-- Table structure for busertable
-- ----------------------------
DROP TABLE IF EXISTS `busertable`;
CREATE TABLE `busertable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bemail` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `bpwd` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of busertable
-- ----------------------------
INSERT INTO `busertable` VALUES ('1', '123456@qq.com', 'a');
INSERT INTO `busertable` VALUES ('2', '123@qq.com', 'a');

-- ----------------------------
-- Table structure for carttable
-- ----------------------------
DROP TABLE IF EXISTS `carttable`;
CREATE TABLE `carttable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `busertable_id` int(11) NOT NULL,
  `goodstable_id` int(11) NOT NULL,
  `shoppingnum` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `bid` (`busertable_id`),
  KEY `gno` (`goodstable_id`),
  CONSTRAINT `bid` FOREIGN KEY (`busertable_id`) REFERENCES `busertable` (`id`),
  CONSTRAINT `gno` FOREIGN KEY (`goodstable_id`) REFERENCES `goodstable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of carttable
-- ----------------------------

-- ----------------------------
-- Table structure for goodstable
-- ----------------------------
DROP TABLE IF EXISTS `goodstable`;
CREATE TABLE `goodstable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  `dprice` double DEFAULT NULL,
  `kucun` int(11) DEFAULT NULL,
  `gpicture` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `goodstype_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `typeid` (`goodstype_id`),
  CONSTRAINT `typeid` FOREIGN KEY (`goodstype_id`) REFERENCES `goodstype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of goodstable
-- ----------------------------
INSERT INTO `goodstable` VALUES ('1', '浪琴军旗系列', '5699', '5399', '2', '20191218140916031.jpg', '1');
INSERT INTO `goodstable` VALUES ('2', '劳力士', '30000', '28999', '6', '20191218140939541.jpg', '1');
INSERT INTO `goodstable` VALUES ('3', 'CARTIER 卡地亚', '13500', '13200', '6', '20191218140957976.jpg', '1');
INSERT INTO `goodstable` VALUES ('4', 'CHANEL 香奈儿包', '25800', '23800', '4', '20191218141006491.jpg', '2');
INSERT INTO `goodstable` VALUES ('5', '古驰/Gucci sylvie', '12800', '8700', '74', '20191218141015636.jpg', '2');
INSERT INTO `goodstable` VALUES ('6', '古驰Gucci GGlogo', '3600', '2799', '10', '20191218141031688.jpg', '2');
INSERT INTO `goodstable` VALUES ('7', '唯玉美珠宝 ', '99999', '86999', '1', '20191218141042474.jpg', '3');
INSERT INTO `goodstable` VALUES ('8', '盛通珠宝貔貅吊坠', '5000', '3500', '98', '20191218141053341.jpg', '3');
INSERT INTO `goodstable` VALUES ('9', '白玉世家 和田', '1599', '1329', '19', '20191218141103264.jpg', '3');
INSERT INTO `goodstable` VALUES ('10', '羊脂玉白玉手镯', '8600', '7580', '92', '20191218141113418.jpg', '3');
INSERT INTO `goodstable` VALUES ('11', '和田玉随形项链', '199', '128', '998', '20191218141126180.jpg', '3');
INSERT INTO `goodstable` VALUES ('12', 'aa', '122', '111', '1', '20191218152143137.jpg', '1');

-- ----------------------------
-- Table structure for goodstype
-- ----------------------------
DROP TABLE IF EXISTS `goodstype`;
CREATE TABLE `goodstype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of goodstype
-- ----------------------------
INSERT INTO `goodstype` VALUES ('1', '钟表');
INSERT INTO `goodstype` VALUES ('2', '箱包');
INSERT INTO `goodstype` VALUES ('3', '玉器');
INSERT INTO `goodstype` VALUES ('4', '二手');
INSERT INTO `goodstype` VALUES ('5', '零食');
INSERT INTO `goodstype` VALUES ('6', '手机');
INSERT INTO `goodstype` VALUES ('7', '衣服');
INSERT INTO `goodstype` VALUES ('8', '啊啊');

-- ----------------------------
-- Table structure for orderbasetable
-- ----------------------------
DROP TABLE IF EXISTS `orderbasetable`;
CREATE TABLE `orderbasetable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `busertable_id` int(11) NOT NULL,
  `amount` double NOT NULL,
  `status` tinyint(4) NOT NULL,
  `orderdate` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `bid2` (`busertable_id`),
  CONSTRAINT `orderbasetable_ibfk_1` FOREIGN KEY (`busertable_id`) REFERENCES `busertable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of orderbasetable
-- ----------------------------
INSERT INTO `orderbasetable` VALUES ('11', '1', '7580', '0', '2019-07-02 08:52:19');
INSERT INTO `orderbasetable` VALUES ('12', '1', '7580', '0', '2019-07-02 08:55:48');
INSERT INTO `orderbasetable` VALUES ('13', '1', '7580', '0', '2019-07-02 08:56:53');
INSERT INTO `orderbasetable` VALUES ('14', '1', '7580', '0', '2019-07-02 08:58:08');
INSERT INTO `orderbasetable` VALUES ('15', '1', '15160', '0', '2019-07-02 08:59:05');
INSERT INTO `orderbasetable` VALUES ('16', '1', '8909', '0', '2019-07-04 21:13:23');
INSERT INTO `orderbasetable` VALUES ('17', '1', '3500', '0', '2019-12-17 11:42:57');
INSERT INTO `orderbasetable` VALUES ('18', '1', '128', '0', '2019-12-18 15:21:10');

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderbasetable_id` int(11) NOT NULL,
  `goodstable_id` int(11) NOT NULL,
  `shoppingnum` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `odsn` (`orderbasetable_id`),
  KEY `gno3` (`goodstable_id`),
  CONSTRAINT `orderdetail_ibfk_1` FOREIGN KEY (`goodstable_id`) REFERENCES `goodstable` (`id`),
  CONSTRAINT `orderdetail_ibfk_2` FOREIGN KEY (`orderbasetable_id`) REFERENCES `orderbasetable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
INSERT INTO `orderdetail` VALUES ('1', '11', '10', '1');
INSERT INTO `orderdetail` VALUES ('2', '12', '10', '1');
INSERT INTO `orderdetail` VALUES ('3', '13', '10', '1');
INSERT INTO `orderdetail` VALUES ('4', '14', '10', '1');
INSERT INTO `orderdetail` VALUES ('5', '15', '10', '2');
INSERT INTO `orderdetail` VALUES ('6', '16', '10', '1');
INSERT INTO `orderdetail` VALUES ('7', '16', '9', '1');
INSERT INTO `orderdetail` VALUES ('8', '17', '8', '1');
INSERT INTO `orderdetail` VALUES ('9', '18', '11', '1');
