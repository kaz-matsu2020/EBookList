<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Detail</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<header>
<jsp:include page="WEB-INF/jsp/isLogin.jsp" />
</header>
<div class="containerDetail">
  <div class="productImage">
    <img src="${pageContext.request.contextPath}/${productDetail.topImage}" alt="Product Image" width="240px">
  </div>
  <div class="product-info">
    <p>名前: ${productDetail.name}</p>
    <p>価格: ${productDetail.price}</p>
    <p>販売業者: ${distributorName}</p>
    <p>出版日: ${productDetail.saleDate}</p>
    <p>更新日: ${productDetail.updateDate}</p>
    <p>商品紹介: ${productDetail.introduceComment}</p>
    <c:if test="${user.userId ne null}">
      <form action="PurchaseServlet" method="get">
        <input type="submit" value="購入">
      </form>
    </c:if>
  </div>
  <div class="comments">
    <h2>ユーザーレビュー</h2>
    <c:forEach var="comment" items="${commentList}">
      <div class="comment-item">
        <p>${comment.userId}: ${comment.commentDate}</p>
        <p>${comment.evaComment}</p>
        <c:if test="${comment.userId eq user.userId}">
          <form action="CommentDeleteServlet" method="post">
            <input type="submit" value="レビューを削除">
          </form>
        </c:if>
      </div>
    </c:forEach>
  </div>
  <c:if test="${user.userId ne null && mine eq true}">
    <div class="comment-form">
      <form action="CommentPostServlet" method="post">
        <input type="text" name="text" placeholder="レビュー投稿">
        <input type="submit" value="投稿">
      </form>
    </div>
  </c:if>
  <c:if test="${not empty errMsg}">
    <p class="error-msg">${errMsg}</p>
  </c:if>
</div>
</body>
</html>