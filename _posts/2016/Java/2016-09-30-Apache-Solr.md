---
layout: post
title:  "Apache SolrのSample"
date:   2016-09-30
category: Java
tags: [Java]
---

## Apache Solr

Apache solrはオープンソースの全文検索エンジンです。

## Solrの特徴

    1. とにかく速い ... 噂では7億ドキュメント(インデックスサイズ3.5TB)でも1秒以内に返ってくるらしい
    
    2. 分散インデックス、レプリケーションなどの機構を備える
    
    3. ファセット機能 
    
    4. 地理空間検索
    
## Solrのインストール

- [Solr](http://lucene.apache.org/solr/) - Apache Solr 

- [Solr download ](http://www.apache.org/dyn/closer.lua/lucene/solr/6.2.1) - Apache Solr download

## Solr コマンド   
   
    1.  Solrの起動

~~~   

$ solr start -e cloud -noprompt

~~~   

    2. Solrの停止

~~~
$ solr stop -all    

~~~
    3. 検索実例を作成

~~~  

$ solr create -c collection1

~~~

    4. 検索サンプルドキュメントを登録
       ※ example\exampledocs」フォルダに移動し、    
         core/collectionを指定してサンプルドキュメントを登録   

~~~
$ java -Dc=collection1 -jar post.jar *.xml       
~~~

###### Solrの管理画面にアクセスして確認

   - [default設定](http://localhost:8983/solr/)  - http://localhost

## Apache SolrのSampleプログラム実行

参考サイト：

- [Apache Solr](http://qiita.com/Siro/items/54dc2ea1860e07792c40) - Apache SolrのSample 