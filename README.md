# hotelmaster
酒店管理系统

自己还没有完完整整的做一个项目，参考书籍《java web项目开发案例精粹》及其源码


开发工具：
    操作系统ｍａｃ　ｍｉｎｉ　OS10.12.5　
    开发工具：Idea 2017.2
    数据库：MySQL,
    版本:windows上5.1.33 for win32
    
    数据库客户端：macmini上Sequel pro,window上navicat
    JDK:1.8
    Web服务器：tomcat 8.0.39
    前端使用:anjularjs
    因为extjs收费且学习周期长因此改为anjularjs

    持久层：Hibernate框架开发
    Hibernate版本5.2.10.Final
    管理框架：Spring来管理各组件
    Spring版本4.3.10
    前端anjularjs:
    
在mac mini上Mysql密码是root，用户名也是root

以下记录的都是自己在做项目时疑问的地方：

2017年8月4日9:02:53
1.windows上,mysql使用客户端为：navicate10.0.17
2.关于maven web项目的目录组织结构：

可以参考官网：
http://maven.apache.org/plugins/maven-war-plugin/usage.html

src/main/java：主代码
    项目源代码放置在src/main/java下,
src/main/resource:资源文件
    涉及到的配置文件,数据文件通常放在src/main/resources目录下
    由于资源文件各类比较多,如数据源配置文件,日志,SQL脚本,
    Spring的Bean,Hibernate等配置进行分类管理.

基于Hibernate项目通常hbm配置文件比较多,可以在资源文件目录下创建
与实体类相同目录管理hbm文件.

target是通过maven来执行相关插件目标的生成目录,如clean,compile等.

3.引入相应的hibernate和spring的jar包,在Pom.xml中配置
最好的方式去看看官方文档.在maven仓库中https://mvnrepository.com这里找的

hibernate下载完整jar包可以看到文档.


