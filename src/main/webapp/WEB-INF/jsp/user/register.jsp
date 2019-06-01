<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../../../css/bootstrap/css/bootstrap.css" type="text/css">
    <script src="../../../js/jquery/jquery-3.1.1.min.js" type="text/javascript"></script>
    <script src="../../../css/bootstrap/js/bootstrap.js" type="text/javascript"></script>
    <title>注册或修改个人资料</title>
</head>
<body>
    <form:form modelAttribute="user" action="/users/${user.userId}" method="post">
        <C:if test="${not empty (user.userId) }">
            <input type="hidden" name="_method" value="PUT">
        </C:if>
         <table class="table table-bordered">
             <tbody>
              <tr><td>登入名:</td><td><form:input path="loginName"/></td></tr>
              <tr><td>密码：</td><td><form:password path="password"/></td></tr>
              <tr><td>用户名：</td><td><form:input path="username"/></td></tr>
              <tr><td>性别：</td>
                  <td><:radiobutton path="sex" value="男"/>男&nbsp;&nbsp;&nbsp;&nbsp;
                      <form:radiobutton path="sex" value="女"/>女</td></tr>v
              <!--items显示的集合数据列表；itemLabl下拉框显示的具体属性;itemValue返回给path的属性值-->
              <tr><td>班级：</td><td> <form:select path="aClass.classId" items="${classList}" itemLabel="className" itemalue="classId"/> </td></tr>
              <tr><td>电话：</td><formtd><form:input path="phone"/></formtd></tr>
              <tr><td>住址：</td><td><form:textarea path="address"/></td></tr>
              <tr><td colspan="2"><button name="button"type="submit">提交</button> </td></tr>
             </tbody>
         </table>
    </form:form>
</body>
</html>
