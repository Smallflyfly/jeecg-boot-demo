/*
 Navicat MySQL Data Transfer

 Source Server         : employ
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : 10.23.12.225:3306
 Source Schema         : m-job

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 03/03/2020 11:04:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for enterprise
-- ----------------------------
DROP TABLE IF EXISTS `enterprise`;
CREATE TABLE `enterprise` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'id',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `short_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '简称',
  `logo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'logo',
  `type` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '公司类型',
  `industry` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所属行业',
  `region_id` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '所属行政区域编码',
  `region_full_name` varchar(256) CHARACTER SET utf8 DEFAULT NULL COMMENT '所属行政区域全名',
  `longitude` decimal(10,6) DEFAULT NULL COMMENT '经度',
  `latitude` decimal(10,6) DEFAULT NULL COMMENT '纬度',
  `enable` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT '1' COMMENT '状态',
  `home_page_title` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '主页简介',
  `home_page_text` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '主页正文',
  `contact` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系人',
  `contact_phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `pictures` varchar(512) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '公司照片',
  `create_by` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='企业表';

SET FOREIGN_KEY_CHECKS = 1;
