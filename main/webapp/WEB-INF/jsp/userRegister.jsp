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
    ユーザーID:<input type="text" name="userId" required><br>
    パスワード:<input type="password" name="pass" required><br>
    MAIL:<input type="email" name="mail" required><br>
    名前:<input type="text" name="name" required><br>
    年齢:<input type="number" name="age" required><br>
    <input type="submit" value="登録">
  </form>
  <a href="index.jsp">トップへ</a>
</div>
</body>
</html>