package com.king.spring1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.king.spring1.mapper.SysUserMapper;
import com.king.spring1.model.SysUser;
import com.king.spring1.utils.PageResult;

/**
 * @author duanyong
 * 2019年2月19日 下午3:48:55
 */
@Service
public class SysUserService {
	
	@Autowired
	private SysUserMapper sysUserMapper;

	public int login(SysUser sysUser){
		List<SysUser> users = sysUserMapper.selectUser(sysUser);
		return users.size();
	}
	
	public PageResult<SysUser> findAll(int page,int rows){
//		List<SysUser> list = sysUserMapper.selectAll();
//		System.out.println(list.size());
		PageResult<SysUser> res=new PageResult<>();
		Page<SysUser> pages= PageHelper.offsetPage(1, 10,true).doSelectPage(() -> sysUserMapper.selectAll());
//		PageHelper.startPage(page, rows);
//		Page<SysUser> pages=new Page<>(list);
//		res.setRows(pages.getResult());
//		System.out.println(pages.getResult().size());
//		res.setPage(page);
//		res.setTotal(pages.getTotal());
//		return res;
		res.setRows(pages.getResult());
		res.setTotal(pages.getTotal());
		return res;
//		PageHelper.startPage(3, 3);
//		List<SysUser> list = sysUserMapper.selectAll();
//		PageInfo<SysUser> res=new PageInfo<>(list);
//		System.out.println(res);
//		System.out.println(res.getList());
//		System.out.println(res.getList().size());
//		return res.getList();
	}
}
