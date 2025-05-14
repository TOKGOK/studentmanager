/*
SQLyog Ultimate v8.32 
MySQL - 5.5.40 : Database - studentmanager
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`student_manager` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `student_manager`;

/*Table structure for table `s_admin` */

DROP TABLE IF EXISTS `s_admin`;

CREATE TABLE `s_admin` (
  `id` VARCHAR(32) PRIMARY KEY,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `s_admin` */

insert  into `s_admin`(`id`,`username`,`password`,`status`)
values
    (1,'admin','123456',1);

/*Table structure for table `s_attendance` */

DROP TABLE IF EXISTS `s_attendance`;

CREATE TABLE `s_attendance` (
  `id` VARCHAR(32) PRIMARY KEY,
  `course_id` VARCHAR(32) NOT NULL,
  `student_id` VARCHAR(32) NOT NULL,
  `type` varchar(11) NOT NULL,
  `date` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `s_attendance` */

insert  into `s_attendance`(`id`,`course_id`,`student_id`,`type`,`date`)
values
    (13,1,2,'上午','2018-09-04'),
    (14,1,4,'上午','2018-09-04'),
    (15,2,2,'上午','2019-07-02');

/*Table structure for table `s_clazz` */

DROP TABLE IF EXISTS `s_clazz`;

CREATE TABLE `s_clazz` (
  `id` VARCHAR(32) PRIMARY KEY,
  `name` varchar(32) NOT NULL,
  `info` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `s_clazz` */

insert  into `s_clazz`(`id`,`name`,`info`)
values
    (1,'软件一班','软件工程专业'),
    (4,'数学一班','大学数学专业'),
    (5,'计算机科学与技术一班','计算机专业');

/*Table structure for table `s_course` */

DROP TABLE IF EXISTS `s_course`;

CREATE TABLE `s_course` (
  `id` VARCHAR(32) PRIMARY KEY ,
  `name` varchar(32) NOT NULL,
  `teacher_id` VARCHAR(32) NOT NULL,
  `course_date` varchar(32) DEFAULT NULL,
  `selected_num` int(5) NOT NULL DEFAULT '0',
  `max_num` int(5) NOT NULL DEFAULT '50',
  `info` varchar(128) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4;

/*Data for the table `s_course` */

insert  into `s_course`(`id`,`name`,`teacher_id`,`course_date`,`selected_num`,`max_num`,`info`)
values
    (1,'大学英语',9,'周三上午8点',49,50,'英语'),
    (2,'大学数学',10,'周三上午10点',4,50,'数学'),
    (3,'计算机基础',11,'周三上午',3,50,'计算机课程');

/*Table structure for table `s_leave` */

DROP TABLE IF EXISTS `s_leave`;

CREATE TABLE `s_leave` (
  `id` VARCHAR(32),
  `student_id` VARCHAR(32) NOT NULL,
  `info` varchar(512) DEFAULT NULL,
  `status` VARCHAR(32) NOT NULL DEFAULT '0',
  `remark` varchar(512) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `s_leave` */

insert  into `s_leave`(`id`,`student_id`,`info`,`status`,`remark`)
values
    (13,2,'世界这么大，想去看看',1,'同意，你很6');

/*Table structure for table `s_score` */

DROP TABLE IF EXISTS `s_score`;

CREATE TABLE `s_score` (
  `id` VARCHAR(32) PRIMARY KEY ,
  `student_id` VARCHAR(32) NOT NULL,
  `course_id` VARCHAR(32) NOT NULL,
  `scoreDto` double(5,2) NOT NULL,
  `remark` varchar(128) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4;

/*Data for the table `s_score` */

insert  into `s_score`(`id`,`student_id`,`course_id`,`scoreDto`,`remark`)
values
    (67,4,2,78.00,'中等'),
    (68,9,1,50.00,'不及格');

/*Table structure for table `s_selected_course` */

DROP TABLE IF EXISTS `s_selected_course`;

CREATE TABLE `s_selected_course` (
  `id` VARCHAR(32) PRIMARY KEY ,
  `student_id` VARCHAR(32) NOT NULL,
  `course_id` VARCHAR(32) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4;

/*Data for the table `s_selected_course` */

insert  into `s_selected_course`(`id`,`student_id`,`course_id`)
values
    (18,2,1),
    (19,2,2),
    (20,2,3),
    (21,4,3),
    (22,4,2),
    (24,9,1);

/*Table structure for table `s_student` */

DROP TABLE IF EXISTS `s_student`;

CREATE TABLE `s_student` (
  `id` VARCHAR(32) PRIMARY KEY ,
  `sn` varchar(32) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `clazz_id` VARCHAR(32) NOT NULL,
  `sex` varchar(5) NOT NULL DEFAULT '男',
  `mobile` varchar(12) DEFAULT NULL,
  `qq` varchar(18) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4;

/*Data for the table `s_student` */

insert  into `s_student`(`id`,`sn`,`username`,`password`,`clazz_id`,`sex`,`mobile`,`qq`,`photo`)
values
    (2,'S51528202992845','张三纷','123456',1,'女','13545454548','1332365656',NULL),
    (4,'S51528379586807','王麻子','111111',5,'男','13356565656','123456',NULL),
    (9,'S41528633634989','马冬梅','1',5,'男','13333332133','131313132323','bb12326f-ef6c-4d3d-a2ae-f9eb30a15ad4.jpg');

/*Table structure for table `s_teacher` */

DROP TABLE IF EXISTS `s_teacher`;

CREATE TABLE `s_teacher` (
  `id` VARCHAR(32) PRIMARY KEY ,
  `sn` varchar(32) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `clazz_id` VARCHAR(32) NOT NULL,
  `sex` varchar(5) NOT NULL DEFAULT '男',
  `mobile` varchar(12) DEFAULT NULL,
  `qq` varchar(18) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `s_teacher` */

insert  into `s_teacher`(`id`,`sn`,`username`,`password`,`clazz_id`,`sex`,`mobile`,`qq`,`photo`)
values (9,'T11528608730648','张三','111',4,'男','13918655656','1193284480',NULL),
       (10,'T11528609224588','李四老师','111',4,'男','13656565656','123456',NULL),
       (11,'T51528617262403','李老师','123456',5,'男','18989898989','1456655565',NULL),
       (18,'T11561727746515','夏青松','123456',1,'女','15174857845','1745854125','5d447b8b-ec54-4a8e-919a-453aa7b6d33b.jpg');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
