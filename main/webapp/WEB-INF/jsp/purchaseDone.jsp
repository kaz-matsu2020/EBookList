<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Purchase Completed - E-Book-List</title>
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
</style>
</head>
<body>
<div class="container">
  <h1>購入完了</h1>
  <jsp:include page="isLogin.jsp" />
</div>
</body>
</html>