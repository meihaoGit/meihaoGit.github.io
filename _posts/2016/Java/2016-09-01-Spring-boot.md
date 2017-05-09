---
layout: post
title:  "Spring-boot勉強(1)"
date:   2016-09-01
category: Java
tags: [Java]
---

## Java Spring-boot開発準備

- [Java](http://www.oracle.com/technetwork/java/javase/downloads/index.html) - Java 8

- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) - IntelliJ IDEA 15



##### WEBUI 素材

- [AdminLTE](https://almsaeedstudio.com/) - AdminLTE

- [Font Awesome Icons](http://fortawesome.github.io/Font-Awesome/) - Font Awesome Icons

- [Ionicons](http://ionicons.com/) - Ionicons

- [js](http://www.jsdelivr.com/) - js lib

~~~
  html5shiv.js →IE対応
  respond.min.js → IE6～8でCSS3 Media Queries（max-widthとmin-width）を解釈可能
~~~

## システム全体像

- ・フレームワーク：Spring Boot
    * Spring Boot (v1.4.0.RELEASE)
- ・実行環境：開発中は組込みTomcat。本番運用はTomcat8
- ・プレゼンテーション層：Thymeleaf。
- ・言語：Java SE 8
- ・運用時はHTTPS通信を行う想定
- ・フロント: Apache2.2
- ・開発環境：IntelliJ IDEA   
    Spring Boot + Thymeleaf + Tomcat + Gradle   

---

## 開発


- [gradle](https://gradle.org/) - Java（JVM）環境におけるビルドシステム

- [mybatis-3](https://github.com/mybatis/mybatis-3) - mybatis-3

#### ログ出力

- [Logback](https://github.com/mybatis/mybatis-3) - Logback
   compile('org.slf4j:slf4j-api:1.7.21')

- logback.xml


- 画像表示テスト

![spring構造](https://raw.githubusercontent.com/meihaoGit/meihaoGit.github.io/master/assets/images/img/spring_1.png)


##### Postgresqlデータベース接続


build.gradle 下記を追加

~~~
compile('org.springframework.boot:spring-boot-starter-data-jpa')
runtime('org.postgresql:postgresql')
~~~

src/main/resourcesの「config」を作成

application.xml


~~~
spring:
  datasource:
    url:  jdbc:postgresql://localhost/sbdb
    username: XXXX
    password: XXXX
    driverClassName: org.postgresql.Driver
~~~


##### その他

- 「xxx cannot be applied to groovy.lang.Closure」 が出たので、対処方法

~~~
File → Settings     
        Build,　Execution,　Deployment    
        Build tools    
        Gradle    
        Use local gradle distribution   
        Gradle home    
~~~
        
→DAO変更Service

##### SpringBootのプロジェクト

- パッケージ構成の設定

~~~
JPA案
├─ src/main/java
│   └─ com.example
│        ├─ app                              ... アプリケーション層のパッケージ
│        │   ├─ foo
│        │   │   └─ FooController.java
│        │   ├─ ErrorPageController.java
│        │   └─ GlobalExceptionHandler.java
│        ├─ domain                           ... ドメイン層のパッケージ
│        │   ├─ model
│        │   │   └─ BarEntity.java
│        │   ├─ repository
│        │   │   └─ BarRepository.java
│        │   └─ service
│        │        └─ FooService.java
│        ├─ utils                            ... 共通で使うUtilityのパッケージ
│        │   └─ Utils.java
│        ├─ DemoApplication.java             ... SpringBootServletInitializerの具象クラス
│        └─ WebSecurityConfig.java           ... WebSecurityConfigurerAdapterの具象クラス
└─ src/main/resources
     ├─ templates                             ... Thymeleafのテンプレート
     │   ├─ foo
     │   │   └─ index.html
     │   ├─ common                           ... 共通UIパーツ
     │   │   └─ header.html
     │   └─ error                            ... エラーページ
     │        ├─ 403.html
     │        ├─ 404.html
     │        └─ 500.html
     ├─ static
     │   ├─ dist                             ... 3rd-partyのjs/css
     │   │   └─ bootstrap
     │   ├─ css
     │   ├─ fonts
     │   └─ js
     └─ application.properties
~~~
~~~
mybatis 案
src
  ┗ main
        ┣ java
        ┃    ┗ com
        ┃         ┗ qiita
        ┃                ┗ demo
        ┃                      ┣ dao(DB処理層)
        ┃                      ┃
        ┃                      ┣ domain(ドメインモデルを定義する層)
        ┃                      ┃      ┗ tbl(DB Bean)
        ┃                      ┃
        ┃                      ┣ config(Springの色々な設定をJavaコード上で行うファイル群)
        ┃                      ┃
        ┃                      ┣ service(トランザクション処理を管理する層)
        ┃                      ┃
        ┃                      ┣ web(WEB層-コントローラーを記載)
        ┃                      ┃   ┣ controller
        ┃                      ┃   ┃
        ┃                      ┃   ┗ form(画面 Bean)
        ┃                      ┃
        ┃                      ┗Application.java(エントリポイント)
        ┃
        ┗ resources
                   ┣ dao(MyBatisのxml格納)
                   ┃
                   ┣ META-INF
                   ┃       ┗ resources
                   ┃
                   ┣ public(共通のjsやcss)
                   ┃
                   ┣ static(静的ファイル)
                   ┃                  ┣ images(画像)
                   ┃                  ┃
                   ┃                  ┣ scripts(js)
                   ┃                  ┃
                   ┃                  ┣ styles(css)
                   ┃                  ┃
                   ┃                  ┗ (静的なHTMLファイル群)
                   ┃
                   ┗ templates(thymeleaf 拡張子html)
                   
~~~


- build.gradleの設定

~~~
dependencies {
  //Spring Initializrで設定された依存関係
  compile('org.springframework.boot:spring-boot-starter-data-jpa')
  compile('org.springframework.boot:spring-boot-starter-security')
  compile('org.springframework.boot:spring-boot-starter-thymeleaf')
  compile('org.springframework.boot:spring-boot-starter-web')
  runtime('com.h2database:h2')
  testCompile('org.springframework.boot:spring-boot-starter-test')

  //ThymeleafでSpring Securityの機能を使うために追加
  compile('org.thymeleaf.extras:thymeleaf-extras-springsecurity4')

  //よく使うライブラリたち
  compile 'org.projectlombok:lombok:1.16.8'
  compile 'org.apache.commons:commons-csv:1.2'
  compile 'org.apache.commons:commons-lang3:3.4'
  compile 'org.apache.commons:commons-io:1.3.2'
  compile 'org.apache.commons:commons-collections4:4.1'

  //SpringでDBUnitを楽に使うためのライブラリ
  testCompile 'com.github.springtestdbunit:spring-test-dbunit:1.3.0'
}
~~~


- application.propertiesの設定

~~~
# ===================================================================
# APPLICATION PROPERTIES
# ===================================================================

# ----------------------------------------
# CORE PROPERTIES
# ----------------------------------------

# LOGGING
logging.file=logs/app.log
logging.level.root=WARN
logging.level.com.example=INFO
logging.level.org.hibernate.SQL=INFO
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=INFO

# THYMELEAF (ThymeleafAutoConfiguration)
spring.thymeleaf.cache=false

# ----------------------------------------
# WEB PROPERTIES
# ----------------------------------------

# MULTIPART (MultipartProperties)
multipart.max-file-size=10MB
multipart.max-request-size=100MB

# EMBEDDED SERVER CONFIGURATION (ServerProperties)
server.port=8080
server.session.timeout=900

# ----------------------------------------
# SECURITY PROPERTIES
# ----------------------------------------
# SECURITY (SecurityProperties)
security.basic.enabled=false

# ----------------------------------------
# DATA PROPERTIES
# ----------------------------------------
# DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
#spring.datasource.driverClassName=com.mysql.jdbc.Driver
#spring.datasource.url=jdbc:mysql://localhost/test
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.url=jdbc:h2:file:./database/test;MODE=PostgreSQL;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.username=user
spring.datasource.password=user

### test and validation for connection
spring.datasource.test-on-borrow=true
spring.datasource.validation-query=SELECT 1
### remove connection when abolish
spring.datasource.remove-abandoned=true
spring.datasource.remove-abandoned-timeout=30
### Settings of Connection pool
spring.datasource.max-active=50
spring.datasource.max-idle=8
spring.datasource.min-idle=8
spring.datasource.initial-size=10
## Number of ms to wait before throwing an exception if no connection is available.
spring.datasource.max-wait=10000

# H2 Web Console (H2ConsoleProperties)
#spring.h2.console.enabled=false # Enable the console.
#spring.h2.console.path=/h2-console # Path at which the console will be available.

# JPA (JpaBaseConfiguration, HibernateJpaAutoConfiguration)
#spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
#spring.jpa.show-sql=true
~~~

curl http://localhost:8080/user/selectuser

## 参考サイト

- [SpringBoot](http://wannabe-jellyfish.hatenablog.com/entry/2016/05/08/154028) - SpringBootでWebアプリを作るとき

- [IntelliJ IDEA](http://qiita.com/opengl-8080/items/108102d692b49f804dbd) - IntelliJ IDEA 入門

- [IntelliJ IDEA](http://ksby.hatenablog.com/entry/2016/11/27/180337) - IntelliJ IDEA 2016.3 の新機能を試してみる


## 備忘

-  Application context not configured for this file

~~~
IntelliJ > Preferences > Notifications > Spring Configuration Check > No popup

~~~


* IntelliJ IDEA 2017.1.2 x64 active 
    
    1.  [IntelliJ IDEA ](http://idea.lanyus.com/) - IntelliJ IDEA GetActive
    
    2.  license server:
     ~~~
     http://intellij.mandroid.cn/ 
     http://idea.imsxm.com/ 
     http://idea.iteblog.com/key.php
     ~~~
 

* IntelliJ IDEAをWindowsにインストールした際にまずやっておくべき設定
    
    1. プロジェクトのデフォルト設定
    
      Configure > Project Defaultes > Project Structureで New > JDK
    
    2.  日本語フォントを設定する
    
      Configure > Settings > Appearance > Override default fonts by… で Meiryo UIを有効にする.
    
    3.  行末カーソル制限を設定する
    
      Configure > Settings > Editor > Allow placement of caret after end of line のチェックマークをはずします.
