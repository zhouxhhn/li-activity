ALTER TABLE `sport_activity`
  ADD COLUMN status tinyint(2) NOT NULL COMMENT '状态';

ALTER TABLE `sport_activity`
  ADD COLUMN `is_hot` tinyint(1) NOT NULL COMMENT '是否热门';

ALTER TABLE `sport_activity`
  ADD COLUMN `sort` int(11) NOT NULL DEFAULT 1 COMMENT '排序';