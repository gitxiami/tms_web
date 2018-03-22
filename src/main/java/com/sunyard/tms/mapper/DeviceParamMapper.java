package com.sunyard.tms.mapper;

import com.sunyard.tms.entity.DeviceParam;
import com.sunyard.tms.entity.DeviceParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceParamMapper {
    int countByExample(DeviceParamExample example);

    int deleteByExample(DeviceParamExample example);

    int deleteByPrimaryKey(String paramId);

    int insert(DeviceParam record);

    int insertSelective(DeviceParam record);

    List<DeviceParam> selectByExample(DeviceParamExample example);

    DeviceParam selectByPrimaryKey(String paramId);

    int updateByExampleSelective(@Param("record") DeviceParam record, @Param("example") DeviceParamExample example);

    int updateByExample(@Param("record") DeviceParam record, @Param("example") DeviceParamExample example);

    int updateByPrimaryKeySelective(DeviceParam record);

    int updateByPrimaryKey(DeviceParam record);
}