package com.king.spring1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.king.spring1.mapper.SysUserMapper;
import com.king.spring1.model.SysUser;
import com.king.spring1.utils.PageResult;
import com.king.spring1.utils.SequenceUtil;

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
		PageResult<SysUser> res=new PageResult<>();
		Page<SysUser> pages= PageHelper.offsetPage((page-1)*rows, rows,true).doSelectPage(() -> sysUserMapper.selectAll());
		res.setRows(pages.getResult());
		res.setTotal(pages.getTotal());
		return res;
	}

	public int addUser(SysUser sysUser) {
		sysUser.setId(SequenceUtil.createSequence("USER"));
		sysUser.setSalt("");
		return sysUserMapper.insert(sysUser);
	}
	
	public int updateUser(SysUser sysUser) {
		return sysUserMapper.updateByPrimaryKey(sysUser);
	}
	
	public int delUser(String id) {
		return sysUserMapper.deleteByPrimaryKey(id);
	}
}
