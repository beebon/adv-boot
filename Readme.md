# 简介

  * 后端基于 SpringBoot，Mybatis-plus，Shiro，JWT
  * 前端采用Vue & Ant Design
  * 提供了python模板生成器（代码生成器理论上生成的代码是平台无关的，即你可以通过修改模板来生成任何语言的代码）,已提供了基于本框架适用的模板
  
  
# 目录结构
  * adv : 前端代码
  * boot : 后端代码
  * codesmith : 代码生成器代码
  
# 安装与部署

  * 配置数据库：新建名为adv-boot的数据库（建议mysql或mariadb），执行boot/doc/db/init.sql
    注：若有需要可修改application.yml中的数据库连接配置
    
  * 安装redis: 安装并使用默认配置，如有需有请自行修改application.yml中的redis连接配置

  * 启动后台：在boot目录上执行终端命令 mvn spring-boot:run，启动后可正常访问http://localhost:8168/adv-boot/swagger-ui.htm
    
    注：关于maven启动入口可参考 https://blog.csdn.net/qbg19881206/article/details/19850857 ,适用单元测试
    
  * 启动前台：执行npm install && npm run serve,访问http://localhost:3000/ 即可访问站点，默认登录帐号密码admin/admin
    注：通过npm install全局安装依赖webpack与vue-cli 3.2.1,确保版本支持即可，vue-cli安装参考https://cli.vuejs.org/zh/guide/installation.html
    若出现问题建议把node_module目录删除后重新安装依赖包
  
  * 代码生成器：安装python与jupyter notebook,在jupyter下打开codesmith目录下的main.ipynb,运行第一项即可（可根据实际需要到cfg目录修改配置文件）
    注：需安装sqlalchemy与pymysql依赖包