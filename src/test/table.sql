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

INSERT INTO uml_open_course_db.resource (id, resName, resTime, resPath, resType, isCheck) VALUES (10, '《软件需求分析与设计》综合实践.pdf', '2018-12-27 12:20:13', '/resource/《软件需求分析与设计》综合实践.pdf', '习题库', '1');
INSERT INTO uml_open_course_db.resource (id, resName, resTime, resPath, resType, isCheck) VALUES (11, '《软件需求分析与设计》课程简介.pptx', '2018-12-27 12:13:53', '/resource/《软件需求分析与设计》课程简介.pptx', '习题库', '1');
INSERT INTO uml_open_course_db.resource (id, resName, resTime, resPath, resType, isCheck) VALUES (12, '2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf', '2018-12-27 12:18:18', '/resource/2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf', '习题库', '1');
INSERT INTO uml_open_course_db.resource (id, resName, resTime, resPath, resType, isCheck) VALUES (13, '《软件需求分析与设计》课程简介.pptx', '2018-12-27 12:13:53', '/resource/《软件需求分析与设计》课程简介.pptx', '习题库', '1');
INSERT INTO uml_open_course_db.resource (id, resName, resTime, resPath, resType, isCheck) VALUES (14, '2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf', '2018-12-27 12:18:18', '/resource/2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf', '习题库', '1');
INSERT INTO uml_open_course_db.resource (id, resName, resTime, resPath, resType, isCheck) VALUES (15, '《软件需求分析与设计》综合实践.pdf', '2018-12-27 12:20:13', '/resource/《软件需求分析与设计》综合实践.pdf', '习题库', '1');
INSERT INTO uml_open_course_db.resource (id, resName, resTime, resPath, resType, isCheck) VALUES (16, '《软件需求分析与设计》课程简介.pptx', '2018-12-27 12:13:53', '/resource/《软件需求分析与设计》课程简介.pptx', '习题库', '1');
INSERT INTO uml_open_course_db.resource (id, resName, resTime, resPath, resType, isCheck) VALUES (17, '2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf', '2018-12-27 12:18:18', '/resource/2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf', '习题库', '1');
INSERT INTO uml_open_course_db.resource (id, resName, resTime, resPath, resType, isCheck) VALUES (18, '《软件需求分析与设计》综合实践.pdf', '2018-12-27 12:20:13', '/resource/《软件需求分析与设计》综合实践.pdf', '习题库', '1');