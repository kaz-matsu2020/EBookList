<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-Book-List</title>
</head>
<body>
<h1>E-Book-List</h1>
<form action="LoginServlet" method="post">
ユーザーID:<input type="text" name="userId"><br>
パスワード:<input type="password" name="pass"><br>
<input type="submit" value="ログイン">
</form>
<a href="UserRegisterServlet">ユーザー登録</a>
<a href="index.jsp">トップへ</a>
</body>
</html>