package com.spring.springGroupS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.springGroupS.common.Pagination;
import com.spring.springGroupS.service.AdminService;
import com.spring.springGroupS.service.MemberService;
import com.spring.springGroupS.vo.ComplaintVO;
import com.spring.springGroupS.vo.MemberVO;
import com.spring.springGroupS.vo.PageVO;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	Pagination pagination;
	
		
	@GetMapping("/adminMain")
	public String adminMainGet() {
		return "admin/adminMain";
	}
	
	@GetMapping("/adminLeft")
	public String adminLeftGet() {
		return "admin/adminLeft";
	}
	
	@GetMapping("/adminContent")
	public String adminContentGet() {
		return "admin/adminContent";
	}
	
	@GetMapping("/member/adMemberList")
	public String adMemberListGet(Model model,
			@RequestParam(name="pag", defaultValue = "1", required = false) int pag,
			@RequestParam(name="pageSize", defaultValue = "10", required = false) int pageSize,
			@RequestParam(name="level", defaultValue = "99", required = false) int level
		) {
		// 페이징 처리하기
		
		List<MemberVO> vos = memberService.getMemberList(0, pageSize, level);
		model.addAttribute("vos", vos);
		model.addAttribute("level", level);
		return "admin/member/adMemberList";
	}
	
	//  회원 등급 변경처리
	@ResponseBody
	@PostMapping("/member/memberLevelChange")
	public String memberLevelChangePost(int idx, int level) {
		return adminService.setMemberLevelChange(idx, level) + ""; //"" 문자로 변환
	}

	// 선택한 회원들 등급변경 처리
	@ResponseBody
	@PostMapping("/member/memberLevelSelectChange")
	public int memberLevelSelectChangePost(String idxSelectArray, int levelSelect) {
		return adminService.setmemberLevelSelectChange(idxSelectArray, levelSelect); 
	}
	
	// 신고리스트 보기
	@GetMapping("/complaint/complaintList")
	public String complaintListGet(Model model, PageVO pageVO) {
		pageVO.setSection("complaint");
		pageVO = pagination.pagination(pageVO);
		List<ComplaintVO> vos = adminService.getComplaintList(pageVO.getStartIndexNo(), pageVO.getPageSize());
		
		model.addAttribute("vos", vos);
		
		return "admin/complaint/complaintList";
	}
	
	// 신고 상세 내역 보기
	@GetMapping("/complaint/complaintContent")
	public String complaintContentGet(Model model, int partIdx) {
		ComplaintVO vo = adminService.getComplaintSearch(partIdx);
		model.addAttribute("vo", vo);
		return "admin/complaint/complaintContent";
	}
	
	// 신고내역자료 '취소/감추기/삭제'
	@ResponseBody
	@PostMapping("/complaint/complaintProcess")
	public int complaintProcessPost(ComplaintVO vo) {
		int res = 0;
		if(vo.getComplaintSw().equals("D")) {
			res = adminService.setComplaintDelete(vo.getPartIdx(), vo.getPart());
			vo.setComplaintSw("처리완료(D)");
		}
		else {
			if(vo.getComplaintSw().equals("H")) {
				res = adminService.setComplaintProcess(vo.getPartIdx(), "HI");
				vo.setComplaintSw("처리중(H)");
			}
			else {
				res = adminService.setComplaintProcess(vo.getPartIdx(), "NO");
				vo.setComplaintSw("처리중(S)");
			}
			if(res != 0) adminService.setComplaintProcessOk(vo.getIdx(), vo.getComplaintSw());
		}
		

		return res;
	}
}
