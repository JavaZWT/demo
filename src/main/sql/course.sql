/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库（local）
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : test1

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2021-07-30 18:19:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cou_no` varchar(10) DEFAULT NULL,
  `cou_name` varchar(255) DEFAULT NULL,
  `teach_no` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_teach_no` (`teach_no`) USING BTREE,
  KEY `idx_cou_no` (`cou_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '1', '语文1', 'teacher1');
INSERT INTO `course` VALUES ('2', '2', '数学', 'teacher2');
INSERT INTO `course` VALUES ('3', '3', '英语', 'teacher3');
