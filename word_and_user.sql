/*
Navicat MySQL Data Transfer

Source Server         : test1
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : dbinterlearn

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-05-18 18:34:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `word_and_user`
-- ----------------------------
DROP TABLE IF EXISTS `word_and_user`;
CREATE TABLE `word_and_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `relationship` int(11) DEFAULT '0',
  `user_id` int(11) DEFAULT NULL,
  `word_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `word_id` (`word_id`),
  CONSTRAINT `word_and_user_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `word_and_user_ibfk_2` FOREIGN KEY (`word_id`) REFERENCES `word` (`word_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of word_and_user
-- ----------------------------
INSERT INTO `word_and_user` VALUES ('1', '0', '3', '3');
INSERT INTO `word_and_user` VALUES ('2', '0', '3', '1');
INSERT INTO `word_and_user` VALUES ('3', '0', '3', '2');
INSERT INTO `word_and_user` VALUES ('4', '0', '3', '23');
INSERT INTO `word_and_user` VALUES ('5', '0', '3', '24');
INSERT INTO `word_and_user` VALUES ('6', '0', '3', '25');
