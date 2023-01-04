package kr.co.ch04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class User1Controller {
	
	@GetMapping("/user1/register")
	public String register() {
		return "/user1/register";
	}
	
	@PostMapping("/user1/register")
	public String register(Model model, HttpServletRequest req, String uid, String name, int age, String hp) { // 매개변수 순서 상관 x
		
		/* JSP 방식
		String uid = req.getParameter("uid");
		System.out.println("uid: " + uid);
		*/
		
		System.out.println("uid :" + uid); // 메서드에 argument로 넣어주기만 하면 Front Controller가 알아서 처리
		System.out.println("name: " + name);
		System.out.println("age: " + age); // getParameter()하면 무조건 String으로 넘어오지만 이것 역시 Front Controller가 argument 자료형에 따라서 알아서 int로 변환
		System.out.println("hp: " + hp);
		
		model.addAttribute("uid", uid);
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("hp", hp);
		
		return "/user1/result";
	}
}
