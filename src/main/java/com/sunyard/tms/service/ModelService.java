package com.sunyard.tms.service;

import java.util.List;

import com.sunyard.tms.entity.Model;
import com.sunyard.tms.utils.DataGrid;

/**
 * @Description:型号管理 服务层接口
 * @author:zhangbo
 * @date:2017年11月30日 上午10:34:18
 */
public interface ModelService {

	/**
	 * @Description:条件分页查询型号信息
	 * @param model
	 * @return DataGrid<Model>
	 */

	public DataGrid<Model> queryModelByPage(Model model);

	/**
	 * @Description:添加型号信息
	 * @param model
	 * @return String
	 */
	public String addModel(Model model);

	/**
	 * @Description:修改型号信息
	 * @param model
	 * @return String
	 */
	public String updateModel(Model model);

	/**
	 * @Description:删除型号信息(物理删除)
	 * @param model
	 * @return String
	 */
	public String deleteModel(Model model);

	/**
	 * @Description:查询全部型号信息
	 * @return List<Model>
     * @param model
	 */
	public List<Model> queryAllModels(Model model);
}