/*
Navicat MySQL Data Transfer

Source Server         : myConection
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : dbinterlearn

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-05-17 00:40:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for word
-- ----------------------------
DROP TABLE IF EXISTS `word`;
CREATE TABLE `word` (
  `word_id` int(11) NOT NULL AUTO_INCREMENT,
  `word_describe` varchar(255) DEFAULT NULL,
  `word_translate` varchar(255) DEFAULT NULL,
  `word_example_cn1` varchar(255) DEFAULT NULL,
  `word_example_cn2` varchar(255) DEFAULT NULL,
  `word_example_cn3` varchar(255) DEFAULT NULL,
  `word_example_en1` varchar(255) DEFAULT NULL,
  `word_example_en2` varchar(255) DEFAULT NULL,
  `word_example_en3` varchar(255) DEFAULT NULL,
  `wordname` varchar(255) NOT NULL,
  PRIMARY KEY (`word_id`),
  UNIQUE KEY `UK_rkay0n1s26nf4fkgf4wtpyo5m` (`wordname`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of word
-- ----------------------------
INSERT INTO `word` VALUES ('1', 'n.the latter part of the day (the period of decreasing daylight from late afternoon until nightfall)', 'adj.平坦的，平稳的，无波动的', '他根本没打开过那封信', '哈哈', '', 'He never even opened the letter.', 'haha', '', 'even');
INSERT INTO `word` VALUES ('2', 'noun the end or last of something or 12 inches', 'vi.跳舞，步行', '我的脚疼', '', '', 'My feet are aching.', '', '', 'foot');
INSERT INTO `word` VALUES ('3', 'adjective something complete or something identical', 'adv.真的，非常', '极快', '', '', 'very quickly', '', '', 'very');
INSERT INTO `word` VALUES ('23', 'n.a small amount or duration', 'adj.小的 adv.毫不，少量地 n.几乎没有(指数量或程度等)', '小房子', '', '', 'a little house', '', '', 'little');
INSERT INTO `word` VALUES ('24', 'noun the beginning or first part of something', 'n.开始；动身；开动；七点', '我每天九点开始工作。', '', '', 'I start work at nine.', '', '', 'start');
INSERT INTO `word` VALUES ('25', 'conjunction even if,or in spite of,the fact', 'adv.可是，然而，不过', '安妮喜欢蒂姆，虽然他经常使她心烦。', '', '', 'Anne was fond of Tim,though he often annoyed her.', '', '', 'though');
INSERT INTO `word` VALUES ('26', 'preposition something that is going the other way someone or something with which you disagree', 'prep.反对，倚靠，违背，防御，相比，相对', '反对恐怖主义的斗争。', '', '', 'the fight against terrorism', '', '', 'against');
INSERT INTO `word` VALUES ('27', 'noun a thousand thousands,expressed as.', 'n.百万，群众', '数千万元', '', '', 'tens of millions of dollars', '', '', 'million');
INSERT INTO `word` VALUES ('28', 'n.an instance of questioning', 'n.问题，询问，争论点', '第三题难极了。', '', '', 'Question 3 was very difficult.', '', '', 'question');
INSERT INTO `word` VALUES ('29', 'n.the present time or age', 'n.今天', '今天晚些时候我有一堂钢琴课。', '', '', 'I\'ve got a piano lesson later today.', '', '', 'today');
INSERT INTO `word` VALUES ('30', '', '', '', '', '', '', '', '', 'across');
