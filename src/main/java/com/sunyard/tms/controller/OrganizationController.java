package com.sunyard.tms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.sunyard.tms.utils.PropertyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunyard.tms.aop.CreateLog;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.constant.CommonConstants;
import com.sunyard.tms.entity.Operator;
import com.sunyard.tms.entity.Organization;
import com.sunyard.tms.service.OrganizationService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.SessionUtils;

/**
 * @Description:机构管理相关控制层
 * @author:zhangbin
 * @date:2017年7月14日 下午1:38:40
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    private OrganizationService orgService;

    private static final Logger logger = LoggerFactory.getLogger(OrganizationController.class);

    /**
     * @Description:展示机构列表
     * @param session
     * @return String
     */
    @RequestMapping("/showOrgList")
    @ResponseBody
    @CreateLog(description = "query organization")
    public String showOrgList(HttpSession session) {
        try {
            Operator currentOp = SessionUtils.getCurrentOp(session);
            String topId = currentOp.getOrgId();
            List<Organization> list = orgService.findAllOrg(topId);
            return JSON.toJSONString(list);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
    /**
     * @Description:添加机构信息
     * @param org
     * @return String
     */
    @RequestMapping("/addOrg")
    @ResponseBody
    @CreateLog(description = "add organization")
    public String addOrg(Organization org) {
        try {
            String backResult = orgService.addOrg(org);
            return backResult;
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR,CommonConstants.SYSTEM_ERROR );
        }
    }

    /**
     * @Description:修改机构信息
     * @param org
     * @return String
     */
    @RequestMapping("/updateOrg")
    @ResponseBody
    @CreateLog(description = "modify organization")
    public String updateOrg(Organization org) {
        try {
            int result = orgService.updateOrg(org);
            if (result == 1) {
                return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("org.updateOrgSuc"));
            } else {
                return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("org.updateOrgFail"));
            }
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:废弃机构
     * @param org
     * @return String
     */
    @RequestMapping("/deleteOrg")
    @ResponseBody
    @CreateLog(description = "delete organization")
    public String deleteOrg(Organization org) {
        try {
            String result = orgService.deleteOrg(org);
            return result;
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:展示机构列表,用于用户相关操作
     * @param session
     * @return String
     */
    @RequestMapping("/showOrgListForOrg")
    @ResponseBody
    public String showOrgListForOrg(HttpSession session) {
        try {
            Operator currentOp = SessionUtils.getCurrentOp(session);
            String topId = currentOp.getOrgId();
            List<Organization> list = orgService.findAllOrg(topId);
            return JSON.toJSONString(list);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
}
