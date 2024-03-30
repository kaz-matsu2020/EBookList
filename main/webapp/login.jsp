<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-Book-List Login</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="containerLogin">
  <h2>E-Book-List Login</h2>
  <form action="LoginServlet" method="post">
    <label for="userId">ユーザーID:</label>
    <input type="text" id="userId" name="userId">
    <label for="pass">パスワード:</label>
    <input type="password" id="pass" name="pass">
    <input type="submit" value="ログイン">
  </form>
  <a href="UserRegisterServlet" class="link">ユーザー登録</a>
  <a href="index.jsp" class="link">トップへ</a>
</div>
</body>
</html>