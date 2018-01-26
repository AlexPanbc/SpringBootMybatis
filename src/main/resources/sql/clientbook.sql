CREATE TABLE `client_book` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(200) NOT NULL COMMENT '书名',
	`author` VARCHAR(200) NOT NULL COMMENT '作者',
	`typeworks` INT(11) NOT NULL COMMENT '作品分类',
	`typework` INT(11) NOT NULL COMMENT '作品类型',
	`workscount` BIGINT(20) NOT NULL COMMENT '作品字数',
	`store` INT(11) NOT NULL COMMENT '收藏数',
	`state` TINYINT(1) NOT NULL COMMENT '是否完结1true ',
	`createdate` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
	`updatedate` DATETIME NULL DEFAULT NULL COMMENT '修改时间',
	PRIMARY KEY (`id`)
)
COMMENT='书籍'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=3
;
