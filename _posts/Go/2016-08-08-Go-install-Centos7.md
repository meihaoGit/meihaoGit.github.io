---
layout: post
title:  "Go 開発"
date:   2016-08-08
category: Go
tags: [Go]
---

### Go 開発



##### インストール


- [Go ダウンロード](https://golang.org/dl/) - 最新のバージョンのファイルのURLを確認し、ダウンロード

- ファイルダウンロード

~~~
$ sudo wget https://storage.googleapis.com/golang/go1.6.3.linux-amd64.tar.gz
~~~

-  ファイル解凍

~~~
$ sudo tar -C /usr/local -xzf go1.6.3.linux-amd64.tar.gz
~~~

-  PATHの設定

~~~
PATHを追加
$ vim ~/.bash_profile 

~~~

-  追記

~~~
  export PATH=$PATH:/usr/local/go/bin
~~~

-  反映

~~~
$ source ~/.bash_profile 
~~~

#####  動作確認
- チュートリアルにある、HelloWorldを動かしてみる。

-  hello.go

~~~
package main

import "fmt"

func main() {
    fmt.Printf("hello, world\n")
}

~~~

-  実行

~~~
$ go run hello.go
hello, world

~~~

-  go runでは実行形式ファイルは残らないが、go buildを実行すると実行形式のファイルが生成される。
-  実行形式ファイル生成

~~~
$ go build hello.go 
~~~
-  実行

~~~
$ ./hello
hello, world
~~~