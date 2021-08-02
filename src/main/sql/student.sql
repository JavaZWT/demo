/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库（local）
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : test1

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2021-07-30 18:19:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `stu_no` varchar(20) NOT NULL COMMENT '学号',
  `stu_sex` char(1) DEFAULT NULL COMMENT '学生性别',
  `stu_birthday` date DEFAULT NULL COMMENT '学生生日',
  `stu_class` char(2) DEFAULT NULL COMMENT '学生班级',
  `stu_name` varchar(50) DEFAULT NULL COMMENT '学生姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '1', '1', '2004-03-03', '1', '张二二');
INSERT INTO `student` VALUES ('2', '2', '0', '2005-06-02', '2', '李四');
INSERT INTO `student` VALUES ('3', '3', '1', '2003-01-07', '3', '王五');
INSERT INTO `student` VALUES ('4', '4', '1', null, '1', '赵六');
