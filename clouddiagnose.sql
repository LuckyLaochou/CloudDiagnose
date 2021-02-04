/*
Navicat MySQL Data Transfer

Source Server         : laochou
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : clouddiagnose

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2021-02-04 21:15:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(32) NOT NULL,
  `content` text NOT NULL,
  `user_id` int(11) NOT NULL,
  `keywords` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `browser_times` int(11) NOT NULL DEFAULT '1',
  `likee` int(11) NOT NULL DEFAULT '1',
  `is_deleted` int(11) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '双非如何拿到阿里，腾讯的Offer', '# Test', '1', '阿里、腾讯', '1', '1', '0', '2020-11-23 23:42:27', '2020-11-23 23:42:27');
INSERT INTO `article` VALUES ('2', '', '![](/upload/78c814ec-3f59-45fa-90df-e26a779a8bd2.jpg)\r\n# Hello World', '1', '', '1', '1', '0', '2020-11-24 20:39:24', '2020-11-24 20:39:24');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `content` text NOT NULL,
  `likee` int(11) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', '1', '写的真好啊', '1', '2020-11-30 11:24:27', '2020-11-30 11:24:30');
INSERT INTO `comment` VALUES ('2', '1', '1', '真棒', '0', '2020-12-20 17:36:46', '2020-12-20 17:36:46');
INSERT INTO `comment` VALUES ('3', '1', '1', '太强了', '0', '2020-12-26 18:50:47', '2020-12-26 18:50:47');
INSERT INTO `comment` VALUES ('4', '1', '1', 'zhend ', '0', '2020-12-26 20:41:21', '2020-12-26 20:41:21');

-- ----------------------------
-- Table structure for diagnose
-- ----------------------------
DROP TABLE IF EXISTS `diagnose`;
CREATE TABLE `diagnose` (
  `id` int(11) NOT NULL,
  `request_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `diagnose_result` varchar(64) NOT NULL,
  `advices` varchar(64) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diagnose
-- ----------------------------

-- ----------------------------
-- Table structure for pre_diagnose
-- ----------------------------
DROP TABLE IF EXISTS `pre_diagnose`;
CREATE TABLE `pre_diagnose` (
  `id` int(11) NOT NULL,
  `request_id` int(11) NOT NULL,
  `pre_diagnose_result` varchar(64) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pre_diagnose
-- ----------------------------

-- ----------------------------
-- Table structure for request
-- ----------------------------
DROP TABLE IF EXISTS `request`;
CREATE TABLE `request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `department` varchar(32) NOT NULL,
  `content` text NOT NULL,
  `pictures` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `video` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_pre_diagnose` int(11) NOT NULL DEFAULT '0',
  `is_diagnose` int(11) NOT NULL DEFAULT '0',
  `is_dispose` int(11) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of request
-- ----------------------------
INSERT INTO `request` VALUES ('1', '2', '皮肤科', '暂无症状', '/upload/54f06d98-8154-4759-99eb-14dbb437031e.jpg', '/upload/806aa6e6-bd99-45e0-b287-ceba5aa88a78.png', '0', '0', '0', '2020-11-08 22:08:32', '2020-11-08 22:08:32');
INSERT INTO `request` VALUES ('2', '2', '皮肤科', '暂无症状', '/upload/54f06d98-8154-4759-99eb-14dbb437031e.jpg', '', '0', '0', '0', '2020-11-08 22:44:41', '2020-11-08 22:44:41');
INSERT INTO `request` VALUES ('3', '2', '骨科', '暂无症状', '/upload/54f06d98-8154-4759-99eb-14dbb437031e.jpg', ' ', '0', '0', '0', '2021-02-01 20:54:13', '2021-02-01 20:54:16');
INSERT INTO `request` VALUES ('4', '2', '骨科', '暂无症状', '/upload/54f06d98-8154-4759-99eb-14dbb437031e.jpg', ' ', '0', '0', '0', '2021-02-01 20:56:07', '2021-02-01 20:56:09');

-- ----------------------------
-- Table structure for symptoms
-- ----------------------------
DROP TABLE IF EXISTS `symptoms`;
CREATE TABLE `symptoms` (
  `id` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  `symptoms` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of symptoms
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `id_card` varchar(32) NOT NULL,
  `mail` varchar(32) NOT NULL,
  `sex` int(11) NOT NULL,
  `role` int(11) NOT NULL,
  `department` varchar(12) NOT NULL DEFAULT '用户系',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `password` varchar(32) NOT NULL,
  `phone` char(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'laochou', '360428200106185311', '927990436@qq.com', '1', '1', '用户系', '2020-10-14 09:56:56', '2020-10-14 09:57:00', 'laochou', '19979199619');
INSERT INTO `user` VALUES ('2', '张三', '360232222222222222', '222222222@qq.com', '1', '1', '用户系', '2021-02-01 20:55:08', '2021-02-01 20:55:11', 'zhangsan', '19922222222');
