INSERT INTO permission_role(role_id, permission_id, permission_group_id)
select 1,id,1 from permission_action where id >= 234;