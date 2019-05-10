package com.king.spring1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String login(SysUser sysUser,Model model,HttpServletRequest request) {
		List<SysUser> users = sysUserService.findUser(sysUser);
		int status=users.size();
		if (status==1) {
			HttpSession session = request.getSession();
			session.setAttribute("user", users.get(0));
			SysUser user = (SysUser) session.getAttribute("user");
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
	
	@RequestMapping("/addUser")
	@ResponseBody
	public int addUser(SysUser sysUser) {
		return sysUserService.addUser(sysUser);
	}

	@RequestMapping("/updateUser")
	@ResponseBody
	public int updateUser(SysUser sysUser) {
		if(sysUser==null) return 0;
		if(StringUtils.isEmpty(sysUser.getId())) return 0;
		return sysUserService.updateUser(sysUser);
	}
	
	@RequestMapping("/delUser")
	@ResponseBody
	public int delUser(@RequestParam String id) {
		System.out.println("===================="+id);
		System.out.println(id);
		return sysUserService.delUser(id);
	}
	
	
}
