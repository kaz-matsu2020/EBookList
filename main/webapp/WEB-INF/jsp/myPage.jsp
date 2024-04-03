<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page - E-Book-List</title>
<link rel="stylesheet" type="text/css" href="./stylede.css">
</head>
<header>
  <%@ include file="isLogin.jsp" %>
</header>
<body>
<div class="containermy">
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
