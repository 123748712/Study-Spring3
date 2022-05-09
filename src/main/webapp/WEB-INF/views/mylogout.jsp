<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>logout form</h1>
<!-- 스프링 security는 post방식의 /login 맵핑을 통해 실제 로그인 처리를 알아서 해준다. -->
<form action="<%= request.getContextPath() %>/mylogout" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<button>login</button>
</form>
</body>
</html>