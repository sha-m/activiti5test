/*
SQLyog Ultimate v12.3.1 (64 bit)
MySQL - 8.0.11 : Database - activiti5test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`activiti5test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `activiti5test`;

/*Table structure for table `t_staff` */

DROP TABLE IF EXISTS `t_staff`;

CREATE TABLE `t_staff` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `sex` varchar(3) DEFAULT NULL,
  `state` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_staff` */

insert  into `t_staff`(`id`,`name`,`sex`,`state`) values 
(1,'小明','男',0),
(2,'小丽','女',0),
(3,'小红','女',1);

/*Table structure for table `t_staff_travel` */

DROP TABLE IF EXISTS `t_staff_travel`;

CREATE TABLE `t_staff_travel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staffName` varchar(90) DEFAULT NULL,
  `travel` int(5) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `cost` int(10) DEFAULT '0',
  `state` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `t_staff_travel` */

/*Table structure for table `t_staff_travel_process` */

DROP TABLE IF EXISTS `t_staff_travel_process`;

CREATE TABLE `t_staff_travel_process` (
  `tra_id` int(11) DEFAULT NULL,
  `piid` varchar(180) DEFAULT NULL,
  `pstep` varchar(180) DEFAULT NULL,
  `state` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_staff_travel_process` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
