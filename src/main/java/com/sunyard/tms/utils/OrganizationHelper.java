package com.sunyard.tms.utils;

import com.sunyard.tms.entity.Organization;
import com.sunyard.tms.entity.Popedom;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author:zhangbin
 */
public class OrganizationHelper {
    public static List<Organization> getTree(List<Organization> all, String orgLv) {
        List<Organization> organization1 = new ArrayList<Organization>();
        for (Organization org : all) {
            if (org.getOrgLv().equals(orgLv)){
                organization1.add(org);
            }
        }
        for (Organization organization : organization1) {
            organization.setChildren(getChild(organization, all));
        }
        return organization1;
    }
    private static List<Organization> getChild(Organization pOrganization, List<Organization> all) {
        List<Organization> childList = new ArrayList<>();
        for (Organization organization : all) {
            // 遍历所有节点，将父权限id与传过来的id比较
            if (StringUtils.isNotBlank(organization.getOrgPid())) {
                if (organization.getOrgPid().equals(pOrganization.getOrgId())) {
                    organization.setOrgParentName(pOrganization.getOrgName());
                    childList.add(organization);
                }
            }
        }
        for (Organization organization : childList) {
            organization.setChildren(getChild(organization, all));
        } // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }
}
