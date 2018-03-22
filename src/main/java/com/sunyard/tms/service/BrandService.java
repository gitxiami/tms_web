package com.sunyard.tms.service;

import java.util.List;

import com.sunyard.tms.entity.Brand;
import com.sunyard.tms.utils.DataGrid;

/**
 * @Description:厂商管理 服务层接口
 * @author:zhangbo
 * @date:2017年11月30日 上午10:34:18
 */
public interface BrandService {

	/**
	 * @Description:条件分页查询厂商信息
	 * @param brand
	 * @return DataGrid<Brand>
	 */

	public DataGrid<Brand> queryBrandByPage(Brand brand);

	/**
	 * @Description:添加厂商信息
	 * @param brand
	 * @return String
	 */
	public String addBrand(Brand brand);

	/**
	 * @Description:修改厂商信息
	 * @param brand
	 * @return String
	 */
	public String updateBrand(Brand brand);

	/**
	 * @Description:删除厂商信息(物理删除)
	 * @param brand
	 * @return String
	 */
	public String deleteBrand(Brand brand);

	/**
	 * @Description:查询全部厂商信息
	 * @return List<Brand>
	 */
	public List<Brand> queryAllBrands();
}