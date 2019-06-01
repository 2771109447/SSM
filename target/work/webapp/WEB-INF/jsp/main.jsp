<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"  href="css/bootstrap/css/bootstrap.css" type="text/css">
    <script src="js/jquery/jquery-3.1.1.min.js" type="text/javascript"></script>
    <script src="css/bootstrap/js/bootstrap.js"type="text/javascript"></script>
    <title>首页</title>
</head>
<body>

<table class="table table-bordered">
    <caption>欢迎[${sessionScope.user.username}]访问</caption>
    <thead>
    <tr >
        <th>封面</th>
        <th>书名</th>
        <th>作者</th>
        <th>价格</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach  items="${requestScope.bookList}" var="book">
        <tr>
            <td><img src="/images/${book.image}"height="60"></td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
