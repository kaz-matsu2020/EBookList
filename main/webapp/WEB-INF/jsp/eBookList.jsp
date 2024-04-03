<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="./style.css">
<c:forEach var="product" items="${productList}">
  <div class="productList">
    <a href="#" onclick="document.getElementById('productForm_${product.productId}').submit(); return false;">
      <h3><c:out value="${product.name}" /></h3>
      <p class="price">価格: <c:out value="${product.price}" /></p>
      <form id="productForm_${product.productId}" action="ProductDetailServlet" method="get">
        <input type="hidden" name="productId" value="${product.productId}">
        <img src="${pageContext.request.contextPath}/${product.topImage}" alt="topImage">
      </form>
    </a>
  </div>
</c:forEach>