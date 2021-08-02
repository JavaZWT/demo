/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库（local）
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : test1

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2021-07-30 18:19:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL COMMENT '主键',
  `teach_no` varchar(20) NOT NULL COMMENT '教师号',
  `teach_name` varchar(50) DEFAULT NULL COMMENT '教师姓名',
  `teach_sex` char(1) DEFAULT NULL COMMENT '教师性别',
  `teach_birthday` date DEFAULT NULL COMMENT '教师生日',
  `teach_depart` varchar(255) DEFAULT NULL COMMENT '教师部门',
  `teach_prof` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
