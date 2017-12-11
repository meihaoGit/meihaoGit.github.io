---
layout: post
title:  "Amazon Lexとは"
date:   2017-04-11
category: Amazon
tags: [Amazon]
---

## Amazon Lexとは

- [Amazon AI](https://aws.amazon.com/jp/amazon-ai/) - Amazon AI

- [Amazon Lex](https://aws.amazon.com/jp/lex/) - Amazon Lex

- [Amazon Lex料金](https://aws.amazon.com/jp/lex/pricing/) - Amazon Lex料金

- [チャットボットの対話設計](http://qiita.com/shiraco/items/eca5d0a6fc7fe6fb0f37) - チャットボットの対話設計
  ※ おすすめです、チャットボット関連サービスを紹介されています。
   
## 特徴

* Amazon Lex

      1  音声やテキストを使用した会話型インターフェイスをさまざまなアプリケーションに構築するためのサービス
      2  Alexaと同じ深層学習テクノロジー
      3  音声のテキスト変換に自動音声認識 (ASR)、テキストの意図認識に自然言語理解 (NLU)といった 深層学習機能によりリアルな会話を実現
      4  高度で自然な言語で会話できるボット (「チャットボット」) をすばやく簡単に開発
      5   AIやディープラーニングの知識不要のグラフィカルなインタフェースによる操作
      6   AWS Lambda、MobileHub、Amazon CloudWatch、Amazon Cognito や Amazon DynamoDBとの連携
      7  Facebook Messengerとの連携 (Slack と Twilio とは近日中に統合予定)
      8  完全マネージド型のサービス  
      9  自動的なスケール   
      10  従量課金
      11  2017年1月時点ではプレビュー
    
*  キーワード
    自動音声認識（Automatic Speech Recognition：ASR）
    自然言語理解（Natural Language Understanding：NLU）
    
## Amazon Lex内容

    Botボット
        Amazon Lex全体の構成要素です。
    Intent（意図）
        相手の会話から目的をくみ取ります。
    Utterance（発話）
        意図を導くための会話を行います。
    Slots
        ユーザがBotに対し返答する必要があるデータです。
    Prompt
        ユーザに対してデータを確認するための質問です。
    Fulfillment
        会話の結果からユーザの目的を解決するための動作を行います。
        現在Lambdaファンクションの利用に対応しております。

## 環境構築
   
- [Amazon本家説明](https://aws.amazon.com/jp/blogs/news/amazon-lex-build-conversational-voice-text-interfaces/) - Amazon本家説明

- [レビューが通ったので使ってみた](http://dev.classmethod.jp/cloud/aws/first-impression-of-amazon-lex/) - レビューが通ったので使ってみた
      
##  サンプル
- [Amazon Lex](https://github.com/awslabs/aws-lex-convo-bot-example) - Amazon Lex

## AWS認定
- [認定資格対応コース](https://www.trainocate.co.jp/reference/aws/certification/index.html) - 認定資格対応コース

- [AWS认证权威考经](http://www.jianshu.com/p/739ec17c16fa) - AWS认证权威考经

- [AWS認定資格](http://desert-snow.hatenadiary.jp/entry/2017/01/26/091558) - AWS認定資格

- [IBM解析微服务架构](https://www.ibm.com/developerworks/community/blogs/3302cc3b-074e-44da-90b1-5055f1dc0d9c/entry/%E8%A7%A3%E6%9E%90%E5%BE%AE%E6%9C%8D%E5%8A%A1%E6%9E%B6%E6%9E%84_%E4%B8%80_%E4%BB%80%E4%B9%88%E6%98%AF%E5%BE%AE%E6%9C%8D%E5%8A%A1?lang=en) - 解析微服务架构
