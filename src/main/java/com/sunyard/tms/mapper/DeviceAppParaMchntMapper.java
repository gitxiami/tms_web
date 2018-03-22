package com.sunyard.tms.mapper;

import com.sunyard.tms.entity.DeviceAppParaMchnt;
import com.sunyard.tms.entity.DeviceAppParaMchntExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceAppParaMchntMapper {
    int countByExample(DeviceAppParaMchntExample example);

    int deleteByExample(DeviceAppParaMchntExample example);

    int deleteByPrimaryKey(String mchntId);

    int insert(DeviceAppParaMchnt record);

    int insertSelective(DeviceAppParaMchnt record);

    List<DeviceAppParaMchnt> selectByExample(DeviceAppParaMchntExample example);

    DeviceAppParaMchnt selectByPrimaryKey(String mchntId);

    int updateByExampleSelective(@Param("record") DeviceAppParaMchnt record, @Param("example") DeviceAppParaMchntExample example);

    int updateByExample(@Param("record") DeviceAppParaMchnt record, @Param("example") DeviceAppParaMchntExample example);

    int updateByPrimaryKeySelective(DeviceAppParaMchnt record);

    int updateByPrimaryKey(DeviceAppParaMchnt record);
}