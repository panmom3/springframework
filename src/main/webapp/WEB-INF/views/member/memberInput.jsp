<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <jsp:include page="/WEB-INF/views/include/bs5.jsp" />
 <title>memberInput.jsp</title>
 <script>

	// 유효성검사
	document.getElementById('myForm').addEventListener('submit', function(e){
		event.preventDefault();
		
		// 정규식 패턴 정의
		  const regexId = /^[a-zA-Z0-9]{5,15}$/;  // 영문/숫자 5~15자
		  const regexPw = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,20}$/; 
		  // 영문, 숫자, 특수문자 포함 8~20자
		  const regexEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; // 이메일 형식
		  const regexPhone = /^010-\d{4}-\d{4}$/; // 010-1234-5678
		  const regexUrl = /^(https?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w \.-]*)*\/?$/; // URL
	    	
		  // 아이디 검사
		  const userid = document.getElementById("userid").value.trim();
		  if (!regexId.test(userid)) {
		    alert("아이디는 영문/숫자 5~15자로 입력해야 합니다.");
		    return;
		  }

		  // 비밀번호 검사
		  const password = document.getElementById("password").value.trim();
		  if (!regexPw.test(password)) {
		    alert("비밀번호는 영문, 숫자, 특수문자를 포함해 8~20자로 입력해야 합니다.");
		    return;
		  }

		  // 이메일 검사
		  const email = document.getElementById("email").value.trim();
		  if (!regexEmail.test(email)) {
		    alert("올바른 이메일 주소를 입력하세요.");
		    return;
		  }

		  // 전화번호 검사
		  const phone = document.getElementById("phone").value.trim();
		  if (!regexPhone.test(phone)) {
		    alert("전화번호는 010-1234-5678 형식으로 입력하세요.");
		    return;
		  }

		  // 홈페이지 검사
		  const homepage = document.getElementById("homepage").value.trim();
		  if (homepage && !regexUrl.test(homepage)) {
		    alert("홈페이지 주소 형식이 올바르지 않습니다.");
		    return;
		  }
		// 모든 검사 통과
		  alert("회원가입이 완료되었습니다!");
		  // 실제 서버로 전송하려면 주석 해제
			myform.submit();
		});

</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/nav.jsp" />
	<jsp:include page="/WEB-INF/views/include/slide2.jsp" />
	<p><br/></p>
	<div class="container">
	<h2>회원가입폼</h2>
		<form name="myForm" method="post" class="">
			<div class="mb-3">
				<label for="mid" class="form-label">아이디</label>
				<input type="text" class="form-control" id="mid" name="mid" required placeholder="아이디를 입력하세요">
			</div>
			<div class="mb-3">
				<label for="pwd" class="form-label">비밀번호</label>
				<input type="password" class="form-control" id="pwd" name="pwd" required placeholder="비밀번호를 입력하세요">
			</div>
			<div class="mb-3">
				<label for="nickName" class="form-label">닉네임</label>
				<input type="text" class="form-control" id="nickName" name="nickName" placeholder="닉네임">
			</div>
			<div class="mb-3">
				<label for="name" class="form-label">성명</label>
				<input type="text" class="form-control" id="name" name="name" required placeholder="홍길동">
			</div>
			<div class="mb-3">
				<label class="form-label d-block">성별</label>
				<input class="form-check-input" type="radio" name="gender" value="male">남자
				<input class="form-check-input" type="radio" name="gender" value="female">여자
			</div>
			<div class="mb-3">
				<label for="birthday" class="form-label">회원 생일</label>
				<input type="date" class="form-control" id="birthday" name="birthday" required>
			</div>
			<div class="mb-3">
				<label for="tel" class="form-label">전화번호</label>
				<input type="tel" class="form-control" id="tel" name="tel" required pattern="010-\d{4}-\d{4}" placeholder="010-1234-5678">
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">이메일</label>
				<input type="email" class="form-control" id="email" name="email" required placeholder="example@domain.com">
			</div>
			<!-- 주소 -->
			<div class="col-12">
				<label class="form-label">주소</label>
			<div class="row g-2">
				<div class="col-md-3">
					<input type="text" class="form-control" id="zipcode" name="zipcode" placeholder="우편번호">
				</div>
				<div class="col-md-5">
					<input type="text" class="form-control" id="address" name="address" placeholder="주소(도로명/지번)" required>
				</div>
				<div class="col-md-4">
					<input type="text" class="form-control" id="addressDetail" name="addressDetail" placeholder="상세주소">
				</div>
			</div>
				<input type="text" class="form-control mt-2" id="addressExtra" name="addressExtra" placeholder="참조주소">
			</div>
			
			<div class="mb-3">
				<label for="homePage" class="form-label">회원 홈페이지</label>
				<input type="url" class="form-control" id="homePage" name="homePage" placeholder="https://">
			</div>
			<div class="mb-3">
			<label for="job" class="form-label">직업</label>
			<select id="job" name="job" class="form-select">
				<option value="">-- 직업을 선택하세요 --</option>
				<option value="student">학생</option>
				<option value="developer">개발자</option>
				<option value="designer">디자이너</option>
				<option value="manager">관리자</option>
				<option value="etc">기타</option>
			</select>
			</div>	
			
			<div class="mb-3">
				<label class="form-label d-block">취미</label>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="hobbyMusic" name="hobby" value="music">
					<label class="form-check-label" for="hobbyMusic">음악감상</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="hobbySports" name="hobby" value="sports">
					<label class="form-check-label" for="hobbySports">운동</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="hobbyTravel" name="hobby" value="travel">
					<label class="form-check-label" for="hobbyTravel">여행</label>
				</div>
			</div>
			<!-- 회원 사진 -->
			<div class="mb-3">
				<label for="photo" class="form-label">회원 사진 업로드</label>
				<input class="form-control" type="file" id="photo" name="photo" accept="image/*">
				<div id="photoPreview" class="mt-2"></div>
			</div>
			<!-- 자기소개 -->
			<div class="mb-3">
				<label for="intro" class="form-label">자기(회원)소개</label>
				<textarea class="form-control" id="intro" name="intro" rows="4" placeholder="자기소개를 입력하세요..."></textarea>
			</div>
			<div class="m-3 text-center">
				<button type="reset" class="btn btn-secondary">초기화</button>
				<button type="submit" class="btn btn-primary">제출</button>
			</div>
		</form>
	</div>
	<p><br/></p>
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>