package kr.co.ch05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch05.service.User1Service;
import kr.co.ch05.vo.User1VO;

@Controller
public class User1Controller {
	@Autowired
	private User1Service service;

	@GetMapping("/user1/list")
	public String list(Model model) {
		List<User1VO> users = service.selectUser1s();
		
		model.addAttribute("users", users); // users만 argument로 주면(=이름 지정안하면) 이름이 없어서 자료형을 view에 넘겨 줌 => 이름 지정해야 함
		
		return "/user1/list";
	}
	
	@GetMapping("/user1/register")
	public String register() {
		return "/user1/register";
	}
	
	@PostMapping("/user1/register")
	public String register(User1VO vo) {
		service.insertUser1(vo);
		
		return "redirect:/user1/list";
	}
	
	@GetMapping("/user1/modify")
	public String modify(Model model, String uid) { // list에서 들어올 때 uid parameter로 들고옮 => uid를 modify의 argument로
		User1VO user = service.selectUser1(uid);
		model.addAttribute("user", user);
		
		return "/user1/modify";
	}
	
	@PostMapping("/user1/modify")
	public String modify(User1VO vo) { 
		service.updateUser1(vo);
		
		return "redirect:/user1/list";
	}
	
	@GetMapping("/user1/delete")
	public String delete(String uid) {
		service.deleteUser1(uid);
		
		return "redirect:/user1/list";
	}
}
