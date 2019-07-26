---
layout: post
title:  "2018 AWS連携OpenData開発"
date:   2018-04-25
category: base
tags: [base]
---

## 参考資料

- [政府統計の総合窓口](https://github.com/e-stat-api/js-app) - 政府統計の総合窓口

- [オープンデータ関連情報](http://www.data.go.jp/for-developer/) - オープンデータ関連情報

- [IBM勉強資料](http://www.data.go.jp/for-developer/https://www.ibm.com/developerworks/cn/opensource/os-beginners-guide-python/index.html) - IBM勉強資料


## 開発環境

~~~
Python 3.7
https://docs.python.org/ja/3.7/download.html

Echats
https://github.com/apache/incubator-echarts
https://github.com/ecomfe/echarts-examples

AWSサビース
~~~

## 設計関連資料


## 日本語  

- *クローラ（Crawler）*

https://www.kawabangga.com/posts/2835

## python with open
- 読み込みモードの種類:

~~~    
"r", "rb", "r+", "rb+", "w", "wb", "w+", "wb+", "a", "ab","a+", "ab+"
r:読み込み, w:書き込み, ファイルを開いた直後のポインタの位置はファイルの先頭。
a:追加書き込み, ファイルを開いた直後のポインタの位置はファイルの末尾。
ただしw,aでは、ファイルが存在しない場合、新たなファイルを作成。ポインタはファイルの先頭。
b:バイナリファイルとして入出力, +:読み書き両用モード
~~~

- [Python JavaのソースコードをAST（Abstract Syntax Tree：抽象構文木）で構文解析](https://qiita.com/5zm/items/6e717f5f7e14f09c4007)
