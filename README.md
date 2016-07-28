### HouseManagerApp
===============

##### Rails 勉強 baukis→bootstrap適用   
---

[twitter-bootstrap-rails][2]
[2]:https://github.com/seyhunak/twitter-bootstrap-rails
~~~
gem "twitter-bootstrap-rails"
~~~
- bootstrap 適用
~~~
rails g bootstrap:install static
rails g bootstrap:themed
~~~
----

Rails →　datetimepicker を使用    

~~~
gem 'momentjs-rails', '~> 2.11', '>= 2.11.1'
gem 'bootstrap3-datetimepicker-rails', '~> 4.17', '>= 4.17.37'
~~~

[bootstrap3-to-rails4][3]
[3]:http://blog.10rane.com/2015/02/18/introduced-bootstrap3-to-rails4/

~~~
cp -a bootstrap-3.3.2-dist/fonts /bootstrap3/vendor/assets
~~~

[【git】既存のディレクトリやソースをgit管理化にしてリモートに紐づける流れ][1]
[1]:http://tweeeety.hateblo.jp/entry/2016/02/10/000712

- ※ リポジトリ化する
~~~
$ git init
~~~
~~~
$ vi .git/config 
~~~
- 下記を修正
~~~
[core]
  repositoryformatversion = 0
  filemode = true
  bare = false
  logallrefupdates = true
  ignorecase = true
  precomposeunicode = true
~~~
- ※ リポジトリ情報追加
~~~
$ git remote add origin git@github.com:ユーザ名/リポジトリ名.git
~~~
- ※ リポジトリ（ディレクトリ）ごとにauthorを登録したいとき
~~~
$ git config user.name "Your Name"
$ git config user.email "you@example.com"
~~~

- ※ 試しにgit branchしてみると何も出てきません
~~~
$ git branch
~~~

- ※ git statusはこのタイミングでディレクトリにあるファイルがすべて差分として表示されます
~~~
$ git status  

$ git fetch    

$ git pull origin master   

$ git branch     
~~~

- ※ 適当なブランチを切る
- ※ カラのcommitをしてpull req出す
~~~
$ git commit --allow-empty -m 'created PR'
$ git push -u origin master
~~~

#####  途中問題解決

1. ※ 突然railsコマンドが動かなくなって    
~~~
$ spring stop

$ ps aux | grep spring
rbuser    7853  0.0  0.0 112652

$ kill -9 7853

~~~

2.  git コマンド補足
~~~
# コミットへ戻る
$ git reset

# ブロック単位
$ git add -p
~~~
3.  テーブル書き方　
~~~
| Left align | Right align | Center align |
|:-----------|------------:|:------------:|
| This       |        This |     This     |
| column     |      column |    column    |
| will       |        will |     will     |
| be         |          be |      be      |
| left       |       right |    center    |
| aligned    |     aligned |   aligned    |
~~~

| Left align | Right align | Center align |
|:-----------|------------:|:------------:|
| This       |        This |     This     |
| column     |      column |    column    |
| will       |        will |     will     |
| be         |          be |      be      |
| left       |       right |    center    |
| aligned    |     aligned |   aligned    |
