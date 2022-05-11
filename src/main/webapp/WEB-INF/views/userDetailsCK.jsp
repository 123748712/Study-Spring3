<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!-- taglib : 태그 라이브러리, uri : 네임스페이스 uri 식별자, priefix : 태그 앞에 붙일 접두사 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ADMIN</h1>
<p><sec:authentication property="principal"/></p>
<p><sec:authentication property="principal.member"/></p>
<p><sec:authentication property="principal.member.userName"/></p>
<p><sec:authentication property="principal.username"/></p>
<p><sec:authentication property="principal.member.authList"/></p>
</body>
</html>