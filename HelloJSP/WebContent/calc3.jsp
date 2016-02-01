<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		// URL에 포함된 파라미터를 가져온다.
		// URL의 파라미터는 ?(물음표)를 기준으로 가져올 수 있다.
		// key=value 형태로 전달된다.
		// 여러 개의 파라미터가 전달 될 경우는 &로 연결한다.
		// Sample URL
		// http://localhost:8080/HelloJSP/calc3.jsp?f=100&s=70
		// request는 URL에 포함된 정보를 가져올 떄 쓰인다.
		String f = request.getParameter("f"); // parameter는 값에 상관없이 string이다.
		String s = request.getParameter("s");
		
		int firstNumber = Integer.parseInt(f);
		int secondNumber = Integer.parseInt(s);
		
		int additionResult = firstNumber + secondNumber;
	
	%>
	
	<%= firstNumber %> + <%= secondNumber %>의 결과는 <%=additionResult %> 입니다.

</body>
</html>