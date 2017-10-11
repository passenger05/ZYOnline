/*
Navicat MySQL Data Transfer

Source Server         : 172.21.143.68
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : zy_tea

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-10-06 23:04:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `number` bigint(20) NOT NULL DEFAULT '0',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of brand
-- ----------------------------
INSERT INTO `brand` VALUES ('1', '安化黑茶', 'ahhc.gif', '264', '2017-10-04 21:42:14', '2017-10-05 18:08:07');
INSERT INTO `brand` VALUES ('2', '安吉白茶', 'ajbc.gif', '126', '2017-10-04 21:43:05', '2017-10-05 16:38:57');
INSERT INTO `brand` VALUES ('3', '安溪铁观音', 'axtgy.gif', '455', '2017-10-04 21:43:33', '2017-10-05 16:39:07');
INSERT INTO `brand` VALUES ('4', '黄山毛峰', 'hsmf.gif', '214', '2017-10-04 21:44:12', '2017-10-05 16:39:01');
INSERT INTO `brand` VALUES ('5', '君山银针', 'jsyz.gif', '12323', '2017-10-04 21:44:42', '2017-10-05 16:39:04');
INSERT INTO `brand` VALUES ('6', '六安瓜片', 'lagp.gif', '21315', '2017-10-04 21:45:31', '2017-10-05 18:03:01');
INSERT INTO `brand` VALUES ('7', '骊山云雾茶', 'lsywc.gif', '35', '2017-10-04 21:46:00', '2017-10-05 16:39:05');
INSERT INTO `brand` VALUES ('8', '茉莉花茶', 'mlhc.gif', '26', '2017-10-04 21:46:40', '2017-10-05 16:39:06');
INSERT INTO `brand` VALUES ('9', '湄潭翠芽', 'mtcy.gif', '826', '2017-10-04 21:47:26', '2017-10-05 16:39:04');
INSERT INTO `brand` VALUES ('10', '普洱茶', 'pec.gif', '1234', '2017-10-04 21:48:02', '2017-10-05 16:39:03');
INSERT INTO `brand` VALUES ('11', '武夷山大红袍', 'wysdhp.gif', '21313', '2017-10-04 21:48:39', '2017-10-05 16:39:03');
INSERT INTO `brand` VALUES ('12', '信阳毛尖', 'xymj.gif', '3424', '2017-10-04 21:48:57', '2017-10-05 16:39:02');
