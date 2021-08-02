/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库（local）
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : test1

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2021-07-30 18:19:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for source_tab
-- ----------------------------
DROP TABLE IF EXISTS `source_tab`;
CREATE TABLE `source_tab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `sex` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of source_tab
-- ----------------------------
INSERT INTO `source_tab` VALUES ('1', '1', '1');
INSERT INTO `source_tab` VALUES ('2', '2', '0');
INSERT INTO `source_tab` VALUES ('3', '1', '1');
INSERT INTO `source_tab` VALUES ('4', '4', '0');
