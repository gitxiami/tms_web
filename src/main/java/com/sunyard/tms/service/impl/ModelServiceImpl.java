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
import com.sunyard.tms.entity.Model;
import com.sunyard.tms.entity.ModelExample;
import com.sunyard.tms.entity.ModelExample.Criteria;
import com.sunyard.tms.entity.Device;
import com.sunyard.tms.entity.DeviceExample;
import com.sunyard.tms.mapper.ModelMapper;
import com.sunyard.tms.mapper.DeviceMapper;
import com.sunyard.tms.service.ModelService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.DateFormat;
import com.sunyard.tms.utils.PrimaryKeyUtil;
import com.sunyard.tms.utils.PropertyUtil;

/**
 * @Description:型号管理 服务层接口实现类
 * @author:zhangbo
 * @date:2017年7月12日 下午2:19:17
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ModelServiceImpl implements ModelService {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private DeviceMapper deviceMapper;

	/**
	 * @Description:条件分页查询型号信息
	 * @param model
	 * @return DataGrid<Model>
	 */
	@Override
	public DataGrid<Model> queryModelByPage(Model model) {
		// 设置分页信息
		PageHelper.startPage(model.getPage().getPageNo(), model.getPage().getPageSize());
		// 执行查询
		List<Model> list = modelMapper.queryForList(model);
		// 取分页信息
		PageInfo<Model> pageInfo = new PageInfo<>(list);
		// 设置返回结果
		DataGrid<Model> dataGrid = new DataGrid<>();
		long total = pageInfo.getTotal();
		dataGrid.setTotal(new Long(total).intValue());
		dataGrid.setRows(list);
		return dataGrid;
	}

	/**
	 * @Description:添加型号信息
	 * @param model
	 * @return String
	 */
	@Override
	public String addModel(Model model) {
		// 验证型号名称是否存在
		boolean flag = checkModelname(model);
		if (!flag) {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("model.ModelNameIsFull"));
		}
		// 补全型号信息
		model.setModelId(PrimaryKeyUtil.getPrimaryKey("MO"));
		String time = DateFormat.dateTimeFormat(new Date());
		model.setCreatedDatetime(time);
		model.setUpdateDatetime(time);
		// 设置返回结果
		int result = modelMapper.insert(model);
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("model.insertModelSuc"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("model.insertModelFail"));
		}
	}

	/**
	 * @Description:验证型号名称是否存在
	 * @param model
	 * @return boolean
	 */
	public boolean checkModelname(Model model) {
        ModelExample example = new ModelExample();
        Criteria criteria = example.createCriteria();
        criteria.andModelNameEqualTo(model.getModelName());
        List<Model> list = modelMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return true;
        }
        return false;
    }

	/**
	 * @Description:修改型号信息
	 * @param model
	 * @return String
	 */
	@Override
	public String updateModel(Model model) {
		if (!model.getModelName().equals(modelMapper.selectByPrimaryKey(model.getModelId()).getModelName())) {
			// 验证型号名称是否存在
			boolean flag = checkModelname(model);
			if (!flag) {
				return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("model.ModelNameIsFull"));
			}
		}
		String time = DateFormat.dateTimeFormat(new Date());
		model.setUpdateDatetime(time);
		// 设置返回结果
		int result = modelMapper.updateByPrimaryKeySelective(model);
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("model.updateModelSuc"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("model.updateModelFail"));
		}
	}

	/**
	 * @Description:删除型号信息(物理删除)
	 * @param model
	 * @return String
	 */
	@Override
	public String deleteModel(Model model) {
		String modelId = model.getModelId();
		// 设置绑定终端的条件查询条件
		DeviceExample example = new DeviceExample();
		com.sunyard.tms.entity.DeviceExample.Criteria criteria= example.createCriteria();
		if (!Strings.isNullOrEmpty(modelId)) {
			criteria.andModelIdLike("%" + modelId + "%");
		}
		// 执行查询
		List<Device> list = deviceMapper.selectByExample(example);
		// 判断该型号是否绑定终端
		if (list.size() > 0) {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("model.getDeviceByModel"));
		}
		// 设置返回结果
		int result = modelMapper.deleteByPrimaryKey(modelId);
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("model.deleteModelSuc"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("model.deleteModelFail"));
		}
	}

	/**
	 * @Description:查询全部型号信息
	 * @return List<Model>
     * @param model
	 */
	@Override
	public List<Model> queryAllModels(Model model) {
		// 设置条件查询条件
		ModelExample example = new ModelExample();
		Criteria criteria = example.createCriteria();
		criteria.andBrandIdEqualTo(model.getBrandId());
		criteria.andModelTypeIdEqualTo(model.getModelTypeId());
		List<Model> list = modelMapper.selectByExample(example);
		return list;
	}
}