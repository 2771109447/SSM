<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/bootstrap/css/bootstrap.css" type="text/css">
    <script src="/js/jquery/jquery-3.1.1.min.js" type="text/javascript"></script>
    <script src="/css/bootstrap/js/bootstrap.js" type="text/javascript"></script>
    <title>添加图书信息</title>
</head>
<body>
   <form:form modelAttribute="book" method="post" action="/books/">
       <table class="table table-bordered">
           <tbody>
               <tr><td>书名：</td><td><form:input path="bookName"/></td></tr>
               <tr><td>作者：</td><td><form:input path="author" /></td></tr>
               <tr><td>价格：</td><td><form:input path="price"/></td></tr>
               <tr><td>图片：</td><td><form:input path="image"/></td></tr>
               <tr><td>出版日期：</td><td><form:input path="publicationdate"/></td></tr>
               <tr><td colspan="2"><input type="submit" value="提交"></td></tr>
           </tbody>
       </table>
   </form:form>

<form action="/books/" method="post">
    <input type="text" name="date">
    <input type="submit" value="提交">
</form>
</body>
</html>
