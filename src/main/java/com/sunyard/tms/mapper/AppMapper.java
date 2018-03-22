package com.sunyard.tms.mapper;

import com.sunyard.tms.dto.AppDto;
import com.sunyard.tms.entity.App;
import com.sunyard.tms.entity.AppExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppMapper {
    int countByExample(AppExample example);

    int deleteByExample(AppExample example);

    int deleteByPrimaryKey(String appId);

    int insert(App record);

    int insertSelective(App record);

    List<App> selectByExampleWithBLOBs(AppExample example);

    List<App> selectByExample(AppExample example);

    App selectByPrimaryKey(String appId);

    int updateByExampleSelective(@Param("record") App record, @Param("example") AppExample example);

    int updateByExampleWithBLOBs(@Param("record") App record, @Param("example") AppExample example);

    int updateByExample(@Param("record") App record, @Param("example") AppExample example);

    int updateByPrimaryKeySelective(App record);

    int updateByPrimaryKeyWithBLOBs(App record);

    int updateByPrimaryKey(App record);

    List<AppDto> findAllAppByPage(App app);
}