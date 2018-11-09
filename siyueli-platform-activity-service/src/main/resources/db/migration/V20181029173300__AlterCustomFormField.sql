ALTER TABLE `custom_form_field`
  ADD COLUMN `field_type` tinyint(2) NULL COMMENT '字段类型';

ALTER TABLE `custom_form_field`
  ADD COLUMN `required` tinyint(1) NULL COMMENT '是否必填';