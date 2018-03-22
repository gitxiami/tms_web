package com.sunyard.tms.mapper;

import com.sunyard.tms.entity.DeviceLog;
import com.sunyard.tms.entity.DeviceLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceLogMapper {
    int countByExample(DeviceLogExample example);

    int deleteByExample(DeviceLogExample example);

    int deleteByPrimaryKey(String deviceLogId);

    int insert(DeviceLog record);

    int insertSelective(DeviceLog record);

    List<DeviceLog> selectByExample(DeviceLogExample example);

    DeviceLog selectByPrimaryKey(String deviceLogId);

    int updateByExampleSelective(@Param("record") DeviceLog record, @Param("example") DeviceLogExample example);

    int updateByExample(@Param("record") DeviceLog record, @Param("example") DeviceLogExample example);

    int updateByPrimaryKeySelective(DeviceLog record);

    int updateByPrimaryKey(DeviceLog record);
}