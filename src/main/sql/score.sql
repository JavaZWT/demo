/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库（local）
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : test1

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2021-07-30 18:19:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `stu_no` varchar(20) NOT NULL COMMENT '学号',
  `cou_no` varchar(20) NOT NULL COMMENT '课程号',
  `score` decimal(10,0) DEFAULT NULL COMMENT '分数',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_stu_cou` (`stu_no`,`cou_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '1', 'A', '99');
INSERT INTO `score` VALUES ('2', '2', 'B', '90');
INSERT INTO `score` VALUES ('3', '2', 'A', '70');
INSERT INTO `score` VALUES ('4', '3', 'A', '60');
