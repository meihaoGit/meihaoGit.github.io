---
layout: post
title:  "RESTfulなjsonAPIサーバ"
date:   2016-08-09
category: REST
tags: [REST]
---

### RESTfulなAPIサーバ

## RESTfulAPIとは

まずはじめに，RESTとは，平たく言ってしまえばWebの設計思想の一つです．    <br>
RESTfulとは，RESTの設計思想に則ったモノというニュアンスで良いでしょう．<br>
つまり，RESTfulAPIとは，RESTの設計思想に基づいたAPIという意味合いになります．<br>

##### RESTの原則とは

    この辺りの設計思想は人によって微妙に差異がありますので，あくまで軽く触れる程度にしておきます．   
    1. ステートレスなクライアント/サーバプロトコル．
    2. 明示的にHTTPメソッドを用いる．
    3. 処理結果はHTTPステータスコードで返す．  
    4. 直感的に理解できる,ディレクトリ構造に似たURLで公開する．   

    より詳細に知りたい方は以下を参照すると良いでしょう．    
    
    
*  一般的なMEANスタックと呼ばれるものと殆ど差異が無いと思います．

【原則1】アドレス可能な「リソース」
【原則2】統一インタフェース
【原則3】表現指向とハイパーメディア
【原則4】ステートレスな通信

> M：MongoDB（ドキュメント指向データベース）    <br>
> E：Express（Node.js上で動作するMVCフレームワーク）         <br>
> A：AngularJS（フロントエンドのJavaScript用MVWフレームワーク）         <br>
> N：Node.js（サーバーサイドJavaScriptの実行環境）     <br>

##  APIのリファレンス

| Route               | HTTP Verb |  Description                             |
|:--------------------|:---------:|:----------------------------------------:|
| /api                |  GET      |  テストメッセージをPOSTする．            |
| /api/users          |  POST     |  ユーザを作成する                        |
| /api/users          |  GET      |  全てのユーザ情報を取得する．            |
| /api/users/:user_id |  GET      |  UserIDに一致するユーザ情報を取得する．  |
| /api/users/:user_id |  PUT      |  UserIDに一致するユーザ情報を更新する．  |
| /api/users/:user_id |  DELETE   |  UserIDに一致するユーザ情報を削除する．  |


##  ディレクトリ構成

~~~
$ tree .
jsonAPI
├── server.js
├── package.json
├── app
│   └── models
│       └──user.js
└── node_module    

~~~

- package.jsonの作成

~~~
$ npm init

package.json
{
    "name": "jsonAPI",
    "main": "server.js",
    "dependencies": {
        "express": "~4.0.0",
        "mongoose": "~3.6.13",
        "body-parser": "~1.0.1"
    }
}
~~~


-  "超"簡単なapiサーバの作成


~~~
server.js
// server.js

// 必要なパッケージの読み込み
var express    = require('express');
var app        = express();
var bodyParser = require('body-parser');

// POSTでdataを受け取るための記述
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

// 3000番を指定
var port = process.env.PORT || 3000;

// expressでAPIサーバを使うための準備
var router = express.Router();

router.use(function(req, res, next) {
    console.log('Something is happening.');
    next();
});

// 正しく実行出来るか左記にアクセスしてテストする (GET http://localhost:3000/api)
router.get('/', function(req, res) {
    res.json({ message: 'Successfully Posted a test message.' });
});


// ルーティング登録
app.use('/api', router);

//サーバ起動
app.listen(port);
console.log('listen on port ' + port);
~~~

- サーバを起動
~~~
$ node server.js
~~~

Jersey Client API : Java でWeb API Client を作成する方法

- [Jersey Client API : Java でWeb API Client を作成する方法](http://www.techscore.com/blog/2016/09/20/jersey-client-api/) - Java でWeb API Client を作成する方法

- [jersey](https://jersey.java.net/) - jersey java

- [REST (Representational State Transfer)](https://www.ibm.com/developerworks/jp/webservices/library/ws-restful/) - RESTful Web サービスの基本

- [RESTの基礎知識](http://www.atmarkit.co.jp/ait/articles/1604/18/news020.html) - RESTful Web JAX-RS

    JAX-RSは、RESTに準拠したWebサービスを作るためのJava EEの仕様
    JAX-RS（Java API for RESTful Web Services）
    
|従業員の操作 | メソッド | URI                               | レスポンスの表現形式   | 
|:------------|:--------:|:---------------------------------:|-----------------------:| 
|検索         | GET      | /crudsample/employees?name={name} | JSON、XML              | 
|取得         | GET      | /crudsample/employees/{ID}        | JSON、XML              | 
|登録         | POST     | /crudsample/employees             | JSON、XML              | 
|更新         | PUT      | /crudsample/employees/{ID}        | なし                   | 
|削除         | DELETE   | /crudsample/employees/{ID}        | なし                   | 


- [マイクロサービスアーキテクチャ](http://qiita.com/kawasima/items/356d54e253c54d730fb0) - マイクロサービス

- [REST簡単紹介](http://www.cnblogs.com/loveis715/p/4669091.html#3505324) - [REST簡単紹介（中国語）

- [microservices](http://microservices.io/patterns/monolithic.html) - microservices English

- [RESTEasy](https://github.com/resteasy) - jboss RESTEasy

- [綺麗なAPI速習会](http://qiita.com/shimastripe/items/e9b0e1f8f8d77b89373f) - 綺麗なAPI速習会

