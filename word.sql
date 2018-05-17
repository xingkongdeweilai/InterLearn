/*
Navicat MySQL Data Transfer

Source Server         : test1
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : dbinterlearn

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-05-17 18:20:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `word`
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
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`word_id`),
  UNIQUE KEY `UK_rkay0n1s26nf4fkgf4wtpyo5m` (`wordname`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of word
-- ----------------------------
INSERT INTO `word` VALUES ('1', 'n.the latter part of the day (the period of decreasing daylight from late afternoon until nightfall)', 'adj.平坦的，平稳的，无波动的', '他根本没打开过那封信', '哈哈', '', 'He never even opened the letter.', 'haha', '', 'even', '0');
INSERT INTO `word` VALUES ('2', 'noun the end or last of something or 12 inches', 'vi.跳舞，步行', '我的脚疼', '', '', 'My feet are aching.', '', '', 'foot', '0');
INSERT INTO `word` VALUES ('3', 'adjective something complete or something identical', 'adv.真的，非常', '极快', '', '', 'very quickly', '', '', 'very', '0');
INSERT INTO `word` VALUES ('23', 'n.a small amount or duration', 'adj.小的 adv.毫不，少量地 n.几乎没有(指数量或程度等)', '小房子', '', '', 'a little house', '', '', 'little', '0');
INSERT INTO `word` VALUES ('24', 'noun the beginning or first part of something', 'n.开始；动身；开动；七点', '我每天九点开始工作。', '', '', 'I start work at nine.', '', '', 'start', '0');
INSERT INTO `word` VALUES ('25', 'conjunction even if,or in spite of,the fact', 'adv.可是，然而，不过', '安妮喜欢蒂姆，虽然他经常使她心烦。', '', '', 'Anne was fond of Tim,though he often annoyed her.', '', '', 'though', '0');
INSERT INTO `word` VALUES ('26', 'preposition something that is going the other way someone or something with which you disagree', 'prep.反对，倚靠，违背，防御，相比，相对', '反对恐怖主义的斗争。', '', '', 'the fight against terrorism', '', '', 'against', '0');
INSERT INTO `word` VALUES ('27', 'noun a thousand thousands,expressed as.', 'n.百万，群众', '数千万元', '', '', 'tens of millions of dollars', '', '', 'million', '0');
INSERT INTO `word` VALUES ('28', 'n.an instance of questioning', 'n.问题，询问，争论点', '第三题难极了。', '', '', 'Question 3 was very difficult.', '', '', 'question', '0');
INSERT INTO `word` VALUES ('29', 'n.the present time or age', 'n.今天', '今天晚些时候我有一堂钢琴课。', '', '', 'I\'ve got a piano lesson later today.', '', '', 'today', '0');
INSERT INTO `word` VALUES ('30', '', '', '', '', '', '', '', '', 'across', '1');
INSERT INTO `word` VALUES ('33', 'n.a location other than here;that place', 'adv.在那里；那里；在那一点上', '有两个人正在外面等候。', '', '', 'There are two people waiting outside.', '', '', 'there', '0');
INSERT INTO `word` VALUES ('34', 'noun strength or power', 'n.力量；武力，暴力；影响力；部队，军队', '聚众闹事者被强行带走。', '', '', 'The rioters were taken away by force.', '', '', 'force', '0');
INSERT INTO `word` VALUES ('49', '', '', '', '', '', '', '', '', 'aaa', '1');
