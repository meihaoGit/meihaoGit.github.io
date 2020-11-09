---
layout: post
title:  "2020 Docker Centos8"
date:   2020-03-11
category: docker
tags: [docker]
---

## 参考資料

- [Centos8](https://www.webtech.co.jp/blog/optpix_labs/13181/) - macOS Catalinaにおけるアプリの「公証(Notarization)」への対応方法

## docker 基礎

~~~sh
$ docker pull centos:8
$ docker image list
$ docker run --name centos8 --privileged -d centos:8 /sbin/init
$ docker ps -a
   コンテナID表示
$ docker exec -it コンテナID /bin/bash
$ docker images
~~~

## 自分用
