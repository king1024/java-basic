package com.king.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.king.ssm.model.UserInfo;
import com.king.ssm.service.TestService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private TestService testService;

	@RequestMapping("/test")
	public String test() {

		System.out.println("=================================test111");
		List<UserInfo> users = testService.getUsers(null);
		for (UserInfo userInfo : users) {
			System.out.println(userInfo);
		}
		System.out.println("=================================test222");
		return "test";
	}
}
