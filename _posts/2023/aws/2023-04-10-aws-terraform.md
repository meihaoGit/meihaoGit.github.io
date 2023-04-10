---
layout: post
title:  "2023 aws terraform"
date:   2023-04-10
category: aws-terraform
tags: [aws-terraform]
---


## terraform

```sh
alias tf="terraform"
alias tfp="terraform plan"
alias tfv="terraform validate"
alias tff="terraform fmt -recursive"
alias tfd="terraform destroy"
```

### 準備作業

##### Spring BootアプリケーションをGradleでビルドして、Dockerイメージを作成する手順は以下の通りです。

- 1.  Dockerfileの作成

-  まず、Dockerfileを作成します。以下は、Spring BootアプリケーションをDockerイメージにパッケージするための基本的なDockerfileです。


```sh
FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

1.  Spring Bootアプリケーションのビルド

次に、Gradleを使用してSpring Bootアプリケーションをビルドします。以下は、Gradleでビルドするためのコマンドです。

bash

```sh
./gradlew build
```

3.  Dockerイメージのビルド

次に、Dockerイメージをビルドします。以下は、Dockerイメージをビルドするためのコマンドです。

bash

```sh
docker build -t <イメージ名> .
```

`<イメージ名>`には、作成するDockerイメージの名前を指定します。最後の`.`は、Dockerfileがあるカレントディレクトリを指します。

4.  Dockerイメージの実行

最後に、作成したDockerイメージを実行します。以下は、Dockerイメージを実行するためのコマンドです。

arduino

```arduino
docker run -p 8080:8080 <イメージ名>
```

`-p`オプションで、Dockerコンテナのポートとホストのポートをマッピングします。`<イメージ名>`には、実行するDockerイメージの名前を指定します。

以上が、Spring BootアプリケーションをGradleでビルドして、Dockerイメージを作成する手順です。

