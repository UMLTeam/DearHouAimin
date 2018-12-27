-- auto-generated definition
create table resource
(
  id      int(11) unsigned auto_increment comment 'ID'
    primary key,
  resName varchar(255)                        not null comment '名称',
  resTime timestamp default CURRENT_TIMESTAMP not null comment '上传时间',
  resPath varchar(255)                        not null comment '上传路径',
  resType varchar(255)                        not null comment '资源类型',
  isCheck varchar(255)                        not null comment '发布状态'
)
  charset = utf8;


select * from resource where resType like 'test2';
