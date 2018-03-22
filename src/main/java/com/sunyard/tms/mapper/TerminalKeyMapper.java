package com.sunyard.tms.mapper;

import com.sunyard.tms.entity.Device;
import com.sunyard.tms.entity.TerminalKey;
import com.sunyard.tms.entity.TerminalKeyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TerminalKeyMapper {
    int countByExample(TerminalKeyExample example);

    int deleteByExample(TerminalKeyExample example);

    int deleteByPrimaryKey(String keyId);

    int insert(TerminalKey record);

    int insertSelective(TerminalKey record);

    List<TerminalKey> selectByExample(TerminalKeyExample example);

    TerminalKey selectByPrimaryKey(String keyId);

    int updateByExampleSelective(@Param("record") TerminalKey record, @Param("example") TerminalKeyExample example);

    int updateByExample(@Param("record") TerminalKey record, @Param("example") TerminalKeyExample example);

    int updateByPrimaryKeySelective(TerminalKey record);

    int updateByPrimaryKey(TerminalKey record);

	List<TerminalKey> queryDevKey(String devSn);
}