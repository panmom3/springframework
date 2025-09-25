<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<jsp:include page="/WEB-INF/views/include/bs5.jsp" />
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<link rel="stylesheet" href="${ctp}/css/style.css">
	<title>adminLeft.jsp</title>
	<script>
		$(function() {
		  $(".accordion").on("click", function() {
			  $(".accordion").not(this).removeClass("active");
			  $(".panel").not($(this).next()).slideUp();
			  
			  
		    $(this).toggleClass("active");
		    var panel = $(this).next();  // 다음 요소(panel)
		    
		    if (panel.is(":visible")) {
		      panel.slideUp();   // 부드럽게 닫기
		    } else {
		      panel.slideDown(); // 부드럽게 열기
		    }
		  });
		});
</script>

</head>
<body>
<p><br/></p>
<div class="container ms-2">
	<h5><a href="${ctp}/admin/adminMain" target="_top">관리자메뉴</a></h5>
	<hr/>
	<p class="adhome"><a href="${ctp}/" target="_top">홈으로</a></p>
	<hr/>
	<div>
		<div class="accordion"><b>게시글관리</b></div>
		<div class="panel">
			<p><a href="${ctp}/admin/guest/adGuestList" target="adminContent">방명록리스트</a></p>
			<p><a href="${ctp}/admin/board/adBoardList" target="adminContent">게시판리스트</a></p>
		</div>
	</div>
	<div>
		<div class="accordion"><b>회원관리</b></div>
		<div class="panel">
			<p><a href="${ctp}/admin/member/adMemberList" target="adminContent">회원리스트</a></p>
			<p><a href="${ctp}/admin/complaint/complaintList" target="adminContent">신고리스트</a></p>
		</div>
	</div>
	<div>
		<div class="accordion"><b>일정관리</b></div>
		<div class="panel">
			<p><a href="${ctp}/admin/schedule/adScheduleList" target="adminContent">일정리스트</a></p>
			<p><a href="">일정게시</a></p>
		</div>
	</div>
	<div>
		<div class="accordion"><b>설문조사관리</b></div>
		<div class="panel">
			<p><a href="${ctp}/admin/guest/adminGuestList">설문조사등록</a></p>
			<p><a href="">설문조사리스트</a></p>
			<p><a href="">설문조사분석</a></p>
		</div>
	</div>
	<div>
		<div class="accordion"><b>상품관리</b></div>
		<div class="panel">
			<p><a href="${ctp}/admin/guest/adminGuestList">상품분류등록</a></p>
			<p><a href="">상품등록관리</a></p>
			<p><a href="">상품등록조회</a></p>
			<p><a href="">옵션등록관리</a></p>
			<p><a href="">주문관리</a></p>
			<p><a href="">반품관리</a></p>
			<p><a href="">1:1문의</a></p>
			<p><a href="">상품메인이미지관리</a></p>
		</div>
	</div>
	<div>
		<div class="accordion"><b>기타관리</b></div>
		<div class="panel">
			<p><a href="${ctp}/admin/guest/adminGuestList">공지사항관리</a></p>
			<p><a href="">FAQ관리</a></p>
			<p><a href="">QnA관리</a></p>
			<p><a href="">쿠폰관리</a></p>
			<p><a href="">임시파일관리</a></p>
			<p><a href="">실시간상담</a></p>
		</div>
	</div>
</div>
<p><br/></p>
</body>
</html>