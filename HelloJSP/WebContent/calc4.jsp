<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>심플 계산기</title>
</head>
<body>

<!-- 화면에서 사용자로부터 정보를 입력받아, 다른 페이지로 보내줄 수 있다.
	 사용자로부터 정보를 입력받기 위해서는 <form>이라는 태그가 필요하다.
	 <form> 태그 안에는 사용자가 입력할 수 있는 "입력 폼"을 만들어야 한다.
	 일반적으로 많이 사용되는 것이 <input /> <textarea></textarea>가 있다. -->

<form method="post" action="/HelloJSP/calc3.jsp">
	<input type="text" name="f" placeholder="첫 번째 숫자를 입력하세요."/>
	<br/>
	<input type="text" name="s" placeholder="두 번째 숫자를 입력하세요."/>
	<br/>
	<input type="submit" value="더하기!"/>
</form>

</body>
</html>