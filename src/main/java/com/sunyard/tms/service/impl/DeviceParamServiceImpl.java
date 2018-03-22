package com.sunyard.tms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.entity.Device;
import com.sunyard.tms.entity.DeviceExample;
import com.sunyard.tms.entity.DeviceParam;
import com.sunyard.tms.entity.DeviceParamExample;
import com.sunyard.tms.entity.DeviceParamExample.Criteria;
import com.sunyard.tms.mapper.DeviceMapper;
import com.sunyard.tms.mapper.DeviceParamMapper;
import com.sunyard.tms.service.DeviceParamService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DateFormat;
import com.sunyard.tms.utils.PrimaryKeyUtil;
import com.sunyard.tms.utils.PropertyUtil;

/**
 * @Description:终端参数管理 服务层接口实现类
 * @author:zhangbo
 * @date:2018年3月2日 下午4:02:18
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DeviceParamServiceImpl implements DeviceParamService {
    @Autowired
    private DeviceParamMapper deviceParamMapper;
    @Autowired
    private DeviceMapper deviceMapper;
    
	/**
	 * @Description:条件分页查询终端参数信息
	 * @param deviceParam
	 * @return List<DeviceParam>
	 */
	@Override
	public List<DeviceParam> queryParamByDevice(DeviceParam deviceParam) {
		// 设置条件查询条件
		DeviceParamExample example = new DeviceParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andDeviceIdEqualTo(deviceParam.getDeviceId());
		List<DeviceParam> list = deviceParamMapper.selectByExample(example);
        return list;
	}
	
	/**
	 * @Description:添加终端参数信息
	 * @param deviceParam
	 * @return String
	 */
	@Override
	public String addDeviceParam(DeviceParam deviceParam) {
        boolean flag = checkParamName(deviceParam.getParamName());
        if (!flag) {
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("deviceParam.ParamNameIsFull"));
        }
        deviceParam.setParamId(PrimaryKeyUtil.getPrimaryKey("DP"));
        Date date = new Date();
        deviceParam.setCreatedDatetime(DateFormat.dateTimeFormat(date));
        deviceParam.setUpdateDatetime(DateFormat.dateTimeFormat(date));
        int result = deviceParamMapper.insertSelective(deviceParam);
        if (result == 1) {
            return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("deviceParam.insertParamSuc"));
        } else {
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("deviceParam.insertParamFail"));
        }
	}
	
    /**    
     * @Description:校验参数名称
     * @param paramName
     * @return boolean
     */
    public boolean checkParamName(String paramName) {
        DeviceParamExample example = new DeviceParamExample();
        Criteria criteria = example.createCriteria();
        criteria.andParamNameEqualTo(paramName);
        List<DeviceParam> list = deviceParamMapper.selectByExample(example);
        return list.size() == 0;
    }

    /**
     * @Description:根据主键批量修改参数值
	 * @param deviceParams
	 * @return String
	 */
	@Override
	public String updateParam(List<DeviceParam> deviceParams) {
        int result = 0;
		for (DeviceParam deviceParam : deviceParams) {
			DeviceParamExample example = new DeviceParamExample();
			Criteria criteria = example.createCriteria();
			criteria.andParamIdEqualTo(deviceParam.getParamId());
			result += deviceParamMapper.updateByExampleSelective(deviceParam, example);
		}
		if (result != 0) {
            return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("deviceParam.updateParamSuc"));
        } else {
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("deviceParam.updateParamFail"));
        }
	}

	/**
	 * @Description:根据主键批量删除参数
	 * @param paramIds
	 * @return String
	 */
	@Override
	public String deleteParam(List<String> paramIds) {
		int result = 0;
		for (String paramId : paramIds) {
			result += deviceParamMapper.deleteByPrimaryKey(paramId);
		}
		if (result == paramIds.size()) {
            return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("deviceParam.deleteParamSuc"));
        } else {
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("deviceParam.deleteParamFail"));
        }
	}

	/**
	 * @Description:终端组导入参数
	 * @param devices
	 * @param deviceParams
	 * @return String
	 */
	@Override
	public String addParamByGroup(List<Device> devices, List<DeviceParam> deviceParams) {
		List<String> deviceIds = new ArrayList<String>();
		for (Device device : devices) {
			if (!Strings.isNullOrEmpty(device.getDeviceId())) {
				deviceIds.add(device.getDeviceId());
			}
		}
		List<String> paramNames = new ArrayList<String>();
		for (DeviceParam deviceParam : deviceParams) {
			if (!Strings.isNullOrEmpty(deviceParam.getParamName())) {
				paramNames.add(deviceParam.getParamName());
			}
		}
		DeviceParamExample example = new DeviceParamExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeviceIdIn(deviceIds);
        criteria.andParamNameIn(paramNames);
		// 根据终端号和参数名删除参数
        deviceParamMapper.deleteByExample(example);
		// 根据终端号循环添加参数
        int result = 0;
        for (String deviceId : deviceIds) {
			for (DeviceParam deviceParam : deviceParams) {
				deviceParam.setParamId(PrimaryKeyUtil.getPrimaryKey("DP"));
				deviceParam.setDeviceId(deviceId);
		        Date date = new Date();
		        deviceParam.setCreatedDatetime(DateFormat.dateTimeFormat(date));
		        deviceParam.setUpdateDatetime(DateFormat.dateTimeFormat(date));
		        deviceParamMapper.insertSelective(deviceParam);
		        result ++;
			}
		}
		if (result == deviceIds.size() * deviceParams.size()) {
            return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("deviceParam.insertParamSuc"));
        } else {
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("deviceParam.insertParamFail"));
        }
	}

	/**
	 * @Description:根据终端序列号查询终端参数
	 * @param devSn
	 * @return List<DeviceParam>
	 */
	@Override
	public List<DeviceParam> queryDevParaBySn(String devSn) {
		// 根据终端序列号查询终端Id
		DeviceExample deviceExample = new DeviceExample();
        com.sunyard.tms.entity.DeviceExample.Criteria deviceCriteria = deviceExample.createCriteria();
        deviceCriteria.andDeviceSnEqualTo(devSn);
		List<Device> device = deviceMapper.selectByExample(deviceExample);
		// 根据终端Id查询终端参数信息
		DeviceParamExample example = new DeviceParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andDeviceIdEqualTo(device.get(0).getDeviceId());
		List<DeviceParam> params = deviceParamMapper.selectByExample(example);
		return params;
	}
}