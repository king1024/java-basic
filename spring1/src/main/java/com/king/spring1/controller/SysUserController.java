package com.king.spring1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.king.spring1.model.SysUser;
import com.king.spring1.service.SysUserService;
import com.king.spring1.utils.PageResult;

/**
 * @author duanyong
 * 2019年2月19日 下午3:56:34
 */
@Controller
@RequestMapping("/sys_user")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;

	@RequestMapping("/login")
	public String login(SysUser sysUser,Model model) {
		int status = sysUserService.login(sysUser);
		System.out.println("login res="+status);
		if (status==1) {
			return "main";
		}else if(status==0) {
			model.addAttribute("sysUser", sysUser);
			model.addAttribute("msg", "用戶名或密码错误");
			return "login";
		}else {
			model.addAttribute("sysUser", sysUser);
			model.addAttribute("msg", "数据异常");
			return "login";
		}
	}
	
	@RequestMapping("/userList")
	@ResponseBody
	public PageResult<SysUser> list(int page,int rows) {
		return sysUserService.findAll(page, rows);
	}
	
	
}
