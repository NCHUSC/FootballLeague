/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : league_managesystem

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 06/06/2018 09:27:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
BEGIN;
INSERT INTO `hibernate_sequence` VALUES (186);
INSERT INTO `hibernate_sequence` VALUES (186);
COMMIT;

-- ----------------------------
-- Table structure for league
-- ----------------------------
DROP TABLE IF EXISTS `league`;
CREATE TABLE `league` (
  `league_id` int(11) NOT NULL AUTO_INCREMENT,
  `constitution` varchar(255) DEFAULT NULL,
  `end_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `league_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shorter_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sponsor` varchar(255) DEFAULT NULL,
  `start_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `abstention_score` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `half_relax_time` varchar(255) DEFAULT NULL,
  `half_time` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`league_id`)
) ENGINE=MyISAM AUTO_INCREMENT=186 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of league
-- ----------------------------
BEGIN;
INSERT INTO `league` VALUES (177, '民主富强', '2018-05-23', '软件学院杯', '软件', '软件学院', '2018-05-21', '3:0(负)', NULL, '20分钟', '30分钟', '大学', 11);
INSERT INTO `league` VALUES (164, '主办方有权在未通知的情况下增加、删除、改动本章程，本章程最终解释权属于主办方所有', '2018-06-23', '欧洲冠军杯', '欧冠', '欧洲', '2018-06-01', '3:0(负)', NULL, '40分钟', '45分钟', '职业联赛', 11);
INSERT INTO `league` VALUES (185, 'test2', '2018-06-23', 'test2', 'test2', 'test2', '2018-06-01', '3:0(负)', NULL, '20分钟', '10分钟', '大学', 11);
INSERT INTO `league` VALUES (158, '主办方有权在未通知的情况下增加、删除、改动本章程，本章程最终解释权属于主办方所有', '2018-05-30', '西班牙甲级足球联赛', '西甲联赛', '西班牙', '2018-05-21', '3:0(负)', NULL, '20分钟', '45分钟', '职业联赛', 11);
INSERT INTO `league` VALUES (94, '主办方有权在未通知的情况下增加、删除、改动本章程，本章程最终解释权属于主办方所有', '2018-05-30', '德国足球甲级联赛', '德甲联赛', '德国', '2018-05-21', '3:0(负)', NULL, '40分钟', '45分钟', '职业联赛', 11);
INSERT INTO `league` VALUES (93, '主办方有权在未通知的情况下增加、删除、改动本章程，本章程最终解释权属于主办方所有', '2018-06-30', '欧洲冠军杯联赛', '欧冠联赛', '欧洲', '2018-05-31', '3:0(负)', NULL, '30分钟', '45分钟', '职业联赛', 11);
INSERT INTO `league` VALUES (183, 'test', '2018-06-04', 'test', 'test', 'test', '2018-05-21', '1:0(负)', NULL, '5分钟', '10分钟', '职业联赛', 3);
COMMIT;

-- ----------------------------
-- Table structure for match_result
-- ----------------------------
DROP TABLE IF EXISTS `match_result`;
CREATE TABLE `match_result` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rleague` varchar(50) NOT NULL,
  `rmatch_date` varchar(50) NOT NULL,
  `rhome_team` varchar(50) NOT NULL,
  `rguest_team` varchar(50) NOT NULL,
  `score` varchar(50) NOT NULL,
  `winner` varchar(50) NOT NULL,
  `home_goals` int(11) NOT NULL,
  `guest_goals` int(11) NOT NULL,
  `match_id` int(11) NOT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of match_result
-- ----------------------------
BEGIN;
INSERT INTO `match_result` VALUES (16, '中超联赛', '2018-06-08', '凯尔特人', '骑士', '5:3', '骑士', 3, 5, 2);
INSERT INTO `match_result` VALUES (17, 'AC米兰', '2018-05-30', '火箭', '勇士', '1:3', '火箭', 3, 1, 1);
COMMIT;

-- ----------------------------
-- Table structure for matchinformation
-- ----------------------------
DROP TABLE IF EXISTS `matchinformation`;
CREATE TABLE `matchinformation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `league` varchar(255) DEFAULT NULL,
  `round` varchar(255) DEFAULT NULL,
  `matchDate` date DEFAULT NULL,
  `homeTeam` varchar(255) DEFAULT NULL,
  `guestTeam` varchar(255) DEFAULT NULL,
  `referee` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `field` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of matchinformation
-- ----------------------------
BEGIN;
INSERT INTO `matchinformation` VALUES (1, 'AC米兰', '第1轮', '2018-05-30', '火箭', '勇士', '姚明', '休斯顿', '丰田中心', '已结束');
INSERT INTO `matchinformation` VALUES (2, '中超联赛', '第2轮', '2018-06-08', '凯尔特人', '骑士', '欧文', '波士顿', '北海岸花园', '已结束');
INSERT INTO `matchinformation` VALUES (3, '意甲联赛', '第3轮', '2018-06-09', '热火', '马刺', '邓肯', '迈阿密', '胜利体育场', '未开始');
INSERT INTO `matchinformation` VALUES (6, 'AC米兰', '第1轮', '2018-06-06', '骑士', '凯尔特人', 'jack', NULL, '', '未开始');
INSERT INTO `matchinformation` VALUES (35, '欧洲冠军杯联赛', '第5轮', NULL, '巴塞罗那', '皇家马德里', NULL, NULL, NULL, NULL);
INSERT INTO `matchinformation` VALUES (34, '欧洲冠军杯联赛', '第4轮', NULL, '国际米兰', '利物浦', NULL, NULL, NULL, NULL);
INSERT INTO `matchinformation` VALUES (33, '欧洲冠军杯联赛', '第4轮', NULL, '尤文图斯', '巴塞罗那', NULL, NULL, NULL, NULL);
INSERT INTO `matchinformation` VALUES (32, '欧洲冠军杯联赛', '第4轮', NULL, '皇家马德里', 'AC米兰', NULL, NULL, NULL, NULL);
INSERT INTO `matchinformation` VALUES (31, '欧洲冠军杯联赛', '第3轮', NULL, '巴塞罗那', '利物浦', NULL, NULL, NULL, NULL);
INSERT INTO `matchinformation` VALUES (30, '欧洲冠军杯联赛', '第3轮', NULL, 'AC米兰', '国际米兰', NULL, NULL, NULL, NULL);
INSERT INTO `matchinformation` VALUES (29, '欧洲冠军杯联赛', '第3轮', NULL, '尤文图斯', '皇家马德里', NULL, NULL, NULL, NULL);
INSERT INTO `matchinformation` VALUES (28, '欧洲冠军杯联赛', '第2轮', NULL, 'AC米兰', '巴塞罗那', NULL, NULL, NULL, NULL);
INSERT INTO `matchinformation` VALUES (27, '欧洲冠军杯联赛', '第2轮', NULL, '利物浦', '尤文图斯', NULL, NULL, NULL, NULL);
INSERT INTO `matchinformation` VALUES (26, '欧洲冠军杯联赛', '第2轮', NULL, '皇家马德里', '国际米兰', NULL, NULL, NULL, NULL);
INSERT INTO `matchinformation` VALUES (25, '欧洲冠军杯联赛', '第1轮', NULL, '尤文图斯', 'AC米兰', NULL, NULL, NULL, NULL);
INSERT INTO `matchinformation` VALUES (24, '欧洲冠军杯联赛', '第1轮', NULL, '国际米兰', '巴塞罗那', NULL, NULL, NULL, NULL);
INSERT INTO `matchinformation` VALUES (23, '欧洲冠军杯联赛', '第1轮', NULL, '皇家马德里', '利物浦', NULL, NULL, NULL, NULL);
INSERT INTO `matchinformation` VALUES (36, '欧洲冠军杯联赛', '第5轮', NULL, 'AC米兰', '利物浦', NULL, NULL, NULL, NULL);
INSERT INTO `matchinformation` VALUES (37, '欧洲冠军杯联赛', '第5轮', NULL, '尤文图斯', '国际米兰', NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for photo
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo` (
  `photo_id` int(11) NOT NULL,
  `dest_file` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `src_file` varchar(255) DEFAULT NULL,
  `upload_date` varchar(255) DEFAULT NULL,
  `upload_user` varchar(255) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `leagueid` int(11) NOT NULL,
  `static_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`photo_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of photo
-- ----------------------------
BEGIN;
INSERT INTO `photo` VALUES (184, '/Users/hurley/Desktop/footballleague-managementsystem/src/main/resources/static/upload/images/177/bf5ec49746024fdfa9d04e749df16205.jpeg', NULL, NULL, '2018/06/04/', NULL, 'bf5ec49746024fdfa9d04e749df16205.jpeg', 177, '/upload/images/177/bf5ec49746024fdfa9d04e749df16205.jpeg');
INSERT INTO `photo` VALUES (181, '/Users/hurley/Desktop/footballleague-managementsystem/src/main/resources/static/upload/images/92/df16a6e88cbc47f795165ede2cda89f4.jpeg', NULL, NULL, '2018/05/30/', NULL, 'df16a6e88cbc47f795165ede2cda89f4.jpeg', 92, '/upload/images/92/df16a6e88cbc47f795165ede2cda89f4.jpeg');
INSERT INTO `photo` VALUES (180, '/Users/hurley/Desktop/footballleague-managementsystem/src/main/resources/static/upload/images/92/90365d89296549f499b4be6d48d0bc0c.jpeg', NULL, NULL, '2018/05/30/', NULL, '90365d89296549f499b4be6d48d0bc0c.jpeg', 92, '/upload/images/92/90365d89296549f499b4be6d48d0bc0c.jpeg');
INSERT INTO `photo` VALUES (179, '/Users/hurley/Desktop/footballleague-managementsystem/src/main/resources/static/upload/images/177/746dbaa7a5f34565af5e5ef0e5e22077.jpeg', NULL, NULL, '2018/05/30/', NULL, '746dbaa7a5f34565af5e5ef0e5e22077.jpeg', 177, '/upload/images/177/746dbaa7a5f34565af5e5ef0e5e22077.jpeg');
INSERT INTO `photo` VALUES (178, '/Users/hurley/Desktop/footballleague-managementsystem/src/main/resources/static/upload/images/177/8c1160ea44cb4766b3ccf56b59169a7d.jpeg', NULL, NULL, '2018/05/30/', NULL, '8c1160ea44cb4766b3ccf56b59169a7d.jpeg', 177, '/upload/images/177/8c1160ea44cb4766b3ccf56b59169a7d.jpeg');
COMMIT;

-- ----------------------------
-- Table structure for player
-- ----------------------------
DROP TABLE IF EXISTS `player`;
CREATE TABLE `player` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `team` varchar(50) NOT NULL,
  `number` int(11) NOT NULL,
  `position` varchar(20) DEFAULT NULL,
  `height` varchar(10) DEFAULT NULL,
  `weight` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of player
-- ----------------------------
BEGIN;
INSERT INTO `player` VALUES (16, '乔丹', '骑士', 23, '前锋', '188', '145', 34);
INSERT INTO `player` VALUES (20, '詹姆斯', '骑士', 23, '前锋', '203', '160', 33);
INSERT INTO `player` VALUES (21, '科比', '骑士', 24, '后卫', '198', '145', 36);
INSERT INTO `player` VALUES (22, '哈登', '火箭', 13, '得分后卫', '189', '135', 31);
INSERT INTO `player` VALUES (23, '保罗', '火箭', 3, '后卫', '187', '132', 32);
INSERT INTO `player` VALUES (24, '戈登', '火箭', 12, '后卫', '185', '133', 31);
INSERT INTO `player` VALUES (25, '塔克', '火箭', 4, '大前锋', '182', '138', 30);
INSERT INTO `player` VALUES (28, '库里', '勇士', 1, '得分后卫', '185', '125', 30);
INSERT INTO `player` VALUES (29, '汤普森', '勇士', 6, '控球后卫', '188', '132', 31);
INSERT INTO `player` VALUES (30, '塔图姆', '凯尔特人', 13, '小前锋', '189', '134', 25);
INSERT INTO `player` VALUES (31, '屁股', '巴塞罗那', 24, '前锋', '178', '130', 25);
INSERT INTO `player` VALUES (32, '韦德', 'AC米兰', 3, '后卫', '189', '135', 33);
INSERT INTO `player` VALUES (33, '韦德', 'AC米兰', 3, '后卫', '189', '135', 33);
INSERT INTO `player` VALUES (34, '姚明', '巴塞罗那', 11, '中场', '189', '135', 23);
COMMIT;

-- ----------------------------
-- Table structure for player_skill
-- ----------------------------
DROP TABLE IF EXISTS `player_skill`;
CREATE TABLE `player_skill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `goals` int(11) NOT NULL,
  `result_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of player_skill
-- ----------------------------
BEGIN;
INSERT INTO `player_skill` VALUES (19, 13, '塔图姆', 3, 2);
INSERT INTO `player_skill` VALUES (20, 23, '詹姆斯', 5, 2);
INSERT INTO `player_skill` VALUES (21, 13, '哈登', 2, 1);
INSERT INTO `player_skill` VALUES (22, 6, '汤普森', 1, 1);
COMMIT;

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teamName` varchar(255) DEFAULT NULL,
  `shorterName` varchar(255) DEFAULT NULL,
  `captainName` varchar(255) DEFAULT NULL,
  `captainTel` varchar(255) DEFAULT NULL,
  `home` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `league` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of team
-- ----------------------------
BEGIN;
INSERT INTO `team` VALUES (1, '皇家马德里', '皇马', 'C罗', '13657936306', '圣西罗球场', '马德里', '欧洲冠军杯联赛');
INSERT INTO `team` VALUES (2, '巴塞罗那', '巴萨', '梅西', '13657936306', '圣西罗球场', '巴塞罗那', '欧洲冠军杯联赛');
INSERT INTO `team` VALUES (3, 'AC米兰', '米兰', NULL, '13657936306', '圣西罗球场', '米兰', '欧洲冠军杯联赛');
INSERT INTO `team` VALUES (4, '尤文图斯', '尤文', NULL, '13657936306', '安联体育场', '都灵', '欧洲冠军杯联赛');
INSERT INTO `team` VALUES (5, '国际米兰', '国米', '', '13657936306', '圣西罗球场', '米兰', '欧洲冠军杯联赛');
INSERT INTO `team` VALUES (6, '利物浦', '利物浦', '', '13657936306', '圣西罗球场', '利物浦', '欧洲冠军杯联赛');
INSERT INTO `team` VALUES (8, '皇家马德里', '皇马', 'C罗', '13657936306', '圣西罗球场', '马德里', '欧洲冠军杯');
INSERT INTO `team` VALUES (9, '巴塞罗那', '巴萨', '梅西', NULL, NULL, NULL, '欧洲冠军杯');
INSERT INTO `team` VALUES (10, 'AC米兰', '米兰', NULL, NULL, NULL, NULL, '欧洲冠军杯');
INSERT INTO `team` VALUES (11, '尤文图斯', '尤文', NULL, NULL, NULL, NULL, '欧洲冠军杯');
INSERT INTO `team` VALUES (12, '国际米兰', '国米', NULL, NULL, NULL, NULL, '欧洲冠军杯');
INSERT INTO `team` VALUES (13, '利物浦', '利物浦', NULL, NULL, NULL, NULL, '欧洲冠军杯');
INSERT INTO `team` VALUES (14, '南安普顿', '南安', NULL, NULL, NULL, NULL, '欧洲冠军杯');
INSERT INTO `team` VALUES (15, '汉堡', '汉堡', NULL, NULL, NULL, NULL, '欧洲冠军杯');
INSERT INTO `team` VALUES (17, '勇士', '勇士', NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=162 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'account', NULL, 'yzheng520', '13657936306');
INSERT INTO `user` VALUES (35, 'hurley', NULL, 'yzheng520', '13657936306');
INSERT INTO `user` VALUES (4, 'admin', NULL, 'yzheng520', '13657936306');
INSERT INTO `user` VALUES (44, 'admin1', NULL, 'yzheng', '13657936306');
INSERT INTO `user` VALUES (45, 'admin3', NULL, 'test', '13247916236');
INSERT INTO `user` VALUES (43, 'test', NULL, 'test', '13657936306');
INSERT INTO `user` VALUES (160, 'test1', NULL, 'test1', '13657936306');
INSERT INTO `user` VALUES (161, 'test2', NULL, 'test2', '13657936306');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
