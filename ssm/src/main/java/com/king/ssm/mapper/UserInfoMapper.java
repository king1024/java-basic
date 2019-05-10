package com.king.ssm.mapper;

import java.util.List;

import com.king.ssm.model.UserInfo;

public interface UserInfoMapper {

	public List<UserInfo> getUsers(UserInfo users);
}
