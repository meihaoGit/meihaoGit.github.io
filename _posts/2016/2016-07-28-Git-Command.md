---
layout: post
title:  "Git Command "
date:   2016-07-29
category: Git
tags: [Git]
---

## Git インストール方法

- Centos7    

~~~
$ yum -y install wget gcc   

$ yum -y install curl-devel expat-devel gettext-devel openssl-devel zlib-devel perl-ExtUtils-MakeMake   

$ yum -y git   

~~~

- ソースからアップデート方法   

- [git](https://git-scm.com/downloads) - git  

~~~
$ git clone https://github.com/git/git

$ cd git
$ make prefix=/usr/local all
$ make prefix=/usr/local install

~~~

## Git 常に使用命令   

##### Git Command 

- git初期化   

- ※ リポジトリ化する   

~~~
$ git init
~~~

~~~
$ vi .git/config  
~~~

- 下記を修正    

~~~
[core]
  repositoryformatversion = 0  
  filemode = true    
  bare = false
  logallrefupdates = true
  ignorecase = true
  precomposeunicode = true
~~~

##### リポジトリ情報追加  

~~~
$ git remote add origin git@github.com:ユーザ名/リポジトリ名.git
~~~

- ※ リポジトリ（ディレクトリ）ごとにauthorを登録したいとき  

~~~
$ git config user.name "Your Name"
$ git config user.email "you@example.com"
~~~

- ※ 試しにgit branchしてみると何も出てきません    

~~~
$ git branch
~~~

- ※ git statusはこのタイミングでディレクトリにあるファイルがすべて差分として表示されます   

~~~
$ git status  

$ git fetch    

$ git pull origin master   

$ git branch     
~~~

- ※  developブランチの作成  

~~~
git checkout -b <名前>  develop
git push origin <名前>  develop
~~~

- ※ 適当なブランチを切る

- ※ カラのcommitをしてpull req出す

~~~
$ git commit --allow-empty -m 'created PR'
$ git push -u origin master
~~~

-  ガベージコレクション（英語: garbage collection; GC）とは、プログラムが動的に確保したメモリ領域    

~~~
$ git gc --auto
~~~

- .git/objects のファイルサイズ

~~~
$ du -sh .git/objects
  6.4M    .git/objects   
  
~~~

- * ※  Git proxyの設定    

~~~       
$ git config --global http.proxy http://proxy.example.com:8080
$ git config --global https.proxy http://proxy.example.com:8080
~~~       

## Git SSH key生成

- SSH 公開鍵の作成

- [SSH key](https://help.github.com/articles/generating-an-ssh-key/) - SSH key

~~~     
$ ssh-keygen

$ cat ~/.ssh/id_rsa.pub

~~~     
