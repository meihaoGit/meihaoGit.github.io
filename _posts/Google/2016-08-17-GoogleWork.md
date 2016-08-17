---
layout: post
title:  "Google Apps for Work 環境作成"
date:   2016-08-17
category: Google
tags: [Google]
---

## Google 関連サービス勉強
   
## Google Cloud Platform（GCP）

- GCPはGoogleが提供するIaaSであり、Amazonの提供するAWSに相当しますが、<br>
  Googleが自社インフラとしてのクラウド環境
  
  https://console.cloud.google.com/home/
  
## ruby 環境作成

- 必要なパッケージのインストール

~~~

# yum -y install gcc-c++ glibc-headers openssl-devel readline libyaml-devel readline-devel zlib 
# yum -y install curl-devel expat-devel gettext-devel zlib-devel perl-ExtUtils-MakeMaker bzip2  sqlite-devel
# yum -y install wget
~~~~


- gitインストール

~~~
$ wget https://www.kernel.org/pub/software/scm/git/git-2.9.0.tar.gz
$ tar zxvf git-2.9.0.tar.gz

$ cd git-2.9.0

$ make prefix=/usr/local all
$ make prefix=/usr/local install
$ git --version
git version 2.9.0
~~~

- rbenvインストール

~~~
$ git clone https://github.com/rbenv/rbenv.git ~/.rbenv
$ echo 'export PATH="$HOME/.rbenv/bin:$PATH"' >> ~/.bash_profile
$ ~/.rbenv/bin/rbenv init 
<br>
echo 'eval "$(rbenv init -)"' >> /etc/profile

$ rbenv --version

を実行して、バージョンの確認をする   
~~~

- ruby-buildインストール

~~~
$ git clone https://github.com/rbenv/ruby-build.git ~/.rbenv/plugins/ruby-build  

~~~

-  rubyインストール

~~~
rbenvでインストールできるRubyのバージョン一覧確認
$ rbenv install -l
Rubyのバージョンを指定してインストール
$ rbenv install -v 2.3.1
$ rbenv rehash
使用するRubyのバージョンを指定
$ rbenv global 2.3.1
バージョンを確認する
$ ruby -v
~~~

-  Railsインストール

~~~
$ gem update --system
$ gem install --no-ri --no-rdoc rails
$ gem install sqlite3 -v '1.3.11'
$ gem install bundler
$ rbenv rehash

バージョンを確認する
rails -v

