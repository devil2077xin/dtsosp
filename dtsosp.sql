/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : dtsosp

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 21/05/2020 10:20:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `userid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`, `username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, 'admin', 'admin', '123456', 1);

-- ----------------------------
-- Table structure for t_clazz
-- ----------------------------
DROP TABLE IF EXISTS `t_clazz`;
CREATE TABLE `t_clazz`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `info` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_clazz
-- ----------------------------
INSERT INTO `t_clazz` VALUES (1, '英语1班', '');
INSERT INTO `t_clazz` VALUES (4, '英语2班', '');
INSERT INTO `t_clazz` VALUES (5, '英语3班', '');
INSERT INTO `t_clazz` VALUES (6, '英语4班', NULL);
INSERT INTO `t_clazz` VALUES (7, '英语5班', NULL);
INSERT INTO `t_clazz` VALUES (8, '英语6班', NULL);

-- ----------------------------
-- Table structure for t_score
-- ----------------------------
DROP TABLE IF EXISTS `t_score`;
CREATE TABLE `t_score`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NULL DEFAULT NULL,
  `score1` double(5, 0) NULL DEFAULT NULL,
  `score2` double(5, 0) NULL DEFAULT NULL,
  `score3` double(5, 0) NULL DEFAULT NULL,
  `score4` double(5, 0) NULL DEFAULT NULL,
  `score5` double(5, 0) NULL DEFAULT NULL,
  `score6` double(5, 0) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_score
-- ----------------------------
INSERT INTO `t_score` VALUES (1, 4, 55, 44, 66, 74, 55, 71, '');
INSERT INTO `t_score` VALUES (2, 2, 86, 55, 55, 77, 88, 99, '');
INSERT INTO `t_score` VALUES (3, 9, 22, 69, 33, 44, 55, 66, 'dauhdia');

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `userid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `clazz_id` int(5) NOT NULL,
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '男',
  `mobile` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qq` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `username`) USING BTREE,
  INDEX `student_clazz_id_foreign`(`clazz_id`) USING BTREE,
  CONSTRAINT `student_clazz_id_foreign` FOREIGN KEY (`clazz_id`) REFERENCES `t_clazz` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES (2, '20160101', '张三', '123456', 1, '男', '13545454548', '1332365656');
INSERT INTO `t_student` VALUES (4, '20160102', '李四', '123456', 4, '男', '13356565655', '123456');
INSERT INTO `t_student` VALUES (9, '20160103', '王五1', '123456', 5, '女', '13333332133', '1313131323');

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `userid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `clazz_id` int(5) NOT NULL,
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '男',
  `mobile` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qq` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `username`) USING BTREE,
  INDEX `student_clazz_id_foreign`(`clazz_id`) USING BTREE,
  CONSTRAINT `t_teacher_ibfk_1` FOREIGN KEY (`clazz_id`) REFERENCES `t_clazz` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES (9, '199701', '张小', '123456', 1, '男', '13918655656', '1193284480');
INSERT INTO `t_teacher` VALUES (10, '199702', '李低', '123456', 4, '男', '13656565656', '123456');
INSERT INTO `t_teacher` VALUES (11, '199703', '李网', '1234567', 5, '女', '18989898981', '1456655565');
INSERT INTO `t_teacher` VALUES (18, '199704', '夏青松', '123456', 5, '男', '15174857847', '1745854125');
INSERT INTO `t_teacher` VALUES (19, '199705', '李九', '123456', 7, '男', '13111111112', '124545');
INSERT INTO `t_teacher` VALUES (21, '199706', 'devil', '12345678', 8, '男', '', '');
INSERT INTO `t_teacher` VALUES (25, '199710', '小张', '123456', 6, '男', '', '');

SET FOREIGN_KEY_CHECKS = 1;
