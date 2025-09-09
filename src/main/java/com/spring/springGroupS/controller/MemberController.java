package com.spring.springGroupS.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	//MemberService memberService;
	
	// 로그인 폼
	@GetMapping("/memberLogin")
	public String memberLoginGet() {
		return "member/memberLogin";
	}
	
  // 로그인 처리하기
	@PostMapping("/memberLogin")
	public String memberLoginPost(HttpSession session,
			@RequestParam(name="mid", defaultValue = "hkd1234", required = false) String mid,
			@RequestParam(name="pwd", defaultValue = "1234", required = false) String pwd,
			@RequestParam(name="idSave", defaultValue = "on", required = false) String idSave
		) {
		//  로그인 인증처리(스프링 시큐리티의 BCryptPasswordEncoder객체를 이용한 암호화되어 있는 비밀번호 비교하기)
		//MemberVO vo = memberService.getMemberIdCheck(mid);
		
		//if() {
			// 로그인 인증완료시 처리할 부분(1.세션, 2.쿠키, 3.기타 설정값....)
			// 1.세션처리
			
			
			// 2.쿠키 저장/삭제
			
			
			// 3. 기타처리(DB에 처리해야할것들(방문카운트, 포인트,... 등)
			// 3-1. 기타처리 : 오늘 첫방문이면 todayCnt = 0
			
			
			// 3-2. 기타처리 : 방문카운트로 10포인트 증정(단, 1일 50포인트까지만 제한처리)
			
			
			// 방문카운트
			
			
			return "redirect:/message/memberLoginOk?mid="+mid;
		//}
		//else {
			//return "redirect:/message/memberLoginNo";
		//}
	}
	
	// 로그아웃 처리
	@GetMapping("/memberLogout")
	public String memberLogoutGet(HttpSession session) {
		String mid = (String) session.getAttribute("sMid");
		session.invalidate();
		
		return "redirect:/message/memberLogout?mid="+mid;
	}
	
	// 회원 가입폼 보여주기
	@GetMapping("/memberJoin")
	public String memberJoinGet() {
		return "member/memberJoin";
	}
	
}
