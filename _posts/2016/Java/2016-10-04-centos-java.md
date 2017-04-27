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
          "tomcat/tomcat-9/v9.0.0.M20/bin/apache-tomcat-9.0.0.M10.tar.gz"  
$ tar -xzvf ~/apache-tomcat-9.0.0.M20.tar.gz
$cd apache-tomcat-9.0.0.M20
  $ mv ./* /usr/tomcat9
$ chown -R tomcat9. /usr/tomcat9

# 新規作成	
$ vi /usr/lib/systemd/system/tomcat9.service

# 新規作成
 [Unit]
Description=Apache Tomcat 9
After=network.target

[Service]
Type=oneshot
ExecStart=/usr/tomcat9/bin/startup.sh
ExecStop=/usr/tomcat9/bin/shutdown.sh
RemainAfterExit=yes
User=tomcat9
Group=tomcat9

[Install]
WantedBy=multi-user.target

# systemctl start tomcat9 
# systemctl enable tomcat9 

~~~  
## tomcat9 403 対応

~~~
$ cd /opt/tomcat/conf/Catalina/localhost/
$ vi manager.xml
<Context privileged="true" antiResourceLocking="false"
  docBase="${catalina.home}/webapps/manager">
<Valve className="org.apache.catalina.valves.RemoteAddrValve" allow="^.*$" />
</Context>

~~~

    3. ajpモジュールによる連携

      /etc/httpd/conf.d/proxy-ajp.confファイルを追加

下記の内容を記載

~~~    
<Location /docs/>
  ProxyPass ajp://127.0.0.1:8009/docs/
</Location>

~~~    

## apache ssl 対応

~~~ 
$ yum -y install mod_ssl
$ vi /etc/httpd/conf.d/ssl.conf

# 59行目：コメント解除
DocumentRoot "/var/www/html"

# 60行目：コメント解除しサーバー名指定
ServerName www.srv.world:443

# 75行目：変更
SSLProtocol -All +TLSv1 +TLSv1.1 +TLSv1.2

# 100行目：証明書指定
SSLCertificateFile /etc/pki/tls/certs/server.crt

# 107行目：鍵ファイル指定
SSLCertificateKeyFile /etc/pki/tls/certs/server.key
$ systemctl restart httpd 

$ cd /etc/pki/tls/certs 

$ make server.key 
umask 77 ; \
/usr/bin/openssl genrsa -aes128 2048 > server.key
Generating RSA private key, 2048 bit long modulus
...
...
e is 65537 (0x10001)
Enter pass phrase:     # パスフレーズ設定
Verifying - Enter pass phrase:     # 再入力

# 秘密鍵からパスフレーズを削除
$ openssl rsa -in server.key -out server.key 
Enter pass phrase for server.key:     # パスフレーズ入力
writing RSA key

$ make server.csr 
umask 77 ; \
/usr/bin/openssl req -utf8 -new -key server.key -out server.csr
You are about to be asked to enter information that will be incorporated
into your certificate request.
What you are about to enter is what is called a Distinguished Name or a DN.
There are quite a few fields but you can leave some blank
For some fields there will be a default value,
If you enter '.', the field will be left blank.
-----
Country Name (2 letter code) [XX]:JP     # 国
State or Province Name (full name) []:Hiroshima     # 地域（県）
Locality Name (eg, city) [Default City]:Hiroshima     # 都市
Organization Name (eg, company) [Default Company Ltd]:GTS     # 組織名
Organizational Unit Name (eg, section) []:Server World     # 組織の部門名
Common Name (eg, your name or your server's hostname) []:www.srv.world     #　IPアドレス
Email Address []:xxx@srv.world     # 管理者アドレス
Please enter the following 'extra' attributes
to be sent with your certificate request
A challenge password []:     # Enter
An optional company name []:     # Enter

# 有効期限が10年の自己署名証明書を作成
$ openssl x509 -in server.csr -out server.crt -req -signkey server.key -days 3650
Signature ok
subject=/C=JP/ST=Hiroshima/L=Hiroshima/O=GTS/OU=Server World/CN=www.srv.world/emailAddress=xxx@srv.world
Getting Private key

~~~ 

- [証明書を作る](https://meihaogit.github.io/ssl/2017/04/21/ssl.html) - 証明書を作る


## 備忘

~~~  
$ rpm -qa | grep mysql     

~~~  
