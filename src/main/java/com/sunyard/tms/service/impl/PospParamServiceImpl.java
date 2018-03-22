package com.sunyard.tms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.entity.PospParam;
import com.sunyard.tms.entity.PospParamExample;
import com.sunyard.tms.entity.PospParamExample.Criteria;
import com.sunyard.tms.mapper.PospParamMapper;
import com.sunyard.tms.service.PospParamService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.DateFormat;
import com.sunyard.tms.utils.PropertyUtil;

/**
 * @Description:终端应用参数管理 服务层接口实现类
 * @author:zhangbo
 * @date:2017年12月5日 下午6:35:49
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PospParamServiceImpl implements PospParamService {
	@Autowired
	private PospParamMapper pospParamMapper;

	/**
	 * @Description:条件分页查询POSP参数信息
	 * @param pospParam
	 * @return DataGrid<PospParam>
	 */
	@Override
	public DataGrid<PospParam> queryPospParamByPage(PospParam pospParam) {
		// 设置条件查询条件
		PospParamExample example = new PospParamExample();
		Criteria criteria = example.createCriteria();
		if (!Strings.isNullOrEmpty(pospParam.getParamType())) {
			criteria.andParamTypeEqualTo(pospParam.getParamType());
		}
		if (!Strings.isNullOrEmpty(pospParam.getParamNo())) {
			criteria.andParamNoEqualTo(pospParam.getParamNo());
		}
		example.setOrderByClause("PARAM_TYPE ASC,PARAM_NO ASC");
		// 设置分页信息
		PageHelper.startPage(pospParam.getPage().getPageNo(), pospParam.getPage().getPageSize());
		// 执行查询
		List<PospParam> list = pospParamMapper.selectByExample(example);
		// 取分页信息
		PageInfo<PospParam> pageInfo = new PageInfo<>(list);
		// 设置返回结果
		DataGrid<PospParam> dataGrid = new DataGrid<>();
		long total = pageInfo.getTotal();
		dataGrid.setTotal(new Long(total).intValue());
		dataGrid.setRows(list);
		return dataGrid;
	}

	/**
	 * @Description:添加POSP参数信息
	 * @param pospParam
	 * @return String
	 */
	@Override
	public String addPospParam(PospParam pospParam) {
		// 验证参数类型和取用序号是否被占用
		boolean flag = checkPospParam(pospParam);
		if (!flag) {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("para.ParamTypeAndParamNoIsFull"));
		}
		// 补全参数信息
		String time = DateFormat.dateTimeFormat(new Date());
		pospParam.setCreateDatetime(time);
		pospParam.setUpdateDatetime(time);
		// 设置返回结果
		int result = pospParamMapper.insert(pospParam);
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("para.insertParaSuc"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("para.insertParasFail"));
		}
	}
	
	public boolean checkPospParam(PospParam pospParam) {
		PospParamExample example = new PospParamExample();
        Criteria criteria = example.createCriteria();
        criteria.andParamTypeEqualTo(pospParam.getParamType());
        criteria.andParamNoEqualTo(pospParam.getParamNo());
        List<PospParam> list = pospParamMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return true;
        }
        return false;
    }

	/**
	 * @Description:修改POSP参数信息
	 * @param pospParam
	 * @return String
	 */
	@Override
	public String updatePospParam(PospParam pospParam) {
		String time = DateFormat.dateTimeFormat(new Date());
		pospParam.setUpdateDatetime(time);
		// 设置返回结果
		int result = pospParamMapper.updateByPrimaryKeySelective(pospParam);
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("para.updateParaSuc"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("para.updateParaFail"));
		}
	}

	/**
	 * @Description:删除POSP参数信息(物理删除)
	 * @param pospParam
	 * @return String
	 */
	@Override
	public String deletePospParam(PospParam pospParam) {
		// 设置返回结果
		int result = pospParamMapper.deleteByPrimaryKey(pospParam);
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("para.deleteParaSuc"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("para.deleteParaFail"));
		}
	}
	
	/**
	 * @Description:查询公钥和磁条卡参数
	 * @param pospParam
	 * @return List<PospParam>
	 */
	@Override
	public List<PospParam> queryPospParam(PospParam pospParam) {
		PospParamExample example = new PospParamExample();
		com.sunyard.tms.entity.PospParamExample.Criteria criteria = example.createCriteria();
		criteria.andParamTypeEqualTo(pospParam.getParamType());
		if (!Strings.isNullOrEmpty(pospParam.getParamNo())) {
			criteria.andParamNoEqualTo(pospParam.getParamNo());
		}
		example.setOrderByClause("PARAM_NO ASC");
		List<PospParam> list = pospParamMapper.selectByExample(example);
		return list;
	}
}