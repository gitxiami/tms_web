/**
 * 
 */
package com.sunyard.tms.service;

import java.util.List;

import com.sunyard.tms.entity.Organization;

/**     
 * @Description:机构服务层接口类
 * @author:zhangbin  
 * @date:2017年7月14日 下午3:08:45   
 */
public interface OrganizationService {

    /**    
     * @Description:根据Id查找机构
     * @return Organization      
     */ 
    Organization findOrgById(String orgId);

    /**    
     * @Description:新增机构
     * @param org
     * @return String      
     */ 
    String addOrg(Organization org);

    /**    
     * @Description:校验机构名称是否存在
     * @param orgName       
     */ 
    List<Organization> queryByUsername(String orgName);

    /**    
     * @Description:校验机构编号是否存在
     * @param orgNo
     * @return List<Organization>      
     */ 
    List<Organization> queryByNo(String orgNo);

    /**    
     * @Description:修改机构信息
     * @param org
     * @return String     
     */ 
    int updateOrg(Organization org);

    /**    
     * @Description:展示机构信息列表
     * @param orgId
     * @return List<Map>
     */ 
    List<Organization> findOrgForNeed(String orgId);

    /**    
     * @Description:删除机构信息
     * @param org
     * @return int      
     */ 
    String deleteOrg(Organization org);
    
    /**    
     * @Description:判断是否还有子机构
     * @param orgId void      
     */ 
    public boolean checkHasChildren(String orgId);

    List<Organization> findAllOrg(String topId);

	/**
	 * @Description:根据机构名称查询机构Id
	 * @param orgName
	 * @return String
	 */
	String findOrgIdByName(String orgName);
}
