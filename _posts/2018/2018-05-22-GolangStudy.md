---
layout: post
title:  "Go 開発データ分析勉強"
date:   2018-05-22
category: go
tags: [go]
---

## 参考資料

 - [Restlet Client - REST API Testing](https://chrome.google.com/webstore/detail/restlet-client-rest-api-t/aejoelaoggembcahagimdiliamlcdmfm)  - Restlet Client - REST API Testing

## 開発環境

- Golangの開発環境をローカルPCに構築する手順  
    - VM準備  
      下記リポジトリの手順に従ってvagrant環境を構築する  
      Windows環境へ導入する場合は、Vagrantfileの内容を下記のように修正すると動作する

~~~ruby
Vagrant.configure(2) do |config|
    config.vm.box = "https://storage.googleapis.com/dmp_image/CentOS-7.4-x86_64.box"
    config.vm.hostname = "CentOS-7.4-x86-64"
    config.vm.network "private_network", ip: "192.168.33.10"

    config.vm.synced_folder "~/workspace/etl", "/etl/"

    config.vm.provision "ansible_local" do |ansible|
        ansible.playbook = "vagrant.yml"
        ansible.limit = "all"
        ansible.verbose = "v"
    end
end

~~~

- ATOM環境にGO開発環境

  `go get golang.org/x/tools/cmd/goimports`  
  `go get github.com/nsf/gocode`  
  `go get github.com/rogpeppe/godef`  
  `apm install go-plus`  
  `apm install godef`  

- git設定

- depツールがgithubにパスワード無しで接続できるようにVMを設定する

  SSHキー登録
下記サイトの手順を参考にgithubにパスワード無しでログインできるようにする

 - [SSHの公開鍵](http://monsat.hatenablog.com/entry/generating-ssh-keys-for-github)  

 - SSHの公開鍵を作成しGithubに登録する手順

 - git設定変更

下記コマンドを実行して、depのgitクローンが適切に動作するように設定する

`git config --global url.'git@github.com:'.insteadOf https://github.com/`

-  depインストール

下記コマンドでdepをインストールする

`go get -u github.com/golang/dep/cmd/dep`

- Google Cloud SDKの導入

~~~
- BigQuery等を利用するGoプログラムが動作するように、Google Cloud SDKを導入する

1.インストール

`curl https://sdk.cloud.google.com | bash`

2. 認証キー登録

~~~

## Go言語のWebフレームワーク

- [Beego](https://beego.me/) - 公式HP

## Goのコマンド

  `go env`→goのビルドに関係する環境変数を一覧表示  
  `go build`　ファイル名  
  `./index &`→バックグラウンドで実行  

## 設計関連資料
