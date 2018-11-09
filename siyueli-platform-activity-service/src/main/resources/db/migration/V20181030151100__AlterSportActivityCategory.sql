ALTER TABLE `sport_activity_category`
  ADD COLUMN introduction text NULL COMMENT '分类简介';

ALTER TABLE `sport_activity_category`
  ADD COLUMN image_id bigint(20) NULL COMMENT '分类id';

ALTER TABLE `sport_activity_category`
  ADD COLUMN image_url varchar(255) NULL COMMENT '分类url';

ALTER TABLE `sport_activity_category`
  ADD COLUMN is_hot tinyint(1) NULL COMMENT '是否设为热门分类';

