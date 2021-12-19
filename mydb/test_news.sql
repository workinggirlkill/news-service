/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.7.36-log : Database - test_news
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test_news` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `test_news`;

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `status` int(11) DEFAULT NULL,
  `msg` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='信息表';

/*Data for the table `message` */

insert  into `message`(`status`,`msg`) values 
(404,'未找到数据'),
(405,'资源被禁止 '),
(500,'内部服务器错误'),
(403,'请求方式出问题'),
(200,'获取成功');

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(100) NOT NULL COMMENT '新闻名称',
  `content` text NOT NULL COMMENT '新闻内容',
  `source` varchar(100) DEFAULT NULL COMMENT '来源',
  `author` varchar(50) DEFAULT NULL COMMENT '作者',
  `level` int(11) DEFAULT '0' COMMENT '0-10,10为最高级别',
  `categoryId` int(11) NOT NULL,
  `publishTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '新闻发布时间',
  `status` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `ix_title` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4;

/*Data for the table `news` */

insert  into `news`(`id`,`title`,`content`,`source`,`author`,`level`,`categoryId`,`publishTime`,`status`) values 
(1,'明星','//时间格式转换\n    dateFormat: function (time) {\n      var date = new Date(time);\n      var year = date.getFullYear();\n      /* 在日期格式中，月份是从0开始的，因此要加0\n       * 使用三元表达式在小于10的前面加0，以达到格式统一  如 09:11:05\n       * */\n      var month =\n        date.getMonth() + 1 < 10 ? \"0\" + (date.getMonth() + 1) : date.getMonth() + 1;\n      var day = date.getDate() < 10 ? \"0\" + date.getDate() : date.getDate();\n      var hours = date.getHours() < 10 ? \"0\" + date.getHours() : date.getHours();\n      var minutes = date.getMinutes() < 10 ? \"0\" + date.getMinutes() : date.getMinutes();\n      var seconds = date.getSeconds() < 10 ? \"0\" + date.getSeconds() : date.getSeconds();\n      // 拼接\n      return year + \"-\" + month + \"-\" + day + \" \" + hours + \":\" + minutes + \":\" + seconds;\n    },\n然后去渲染\n<span>{{ dateFormat(loginMessInfo.expireTime) }}</span>','腾讯新闻','巨巨',5,9,'2025-06-27 18:02:02',1),
(2,'财经','2017年，航天科技集团一院启动新一代载人运载火箭的方案论证工作，并完成多轮方案对比分析。后续，该型火箭将用于载人月球探测工程中的环月、绕月、登月等演示验证及飞行任务，未来还可以同重型运载火箭组合使用建立月球基地，实现月球可持续开发利用。','搜狐','小梁',2,2,'2021-12-10 11:10:37',1),
(3,'军事','日本前首相安倍晋三继12月1日宣称“台湾有事就是日本有事','新华社','范冰冰',5,1,'2021-12-09 11:09:02',1),
(4,'军事','日本前首相安倍晋三继12月1日宣称“台湾有事就是日本有事','新华设','范冰冰',5,1,'2021-12-09 11:09:02',1),
(5,'军事','日本前首相安倍晋三继12月1日宣称“台湾有事就是日本有事','新华社','范冰冰',5,1,'2021-12-09 11:09:02',1),
(6,'军事','日本前首相安倍晋三继12月1日宣称“台湾有事就是日本有事.df','新华社','范冰冰789',5,1,'2021-12-09 11:09:02',1),
(7,'军事','日本前首相安倍晋三继12月1日宣称“台湾有事就是日本有事','新华社','范冰冰',5,1,'2021-12-09 11:09:02',0),
(8,'其他','1、搭建springboot工程\r\n2、导入springSecurity跟jwt的依赖\r\n3、用户的实体类，dao层，service层（真正开发时再写，这里就直接调用dao层操作数据库）\r\n4、实现UserDetailsService接口\r\n5、实现UserDetails接口\r\n6、验证用户登录信息的拦截器\r\n7、验证用户权限的拦截器\r\n8、springSecurity配置\r\n9、认证的Controller以及测试的controller\r\n','搜狐','冰冰2号',10,10,'2021-12-28 16:00:00',1),
(9,'其他','1、搭建springboot工程\r\n2、导入springSecurity跟jwt的依赖\r\n3、用户的实体类，dao层，service层（真正开发时再写，这里就直接调用dao层操作数据库）\r\n4、实现UserDetailsService接口\r\n5、实现UserDetails接口\r\n6、验证用户登录信息的拦截器\r\n7、验证用户权限的拦截器\r\n8、springSecurity配置\r\n9、认证的Controller以及测试的controller\r\n','搜狐','冰冰',10,10,'2021-12-09 11:09:02',1),
(10,'其他','1、搭建springboot工程\r\n2、导入springSecurity跟jwt的依赖\r\n3、用户的实体类，dao层，service层（真正开发时再写，这里就直接调用dao层操作数据库）\r\n4、实现UserDetailsService接口\r\n5、实现UserDetails接口\r\n6、验证用户登录信息的拦截器\r\n7、验证用户权限的拦截器\r\n8、springSecurity配置\r\n9、认证的Controller以及测试的controller\r\n','搜狐','冰冰',10,10,'2021-12-09 11:09:02',1),
(11,'其他','1、搭建springboot工程\r\n2、导入springSecurity跟jwt的依赖\r\n3、用户的实体类，dao层，service层（真正开发时再写，这里就直接调用dao层操作数据库）\r\n4、实现UserDetailsService接口\r\n5、实现UserDetails接口\r\n6、验证用户登录信息的拦截器\r\n7、验证用户权限的拦截器\r\n8、springSecurity配置\r\n9、认证的Controller以及测试的controller\r\n','搜狐','冰冰',10,10,'2021-12-09 11:09:02',1),
(12,'其他','1、搭建springboot工程\r\n2、导入springSecurity跟jwt的依赖\r\n3、用户的实体类，dao层，service层（真正开发时再写，这里就直接调用dao层操作数据库）\r\n4、实现UserDetailsService接口\r\n5、实现UserDetails接口\r\n6、验证用户登录信息的拦截器\r\n7、验证用户权限的拦截器\r\n8、springSecurity配置\r\n9、认证的Controller以及测试的controller\r\n','搜狐','冰冰',10,10,'2021-12-09 11:09:02',1),
(13,'其他','1、搭建springboot工程\r\n2、导入springSecurity跟jwt的依赖\r\n3、用户的实体类，dao层，service层（真正开发时再写，这里就直接调用dao层操作数据库）\r\n4、实现UserDetailsService接口\r\n5、实现UserDetails接口\r\n6、验证用户登录信息的拦截器\r\n7、验证用户权限的拦截器\r\n8、springSecurity配置\r\n9、认证的Controller以及测试的controller\r\n','搜狐','冰冰',10,10,'2021-12-09 11:09:02',1),
(14,'社会','据美国媒体当地时间11日报道，美国中部6个州10日夜间遭遇至少30场龙卷风袭击，截至目前龙卷风灾害已造成超过百人死亡，肯塔基州灾情最为严重。\r\n\r\n美国总统拜登11日发表讲话称，此次龙卷风灾害或为美国历史上遭遇的最为严重的龙卷风灾害之一，联邦政府将配合各地州政府为灾情提供一切帮助','看看新闻','冰冰',10,10,'2021-12-09 11:09:02',1),
(15,'社会','据美国媒体当地时间11日报道，美国中部6个州10日夜间遭遇至少30场龙卷风袭击，截至目前龙卷风灾害已造成超过百人死亡，肯塔基州灾情最为严重。\r\n\r\n美国总统拜登11日发表讲话称，此次龙卷风灾害或为美国历史上遭遇的最为严重的龙卷风灾害之一，联邦政府将配合各地州政府为灾情提供一切帮助','看看新闻','冰冰',10,10,'2021-12-09 11:09:02',1),
(16,'社会','据美国媒体当地时间11日报道，美国中部6个州10日夜间遭遇至少30场龙卷风袭击，截至目前龙卷风灾害已造成超过百人死亡，肯塔基州灾情最为严重。\r\n\r\n美国总统拜登11日发表讲话称，此次龙卷风灾害或为美国历史上遭遇的最为严重的龙卷风灾害之一，联邦政府将配合各地州政府为灾情提供一切帮助','看看新闻','冰冰',10,10,'2021-12-09 11:09:02',1),
(17,'社会','据美国媒体当地时间11日报道，美国中部6个州10日夜间遭遇至少30场龙卷风袭击，截至目前龙卷风灾害已造成超过百人死亡，肯塔基州灾情最为严重。\r\n\r\n美国总统拜登11日发表讲话称，此次龙卷风灾害或为美国历史上遭遇的最为严重的龙卷风灾害之一，联邦政府将配合各地州政府为灾情提供一切帮助','看看新闻','冰冰',10,10,'2021-12-09 11:09:02',1),
(18,'社会','据美国媒体当地时间11日报道，美国中部6个州10日夜间遭遇至少30场龙卷风袭击，截至目前龙卷风灾害已造成超过百人死亡，肯塔基州灾情最为严重。\r\n\r\n美国总统拜登11日发表讲话称，此次龙卷风灾害或为美国历史上遭遇的最为严重的龙卷风灾害之一，联邦政府将配合各地州政府为灾情提供一切帮助','看看新闻','冰冰',10,10,'2021-12-09 11:09:02',1),
(19,'社会','据美国媒体当地时间11日报道，美国中部6个州10日夜间遭遇至少30场龙卷风袭击，截至目前龙卷风灾害已造成超过百人死亡，肯塔基州灾情最为严重。\r\n\r\n美国总统拜登11日发表讲话称，此次龙卷风灾害或为美国历史上遭遇的最为严重的龙卷风灾害之一，联邦政府将配合各地州政府为灾情提供一切帮助','看看新闻','冰冰',10,10,'2021-12-09 11:09:02',1),
(20,'社会','据美国媒体当地时间11日报道，美国中部6个州10日夜间遭遇至少30场龙卷风袭击，截至目前龙卷风灾害已造成超过百人死亡，肯塔基州灾情最为严重。\r\n\r\n美国总统拜登11日发表讲话称，此次龙卷风灾害或为美国历史上遭遇的最为严重的龙卷风灾害之一，联邦政府将配合各地州政府为灾情提供一切帮助','看看新闻','冰冰',10,10,'2021-12-09 11:09:02',1),
(21,'社会','据美国媒体当地时间11日报道，美国中部6个州10日夜间遭遇至少30场龙卷风袭击，截至目前龙卷风灾害已造成超过百人死亡，肯塔基州灾情最为严重。\r\n\r\n美国总统拜登11日发表讲话称，此次龙卷风灾害或为美国历史上遭遇的最为严重的龙卷风灾害之一，联邦政府将配合各地州政府为灾情提供一切帮助','看看新闻','冰冰',10,10,'2021-12-09 11:09:02',1),
(22,'社会','据美国媒体当地时间11日报道，美国中部6个州10日夜间遭遇至少30场龙卷风袭击，截至目前龙卷风灾害已造成超过百人死亡，肯塔基州灾情最为严重。\r\n\r\n美国总统拜登11日发表讲话称，此次龙卷风灾害或为美国历史上遭遇的最为严重的龙卷风灾害之一，联邦政府将配合各地州政府为灾情提供一切帮助','看看新闻','冰冰',10,10,'2021-12-12 15:23:36',1),
(23,'社会','据美国媒体当地时间11日报道，美国中部6个州10日夜间遭遇至少30场龙卷风袭击，截至目前龙卷风灾害已造成超过百人死亡，肯塔基州灾情最为严重。\r\n\r\n美国总统拜登11日发表讲话称，此次龙卷风灾害或为美国历史上遭遇的最为严重的龙卷风灾害之一，联邦政府将配合各地州政府为灾情提供一切帮助','看看新闻','冰冰',10,10,'2021-12-12 15:28:16',1),
(24,'军事','哈哈哈哈哈','百度新闻','自己',5,10,'2021-12-12 16:01:44',1),
(25,'军事','哈哈哈哈哈','百度新闻','自己',5,10,'2021-12-12 16:06:43',1),
(26,'社会','皇后的哥哥说的是哈哈5555','百度新闻','自己',10,10,'2021-12-12 16:07:21',1),
(27,'社会','皇后的哥哥说的是哈哈','百度新闻','自己',10,10,'2021-12-12 18:09:50',1),
(28,'社会','皇后的哥哥说的是哈哈','百度新闻','自己',10,10,'2021-12-12 18:17:50',0),
(31,'社会','皇后的哥哥说的是哈哈','百度新闻','自己',10,10,'2021-12-12 18:46:12',1),
(32,'66','66','66','66',66,66,'2021-12-12 18:53:58',1),
(33,'77','77','77','77',77,77,'2021-12-12 18:56:30',1),
(34,'教育','6666','666','666',66666,66,'2021-12-12 20:59:41',1),
(36,'明星','观察者网讯）与特朗普“渐行渐远”后，美国前副总统彭斯开始独立走上“全国巡游”之路，为2024年可能的总统竞选打下基础。\n\n　　据英国《卫报》11日报道，现在的彭斯，采取了一种颇为圆滑的策略：与特朗普保持距离，但不公开谴责他，试图以此讨好特朗普的追随者，同时借此向其他共和党人表明“降温”态度。彭斯的传记作者迈克尔德·安东尼（Michael D’Antonio）说，彭斯的行为所表达的意思是：“看，我是唐纳德·特朗普，但没有暴力。”\n\n　　然而，因为公开反对1月6日的国会冲击事件，彭斯至今仍受到特朗普追随者谴责，可能陷入“两头不讨好”的尴尬境地。据英国《卫报》11日报道，前共和党国会助理巴代拉直言，彭斯是“一个没有任何真正道德信念或原则的懦夫”。','新浪新闻','继荣',5,9,'2021-12-12 22:53:33',1),
(38,'科技','666666666666','新浪新闻','66',7,7,'2021-12-13 22:26:19',1),
(39,'社会','但是F','搜狐新闻','和经济',5,8,'2021-12-14 14:38:42',1),
(40,'财经','方法','百度新闻','fff',6,2,'2021-12-14 16:32:53',1),
(41,'财经','方法','百度新闻','fff',7,2,'2021-12-14 16:32:58',1),
(42,'财经','方法','百度新闻','fff',7,2,'2021-12-14 16:33:00',1),
(43,'财经','方法','百度新闻','fff',7,2,'2021-12-14 16:33:02',0),
(44,'财经','方法','百度新闻','fff',7,2,'2021-12-14 16:33:04',0),
(45,'财经','方法','百度新闻','fff',7,2,'2021-12-14 16:33:06',0),
(46,'财经','方法','百度新闻','fff',7,2,'2021-12-14 16:33:13',1),
(47,'财经','方法','百度新闻','fff',7,2,'2021-12-14 16:33:15',0),
(48,'教育','jdx','新浪新闻','7',6,4,'2021-12-14 16:33:39',0),
(49,'教育','44','央视新闻','自己',5,4,'2021-12-19 12:14:50',1),
(50,'教育','44','新浪新闻','自己',5,4,'2021-12-19 12:14:55',1),
(51,'教育','44','搜狐新闻','自己',5,4,'2021-12-19 12:14:59',1),
(52,'教育','44','凤凰新闻','自己',5,4,'2021-12-19 12:15:03',1),
(53,'教育','44','搜视新闻','自己',5,4,'2021-12-19 12:15:06',1),
(54,'教育','44','新华新闻','自己',5,4,'2021-12-19 12:15:10',1),
(55,'教育','44','腾讯新闻','自己',5,4,'2021-12-19 12:15:14',1),
(56,'教育','44','网易新闻','自己',5,4,'2021-12-19 12:15:18',1),
(57,'财经','ffgg','环球新闻','自己',5,2,'2021-12-19 12:15:48',1);

/*Table structure for table `news_category` */

DROP TABLE IF EXISTS `news_category`;

CREATE TABLE `news_category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类编号',
  `title` varchar(20) NOT NULL COMMENT '分类名称',
  `sort` int(11) DEFAULT '0' COMMENT '0-10,值越大排前',
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

/*Data for the table `news_category` */

insert  into `news_category`(`categoryId`,`title`,`sort`) values 
(1,'军事',4),
(2,'财经',4),
(4,'教育',2),
(6,'家庭',5),
(7,'科技',7),
(8,'社会',10),
(9,'明星',10),
(12,'bug',3);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `nickname` varchar(50) NOT NULL,
  `account` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `uq_account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

/*Data for the table `users` */

insert  into `users`(`userId`,`nickname`,`account`,`password`) values 
(1,'张三','admin','123456'),
(2,'李四','root','123456'),
(3,'王五','admin1','123456'),
(4,'王si','root123','123456'),
(11,'李四大地','adminwe456','123456'),
(13,'好好规划规划和','sdd','12434123'),
(20,'ffff','root1','123456');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
