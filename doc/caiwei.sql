/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : caiwei

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2018-03-28 20:38:01
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
  `create_time` datetime DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_terms_code` (`terms_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_mdm_data_termscode
-- ----------------------------
INSERT INTO `t_mdm_data_termscode` VALUES ('1', 'GENDER', '性别', null, '0', '2018-03-09 15:54:19', null);
INSERT INTO `t_mdm_data_termscode` VALUES ('2', 'SYSTEM_TYPE', '系统类型', null, '0', '2018-03-28 09:41:54', null);
INSERT INTO `t_mdm_data_termscode` VALUES ('3', 'JURISDICTION_TYPE', '权限类型', null, '0', '2018-03-28 09:41:54', null);
INSERT INTO `t_mdm_data_termscode` VALUES ('4', 'RESOURCES_LEVEL', '权限级别', null, '0', '2018-03-28 09:41:54', null);

-- ----------------------------
-- Table structure for t_mdm_data_termsvalue
-- ----------------------------
DROP TABLE IF EXISTS `t_mdm_data_termsvalue`;
CREATE TABLE `t_mdm_data_termsvalue` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `value_code` varchar(50) NOT NULL COMMENT '值编码',
  `value_name` varchar(100) NOT NULL COMMENT '值名称',
  `terms_code` varchar(50) NOT NULL COMMENT '条款编码',
  `terms_name` varchar(100) NOT NULL,
  `value_seq` tinyint(1) DEFAULT NULL COMMENT '排序',
  `notes` varchar(255) DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_value_code` (`value_code`) USING BTREE,
  KEY `idx_terms_code` (`terms_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_mdm_data_termsvalue
-- ----------------------------
INSERT INTO `t_mdm_data_termsvalue` VALUES ('1', 'FEMALE', '女', 'GENDER', '性别', '1', null, '1', '2018-03-09 15:56:57', '2018-03-28 17:47:17');
INSERT INTO `t_mdm_data_termsvalue` VALUES ('2', 'MALE', '男', 'GENDER', '性别', '2', null, '1', '2018-03-09 15:56:57', '2018-03-28 17:47:17');
INSERT INTO `t_mdm_data_termsvalue` VALUES ('3', 'WEB', 'WEB', 'SYSTEM_TYPE', '系统类型', '1', null, '0', '2018-03-28 09:50:08', '2018-03-28 16:49:18');
INSERT INTO `t_mdm_data_termsvalue` VALUES ('4', 'APP', 'APP', 'SYSTEM_TYPE', '系统类型', '2', null, '0', '2018-03-28 09:50:08', '2018-03-28 16:49:26');
INSERT INTO `t_mdm_data_termsvalue` VALUES ('5', '1', '子系统', 'JURISDICTION_TYPE', '权限类型', '1', null, '0', '2018-03-28 09:50:08', '2018-03-28 16:49:26');
INSERT INTO `t_mdm_data_termsvalue` VALUES ('6', '2', '模块', 'JURISDICTION_TYPE', '权限类型', '2', null, '0', '2018-03-28 09:50:08', '2018-03-28 16:49:27');
INSERT INTO `t_mdm_data_termsvalue` VALUES ('7', '3', '菜单', 'JURISDICTION_TYPE', '权限类型', '3', null, '0', '2018-03-28 09:50:08', '2018-03-28 16:49:28');
INSERT INTO `t_mdm_data_termsvalue` VALUES ('8', '4', '按钮', 'JURISDICTION_TYPE', '权限类型', '4', null, '0', '2018-03-28 09:50:08', '2018-03-28 16:49:33');
INSERT INTO `t_mdm_data_termsvalue` VALUES ('9', '1', '1', 'RESOURCES_LEVEL', '权限级别', '1', null, '0', '2018-03-28 09:50:08', '2018-03-28 16:49:33');
INSERT INTO `t_mdm_data_termsvalue` VALUES ('10', '2', '2', 'RESOURCES_LEVEL', '权限级别', '2', null, '0', '2018-03-28 09:50:08', '2018-03-28 16:49:34');
INSERT INTO `t_mdm_data_termsvalue` VALUES ('11', '3', '3', 'RESOURCES_LEVEL', '权限级别', '3', null, '0', '2018-03-28 09:50:08', '2018-03-28 16:49:35');
INSERT INTO `t_mdm_data_termsvalue` VALUES ('12', '4', '4', 'RESOURCES_LEVEL', '权限级别', '4', null, '0', '2018-03-28 09:50:08', '2018-03-28 16:49:38');

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
  `create_time` datetime DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_dept_code` (`dept_code`) USING BTREE,
  KEY `idx_parent_code` (`parent_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_mdm_org_department
-- ----------------------------
INSERT INTO `t_mdm_org_department` VALUES ('1', '00001', '集团', null, null, '0', '2018-03-08 10:53:50', null);

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
  `gender` tinyint(1) DEFAULT NULL COMMENT '0 女 1 男',
  `mobile_no` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `tel_phone` varchar(50) DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_emp_code` (`emp_code`) USING BTREE,
  KEY `idx_dept_code` (`dept_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_mdm_org_employee
-- ----------------------------
INSERT INTO `t_mdm_org_employee` VALUES ('1', '275688', 'longhairen', '00001', '集团', '1', '18621526765', '1234354@qq.com', null, '0', '2018-03-08 10:51:55', null);

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
  `create_time` datetime DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_resource_code` (`res_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_mdm_permis_resource
-- ----------------------------
INSERT INTO `t_mdm_permis_resource` VALUES ('1', 'console_1', 'CONSOLE系统', '', '1', '', '1', '1', '0', '1', 'ye1-node-lvl1', 'butterfly_icons_emp', 'WEB', '', '0', '2018-03-08 11:17:12', '2018-03-28 10:38:38');
INSERT INTO `t_mdm_permis_resource` VALUES ('2', 'console_110', '综合管理', '', '2', 'console_1', '2', '1', '0', '1', 'ye1-node-lvl2', 'butterfly_icons_emp', 'WEB', '', '0', '2018-03-08 11:17:12', '2018-03-28 10:38:38');
INSERT INTO `t_mdm_permis_resource` VALUES ('3', 'console_120', '基础数据', '', '2', 'console_1', '2', '2', '0', '1', 'ye1-node-lvl2', 'butterfly_icons_emp', 'WEB', '', '0', '2018-03-08 11:17:12', '2018-03-28 10:38:38');
INSERT INTO `t_mdm_permis_resource` VALUES ('4', 'console_130', '系统设置', '', '2', 'console_1', '2', '3', '0', '1', 'ye1-node-lvl2', 'butterfly_icons_emp', 'WEB', '', '0', '2018-03-08 11:17:12', '2018-03-28 10:39:19');
INSERT INTO `t_mdm_permis_resource` VALUES ('5', 'console_130001', '用户管理', '/console/user/index', '3', 'console_130', '3', '1', '0', '0', 'ye1-node-lvl3', 'butterfly_icons_emp', 'WEB', '', '0', '2018-03-09 18:13:59', '2018-03-28 10:39:19');
INSERT INTO `t_mdm_permis_resource` VALUES ('6', 'console_130002', '角色管理', '/console/role/index', '3', 'console_130', '3', '2', '0', '0', 'ye1-node-lvl3', 'butterfly_icons_emp', 'WEB', '', '0', '2018-03-09 18:13:59', '2018-03-28 10:39:19');
INSERT INTO `t_mdm_permis_resource` VALUES ('7', 'console_130003', '资源管理', '/console/resource/index', '3', 'console_130', '3', '2', '0', '0', 'ye1-node-lvl3', 'butterfly_icons_emp', 'WEB', '', '0', '2018-03-09 18:13:59', '2018-03-28 10:39:19');
INSERT INTO `t_mdm_permis_resource` VALUES ('8', 'console_120001', '词条管理', '/console/terms/index', '3', 'console_120', '3', '1', '0', '0', 'ye1-node-lvl3', 'butterfly_icons_emp', 'WEB', '', '0', '2018-03-28 12:45:11', '2018-03-28 12:45:11');
INSERT INTO `t_mdm_permis_resource` VALUES ('9', 'console_120002', '词条管理1', '/console/terms/index', '3', 'console_120', '3', '2', '0', '0', 'ye1-node-lvl3', 'butterfly_icons_emp', 'WEB', '', '0', null, '2018-03-28 14:50:03');

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
  `create_time` datetime DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_role_code` (`role_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_mdm_permis_role
-- ----------------------------
INSERT INTO `t_mdm_permis_role` VALUES ('1', 'admin', 'admin', 'web', null, null, '0', '2018-03-08 10:57:14', '2018-03-24 16:22:22');
INSERT INTO `t_mdm_permis_role` VALUES ('2', 'subadmin', '系统管理员', 'web', 'web', '系统管理员', '1', '2018-03-24 16:45:40', '2018-03-27 13:58:34');
INSERT INTO `t_mdm_permis_role` VALUES ('3', 'hello', 'hello', '', '', '', '0', '2018-03-25 17:33:04', '2018-03-25 17:33:04');

-- ----------------------------
-- Table structure for t_mdm_permis_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_mdm_permis_role_resource`;
CREATE TABLE `t_mdm_permis_role_resource` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `role_code` varchar(50) NOT NULL COMMENT '角色ID',
  `res_code` varchar(50) NOT NULL COMMENT '权限ID',
  `status` tinyint(1) unsigned NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_role_code` (`role_code`) USING BTREE,
  KEY `idx_res_code` (`res_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_mdm_permis_role_resource
-- ----------------------------
INSERT INTO `t_mdm_permis_role_resource` VALUES ('1', 'admin', 'console_1', '0', '2018-03-08 11:21:02', '2018-03-08 18:13:46');
INSERT INTO `t_mdm_permis_role_resource` VALUES ('2', 'admin', 'console_110', '0', '2018-03-08 11:21:02', '2018-03-08 18:13:50');
INSERT INTO `t_mdm_permis_role_resource` VALUES ('3', 'admin', 'console_120', '0', '2018-03-08 11:21:02', '2018-03-08 18:13:56');
INSERT INTO `t_mdm_permis_role_resource` VALUES ('4', 'admin', 'console_130', '0', '2018-03-08 11:21:02', '2018-03-08 18:14:00');
INSERT INTO `t_mdm_permis_role_resource` VALUES ('5', 'admin', 'console_130001', '0', '2018-03-09 22:16:30', null);
INSERT INTO `t_mdm_permis_role_resource` VALUES ('6', 'admin', 'console_130002', '0', '2018-03-09 22:16:30', null);
INSERT INTO `t_mdm_permis_role_resource` VALUES ('7', 'admin', 'console_130003', '0', '2018-03-09 22:16:30', null);
INSERT INTO `t_mdm_permis_role_resource` VALUES ('8', 'admin', 'console_120001', '0', '2018-03-09 22:16:30', null);

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
  `create_time` datetime DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_user_code` (`user_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_mdm_permis_user
-- ----------------------------
INSERT INTO `t_mdm_permis_user` VALUES ('7', '275688', '202CB962AC59075B964B07152D234B70', '275688', 'longhairen', 'DP0001', null, null, '0', '2017-11-06 19:49:58', '2018-03-14 23:14:33');
INSERT INTO `t_mdm_permis_user` VALUES ('8', '123456', 'E10ADC3949BA59ABBE56E057F20F883E', '275688', 'longhairen', '00001', null, '', '1', '2018-03-24 10:10:31', '2018-03-24 10:15:32');
INSERT INTO `t_mdm_permis_user` VALUES ('9', '147258', '4607E782C4D86FD5364D7E4508BB10D9', '275688', 'longhairen', '00001', null, '', '1', '2018-03-24 10:15:18', '2018-03-24 10:15:32');
INSERT INTO `t_mdm_permis_user` VALUES ('10', '159963', 'D04736115A4AFBD35DE30D9F0AFF0E03', '275688', 'longhairen', '0123', null, '', '1', '2018-03-24 10:23:06', '2018-03-24 10:23:17');

-- ----------------------------
-- Table structure for t_mdm_permis_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_mdm_permis_user_role`;
CREATE TABLE `t_mdm_permis_user_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_code` varchar(50) NOT NULL COMMENT '用户编码',
  `dept_code` varchar(50) NOT NULL COMMENT '组织编码',
  `role_code` varchar(50) NOT NULL COMMENT '角色编码',
  `status` tinyint(1) unsigned NOT NULL COMMENT '逻辑删除',
  `create_time` datetime DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_user_code` (`user_code`) USING BTREE,
  KEY `idx_role_code` (`role_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_mdm_permis_user_role
-- ----------------------------
INSERT INTO `t_mdm_permis_user_role` VALUES ('1', '275688', '00001', 'admin', '0', '2018-03-08 11:01:13', '2018-03-08 18:12:52');
