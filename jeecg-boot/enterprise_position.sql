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

 Date: 03/03/2020 10:54:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for enterprise_position
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_position`;
CREATE TABLE `enterprise_position` (
  `id` varchar(32) NOT NULL COMMENT '职位序号',
  `enterprise_id` varchar(32) DEFAULT NULL COMMENT '公司Id',
  `enterprise_name` varchar(50) NOT NULL COMMENT '公司名称',
  `position` varchar(20) NOT NULL COMMENT '职位名称',
  `experience` varchar(20) DEFAULT NULL COMMENT '经验要求',
  `education` varchar(20) DEFAULT NULL COMMENT '学历要求',
  `salary_lower` int(10) DEFAULT NULL COMMENT '薪资范围下限',
  `salary_upper` int(10) DEFAULT NULL COMMENT '薪资范围上限',
  `position_key` varchar(50) DEFAULT NULL COMMENT '职位关键词',
  `position_title` varchar(100) DEFAULT NULL COMMENT '岗位描述小标题',
  `position_content` varchar(255) DEFAULT NULL COMMENT '岗位描述正文内容',
  `work_address` varchar(256) DEFAULT NULL COMMENT '工作地址',
  `release_time` datetime DEFAULT NULL COMMENT '发布时间',
  `status` varchar(20) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(20) DEFAULT NULL COMMENT '更新者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `region_full_name` varchar(256) DEFAULT NULL COMMENT '工作城市',
  `hire_number` int(10) DEFAULT NULL COMMENT '招聘人数',
  `phone` varchar(32) DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
