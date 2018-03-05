/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : caiwei

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2018-03-05 19:26:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_mdm_data_termscode
-- ----------------------------
DROP TABLE IF EXISTS `t_mdm_data_termscode`;
CREATE TABLE `t_mdm_data_termscode` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `terms_code` varchar(50) NOT NULL COMMENT '条款编码',
  `terms_name` varchar(100) NOT NULL COMMENT '条款名称',
  `notes` varchar(255) DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  `create_time` datetime NOT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_terms_code` (`terms_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_mdm_data_termscode
-- ----------------------------

-- ----------------------------
-- Table structure for t_mdm_data_termsvalue
-- ----------------------------
DROP TABLE IF EXISTS `t_mdm_data_termsvalue`;
CREATE TABLE `t_mdm_data_termsvalue` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `value_code` varchar(50) NOT NULL COMMENT '值编码',
  `value_name` varchar(100) NOT NULL COMMENT '值名称',
  `terms_code` varchar(50) NOT NULL COMMENT '条款编码',
  `value_seq` tinyint(1) DEFAULT NULL COMMENT '排序',
  `notes` varchar(255) DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  `create_time` datetime NOT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_value_code` (`value_code`),
  KEY `idx_terms_code` (`terms_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_mdm_data_termsvalue
-- ----------------------------

-- ----------------------------
-- Table structure for t_mdm_org_department
-- ----------------------------
DROP TABLE IF EXISTS `t_mdm_org_department`;
CREATE TABLE `t_mdm_org_department` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dept_code` varchar(50) NOT NULL COMMENT '部门编码',
  `dept_name` varchar(100) NOT NULL COMMENT '部门名称',
  `parent_code` varchar(50) DEFAULT NULL COMMENT '父级部门编码',
  `parent_name` varchar(100) DEFAULT NULL COMMENT '父级部门名称',
  `status` tinyint(1) NOT NULL COMMENT '数据有效状态，0 有效，1 无效',
  `create_time` datetime NOT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_dept_code` (`dept_code`) USING BTREE,
  KEY `idx_parent_code` (`parent_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_mdm_org_department
-- ----------------------------

-- ----------------------------
-- Table structure for t_mdm_org_employee
-- ----------------------------
DROP TABLE IF EXISTS `t_mdm_org_employee`;
CREATE TABLE `t_mdm_org_employee` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `emp_code` varchar(50) NOT NULL,
  `emp_name` varchar(100) NOT NULL,
  `dept_code` varchar(50) NOT NULL,
  `dept_name` varchar(100) NOT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `mobile_no` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `tel_phone` varchar(50) DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  `create_time` datetime NOT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_emp_code` (`emp_code`) USING BTREE,
  KEY `idx_dept_code` (`dept_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_mdm_org_employee
-- ----------------------------

-- ----------------------------
-- Table structure for t_mdm_permis_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_mdm_permis_resource`;
CREATE TABLE `t_mdm_permis_resource` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `res_code` varchar(50) NOT NULL COMMENT '权限编码',
  `res_name` varchar(100) NOT NULL COMMENT '权限名称',
  `entry_url` varchar(255) DEFAULT NULL COMMENT '权限入口URI',
  `res_level` tinyint(1) unsigned NOT NULL COMMENT '功能层级(1：子系统 2：模块 3：菜单 4：按钮)',
  `parent_res` varchar(50) DEFAULT NULL COMMENT '上级权限',
  `res_type` tinyint(1) unsigned NOT NULL COMMENT '权限类型(1：子系统 2：模块 3：菜单 4：按钮)',
  `display_order` tinyint(1) unsigned DEFAULT NULL COMMENT '显示顺序',
  `checked` tinyint(1) DEFAULT NULL COMMENT '是否权限检查',
  `leaf_flag` tinyint(1) unsigned DEFAULT NULL COMMENT '是否叶子节点',
  `node_cls` varchar(50) DEFAULT NULL COMMENT '节点的CSS样式',
  `icon_cls` varchar(50) DEFAULT NULL COMMENT '图标的CSS样式',
  `system_code` varchar(50) DEFAULT NULL COMMENT '所属系统类型',
  `notes` varchar(255) DEFAULT NULL COMMENT '权限描述',
  `status` tinyint(1) unsigned NOT NULL COMMENT '逻辑删除',
  `create_time` datetime NOT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_resource_code` (`res_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_mdm_permis_resource
-- ----------------------------

-- ----------------------------
-- Table structure for t_mdm_permis_role
-- ----------------------------
DROP TABLE IF EXISTS `t_mdm_permis_role`;
CREATE TABLE `t_mdm_permis_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `role_code` varchar(50) NOT NULL COMMENT '角色CODE',
  `role_name` varchar(100) NOT NULL COMMENT '角色名称',
  `system_code` varchar(50) DEFAULT NULL COMMENT '系统编码',
  `type` varchar(50) DEFAULT NULL COMMENT '角色类型',
  `notes` varchar(255) DEFAULT NULL,
  `status` tinyint(1) unsigned NOT NULL COMMENT '逻辑删除（1：是 0：否）',
  `create_time` datetime NOT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_role_code` (`role_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_mdm_permis_role
-- ----------------------------

-- ----------------------------
-- Table structure for t_mdm_permis_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_mdm_permis_role_resource`;
CREATE TABLE `t_mdm_permis_role_resource` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `trole_id` int(11) NOT NULL COMMENT '角色ID',
  `tres_id` int(11) NOT NULL COMMENT '权限ID',
  `status` tinyint(1) unsigned NOT NULL,
  `create_time` datetime NOT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_role_code` (`trole_id`),
  KEY `idx_res_code` (`tres_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_mdm_permis_role_resource
-- ----------------------------

-- ----------------------------
-- Table structure for t_mdm_permis_user
-- ----------------------------
DROP TABLE IF EXISTS `t_mdm_permis_user`;
CREATE TABLE `t_mdm_permis_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_code` varchar(50) NOT NULL COMMENT '登录用户名',
  `pass_word` varchar(100) NOT NULL COMMENT '登录密码',
  `emp_code` varchar(50) DEFAULT NULL COMMENT '员工工号',
  `emp_name` varchar(100) DEFAULT NULL COMMENT '员工姓名',
  `dept_code` varchar(50) DEFAULT NULL COMMENT '组织编码',
  `last_login` datetime DEFAULT NULL COMMENT '上次登录时间',
  `notes` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` tinyint(1) unsigned NOT NULL COMMENT '逻辑删除（1：是 0：否）',
  `create_time` datetime NOT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_user_code` (`user_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_mdm_permis_user
-- ----------------------------
INSERT INTO `t_mdm_permis_user` VALUES ('7', '275688', '202CB962AC59075B964B07152D234B70', '275688', 'longhairen', 'DP0001', null, null, '1', '2017-11-06 19:49:58', null);

-- ----------------------------
-- Table structure for t_mdm_permis_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_mdm_permis_user_role`;
CREATE TABLE `t_mdm_permis_user_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `tuser_id` int(11) NOT NULL COMMENT '用户编码',
  `tdept_id` int(11) NOT NULL COMMENT '组织编码',
  `trole_id` int(11) NOT NULL COMMENT '角色编码',
  `status` tinyint(1) unsigned NOT NULL COMMENT '逻辑删除',
  `create_time` datetime NOT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_user_code` (`tuser_id`),
  KEY `idx_role_code` (`trole_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_mdm_permis_user_role
-- ----------------------------
