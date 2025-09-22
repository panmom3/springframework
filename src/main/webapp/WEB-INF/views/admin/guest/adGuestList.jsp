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
	<h2 class="text-center mt-5 mb-4">방 명 록 리 스 트</h2>
	<table class="table text-center">
		<thead class="table-warning">
			<tr>
				<th>번호</th>
				<th>성명</th>
				<th>이메일</th>
				<th>홈페이지</th>
				<th>방문소감</th>
				<th>방문일자</th>
			</tr>
		</thead>
			<c:forEach var="vo" items="${vos}" varStatus="st">
			<tr>
				<td>${vo.idx}</td>
				<td>${vo.name}</td>
				<td>${vo.email}</td>
				<td>${vo.homePage}</td>
				<td>${vo.content}</td>
				<td>${vo.VDate}</td>
			</tr>
			</c:forEach>
	</table>
</div>
</body>
</html>