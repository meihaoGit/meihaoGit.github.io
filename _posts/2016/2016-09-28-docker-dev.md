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

- [CentOS7にdockerをインストール](http://qiita.com/maimai-swap/items/00590b96888330aa54f1) - CentOS7にdocker

## CentOS7にdockerをインストール
    
    - docker community editionのレポジトリを追加
    ~~~
    # yum-config-manager \
      --add-repo \
      https://download.docker.com/linux/centos/docker-ce.repo
      
    ~~~
    
    - docker community editionのレポジトリを常にenableにしておくときは、以下もやる。
    
    ~~~
    # yum-config-manager --enable docker-ce-edge

    # vi  /etc/yum.repos.d/docker-ce.repo
         [docker-ce-edge]
         name=Docker CE Edge - $basearch
         baseurl=https://download.docker.com/linux/centos/7/$basearch/edge
         enabled=0 # offにする
         gpgcheck=1
         gpgkey=https://download.docker.com/linux/centos/gpg
         
    ~~~
    - docker-ceをインストール
    ~~~
    # yum -y install docker-ce
    ~~~
    - docker-composeのインストール
    
    ~~~
    $ curl -L "https://github.com/docker/compose/releases/download/1.8.1/docker-compose-$(uname -s)-$(uname -m)" > docker-compose

    $ sudo mv docker-compose /usr/bin/
    $ sudo chmod +x /usr/bin/docker-compose
    ~~~

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

    3. docker基本命令
    
    
| コンテナを立ち上げ | docker run オプション --name コンテナ名　イメージ名  | 
| コンテナ一覧を表示 | docker ps -a                                         | 
| イメージ一覧を表示 | docker images                                        | 
| コンテナを起動 | docker start コンテナ名                                  | 
| コンテナを停止 | docker stop コンテナ名                                   | 
| コンテナを削除 | docker rm コンテナ名                                     | 
| イメージを削除 | docker rmi イメージ名                                    | 


|-d | コンテナをバックグラウンドで起動                                            | 
|-p | 「Mac側ポート番号:コンテナ側ポート番号」のようにポートマッピングを指定      | 
|-v | 「Mac側ディレクトリ:コンテナ側ディレクトリ」のように共有ディレクトリを指定  | 
|-i | STDINを常に開く                                                             | 
|-t | ttyを割り当てる                                                             | 

    4. docker SSH接続できる起動   
    
docker run -d -p 22 <username>/ssh:centos7
docker run -d -p 22 root/ssh:centos7

## 参考

- [Docker Ruby on Rails](http://uxmilk.jp/33604) - Docker Ruby on Rails

- [Docker 日本語化](http://docs.docker.jp/) - Docker 日本語化


## win10 docker proxyの設定    

~~~
$docker-machine ssh

docker@boot2docker:~$ sudo vi /var/lib/boot2docker/profile 

     export HTTP_PROXY=http://your.proxy.name:8080
     export HTTPS_PROXY=http://your.proxy.name:8080

docker@boot2docker:~$ sudo /etc/init.d/docker restart    
~~~

## 参考

- [docker-rails-mysql](https://github.com/okisanjp/docker-rails-mysql) - docker-rails-mysql

~~~
$ sudo docker-compose up

~~~

