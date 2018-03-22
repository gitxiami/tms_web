package com.sunyard.tms.mapper;

import com.sunyard.tms.entity.Popedom;
import com.sunyard.tms.entity.PopedomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PopedomMapper {
    int countByExample(PopedomExample example);

    int deleteByExample(PopedomExample example);

    int deleteByPrimaryKey(String popedomId);

    int insert(Popedom record);

    int insertSelective(Popedom record);

    List<Popedom> selectByExample(PopedomExample example);

    Popedom selectByPrimaryKey(String popedomId);

    int updateByExampleSelective(@Param("record") Popedom record, @Param("example") PopedomExample example);

    int updateByExample(@Param("record") Popedom record, @Param("example") PopedomExample example);

    int updateByPrimaryKeySelective(Popedom record);

    int updateByPrimaryKey(Popedom record);

    /**
     * @Description:根据用户Id查找对应的权限
     * @param opId
     * @return List<Popedom>
     */
    List<Popedom> findByUserId(String opId);

    List<Popedom> findPopedomchild(Popedom popedom);
}