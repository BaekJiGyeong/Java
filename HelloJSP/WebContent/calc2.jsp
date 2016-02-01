<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>심플 계산기</title>
</head>
<body>
	<%
		int firstNumber = 50;
		int secondNumber = 60;
	%>
	
	<i><%=firstNumber%> + <%=secondNumber%></i>의 결과는
	<b><%=firstNumber+secondNumber%></b>입니다.

</body>
</html>