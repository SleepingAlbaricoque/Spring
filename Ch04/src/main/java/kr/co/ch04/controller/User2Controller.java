package kr.co.ch04.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch04.vo.User2VO;

@Controller
public class User2Controller {

	@GetMapping("/user2/register")
	public String register() {
		return "/user2/register";
	}
	
	@PostMapping("/user2/register")
	public String register(Model model, User2VO vo) {
		model.addAttribute(vo); // 이름은 지어도 됨 model.addAttribute("user2", vo); 지금처럼 안 지으면 argument로 들어간 자료형이 곧 이름
		
		return "/user2/result";
	}
}
