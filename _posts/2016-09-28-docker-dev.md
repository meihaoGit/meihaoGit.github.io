---
layout: post
title:  "docker開発環境構築"
date:   2016-09-28
category: docker
tags: [docker]
---

## 事前インストール必要

- OS : vagrant(Centos7)
       XOS
       
      ※proxy対応: vi /etc/sysconfig/docker


#### Vagrantツール参考

- [Vagrantツール](https://meihaogit.github.io/vagrant/2016/08/31/vagrant-dev.html) - vagrant開発環境構築

---

- TODO：

- [Dockerツール](http://paiza.hatenablog.com/entry/docker_intro) - 2016年版、Dockerのすべてが5分でわかる

#### PostgreSQL サービス起動

- [docker](https://hub.docker.com/_/postgres/) - docker PostgreSQL

    1. PostgreSQLイメージを取得
    
~~~    
$ docker pull postgres   

~~~    
    2. PostgreSQLイメージを実行
    
~~~    
$ docker run -d --name=postgres -p 5432:5432 -e POSTGRES_PASSWORD=mysecretpassword postgres 
    
~~~   
## docker コマンド
 
    1. コンテナ 操作
  
~~~ 
# コンテナの稼働状況
$ docker ps -a

# コンテナ 起動、停止
$ docker stop ｛コンテナー名｝|｛コンテナーID｝
$ docker start ｛コンテナー名｝|｛コンテナーID｝ 

# コンテナに接続する
$ docker attach｛コンテナー名｝|｛コンテナーID｝ 

# コンテナを削除する 
$ docker rm｛コンテナー名｝|｛コンテナーID｝ 

~~~    
    2. dockerイメージ操作

~~~    
# イメージの確認
$ docker images

# イメージを削除する．
docker rmi <IMAGE ID>

~~~    