<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration - E-Book-List</title>
<link rel="stylesheet" type="text/css" href="./stylede.css">
</head>
<header>
  <%@ include file="isLogin.jsp" %>
</header>
<body>
<div class="containerRegi">
  <h1>ユーザー登録</h1>
  <c:if test="${errMsg != null}">
    <p>${errMsg}</p>
  </c:if>
  <form action="UserRegisterServlet" method="post">
    <div class="left">
    ユーザーID<input type="text" name="userId" placeholder="半角英数字3文字～10文字" required><br>
    パスワード<input type="password" name="pass" placeholder="半角英数字3文字～10文字" required><br>
    MAIL<input type="email" name="mail" placeholder="a@a" required><br>
    名前<input type="text" name="name" placeholder="メニューに表示する名前" required><br>
    年齢<input type="number" name="age" placeholder="年齢" required><br>
    </div>
    <div class="button"><input type="submit" value="登録"></div>
  </form>
  <a href="index.jsp">トップへ</a>
</div>
</body>
</html>