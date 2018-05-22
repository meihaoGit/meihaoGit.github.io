---
layout: post
title:  "2018 AWS連携OpenData開発"
date:   2018-04-25
category: base
tags: [base]
---

## 参考資料

- [AWS 勉強資料](https://qiita.com/hiroshik1985/items/6433d5de97ac55fedfde) - 勉強資料

- [AWS活用資料集](https://aws.amazon.com/jp/aws-jp-introduction/) - AWS活用資料集

- [AWS資料作成](https://cacoo.com/ja/) - AWS資料作成ツール

- [AWS試験関連](https://aws.koiwaclub.com/) - AWS試験関連

- [AWS環境構築](https://qiita.com/tiwu_official/items/220e00c9a18c6c8adb54#_reference-baf5c073462282e837ca) - AWS環境構築

- [AWS アーキテクチャセンター](https://aws.amazon.com/jp/architecture/) - AWS アーキテクチャセンター

- [政府統計の総合窓口](https://github.com/e-stat-api/js-app) - 政府統計の総合窓口

- [オープンデータ関連情報](http://www.data.go.jp/for-developer/) - オープンデータ関連情報


## 開発環境

~~~
Python 3.7
https://docs.python.org/ja/3.7/download.html

Echats
https://github.com/apache/incubator-echarts
https://github.com/ecomfe/echarts-examples

AWSサビース
~~~

## 設計関連資料




メタデータの末尾にスキップ
作成者 fotome-tomohiro.ito、最終変更日5 10, 2018 メタデータの先頭に移動
Golangの開発環境をローカルPCに構築する手順を記載する

VM準備
下記リポジトリの手順に従ってvagrant環境を構築する

https://github.kddi-cf.com/wowma/dmp-vagrant

Windows環境へ導入する場合は、Vagrantfileの内容を下記のように修正すると動作する

Vagrant.configure(2) do |config|
config.vm.box = "https://storage.googleapis.com/dmp_image/CentOS-7.4-x86_64.box"
config.vm.hostname = "DMP-CentOS-7.4-x86-64"

config.vm.network "private_network", ip: "192.168.33.10"

config.proxy.http = "http://proxy.cf.internal:15080"
config.proxy.https = "http://proxy.cf.internal:15080"
config.proxy.no_proxy = "localhost,127.0.0.1"

config.vm.synced_folder "~/workspace/dmp-etl", "/dmp-etl/"

config.vm.provision "ansible_local" do |ansible| 
ansible.playbook = "DMP-vagrant.yml"
ansible.limit = "all"
ansible.verbose = "v"
end
end

vagrant upを実行する前に、下記コマンドでプラグインを導入しておく

vagrant plugin install vagrant-proxyconf
git設定
depツールがgithubにパスワード無しで接続できるようにVMを設定する

1.SSHキー登録
下記サイトの手順を参考にgithubにパスワード無しでログインできるようにする

http://monsat.hatenablog.com/entry/generating-ssh-keys-for-github

2.git設定変更
下記コマンドを実行して、depのgitクローンが適切に動作するように設定する

git config --global url.'git@github.kddi-cf.com:'.insteadOf https://github.kddi-cf.com/
depインストール
下記コマンドでdepをインストールする

go get -u github.com/golang/dep/cmd/dep
また、vagrantユーザの~/.bash_profileファイルに下記を追記する（もしかすると不要かも）

DEPNOLOCK=1
export DEPNOLOCK

Google Cloud SDKの導入
BigQuery等を利用するGoプログラムが動作するように、Google Cloud SDKを導入する

1.インストール
curl https://sdk.cloud.google.com | bash
2.認証キー登録
適切なGoogle Cloudの認証キー（JSONファイル）を取得し、VM内の任意のディレクトリに配置する。

配置後、そのパスをGOOGLE_APPLICATION_CREDENTIALS環境変数に設定する。

ログインユーザーに紐づくJSONキーの作成方法については下記ページを参照

https://github.kddi-cf.com/wowma/dmp-etl/tree/develop/src/etl