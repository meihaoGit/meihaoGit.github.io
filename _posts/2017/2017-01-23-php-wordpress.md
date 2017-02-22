---
layout: post
title:  "WordPress開発環境構築"
date:   2017-01-23
category: WordPress
tags: [WordPress]
---

## 事前インストール必要

- OS : Win7
       XOS

- [vagrant](https://www.vagrantup.com/) - vagrant

- [VirtualBox](https://www.virtualbox.org/wiki/Downloads) - VirtualBox

- [vagrantbox](http://www.vagrantbox.es/) - vagrantbox

- [SSH接続ツール](https://osdn.jp/projects/ttssh2/releases/) - windowsOS必要


## 参考サイト

- [PHPとMySQLとApacheをインストール](https://adan.jp.net/blog/program/1235) - PHPとMySQLとApacheをインストール

## 詳細手順

~~~ 
$ yum install epel-release
~~~ 

- Apache の設定

~~~

# vi /etc/httpd/conf/httpd.conf
DocumentRoot "/var/www/blog.rnita.me"       # WordPress のディレクトリ
<Directory "/var/www/blog.rnita.me">        # DocumentRoot と同じディレクトリ
    AllowOverride All                       # .htaccess によるディレクティブの上書きを許可


<Directory "/home/phpuser/wordpress">
    AllowOverride All
</Directory>

$ chmod 711 /home/phpuser/

~~~

- userdir設定ファイル編集

~~~
# vi /etc/httpd/conf.d/wordpress.conf　←　userdir設定ファイル編集
<IfModule mod_userdir.c>
    #
    # UserDir is disabled by default since it can confirm the presence
    # of a username on the system (depending on home directory
    # permissions).
    #
    #UserDir disable　←　#を追加(コメントアウト)

    #
    # To enable requests to /~user/ to serve the user's public_html
    # directory, remove the "UserDir disable" line above, and uncomment
    # the following line instead:
    #
    UserDir public_html　←　行頭の#を削除(コメント解除)
    AliasMatch ^/centos(.*) /home/centos/public_html/$1
　←　centosユーザーのみhttp://centossrv.com/centos/のように~(チルダ)なしでアクセスできるようにする
    AliasMatch ^/userdir/([^/]+)/(.*) /home/$1/public_html/$2
　←　全てのユーザーでhttp://centossrv.com/userdir/ユーザー名/でアクセスできるようにする
</IfModule>

<Directory "/home/*/public_html">
    AllowOverride All　←　.htaccessの許可
    Options IncludesNoExec ExecCGI FollowSymLinks　←　CGI,SSI(Exec命令以外)の許可
    Require method GET POST OPTIONS
</Directory>

~~~



* PHP7をインストール

~~~
$ sudo rpm -Uvh http://rpms.famillecollet.com/enterprise/remi-release-7.rpm

$ sudo yum --enablerepo=remi-php70 -y install php php-cli php-devel php-common php-mbstring php-mysql php-phpunit-PHPUnit php-pecl-xdebug php-fpm php-gd php-gmp php-mcrypt php-opcache php-pdo php-xml

$ php --version

PHP 7.0.15 (cli) (built: Jan 17 2017 17:10:58) ( NTS )
Copyright (c) 1997-2017 The PHP Group
Zend Engine v3.0.0, Copyright (c) 1998-2017 Zend Technologies

$vi /etc/php.ini

~~~

* 日本語WordPressパッケージをダウンロード

~~~
$ cd ~

$ wget http://ja.wordpress.org/latest-ja.tar.gz

$ tar -xzvf latest-ja.tar.gz 

$  cd ~/wordpress
$  cp wp-config-sample.php wp-config.php
$  vi wp-config.php

/** WordPress のためのデータベース名 */
define('DB_NAME', 'wordpressdb');

/** MySQL データベースのユーザー名 */
define('DB_USER', 'wordpress');

/** MySQL データベースのパスワード */
define('DB_PASSWORD', 'Myphpwp7.7');

/** MySQL のホスト名 */
define('DB_HOST', 'localhost');

~~~ 
* MysqlのWordPressユーザを追加

~~~
Mysql>create database wordpressdb;
Mysql>CREATE USER wordpress IDENTIFIED BY 'Myphpwp7.7';
Mysql>CREATE USER 'wordpress'@'192.168.33.%' IDENTIFIED BY 'Myphpwp7.7';
Mysql>CREATE USER 'wordpress'@'localhost' IDENTIFIED BY 'Myphpwp7.7';

Mysql>grant all on wordpressdb.* to 'wordpress'@'localhost' identified by 'Myphpwp7.7';


Mysql>SHOW GRANTS FOR 'wordpress'@'192.168.33.%';

Mysql>mysql -uwordpress -pMyphpwp7.7 -Dwordpressdb


データベース名 : wordpressdb
ユーザー名     : wordpress
パスワード     : Myphpwp7.7
ホスト名       : localhost


~~~ 
* 権限変更

~~~
$ su
# chown -R phpuser:phpuser html

# ln -fs ~/wordpress/ /var/www/html/

# chown -R phpuser:phpuser wordpress

# chown apache:apache /var/www/html/wordpress

$ chmod -R 777 wp-content

~~~

## 起動後の設定

- [WordPress の使い方](http://cms.thingslabo.com/manual/wordpress/) - WordPress の使い方


## nginxのインストール

~~~   
$ sudo rpm -ivh http://nginx.org/packages/centos/7/noarch/RPMS/nginx-release-centos-7-0.el7.ngx.noarch.rpm
$ sudo yum -y update nginx-release-centos
$ sudo yum -y --enablerepo=nginx install nginx
$ nginx -v
nginx version: nginx/1.8.1

~~~   

## 備忘

- centos7のapacheの設定

~~~ 
# vi /etc/httpd/conf.d

~~~ 

- epelの無効設定は、設定ファイルを開いて
  [epel]の部分のenable=1を、enable=0 書き換えてるのみです。
  
~~~ 
# vi /etc/yum.repos.d/epel.repo   

~~~ 

-  remiの場合は、下記
 [remi]の部分のenable=1を、enable=0 書き換えてるのみです。
 
~~~ 
# vi /etc/yum.repos.d/remi.repo

~~~ 
- PHPテスト

~~~ 
$ cd /var/www/html/

$ echo '<?php echo phpinfo(); ?>' > index.php

~~~ 
- [綺麗なフォントベース](http://a1-style.net/wordpress/create-siteicon-favicon/) - 綺麗なフォントベース


## TODO

- [docker-compose WordPress](https://tech.recruit-mp.co.jp/infrastructure/post-11266/) - docker-compose WordPress
