<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-Book-List</title>
</head>
<body>
<jsp:include page="isLogin.jsp" />
こちらの購入で間違いないですか？<br>
<form action="PurchaseServlet" method="post">
<input type="submit" value="購入確定">
</form>
タイトル:${productDetail.name}<br>
価格:${productDetail.price}<br>
<img src="${pageContext.request.contextPath}/${productDetail.topImage}" alt="topImage" width="300px" border="3">
</body>
</html>