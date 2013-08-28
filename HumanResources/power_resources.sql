/*
MySQL Data Transfer
Source Host: localhost
Source Database: power_resources
Target Host: localhost
Target Database: power_resources
Date: 2009/12/30 15:40:15
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for bumen
-- ----------------------------
CREATE TABLE `bumen` (
  `id` int(16) NOT NULL auto_increment,
  `employees_professional` varchar(256) NOT NULL COMMENT '部门',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for employees_information
-- ----------------------------
CREATE TABLE `employees_information` (
  `id` int(16) NOT NULL auto_increment COMMENT '自动递增',
  `employess_job` varchar(16) collate utf8_unicode_ci NOT NULL COMMENT '职务',
  `employess_id` varchar(16) collate utf8_unicode_ci NOT NULL COMMENT '员工ID',
  `employees_name` varchar(16) collate utf8_unicode_ci default NULL COMMENT '员工姓名',
  `employees_sex` varchar(16) collate utf8_unicode_ci default NULL COMMENT '工员性别',
  `employees_marriage` varchar(16) collate utf8_unicode_ci default NULL COMMENT '婚姻状况',
  `employees_city` varchar(16) collate utf8_unicode_ci default NULL COMMENT '所在的城市',
  `employees_study` varchar(16) collate utf8_unicode_ci default NULL COMMENT '最高的学历',
  `employees_politically` varchar(16) collate utf8_unicode_ci default NULL COMMENT '政治面貌',
  `employees_identity` varchar(26) collate utf8_unicode_ci default NULL COMMENT '员工的身份证号',
  `employees_mobile` varchar(16) collate utf8_unicode_ci default NULL COMMENT '员工的手机号',
  `employees_tel` varchar(16) collate utf8_unicode_ci default NULL COMMENT '员工家的电话',
  `employees_lashup_tel` varchar(16) collate utf8_unicode_ci default NULL COMMENT '员工的应急电话',
  `employees_email` varchar(16) collate utf8_unicode_ci default NULL COMMENT '邮箱',
  `employees_professional` varchar(16) collate utf8_unicode_ci default NULL COMMENT '部门',
  `employess_jointime` date default NULL COMMENT '入职时间',
  `elmployess_engtime` date default NULL COMMENT '终止时间',
  `employees_photo` varchar(255) collate utf8_unicode_ci default NULL COMMENT '照片',
  `employees_status` varchar(16) collate utf8_unicode_ci default NULL COMMENT '1:超管理员2:普通管理员3:员工',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for employess_assess
-- ----------------------------
CREATE TABLE `employess_assess` (
  `id` int(16) NOT NULL auto_increment COMMENT 'id',
  `employess_id` varchar(16) collate utf8_unicode_ci default NULL COMMENT '工员编号',
  `status` varchar(16) collate utf8_unicode_ci default NULL COMMENT '1：来了2：没来',
  `time` date default NULL COMMENT '考评的时间',
  `matter` varchar(256) collate utf8_unicode_ci default NULL COMMENT '考评的原因',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for employess_prize_note
-- ----------------------------
CREATE TABLE `employess_prize_note` (
  `id` int(16) NOT NULL auto_increment,
  `employess_id` varchar(16) collate utf8_unicode_ci default NULL COMMENT '工员',
  `matter` varchar(256) collate utf8_unicode_ci default NULL COMMENT '原因',
  `time` date default NULL,
  `jiangjin` varchar(16) collate utf8_unicode_ci default NULL COMMENT '奖金',
  `fakuan` varchar(16) collate utf8_unicode_ci default NULL COMMENT '罚款',
  `userid` int(16) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for employess_train
-- ----------------------------
CREATE TABLE `employess_train` (
  `id` int(16) NOT NULL auto_increment COMMENT 'id',
  `employess_id` varchar(16) collate utf8_unicode_ci default NULL COMMENT '工员标号',
  `month` date default NULL COMMENT '培训的时间',
  `status` varchar(16) collate utf8_unicode_ci default NULL COMMENT '1：有培训2：无培训',
  `matter` varchar(256) collate utf8_unicode_ci default NULL COMMENT '培训的原因',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for employess_wage_note
-- ----------------------------
CREATE TABLE `employess_wage_note` (
  `id` int(16) NOT NULL auto_increment,
  `employess_id` varchar(16) collate utf8_unicode_ci default NULL COMMENT '员工ID',
  `time` date default NULL COMMENT '获取当前的时间(历史记录表)',
  `money` varchar(16) collate utf8_unicode_ci default NULL COMMENT '历史工的资',
  `userid` int(16) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for employess_zhiwu
-- ----------------------------
CREATE TABLE `employess_zhiwu` (
  `id` int(16) NOT NULL auto_increment,
  `employess_job` varchar(16) collate utf8_unicode_ci NOT NULL COMMENT '职务',
  `bumenid` int(16) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for employess_zhiwu_note
-- ----------------------------
CREATE TABLE `employess_zhiwu_note` (
  `id` int(16) NOT NULL auto_increment COMMENT '工员',
  `employess_id` varchar(16) collate utf8_unicode_ci default '' COMMENT '员工',
  `time` date default NULL COMMENT '获取当前的系统时间',
  `employess_job` varchar(16) collate utf8_unicode_ci default NULL COMMENT '历史记录的职位',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for super_employees
-- ----------------------------
CREATE TABLE `super_employees` (
  `id` int(16) NOT NULL auto_increment COMMENT 'ID号    自动递增',
  `user` varchar(16) collate utf8_unicode_ci default NULL COMMENT '超级管理员姓名',
  `pass` varchar(16) collate utf8_unicode_ci default NULL COMMENT '密码',
  `status` varchar(16) collate utf8_unicode_ci default NULL COMMENT '1：超级管理员    2：普通管理员',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- View structure for jiangcheng
-- ----------------------------
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `jiangcheng` AS select `super_employees`.`user` AS `user`,`employess_prize_note`.`id` AS `id`,`employess_prize_note`.`employess_id` AS `employess_id`,`employess_prize_note`.`time` AS `time`,`employess_prize_note`.`matter` AS `matter`,`employess_prize_note`.`jiangjin` AS `jiangjin`,`employess_prize_note`.`fakuan` AS `fakuan`,`employess_prize_note`.`userid` AS `userid`,`employees_information`.`employees_name` AS `employees_name` from ((`super_employees` join `employess_prize_note` on((`super_employees`.`id` = `employess_prize_note`.`userid`))) join `employees_information` on((`employees_information`.`employess_id` = `employess_prize_note`.`employess_id`)));

-- ----------------------------
-- View structure for shitu1
-- ----------------------------
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `shitu1` AS select `employess_assess`.`id` AS `id`,`employess_assess`.`employess_id` AS `employess_id`,`employess_assess`.`status` AS `status`,`employess_assess`.`time` AS `time`,`employess_assess`.`matter` AS `matter`,`employees_information`.`employees_name` AS `employees_name`,`employees_information`.`employees_sex` AS `employees_sex` from (`employees_information` join `employess_assess` on((`employess_assess`.`employess_id` = `employees_information`.`employess_id`)));

-- ----------------------------
-- View structure for shitu2
-- ----------------------------
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `shitu2` AS select `employess_train`.`id` AS `id`,`employess_train`.`employess_id` AS `employess_id`,`employess_train`.`month` AS `month`,`employess_train`.`status` AS `status`,`employess_train`.`matter` AS `matter`,`employees_information`.`employees_name` AS `employees_name`,`employees_information`.`employees_sex` AS `employees_sex` from (`employees_information` join `employess_train` on((`employess_train`.`employess_id` = `employees_information`.`employess_id`)));

-- ----------------------------
-- View structure for vrenshi
-- ----------------------------
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vrenshi` AS select `employess_zhiwu_note`.`time` AS `time`,`employess_zhiwu_note`.`employess_job` AS `employess_job`,`employess_zhiwu_note`.`id` AS `id`,`employess_zhiwu_note`.`employess_id` AS `employess_id`,`employees_information`.`employees_name` AS `employees_name`,`employees_information`.`employees_status` AS `employees_status`,`employees_information`.`employees_sex` AS `employees_sex`,`employees_information`.`employees_study` AS `employees_study`,`employees_information`.`employees_politically` AS `employees_politically`,`employees_information`.`elmployess_engtime` AS `elmployess_engtime`,`employees_information`.`employess_jointime` AS `employess_jointime`,`employees_information`.`employees_professional` AS `employees_professional` from (`employees_information` join `employess_zhiwu_note` on((`employess_zhiwu_note`.`employess_id` = `employees_information`.`employess_id`)));

-- ----------------------------
-- View structure for vzhiwu
-- ----------------------------
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vzhiwu` AS select `employess_wage_note`.`id` AS `id`,`employess_wage_note`.`employess_id` AS `employess_id`,`employess_wage_note`.`time` AS `time`,`employess_wage_note`.`money` AS `money`,`employees_information`.`employees_name` AS `employees_name`,`employess_wage_note`.`userid` AS `userid`,`super_employees`.`user` AS `user` from ((`employees_information` join `employess_wage_note` on((`employess_wage_note`.`employess_id` = `employees_information`.`employess_id`))) join `super_employees` on((`super_employees`.`id` = `employess_wage_note`.`userid`)));

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `bumen` VALUES ('1', '人事部');
INSERT INTO `bumen` VALUES ('2', '宣传部');
INSERT INTO `employees_information` VALUES ('4', '员工', '1', '李畔', '女', '未婚', '', '大学', '团员', '211421198908091425', '', '', '', '', '人事部', '2009-12-25', '2009-12-31', '2009-12-25 010046.gif', '3');
INSERT INTO `employees_information` VALUES ('5', '经理', '2', '2', '女', '未婚', '', '高中', '其它', '211421198908091425', '', '', '', '', '人事部', '2009-12-23', '2009-12-31', '2009-12-25 010110.gif', '3');
INSERT INTO `employees_information` VALUES ('6', '员工', '3', '3', '男', '已婚', '', '高中', '其它', '211421198908091425', '', '', '', '', '人事部', '2009-12-24', '2009-12-31', '2009-12-25 010135.gif', '3');
INSERT INTO `employees_information` VALUES ('7', '经理', '4', '你好', '男', '已婚', '', '大学', '团员', '211421198908091425', '', '', '', '', '人事部', '2009-12-23', '2009-12-31', '2009-12-25 095150.gif', '3');
INSERT INTO `employess_assess` VALUES ('1', '1', '3', '2009-12-16', '1111111');
INSERT INTO `employess_prize_note` VALUES ('1', '1', '1', '2009-12-23', '1', '1', '1');
INSERT INTO `employess_prize_note` VALUES ('12', '1', 'sad', '2009-12-28', 'dsad', 'dasd', '13');
INSERT INTO `employess_train` VALUES ('1', '1', '2009-12-30', '3', '33333333');
INSERT INTO `employess_wage_note` VALUES ('11', '2', '2009-12-25', '500', '12');
INSERT INTO `employess_wage_note` VALUES ('12', '3', '2009-12-25', '4000', '12');
INSERT INTO `employess_wage_note` VALUES ('13', '1', '2009-12-25', '50000', '12');
INSERT INTO `employess_wage_note` VALUES ('14', '4', '2009-12-25', '12321', '11');
INSERT INTO `employess_wage_note` VALUES ('15', '3', '2009-12-28', '12222', '13');
INSERT INTO `employess_zhiwu` VALUES ('1', '经理', '1');
INSERT INTO `employess_zhiwu` VALUES ('2', '员工', '1');
INSERT INTO `employess_zhiwu` VALUES ('3', '秘书', '1');
INSERT INTO `employess_zhiwu` VALUES ('5', '', '2');
INSERT INTO `employess_zhiwu_note` VALUES ('30', '1', '2009-12-25', '员工');
INSERT INTO `employess_zhiwu_note` VALUES ('31', '2', '2009-12-25', '经理');
INSERT INTO `employess_zhiwu_note` VALUES ('32', '3', '2009-12-25', '员工');
INSERT INTO `employess_zhiwu_note` VALUES ('33', '4', '2009-12-25', '经理');
INSERT INTO `super_employees` VALUES ('1', 'admin', '', '1');
INSERT INTO `super_employees` VALUES ('10', '韩晶', '\\', '2');
INSERT INTO `super_employees` VALUES ('13', 'yy', '\\', '1');
