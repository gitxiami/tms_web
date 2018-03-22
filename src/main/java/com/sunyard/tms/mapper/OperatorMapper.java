package com.sunyard.tms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sunyard.tms.dto.OperatorDto;
import com.sunyard.tms.entity.Operator;
import com.sunyard.tms.entity.OperatorExample;

public interface OperatorMapper {
    int countByExample(OperatorExample example);

    int deleteByExample(OperatorExample example);

    int deleteByPrimaryKey(String opId);

    int insert(Operator record);

    int insertSelective(Operator record);

    List<Operator> selectByExample(OperatorExample example);
    
    List<OperatorDto> showOperator(Operator operator);

    Operator selectByPrimaryKey(String opId);

    int updateByExampleSelective(@Param("record") Operator record, @Param("example") OperatorExample example);

    int updateByExample(@Param("record") Operator record, @Param("example") OperatorExample example);

    int updateByPrimaryKeySelective(Operator record);

    int updateByPrimaryKey(Operator record);

    List<String> findAll();

    OperatorDto findOperatorById(String opId);

    List<OperatorDto> findChild(OperatorDto operatorDto);
}