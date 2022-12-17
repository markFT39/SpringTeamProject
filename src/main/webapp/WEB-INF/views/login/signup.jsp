<%--
  Created by IntelliJ IDEA.
  User: segsipogtandaineomaiteu
  Date: 2022/12/15
  Time: 8:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원가입</title>
</head>
<body>
<h1>누구세용?</h1>
  <form method="post" action="signupOk">
    <div><label>User Name: </label><input type='text' name='username' /></div>
    <div><label>User ID: </label><input type='text' name='userid' /></div>
    <div><label>Password: </label><input type='password' name='password' /></div>
    <br>
    <button type="button" onclick="history.back()">뒤로가기</button>
    <button type='submit'>가입하기</button>
  </form>
</body>
</html>
