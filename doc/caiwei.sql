/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : caiwei

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 26/03/2018 23:01:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_mdm_data_termscode
-- ----------------------------
DROP TABLE IF EXISTS `t_mdm_data_termscode`;
CREATE TABLE `t_mdm_data_termscode`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `terms_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '条款编码',
  `terms_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '条款名称',
  `notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  `create_time` datetime(0) NULL,
  `modify_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_terms_code`(`terms_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_mdm_data_termscode
-- ----------------------------
INSERT INTO `t_mdm_data_termscode` VALUES (1, 'GENDER', '性别', NULL, 0, '2018-03-09 15:54:19', NULL);

-- ----------------------------
-- Table structure for t_mdm_data_termsvalue
-- ----------------------------
DROP TABLE IF EXISTS `t_mdm_data_termsvalue`;
CREATE TABLE `t_mdm_data_termsvalue`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `value_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '值编码',
  `value_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '值名称',
  `terms_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '条款编码',
  `value_seq` tinyint(1) NULL DEFAULT NULL COMMENT '排序',
  `notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  `create_time` datetime(0) NULL,
  `modify_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_value_code`(`value_code`) USING BTREE,
  INDEX `idx_terms_code`(`terms_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_mdm_data_termsvalue
-- ----------------------------
INSERT INTO `t_mdm_data_termsvalue` VALUES (1, 'FEMALE', '女', 'GENDER', 1, NULL, 0, '2018-03-09 15:56:57', NULL);
INSERT INTO `t_mdm_data_termsvalue` VALUES (2, 'MALE', '男', 'GENDER', 2, NULL, 0, '2018-03-09 15:56:57', NULL);

-- ----------------------------
-- Table structure for t_mdm_org_department
-- ----------------------------
DROP TABLE IF EXISTS `t_mdm_org_department`;
CREATE TABLE `t_mdm_org_department`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `dept_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门编码',
  `dept_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `parent_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父级部门编码',
  `parent_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父级部门名称',
  `status` tinyint(1) NOT NULL COMMENT '数据有效状态，0 有效，1 无效',
  `create_time` datetime(0) NULL,
  `modify_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_dept_code`(`dept_code`) USING BTREE,
  INDEX `idx_parent_code`(`parent_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_mdm_org_department
-- ----------------------------
INSERT INTO `t_mdm_org_department` VALUES (1, '00001', '集团', NULL, NULL, 0, '2018-03-08 10:53:50', NULL);

-- ----------------------------
-- Table structure for t_mdm_org_employee
-- ----------------------------
DROP TABLE IF EXISTS `t_mdm_org_employee`;
CREATE TABLE `t_mdm_org_employee`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `emp_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `emp_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dept_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dept_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` tinyint(1) NULL DEFAULT NULL COMMENT '0 女 1 男',
  `mobile_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel_phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  `create_time` datetime(0) NULL,
  `modify_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_emp_code`(`emp_code`) USING BTREE,
  INDEX `idx_dept_code`(`dept_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_mdm_org_employee
-- ----------------------------
INSERT INTO `t_mdm_org_employee` VALUES (1, '275688', 'longhairen', '00001', '集团', 1, '18621526765', '1234354@qq.com', NULL, 0, '2018-03-08 10:51:55', NULL);

-- ----------------------------
-- Table structure for t_mdm_permis_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_mdm_permis_resource`;
CREATE TABLE `t_mdm_permis_resource`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `res_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限编码',
  `res_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名称',
  `entry_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限入口URI',
  `res_level` tinyint(1) UNSIGNED NOT NULL COMMENT '功能层级(1：子系统 2：模块 3：菜单 4：按钮)',
  `parent_res` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上级权限',
  `res_type` tinyint(1) UNSIGNED NOT NULL COMMENT '权限类型(1：子系统 2：模块 3：菜单 4：按钮)',
  `display_order` tinyint(1) UNSIGNED NULL DEFAULT NULL COMMENT '显示顺序',
  `checked` tinyint(1) NULL DEFAULT NULL COMMENT '是否权限检查',
  `leaf_flag` tinyint(1) UNSIGNED NULL DEFAULT NULL COMMENT '是否叶子节点',
  `node_cls` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '节点的CSS样式',
  `icon_cls` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标的CSS样式',
  `system_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属系统类型',
  `notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限描述',
  `status` tinyint(1) UNSIGNED NOT NULL COMMENT '逻辑删除',
  `create_time` datetime(0) NULL,
  `modify_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_resource_code`(`res_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_mdm_permis_resource
-- ----------------------------
INSERT INTO `t_mdm_permis_resource` VALUES (1, 'console_1', 'CONSOLE系统', '', 1, '', 1, 1, 0, 1, 'ye1-node-lvl1', 'butterfly_icons_emp', 'web', '', 0, '2018-03-08 11:17:12', '2018-03-10 19:14:48');
INSERT INTO `t_mdm_permis_resource` VALUES (2, 'console_110', '综合管理', '', 2, 'console_1', 2, 1, 0, 1, 'ye1-node-lvl2', 'butterfly_icons_emp', 'web', '', 0, '2018-03-08 11:17:12', '2018-03-10 19:14:42');
INSERT INTO `t_mdm_permis_resource` VALUES (3, 'console_120', '基础数据', '', 2, 'console_1', 2, 2, 0, 1, 'ye1-node-lvl2', 'butterfly_icons_emp', 'web', '', 0, '2018-03-08 11:17:12', '2018-03-10 19:14:31');
INSERT INTO `t_mdm_permis_resource` VALUES (4, 'console_130', '系统设置', '', 2, 'console_1', 2, 3, 0, 1, 'ye1-node-lvl2', 'butterfly_icons_emp', 'web', '', 0, '2018-03-08 11:17:12', '2018-03-10 19:14:29');
INSERT INTO `t_mdm_permis_resource` VALUES (5, 'console_130001', '用户管理', '/console/user/index', 3, 'console_130', 3, 1, 0, 0, 'ye1-node-lvl3', 'butterfly_icons_emp', 'web', '', 0, '2018-03-09 18:13:59', '2018-03-10 17:23:12');
INSERT INTO `t_mdm_permis_resource` VALUES (6, 'console_130002', '角色管理', '/console/role/index', 3, 'console_130', 3, 2, 0, 0, 'ye1-node-lvl3', 'butterfly_icons_emp', 'web', '', 0, '2018-03-09 18:13:59', '2018-03-24 16:13:18');

-- ----------------------------
-- Table structure for t_mdm_permis_role
-- ----------------------------
DROP TABLE IF EXISTS `t_mdm_permis_role`;
CREATE TABLE `t_mdm_permis_role`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `role_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色CODE',
  `role_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `system_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统编码',
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色类型',
  `notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` tinyint(1) UNSIGNED NOT NULL COMMENT '逻辑删除（1：是 0：否）',
  `create_time` datetime(0) NULL,
  `modify_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_role_code`(`role_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_mdm_permis_role
-- ----------------------------
INSERT INTO `t_mdm_permis_role` VALUES (1, 'admin', 'admin', 'web', NULL, NULL, 0, '2018-03-08 10:57:14', '2018-03-24 16:22:22');
INSERT INTO `t_mdm_permis_role` VALUES (2, 'subadmin', '系统管理员', 'web', 'web', '系统管理员', 0, '2018-03-24 16:45:40', '2018-03-24 17:54:17');
INSERT INTO `t_mdm_permis_role` VALUES (3, 'hello', 'hello', '', '', '', 0, '2018-03-25 17:33:04', '2018-03-25 17:33:04');

-- ----------------------------
-- Table structure for t_mdm_permis_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_mdm_permis_role_resource`;
CREATE TABLE `t_mdm_permis_role_resource`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `role_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色ID',
  `res_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限ID',
  `status` tinyint(1) UNSIGNED NOT NULL,
  `create_time` datetime(0) NULL,
  `modify_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_role_code`(`role_code`) USING BTREE,
  INDEX `idx_res_code`(`res_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_mdm_permis_role_resource
-- ----------------------------
INSERT INTO `t_mdm_permis_role_resource` VALUES (1, 'admin', 'console_1', 0, '2018-03-08 11:21:02', '2018-03-08 18:13:46');
INSERT INTO `t_mdm_permis_role_resource` VALUES (2, 'admin', 'console_110', 0, '2018-03-08 11:21:02', '2018-03-08 18:13:50');
INSERT INTO `t_mdm_permis_role_resource` VALUES (3, 'admin', 'console_120', 0, '2018-03-08 11:21:02', '2018-03-08 18:13:56');
INSERT INTO `t_mdm_permis_role_resource` VALUES (4, 'admin', 'console_130', 0, '2018-03-08 11:21:02', '2018-03-08 18:14:00');
INSERT INTO `t_mdm_permis_role_resource` VALUES (5, 'admin', 'console_130001', 0, '2018-03-09 22:16:30', NULL);
INSERT INTO `t_mdm_permis_role_resource` VALUES (6, 'admin', 'console_130002', 0, '2018-03-09 22:16:30', NULL);

-- ----------------------------
-- Table structure for t_mdm_permis_user
-- ----------------------------
DROP TABLE IF EXISTS `t_mdm_permis_user`;
CREATE TABLE `t_mdm_permis_user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录用户名',
  `pass_word` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `emp_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工工号',
  `emp_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `dept_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组织编码',
  `last_login` datetime(0) NULL DEFAULT NULL COMMENT '上次登录时间',
  `notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `status` tinyint(1) UNSIGNED NOT NULL COMMENT '逻辑删除（1：是 0：否）',
  `create_time` datetime(0) NULL,
  `modify_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_user_code`(`user_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_mdm_permis_user
-- ----------------------------
INSERT INTO `t_mdm_permis_user` VALUES (7, '275688', '202CB962AC59075B964B07152D234B70', '275688', 'longhairen', 'DP0001', NULL, NULL, 0, '2017-11-06 19:49:58', '2018-03-14 23:14:33');
INSERT INTO `t_mdm_permis_user` VALUES (8, '123456', 'E10ADC3949BA59ABBE56E057F20F883E', '275688', 'longhairen', '00001', NULL, '', 1, '2018-03-24 10:10:31', '2018-03-24 10:15:32');
INSERT INTO `t_mdm_permis_user` VALUES (9, '147258', '4607E782C4D86FD5364D7E4508BB10D9', '275688', 'longhairen', '00001', NULL, '', 1, '2018-03-24 10:15:18', '2018-03-24 10:15:32');
INSERT INTO `t_mdm_permis_user` VALUES (10, '159963', 'D04736115A4AFBD35DE30D9F0AFF0E03', '275688', 'longhairen', '0123', NULL, '', 1, '2018-03-24 10:23:06', '2018-03-24 10:23:17');

-- ----------------------------
-- Table structure for t_mdm_permis_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_mdm_permis_user_role`;
CREATE TABLE `t_mdm_permis_user_role`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户编码',
  `dept_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '组织编码',
  `role_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编码',
  `status` tinyint(1) UNSIGNED NOT NULL COMMENT '逻辑删除',
  `create_time` datetime(0) NULL,
  `modify_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_user_code`(`user_code`) USING BTREE,
  INDEX `idx_role_code`(`role_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_mdm_permis_user_role
-- ----------------------------
INSERT INTO `t_mdm_permis_user_role` VALUES (1, '275688', '00001', 'admin', 0, '2018-03-08 11:01:13', '2018-03-08 18:12:52');

SET FOREIGN_KEY_CHECKS = 1;
