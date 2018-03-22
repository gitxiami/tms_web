package com.sunyard.tms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.entity.AppArea;
import com.sunyard.tms.entity.AppAreaExample;
import com.sunyard.tms.entity.AppAreaExample.Criteria;
import com.sunyard.tms.mapper.AppAreaMapper;
import com.sunyard.tms.service.AppAreaService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.IPage;
import com.sunyard.tms.utils.PropertyUtil;

/**
 * @Description:终端应用参数管理 服务层接口实现类
 * @author:zhangbo
 * @date:2017年12月5日 下午6:35:49
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AppAreaServiceImpl implements AppAreaService {
	@Autowired
	private AppAreaMapper appAreaMapper;

	/**
	 * @Description:条件分页查询应用地区信息
	 * @param appArea
	 * @param page
	 * @return DataGrid<AppArea>
	 */
	@Override
	public DataGrid<AppArea> queryAppAreaByPage(AppArea appArea, IPage page) {
		// 设置条件查询条件
		AppAreaExample example = new AppAreaExample();
		Criteria criteria = example.createCriteria();
		if (!Strings.isNullOrEmpty(appArea.getAreaName())) {
			criteria.andAreaNameLike(appArea.getAreaName());
		}
		// 设置分页信息
		PageHelper.startPage(page.getPageNo(), page.getPageSize());
		// 执行查询
		List<AppArea> list = appAreaMapper.selectByExample(example);
		// 取分页信息
        PageInfo<AppArea> pageInfo = new PageInfo<>(list);
        // 设置返回结果
        DataGrid<AppArea> dataGrid = new DataGrid<>();
        long total = pageInfo.getTotal();
        dataGrid.setTotal(new Long(total).intValue());
        dataGrid.setRows(list);
        return dataGrid;
	}

	/**
	 * @Description:添加应用地区信息
	 * @param appArea
	 * @return String
	 */
	@Override
	public String addAppArea(AppArea appArea) {
		// 验证地区名称是否被占用
		boolean flag = checkAppArea(appArea);
		if (!flag) {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("appArea.AreaNameIsFull"));
		}
		// 设置返回结果
		int result = appAreaMapper.insert(appArea);
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("appArea.insertAreaSuc"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("appArea.insertAreaFail"));
		}
	}

	private boolean checkAppArea(AppArea appArea) {
		AppAreaExample example = new AppAreaExample();
        Criteria criteria = example.createCriteria();
        criteria.andAreaNameEqualTo(appArea.getAreaName());
        List<AppArea> list = appAreaMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return true;
        }
        return false;
    }

	/**
	 * @Description:修改应用地区信息
	 * @param appArea
	 * @return String
	 */
	@Override
	public String updateAppArea(AppArea appArea) {
		// 设置返回结果
		int result = appAreaMapper.updateByPrimaryKeySelective(appArea);
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("appArea.updateAreaSuc"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("appArea.updateAreaFail"));
		}
	}

	/**
	 * @Description:删除应用地区信息(物理删除)
	 * @param appArea
	 * @return String
	 */
	@Override
	public String deleteAppArea(AppArea appArea) {
		// 设置返回结果
		int result = appAreaMapper.deleteByPrimaryKey(appArea.getAppAreaId());
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("appArea.deleteAreaSuc"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("appArea.deleteAreaFail"));
		}
	}

	/**
     * @Description:查询全部应用地区
     * @param appArea
     * @return String
     */
	@Override
	public List<AppArea> queryAllAppArea(AppArea appArea) {
		AppAreaExample example = new AppAreaExample();
		// 执行查询
		List<AppArea> list = appAreaMapper.selectByExample(example);
		return list;
	}
}