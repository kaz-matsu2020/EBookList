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
<jsp:include page="WEB-INF/jsp/isLogin.jsp" />
<h1>${productDetail.name}の詳細</h1>
<img src="${pageContext.request.contextPath}/${productDetail.topImage}" alt="topImage" width="300px" border="3"><br>
名前:${productDetail.name}<br>
価格:${productDetail.price}<br>
<a href="DistributorServlet">販売業者:${distributorName}</a><br>
出版日:${productDetail.saleDate}<br>
更新日:${productDetail.updateDate}<br>
商品紹介:${productDetail.introduceComment}<br>
コメント一覧:<br>
購入ボタン:<br>
コメント投稿:
</body>
</html>