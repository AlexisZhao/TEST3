<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<title>Insert title here</title>
	</head>
	<body>
		<center>
			<h1>
				Message!
			</h1>
			<hr>
			<h2><%=request.getAttribute("errorMsg")%></h2>
			<a href="./index.jsp">Home Page</a>
		</center>
	</body>
</html>