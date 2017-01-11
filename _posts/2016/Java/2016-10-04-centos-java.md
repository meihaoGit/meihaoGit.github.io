---
layout: post
title:  "Centos7環境JAVA開発"
date:   2016-10-04 
category: Java
tags: [Java]
---

## JAVA ダウンロードとインストール

    1. ダウンロード

~~~
$ curl -LO -H "Cookie: oraclelicense=accept-securebackup-cookie" \
"http://download.oracle.com/otn-pub/java/jdk/8u102-b14/jdk-8u102-linux-x64.rpm"    

~~~
    2. インストール

~~~
$ sudo yum localinstall jdk-8u102-linux-x64.rpm 
   
$ sudo alternatives --config java

~~~
    3. 環境変数

~~~
$ vi /etc/profile
export JAVA_HOME=/usr/java/default
export PATH=$PATH:$JAVA_HOME/bin
export CLASSPATH=.:$JAVA_HOME/jre/lib:$JAVA_HOME/lib:$JAVA_HOME/lib/tools.jar

$ source /etc/profile

~~~

## apache-tomcat ダウンロード

    1. Apacheのインストール

~~~
$ yum -y install httpd

$ systemctl enable httpd.service
$ systemctl start httpd.service

~~~

    2. tomcatのインストール

~~~   

$ useradd -s /sbin/nologin tomcat

~~~      

- [apache-tomcat](http://tomcat.apache.org/download-90.cgi) - apache-tomcat-9

~~~  
$ cd ~/download
$ curl -O "http://ftp.tsukuba.wide.ad.jp/software/apache/" \
          "tomcat/tomcat-9/v9.0.0.M10/bin/apache-tomcat-9.0.0.M10.tar.gz"  
$ tar -xzvf ~/apache-tomcat-9.0.0.M10.tar.gz
$ mv ~/apache-tomcat-9.0.0.M10.tar.gz /opt
$ ln -s /usr/lib/apache-tomcat-7.0.62/ /usr/lib/tomcat
$ chown -R tomcat:tomcat /opt/apache-tomcat-9.0.0.M10

# 新規作成	
$ vi /usr/lib/systemd/system/tomcat.service

 [Unit]
Description=Apache Tomcat
After=network.target

[Service]
Type=oneshot
ExecStart=/opt/tomcat/bin/startup.sh
ExecStop=/opt/tomcat/bin/shutdown.sh
RemainAfterExit=yes
User=tomcat
Group=tomcat

[Install]
WantedBy=multi-user.target

$ systemctl start tomcat
$ systemctl enable tomcat

~~~  

    3. ajpモジュールによる連携

      /etc/httpd/conf.d/proxy-ajp.confファイルを追加

下記の内容を記載

~~~    
<Location /docs/>
  ProxyPass ajp://127.0.0.1:8009/docs/
</Location>

~~~    

## 備忘

~~~  
$ rpm -qa | grep mysql     

~~~  
