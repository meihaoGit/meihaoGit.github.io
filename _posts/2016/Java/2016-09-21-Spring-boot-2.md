---
layout: post
title:  "Spring-boot勉強(3)"
date:   2016-09-21
category: Java
tags: [Java]
---

## Java Spring-boot前回

- [Spring-boot勉強(1)](https://meihaogit.github.io/java/2016/09/01/Spring-boot.html) - Spring-boot勉強(1)
- [Spring-boot勉強(2)](https://meihaogit.github.io/java/2016/09/07/Spring-boot-1.html) - Spring-boot勉強(2)


## 開発進階


- mybatis-spring-boot-starter 実装

     1. SQLをXMLファイルに書き
     
~~~
src/main/java/com/example/mapper/TodoMapper.java
@Mapper
public interface TodoMapper {
    void insert(Todo todo);
    Todo select(int id);
}
src/main/resources/com/example/mapper/TodoMapper.xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.example.mapper.TodoMapper">
    <insert id="insert" useGeneratedKeys="true" keyProperty="id">
        INSERT INTO todo (title, details, finished) VALUES (#{title}, #{details}, #{finished})
    </insert>
    <select id="select" resultType="com.example.domain.Todo">
        SELECT id, title, details, finished FROM todo WHERE id = #{id}
    </select>
</mapper>

~~~

##### フォルダ構成        


~~~     
│
├─src/main
│  ├─java
│  │  └─com
│  │      └─example
│  │          │  SpaTestApplication.java : SpringBootApp
│  │          │  
│  │          ├─config
│  │          │      MyConfiguration.java : JavaConfig
│  │          │      
│  │          ├─domain
│  │          │      Item.java : 業務データモデル
│  │          │      
│  │          ├─dto
│  │          │      DtoItem.java : DBレコード
│  │          │      
│  │          ├─mapper
│  │          │      ItemMapper.java : （テーブルとSQLの？）マッパー
│  │          │      
│  │          ├─repository
│  │          │      ItemRepository.java : ドメインとDTOの間を吸収する
│  │          │      
│  │          ├─service
│  │          │      ItemService.java : ドメインを使ってビジネスロジックを処理する
│  │          │      
│  │          └─web
│  │              └─rest
│  │                      ItemResource.java : RESTコントローラ
│  │                      
│  └─resources
│      ├─config
│      │      mybatis.xml : MyBatisの設定内容
│      │      
│      ├─sql
│      │      ItemMapper.xml : ItemMapperに対応するSQL群
│      │      
│      └─static
│          │  index.html : ページ
│          │  
│          ├─css
│          │      （割愛）
│          │      
│          ├─js
│          │      （割愛）
│          │      
│          └─vendor
│              ├─bootstrap
│              │      （割愛）
│              │          
│              ├─Ink
│              │      （割愛）
│              │          
│              └─jquery
│                     （割愛）
│                      
└─src/test
    └─java
        └─com
            └─example
            
~~~
- [SpringBoot(SPA)+MyBatis+RDBMS(PostgreSQL)](http://qiita.com/kojisaiki/items/be5805bba172aab188c3) - SpringBoot(SPA)+MyBatis+RDBMS(PostgreSQL)
