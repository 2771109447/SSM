
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%><html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>登录页面</title>
</head>
<body>

  <h3>登录页面</h3>
  <form action="/users/login" method="get">
     <h3 color="red">${requestScope.error}</h3>
      <table>
          <tr>
              <td><label>登录名：</label></td>
              <td><input type="text" id="loginname" name="loginname"> </td>
          </tr>
          <tr>
              <td><label>密码：：</label></td>
              <td><input type="text" id="password" name="password"> </td>
          </tr>
          <tr><td><input type="submit" value="登录"></td></tr>
      </table>

  </form>

   //查询全部用户
  <form action="/users/" method="get">
      <input type="submit" value="TestRest get"/>
  </form>

</body>
</html>
