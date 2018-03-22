package com.sunyard.tms.mapper;

import com.sunyard.tms.entity.DeviceAppParaTpdu;
import com.sunyard.tms.entity.DeviceAppParaTpduExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceAppParaTpduMapper {
    int countByExample(DeviceAppParaTpduExample example);

    int deleteByExample(DeviceAppParaTpduExample example);

    int deleteByPrimaryKey(String tpduId);

    int insert(DeviceAppParaTpdu record);

    int insertSelective(DeviceAppParaTpdu record);

    List<DeviceAppParaTpdu> selectByExample(DeviceAppParaTpduExample example);

    DeviceAppParaTpdu selectByPrimaryKey(String tpduId);

    int updateByExampleSelective(@Param("record") DeviceAppParaTpdu record, @Param("example") DeviceAppParaTpduExample example);

    int updateByExample(@Param("record") DeviceAppParaTpdu record, @Param("example") DeviceAppParaTpduExample example);

    int updateByPrimaryKeySelective(DeviceAppParaTpdu record);

    int updateByPrimaryKey(DeviceAppParaTpdu record);
}