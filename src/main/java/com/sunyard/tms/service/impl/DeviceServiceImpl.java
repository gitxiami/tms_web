package com.sunyard.tms.service.impl;

import java.util.Date;
import java.util.List;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.constant.StatusConstants;
import com.sunyard.tms.entity.Device;
import com.sunyard.tms.entity.DeviceExample;
import com.sunyard.tms.entity.Merchant;
import com.sunyard.tms.entity.TerminalKey;
import com.sunyard.tms.entity.TerminalKeyExample;
import com.sunyard.tms.mapper.DeviceMapper;
import com.sunyard.tms.mapper.TerminalKeyMapper;
import com.sunyard.tms.service.DeviceService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.DateFormat;
import com.sunyard.tms.utils.IPage;
import com.sunyard.tms.utils.PrimaryKeyUtil;
import com.sunyard.tms.utils.PropertyUtil;

/**
 * @Description:终端管理 服务层接口实现类
 * @author:zhangbo
 * @date:2017年11月30日 下午5:37:33
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private DeviceMapper deviceMapper;
	@Autowired
	private TerminalKeyMapper terminalKeyMapper;

	/**
	 * @Description:条件分页查询终端信息
	 * @param device
	 * @return DataGrid<Device>
	 */
	@Override
	public DataGrid<Device> queryDeviceByPage(Device device) {
		// 设置分页信息
		PageHelper.startPage(device.getPage().getPageNo(), device.getPage().getPageSize());
		// 执行查询
		List<Device> list = deviceMapper.queryForList(device);
		// 取分页信息
		PageInfo<Device> pageInfo = new PageInfo<>(list);
		// 设置返回结果
		DataGrid<Device> dataGrid = new DataGrid<>();
		long total = pageInfo.getTotal();
		dataGrid.setTotal(new Long(total).intValue());
		dataGrid.setRows(list);
		return dataGrid;
	}

	/**
	 * @Description:添加终端信息
	 * @param device
	 * @return String
	 */
	@Override
	public String addDevice(Device device) {
		// 验证设备序列号号是否存在
		boolean flag = checkDevicesn(device);
		if (!flag) {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("device.DeviceSnIsFull"));
		}
		// 补全设备信息
		device.setDeviceId(PrimaryKeyUtil.getPrimaryKey("TM"));
		device.setDeviceStatus(StatusConstants.DEVSTATUS_STORAGE);
		String time = DateFormat.dateTimeFormat(new Date());
		device.setCreateDatetime(time);
		device.setUpdateDatetime(time);
		// 设置返回结果
		int result = deviceMapper.insert(device);
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("device.insertDeviceSuc"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("device.insertDeviceFail"));
		}
	}

	/**
	 * @Description:验证终端序列号是否存在
	 * @param device
	 * @return boolean
	 */
	public boolean checkDevicesn(Device device) {
		DeviceExample example = new DeviceExample();
		com.sunyard.tms.entity.DeviceExample.Criteria criteria = example.createCriteria();
		criteria.andDeviceStatusNotEqualTo(StatusConstants.DEVSTATUS_CANCLE);
		criteria.andDeviceSnEqualTo(device.getDeviceSn());
		List<Device> list = deviceMapper.selectByExample(example);
		return list == null || list.size() == 0;
	}

	/**
	 * @Description:修改终端信息
	 * @param device
	 * @return String
	 */
	@Override
	public String updateDevice(Device device) {
		// 验证终端是否已注销
		boolean disFlag = checkDevDiscared(device.getDeviceId());
		if (!disFlag) {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("device.discared"));
		}
		if (!device.getDeviceSn().equals(deviceMapper.selectByPrimaryKey(device.getDeviceId()).getDeviceSn())) {
			// 验证设备序列号号是否存在
			boolean flag = checkDevicesn(device);
			if (!flag) {
				return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("device.DeviceSnIsFull"));
			}
		}
		String time = DateFormat.dateTimeFormat(new Date());
		device.setUpdateDatetime(time);
		// 设置返回结果
		int result = deviceMapper.updateByPrimaryKeySelective(device);
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("device.updateDeviceSuc"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("device.updateDeviceFail"));
		}
	}


	/**
	 * @Description:验证终端是否已注销
	 * @return boolean
	 */
	public boolean checkDevDiscared(String devId) {
		Device device = deviceMapper.selectByPrimaryKey(devId);
		return device == null || !StatusConstants.DEVSTATUS_CANCLE.equals(device.getDeviceStatus());
	}

	/**
	 * @Description:禁用终端
	 * @param device
	 * @return String
	 */
	@Override
	public String disableDevice(Device device) {
		// 验证终端是否已注销
		boolean disFlag = checkDevDiscared(device.getDeviceId());
		if (!disFlag) {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("device.disable.discared"));
		}
		device.setDeviceStatus(StatusConstants.DEVSTATUS_DISABLE);
		String time = DateFormat.dateTimeFormat(new Date());
		device.setUpdateDatetime(time);
		// 设置返回结果
		int result = deviceMapper.updateByPrimaryKeySelective(device);
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("device.disable.ok"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("device.disable.err"));
		}
	}
	
	/**
	 * @Description:启用终端
	 * @param device
	 * @return String
	 */
	@Override
	public String enableDevice(Device device) {
		// 验证终端是否已注销
		boolean disFlag = checkDevDiscared(device.getDeviceId());
		if (!disFlag) {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("device.enable.discared"));
		}
		device.setDeviceStatus(StatusConstants.DEVSTATUS_ENABLE);
		String time = DateFormat.dateTimeFormat(new Date());
		device.setUpdateDatetime(time);
		// 设置返回结果
		int result = deviceMapper.updateByPrimaryKeySelective(device);
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("device.enable.ok"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("device.enable.err"));
		}
	}

	/**
	 * @Description:注销终端
	 * @param device
	 * @return String
	 */
	@Override
	public String cancleDevice(Device device) {
		device.setDeviceStatus(StatusConstants.DEVSTATUS_CANCLE);
		String time = DateFormat.dateTimeFormat(new Date());
		device.setUpdateDatetime(time);
		// 设置返回结果
		int result = deviceMapper.updateByPrimaryKeySelective(device);
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("device.delete.ok"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("device.delete.err"));
		}
	}

	@Override
	public List<Device> findByMerchantId(Merchant merchant) {
		List<Device> list = deviceMapper.findByMerchantId(merchant);
		return list;
	}

	@Override
	public DataGrid<Device> showNoMerchantDevice(IPage page) {
		// 设置分页信息
		PageHelper.startPage(page.getPageNo(), page.getPageSize());
		// 执行查询
		List<Device> list = deviceMapper.showNoMerchantDevice();
		// 取分页信息
		PageInfo<Device> pageInfo = new PageInfo<>(list);
		// 设置返回结果
		DataGrid<Device> dataGrid = new DataGrid<>();
		long total = pageInfo.getTotal();
		dataGrid.setTotal(new Long(total).intValue());
		dataGrid.setRows(list);
		return dataGrid;
	}
	
	@Override
	public List<TerminalKey> queryDevKey(String devSn) {
		// 条件查询该终端是否绑定主密钥
		DeviceExample dExample = new DeviceExample();
		com.sunyard.tms.entity.DeviceExample.Criteria dCriteria = dExample.createCriteria();
		dCriteria.andDeviceSnEqualTo(devSn);
		dCriteria.andDeviceStatusEqualTo(StatusConstants.DEVSTATUS_ENABLE);
		dCriteria.andDevTmkIsNull();
		List<Device> dList = deviceMapper.selectByExample(dExample);
		if (dList.size() > 0) {
			// 该终端未绑定主密钥
			TerminalKeyExample tkExample = new TerminalKeyExample();
			com.sunyard.tms.entity.TerminalKeyExample.Criteria tkCriteria = tkExample.createCriteria();
			tkCriteria.andUseFlagEqualTo(StatusConstants.USE_FLAG_UNUSED);
			tkExample.setOrderByClause("CREATE_TIME ASC");
			// 查询未绑定的主密钥
			List<TerminalKey> tkList = terminalKeyMapper.selectByExample(tkExample);
			if (tkList.size() > dList.size()) {
				// 在终端表中绑定密钥主键
				for (int i = 0; i < dList.size(); i++) {
					dList.get(i).setDevTmk(tkList.get(i).getKeyId());
					tkList.get(i).setUseFlag(StatusConstants.USE_FLAG_ISUSED);
					deviceMapper.updateByPrimaryKeySelective(dList.get(i));
					terminalKeyMapper.updateByPrimaryKeySelective(tkList.get(i));
				}
			}
		}
		// 查询终端主密钥
		List<TerminalKey> list = terminalKeyMapper.queryDevKey(devSn);
		return list;
	}

    @Override
    public void addTmk(TerminalKey terminalKey) {
        terminalKeyMapper.insertSelective(terminalKey);
    }

	@Override
	public DataGrid<TerminalKey> showTerminalKey(TerminalKey terminalKey, IPage page) {
		TerminalKeyExample terminalKeyExample = new TerminalKeyExample();
		TerminalKeyExample.Criteria criteria = terminalKeyExample.createCriteria();
		if (!Strings.isNullOrEmpty(terminalKey.getUseFlag())){
			criteria.andUseFlagEqualTo(terminalKey.getUseFlag());
		}
		// 设置分页信息
		PageHelper.startPage(page.getPageNo(), page.getPageSize());
		// 执行查询
		List<TerminalKey> list = terminalKeyMapper.selectByExample(terminalKeyExample);
		// 取分页信息
		PageInfo<TerminalKey> pageInfo = new PageInfo<>(list);
		// 设置返回结果
		DataGrid<TerminalKey> dataGrid = new DataGrid<>();
		long total = pageInfo.getTotal();
		dataGrid.setTotal(new Long(total).intValue());
		dataGrid.setRows(list);
		return dataGrid;
	}

	@Override
	public void deleteTerminalKey(TerminalKey terminalKey) {
		terminalKeyMapper.deleteByPrimaryKey(terminalKey.getKeyId());
	}

	@Override
	public boolean checkTmk(String tmk) {
		TerminalKeyExample example = new TerminalKeyExample();
		TerminalKeyExample.Criteria criteria = example.createCriteria();
		criteria.andTmkEqualTo(tmk);
		List<TerminalKey> list = terminalKeyMapper.selectByExample(example);
		if (list.size()==0){
			return true;
		}
		return false;
	}
}
