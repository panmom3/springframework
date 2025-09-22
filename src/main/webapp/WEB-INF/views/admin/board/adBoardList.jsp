<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<jsp:include page="/WEB-INF/views/include/bs5.jsp" />
	<link rel="stylesheet" type="text/css" href="${ctp}/css/style.css">
	<title>adBoardList.jsp</title>
</head>
<body>
<div class="container">
	<h2 class="text-center mt-5 mb-4">게 시 판 리 스 트</h2>
	<table class="table table-hover text-center">
		<thead class="table-success">
			<tr>
				<th>번호</th>
				<th>글제목</th>
				<th>글쓴이</th>
				<th>올린날짜</th>
			</tr>
		</thead>
			<c:forEach var="vo" items="${vos}" varStatus="st">
			<tr>
				<td>${vo.idx}</td>
				<td>${vo.title}</td>
				<td>${vo.nickName}</td>
				<td>${vo.WDate}</td>
			</tr>
			</c:forEach>
	</table>
</div>
</body>
</html>