-- auto Generated on 2017-07-19 14:31:35 
-- DROP TABLE IF EXISTS `system_category_attr_values`; 
CREATE TABLE `system_category_attr_values`(
    `value_id` VARCHAR (50) NOT NULL AUTO_INCREMENT COMMENT 'valueId',
    `attribute_id` BIGINT (15) DEFAULT -1 COMMENT 'attributeId',
    `category_id` BIGINT (15) DEFAULT -1 COMMENT 'categoryId',
    `features_all` VARCHAR (50) DEFAULT '' COMMENT 'featuresAll',
    `id` BIGINT (15) COMMENT 'id',
    `index_id` INT (11) DEFAULT -1 COMMENT 'indexId',
    `value` VARCHAR (255) DEFAULT '' COMMENT 'value',
    PRIMARY KEY (`value_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`system_category_attr_values`';
