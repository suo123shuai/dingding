/*
Navicat MySQL Data Transfer

Source Server         : 鸡舍
Source Server Version : 50721
Source Host           : 118.89.138.197:3306
Source Database       : db_test

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-07-03 15:26:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbManager`
-- ----------------------------
DROP TABLE IF EXISTS `tbManager`;
CREATE TABLE `tbManager` (
  `managerId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `userAccount` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '账号',
  `userPassword` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '密码',
  `userName` varchar(50) DEFAULT NULL COMMENT '姓名',
  `createTime` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '创建时间',
  `uRole` int(2) DEFAULT '2' COMMENT '1超级管理员2区域管理员',
  `deleteFlag` int(1) DEFAULT '0' COMMENT '0未删除1已删除',
  `cityId` bigint(200) DEFAULT NULL COMMENT '管理的城市',
  `uStatus` int(2) DEFAULT '1' COMMENT '1是已激活 2是已禁用',
  PRIMARY KEY (`managerId`)
) ENGINE=MyISAM AUTO_INCREMENT=242 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbManager
-- ----------------------------
INSERT INTO `tbManager` VALUES ('1', 'admin', 'E10ADC3949BA59ABBE56E057F20F883E', '张兴旺', '2016-11-30 09:50:06', '1', '0', '49', '1');
INSERT INTO `tbManager` VALUES ('3', 'sunyan', 'E10ADC3949BA59ABBE56E057F20F883E', '孙燕', '2016-11-30 09:50:06', '2', '0', '51', '1');
INSERT INTO `tbManager` VALUES ('241', 'suyang', 'c33367701511b4f6020ec61ded352059', '苏阳', '2018-07-03 14:05:36', '1', '0', '213', '1');
INSERT INTO `tbManager` VALUES ('4', 'zhangzhizhong', 'a8f5f167f44f4964e6c998dee827110c', '张志忠', '2017-03-03 09:11:43', '2', '0', '49', '2');
INSERT INTO `tbManager` VALUES ('240', 'machao001', '777e6b872bc84ab60b937056f30cce5f', '马超001', '2018-07-02 19:21:46', '2', '1', '217', '1');
INSERT INTO `tbManager` VALUES ('5', 'wangkun', '4297f44b13955235245b2497399d7a93', '王坤', '2018-06-22 10:02:07', '1', '0', '61', '1');
INSERT INTO `tbManager` VALUES ('6', 'lihongwei', '343b1c4a3ea721b2d640fc8700db0f36', '李宏伟', '2018-06-22 10:03:21', '1', '0', '78', '1');
INSERT INTO `tbManager` VALUES ('7', 'zhaoruike', '670b14728ad9902aecba32e22fa4f6bd', '赵瑞可', '2018-06-22 10:04:19', '1', '1', '99', '1');
INSERT INTO `tbManager` VALUES ('11', 'machao', '8c7c4283eac0b2d104ddb04b1a2889df', '马超', '2018-06-25 15:06:10', '2', '0', '61', '1');
INSERT INTO `tbManager` VALUES ('8', 'liuzhilan', 'efe6398127928f1b2e9ef3207fb82663', '刘志兰', '2018-06-25 14:21:30', '2', '0', '42', '1');
INSERT INTO `tbManager` VALUES ('9', 'chenminghao', '4297f44b13955235245b2497399d7a93', '陈明浩', '2018-06-25 14:59:49', '2', '0', '41', '1');
INSERT INTO `tbManager` VALUES ('10', 'wuzhubo', 'd41d8cd98f00b204e9800998ecf8427e', '吴柱波', '2018-06-25 15:00:59', '1', '0', '106', '1');

-- ----------------------------
-- Table structure for `tbUser`
-- ----------------------------
DROP TABLE IF EXISTS `tbUser`;
CREATE TABLE `tbUser` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbUser
-- ----------------------------
INSERT INTO `tbUser` VALUES ('1', ' 张君宝');
INSERT INTO `tbUser` VALUES ('2', '张无忌');
