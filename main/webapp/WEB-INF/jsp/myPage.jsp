<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-Book-List</title>
</head>
<body>
<h1>My Page</h1>
<jsp:include page="isLogin.jsp" />
<h2>My-E-Book</h2>
<c:forEach var="myProduct" items="${myProductList}">
<a href="#" onclick="document.getElementById('productForm_${myProduct.productId}').submit(); return false;">
<div style="padding: 10px; margin-bottom: 10px; border: 1px solid #333333; width: 350px;">
<p>
タイトル:<c:out value="${myProduct.name}" /><br>
<form id="productForm_${myProduct.productId}" action="ReadingEBookServlet" method="get" style="display: inline;">
<input type="hidden" name="productId" value="${myProduct.productId}">
<img src="${pageContext.request.contextPath}/${myProduct.topImage}" alt="topImage" width="300px" border="3">
</form>
</p>
</div>
</a>
</c:forEach>
</body>
</html>