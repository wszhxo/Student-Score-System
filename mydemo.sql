/*
Navicat MySQL Data Transfer

Source Server         : 张某
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : mydemo

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-03-18 18:55:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ename` varchar(255) DEFAULT NULL,
  `credit` double DEFAULT NULL COMMENT '学分',
  `year` int(11) DEFAULT NULL COMMENT '学年及春秋',
  PRIMARY KEY (`id`),
  KEY `course_year` (`year`),
  CONSTRAINT `course_year` FOREIGN KEY (`year`) REFERENCES `courseyear` (`yearid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '编译原理', 'by', '1.5', '2');
INSERT INTO `course` VALUES ('2', '计算机网络', 'net', '1.5', '2');
INSERT INTO `course` VALUES ('3', '实用软件工程', 'soft', '2', '2');
INSERT INTO `course` VALUES ('4', '计算机组成原理', 'zc', '1.5', '2');
INSERT INTO `course` VALUES ('5', '计算机操作系统', 'os', '2.5', '2');
INSERT INTO `course` VALUES ('6', 'C++', 'c', '1', '6');
INSERT INTO `course` VALUES ('7', '数据库基础', 'sql', '2', '1');
INSERT INTO `course` VALUES ('8', 'java核心技术', 'jv', '1.5', '1');
INSERT INTO `course` VALUES ('9', '大学英语4', 'eg', '1', '1');
INSERT INTO `course` VALUES ('10', 'Web前端开发基础', 'web', '2', '6');

-- ----------------------------
-- Table structure for `courseyear`
-- ----------------------------
DROP TABLE IF EXISTS `courseyear`;
CREATE TABLE `courseyear` (
  `yearid` int(11) NOT NULL,
  `mean` varchar(255) DEFAULT NULL COMMENT 'id对应的具体年份',
  PRIMARY KEY (`yearid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of courseyear
-- ----------------------------
INSERT INTO `courseyear` VALUES ('1', '2018(春)');
INSERT INTO `courseyear` VALUES ('2', '2018(秋)');
INSERT INTO `courseyear` VALUES ('3', '2019(春)');
INSERT INTO `courseyear` VALUES ('4', '2019(秋)');
INSERT INTO `courseyear` VALUES ('5', '2017(春)');
INSERT INTO `courseyear` VALUES ('6', '2017(秋)');
INSERT INTO `courseyear` VALUES ('7', '2020(春)');
INSERT INTO `courseyear` VALUES ('8', '2020(秋)');

-- ----------------------------
-- Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `stuid` int(11) NOT NULL COMMENT '学号',
  `grade` double(11,0) DEFAULT NULL COMMENT '成绩',
  `courseid` int(11) NOT NULL,
  PRIMARY KEY (`stuid`,`courseid`),
  KEY `student_stuid` (`stuid`),
  KEY `course_id` (`courseid`),
  CONSTRAINT `course_id` FOREIGN KEY (`courseid`) REFERENCES `course` (`id`),
  CONSTRAINT `student_stuid` FOREIGN KEY (`stuid`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('16002', '32', '1');
INSERT INTO `score` VALUES ('16002', '87', '2');
INSERT INTO `score` VALUES ('16002', '97', '3');
INSERT INTO `score` VALUES ('16002', '65', '4');
INSERT INTO `score` VALUES ('16002', '66', '5');
INSERT INTO `score` VALUES ('16002', '74', '6');
INSERT INTO `score` VALUES ('16002', '74', '7');
INSERT INTO `score` VALUES ('16002', '74', '8');
INSERT INTO `score` VALUES ('16002', '74', '9');
INSERT INTO `score` VALUES ('16002', '74', '10');
INSERT INTO `score` VALUES ('16003', '77', '1');
INSERT INTO `score` VALUES ('16003', '69', '2');
INSERT INTO `score` VALUES ('16003', '78', '3');
INSERT INTO `score` VALUES ('16003', '94', '4');
INSERT INTO `score` VALUES ('16003', '94', '5');
INSERT INTO `score` VALUES ('16003', '74', '6');
INSERT INTO `score` VALUES ('16003', '74', '7');
INSERT INTO `score` VALUES ('16003', '74', '8');
INSERT INTO `score` VALUES ('16003', '74', '9');
INSERT INTO `score` VALUES ('16003', '74', '10');
INSERT INTO `score` VALUES ('16004', '67', '1');
INSERT INTO `score` VALUES ('16004', '76', '2');
INSERT INTO `score` VALUES ('16004', '87', '3');
INSERT INTO `score` VALUES ('16004', '97', '4');
INSERT INTO `score` VALUES ('16004', '65', '5');
INSERT INTO `score` VALUES ('16004', '73', '6');
INSERT INTO `score` VALUES ('16004', '72', '7');
INSERT INTO `score` VALUES ('16004', '76', '8');
INSERT INTO `score` VALUES ('16004', '77', '9');
INSERT INTO `score` VALUES ('16004', '74', '10');
INSERT INTO `score` VALUES ('16005', '78', '1');
INSERT INTO `score` VALUES ('16005', '87', '2');
INSERT INTO `score` VALUES ('16005', '46', '3');
INSERT INTO `score` VALUES ('16005', '78', '4');
INSERT INTO `score` VALUES ('16005', '77', '5');
INSERT INTO `score` VALUES ('16005', '73', '6');
INSERT INTO `score` VALUES ('16005', '72', '7');
INSERT INTO `score` VALUES ('16005', '76', '8');
INSERT INTO `score` VALUES ('16005', '77', '9');
INSERT INTO `score` VALUES ('16005', '74', '10');
INSERT INTO `score` VALUES ('16006', '87', '1');
INSERT INTO `score` VALUES ('16006', '95', '2');
INSERT INTO `score` VALUES ('16006', '56', '3');
INSERT INTO `score` VALUES ('16006', '86', '4');
INSERT INTO `score` VALUES ('16006', '96', '5');
INSERT INTO `score` VALUES ('16006', '73', '6');
INSERT INTO `score` VALUES ('16006', '72', '7');
INSERT INTO `score` VALUES ('16006', '76', '8');
INSERT INTO `score` VALUES ('16006', '77', '9');
INSERT INTO `score` VALUES ('16006', '74', '10');
INSERT INTO `score` VALUES ('16007', '99', '1');
INSERT INTO `score` VALUES ('16007', '95', '2');
INSERT INTO `score` VALUES ('16007', '75', '3');
INSERT INTO `score` VALUES ('16007', '68', '4');
INSERT INTO `score` VALUES ('16007', '79', '5');
INSERT INTO `score` VALUES ('16007', '73', '6');
INSERT INTO `score` VALUES ('16007', '72', '7');
INSERT INTO `score` VALUES ('16007', '76', '8');
INSERT INTO `score` VALUES ('16007', '77', '9');
INSERT INTO `score` VALUES ('16007', '74', '10');
INSERT INTO `score` VALUES ('16008', '86', '1');
INSERT INTO `score` VALUES ('16008', '56', '2');
INSERT INTO `score` VALUES ('16008', '67', '3');
INSERT INTO `score` VALUES ('16008', '69', '4');
INSERT INTO `score` VALUES ('16008', '79', '5');
INSERT INTO `score` VALUES ('16008', '73', '6');
INSERT INTO `score` VALUES ('16009', '86', '1');
INSERT INTO `score` VALUES ('16009', '76', '2');
INSERT INTO `score` VALUES ('16009', '68', '3');
INSERT INTO `score` VALUES ('16009', '73', '4');
INSERT INTO `score` VALUES ('16009', '75', '5');
INSERT INTO `score` VALUES ('16010', '75', '1');
INSERT INTO `score` VALUES ('16010', '45', '2');
INSERT INTO `score` VALUES ('16010', '82', '3');
INSERT INTO `score` VALUES ('16010', '86', '4');
INSERT INTO `score` VALUES ('16010', '84', '5');
INSERT INTO `score` VALUES ('16011', '46', '1');
INSERT INTO `score` VALUES ('16011', '32', '2');
INSERT INTO `score` VALUES ('16011', '69', '3');
INSERT INTO `score` VALUES ('16011', '84', '4');
INSERT INTO `score` VALUES ('16011', '84', '5');
INSERT INTO `score` VALUES ('16012', '76', '1');
INSERT INTO `score` VALUES ('16012', '76', '2');
INSERT INTO `score` VALUES ('16012', '87', '3');
INSERT INTO `score` VALUES ('16012', '87', '4');
INSERT INTO `score` VALUES ('16012', '89', '5');
INSERT INTO `score` VALUES ('16013', '74', '1');
INSERT INTO `score` VALUES ('16013', '43', '2');
INSERT INTO `score` VALUES ('16013', '86', '3');
INSERT INTO `score` VALUES ('16013', '75', '4');
INSERT INTO `score` VALUES ('16013', '86', '5');
INSERT INTO `score` VALUES ('16014', '44', '1');
INSERT INTO `score` VALUES ('16014', '83', '2');
INSERT INTO `score` VALUES ('16014', '85', '3');
INSERT INTO `score` VALUES ('16014', '86', '4');
INSERT INTO `score` VALUES ('16014', '99', '5');
INSERT INTO `score` VALUES ('16015', '76', '1');
INSERT INTO `score` VALUES ('16015', '35', '2');
INSERT INTO `score` VALUES ('16015', '83', '3');
INSERT INTO `score` VALUES ('16015', '71', '4');
INSERT INTO `score` VALUES ('16015', '48', '5');
INSERT INTO `score` VALUES ('16016', '83', '1');
INSERT INTO `score` VALUES ('16016', '42', '2');
INSERT INTO `score` VALUES ('16016', '78', '3');
INSERT INTO `score` VALUES ('16016', '68', '4');
INSERT INTO `score` VALUES ('16016', '73', '5');
INSERT INTO `score` VALUES ('16017', '31', '1');
INSERT INTO `score` VALUES ('16017', '31', '2');
INSERT INTO `score` VALUES ('16017', '87', '3');
INSERT INTO `score` VALUES ('16017', '85', '4');
INSERT INTO `score` VALUES ('16017', '68', '5');
INSERT INTO `score` VALUES ('16018', '85', '1');
INSERT INTO `score` VALUES ('16018', '31', '2');
INSERT INTO `score` VALUES ('16018', '31', '3');
INSERT INTO `score` VALUES ('16018', '39', '4');
INSERT INTO `score` VALUES ('16018', '80', '5');
INSERT INTO `score` VALUES ('16019', '57', '1');
INSERT INTO `score` VALUES ('16019', '83', '2');
INSERT INTO `score` VALUES ('16019', '74', '3');
INSERT INTO `score` VALUES ('16019', '43', '4');
INSERT INTO `score` VALUES ('16019', '87', '5');
INSERT INTO `score` VALUES ('16027', '88', '1');
INSERT INTO `score` VALUES ('16027', '43', '2');
INSERT INTO `score` VALUES ('16027', '76', '3');
INSERT INTO `score` VALUES ('16027', '98', '4');
INSERT INTO `score` VALUES ('16027', '76', '5');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL COMMENT '学号',
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `depart` varchar(255) DEFAULT NULL COMMENT '系别',
  `password` varchar(255) DEFAULT '123456',
  `type` int(2) DEFAULT '2' COMMENT '默认2学生',
  `isdel` int(2) DEFAULT '0' COMMENT '是否删除',
  `age` timestamp NULL DEFAULT '1998-04-02 11:11:11' ON UPDATE CURRENT_TIMESTAMP COMMENT '年份',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('16001', '贾齐龙', '女', '重庆市合川区高阳大道', '土木工程', '123456', '2', '1', '2018-12-25 22:32:22');
INSERT INTO `student` VALUES ('16002', '黄钟荣', '男', '\r\n重庆市合川区高阳大道', '土木工程', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16003', '刘张传', '男', '南京市江宁区麒麟镇麒东路777号', '计算机类', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16004', '何志远', '女', '\r\n重庆市合川区高阳大道', '土木工程', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16005', '韩凯', '男', '\r\n重庆市合川区高阳大道', '经商管理', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16006', '项凯 ', '女', '南京市江宁区麒麟镇麒东路777号', '计算机类', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16007', '沈霆 ', '男', '杭州市拱墅区', '经商管理', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16008', '么克东', '女', '杭州市拱墅区', '计算机类', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16009', '孙蒙', '男', '\r\n南京市雨花台区应天大街619号南京市江宁区麒麟镇麒东路777号', '土木工程', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16010', '朱翔', '女', '南京市玄武区玄武大道699-1号', '计算机类', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16011', '唐科', '男', '\r\n宣城市宁国市', '土木工程', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16012', '孙彪', '女', '南京市玄武区龙蟠路111号', '土木工程', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16013', '吕凯强', '男', '\r\n上海市徐汇区', '计算机类', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16014', '孙晓亮', '男', '南京市玄武区玄武大道699-1号', '经商管理', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16015', '卢易斯', '女', '\r\n上海市徐汇区', '经商管理', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16016', '宋瑛', '男', '\r\n上海市徐汇区', '经商管理', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16017', '阮焘', '男', '南京市玄武区龙蟠路111号', '经商管理', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16018', '李金泽', '女', '南京市玄武区玄武大道699-1号', '土木工程', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16019', '黄爱芬', '女', '金华市婺城区', '计算机类', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16020', '柳长青', '男', '\r\n重庆市合川区高阳大道', '土木工程', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16021', '汤伶', '男', '\r\n重庆市渝中区', '土木工程', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16022', '罗志宏', '女', '南京市建邺区江东中路98号', '土木工程', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16023', '李瑞', '男', '金华市婺城区', '土木工程', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16024', '骆开明', '女', '宣城市广德县', '土木工程', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16025', '龙天一', '男', '\r\n上海市徐汇区', '计算机类', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16026', '李爽', '女', '南京市栖霞区', '土木工程', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16027', '兰杰', '男', '\r\n宣城市宁国市', '土木工程', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16028', '刘健', '女', '\r\n重庆市渝中区', '土木工程', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16029', '肖长征', '男', '金华市婺城区', '计算机类', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16030', '邵飞', '女', '宣城市广德县', '土木工程', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16031', '严刚', '男', '南京市建邺区江东中路98号', '计算机类', '123456', '2', '0', '1998-04-02 11:11:11');
INSERT INTO `student` VALUES ('16032', '张某', '男', '新疆维吾尔自治区', '计算机类', '123456', '2', '0', '1998-10-23 00:00:00');
INSERT INTO `student` VALUES ('160333', '张三丰', '男', '软件工程', '广东佛山', '123456', '2', '0', '1997-03-21 00:00:00');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `type` int(2) DEFAULT '2' COMMENT '1是老师 2是学生',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=95276 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('95271', '张老师', '123', '1');
INSERT INTO `user` VALUES ('95272', '王老师', '123456', '1');
INSERT INTO `user` VALUES ('95273', '李老师', '123456', '1');
INSERT INTO `user` VALUES ('95274', '叶老师', '123456', '1');
INSERT INTO `user` VALUES ('95275', '黄老师', '123456', '1');
