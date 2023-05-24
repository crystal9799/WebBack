<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>simpleController 에서 전달된(request) 데이터 출력</h3>
	결과출력 : <%= request.getAttribute("result") %>
</body>
</html>