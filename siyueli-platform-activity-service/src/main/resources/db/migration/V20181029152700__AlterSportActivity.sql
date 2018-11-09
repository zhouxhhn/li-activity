ALTER TABLE `sport_activity`
  DROP COLUMN `site`;

ALTER TABLE `sport_activity`
  ADD COLUMN `site_province` bigint(20) NULL COMMENT '活动地点-省';

ALTER TABLE `sport_activity`
  ADD COLUMN `site_city` bigint(20) NULL COMMENT '活动地点-城市';

ALTER TABLE `sport_activity`
  ADD COLUMN `site_area` bigint(20) NULL COMMENT '活动地点-区';

ALTER TABLE `sport_activity`
  ADD COLUMN `allow_refund_time` decimal(6,2) NULL COMMENT '允许退款时间';

ALTER TABLE `sport_activity`
  ADD COLUMN `invited_need_payment` tinyint(1) NULL COMMENT '受邀人员需要付款';

ALTER TABLE `sport_activity`
  ADD COLUMN `signup_time_start` datetime NULL COMMENT '报名时间-开始';

ALTER TABLE `sport_activity`
  ADD COLUMN `signup_time_end` datetime NULL COMMENT '报名时间-结束';