<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
<c:when test="${empty user}">
<p>
<a href="LoginServlet">ログイン</a><br>
<a href="UserRegisterServlet">ユーザー登録</a><br>
<a href="index.jsp">トップへ</a>
</p>
</c:when>
<c:otherwise>
<p>
${user.name}さん<br>
<a href="index.jsp">トップへ</a><br>
<a href="MyPageServlet">マイページ</a><br>
<a href="LogoutServlet">ログアウト</a>
</p>
</c:otherwise>
</c:choose>