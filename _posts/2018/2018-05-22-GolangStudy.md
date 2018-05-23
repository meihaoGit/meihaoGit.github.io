---
layout: post
title:  "Go 開発データ分析勉強"
date:   2018-05-22
category: base
tags: [base]
---

## 参考資料




## 開発環境

- Golangの開発環境をローカルPCに構築する手順  
    - VM準備  
      下記リポジトリの手順に従ってvagrant環境を構築する  
~~~
Windows環境へ導入する場合は、Vagrantfileの内容を下記のように修正すると動作する

Vagrant.configure(2) do |config|
config.vm.box = "https://storage.googleapis.com/dmp_image/CentOS-7.4-x86_64.box"
config.vm.hostname = "DMP-CentOS-7.4-x86-64"

config.vm.network "private_network", ip: "192.168.33.10"

config.vm.synced_folder "~/workspace/dmp-etl", "/dmp-etl/"

config.vm.provision "ansible_local" do |ansible| 
ansible.playbook = "DMP-vagrant.yml"
ansible.limit = "all"
ansible.verbose = "v"
end
end

~~~

    - git設定
    
~~~
depツールがgithubにパスワード無しで接続できるようにVMを設定する

1.SSHキー登録
下記サイトの手順を参考にgithubにパスワード無しでログインできるようにする

~~~

- [SSHの公開鍵](http://monsat.hatenablog.com/entry/generating-ssh-keys-for-github) - SSHの公開鍵を作成しGithubに登録する手順  

~~~
2.git設定変更
下記コマンドを実行して、depのgitクローンが適切に動作するように設定する

$ git config --global url.'git@github.com:'.insteadOf https://github.com/

depインストール
下記コマンドでdepをインストールする

$ go get -u github.com/golang/dep/cmd/dep

また、vagrantユーザの~/.bash_profileファイルに下記を追記する（もしかすると不要かも）

DEPNOLOCK=1
export DEPNOLOCK

~~~

    - Google Cloud SDKの導入

~~~
BigQuery等を利用するGoプログラムが動作するように、Google Cloud SDKを導入する

1.インストール
curl https://sdk.cloud.google.com | bash

2.認証キー登録
適切なGoogle Cloudの認証キー（JSONファイル）を取得し、VM内の任意のディレクトリに配置する。

配置後、そのパスをGOOGLE_APPLICATION_CREDENTIALS環境変数に設定する。

ログインユーザーに紐づくJSONキーの作成方法について


~~~

## 設計関連資料


