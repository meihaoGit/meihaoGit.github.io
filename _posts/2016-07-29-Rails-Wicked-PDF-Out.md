### Rails で Wicked PDF 使って PDF を出力

#### 作成環境と前提
Rails 4.2.6      
Ruby 2.3.1    


#### 前期準備
~~~
$ yum install libXrender libXext fontconfig
~~~

- PDF日本語フォント（linuxのみ）  
~~~
$ yum install -y ipa-gothic-fonts
$ yum install -y ipa-mincho-fonts
~~~

- Gemfile   

~~~
gem 'pdfkit'
gem 'wicked_pdf'
gem 'wkhtmltopdf-binary'
~~~

#### PJ作成   
- customerマスタ管理   

~~~
$ rails g scaffold customer name:string name_kana:string mail:string

$ rails g wicked_pdf
create  config/initializers/wicked_pdf.rb
~~~

これでconfig/initializer/wicked_pdf.rbが生成されます。

~~~
WickedPdf.config = {
  # which  wkhtmltopdf
  # wkhtmltopdfコマンドの位置を確認
  exe_path: '/usr/local/bin/wkhtmltopdf'
}
~~~

#### Controllerの編集  

続いてPDF出力をしたいControllerを修正します。  

~~~
  # GET /customers/1
  # GET /customers/1.json
  def show
    @customer = Customer.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.pdf do
        # 詳細画面のHTMLを取得
        html = render_to_string template: "customers/show"

        # PDFKitを作成
        pdf = PDFKit.new(html, encoding: "UTF-8")

        # 画面にPDFを表示する
        # to_pdfメソッドでPDFファイルに変換する
        # 他には、to_fileメソッドでPDFファイルを作成できる
        # disposition: "inline" によりPDFはダウンロードではなく画面に表示される
        send_data pdf.to_pdf,
          filename:    "#{@customer.id}.pdf",
          type:        "application/pdf",
          disposition: "inline"
      end
    end

  end
~~~

#### PDF表示の編集template作成

~~~
show.html.erb→show.pdf.erb
リンクボタンを削除
~~~

---
参考サイト[Railsでwickedpdfを使ってPDF出力する]

[Railsでwickedpdfを使ってPDF出力する]:http://www.virment.com/setup-wickedpdf-rails/
