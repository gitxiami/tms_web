package com.sunyard.tms.mapper;

import com.sunyard.tms.entity.DeviceGroup;
import com.sunyard.tms.entity.DeviceGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceGroupMapper {
    int countByExample(DeviceGroupExample example);

    int deleteByExample(DeviceGroupExample example);

    int deleteByPrimaryKey(String groupId);

    int insert(DeviceGroup record);

    int insertSelective(DeviceGroup record);

    List<DeviceGroup> selectByExample(DeviceGroupExample example);

    DeviceGroup selectByPrimaryKey(String groupId);

    int updateByExampleSelective(@Param("record") DeviceGroup record, @Param("example") DeviceGroupExample example);

    int updateByExample(@Param("record") DeviceGroup record, @Param("example") DeviceGroupExample example);

    int updateByPrimaryKeySelective(DeviceGroup record);

    int updateByPrimaryKey(DeviceGroup record);

	List<DeviceGroup> queryForList(DeviceGroup deviceGroup);
}