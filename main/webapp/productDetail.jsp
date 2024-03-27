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
購入ボタン:<br>
<div style="padding: 10px; margin-bottom: 10px; border: 1px solid #333333; width: 350px;">
コメント一覧<br>
<c:forEach var="comment" items="${commentList}">
<c:out value="${comment.userId}" />:<c:out value="${comment.commentDate}" /><br>
<c:out value="${comment.evaComment}" />
<c:if test="${comment.userId == user.userId}">
<br>
<form action="CommentDeleatServlet" method="post">
<input type="submit" value="コメントを削除">
<input type="hidden" value="comment">
</form>
</c:if>
<br>
</c:forEach>
</div>
<c:if test="${user.userId != null}">
<form action="CommentPostServlet" method="post">
コメント投稿:<input type="text" name="text"><br>
<input type="submit" value="投稿">
<input type="hidden" name="productId" value="${productDetail.productId}">
</form>
</c:if>
<c:if test="${not empty errMsg}">
${errMsg}
</c:if>
</body>
</html>