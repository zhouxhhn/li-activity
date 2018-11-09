ALTER TABLE `sport_information`
  ADD COLUMN `author` varchar(255) NULL COMMENT '作者';

ALTER TABLE `sport_information`
  ADD COLUMN `image_id` bigint(20) NULL COMMENT '封面图id';

ALTER TABLE `sport_information`
  ADD COLUMN `image_url` varchar(255) NULL COMMENT '封面图url';

