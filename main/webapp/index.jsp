<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>E-Book-List</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<header>
  <%@ include file="WEB-INF/jsp/isLogin.jsp" %>
</header>
<div class="container">
  <div class="ebook-list">
    <%@ include file="WEB-INF/jsp/eBookList.jsp" %>
  </div>
</div>
</body>
</html>