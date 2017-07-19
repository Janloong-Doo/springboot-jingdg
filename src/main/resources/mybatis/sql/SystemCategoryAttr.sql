-- auto Generated on 2017-07-19 11:02:10 
-- DROP TABLE IF EXISTS `system_category_attr`; 
CREATE TABLE `system_category_attr`(
    `attr_id` VARCHAR (50) NOT NULL AUTO_INCREMENT COMMENT 'attrId',
    `category_attr_id` BIGINT (15) NOT NULL DEFAULT -1 COMMENT 'categoryAttrId',
    `attr_index_id` INT (11) DEFAULT -1 COMMENT 'attrIndexId',
    `att_name` VARCHAR (255) NOT NULL DEFAULT '' COMMENT 'attName',
    `input_type` INT (11) DEFAULT -1 COMMENT 'inputType',
    `category_id` BIGINT (15) NOT NULL DEFAULT -1 COMMENT 'categoryId',
    `attribute_type` INT (11) DEFAULT -1 COMMENT 'attributeType',
    `features_all` VARCHAR (255) DEFAULT '' COMMENT 'featuresAll',
    PRIMARY KEY (`attr_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`system_category_attr`';
