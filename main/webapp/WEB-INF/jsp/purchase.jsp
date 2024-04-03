<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm Purchase - E-Book-List</title>
<link rel="stylesheet" type="text/css" href="./stylede.css">
</head>
<header>
  <%@ include file="isLogin.jsp" %>
</header>
<body>
<div class="containerPu">
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