<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/bootstrap/css/bootstrap.css" type="text/css">
    <script src="/js/jquery/jquery-3.1.1.min.js" type="text/javascript"></script>
    <script src="/css/bootstrap/js/bootstrap.js" type="text/javascript"></script>
    <title>Title</title>
</head>
<body>
<table class="table table-bordered">
    <thead>${sessionScope.user.username}</thead>
    <thead>
    <tr>
    <th>id</th>
    <th>封面</th>
    <th>作者</th>
    <th>出版日期</th>
    <th>价格</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach  items="${requestScope.bookList}" var="book">
        <tr>
            <td>${book.bookId}</td>
            <td><image src="/images/${book.image}"height="60"/></td>
            <td>${book.author}</td>
            <td><fmt:formatDate value="${book.publicationdate}" pattern="yyyy-MM-dd"/></td>
            <td>${book.price}</td>
        </tr>
    </c:forEach>
        <tr><td colspan="5"><a href="/books/insert">添加</a></td></tr>
    </tbody>
</table>
</body>
</html>
