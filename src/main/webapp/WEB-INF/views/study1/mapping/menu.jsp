<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<jsp:include page="/WEB-INF/views/include/bs5.jsp" />
	<title>menu.jsp</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/nav.jsp" />
<jsp:include page="/WEB-INF/views/include/slide2.jsp" />
<p><br/></p>
<div class="container">
	<h2>Mapping 연습</h2>
	<hr style="border-width:10px">
	<p><b>Query String방식(?변수=값)</b></p>
	<hr/>
	<p>
		<a href="test1?mid=hkd1234&pwd=1234" class="btn btn-success">test1</a>
		<a href="test2?mid=kms1234&pwd=5678" class="btn btn-primary">test2</a>
		<a href="test3?mid=lkj1234&pwd=4321" class="btn btn-secondary">test3</a>
		<a href="test4?mid=snm1234&pwd=8765&sex=2" class="btn btn-info">test4</a>
		<a href="test5?mid=snm1234&pwd=8765&name=소나무&gender=남자&age=20" class="btn btn-dark">test5</a>
	</p>
	<p>
		<a href="test6?mid=ohn1234&pwd=1357&name=오하늘&gender=여자&age=22" class="btn btn-outline-success">test6</a>
		<a href="test7?mid=gid1234&pwd=2468&name=고인돌&gender=남자&age=60" class="btn btn-outline-primary">test7</a>
		<a href="test8?mid=atom1234&pwd=0987&name=아톰&gender=중성&age=12" class="btn btn-outline-secondary">test8</a>
		<a href="test9?mid=btom1234&pwd=5687&name=비톰&gender=남자&age=44" class="btn btn-outline-info">test9</a>
	</p>
	<hr style="border-width:10px">
	<p><b>Path Variable방식(/값1/값2)</b></p>
	<hr/>
	<p>
		<a href="test21/hkd1234/1234" class="btn btn-success">test21</a>
		<a href="test22/kms1234/5678" class="btn btn-primary">test22</a>
		<a href="1357/test23/lkj1234" class="btn btn-secondary">test23</a>
		<a href="2468/_____/test24/ohn1234" class="btn btn-info">test24</a>
		<a href="test25/atom1234/2580/아톰/남자/13" class="btn btn-dark">test25</a>
	</p>
</div>
<p><br/></p>
<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>