package com.king.spring1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.king.spring1.mapper.SysPermissionMapper;
import com.king.spring1.model.SysPermission;
import com.king.spring1.utils.Menu;

/**
 * @author duanyong
 * 2019年3月19日 上午9:14:35
 */
@Service
public class SysPermissionService {

	@Autowired
	private SysPermissionMapper sysPermissionMapper;
	
	public List<Menu> getMenuList(){
		List<SysPermission> permissions = sysPermissionMapper.selectAll();
		List<Menu> menus=new ArrayList<>();
		for (int i = 0; i < permissions.size(); i++) {
			if(i==0) {
				menus.add(new Menu(permissions.get(i).getUrl(),permissions.get(i).getId()+"",permissions.get(i).getName(), "icon-sum", "close",new ArrayList<Menu>()));
			}else {
				if(addMenu(menus,permissions.get(i))) {
					menus.add(new Menu(permissions.get(i).getUrl(),permissions.get(i).getId()+"",permissions.get(i).getName(), "icon-sum", "close",new ArrayList<Menu>()));
				}
			}
			
		}
		return menus;
	}
	
	public boolean addMenu(List<Menu> menus,SysPermission permission) {
		for (Menu menu : menus) {
			if(menu.getMenuNo().equals(permission.getParentid().intValue()+"")) {
				menu.getChildren().add(new Menu(permission.getUrl(),permission.getId()+"",permission.getName(), "icon-sum", "close",new ArrayList<Menu>()));
				return false;
			}else {
				if(!addMenu(menu.getChildren(), permission)) return false;
			}
		}
		return true;
	}
	
}
