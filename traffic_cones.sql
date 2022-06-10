/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : traffic_cones

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 01/02/2021 20:47:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cones
-- ----------------------------
DROP TABLE IF EXISTS `cones`;
CREATE TABLE `cones`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `cone_id` bigint(11) NULL DEFAULT NULL COMMENT '锥桶id',
  `cone_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '锥桶名称',
  `type` tinyint(2) NULL DEFAULT NULL COMMENT '锥桶类别。1：高速交通，2：普通道路，3：街道',
  `in_time` datetime NULL DEFAULT NULL COMMENT '采购时间',
  `user_id` int(10) NULL DEFAULT NULL COMMENT '负责人id',
  `user_flag` tinyint(2) NULL DEFAULT NULL COMMENT '使用状态 1，正在使用中，2，库存保存中',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '当前位置',
  `battery_left` int(3) UNSIGNED NULL DEFAULT NULL COMMENT '系统电量:满电为100%',
  `scrap_time` datetime NULL DEFAULT NULL COMMENT '报废时间',
  `scrap_flag` tinyint(2) NULL DEFAULT NULL COMMENT '报废标志：0未报废，1报废',
  `createtime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cones
-- ----------------------------
INSERT INTO `cones` VALUES (8, 1611470789100, '测试2', 3, '2021-01-13 00:00:00', 1, 2, '是懂法守法', 56, NULL, 2, '2021-01-24 14:46:29');

-- ----------------------------
-- Table structure for dispatch
-- ----------------------------
DROP TABLE IF EXISTS `dispatch`;
CREATE TABLE `dispatch`  (
  `id` int(11) NOT NULL,
  `cones_id` int(11) NULL DEFAULT NULL COMMENT '锥桶id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '调度用户id',
  `accident_type` tinyint(2) NULL DEFAULT NULL COMMENT '事故类别',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '部署位置',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '调度状态：1正在使用中，2已完成',
  `createtime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '手机号码',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
  `admin_flag` tinyint(1) NULL DEFAULT NULL COMMENT '是否为管理员',
  `last_login` datetime NULL DEFAULT NULL COMMENT '上次登陆时间',
  `is_active` tinyint(1) NULL DEFAULT NULL COMMENT '是否激活',
  `createtime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '梅金东', '1', NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for warning_info
-- ----------------------------
DROP TABLE IF EXISTS `warning_info`;
CREATE TABLE `warning_info`  (
  `id` int(11) NOT NULL,
  `msg_id` int(11) NULL DEFAULT NULL COMMENT '消息id',
  `cone_id` int(11) NULL DEFAULT NULL COMMENT '锥桶id',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '事故发生位置',
  `msg_type` tinyint(2) NULL DEFAULT NULL COMMENT '消息类别',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '消息状态',
  `createtime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
