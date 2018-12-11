UML课程设计
-----------

目录
----
-   [UML课程设计](#uml课程设计)
-   [目录](#目录)
-   [重要文档链接](#重要文档链接)
-   [如何团队项目保持同步(重要)](#如何团队项目保持同步重要)
-   [docker部署说明](#docker部署说明)
-   [项目规范及各种教程](#项目规范及各种教程)
    -   [约定](#约定)
    -   [git教程](#git教程)
    -   [processon](#processon)

重要文档链接
------------

-   [项目规格说明书](docs/demand-specification.md)
-   [项目需求说明书](docs/README.md)

如何团队项目保持同步(重要)
--------------------------

-   第一次时需要,与团队仓库建立联系

<!-- -->

    git remote add upstream https://github.com/UMLTeam/DearHouAimin.git 

-   工作前后要运行这几条命令,和团队项目保持同步

<!-- -->

    git fetch upstream
    git merge upstream/master

docker部署说明
--------------

-   部署命令

``` {.bash}
docker build --no-cache open_course .
docker-compose up -d db
docker-compose up -d web
```

-   查看状态的命令

``` {.bash}
docker logs -f team_web
```
-   删除
```{.bash}
docker stop team_web
docker rm team_web
docker rmi dearhouaimin
docker rmi $(docker images | grep "^" | awk "{print $3}")
```

项目规范及各种教程
------------------

### 约定

-   所有路径全部使用绝对路径,勿使用相对路径,以免造成跳转错误.
-   命名要规范 (驼峰)
-   请不要将.idea/ 等文件传上来
-   commit时,请说清楚你所修改的内容

### git教程

-   [Git教程-
    廖雪峰的官方网站](https://www.liaoxuefeng.com/wiki/0013739516305929606dd18361248578c67b8067c8c017b000)\
-   [GitHub团队项目合作流程](https://www.cnblogs.com/schaepher/p/4933873.html)

### processon

-   [processon在线画用例图](https://www.processon.com)
