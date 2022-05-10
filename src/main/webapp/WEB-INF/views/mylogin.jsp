<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>login form</h1>
<!-- 스프링 security는 post방식의 /login 맵핑을 통해 실제 로그인 처리를 알아서 해준다. -->
<form action="<%= request.getContextPath() %>/login" method="post">
	아이디<input type="text" name="username" value=""> <br>
	비밀번호<input type="password" name="password" value=""> <br>
 	<!-- security parameter는 uesrname, password로 받는다. -->
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<!-- form의 method가 post인 경우에만 넣어줌 csrf 공격을 막기위함 -->
	<button>login</button>
</form>
</body>
</html>