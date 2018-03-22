package com.sunyard.tms.service;

import com.sunyard.tms.entity.Device;
import com.sunyard.tms.entity.Merchant;
import com.sunyard.tms.entity.TerminalKey;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.IPage;

import java.util.List;

/**
 * @Description:终端管理 服务层接口
 * @author:zhangbo
 * @date:2017年11月30日 下午5:14:27
 */
public interface DeviceService {

	/**
	 * @Description:条件分页查询终端信息
	 * @param device
	 * @return DataGrid<Device>
	 */
	public DataGrid<Device> queryDeviceByPage(Device device);


	/**
	 * @Description:添加终端信息
	 * @param device
	 * @return String
	 */
	public String addDevice(Device device);


	/**
	 * @Description:修改终端信息
	 * @param device
	 * @return String
	 */
	public String updateDevice(Device device);


	/**
	 * @Description:禁用终端
	 * @param device
	 * @return String
	 */
	public String disableDevice(Device device);
	
	/**
	 * @Description:启用终端
	 * @param device
	 * @return String
	 */
	public String enableDevice(Device device);

	/**
	 * @Description:注销终端
	 * @param device
	 * @return String
	 */
	public String cancleDevice(Device device);

    List<Device> findByMerchantId(Merchant merchant);

    DataGrid<Device> showNoMerchantDevice(IPage page);

	/**
	 * @Description:根据终端序列号查询终端密钥
	 * @param devSn
	 * @return List<TerminalKey>
	 */
	public List<TerminalKey> queryDevKey(String devSn);


    /**    
     * @Description:TODO
     * @param terminalKey void      
     */ 
    public void addTmk(TerminalKey terminalKey);

    DataGrid<TerminalKey> showTerminalKey(TerminalKey terminalKey, IPage page);

    void deleteTerminalKey(TerminalKey terminalKey);

    boolean checkTmk(String tmk);
}
