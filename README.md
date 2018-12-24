UML课程设计
-----------

目录
----
-   [UML课程设计](#uml课程设计)
-   [目录](#目录)
-   [重要文档链接](#重要文档链接)
-   [项目规范及各种教程](#项目规范及各种教程)
    -   [代码规范](#代码规范)
    -   [关于commit](#关于commit)
    -   [关于issue](#关于issue)
    -   [git教程](#git教程)
    -   [processon](#processon)
-   [如何团队项目保持同步(重要)](#如何团队项目保持同步重要)
-   [docker部署说明](#docker部署说明)

重要文档链接
------------

-   [项目规格说明书](docs/demand-specification.md)
-   [项目需求说明书](docs/README.md)
-   [关于规格说明书以及数据库信息](https://github.com/orgs/UMLTeam/teams/dgutteam)
-   [关于分工的信息](https://github.com/orgs/UMLTeam/teams/dgutteam)

项目规范及各种教程
------------------

### 代码规范

-   所有路径全部使用绝对路径,勿使用相对路径,以免造成跳转错误.
-   命名要规范 (驼峰)

### 关于commit

-   请不要将.idea/ 等文件传上来
-   commit时,请说清楚你所修改的内容
-   commit前一定要fetch 与 merge
-   大家要是修复了哪个bug, 就在commit时 加入 fix \#issueid,例如:


```bash
git commit -m "尝试关闭issue fix #47"
```
    
### 关于issue

-   大家要是发现有什么bug,或者什么需求, 也可以在github中提交issue,
    然后我们尝试着使用issue来分配任务以及任务进度跟踪
-   [Github issues
    使用指南](http://note.openmindclub.com/power/github-issue.html)

### git教程

-   [Git教程-
    廖雪峰的官方网站](https://www.liaoxuefeng.com/wiki/0013739516305929606dd18361248578c67b8067c8c017b000)
-   [GitHub团队项目合作流程](https://www.cnblogs.com/schaepher/p/4933873.html)

### processon

-   [processon在线画用例图](https://www.processon.com)

如何团队项目保持同步(重要)
--------------------------

-   第一次时需要,与团队仓库建立联系

``` {.bash}
git remote add upstream https://github.com/UMLTeam/DearHouAimin.git 
```

-   工作前后要运行这几条命令,和团队项目保持同步

``` {.bash}
git fetch upstream
git merge upstream/master
```

docker部署说明
--------------

-   部署命令

``` {.bash}
docker build  -t open_course .
docker-compose up -d db
docker-compose up -d web
```

-   查看状态的命令

``` {.bash}
docker logs -f team_web
```

-   删除

``` {.bash}
docker stop team_web
docker rm team_web
docker rmi dearhouaimin
docker rmi $(docker images | grep "^" | awk "{print $3}")
```
