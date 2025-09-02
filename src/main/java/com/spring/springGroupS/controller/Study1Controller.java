package com.spring.springGroupS.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.springGroupS.vo.HoewonVO;

@Controller
@RequestMapping("/study1")
public class Study1Controller {
	
	// QueryString 방식을 통한 값의 전달
	//@RequestMapping(value = "/study1/mapping/test1", method = RequestMethod.GET)
	@GetMapping("/mapping/menu")
	private String menuGet() {
		return "/study1/mapping/menu";
	}
	
	@GetMapping("/mapping/test1")
	private String test1Get(HttpServletRequest request) {
		String mid = request.getParameter("mid");
		String pwd = request.getParameter("pwd");
		
		request.setAttribute("mid", mid);
		request.setAttribute("pwd", pwd);
		
		return "/study1/mapping/test1";
	}
	
	@GetMapping("/mapping/test2")
	private String test2Get(Model model, String mid, String pwd) {
		model.addAttribute("mid", mid);
		model.addAttribute("pwd", pwd);
		
		return "/study1/mapping/test2";
	}
	
	@GetMapping("/mapping/test3")
	private String test3Get(Model model, 
			@RequestParam(name="mid") String id, 
			@RequestParam(name="pwd") String passwd
		) {
		model.addAttribute("mid", id);
		model.addAttribute("pwd", passwd);
		
		return "/study1/mapping/test3";
	}
	
	@GetMapping("/mapping/test4")
	private String test4Get(Model model, 
			@RequestParam(name="mid") String id, 
			@RequestParam(name="pwd") String passwd,
			@RequestParam(name="name", defaultValue = "손님", required = false) String name,
			@RequestParam(name="sex") int sex
		) {
		
		String gender = "";
		if(sex == 1 || sex == 3) gender = "남자";
		else if(sex == 2 || sex == 4) gender = "여자";
		else gender = "중성";
		
		model.addAttribute("mid", id);
		model.addAttribute("pwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		
		return "/study1/mapping/test4";
	}
	
	@GetMapping("/mapping/test5")
	private String test5Get(Model model, String mid, String pwd, String gender, String name, int age) {
		model.addAttribute("mid", mid);
		model.addAttribute("pwd", pwd);
		model.addAttribute("gender", gender);
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "/study1/mapping/test5";
	}
	
	@GetMapping("/mapping/test6")
	private String test6Get(Model model, String mid, String pwd, String gender, String name, int age) {
		HoewonVO vo = new HoewonVO();
		
		vo.setMid(mid);
		vo.setPwd(pwd);
		vo.setName(name);
		vo.setGender(gender);
		vo.setAge(age);
		
		model.addAttribute("vo", vo);
		return "/study1/mapping/test6";
	}
	
	@GetMapping("/mapping/test7")
	private String test7Get(Model model, String mid, String pwd, String gender, String name, int age, HoewonVO vo) {
		//HoewonVO vo = new HoewonVO();
		
		vo.setMid(mid);
		vo.setPwd(pwd);
		vo.setName(name);
		vo.setGender(gender);
		vo.setAge(age);
		
		model.addAttribute("vo", vo);
		return "/study1/mapping/test7";
	}

	@GetMapping("/mapping/test8")
	private String test8Get(Model model, HoewonVO vo) {
		
		model.addAttribute("vo", vo);
		return "/study1/mapping/test8";
	}
	
	@GetMapping("/mapping/test9")
	private ModelAndView test9Get(HoewonVO vo) {
		ModelAndView mv = new ModelAndView("/study1/mapping/test9");
		mv.addObject("vo", vo);
		return mv;
	}
	
	/* ---------------------------------------------------------------- */
	// Path Variable방식으로의 값전달연습
	@GetMapping("/mapping/test21/{mid}/{pwd}")
	private String test21Get(Model model, @PathVariable String mid,@PathVariable String pwd) {
		model.addAttribute("mid", mid);
		model.addAttribute("pwd", pwd);
		
		return "/study1/mapping/test21";
	}
	
	//Path Variable방식으로의 값전달연습
	@GetMapping("/mapping/test22/{id}/{passwd}")
	private String test22Get(Model model, @PathVariable String id,@PathVariable String passwd) {
		model.addAttribute("mid", id);
		model.addAttribute("pwd", passwd);
		
		return "/study1/mapping/test22";
	}
	
	//Path Variable방식으로의 값전달연습
	@GetMapping("/mapping/{passwd}/test23/{id}")
	private String test23Get(Model model, @PathVariable String id,@PathVariable String passwd) {
		model.addAttribute("mid", id);
		model.addAttribute("pwd", passwd);
		
		return "/study1/mapping/test23";
	}
	
	//Path Variable방식으로의 값전달연습
	@GetMapping("/mapping/{passwd}/{temp}/test24/{id}")
	private String test24Get(Model model, @PathVariable String id,@PathVariable String temp,@PathVariable String passwd) {
		model.addAttribute("mid", id);
		model.addAttribute("pwd", passwd);
		
		return "/study1/mapping/test24";
	}
	
	//Path Variable방식으로의 값전달연습
	@GetMapping("/mapping/test25/{mid}/{pwd}/{name}/{gender}/{age}")
	private String test25Get(Model model, HoewonVO vo) {
		model.addAttribute("vo",vo);
		
		return "/study1/mapping/test25";
	}
	
	/* ---------------------------------------------------------------- */
	// Post방식에 의한 값의 전달
	//@GetMapping("/mapping/test31")
	//@RequestMapping(value = "/mapping/test31", method = RequestMethod.POST)
	@PostMapping("/mapping/test31")
	private String test31Post(Model model, HoewonVO vo,
		String mid,
		String pwd,
		String name,
		String strGender,
		int age,
		String nickName
		) {
		
		vo.setMid(mid);
		vo.setPwd(pwd);
		vo.setName(name);
		vo.setGender(strGender);
		vo.setAge(age);
		vo.setNickName(nickName);
		
		model.addAttribute("vo",vo);
		return "/study1/mapping/test31";
	}
	
	@PostMapping("/mapping/test32")
	private String test32Post(Model model, HoewonVO vo) {
		
		model.addAttribute("vo",vo);
		return "/study1/mapping/test32";
	}
	
	@GetMapping("/mapping/test33")
	private String test33Get(Model model, String mid) {
		// 아이디로 DB에서 회원정보를 가져와서 VO에 담아서 jsp로 넘겨준다.
		//model.addAttribute("vo",vo);
		model.addAttribute("mid", mid);
		return "/study1/mapping/test33";
	}
	@PostMapping("/mapping/test33")
	private String test33Post(Model model, HoewonVO vo) {
		// DB에 회원정보를 저장시킨다.(회원가입처리)
		
		// 회원 가입 후 메세지 처리한다.
		model.addAttribute("message", vo.getMid() + "님 회원 가입 되었습니다.");
		model.addAttribute("url","/study1/mapping/test33?mid="+vo.getMid());
//		model.addAttribute("url","/study1/mapping/test33?mid=");
//		model.addAttribute("mid",vo.getMid());
		return "include/message";
	}
	
	@GetMapping("/mapping/test34")
	private String test34Get(Model model, HoewonVO vo) {
		model.addAttribute("vo",vo);
		return "/study1/mapping/test34";
	}
	@PostMapping("/mapping/test34")
	private String test34Post(Model model, HoewonVO vo) {
		model.addAttribute("message","회원 가입 되었습니다.");
		model.addAttribute("url","/study1/mapping/test34");
		
		model.addAttribute("vo",vo);
		return "include/message";
	}
}
