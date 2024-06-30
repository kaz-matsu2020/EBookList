<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>E-Book-List</title>
    <link rel="stylesheet" type="text/css" href="./style.css">
</head>
<body>
    <div class="title-container">
        <div class="title">
            <h1 style="display: inline;">E-Book-List</h1>
        </div>
        <div class="header">
            <c:choose>
                <c:when test="${empty user}">
                    <p>
                        <a href="LoginServlet" class="Button">ログイン</a>
                        <a href="UserRegisterServlet" class="Button">ユーザー登録</a>
                        <a href="index.jsp" class="Button">トップへ</a>
                    </p>
                </c:when>
                <c:otherwise>
                    <p>
                        <span class="userName">${user.name}さん | </span>
                        <a href="index.jsp">トップへ</a>
                        <a href="MyPageServlet">マイページ</a>
                        <a href="ChangeUserInfoServlet">ユーザー情報変更</a>
                        <a href="LogoutServlet">ログアウト</a>
                    </p>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</body>
</html>