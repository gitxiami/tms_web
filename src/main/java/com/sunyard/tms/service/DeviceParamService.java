package com.sunyard.tms.service;

import java.util.List;

import com.sunyard.tms.entity.Device;
import com.sunyard.tms.entity.DeviceParam;

/**
 * @Description:终端参数管理 服务层接口
 * @author:zhangbo
 * @date:2018年3月2日 下午4:01:43
 */
public interface DeviceParamService {

	/**
	 * @Description:条件分页查询终端参数信息
	 * @param deviceParam
	 * @return List<DeviceParam>
	 */
	List<DeviceParam> queryParamByDevice(DeviceParam deviceParam);

	/**
	 * @Description:添加终端参数信息
	 * @param deviceParam
	 * @return String
	 */
	String addDeviceParam(DeviceParam deviceParam);

    /**
     * @Description:根据主键批量修改参数值
	 * @param deviceParams
	 * @return String
	 */
	String updateParam(List<DeviceParam> deviceParams);

	/**
	 * @Description:根据主键批量删除参数
	 * @param paramIds
	 * @return String
	 */
	String deleteParam(List<String> paramIds);

	/**
	 * @Description:终端组导入参数
	 * @param devices
	 * @param deviceParams
	 * @return String
	 */
	String addParamByGroup(List<Device> devices, List<DeviceParam> deviceParams);

	/**
	 * @Description:根据终端序列号查询终端参数
	 * @param devSn
	 * @return List<DeviceParam>
	 */
	List<DeviceParam> queryDevParaBySn(String devSn);
}