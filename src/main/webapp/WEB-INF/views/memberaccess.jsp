<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>멤버 접속가능한 페이지</h1>
<h1>${accessUser} 접속</h1>
<a href="<%= request.getContextPath() %>/mylogout">logout</a>
</body>
</html>