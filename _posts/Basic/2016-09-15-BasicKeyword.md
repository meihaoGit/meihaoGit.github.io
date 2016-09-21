---
layout: post
title:  "基本概念"
date:   2016-09-15
category: Basic
tags: [Basic]
---

## Java 関連

#### Spring Boot

スタンドアロンで production-grade な Spring ベースのアプリケーションを簡単に作ることができる。


#### Hibernate

Hibernate は Java で O/R マッピングを実現するためのツールです。    
O/R マッピングツールは、 オブジェクト指向とリレーショナルデータベースの溝を埋めることを目的としています。     
現実世界に即したオブジェクト指向という考え方と、数学的なアプローチから正規化をベースとして、    
検索や登録に最適化されたリレーショナルデータベース。この両者の溝は、Java プログラマに余計なソースコードを書かせてきました。   
Hibernate を利用することで、Java プログラマの負担が飛躍的に軽減されるのです。 
そのHibernateについて解説していきます。

- [Hibernate](http://www.techscore.com/tech/Java/Others/Hibernate/index/) - Hibernate説明


#### RxJava

RxJavaとはリアクティブプログラミングを行うためのライブラリであるRx(Reactive Extensions)のJVM版とのこと。     

- [RxJava](http://gank.io/post/560e15be2dca930e00da1083) - RxJava説明(中国語)   
 


#### クロージャ closure

クロージャ（クロージャー、英: closure）、関数閉包はプログラミング言語における関数オブジェクトの一種。    
いくつかの言語ではラムダ式や無名関数で実現している。   

~~~
Sample1
function outer() {

    var x = 10;

    function inner() {
        alert(x)
        x = x + 1
    }

    return inner;
}   
~~~

## JS 関連

#### Redux

* Reduxとは
Reduxは、ReactJSが扱うUIのstate(状態)を管理をするためのフレームワークです。    
Reactではstateの管理するデータフローにFluxを提案していますが、   
ReduxはFluxの概念を拡張してより扱いやすく設計されています。      
Reduxはstateを管理するためのライブラリーなので、                 
React以外にもAngularJSやjQueryなどと併せて使用することもできますが、       
Reactと使用するのが一番相性がいいです。


- [Redux入門](http://qiita.com/kiita312/items/49a1f03445b19cf407b7) - Redux入門【ダイジェスト版】10分で理解する

## AWS IoT 関連

- [AWS IoT](http://codezine.jp/article/detail/9530) - AWS IoTとRaspberry PiではじめるIoT超入門


