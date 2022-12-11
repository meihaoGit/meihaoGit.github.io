---
layout: post
title:  "$ git Command "
date:   2016-07-29
category: $ git
tags: [$ git]
---

## $ git使用資料

- [$ git doc](https://$ git-scm.com/book/ja/v2)

## $ git インストール方法

- Centos7    

~~~
$ yum -y install wget gcc   

$ yum -y install curl-devel expat-devel gettext-devel openssl-devel zlib-devel perl-ExtUtils-MakeMake   

$ yum -y $ git   

~~~

- ソースからアップデート方法   

- [$ git](https://$ git-scm.com/downloads) - $ git  

~~~
$ cd /usr/local/src/
$ git clone https://$ github.com/$ git/$ git
$ cd $ git
$ make prefix=/usr/local all
$ make prefix=/usr/local install
$ git --version

~~~

## $ git 常に使用命令   

##### $ git Command 

- $ git初期化   

- ※ リポジトリ化する   

~~~
$ git init
~~~

~~~
$ vi .$ git/config  
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
$ git remote add origin $ git@$ github.com:ユーザ名/リポジトリ名.$ git
~~~

- ※ リポジトリ（ディレクトリ）ごとにauthorを登録したいとき  

~~~
$ git config user.name "Your Name"
$ git config user.email "you@example.com"
~~~

- ※ 試しに$ git branchしてみると何も出てきません    

~~~
$ git branch
~~~

- ※ $ git statusはこのタイミングでディレクトリにあるファイルがすべて差分として表示されます   

~~~
$ git status  

$ git fetch    

$ git pull origin master   

$ git branch     
~~~

- ※  developブランチの作成  

~~~
$ git checkout -b <名前>  develop
$ git push origin <名前>  develop
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

- .$ git/objects のファイルサイズ

~~~
$ du -sh .$ git/objects
  6.4M    .$ git/objects   
  
~~~

- * ※  $ git proxyの設定    

~~~       
$ git config --global http.proxy http://proxy.example.com:8080
$ git config --global https.proxy http://proxy.example.com:8080
~~~       

## $ git SSH key生成

- SSH 公開鍵の作成

- [SSH key](https://help.$ github.com/articles/generating-an-ssh-key/) - SSH key

github 公開鍵の作成

```sh    
$ ssh-keygen -t rsa

$ cat ~/.ssh/id_rsa.pub
```
gitlab 公開鍵の作成

```sh 
ssh-keygen -t ed25519  -C "test@mail.com " -f ~/.ssh/id_ed25519
```

 
## $ gitローカルからリモートリポジトリへ反映

- 作業場所:ローカル


```sh
$ git init    
$ git add .    
$ git commit -m "init workspace " 
```    

- $ githubでリモートリポジトリを作成する    
    リモートリポジトリのSSHをcopyする     
 
-リモートリポジトリへ反映

```sh
$ git remote add origin [リモートリポジトリのSSHのcopy]    
$ git push --set-upstream origin master    
```


-error: the requested upstream branch 'origin/origin' does not exist    

```sh
$ git fetch &&  git merge origin/master     

$ git merge origin/master  --allow-unrelated-histories    

$ git branch --set-upstream-to=origin/master master    

$ git push --set-upstream origin master   

$ git rm -r --cached 外したいフォルダ名   
```

```sh
# 1) コンフり起こしてるファイルを一時退避
$ git stash```
# 2) 退避したコミットしていないものが表示されるのでpullする
$ git pull origin master```
# 3) スタッシュを戻す
  git stash pop
```


