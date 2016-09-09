---
layout: post
title:  "Spring-boot勉強(2)"
date:   2016-09-07
category: Java
tags: [Java]
---

## Java Spring-boot前回

- [Spring-boot勉強(1)](https://meihaogit.github.io/java/2016/09/01/Spring-boot.html) - Spring-boot勉強(1)


## 開発進階


- spring boot + thymeleafでWEB画面実装

     1. テンプレートを追加
     
~~~
test.html

<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>top page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
test
  <p th:text="${msg}" /> 
</body>
</html>

~~~
     2. コントローラを追加
     
~~~
# CustomerController.java
     
package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class CustomerController {

    @RequestMapping(method = RequestMethod.GET)
    public String test(Model model) {
        model.addAttribute("msg","サンプルメッセージ！");
        return "test/test";
    }

}
~~~  
     3. テンプレートモードをHTMLにする
     
~~~  
src/main/resources/application.properties
spring.thymeleaf.mode=HTML

~~~
     4. Thymeleaf Layout Dialec   
     
~~~
src/main/java/demo/indexController.java

package demo;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
 
@Controller
public class indexController {
  @RequestMapping(value="/",method=RequestMethod.GET)
  String index(){
    return "index";
  }
  @RequestMapping(value="/index2",method=RequestMethod.GET)
  String index2(){
    return "index2";
  }
}

~~~   
     5.  /src/main/resources/templates/layout.html 作成
      
~~~
<!DOCTYPE html>
<html
xmlns         = "http://www.w3.org/1999/xhtml"
xmlns:th      = "http://www.thymeleaf.org"
xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
</head>
<body>
 
<th:block layout:fragment="layout-content">
    <p>Default layout content</p>
</th:block>
 
</body>
</html>

~~~  
    6.  /src/main/resources/templates/index.html　作成


~~~
<div layout:decorator="layout">
    <th:block layout:fragment="layout-content">
        <p>ページ１</p>
    </th:block>
</div>

~~~  
    7. /src/main/resources/templates/index2.html　作成

~~~   
<div layout:decorator="layout">
    <th:block layout:fragment="layout-content">
        <p>ページ２</p>
    </th:block>
</div>

~~~

