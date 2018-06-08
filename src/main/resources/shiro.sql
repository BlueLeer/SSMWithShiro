/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.36 : Database - shiro
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shiro` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `shiro`;

/*Table structure for table `permission` */

CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `resource` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `permission` */

insert  into `permission`(`id`,`name`,`resource`) values (1,'部门列表','department:list');
insert  into `permission`(`id`,`name`,`resource`) values (2,'部门删除','department:delete');
insert  into `permission`(`id`,`name`,`resource`) values (3,'部门保存','department:save');
insert  into `permission`(`id`,`name`,`resource`) values (4,'部门编辑','department:edit');
insert  into `permission`(`id`,`name`,`resource`) values (5,'员工列表','employee:list');
insert  into `permission`(`id`,`name`,`resource`) values (6,'员工删除','employee:delete');
insert  into `permission`(`id`,`name`,`resource`) values (7,'员工保存','employee:save');
insert  into `permission`(`id`,`name`,`resource`) values (8,'员工编辑','employee:edit');
insert  into `permission`(`id`,`name`,`resource`) values (9,'部门列表','department:list');
insert  into `permission`(`id`,`name`,`resource`) values (10,'部门删除','department:delete');
insert  into `permission`(`id`,`name`,`resource`) values (11,'部门保存','department:save');
insert  into `permission`(`id`,`name`,`resource`) values (12,'部门编辑','department:edit');
insert  into `permission`(`id`,`name`,`resource`) values (13,'员工列表','employee:list');
insert  into `permission`(`id`,`name`,`resource`) values (14,'员工删除','employee:delete');
insert  into `permission`(`id`,`name`,`resource`) values (15,'员工保存','employee:save');
insert  into `permission`(`id`,`name`,`resource`) values (16,'员工编辑','employee:edit');

/*Table structure for table `role` */

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`name`,`sn`) values (1,'部门经理','deptMgr');
insert  into `role`(`id`,`name`,`sn`) values (2,'员工经理','empMgr');
insert  into `role`(`id`,`name`,`sn`) values (3,'管理员','admin');

/*Table structure for table `role_permission` */

CREATE TABLE `role_permission` (
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_permission` */

insert  into `role_permission`(`role_id`,`permission_id`) values (1,1);
insert  into `role_permission`(`role_id`,`permission_id`) values (1,2);
insert  into `role_permission`(`role_id`,`permission_id`) values (1,3);
insert  into `role_permission`(`role_id`,`permission_id`) values (1,4);
insert  into `role_permission`(`role_id`,`permission_id`) values (2,5);
insert  into `role_permission`(`role_id`,`permission_id`) values (2,6);
insert  into `role_permission`(`role_id`,`permission_id`) values (2,7);
insert  into `role_permission`(`role_id`,`permission_id`) values (2,8);

/*Table structure for table `user` */

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`) values (1,'admin','7fef057252c2517b629a1273934b1320');
insert  into `user`(`id`,`username`,`password`) values (2,'zhangsan','baacc2a8c7428f490042a1e17db48b9a');
insert  into `user`(`id`,`username`,`password`) values (3,NULL,NULL);

/*Table structure for table `user_role` */

CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`user_id`,`role_id`) values (1,1);
insert  into `user_role`(`user_id`,`role_id`) values (1,2);
insert  into `user_role`(`user_id`,`role_id`) values (2,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
