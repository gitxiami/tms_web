/**
 * 
 */
package com.sunyard.tms.service.impl;

import java.util.Date;
import java.util.List;

import com.sunyard.tms.utils.OrganizationHelper;
import com.sunyard.tms.utils.PropertyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.constant.StatusConstants;
import com.sunyard.tms.entity.Organization;
import com.sunyard.tms.entity.OrganizationExample;
import com.sunyard.tms.entity.OrganizationExample.Criteria;
import com.sunyard.tms.mapper.OrganizationMapper;
import com.sunyard.tms.service.OrganizationService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DateFormat;

/**
 * @Description:机构服务层实现类
 * @author:zhangbin
 * @date:2017年7月14日 下午3:08:45
 */
@Service
@Transactional(rollbackFor = Exception.class )
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationMapper organizationMapper;

    /**
     * @Description:根据Id查找其子机构信息
     * @return List<Organization>
     */
    @Override
    public List<Organization> findOrgForNeed(String orgId) {
        OrganizationExample example = new OrganizationExample();
        Criteria criteria = example.createCriteria();
        criteria.andOrgPidEqualTo(orgId);
        organizationMapper.selectByExample(example);
        return organizationMapper.selectByExample(example);
    }

    /**
     * @Description:根据Id查找机构
     * @param orgId
     * @return Organization
     */
    @Override
    public Organization findOrgById(String orgId) {
        OrganizationExample example = new OrganizationExample();
        Criteria criteria = example.createCriteria();
        criteria.andOrgIdEqualTo(orgId);
        organizationMapper.selectByExample(example);
        return organizationMapper.selectByExample(example).get(0);
    }

    /**
     * @Description:新增机构
     * @param org
     * @return int
     */
    @Override
    public String addOrg(Organization org) {
        // 根据其父Id查找父机构信息
        Organization parentOrg =findOrgById(org.getOrgPid());
        // 若父机构为支行,不允许添加
        if ("3".equals(parentOrg.getOrgLv())) {
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("org.SubBranchNoAdd"));
        }
        // 校验机构名
        List<Organization> queryByUsername = queryByUsername(org.getOrgName());
        if (queryByUsername != null && queryByUsername.size() != 0) {
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("org.OrgNameIsFull"));
        }
        // 校验机构编号
        List<Organization> queryByNo = queryByNo(org.getOrgId());
        if (queryByNo != null && queryByNo.size() != 0) {
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("org.OrgNoIsFull"));
        }
        // 添加机构
        // 判断其父机构的所属等级
        if (parentOrg.getOrgLv().equals(StatusConstants.ORG_LV_MASTER)) {
            org.setOrgLv(StatusConstants.ORG_LV_BRANCH);
        }
        if (parentOrg.getOrgLv().equals(StatusConstants.ORG_LV_BRANCH)) {
            org.setOrgLv(StatusConstants.ORG_LV_SUBBRANCH);
        }
        if (parentOrg.getOrgLv().equals(StatusConstants.ORG_LV_SUBBRANCH)) {
            org.setOrgLv("3");
        }
        Date date = new Date();
        org.setCreatedDatetime(DateFormat.dateTimeFormat(date));
        org.setUpdateDatetime(DateFormat.dateTimeFormat(date));
        org.setOrgStatus(StatusConstants.ORG_NORMAL);
        int result = organizationMapper.insertSelective(org);
        if (result == 1) {
            return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("org.insertOrgSuc"));
        } else {
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("org.insertOrgFail"));
        }
    }

    /**
     * @Description:校验机构名称
     * @param orgName void
     * @return
     */
    @Override
    public List<Organization> queryByUsername(String orgName) {
        OrganizationExample example = new OrganizationExample();
        Criteria criteria = example.createCriteria();
        criteria.andOrgNameEqualTo(orgName);
        List<Organization> list = organizationMapper.selectByExample(example);
        return list;
    }
    /**    
     * @Description:校验机构编号是否存在
     * @param orgId
     * @return List<Organization>      
     */ 
    @Override
    public List<Organization> queryByNo(String orgId) {
        OrganizationExample example = new OrganizationExample();
        Criteria criteria = example.createCriteria();
        criteria.andOrgIdEqualTo(orgId);
        List<Organization> list = organizationMapper.selectByExample(example);
        return list;
    }

    /**
     * @Description:修改机构信息
     * @param org
     * @return int
     */
    @Override
    public int updateOrg(Organization org) {
        Date date = new Date();
        org.setUpdateDatetime(DateFormat.dateTimeFormat(date));
        int result = organizationMapper.updateByPrimaryKeySelective(org);
        return result;
    }
    @Override
    public String deleteOrg(Organization org) {
        boolean flag = checkHasChildren(org.getOrgId());
        if(flag){
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("org.hasChildren"));
        }
        int result = organizationMapper.deleteByPrimaryKey(org.getOrgId());
        if (result == 1) {
            return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("org.delOrgSuc"));
        } else {
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("org.delOrgFail"));
        }
    }

    /**    
     * @Description:判断是否还有子机构
     * @param orgId void      
     * @return 
     */
    @Override
    public boolean checkHasChildren(String orgId) {
        OrganizationExample example = new OrganizationExample();
        Criteria criteria = example.createCriteria();
        criteria.andOrgPidEqualTo(orgId);
        criteria.andOrgStatusNotEqualTo(StatusConstants.ORG_DELETE);
        List<Organization> list = organizationMapper.selectByExample(example);
        return list.size() != 0 && list != null;
    }

    @Override
    public List<Organization> findAllOrg(String topId) {
        Organization organization = organizationMapper.selectByPrimaryKey(topId);
        return OrganizationHelper.getTree(organizationMapper.findOrgList(topId),organization.getOrgLv());
    }

	@Override
	public String findOrgIdByName(String orgName) {
		OrganizationExample example = new OrganizationExample();
        Criteria criteria = example.createCriteria();
        criteria.andOrgNameEqualTo(orgName);
        criteria.andOrgStatusNotEqualTo(StatusConstants.ORG_DELETE);
        List<Organization> list = organizationMapper.selectByExample(example);
        if (list.size() != 0 && list != null) {
        	return list.get(0).getOrgId();
		}
        return null;
	}
}
