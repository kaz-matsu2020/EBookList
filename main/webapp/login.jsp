<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-Book-List Login</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<header>
  <%@ include file="WEB-INF/jsp/isLogin.jsp" %>
</header>
<body>
<div class="containerLogin">
  <h2>ログイン画面</h2>
  <form action="LoginServlet" method="post">
    <label for="userId">ユーザーID</label>
    <input type="text" id="userId" name="userId" placeholder="半角英数字3文字～10文字" required>
    <label for="pass">パスワード</label>
    <input type="password" id="pass" name="pass" placeholder="半角英数字3文字～10文字" required>
    <div class="button"><input type="submit" value="ログイン"></div>
  </form>
  <a href="UserRegisterServlet" class="link">ユーザー登録</a>
  <a href="index.jsp" class="link">トップへ</a>
</div>
</body>
</html>