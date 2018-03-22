package com.sunyard.tms.service;

import java.util.List;

import com.sunyard.tms.entity.Popedom;

/**
 * @Description:权限接口，用来操作权限
 * @author:zhangbo
 * @date:2017年7月17日 上午9:48:51
 */
public interface PopedomService {

	/**
	 * 获取所有权限
	 * @return List<Popedom>
	 */
	public List<Popedom> queryAllPopedoms();

	
    /**    
     * @Description:根据用户Id查找其对应的权限
     * @param opId
     * @return List<Popedom>      
     */ 
    public List<Popedom> findByUserId(String opId);


}
