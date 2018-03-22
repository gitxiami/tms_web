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
import com.sunyard.tms.entity.Device;
import com.sunyard.tms.entity.DeviceExample;
import com.sunyard.tms.entity.DeviceGroup;
import com.sunyard.tms.entity.DeviceGroupExample;
import com.sunyard.tms.entity.DeviceGroupExample.Criteria;
import com.sunyard.tms.mapper.DeviceGroupMapper;
import com.sunyard.tms.mapper.DeviceMapper;
import com.sunyard.tms.service.DeviceGroupService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.DateFormat;
import com.sunyard.tms.utils.IPage;
import com.sunyard.tms.utils.PrimaryKeyUtil;
import com.sunyard.tms.utils.PropertyUtil;

/**
 * @Description:终端组管理 服务层接口实现类
 * @author:zhangbo
 * @date:2018年2月27日 下午3:01:59
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DeviceGroupServiceImpl implements DeviceGroupService {
	@Autowired
	private DeviceGroupMapper deviceGroupMapper;
	@Autowired
	private DeviceMapper deviceMapper;

	/**
	 * @Description:条件分页查询终端组信息
	 * @param deviceGroup
	 * @param page
	 * @return DataGrid<DeviceGroup>
	 */
	@Override
	public DataGrid<DeviceGroup> queryDeviceGroupByPage(DeviceGroup deviceGroup, IPage page) {
		PageHelper.startPage(page.getPageNo(), page.getPageSize());
		List<DeviceGroup> list = deviceGroupMapper.queryForList(deviceGroup);
        // 取分页信息
        PageInfo<DeviceGroup> pageInfo = new PageInfo<>(list);
        // 设置返回结果
        DataGrid<DeviceGroup> dataGrid = new DataGrid<>();
        long total = pageInfo.getTotal();
        dataGrid.setTotal(new Long(total).intValue());
        dataGrid.setRows(list);
        return dataGrid;
	}

	/**
	 * @Description:添加终端组信息
	 * @param deviceGroup
	 * @param deviceIds
	 * @return String
	 */
	@Override
	public String addDeviceGroup(DeviceGroup deviceGroup, List<String> deviceIds) {
		// 验证终端组名称是否存在
		boolean flag = checkGroupname(deviceGroup);
		if (!flag) {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("deviceGroup.GroupNameIsFull"));
		}
		// 补全终端组信息
		String groupId = PrimaryKeyUtil.getPrimaryKey("DG");
		deviceGroup.setGroupId(groupId);
		String time = DateFormat.dateTimeFormat(new Date());
		deviceGroup.setCreatedDatetime(time);
		// 设置返回结果
		int result = deviceGroupMapper.insert(deviceGroup);
		if (deviceIds.size() > 0) {
			Device device = new Device();
			device.setGroupId(groupId);
			for (String deviceId : deviceIds) {
				device.setDeviceId(deviceId);
				deviceMapper.updateByPrimaryKeySelective(device);
			}
			result++;
		}
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("deviceGroup.insertGroupSuc"));
		} else if (result == 2) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("deviceGroup.insertGroupDeviceSuc"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("deviceGroup.insertGroupFail"));
		}
	}

	/**
	 * @Description:验证终端组名称是否存在
	 * @param deviceGroup
	 * @return boolean
	 */
	private boolean checkGroupname(DeviceGroup deviceGroup) {
		DeviceGroupExample example = new DeviceGroupExample();
		Criteria criteria = example.createCriteria();
		criteria.andGroupNameEqualTo(deviceGroup.getGroupName());
		List<DeviceGroup> list = deviceGroupMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
            return true;
        }
        return false;
	}

	/**
	 * @Description:修改终端组信息
	 * @param deviceGroup
	 * @param deviceIds
	 * @return String
	 */
	@Override
	public String updateDeviceGroup(DeviceGroup deviceGroup, List<String> deviceIds) {
		Device device = new Device();
		device.setGroupId(deviceGroup.getGroupId());
		// 先清空组内终端
		deleteDeviceGroup(deviceGroup.getGroupId());
		// 再绑定已选终端
		for (String deviceId : deviceIds) {
			device.setDeviceId(deviceId);
			deviceMapper.updateByPrimaryKeySelective(device);
		}
		String time = DateFormat.dateTimeFormat(new Date());
		deviceGroup.setUpdateDatetime(time);
		// 设置返回结果
		int result = deviceGroupMapper.updateByPrimaryKeySelective(deviceGroup);
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("deviceGroup.updateGroupSuc"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("deviceGroup.updateGroupFail"));
		}
	}

	/**
	 * @Description:删除终端组信息
	 * @param deviceGroup
	 * @return String
	 */
	@Override
	public String deleteDeviceGroup(String groupId) {
		// 设置返回结果
		int result = deviceGroupMapper.deleteByPrimaryKey(groupId);
		result += deviceMapper.emptyGroupIdByGroup(groupId);
		if (result >= 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("deviceGroup.deleteGroupSuc"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("deviceGroup.deleteGroupFail"));
		}
	}

	/**
	 * @Description:查询全部终端组信息
	 * @param modelId
	 * @return List<DeviceGroup>
	 */
	@Override
	public List<DeviceGroup> allDeviceGroupByModel(String modelId) {
		DeviceGroupExample example = new DeviceGroupExample();
		Criteria criteria = example.createCriteria();
		criteria.andModelIdEqualTo(modelId);
		List<DeviceGroup> list = deviceGroupMapper.selectByExample(example);
        return list;
	}
	
	/**
	 * @Description:根据终端组查询组全部终端
	 * @param groupId
	 * @return List<Device>
	 */
	@Override
	public List<Device> queryDeviceByGroup(String groupId) {
		DeviceExample example = new DeviceExample();
		com.sunyard.tms.entity.DeviceExample.Criteria criteria = example.createCriteria();
		criteria.andGroupIdEqualTo(groupId);
		List<Device> list = deviceMapper.selectByExample(example);
		return list;
	}

	/**
	 * @Description:查询全部未分组终端
	 * @param modelId
	 * @param deviceSn
	 * @return List<Device>
	 */
	@Override
	public List<Device> showNoMerchantDevice(String modelId, String deviceSn) {
		DeviceExample example = new DeviceExample();
		com.sunyard.tms.entity.DeviceExample.Criteria criteria = example.createCriteria();
		criteria.andGroupIdIsNull();
		criteria.andModelIdEqualTo(modelId);
		if (!Strings.isNullOrEmpty(deviceSn)) {
			criteria.andDeviceSnEqualTo(deviceSn);
		}
		List<Device> list = deviceMapper.selectByExample(example);
		return list;
	}
}