---
layout: post
title:  "vagrant開発環境構築"
date:   2016-08-31
category: vagrant
tags: [vagrant]
---

## 事前インストール必要

- OS : Win7
       XOS

- [vagrant](https://www.vagrantup.com/) - vagrant

- [VirtualBox](https://www.virtualbox.org/wiki/Downloads) - VirtualBox

- [vagrantbox](http://www.vagrantbox.es/) - vagrantbox

- [SSH接続ツール](https://osdn.jp/projects/ttssh2/releases/) - windowsOS必要


#### Vagrantツール初期化　開始

---

- vagrant　バージョン確認

C:\Tools\CentOS\centos7>vagrant -v  

Vagrant 1.7.2

    1. ボックスの追加   

~~~
vagrant box add centOS7 centos7.box   
~~~

    2. ボックスのリスト表示  

~~~
vagrant box list   
~~~

    3. ボックスの初期化   
     
~~~
vagrant init

~~~
    centos7.boxフォルダ直下に  
    .vagrant
     Vagrantfile
     を生成

    4. Vagrantfileファイルを下記箇所を修正   
    
~~~
 ① # config.vm.network "forwarded_port", guest: 80, host: 8080  
 ② # config.vm.network "private_network", ip: "192.168.33.10"   
 
コメントをはず       
~~~

※　①　apacheアクセスために使用→TCP 8080番ポートは別で修正できる
　　②　SSH接続使用　→必ず修正必要

   5. 立ち上げ
   
~~~
vagrant up       

~~~

- ※　下記のログを参考

~~~
Bringing machine 'default' up with 'virtualbox' provider...
==> default: Clearing any previously set network interfaces...
==> default: Preparing network interfaces based on configuration...
    default: Adapter 1: nat
    default: Adapter 2: hostonly
==> default: Forwarding ports...
    default: 80 => 8080 (adapter 1)
    default: 22 => 2222 (adapter 1)
==> default: Booting VM...
==> default: Waiting for machine to boot. This may take a few minutes...
    default: SSH address: 127.0.0.1:2222
    default: SSH username: vagrant
    default: SSH auth method: private key
    default: Warning: Connection timeout. Retrying...
    default: Warning: Connection timeout. Retrying...
    default: Warning: Connection timeout. Retrying...
    default: Warning: Connection timeout. Retrying...
    default: Warning: Remote connection disconnect. Retrying...
==> default: Machine booted and ready!
==> default: Checking for guest additions in VM...
==> default: Configuring and enabling network interfaces...
==> default: Mounting shared folders...
    default: /vagrant => C:/Tools/CentOS/centos7
Failed to mount folders in Linux guest. This is usually because
the "vboxsf" file system is not available. Please verify that
the guest additions are properly installed in the guest and
can work properly. The command attempted was:

mount -t vboxsf -o uid=`id -u vagrant`,gid=`getent group vagrant | cut -d: -f3`
vagrant /vagrant
mount -t vboxsf -o uid=`id -u vagrant`,gid=`id -g vagrant` vagrant /vagrant

The error output from the last command was:

/sbin/mount.vboxsf: mounting failed with the error: No such device

vboxadd setup を再実行

ゲストOS上で下記のコマンドを実行する。
$ sudo /etc/init.d/vboxadd setup
~~~


#### Vagrantツール初期化　完了

---


teratermツールを起動
初期ユーザ：vagrant、root
PS:vagrant

正常に接続完了
centos初期設定など別資料参考

* LAMP環境とは   

~~~
Linux、Apache、MySQL、PHPの環境でWebシステムを開発することを、それぞれの頭文字をとってLAMP環境と言います。
最近のWebシステムは、LAMP環境での開発が主流となっているため、LAMP環境で開発が出来るWebエンジニアの採用ニーズは非常に高まっています。
~~~

**************************************
削除：
vagrant box remove CentOS7
**************************************

vagrant ssh-config --host 192.168.33.11


コピーして持ってきたtemplateの中にscripts/vagrant.shというシェルスクリプトがある。
date > /etc/vagrant_box_build_time

mkdir -pm 700 /home/vagrant/.ssh
curl -L https://raw.github.com/mitchellh/vagrant/master/keys/vagrant.pub -o /home/vagrant/.ssh/authorized_keys
chmod 0600 /home/vagrant/.ssh/authorized_keys
chown -R vagrant:vagrant /home/vagrant/.ssh

vagrant ssh-config

ssh-keygen -yf xxxx/vagrant_private_key > public_key

## エラー解決

- vagrant package作成後

*****************************************************
【エラー】解決方法
「default: Warning: Authentication failure. Retrying...」
※　
①　
Typed 'vagrant ssh-config' in the console
②　
Made sure to halt by typing 'vagrant halt'
③　
C:\vagrant\.vagrant\machines\default\virtualbox
private_key　を削除
*****************************************************


PATH=$PATH:$HOME/bin

export PATH
export PATH="$HOME/.rbenv/bin:$PATH"
eval "$(rbenv init -)"

*****************************************************
CentOS (RHEL) にProxyの設定

# vi /etc/profile
# source /etc/profile
*****************************************************



## ボックスサイズの最小化

~~~

$ rm /root/.bash_history
$ yum clean all
$ rm -fr /var/log/*
$ rm -fr /tmp/*
$ dd if=/dev/zero of=/0 bs=4k
$ rm /0
$ history -c

~~~