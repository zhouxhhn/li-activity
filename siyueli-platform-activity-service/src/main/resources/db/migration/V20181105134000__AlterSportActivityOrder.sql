ALTER TABLE `sport_activity_order`
  ADD COLUMN `remark` varchar(255) NULL COMMENT '备注' AFTER `status`;