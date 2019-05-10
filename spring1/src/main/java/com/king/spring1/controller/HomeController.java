package com.king.spring1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author duanyong
 * 2019年3月18日 上午11:26:48
 */
@Controller
public class HomeController {

	@RequestMapping("/main")
	public String main1(Model model ,boolean flag) {
		model.addAttribute("flag", flag);
		if(flag) {
			return "main";
		}else {
			return "main2";
		}
	}
	
	@RequestMapping("/loginPage")
	public String loginPage() {
		System.out.println("controller-----------------/loginPage");
		return "login";
	}

	@RequestMapping("/tab1")
	public String tab1() {
		return "tab1";
	}
	@RequestMapping("/tab2")
	public String tab2() {
		return "tab2";
	}
	@RequestMapping("/tab3")
	public String tab3() {
		return "tab3";
	}
	@RequestMapping("/top")
	public String top(Model model) {
		model.addAttribute("flag", true);
		return "top";
	}
	@RequestMapping("/menu")
	public String menu() {
		return "menu";
	}
	@RequestMapping("/firstPage")
	public String firstPage() {
		return "firstPage";
	}
	
	

	@RequestMapping("/userList")
	public String userList() {
		return "user/userList";
	}
	
	@RequestMapping("/loginOut")
	public String loginOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "login";
	}
}
