CREATE TABLE `sport_activity_sponsor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '主办方名称',
  `telephone` varchar(255) NULL COMMENT '联系电话',
  `email` varchar(255) NULL COMMENT '联系邮箱',
  `website` varchar(255) NULL COMMENT '官方网址',
  `introduction` text NULL COMMENT '主办方介绍',
  `logo_image_id` bigint(20) NULL COMMENT '主办方logo图片id',
  `logo_image_url` varchar(255) NULL COMMENT '主办方logo图片url',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) COMMENT='体育活动_主办方';

CREATE TABLE `sport_activity_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '分类名称',
  `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '父级id',
  `lft` int(11) NULL COMMENT '最左',
  `rgt` int(11) NULL COMMENT '最右',
  `sort` int(11) NOT NULL COMMENT '排序',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否已删除',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) COMMENT='活动分类';

CREATE TABLE `sport_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '活动名称',
  `begin_time` datetime NOT NULL COMMENT '活动开始时间',
  `end_time` datetime NOT NULL COMMENT '活动结束时间',
  `site` varchar(255) NULL COMMENT '活动地点',
  `address` varchar(255) NULL COMMENT '详细地址',
  `sponsor` bigint(20) NOT NULL COMMENT '主办方',
  `category_id` bigint(20) NOT NULL COMMENT '活动分类id',
  `is_public` tinyint(1) NOT NULL COMMENT '是否公开活动',
  `poster_image_id` bigint(20) NULL COMMENT '活动海报图片id',
  `poster_image_url` varchar(255) NULL COMMENT '活动海报图片url',
  `activity_detail` text NULL COMMENT '活动详情',
  `share_title` varchar(255) NULL COMMENT '分享标题',
  `share_description` varchar(255) NULL COMMENT '分享描述',
  `share_image_id` bigint(20) NULL COMMENT '分享图片id',
  `share_image_url` varchar(255) NULL COMMENT '分享图片',
  `quantity_limit` tinyint(1) NOT NULL COMMENT '报名数量限制',
  `quantity` int(10) NULL COMMENT '报名数量',
  `subject` tinyint(1) NOT NULL COMMENT '报名对象',
  `team_qty_limit` tinyint(1) NOT NULL COMMENT '是否限制团体人数',
  `team_qty_min` int(10) NULL COMMENT '团体人数最小值',
  `team_qty_max` int(10) NULL COMMENT '团体人数最大值',
  `fee_flag` tinyint(1) NOT NULL COMMENT '活动是否收费',
  `fee` decimal(12,2) NULL COMMENT '收费费用',
  `refund_flag` tinyint(1) NOT NULL COMMENT '是否支持退费',
  `audit_flag` tinyint(1) NOT NULL COMMENT '活动需要审核',
  `form_id` bigint(20) NOT NULL COMMENT '表单id',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否已删除',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) COMMENT='体育活动';

CREATE TABLE `sport_member_favorites` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `entity_id` bigint(20) NOT NULL COMMENT '实体id',
  `type` tinyint(2) NOT NULL COMMENT '收藏活动的类型',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) COMMENT='体育活动_收藏';

CREATE TABLE `sport_activity_team` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
 `name` varchar(255) NULL COMMENT '名称',
 `activity_id` bigint(20) NOT NULL COMMENT '活动id',
 `create_at` datetime NOT NULL COMMENT '创建时间',
 `update_at` datetime NOT NULL COMMENT '更新时间',
 PRIMARY KEY (`id`)
) COMMENT='活动队伍';

CREATE TABLE `sport_activity_signup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `activity_id` bigint(20) NOT NULL COMMENT '活动id',
  `activity_channel_id` bigint(20) NULL COMMENT '活动渠道id',
  `team_id` bigint(20) NOT NULL COMMENT '队伍id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `status` int(6) NOT NULL COMMENT '状态',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否已删除',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) COMMENT='活动报名';

CREATE TABLE `sport_signup_field_value` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`signup_id` bigint(20) NOT NULL COMMENT '活动报名id',
	`field_id` bigint(20) NOT NULL COMMENT '字段id',
	`field_value` varchar(255) NULL COMMENT '字段值',
	`update_at` datetime NOT NULL COMMENT '更新时间',
	`create_at` datetime NOT NULL COMMENT '创建时间',
	PRIMARY KEY (`id`)
) COMMENT='活动报名字段值表';

CREATE TABLE `sport_invitation_letter` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '邀请用户id',
  `activity_id` bigint(20) NOT NULL COMMENT '活动id',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) COMMENT='邀请函';

CREATE TABLE `sport_invited_user_view` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `letter_id` bigint(20) NOT NULL COMMENT '邀请函id',
  `user_id` bigint(20) NOT NULL COMMENT '浏览用户id',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) COMMENT='邀请函浏览信息';

CREATE TABLE `sport_activity_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_no` varchar(64) NOT NULL COMMENT '订单号',
  `signup_id` bigint(20) NOT NULL COMMENT '活动报名id',
  `amount` decimal(12,2) NOT NULL COMMENT '总额',
  `paid_amount` decimal(12,2) NULL COMMENT '实付金额',
  `status` tinyint(6) NOT NULL COMMENT '状态',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否已删除',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) COMMENT='活动报名订单';

CREATE TABLE `sport_activity_refund_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `refund_order_no` varchar(64) NOT NULL COMMENT '退款单号',
  `signup_id` bigint(20) NOT NULL COMMENT '活动报名id',
  `refund_amount` decimal(12,2) NOT NULL COMMENT '退款金额',
  `status` tinyint(6) NOT NULL COMMENT '状态',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否已删除',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) COMMENT='活动报名退款单';

CREATE TABLE `sport_infomation_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '父级id',
  `lft` int(11) NULL COMMENT '最左',
  `rgt` int(11) NULL COMMENT '最右',
  `sort` int(11) NOT NULL COMMENT '排序',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否已删除',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) COMMENT='资讯分类';

CREATE TABLE `sport_information` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category_id` bigint(20) NOT NULL COMMENT '分类id',
  `title` varchar(255) NOT NULL COMMENT '文章标题',
  `introduction` text NULL COMMENT '文章简介',
  `sort` int(11) NOT NULL COMMENT '排序',
  `is_hot` tinyint(1) NULL COMMENT '是否热门文章',
  `details` text NULL COMMENT '文章详情',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) COMMENT='资讯';

CREATE TABLE `sport_msg_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) COMMENT='消息用户组';

CREATE TABLE `sport_msg_group_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `group_id` bigint(20) NOT NULL COMMENT '分组id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) COMMENT='消息用户组的用户';

CREATE TABLE `sport_channel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '渠道名称',
  `flag` varchar(255) NOT NULL COMMENT '渠道标记',
  `introduction` text NULL COMMENT '渠道介绍',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) COMMENT='渠道';

CREATE TABLE `sport_activity_channel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `activity_id` bigint(20) NOT NULL COMMENT '活动id',
  `channel_id` bigint(20) NOT NULL COMMENT '渠道id',
  `link_url` varchar(255) NULL COMMENT '渠道链接',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) COMMENT='活动渠道';

CREATE TABLE `sport_activity_view` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `activity_id` bigint(20) NOT NULL COMMENT '活动id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `activity_channel_id` bigint(20) NULL COMMENT '活动渠道id',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) COMMENT='活动浏览';

CREATE TABLE `sport_activity_view_statistics` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `activity_id` bigint(20) NOT NULL COMMENT '活动id',
  `activity_channel_id` bigint(20) NULL COMMENT '活动渠道id',
  `view_count` int(10) NOT NULL COMMENT '浏览次数',
  `view_user_count` int(10) NOT NULL COMMENT '浏览用户数',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) COMMENT='活动浏览统计';

