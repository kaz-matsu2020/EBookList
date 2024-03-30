<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page - E-Book-List</title>
<link rel="stylesheet" type="text/css" href="style.css">
<style>
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
  }

  .container {
    max-width: 1200px;
    margin: 0 auto;
    padding: 20px;
  }

  h1, h2 {
    margin: 0;
    padding: 10px 0;
  }

  .productList {
    display: inline-block;
    border: 1px solid #ddd;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    margin-right: 20px;
    margin-bottom: 20px;
    width: 200px;
  }

  .productList a {
    display: block;
    text-decoration: none;
    color: #333;
  }

  .productList img {
    width: 100%;
    height: auto;
    display: block;
    border-radius: 5px 5px 0 0;
  }

  .productList p {
    margin: 0;
    padding: 10px;
    font-size: 14px;
  }
</style>
</head>
<header>
  <%@ include file="isLogin.jsp" %>
</header>
<body>
<div class="container">
  <h1>My Page</h1>
  <h2>My E-Books</h2>
  <c:forEach var="myProduct" items="${myProductList}">
    <div class="productList">
      <a href="#" onclick="document.getElementById('productForm_${myProduct.productId}').submit(); return false;">
        <img src="${pageContext.request.contextPath}/${myProduct.topImage}" alt="Product Image">
        <p><c:out value="${myProduct.name}" /></p>
      </a>
      <form id="productForm_${myProduct.productId}" action="ReadingEBookServlet" method="get" style="display: none;">
        <input type="hidden" name="productId" value="${myProduct.productId}">
      </form>
    </div>
  </c:forEach>
</div>
</body>
</html>
