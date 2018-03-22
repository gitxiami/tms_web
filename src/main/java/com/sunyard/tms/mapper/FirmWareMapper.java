package com.sunyard.tms.mapper;

import com.sunyard.tms.entity.FirmWare;
import com.sunyard.tms.entity.FirmWareExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FirmWareMapper {
    int countByExample(FirmWareExample example);

    int deleteByExample(FirmWareExample example);

    int deleteByPrimaryKey(String firmId);

    int insert(FirmWare record);

    int insertSelective(FirmWare record);

    List<FirmWare> selectByExample(FirmWareExample example);

    FirmWare selectByPrimaryKey(String firmId);

    int updateByExampleSelective(@Param("record") FirmWare record, @Param("example") FirmWareExample example);

    int updateByExample(@Param("record") FirmWare record, @Param("example") FirmWareExample example);

    int updateByPrimaryKeySelective(FirmWare record);

    int updateByPrimaryKey(FirmWare record);
}