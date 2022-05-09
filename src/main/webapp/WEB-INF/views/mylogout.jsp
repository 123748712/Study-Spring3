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
<form action="<%= request.getContextPath() %>/mylogout" method="post" id="id_form">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<br>
<h1>${guest}.. logout ?</h1>
<a href="#" id="id_logout">logout</a>
<script>
	const c_a = document.querySelector("#id_logout");
	const c_form = document.querySelector("#id_form");
	
	c_a.onclick = () => {
		event.preventDefault();
		c_form.submit(); // POST로 이미 세팅된 상태로 전송
	}
</script>
</body>
</html>