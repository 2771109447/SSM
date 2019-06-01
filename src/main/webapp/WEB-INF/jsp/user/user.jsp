<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="../../../css/bootstrap/css/bootstrap.css" type="text/css">
    <script src="../../../js/jquery/jquery-3.1.1.min.js" type="text/javascript"></script>
    <script src="../../../css/bootstrap/js/bootstrap.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $(".delete").click(function () {
                var tr=$(this).attr("href");
                $.ajax({url:tr,type:"delete",success:function(result){

                    }});
                $(this).parents("tr").remove();
                return false;  //防止连接再度跳转
            })
        })
    </script>
    <title>首页</title>
</head>
<body>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>登入名</th>
        <th>用户名</th>
        <th>性别</th>
        <th>密码</th>
        <th>电话</th>
        <th>地址</th>
        <th>删除</th>
        <th>更新</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach  items="${requestScope.userList}" var="user">
        <tr>
            <td>${user.loginName}</td>
            <td>${user.username}</td>
            <td>${user.sex}</td>
            <td>${user.password}</td>
            <td>${user.phone}</td>
            <td>${user.address}</td>
            <td><a href="/users/${user.userId}"  class="delete">是</a> </td>
            <td><a href="/users/update/${user.userId}"  class="update">是</a> </td>

        </tr>
    </c:forEach>
    <tr><td colspan="8" align="right"><a href="/users/add">添加用户</a></td></tr>
    </tbody>
</table>
</body>
</html>