<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm Purchase - E-Book-List</title>
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
  }
  input[type="submit"] {
    padding: 10px 20px;
    background-color: #232f3e;
    color: #ffffff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }
  input[type="submit"]:hover {
    background-color: #232f3e;
  }
  img {
    display: block;
    margin: 20px auto;
    border: 3px solid #ffffff;
    border-radius: 5px;
    max-width: 100%;
    height: auto;
  }
</style>
</head>
<body>
<div class="container">
  <jsp:include page="isLogin.jsp" />
  <h1>購入確認</h1>
  <p>こちらの購入で間違いありませんか？</p>
  <form action="PurchaseServlet" method="post">
    <input type="submit" value="購入確定">
  </form>
  <p>タイトル: ${productDetail.name}</p>
  <p>価格: ${productDetail.price}</p>
  <img src="${pageContext.request.contextPath}/${productDetail.topImage}" alt="Product Image">
</div>
</body>
</html>