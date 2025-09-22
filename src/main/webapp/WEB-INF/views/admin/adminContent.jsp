<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<jsp:include page="/WEB-INF/views/include/bs5.jsp" />
	<title>adminContent.jsp</title>
</head>
<body>
<p><br/></p>
<div class="container">
	<h2>관리자 메인화면</h2>
	<hr/>
	<!-- 
		- 방명록에 올린 최근글 리스트 ? 개 게시
		- 게시판 ---------
		- 신규회원(level=3) 리스트(건수)
		- 탈퇴신청회원 리스트(건수)
	 -->
	 <table class="table table-bordered table-striped table-hover text-center">
	 	<colgroup>
	 		<col style="width:70%">
	 		<col>
	 	</colgroup>
	  <tbody>
	  	<tr>
	      <th class="table-primary">방명록 새글</th>
	      <td>${guestCnt} 건</td>
	    </tr>
	    <tr>
	      <th class="table-primary">게시판 새글</th>
	      <td>${boardCnt} 건</td>
	    </tr>
	    <tr>
	      <th class="table-primary">신고글 새글</th>
	      <td>건</td>
	    </tr>
	    <tr>
	      <th class="table-primary">신규회원 새글</th>
	      <td>건</td>
	    </tr>
	    <tr>
	      <th class="table-primary">탙퇴회원 새글</th>
	      <td>건</td>
	    </tr>
	  </tbody>
	</table>
</div>
<p><br/></p>
</body>
</html>