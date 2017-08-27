#drop table ga_user_info;
CREATE TABLE IF NOT EXISTS `ga_user_info`(
   `user_id`   VARCHAR(60),
   `user_name` VARCHAR(60) NOT NULL,
   `password` VARCHAR(60) NOT NULL,
   `email`    VARCHAR(100),
   `phone`    integer(11),
   `data_status` VARCHAR(1) NOT NULL,
   `create_by`   VARCHAR(60) NOT NULL,
   `create_date` DATE NOT NULL,
   `update_by`   VARCHAR(60) NOT NULL,
   `update_date` DATE NOT NULL,
   PRIMARY KEY ( `user_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table ga_user_info comment '用户信息表';
alter table ga_user_info modify column user_id VARCHAR(60) comment '用户id'; 
alter table ga_user_info modify column user_name VARCHAR(60) comment '用户名称'; 
alter table ga_user_info modify column password VARCHAR(60) comment '用户密码'; 
alter table ga_user_info modify column email VARCHAR(100) comment '用户邮箱'; 
alter table ga_user_info modify column phone integer comment '用户手机号码'; 
alter table ga_user_info modify column data_status VARCHAR(1) comment '数据状态 1：有效 0无效'; 
alter table ga_user_info modify column create_by VARCHAR(60) comment '创建人'; 
alter table ga_user_info modify column create_date DATE comment '创建时间'; 
alter table ga_user_info modify column update_by VARCHAR(60) comment '修改人'; 
alter table ga_user_info modify column update_date DATE comment '修改时间'; 


#drop table ga_role_info;
CREATE TABLE IF NOT EXISTS `ga_role_info`(
   `role_id`   VARCHAR(60),
   `role_name` VARCHAR(60) NOT NULL,
   `role_type` integer(2) NOT NULL,
   `data_status` VARCHAR(1) NOT NULL,
   `create_by`   VARCHAR(60) NOT NULL,
   `create_date` DATE NOT NULL,
   `update_by`   VARCHAR(60) NOT NULL,
   `update_date` DATE NOT NULL,
   PRIMARY KEY ( `role_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table ga_role_info comment '角色信息表';
alter table ga_role_info modify column role_id VARCHAR(60) comment '角色id'; 
alter table ga_role_info modify column role_name VARCHAR(60) comment '角色名称'; 
alter table ga_role_info modify column role_type integer(2) comment '用户类型 1 资源角色 2 数据角色'; 
alter table ga_role_info modify column data_status VARCHAR(1) comment '数据状态 1：有效 0无效'; 
alter table ga_role_info modify column create_by VARCHAR(60) comment '创建人'; 
alter table ga_role_info modify column create_date DATE comment '创建时间'; 
alter table ga_role_info modify column update_by VARCHAR(60) comment '修改人'; 
alter table ga_role_info modify column update_date DATE comment '修改时间'; 


#drop table ga_resource_info;
CREATE TABLE IF NOT EXISTS `ga_resource_info`(
   `resource_id`   VARCHAR(60),
   `resource_name` VARCHAR(60) NOT NULL,
   `resource_type` integer(2) NOT NULL,
   `data_status` VARCHAR(1) NOT NULL,
   `create_by`   VARCHAR(60) NOT NULL,
   `create_date` DATE NOT NULL,
   `update_by`   VARCHAR(60) NOT NULL,
   `update_date` DATE NOT NULL,
   PRIMARY KEY ( `resource_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table ga_resource_info comment '资源信息表';
alter table ga_resource_info modify column resource_id VARCHAR(60) comment '资源id'; 
alter table ga_resource_info modify column resource_name VARCHAR(60) comment '资源名称'; 
alter table ga_resource_info modify column resource_type integer(2) comment '资源类型 1 操作资源 2 数据资源'; 
alter table ga_resource_info modify column data_status VARCHAR(1) comment '数据状态 1：有效 0无效'; 
alter table ga_resource_info modify column create_by VARCHAR(60) comment '创建人'; 
alter table ga_resource_info modify column create_date DATE comment '创建时间'; 
alter table ga_resource_info modify column update_by VARCHAR(60) comment '修改人'; 
alter table ga_resource_info modify column update_date DATE comment '修改时间'; 


#drop table ga_user_role;
CREATE TABLE IF NOT EXISTS `ga_user_role`(
   `id`      VARCHAR(60),
   `user_id` VARCHAR(60) NOT NULL,
   `role_id` VARCHAR(60) NOT NULL,
   `data_status` VARCHAR(1) NOT NULL,
   `create_by`   VARCHAR(60) NOT NULL,
   `create_date` DATE NOT NULL,
   `update_by`   VARCHAR(60) NOT NULL,
   `update_date` DATE NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table ga_user_role comment '用户角色关联表';
alter table ga_user_role modify column id VARCHAR(60) comment 'id'; 
alter table ga_user_role modify column user_id VARCHAR(60) comment '用户编号'; 
alter table ga_user_role modify column role_id VARCHAR(60) comment '角色编号'; 
alter table ga_user_role modify column data_status VARCHAR(1) comment '数据状态 1：有效 0无效'; 
alter table ga_user_role modify column create_by VARCHAR(60) comment '创建人'; 
alter table ga_user_role modify column create_date DATE comment '创建时间'; 
alter table ga_user_role modify column update_by VARCHAR(60) comment '修改人'; 
alter table ga_user_role modify column update_date DATE comment '修改时间'; 

#drop table ga_role_resource;
CREATE TABLE IF NOT EXISTS `ga_role_resource`(
   `id`      VARCHAR(60),
   `role_id` VARCHAR(60) NOT NULL,
   `resource_id` VARCHAR(60) NOT NULL,
   `data_status` VARCHAR(1) NOT NULL,
   `create_by`   VARCHAR(60) NOT NULL,
   `create_date` DATE NOT NULL,
   `update_by`   VARCHAR(60) NOT NULL,
   `update_date` DATE NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table ga_role_resource comment '角色资源关联表';
alter table ga_role_resource modify column id VARCHAR(60) comment 'id'; 
alter table ga_role_resource modify column role_id VARCHAR(60) comment '角色编号'; 
alter table ga_role_resource modify column resource_id VARCHAR(60) comment '资源编号'; 
alter table ga_role_resource modify column data_status VARCHAR(1) comment '数据状态 1：有效 0无效'; 
alter table ga_role_resource modify column create_by VARCHAR(60) comment '创建人'; 
alter table ga_role_resource modify column create_date DATE comment '创建时间'; 
alter table ga_role_resource modify column update_by VARCHAR(60) comment '修改人'; 
alter table ga_role_resource modify column update_date DATE comment '修改时间'; 
