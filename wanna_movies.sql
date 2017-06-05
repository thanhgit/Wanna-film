/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : wanna_movies

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2017-06-05 13:40:10
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `account_id` bigint(20) NOT NULL default '0',
  `user_name` text,
  `password` text,
  `email` text,
  `phone` text,
  `authority` text COMMENT 'user',
  PRIMARY KEY  (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1496373753357', 'phucthanh', '123', 'thanh@gmail.com', '134', 'root');
INSERT INTO `account` VALUES ('1496403915888', 'thanhuit', '123', 'thanh@gmail.com', '056113', 'user');
INSERT INTO `account` VALUES ('1496404075906', 'thanhthanh', 'vanhao', 'thanh@gmail.com', '056113', 'user');

-- ----------------------------
-- Table structure for `country`
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `country_id` bigint(11) NOT NULL default '0',
  `country_name` text,
  PRIMARY KEY  (`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES ('1', 'Nhật bản');
INSERT INTO `country` VALUES ('2', 'Hàn quốc');
INSERT INTO `country` VALUES ('3', 'Trung quốc');
INSERT INTO `country` VALUES ('4', 'Mỹ');
INSERT INTO `country` VALUES ('5', 'Úc');
INSERT INTO `country` VALUES ('6', 'Lào');
INSERT INTO `country` VALUES ('7', 'Thái Lan');
INSERT INTO `country` VALUES ('9', 'Anh');
INSERT INTO `country` VALUES ('10', 'Ấn Độ');
INSERT INTO `country` VALUES ('123', 'Việt Nam');
INSERT INTO `country` VALUES ('1496465086921', 'Đức');
INSERT INTO `country` VALUES ('1496465234363', 'Bao');

-- ----------------------------
-- Table structure for `film`
-- ----------------------------
DROP TABLE IF EXISTS `film`;
CREATE TABLE `film` (
  `film_id` bigint(20) NOT NULL default '0',
  `film_name` text,
  `film_description` longtext,
  `film_image` text,
  `film_video` text,
  `genres_id` bigint(20) default NULL,
  `country_id` bigint(20) default NULL,
  `produced_year` int(11) default NULL,
  `check_see_max` tinyint(255) unsigned zerofill default '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000',
  `is_series` tinyint(4) default '0',
  `is_feature` tinyint(4) default '0',
  `is_rating` tinyint(4) default '0',
  `is_recently` tinyint(4) default '0',
  `status_id` bigint(20) default '1496355971090',
  PRIMARY KEY  (`film_id`),
  KEY `FK_1050nks2vj9uc41at0rl9dlcv` (`country_id`),
  KEY `FK_jm6ge8knc2d4ixq81oknt4ffq` (`genres_id`),
  KEY `FK_r8d7p6cux2n42begkoj3qyhm1` (`status_id`),
  CONSTRAINT `FK_1050nks2vj9uc41at0rl9dlcv` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`),
  CONSTRAINT `FK_jm6ge8knc2d4ixq81oknt4ffq` FOREIGN KEY (`genres_id`) REFERENCES `genres` (`genres_id`),
  CONSTRAINT `FK_r8d7p6cux2n42begkoj3qyhm1` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of film
-- ----------------------------
INSERT INTO `film` VALUES ('1', 'Tazan', 'Tarzan, having acclimated to life in London, is called back to his former home in the jungle to investigate the activities at a mining encampment.', '5.jpg', 'ORdSmoYrS7o', '1', '1', '2016', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', '0', '1', '1', '1', '1496355971090');
INSERT INTO `film` VALUES ('2', 'Maximum Ride', 'Six children, genetically cross-bred with avian DNA, take flight around the country to discover their origins. Along the way, their mysterious past is ...', '2.jpg', 'ztJlOmefsd0', '1', '2', '2017', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', '1', '2', '0', '0', '1496355955104');
INSERT INTO `film` VALUES ('3', 'Independence', 'The fate of humanity hangs in the balance as the U.S. President and citizens decide if these aliens are to be trusted ...or feared.', '3.jpg', 'ztJlOmefsd0', '1', '2', '2015', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', '1', '0', '1', '1', '1496355971090');
INSERT INTO `film` VALUES ('4', 'Moana', 'Bộ phim nói về ngôi sao hàng đầu xứ Hàn, Yeo Woon Kwang (Park Sung Woong) và anh chàng đặc vụ bí mật Kim Sul Woo (Park Hae Jin). Kim Sul-Woo âm thầm làm việc như vệ sĩ của Yeo Woon-Gwang, nam diễn viên chuyên thể hiện những vai diễn hành động. Bộ phim nói về ngôi sao hàng đầu xứ Hàn', '1.jpg', 'YZa7m_H-V7w', '1', '5', '2016', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', '1', '1', '0', '0', '1496355882112');
INSERT INTO `film` VALUES ('5', 'Dirty Grandpa', 'Bộ phim nói về ngôi sao hàng đầu xứ Hàn, Yeo Woon Kwang (Park Sung Woong) và anh chàng đặc vụ bí mật Kim Sul Woo (Park Hae Jin). Kim Sul-Woo âm thầm làm việc như vệ sĩ của Yeo Woon-Gwang, nam diễn viên chuyên thể hiện những vai diễn hành động.\r\n', '2.jpg', 'ztJlOmefsd0', '2', '1', '2016', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', '1', '0', '0', '0', '1496355971090');
INSERT INTO `film` VALUES ('6', 'Ride Along', 'Bộ phim nói về ngôi sao hàng đầu xứ Hàn, Yeo Woon Kwang (Park Sung Woong) và anh chàng đặc vụ bí mật Kim Sul Woo (Park Hae Jin). Kim Sul-Woo âm thầm làm việc như vệ sĩ của Yeo Woon-Gwang, nam diễn viên chuyên thể hiện những vai diễn hành động.\r\n', '3.jpg', 'YZa7m_H-V7w', '2', '1', '2016', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000', '1', '1', '1', '1', '1496355971090');
INSERT INTO `film` VALUES ('7', 'The Boss', 'Bộ phim nói về ngôi sao hàng đầu xứ Hàn, Yeo Woon Kwang (Park Sung Woong) và anh chàng đặc vụ bí mật Kim Sul Woo (Park Hae Jin). Kim Sul-Woo âm thầm làm việc như vệ sĩ của Yeo Woon-Gwang, nam diễn viên chuyên thể hiện những vai diễn hành động.\r\n', '4.jpg', 'ztJlOmefsd0', '2', '1', '2016', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000', '1', '0', '0', '0', '1496355971090');
INSERT INTO `film` VALUES ('8', 'Keanu', 'Bộ phim nói về ngôi sao hàng đầu xứ Hàn, Yeo Woon Kwang (Park Sung Woong) và anh chàng đặc vụ bí mật Kim Sul Woo (Park Hae Jin). Kim Sul-Woo âm thầm làm việc như vệ sĩ của Yeo Woon-Gwang, nam diễn viên chuyên thể hiện những vai diễn hành động.\r\n', '5.jpg', 'ztJlOmefsd0', '2', '1', '2016', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000', '0', '1', '0', '0', '1496355882112');
INSERT INTO `film` VALUES ('9', 'Ice Age', 'Bộ phim nói về ngôi sao hàng đầu xứ Hàn, Yeo Woon Kwang (Park Sung Woong) và anh chàng đặc vụ bí mật Kim Sul Woo (Park Hae Jin). Kim Sul-Woo âm thầm làm việc như vệ sĩ của Yeo Woon-Gwang, nam diễn viên chuyên thể hiện những vai diễn hành động.\r\n', '6.jpg', 'YZa7m_H-V7w', '2', '1', '2016', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000', '0', '0', '1', '0', '1496355971090');
INSERT INTO `film` VALUES ('10', 'Mike-Dave', 'Bộ phim nói về ngôi sao hàng đầu xứ Hàn, Yeo Woon Kwang (Park Sung Woong) và anh chàng đặc vụ bí mật Kim Sul Woo (Park Hae Jin). Kim Sul-Woo âm thầm làm việc như vệ sĩ của Yeo Woon-Gwang, nam diễn viên chuyên thể hiện những vai diễn hành động.\r\n', '7.jpg', 'YZa7m_H-V7w', '2', '1', '2016', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000', '0', '0', '0', '0', '1496355971090');
INSERT INTO `film` VALUES ('11', 'Bad Moms', 'Bộ phim nói về ngôi sao hàng đầu xứ Hàn, Yeo Woon Kwang (Park Sung Woong) và anh chàng đặc vụ bí mật Kim Sul Woo (Park Hae Jin). Kim Sul-Woo âm thầm làm việc như vệ sĩ của Yeo Woon-Gwang, nam diễn viên chuyên thể hiện những vai diễn hành động.\r\n', '8.jpg', 'ORdSmoYrS7o', '2', '1', '2016', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000', '0', '0', '0', '1', '1496355971090');
INSERT INTO `film` VALUES ('12', 'Barber Shop', 'Bộ phim nói về ngôi sao hàng đầu xứ Hàn, Yeo Woon Kwang (Park Sung Woong) và anh chàng đặc vụ bí mật Kim Sul Woo (Park Hae Jin). Kim Sul-Woo âm thầm làm việc như vệ sĩ của Yeo Woon-Gwang, nam diễn viên chuyên thể hiện những vai diễn hành động.\r\n', '9.jpg', 'ORdSmoYrS7o', '2', '1', '2016', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000', '1', '1', '1', '0', '1496355882112');
INSERT INTO `film` VALUES ('13', 'Nine Leaves', 'Bộ phim nói về ngôi sao hàng đầu xứ Hàn, Yeo Woon Kwang (Park Sung Woong) và anh chàng đặc vụ bí mật Kim Sul Woo (Park Hae Jin). Kim Sul-Woo âm thầm làm việc như vệ sĩ của Yeo Woon-Gwang, nam diễn viên chuyên thể hiện những vai diễn hành động.\r\n', '10.jpg', 'ORdSmoYrS7o', '2', '1', '2016', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000', '0', '1', '0', '0', '1496355971090');
INSERT INTO `film` VALUES ('14', 'Dream', 'Bộ phim nói về ngôi sao hàng đầu xứ Hàn, Yeo Woon Kwang (Park Sung Woong) và anh chàng đặc vụ bí mật Kim Sul Woo (Park Hae Jin). Kim Sul-Woo âm thầm làm việc như vệ sĩ của Yeo Woon-Gwang, nam diễn viên chuyên thể hiện những vai diễn hành động.\r\n', '11.jpg', 'ztJlOmefsd0', '2', '1', '2016', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000', '1', '0', '0', '1', '1496355882112');
INSERT INTO `film` VALUES ('15', 'War on Everyone', 'Bộ phim nói về ngôi sao hàng đầu xứ Hàn, Yeo Woon Kwang (Park Sung Woong) và anh chàng đặc vụ bí mật Kim Sul Woo (Park Hae Jin). Kim Sul-Woo âm thầm làm việc như vệ sĩ của Yeo Woon-Gwang, nam diễn viên chuyên thể hiện những vai diễn hành động.\r\n', '12.jpg', 'ztJlOmefsd0', '2', '1', '2017', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000', '0', '1', '0', '0', '1496355971090');
INSERT INTO `film` VALUES ('16', 'bibi', 'Bộ phim nói về ngôi sao hàng đầu xứ Hàn, Yeo Woon Kwang (Park Sung Woong) và anh chàng đặc vụ bí mật Kim Sul Woo (Park Hae Jin). Kim Sul-Woo âm thầm làm việc như vệ sĩ của Yeo Woon-Gwang, nam diễn viên chuyên thể hiện những vai diễn hành động.\r\n', '12.jpg', 'ztJlOmefsd0', '2', '1', '2018', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000', '1', '0', '0', '0', '1496355882112');

-- ----------------------------
-- Table structure for `genres`
-- ----------------------------
DROP TABLE IF EXISTS `genres`;
CREATE TABLE `genres` (
  `genres_id` bigint(20) NOT NULL default '0',
  `genres_name` text character set utf8,
  PRIMARY KEY  (`genres_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of genres
-- ----------------------------
INSERT INTO `genres` VALUES ('1', 'Phim hài');
INSERT INTO `genres` VALUES ('2', 'Phim cổ trang');
INSERT INTO `genres` VALUES ('3', 'Phim viễn tưởng');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` bigint(20) NOT NULL,
  `tag_name` text character set utf8 collate utf8_unicode_ci,
  `tag_order` int(11) default NULL,
  `num_child` int(11) default NULL,
  `checked` int(11) unsigned zerofill default NULL,
  `url` text character set utf8 collate utf8_unicode_ci,
  PRIMARY KEY  (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', 'Trang chủ', '1', '0', '00000000001', '/WannaMovies/home/index');
INSERT INTO `menu` VALUES ('3', 'Thể loại', '2', '1', '00000000000', '/WannaMovies/genres/');
INSERT INTO `menu` VALUES ('4', 'Tin mới', '7', '0', '00000000000', '/WannaMovies/news/');
INSERT INTO `menu` VALUES ('13', 'Phim bộ', '3', '0', '00000000000', '/WannaMovies/series_movie/');
INSERT INTO `menu` VALUES ('14', 'Phim lẻ', '4', '0', '00000000000', '/WannaMovies/movies/');
INSERT INTO `menu` VALUES ('15', 'Quốc gia', '5', '2', '00000000000', '/WannaMovies/country/');
INSERT INTO `menu` VALUES ('16', 'Tìm kiếm', '6', '0', '00000000000', '/WannaMovies/search/');
INSERT INTO `menu` VALUES ('1496137294160', 'Top', '0', '0', '00000000000', '/WannaMovies/top/');

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `news_id` bigint(20) NOT NULL default '0',
  `news_title` text,
  `news_description` text,
  `news_image` text,
  `published_date` date default NULL,
  `viewer` int(11) default '0',
  `published_man` text COMMENT 'không tên',
  PRIMARY KEY  (`news_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1496311495837', 'Hot girl', 'phim hay', '3.jpg', '2017-06-01', '0', 'vô danh');
INSERT INTO `news` VALUES ('1496350830678', 'Em chưa 18', 'phim hay', '1.jpg', '2017-06-01', '0', 'Thanh uit');
INSERT INTO `news` VALUES ('1496354299279', 'Sau tất cả', 'phim ca nhạc', '1.jpg', '2017-06-02', '0', 'Van hao');

-- ----------------------------
-- Table structure for `status`
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `status_id` bigint(20) NOT NULL default '0',
  `status_name` text,
  PRIMARY KEY  (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of status
-- ----------------------------
INSERT INTO `status` VALUES ('1496355882112', 'Đang chiếu');
INSERT INTO `status` VALUES ('1496355955104', 'Sắp chiếu');
INSERT INTO `status` VALUES ('1496355971090', 'Đã chiếu');
