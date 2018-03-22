package com.sunyard.tms.service;

import java.util.List;

import com.sunyard.tms.entity.AppArea;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.IPage;

/**
 * @Description:应用地区管理 服务层接口
 * @author:zhangbo
 * @date:2018年1月31日 上午10:51:18
 */
public interface AppAreaService {
	/**
	 * @Description:条件分页查询应用地区信息
	 * @param appArea
	 * @param page
	 * @return DataGrid<AppArea>
	 */
	DataGrid<AppArea> queryAppAreaByPage(AppArea appArea, IPage page);

	/**
	 * @Description:添加应用地区信息
	 * @param appArea
	 * @return String
	 */
	String addAppArea(AppArea appArea);

	/**
	 * @Description:修改应用地区信息
	 * @param appArea
	 * @return String
	 */
	String updateAppArea(AppArea appArea);

	/**
	 * @Description:删除应用地区信息(物理删除)
	 * @param appArea
	 * @return String
	 */
	String deleteAppArea(AppArea appArea);

	/**
     * @Description:查询全部应用地区
     * @param appArea
     * @return String
     */
	List<AppArea> queryAllAppArea(AppArea appArea);
}