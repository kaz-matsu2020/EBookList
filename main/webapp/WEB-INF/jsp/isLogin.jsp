<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="./style.css">
<div class="header">
<h1>E-Book-List</h1>
  <c:choose>
    <c:when test="${empty user}">
      <p>
        <a href="LoginServlet">ログイン</a>
        <a href="UserRegisterServlet">ユーザー登録</a>
        <a href="index.jsp">トップへ</a>
      </p>
    </c:when>
    <c:otherwise>
      <p>
        <span>${user.name}さん</span>
        <a href="index.jsp">トップへ</a>
        <a href="MyPageServlet">マイページ</a>
        <a href="LogoutServlet">ログアウト</a>
      </p>
    </c:otherwise>
  </c:choose>
</div>