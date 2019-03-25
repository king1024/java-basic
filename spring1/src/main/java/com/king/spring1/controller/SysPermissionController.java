package com.king.spring1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.king.spring1.service.SysPermissionService;
import com.king.spring1.utils.Menu;

/**
 * @author duanyong
 * 2019年3月19日 上午9:12:08
 */
@Controller
@RequestMapping("/sys_permission")
public class SysPermissionController {
	
	@Autowired
	private SysPermissionService sysPermissionService;
	
	@RequestMapping("/menuList")
	@ResponseBody
	public List<Menu> list() {
		return sysPermissionService.getMenuList();
	}
	
}
