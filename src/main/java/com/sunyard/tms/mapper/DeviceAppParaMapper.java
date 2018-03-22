package com.sunyard.tms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sunyard.tms.entity.DeviceAppPara;
import com.sunyard.tms.entity.DeviceAppParaExample;
import com.sunyard.tms.entity.DeviceAppParaKey;

public interface DeviceAppParaMapper {
    int countByExample(DeviceAppParaExample example);

    int deleteByExample(DeviceAppParaExample example);

    int deleteByPrimaryKey(DeviceAppParaKey key);

    int insert(DeviceAppPara record);

    int insertSelective(DeviceAppPara record);

    List<DeviceAppPara> selectByExample(DeviceAppParaExample example);

    DeviceAppPara selectByPrimaryKey(DeviceAppParaKey key);

    int updateByExampleSelective(@Param("record") DeviceAppPara record, @Param("example") DeviceAppParaExample example);

    int updateByExample(@Param("record") DeviceAppPara record, @Param("example") DeviceAppParaExample example);

    int updateByPrimaryKeySelective(DeviceAppPara record);

    int updateByPrimaryKey(DeviceAppPara record);
}