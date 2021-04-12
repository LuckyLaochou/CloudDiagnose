/*
Navicat MySQL Data Transfer

Source Server         : laochou
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : clouddiagnose

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2021-04-12 19:01:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(32) NOT NULL,
  `content` text NOT NULL,
  `user_id` int(11) NOT NULL,
  `keywords` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `browser_times` int(11) NOT NULL DEFAULT '1',
  `likee` int(11) NOT NULL DEFAULT '1',
  `is_deleted` int(11) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('3', '过敏性哮喘患者在饮食上有什么禁忌？', '社会的发展使人们的生活更加方便快捷，推动了人民中国质量的提高。但是另一方面也给人类带来了一些危害，社会快速发展的背后就是工业的发展，工业发展必然会带来一些环境污染，环境未来竟然又会影响到人类，所以如何实现人地协调发展是一个非常重要的问题。如果不能实现人地协调发展，就会给人类带来很大的危害。就比如说现在各种疾病的患病率越来越高，和工业污染有一定的关联。今天就给大家介绍一下，过敏性哮喘患者在饮食上有什么样的禁忌。\r\n\r\n过敏性哮喘患者在饮食上有什么禁忌？\r\n过敏性哮喘饮食禁忌——奶制品。\r\n\r\n现在儿童患有过敏性，哮喘的几率也是越来越高了，最主要的变化原因就是奶制品。因为牛奶当中，本身就含有两种乳蛋白以及酪蛋白，牛奶当中的甲型乳白蛋白是最强的，过敏来源。虽然在经济性将热处理之后，他的过敏性会有所降低，但是对于牛奶过敏的人来说，不管怎样处理他都能够引起过敏。而且还会诱发哮喘。所以对婴儿还是建议要进行母乳喂养，这样的话就可以避免引起过敏性哮喘。\r\n\r\n过敏性哮喘饮食禁忌——海鲜和水产品。\r\n\r\n很多人平时对海鲜和水产品都是一个过敏的，而海鲜和水产品也是过敏性哮喘饮食上的一个禁忌，尽管是加工的熟食，也会引起过敏性哮喘，真的还有一些不新鲜的海鲜，更能增加过敏性哮喘病发的几率。\r\n\r\n过敏性哮喘饮食禁忌——花生芝麻和棉子。\r\n\r\n过敏性哮喘患者在平时的饮食过程当中用碱厂油料作物的收入，因为他们当中富含高蛋白质，而这先生说他们容易引发过敏性哮喘。但是当这些时候加工成成品油之后基本上不会引起什么过敏症症状。所以对于这些食物不要生吃，必须把它加工熟了之后才可以吃。\r\n\r\n过敏性哮喘饮食禁忌——鸡蛋。\r\n\r\n鸡蛋也是引起过敏性哮喘的一个因素，而且那大中主要的过敏源就是蛋清，所以有的人平时只喜欢吃蛋黄，不喜欢吃蛋清的人一般哮喘的概率就比较低。因为丹青丹中的卵蛋白是过敏性哮喘病发的原因之一。\r\n\r\n过敏性哮喘患者在饮食上有什么禁忌？\r\n过敏性哮喘饮食禁忌——小麦谷物。\r\n\r\n小麦谷物也会引发过敏性哮喘，因为小麦，谷物最终都能够加工成面粉，而面粉是引起过敏性哮喘的一个重要原因。所以面粉存放的时间不能太长，太长的话就会成为过敏源。\r\n\r\n以上就是给大家介绍的过敏性哮喘患者在饮食上的一些禁忌，在治疗过程当中，除了积极配合医生的药物治疗之外，平时在饮食上的护理也是至关重要的，她其中一个非常重要的辅助作用。如果饮食不到的话，就有可能会加重病情，提到是倍功半的效果，不利于病情的恢复。所以大家在平时的饮食过程当中一定要注意这些小的细节，不要让它加重了我们的病情，耽误了治疗。', '1', '过敏、哮喘、饮食', '1', '1', '0', '2021-04-02 10:50:47', '2021-04-02 10:50:47');
INSERT INTO `article` VALUES ('4', '小儿便秘，家长朋友们一定要学会这几招', '小儿便秘孩子难受，宝爸宝妈也着急，如何预防小儿便秘也成了各位家长想了解的问题，那么你们知道平时如何预防小儿便秘的产生吗？那么我们一起来学习一下吧。\r\n\r\n小儿便秘，家长朋友们一定要学会这几招\r\n1、合理饮食，多摄取瓜果\r\n\r\n儿童便秘的原因在于其体质燥热。因此，便秘的孩子平时可以多进食瓜类水果，如西瓜、香瓜、哈密瓜等，以消除其体内的燥热。如果孩子不喜欢这类水果的味道，可以在水果上洒点炼乳、酸奶或冰淇淋，让香浓的甜奶味盖过瓜味。此外，家长还应经常为孩子熬点绿豆薏仁粥吃，也能起到解热通便的作用。\r\n\r\n2、适当运动\r\n\r\n平时，家长应鼓励孩子多参加体育运动。因为运动可增加肠蠕动，促进排便。家长也可在孩子临睡前，以其肚脐为中心按顺时针方向轻轻按摩其腹部，这样不仅可以促进孩子的肠蠕动，还有助于其入眠。另外，在孩子进食后一小时轻按足三里与支沟穴两处穴位，也可促进其排便。\r\n\r\n3、合理饮水\r\n\r\n宝宝喝水要讲究方法，首先要做到少“饮”多餐。不要因渴而喝，因为宝宝真正口喝的时候，表明体内水分已失去平衡，身体细胞开始脱水。其次，宝宝非常口渴时，应该先喝少量的水，待身体状况逐渐稳定后再喝。\r\n\r\n4、养成良好的排便习惯\r\n\r\n不按时排便是导致许多孩子便秘的原因之一。3～7岁的儿童，其腹部及骨盆腔的肌肉正处在发育阶段，排便反射的功能尚不成熟。他们还不知道有便意就该上洗手间，经常需要家长的提醒。因此，家长可以把早餐后一小时作为孩子固定的排便时间。开始时，家长可以陪伴孩子排便，每次10分钟左右，渐渐帮助孩子养成定时如厕的习惯。如厕前可给孩子喝杯果汁或温蜂蜜水润润肠。\r\n\r\n5、巧妙补充纤维质\r\n\r\n如果孩子平时讨厌吃蔬菜、水果，可以让其多吃木耳、杏鲍菇、海苔、海带、果干等食物，以增加其纤维质的摄入，从而促进其排便。\r\n\r\n6、少食多餐，慎选优质点心\r\n\r\n虽然孩子的胃容量小，每次吃不了太多的食物，但其精力旺盛，活动量大，几乎每3～4小时就需要给其补充饮食。所以，孩子的饮食应坚持少量多餐。家长可以把孩子每日所需的营养，分成三顿正餐和两顿副餐来供给。至于副餐，可以选择一些富含营养的食品，如白木耳、杏仁、蜂蜜等。这些食物不仅含有优质蛋白质及脂质，还有软便润肠的作用，是孩子最佳的活力补给来源。\r\n\r\n小儿便秘，家长朋友们一定要学会这几招\r\n小儿便秘临床要注意排除肠道器质性疾病所致的排便困难。那么应该如何治疗小儿便秘呢?我们看看中医大夫如何推拿治疗小儿便秘？\r\n\r\n推拿治疗小儿便秘\r\n\r\n对于服药困难或不愿服药的患儿，采用推拿手法也能取得较好。便秘有虚实之分，推拿手法也有补泻之别。\r\n\r\n补脾：脾经位于拇指桡侧缘。操作时，由指根尖推向指根300次。能调理脾胃，加强脾胃运化功能。\r\n\r\n推三关：位于前臂桡侧，太渊穴至曲池穴成一直线。操作时，自下向上推100～500次。具有温里散寒、温补气血之功效，适用于各种虚证，如身体虚弱、神疲气怯、面色无华等。\r\n\r\n捏脊：从第一胸椎至尾椎，由下往上捏30遍。可调阴阳、理气血、和脏腑、通经络，凡脾胃虚弱之证，均可用之。\r\n\r\n看了以上小儿便秘的护理方法和中医的按摩手法，各位家长可以学习借鉴一下，一方面解除孩子的痛苦，另一方面家长朋友也不会跟着一起揪心了。', '1', '小孩、便秘', '1', '1', '0', '2021-04-02 11:02:25', '2021-04-02 11:02:25');

-- ----------------------------
-- Table structure for auth
-- ----------------------------
DROP TABLE IF EXISTS `auth`;
CREATE TABLE `auth` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `department` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `img` varchar(255) NOT NULL,
  `result` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '未处理',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth
-- ----------------------------
INSERT INTO `auth` VALUES ('6', '8', '呼吸科', '/upload/88b8a466-ccb4-4e4a-87fa-0db980221caa.jpeg', '认证通过');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `content` text NOT NULL,
  `likee` int(11) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', '1', '写的真好', '1', '2020-11-30 11:24:27', '2020-11-30 11:24:30');
INSERT INTO `comment` VALUES ('3', '1', '1', '太强', '0', '2020-12-26 18:50:47', '2020-12-26 18:50:47');
INSERT INTO `comment` VALUES ('4', '1', '1', 'zhend ', '0', '2020-12-26 20:41:21', '2020-12-26 20:41:21');
INSERT INTO `comment` VALUES ('5', '3', '2', '确实，对我帮助很大', '0', '2021-04-06 15:55:02', '2021-04-06 15:55:02');

-- ----------------------------
-- Table structure for diagnose
-- ----------------------------
DROP TABLE IF EXISTS `diagnose`;
CREATE TABLE `diagnose` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `request_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `diagnose_result` varchar(64) NOT NULL,
  `advices` varchar(64) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diagnose
-- ----------------------------
INSERT INTO `diagnose` VALUES ('9', '13', '8', '感冒', '注意保暖，多喝开水', '2021-04-12 10:17:28', '2021-04-12 10:17:28');

-- ----------------------------
-- Table structure for pre_diagnose
-- ----------------------------
DROP TABLE IF EXISTS `pre_diagnose`;
CREATE TABLE `pre_diagnose` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `request_id` int(11) NOT NULL,
  `pre_diagnose_result` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pre_diagnose
-- ----------------------------
INSERT INTO `pre_diagnose` VALUES ('8', '11', '感冒、慢性咽炎', '2021-03-21 16:00:57', '2021-03-21 16:00:57');
INSERT INTO `pre_diagnose` VALUES ('9', '12', '', '2021-04-10 16:23:09', '2021-04-10 16:23:09');
INSERT INTO `pre_diagnose` VALUES ('10', '13', '慢性咽炎、感冒', '2021-04-12 10:04:15', '2021-04-12 10:04:15');

-- ----------------------------
-- Table structure for request
-- ----------------------------
DROP TABLE IF EXISTS `request`;
CREATE TABLE `request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `department` varchar(32) NOT NULL,
  `content` text NOT NULL,
  `pictures` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `video` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_pre_diagnose` char(1) NOT NULL DEFAULT '0',
  `is_diagnose` char(1) NOT NULL DEFAULT '0',
  `is_dispose` char(1) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of request
-- ----------------------------
INSERT INTO `request` VALUES ('13', '3', '呼吸科', '咳嗽，流鼻涕', '/upload/1927bc30-6874-427d-bfdb-35f932077421.jpeg', '', '1', '1', '1', '2021-04-12 10:04:13', '2021-04-12 10:04:13');

-- ----------------------------
-- Table structure for symptoms
-- ----------------------------
DROP TABLE IF EXISTS `symptoms`;
CREATE TABLE `symptoms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `symptoms` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of symptoms
-- ----------------------------
INSERT INTO `symptoms` VALUES ('1', '感冒', '本病起病较急，潜伏期1～3天，主要表现为鼻部症状，如喷嚏、鼻塞、流清水样鼻涕，也可表现为咳嗽、咽干、咽痒、咽痛或灼热感，甚至鼻后滴漏感。2～3天后鼻涕变稠，常伴咽痛、流泪、味觉减退、呼吸不畅、声嘶等。一般无发热及全身症状，或仅有低热、不适、轻度畏寒、头痛。');
INSERT INTO `symptoms` VALUES ('2', '急性咽炎', '急性咽炎起病较急，初起时咽部干燥、灼热，继有咽痛，空咽时咽痛往往比进食时更加明显，疼痛可放射到耳部。全身症状一般较轻，但因年龄、免疫力以及病毒、细菌毒力之不同而程度不一，严重者表现为发热、头痛、食欲不振和四肢酸痛等。—般病程在l周左右。检查见口咽及鼻咽粘膜呈急性弥漫性充血，腭弓、悬雍垂水肿，咽后壁淋巴滤泡和咽侧索红肿。细菌感染者，咽后壁淋巴滤泡中央可出现黄白色点状渗出物。颌下淋巴结肿大，且有压痛。');
INSERT INTO `symptoms` VALUES ('3', '慢性咽炎', '慢性咽炎患者咽部可有各种不适感，如异物感、灼热感、干燥感、痒感、刺激感和轻微的疼痛等。由于咽后壁常有较粘稠的分泌物刺激，常在晨起时出现较频繁的刺激性咳嗽，严重时可引起作呕，咳嗽时常无分泌物咳出。上述症状因人而异，轻重不一、往往在用嗓过度、受凉或疲劳时加重。全身症状一般均不明显。检查所见：慢性单纯性咽炎可见粘膜弥漫性充血，血管扩张，呈暗红色，咽后壁常有少许粘稠分泌物附着。悬雍垂增粗，呈蚯蚓状下垂，有时与舌根接触。慢性肥厚性咽炎可见粘膜肥厚，弥漫充血。咽后壁有较多颗粒状隆起的淋巴滤泡，可散在分布或融合成块。两侧咽侧索也有充血肥厚。');
INSERT INTO `symptoms` VALUES ('4', '萎缩性咽炎', '萎缩性咽炎患者自觉咽部干燥，有时可咳出带臭味的痂皮。检查可见咽粘膜干燥，萎缩变薄，色苍白且发亮，咽后壁粘膜上常有粘稠的粘液或有臭味的黄褐色痂皮。');
INSERT INTO `symptoms` VALUES ('5', '测试', '真的测试');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `id_card` varchar(32) NOT NULL,
  `mail` varchar(32) NOT NULL,
  `sex` char(1) NOT NULL,
  `role` int(11) NOT NULL,
  `department` varchar(12) NOT NULL DEFAULT '用户系',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `password` varchar(32) NOT NULL,
  `phone` char(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'laochou', '360428200106185312', '927990436@qq.cn', '1', '2', '呼吸科', '2020-10-14 09:56:56', '2020-10-14 09:57:00', 'laochou', '19979199619');
INSERT INTO `user` VALUES ('2', '张三', '360232222222222221', '222222222@qq.com', '1', '1', '用户系', '2021-02-01 20:55:08', '2021-02-01 20:55:11', 'zhangsan', '124');
INSERT INTO `user` VALUES ('3', '李四', '340', '222222222@qq.com', '1', '1', '用户系', '2021-03-04 11:30:11', '2021-03-04 11:30:15', 'lisi', '123');
INSERT INTO `user` VALUES ('6', '袁世宝', '330218987472838232', 'yzllaochou@gmail.com', '1', '2', '用户系', '2021-04-07 13:44:29', '2021-04-07 13:44:29', '123456', '13398745678');
INSERT INTO `user` VALUES ('7', 'admin', '360000000000000000', 'admin@gmail.com', '1', '3', '管理系', '2021-04-09 16:03:30', '2021-04-09 16:03:33', 'admin', '111');
INSERT INTO `user` VALUES ('8', '余和伟', '360428199809213321', 'yuhewei@gmail.com', '1', '2', '呼吸科', '2021-04-11 09:52:05', '2021-04-11 09:52:05', '123456', '13456233321');
