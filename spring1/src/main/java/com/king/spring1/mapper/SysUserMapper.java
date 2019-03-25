package com.king.spring1.mapper;

import com.king.spring1.model.SysUser;
import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    SysUser selectByPrimaryKey(String id);

    List<SysUser> selectAll();

    int updateByPrimaryKey(SysUser record);

    List<SysUser> selectUser(SysUser record);
}