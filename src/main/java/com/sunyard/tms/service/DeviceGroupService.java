package com.sunyard.tms.service;

import java.util.List;

import com.sunyard.tms.entity.Device;
import com.sunyard.tms.entity.DeviceGroup;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.IPage;

/**
 * @Description:终端组管理 服务层接口
 * @author:zhangbo
 * @date:2018年2月27日 下午2:21:02
 */
public interface DeviceGroupService {

	/**
	 * @Description:条件分页查询终端组信息
	 * @param deviceGroup
	 * @param page
	 * @return DataGrid<DeviceGroup>
	 */
	DataGrid<DeviceGroup> queryDeviceGroupByPage(DeviceGroup deviceGroup, IPage page);

	/**
	 * @Description:添加终端组信息
	 * @param deviceGroup
	 * @param deviceIds
	 * @return String
	 */
	String addDeviceGroup(DeviceGroup deviceGroup, List<String> deviceIds);

	/**
	 * @Description:修改终端组信息
	 * @param deviceGroup
	 * @param deviceIds
	 * @return String
	 */
	String updateDeviceGroup(DeviceGroup deviceGroup, List<String> deviceIds);

	/**
	 * @Description:删除终端组信息
	 * @param groupId
	 * @return String
	 */
	String deleteDeviceGroup(String groupId);

	/**
	 * @Description:查询全部终端组信息
	 * @param modelId
	 * @return List<DeviceGroup>
	 */
	List<DeviceGroup> allDeviceGroupByModel(String modelId);

	/**
	 * @Description:根据终端组查询组全部终端
	 * @param groupId
	 * @return List<Device>
	 */
	List<Device> queryDeviceByGroup(String groupId);
	
	/**
	 * @Description:查询全部未分组终端
	 * @param modelId
	 * @param deviceSn
	 * @return List<Device>
	 */
	List<Device> showNoMerchantDevice(String modelId, String deviceSn);
}