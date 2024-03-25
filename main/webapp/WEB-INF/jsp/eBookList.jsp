<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="product" items="${productList}">
<a href="#" onclick="document.getElementById('productForm_${product.productId}').submit(); return false;">
<div style="padding: 10px; margin-bottom: 10px; border: 1px solid #333333; width: 350px;">
<p>
タイトル:<c:out value="${product.name}" /><br>
価格:<c:out value="${product.price}" />
<form id="productForm_${product.productId}" action="ProductDetailServlet" method="get" style="display: inline;">
<input type="hidden" name="productId" value="${product.productId}">
<img src="${pageContext.request.contextPath}/${product.topImage}" alt="topImage" width="300px" border="3">
</form>
</p>
</div>
</a>
</c:forEach>