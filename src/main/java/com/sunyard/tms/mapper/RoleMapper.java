package com.sunyard.tms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sunyard.tms.entity.Role;
import com.sunyard.tms.entity.RoleExample;

public interface RoleMapper {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(String roleId);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(String roleId);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<String> queryRolePopedomByRoleId(String roleId);
	
	List<String> queryPopedomById(String roleId);

	int addPopedom(Role in);

	int deletePopedomById(Role de);
}