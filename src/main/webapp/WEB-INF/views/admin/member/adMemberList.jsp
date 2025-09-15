<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <jsp:include page="/WEB-INF/views/include/bs5.jsp" />
  <title>adMemberList.jsp</title>
  <script>
    'use strict';
    
    // 등급별 보여주기
    function levelItemCheck() {
    	let level = $("#levelItem").val();
    	location.href = "adMemberList?level="+level;
    }
    
    // 등급 변경처리
    function levelChange(e) {
			let ans = confirm("선택한 회원의 등급을 변경하시겠습니까?");
			if(!ans) {
				location.reload();
				return false;
			}

			let items = e.value.split("/");
			let query = {
					level : items[0],
					idx : items[1]
			}
			$.ajax({
				url : '${ctp}/admin/member/memberLevelChange',
				type : 'post',
				data : query,
				success : (res) => {
					if(res != "0") {
						alert("등급 수정 완료!!");
						location.reload();
					}
					else alert("등급 수정 실패~~");
				},
				error : () => alert("전송오류")
			});
		} 
 		// 전체선택
    function allCheck() {
      for(let i=0; i<myform.idxFlag.length; i++) {
        //myform.idxFlag[i].checked = true;
        if(!myform.idxFlag[i].disabled) myform.idxFlag[i].checked = true;
      }
    }

    // 전체취소
    function allReset() {
      for(let i=0; i<myform.idxFlag.length; i++) {
        myform.idxFlag[i].checked = false;
      }
    }

    // 선택반전
    function reverseCheck() {
      for(let i=0; i<myform.idxFlag.length; i++) {
    	  if(!myform.idxFlag[i].disabled) {
    			myform.idxFlag[i].checked = !myform.idxFlag[i].checked;
    	  }
      }
    }
    // 페이징처리
    $(() => {
        $('#pageSizeItem select').on('change', function() {
            const pageSize = $(this).val();
            const level = $('#levelItem').val();
            location.href = '${ctp}/admin/member/adMemberList?pag=1&pageSize=' + pageSize + '&level='+level;
        })
    });
    // 여러게 선택항목에 대한 등급변경처리
    function levelSelectCheck() {
    	let ans = confirm("선택한 회원의 등급을 변경하시겠습니까?");
    	if(!ans) return false;
    	
    	let select = document.getElementById("levelSelect");
    	let levelSelectText = select.options[select.selectedIndex].text;
    	let levelSelect = select.options[select.selectedIndex].value;
    	
    	let idxSelectArray = '';
    	for(let i=0; i<myform.idxFlag.length; i++) {
    		if(myform.idxFlag[i].checked) idxSelectArray += myform.idxFlag[i].value + "/";
    	}
    	
    	if(idxSelectArray == '') {
    		alert("등급을 변경할 항목을 1개 이상 선택하세요");
    		return false;
    	}
    	
    	idxSelectArray = idxSelectArray.substring(0, idxSelectArray.lastIndexOf("/"));
    	let query = {
    			idxSelectArray : idxSelectArray,		
    			levelSelect : levelSelect
    	}
    	$.ajax({
			url : '${ctp}/admin/member/memberLevelSelectChange',
			type : 'post',
			data : query,
			success : (res) => {
				if(res != 0) {
					alert("선택한 항목들이 " + levelSelectText + " 등급으로 수정 완료!!");
					location.reload();
				}
				else alert("등급 수정 실패~~");
			},
			error : () => alert("전송오류")
		});
    }
  </script>
</head>
<body>
<p><br/></p>
<div class="container">
  <h2 class="text-center mb-3">회 원 리 스 트</h2>
  <div class="row mb-2">
    <div class="col">
      <select name="levelItem" id="levelItem" onchange="levelItemCheck()">
        <option value="99"  ${level == 99  ? 'selected' : ''}>전체회원</option>
        <option value="1"   ${level == 1   ? 'selected' : ''}>우수회원</option>
        <option value="2"   ${level == 2   ? 'selected' : ''}>정회원</option>
        <option value="3"   ${level == 3   ? 'selected' : ''}>준회원</option>
        <option value="999" ${level == 999 ? 'selected' : ''}>탈퇴신청회원</option>
        <option value="0"   ${level == 0   ? 'selected' : ''}>관리자</option>
      </select>
    </div>
    <!-- 페이징처리 -->
    <div class="col text-end mb-3" id="pageSizeItem">
        <select name="pageSize" >
            <option value="5" <c:if test="${pageSize == 5}">selected</c:if>>5개씩 보기</option>
            <option value="10" <c:if test="${pageSize == 10}">selected</c:if>>10개씩 보기</option>
            <option value="15" <c:if test="${pageSize == 15}">selected</c:if>>15개씩 보기</option>
            <option value="20" <c:if test="${pageSize == 20}">selected</c:if>>20개씩 보기</option>
        </select>
    </div>
    <div class="input-group">
	    <input type="button" value="전체선택" onclick="allCheck()" class="btn btn-success btn-sm mr-1"/>
	    <input type="button" value="전체취소" onclick="allReset()" class="btn btn-primary btn-sm mr-1"/>
	    <input type="button" value="선택반전" onclick="reverseCheck()" class="btn btn-info btn-sm mr-1"/>
	    <!-- 레벨체크 -->
    	<select name="levelSelect" id="levelSelect" class="form-select">
    		<option value="2" selected>정회원</option>
    		<option value="3">준회원</option>
    		<option value="1">우수회원</option>
    	</select>
    	<input type="button" value="선택항목등급변경" onclick="levelSelectCheck()" class="btn btn-warning btn-sm"/>
	  </div>
  </div>
  <form name="myform">
	  <table class="table table-hover text-center">
	    <tr class="table-secondary">
	      <th>번호</th>
	      <th>아이디</th>
	      <th>닉네임</th>
	      <th>성명</th>
	      <th>생일</th>
	      <th>생별</th>
	      <th>최종방문일</th>
	      <th>오늘방문횟수</th>
	      <th>활동여부</th>
	      <th>회원등급</th>
	    </tr>
	    <c:forEach var="vo" items="${vos}" varStatus="st">
	      <tr>
	        <td>
	        	<c:if test="${vo.level != 0}"><input type="checkbox" name="idxFlag" id="idxFlag${vo.idx}" value="${vo.idx}" /></c:if>
	        	<c:if test="${vo.level == 0}"><input type="checkbox" name="idxFlag" id="idxFlag${vo.idx}" value="${vo.idx}" disabled /></c:if>
	       	 	${vo.idx}
	        </td>
	        <td>${vo.mid}</td>
	        <td>${vo.nickName}</td>
	        <td>${vo.name}</td>
	        <td>${fn:substring(vo.birthday,0,10)}</td>
	        <td>${vo.gender}</td>
	        <td>${fn:substring(vo.lastDate,0,16)}</td>
	        <td>${vo.todayCnt}</td>
	        <td>
	          <c:if test="${vo.userDel == 'NO'}">활동중</c:if>
	          <c:if test="${vo.userDel == 'OK'}">탈퇴신청중</c:if>
	        </td>
	        <td>
	          <select name="level" id="level" onchange="levelChange(this)">
	            <option value="1/${vo.idx}" ${vo.level==1 ? 'selected' : ''}>우수회원</option>
	            <option value="2/${vo.idx}" ${vo.level==2 ? 'selected' : ''}>정회원</option>
	            <option value="3/${vo.idx}" ${vo.level==3 ? 'selected' : ''}>준회원</option>
	            <option value="0/${vo.idx}" ${vo.level==0 ? 'selected' : ''}>관리자</option>
	            <option value="999/${vo.idx}" ${vo.level==999 ? 'selected' : ''}>탈퇴신청회원</option>
	          </select>
	        </td>
	      </tr>
	    </c:forEach>
	  </table>
	</form>
</div>
<p><br/></p>
</body>
</html>