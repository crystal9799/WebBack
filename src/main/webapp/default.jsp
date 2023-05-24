<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet 요청하기</title>
</head>
<body>
	<h3>요청 처리하기</h3>
	<h3>getContextPath</h3>
	<%= request.getContextPath() %>
	<hr>
	<a href="<%= request.getContextPath()%>/simple">simple 요청하기(GET)</a>
	<br>
	<a href="<%= request.getContextPath()%>/simple?type=date">날씨 요청하기(GET)</a>
	<br>
	<a href="<%= request.getContextPath()%>/simple?type=abcd">비정상 요청하기(GET)</a>
	<hr>
	<h3>FrontServletController 사용하기 (게시판 요청 Command 방식으로 servlet 하나가 모두 처리)</h3>
	
	<a href="<%= request.getContextPath()%>/board?cmd=boardlist">게시판 목록보기</a>
	<br>	
	<a href="<%= request.getContextPath()%>/board?cmd=boardwrite">게시판 글쓰기</a>
	<br>	
	<a href="<%= request.getContextPath()%>/board">cmd null Error 페이지</a>
	<br>	
	<a href="<%= request.getContextPath()%>/board?cmd=boarddelete">게시판 삭제하기</a>
	<br>	
	<a href="<%= request.getContextPath()%>/board?cmd=Login">보안 페이지 로그인 처리</a>
	<br>
	
</body>
</html>