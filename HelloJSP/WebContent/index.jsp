<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 주석... 다른 사용자가 이 주석을 볼 수 있다. 그래서 민감한 정보는 여기다가 쓰지 않는다. -->    
<%-- 주석... 다른 사용자가 이 주석을 볼 수 없다. JSP의 주석 --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

안녕하세요! <br />

<p>JSP 입니다.</p>

<% // 스크립트릿 : JSP에서 Java 코드를 쓸 수 있는 영역 // 시험에 나옴
	String hello = "반갑습니다.";
	out.println(hello+"<br/>"); // 화면에 출력한다.
%>
<br />
<%= hello %> 

</body>
</html>