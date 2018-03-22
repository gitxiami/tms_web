package com.sunyard.tms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import com.sunyard.tms.aop.CreateLog;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.constant.CommonConstants;
import com.sunyard.tms.entity.Role;
import com.sunyard.tms.service.RoleService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.IPage;
import com.sunyard.tms.utils.PropertyUtil;

/**
 * @Description:角色管理 控制层
 * @author:zhangbo
 * @date:2017年11月30日 上午10:33:58
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    /**
     * @Description:条件分页查询角色信息
     * @param role
     * @param page
     * @return String
     */
    @RequestMapping("/showRole")
    @ResponseBody
    @CreateLog(description = "query role")
    public String showRoleByPage(Role role, IPage page) {
        try {
            role.setPage(page);
            DataGrid<Role> roles = roleService.queryRoleByPage(role);
            return JSON.toJSONString(roles);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:添加角色信息
     * @param role
     * @return String
     */
    @RequestMapping("/addRole")
    @ResponseBody
    @CreateLog(description = "add role")
    public String addRole(Role role) {
        try {
            return roleService.addRole(role);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:修改角色信息
     * @param role
     * @return String
     */
    @RequestMapping("/updateRole")
    @ResponseBody
    @CreateLog(description = "modify role")
    public String updateRole(Role role) {
        if (Strings.isNullOrEmpty(role.getRoleId())) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        try {
            return roleService.updateRole(role);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:删除角色信息(物理删除)
     * @param role
     * @return String
     */
    @RequestMapping("/deleteRole")
    @ResponseBody
    @CreateLog(description = "delete role")
    public String deleteRole(Role role) {
        try {
            if (Strings.isNullOrEmpty(role.getRoleId())) {
                return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
            }
            if(role.getRoleId().equals(PropertyUtil.getParam("org.admin.role"))){
                return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("role.superRole"));
            }
            return roleService.deleteRole(role);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:配置角色权限
     * @param role
     * @return String
     */
    @RequestMapping("/configRole")
    @ResponseBody
    @CreateLog(description = "edit permissions")
    public String configRole(Role role) {
        if (Strings.isNullOrEmpty(role.getRoleId())) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        try {
            /*if(role.getRoleId().equals(ConfCache.getValue("org.admin.role"))){
                return BackResult.back(false, CodeConst.FAIL, PageErrorConfig.getSystemError("role.superRolePope"));
            }*/
            return roleService.configRole(role);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:查询全部角色信息
     * @return String
     */
    @RequestMapping("/allRole")
    @ResponseBody
    public String showAllRole() {
        try {
            List<Role> roles = roleService.queryAllRoles();
            return JSON.toJSONString(roles);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

}
