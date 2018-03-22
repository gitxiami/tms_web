package com.sunyard.tms.service.impl;

import java.util.List;

import com.sunyard.tms.utils.PopedomHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sunyard.tms.constant.StatusConstants;
import com.sunyard.tms.entity.Popedom;
import com.sunyard.tms.entity.PopedomExample;
import com.sunyard.tms.entity.PopedomExample.Criteria;
import com.sunyard.tms.mapper.PopedomMapper;
import com.sunyard.tms.service.PopedomService;

/**
 * @Description:权限管理 服务层接口实现类
 * @author:zhangbo
 * @date:2017年7月17日 上午9:48:18
 */
@Service
public class PopedomServiceImpl implements PopedomService {
	@Autowired
	private PopedomMapper popedomMapper;
	
	@Override
	public List<Popedom> queryAllPopedoms() {
		PopedomExample example = new PopedomExample();
		example.setOrderByClause("POPEDOM_ID ASC");
		Criteria criteria = example.createCriteria();
		criteria.andPopedomOriginEqualTo("0");
		List<Popedom> list = popedomMapper.selectByExample(example);
		List<Popedom> tree =  PopedomHelper.getTree(list);
		return tree;
	}


    @Override
    public List<Popedom> findByUserId(String opId) {
        List<Popedom> list = popedomMapper.findByUserId(opId);
        return list;
    }
}
