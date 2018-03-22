package com.sunyard.tms.service;

import java.util.List;

import com.sunyard.tms.entity.PospParam;
import com.sunyard.tms.utils.DataGrid;

/**
 * @Description:POSP参数管理 服务层接口
 * @author:zhangbo
 * @date:2017年12月11日 下午3:09:03
 */
public interface PospParamService {

	/**
	 * @Description:条件分页查询POSP参数信息
	 * @param pospParam
	 * @return DataGrid<PospParam>
	 */
	DataGrid<PospParam> queryPospParamByPage(PospParam pospParam);

	/**
	 * @Description:添加POSP参数信息
	 * @param pospParam
	 * @return String
	 */
	String addPospParam(PospParam pospParam);

	/**
	 * @Description:修改POSP参数信息
	 * @param pospParam
	 * @return String
	 */
	String updatePospParam(PospParam pospParam);

	/**
	 * @Description:删除POSP参数信息(物理删除)
	 * @param pospParam
	 * @return String
	 */
	String deletePospParam(PospParam pospParam);
	
	/**
	 * @Description:查询公钥和磁条卡参数
	 * @param pospParam
	 * @return List<PospParam>
	 */
	List<PospParam> queryPospParam(PospParam pospParam);
}