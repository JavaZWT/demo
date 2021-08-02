/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库（local）
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : test1

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2021-07-30 18:19:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tab_no_index
-- ----------------------------
DROP TABLE IF EXISTS `tab_no_index`;
CREATE TABLE `tab_no_index` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tab_no_index
-- ----------------------------
INSERT INTO `tab_no_index` VALUES ('1', '1');
INSERT INTO `tab_no_index` VALUES ('2', '2');
INSERT INTO `tab_no_index` VALUES ('3', '3');
INSERT INTO `tab_no_index` VALUES ('4', '4');
