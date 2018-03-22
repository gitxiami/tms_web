package com.sunyard.tms.mapper;

import com.sunyard.tms.entity.PospParam;
import com.sunyard.tms.entity.PospParamExample;
import com.sunyard.tms.entity.PospParamKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PospParamMapper {
    int countByExample(PospParamExample example);

    int deleteByExample(PospParamExample example);

    int deleteByPrimaryKey(PospParamKey key);

    int insert(PospParam record);

    int insertSelective(PospParam record);

    List<PospParam> selectByExample(PospParamExample example);

    PospParam selectByPrimaryKey(PospParamKey key);

    int updateByExampleSelective(@Param("record") PospParam record, @Param("example") PospParamExample example);

    int updateByExample(@Param("record") PospParam record, @Param("example") PospParamExample example);

    int updateByPrimaryKeySelective(PospParam record);

    int updateByPrimaryKey(PospParam record);
}