package com.sunyard.tms.mapper;

import com.sunyard.tms.entity.AppArea;
import com.sunyard.tms.entity.AppAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppAreaMapper {
    int countByExample(AppAreaExample example);

    int deleteByExample(AppAreaExample example);

    int deleteByPrimaryKey(String appAreaId);

    int insert(AppArea record);

    int insertSelective(AppArea record);

    List<AppArea> selectByExample(AppAreaExample example);

    AppArea selectByPrimaryKey(String appAreaId);

    int updateByExampleSelective(@Param("record") AppArea record, @Param("example") AppAreaExample example);

    int updateByExample(@Param("record") AppArea record, @Param("example") AppAreaExample example);

    int updateByPrimaryKeySelective(AppArea record);

    int updateByPrimaryKey(AppArea record);
}