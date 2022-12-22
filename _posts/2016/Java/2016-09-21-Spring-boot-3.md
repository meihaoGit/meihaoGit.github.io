---
layout: post
title:  "Spring-boot勉強(4)"
date:   2016-10-11
category: Java
tags: [Java]
---

## Java Spring-boot前回

- [Spring-boot勉強(1)](https://meihaogit.github.io/java/2016/09/01/Spring-boot.html) - Spring-boot勉強(1)
- [Spring-boot勉強(2)](https://meihaogit.github.io/java/2016/09/07/Spring-boot-1.html) - Spring-boot勉強(2)
- [Spring-boot勉強(3)](https://meihaogit.github.io/java/2016/09/21/Spring-boot-2.html) - Spring-boot勉強(3)


## activiti 開発


- spring-boot-with-activiti 実装

- [Activiti User Guide](http://activiti.org/userguide/index.html) - Activiti User Guide 

- [spring-boot-with-activiti-example](https://github.com/jbarrez/spring-boot-with-activiti-example) - spring-boot-with-activiti-example

- [alfresco-activiti](https://docs.alfresco.com/activiti/blog/posts/201603-demos/) - alfresco-activiti-example


## Spring Boot関連資料

- [Spring-boot勉強(中国語)](http://www.infoq.com/cn/articles/microframeworks1-spring-boot/) - Spring-boot勉強(中国語)


##　Micro Services 関連資料

- [Micro Services](http://martinfowler.com/articles/microservices.html) - Micro Services

- [Micro Services testing](http://martinfowler.com/articles/microservice-testing/) - Micro Services testing

- [マイクロサービスのフレームワーク](http://qiita.com/hat22/items/3c9ad74d89166b7a72db) - マイクロサービス

- [React.js and Spring Data REST](https://spring.io/guides/tutorials/react-and-spring-data-rest/) - React.js and Spring Data REST

- [マイクロサービスアーキテクチャ](http://tsuyoshi-nakamura.hatenablog.com/entry/2016/06/15/105639) - マイクロサービス

- [Spring Bootで作ったRESTful API](http://qiita.com/gates1de/items/5ac83f48212580e6c7fd) - Spring Bootで作ったRESTful API

- [Microservice紹介](http://www.cnblogs.com/loveis715/p/4644266.html) - Microservice紹介（中国語）


### 

- [OIDC と JWT の関わり](https://zenn.dev/mikakane/articles/tutorial_for_openid) 


##　 RxJavaとは

- [RxJavaの概要](http://codezine.jp/article/detail/9570) - RxJavaの概要

####  特性：
- 大きなサービスを実行させるにあたって、マイクロサービスでは次のような小さいサービスを開発して、Web APIを通じて、各サービスを呼び出し連携させます。

~~~   
認証サービス（IDやパスワード）
ロジック：データのフィルタリングサービス（サイズや色）
ロジック：レコメンデーションサービス（おすすめ商品の通知）
アクセス許可：在庫管理システム連携サービス
データ：販売実績の追加、配送ステータス管理サービス

~~~   
- こうすることによって、マイクロサービスでは、次のような利点が得られます。

~~~
開発チームがサービスごとに分かれて、得意な言語を利用して各サービスの開発を進めることができる
変更をかけたいときは、システム全体ではなく、その小さなサービスごとに変更をかけられる
小さなサービスで開発単位を進めるため、ビルドやテストの期間が短くなり開発効率が上がる
モノリシックなシステムだと何か障害が起きたときに、どこがおかしいのかルート構造をたどるのに時間がかかるが、原因の突き止めが比較的容易

~~~
