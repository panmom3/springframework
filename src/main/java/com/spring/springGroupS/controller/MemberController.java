package com.spring.springGroupS.controller;

import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.springGroupS.common.ProjectProvide;
import com.spring.springGroupS.service.MemberService;
import com.spring.springGroupS.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService memberService;

	@Autowired
	ProjectProvide projectProvide;
	
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
	
	// 아이디 중복체크처리
	@ResponseBody
	@PostMapping("/memberIdCheck")
	public MemberVO memberIdCheckPost(String mid) {
		return memberService.getMemberIdCheck(mid);
	}
	
	// 닉네임 중복체크처리
	@ResponseBody
	@PostMapping("/memberNickCheck")
	public MemberVO memberNickCheckPost(String nickName) {
		return memberService.getMemberNickCheck(nickName);
	}
	
	// 회원가입시 이메일로 인증번호 전송하기
	@ResponseBody
	@PostMapping("/memberEmailCheck")
	public int memberEmailCheckPost(String email, HttpSession session) throws MessagingException {
		String emailKey = UUID.randomUUID().toString().substring(0, 8);
		
		// 이메일 인증키를 세션에 저장시켜둔다.(2분안에 인증하지 않으면 다시 발행해야함...)
		session.setAttribute("sEmailKey", emailKey);
		
		projectProvide.mailSend(email, "이메일 인증키입니다.", "이메일 인증키 : " + emailKey);
		
		return 1;
	}
	
	// 회원가입시 이메일로 인증번호받은 인증키 확인하기
	@ResponseBody
	@PostMapping("/memberEmailCheckOk")
	public int memberEmailCheckOkPost(String checkKey, HttpSession session) {
		String emailKey = (String) session.getAttribute("sEmailKey");
		
		if(checkKey.equals(emailKey))  return 1;
		return 0;
	}
	
	
}
