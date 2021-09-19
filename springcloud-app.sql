-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.24-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 springcloud-app 的数据库结构
CREATE DATABASE IF NOT EXISTS `springcloud-app` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `springcloud-app`;

-- 导出  表 springcloud-app.system_resources 结构
CREATE TABLE IF NOT EXISTS `system_resources` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- 正在导出表  springcloud-app.system_resources 的数据：~17 rows (大约)
/*!40000 ALTER TABLE `system_resources` DISABLE KEYS */;
INSERT INTO `system_resources` (`id`, `pid`, `name`, `url`, `type`, `sort`) VALUES
	(1, 0, '菜单', '/', '1', NULL),
	(2, 1, '系统管理', '/system', '1', 1),
	(8, 2, '菜单管理', '/system/resources', '1', 3),
	(9, 8, '增加', '/system/resources/add', '2', NULL),
	(10, 8, '删除', '/system/resources/delete', '2', NULL),
	(11, 8, '列表', '/system/resources/list', '2', NULL),
	(12, 8, '更改', '/system/resources/update', '2', NULL),
	(13, 2, '角色管理', '/system/role', '1', 2),
	(14, 13, '添加', '/system/role/add', '2', NULL),
	(15, 13, '删除', '/system/role/delete', '2', NULL),
	(16, 13, '列表', '/system/role/list', '2', NULL),
	(17, 13, '更改', '/system/role/update', '2', NULL),
	(18, 2, '用户管理', '/system/user', '1', 1),
	(19, 18, '添加', '/system/user/add', '2', NULL),
	(20, 18, '删除', '/system/user/delete', '2', NULL),
	(21, 18, '列表', '/system/user/list', '2', NULL),
	(22, 18, '更改', '/system/user/update', '2', NULL);
/*!40000 ALTER TABLE `system_resources` ENABLE KEYS */;

-- 导出  表 springcloud-app.system_role 结构
CREATE TABLE IF NOT EXISTS `system_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  springcloud-app.system_role 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `system_role` DISABLE KEYS */;
INSERT INTO `system_role` (`id`, `name`) VALUES
	(1, 'JAVA');
/*!40000 ALTER TABLE `system_role` ENABLE KEYS */;

-- 导出  表 springcloud-app.system_role_resources 结构
CREATE TABLE IF NOT EXISTS `system_role_resources` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `resources_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- 正在导出表  springcloud-app.system_role_resources 的数据：~17 rows (大约)
/*!40000 ALTER TABLE `system_role_resources` DISABLE KEYS */;
INSERT INTO `system_role_resources` (`id`, `role_id`, `resources_id`) VALUES
	(1, 1, 2),
	(7, 1, 8),
	(8, 1, 9),
	(9, 1, 10),
	(10, 1, 1),
	(11, 1, 11),
	(12, 1, 12),
	(13, 1, 13),
	(14, 1, 14),
	(15, 1, 15),
	(16, 1, 16),
	(17, 1, 17),
	(18, 1, 18),
	(19, 1, 19),
	(20, 1, 20),
	(21, 1, 21),
	(22, 1, 22);
/*!40000 ALTER TABLE `system_role_resources` ENABLE KEYS */;

-- 导出  表 springcloud-app.system_user 结构
CREATE TABLE IF NOT EXISTS `system_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  springcloud-app.system_user 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `system_user` DISABLE KEYS */;
INSERT INTO `system_user` (`id`, `username`, `password`) VALUES
	(1, 'wangsong', '532da1c5da9fb86bf61b2a63487f300c');
/*!40000 ALTER TABLE `system_user` ENABLE KEYS */;

-- 导出  表 springcloud-app.system_user_role 结构
CREATE TABLE IF NOT EXISTS `system_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  springcloud-app.system_user_role 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `system_user_role` DISABLE KEYS */;
INSERT INTO `system_user_role` (`id`, `user_id`, `role_id`) VALUES
	(1, 1, 1);
/*!40000 ALTER TABLE `system_user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
