/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : butterfly

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2018-03-30 16:44:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_bse_data_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `t_bse_data_dictionary`;
CREATE TABLE `t_bse_data_dictionary` (
  `ID` varchar(50) NOT NULL DEFAULT '',
  `TERMS_CODE` varchar(50) DEFAULT NULL,
  `TERMS_NAME` varchar(100) DEFAULT NULL,
  `IF_LEAF` char(1) DEFAULT NULL,
  `PARENT_TERMS_CODE` varchar(50) DEFAULT NULL,
  `NOTES` varchar(100) DEFAULT NULL,
  `ACTIVE` char(1) DEFAULT NULL,
  `VERSION_NO` decimal(18,0) DEFAULT NULL,
  `CREATE_TIME` date DEFAULT NULL,
  `CREATE_USER_CODE` varchar(50) DEFAULT NULL,
  `MODIFY_TIME` varchar(50) DEFAULT NULL,
  `MODIFY_USER_CODE` date DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_bse_data_dictionary
-- ----------------------------
