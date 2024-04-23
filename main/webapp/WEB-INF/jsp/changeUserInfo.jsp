<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change User Infomation - E-Book-List</title>
<link rel="stylesheet" type="text/css" href="./stylede.css">
</head>
<header>
  <%@ include file="isLogin.jsp" %>
</header>
<body>
<div class="containerRegi">
  <h1>登録情報変更</h1>
   <c:if test="${errMsg != null}">
    <p>${errMsg}</p>
  </c:if>
  <c:if test="${resultMsg != null}">
    <p>${resultMsg}</p>
  </c:if>
  ユーザーID:${user.userId}
  <form action="ChangeUserInfoServlet" method="post">
    パスワード:<input type="password" name="pass" value = "${user.pass}" required><br>
    MAIL:<input type="email" name="mail" value = "${user.mail}" required><br>
    名前:<input type="text" name="name" value = "${user.name}" required><br>
    年齢:<input type="number" name="age" value = "${user.age}" required><br>
    <input type="submit" value="変更">
  </form>
  <a href="index.jsp">トップへ</a>
</div>
</body>
</html>