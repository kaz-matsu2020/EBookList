<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration - E-Book-List</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f3f3f3;
    margin: 0;
    padding: 0;
  }
  .container {
    max-width: 600px;
    margin: 50px auto;
    padding: 20px;
    background-color: #ffffff;
    border-radius: 5px;
    box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
  }
  h1, h2 {
    text-align: center;
    color: #333333;
  }
  form {
    text-align: center;
    margin-top: 20px;
  }
  input[type="text"],
  input[type="password"],
  input[type="email"],
  input[type="number"] {
    width: 100%;
    padding: 10px;
    margin: 10px 0;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
  }
  input[type="submit"] {
    width: 100%;
    padding: 10px;
    margin-top: 20px;
    background-color: #232f3e;
    color: #ffffff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }
  input[type="submit"]:hover {
    background-color: #232f3e;
  }
  a {
    display: block;
    text-align: center;
    margin-top: 20px;
    text-decoration: none;
    color: #0066c0;
  }
</style>
</head>
<body>
<div class="container">
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