package com.sunyard.tms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sunyard.tms.entity.App;
import com.sunyard.tms.entity.AppPackage;
import com.sunyard.tms.entity.AppPackageExample;
import com.sunyard.tms.entity.AppPackageKey;

public interface AppPackageMapper {
	int countByExample(AppPackageExample example);

	int deleteByExample(AppPackageExample example);

	int deleteByPrimaryKey(AppPackageKey key);

	int insert(AppPackage record);

	int insertSelective(AppPackage record);

	List<AppPackage> selectByExample(AppPackageExample example);

	AppPackage selectByPrimaryKey(AppPackageKey key);

	int updateByExampleSelective(@Param("record") AppPackage record, @Param("example") AppPackageExample example);

	int updateByExample(@Param("record") AppPackage record, @Param("example") AppPackageExample example);

	int updateByPrimaryKeySelective(AppPackage record);

	int updateByPrimaryKey(AppPackage record);

	List<App> selectLatestVersionApp(@Param("devSn") String devSn, @Param("appId") String appId,
			@Param("appName") String appName, @Param("orgId") String orgId);
}