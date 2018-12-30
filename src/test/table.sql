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

INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('《软件需求分析与设计》综合实践.pdf',  '/resource/《软件需求分析与设计》综合实践.pdf', '3', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('《软件需求分析与设计》课程简介.pptx',  '/resource/《软件需求分析与设计》课程简介.pptx', '3', '0');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf',  '/resource/2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf', '5', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('《软件需求分析与设计》课程简介.pptx',  '/resource/《软件需求分析与设计》课程简介.pptx', '3', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf',  '/resource/2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf', '5', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('《软件需求分析与设计》综合实践.pdf',  '/resource/《软件需求分析与设计》综合实践.pdf', '3', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('《软件需求分析与设计》课程简介.pptx',  '/resource/《软件需求分析与设计》课程简介.pptx', '3', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf',  '/resource/2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf', '5', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('《软件需求分析与设计》综合实践.pdf',  '/resource/《软件需求分析与设计》综合实践.pdf', '3', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('《软件需求分析与设计》综合实践.pdf',  '/resource/《软件需求分析与设计》综合实践.pdf', '3', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('《软件需求分析与设计》课程简介.pptx',  '/resource/《软件需求分析与设计》课程简介.pptx', '3', '0');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf',  '/resource/2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf', '5', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('《软件需求分析与设计》课程简介.pptx',  '/resource/《软件需求分析与设计》课程简介.pptx', '3', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf',  '/resource/2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf', '5', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('《软件需求分析与设计》综合实践.pdf',  '/resource/《软件需求分析与设计》综合实践.pdf', '3', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('《软件需求分析与设计》课程简介.pptx',  '/resource/《软件需求分析与设计》课程简介.pptx', '3', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf',  '/resource/2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf', '5', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('《软件需求分析与设计》综合实践.pdf',  '/resource/《软件需求分析与设计》综合实践.pdf', '3', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('《软件需求分析与设计》综合实践.pdf',  '/resource/《软件需求分析与设计》综合实践.pdf', '3', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('《软件需求分析与设计》课程简介.pptx',  '/resource/《软件需求分析与设计》课程简介.pptx', '3', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf',  '/resource/2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf', '5', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('《软件需求分析与设计》课程简介.pptx',  '/resource/《软件需求分析与设计》课程简介.pptx', '3', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf',  '/resource/2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf', '5', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('《软件需求分析与设计》综合实践.pdf',  '/resource/《软件需求分析与设计》综合实践.pdf', '3', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('《软件需求分析与设计》课程简介.pptx',  '/resource/《软件需求分析与设计》课程简介.pptx', '5', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf',  '/resource/2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf', '5', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('《软件需求分析与设计》综合实践.pdf',  '/resource/《软件需求分析与设计》综合实践.pdf', '5', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('《软件需求分析与设计》综合实践.pdf',  '/resource/《软件需求分析与设计》综合实践.pdf', '5', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('《软件需求分析与设计》课程简介.pptx',  '/resource/《软件需求分析与设计》课程简介.pptx', '5', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf',  '/resource/2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf', '5', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('《软件需求分析与设计》课程简介.pptx',  '/resource/《软件需求分析与设计》课程简介.pptx', '4', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf',  '/resource/2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf', '5', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('《软件需求分析与设计》综合实践.pdf',  '/resource/《软件需求分析与设计》综合实践.pdf', '4', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('《软件需求分析与设计》课程简介.pptx',  '/resource/《软件需求分析与设计》课程简介.pptx', '4', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf',  '/resource/2017-18-1--面向对象分析与设计(UML)--期中考试试卷A-答案.pdf', '5', '1');
INSERT INTO uml_open_course_db.resource (resName,  resPath, resType, isCheck) VALUES ('《软件需求分析与设计》综合实践.pdf',  '/resource/《软件需求分析与设计》综合实践.pdf', '5', '1');