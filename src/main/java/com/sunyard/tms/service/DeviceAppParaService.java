package com.sunyard.tms.service;

import com.sunyard.tms.dto.DeviceAppParaDto;
import com.sunyard.tms.entity.DeviceAppPara;
import com.sunyard.tms.entity.DeviceAppParaMchnt;
import com.sunyard.tms.entity.DeviceAppParaTpdu;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.IPage;

/**
 * @Description:终端应用参数管理 服务层接口
 * @author:zhangbo
 * @date:2017年11月30日 上午10:34:18
 */
public interface DeviceAppParaService {
	
	/**
     * @Description:条件分页查询终端应用参数信息
     * @param deviceAppPara
     * @param page
     * @return String
     */
	DataGrid<DeviceAppPara> queryParaByPage(DeviceAppPara deviceAppPara);
	
	/**
	 * @Description:根据关联键分页查询终端应用TPDU参数信息
	 * @param paraId
	 * @param page
	 * @return DataGrid<DeviceAppParaTpdu>
	 */
	DataGrid<DeviceAppParaTpdu> queryTpduByPara(String paraId, IPage page);
	
	/**
	 * @Description:根据关联键分页查询终端应用MCHNT参数信息
	 * @param paraId
	 * @param page
	 * @return DataGrid<DeviceAppParaMchnt>
	 */
	DataGrid<DeviceAppParaMchnt> queryMchntByPara(String paraId, IPage page);

	/**
     * @Description:添加终端应用参数信息
     * @param deviceAppPara
     * @return String
     */
	String addPara(DeviceAppPara deviceAppPara);

	/**
     * @Description:添加终端应用TPDU参数信息
	 * @param deviceAppParaTpdu
	 * @return String
	 */
	String addTpdu(DeviceAppParaTpdu deviceAppParaTpdu);
	
	/**
	 * @Description:添加终端应用MCHNT参数信息
	 * @param deviceAppParaMchnt
	 * @return String
	 */
	String addMchnt(DeviceAppParaMchnt deviceAppParaMchnt);

	/**
     * @Description:修改终端应用参数信息
     * @param deviceAppPara
     * @return String
     */
//	String updatePara(DeviceAppPara deviceAppPara);

	/**
     * @Description:删除终端应用参数信息(物理删除)
     * @param deviceAppPara
     * @return String
     */
//	String deletePara(DeviceAppPara deviceAppPara);

	/**
	 * @Description:根据终端序列号查询最新参数信息
	 * @param deviceAppPara
	 * @return DeviceAppPara
	 */
	DeviceAppParaDto queryLatestVersionPara(DeviceAppPara deviceAppPara);

	/**
	 * @Description:修改终端应用MCHNT参数信息
	 * @param deviceAppParaMchnt
	 * @return String
	 */
	String updateMchnt(DeviceAppParaMchnt deviceAppParaMchnt);
}