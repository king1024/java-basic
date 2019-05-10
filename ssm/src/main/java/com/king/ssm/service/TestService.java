package com.king.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.king.ssm.mapper.UserInfoMapper;
import com.king.ssm.model.UserInfo;

@Service
public class TestService {
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	public List<UserInfo> getUsers(UserInfo users){
		return userInfoMapper.getUsers(users);
	}

}
