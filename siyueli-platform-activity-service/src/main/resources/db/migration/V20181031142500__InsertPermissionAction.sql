INSERT INTO permission_action(`id`,`action_url`,`display_name`,`group_id`,`created_at`)
VALUES(274,'/api/siyueli-activity/file/upload','文件上传接口',1,'2018-10-08 14:57:00');

INSERT INTO permission_role(`id`,`role_id`,`permission_id`,`permission_group_id`)
VALUES(461,1,274,1);