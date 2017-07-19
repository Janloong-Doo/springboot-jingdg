-- auto Generated on 2017-07-18 10:01:13 
-- DROP TABLE IF EXISTS `system_category`; 
CREATE TABLE `system_category`(
    `cid` VARCHAR (32) UNIQUE NOT NULL AUTO_INCREMENT COMMENT 'cid',
    `fid` BIGINT (15) NOT NULL DEFAULT -1 COMMENT 'fid',
    `id` BIGINT (15) NOT NULL COMMENT 'id',
    `lev` INT (11) NOT NULL DEFAULT -1 COMMENT 'lev',
    `name` VARCHAR (8) NOT NULL DEFAULT '' COMMENT 'name',
    `order` INT (11) NOT NULL DEFAULT -1 COMMENT 'order',
    `features_all` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'featuresAll',
    PRIMARY KEY (`cid`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`system_category`';
