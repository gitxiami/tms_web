package com.sunyard.tms.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.sunyard.tms.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.common.base.Strings;
import com.sunyard.tms.aop.CreateLog;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.constant.CommonConstants;
import com.sunyard.tms.constant.StatusConstants;
import com.sunyard.tms.dto.OperatorDto;
import com.sunyard.tms.entity.Operator;
import com.sunyard.tms.service.OperatorService;


/**
 * @Description:用户管理模块类 控制层
 * @author:zhangbin
 * @date:2017年7月11日 上午9:30:24
 */
@Controller
@RequestMapping("/operator")
public class OperatorController {
    @Autowired
    private OperatorService operatorService;
    private final static Logger logger = LoggerFactory.getLogger(OperatorController.class);

    /**
     * @Description:用户修改自己的密码
     * @param oldPwd
     * @param newPwd
     * @param session
     * @return String
     */
    @RequestMapping("/updatePwd")
    @ResponseBody
    @CreateLog(description = "change password")
    public String updatePwd(String oldPwd, String newPwd, HttpSession session) {
        try {
            Operator operator = SessionUtils.getCurrentOp(session);
            if(PropertyUtil.getParam("defaultPwd").equals(newPwd)){
                return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("user.changeToDefault"));
            }
            if (!DigestUtils.md5DigestAsHex(oldPwd.getBytes()).equals(operator.getOpPwd())) {
                return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("user.oldPwdError"));
            }
            operator.setOpPwd(DigestUtils.md5DigestAsHex(newPwd.getBytes()));
            int result = operatorService.updateOperatorPwd(operator);
            if (result == 1) {
                // 重新登录
                session.invalidate();
                return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("user.changePwdSuc"));
            } else {
                return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("user.changePwdFail"));
            }
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:条件查询,分页展示用户
     * @param operator
     * @return String
     */
    @RequestMapping("/showOperatorByPage")
    @ResponseBody
    @CreateLog(description = "query user")
    public String showOperatorByPage(Operator operator, IPage page,HttpSession session) {
        try {
            Operator currentOp =  SessionUtils.getCurrentOp(session);
            operator.setOrgId(currentOp.getOrgId());
            DataGrid<OperatorDto> dataGrid = operatorService.queryOperatorByPage(operator, page);
            return JSON.toJSONString(dataGrid);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:新增用户
     * @param operator
     * @return String
     */
    @RequestMapping("/addOperator")
    @ResponseBody
    @CreateLog(description = "add user")
    public String addOperator(Operator operator) {
        try {
            String backResult = operatorService.addOperator(operator);
            return backResult;
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:修改用户信息
     * @param operator
     * @return String
     */
    @RequestMapping("/updateOperator")
    @ResponseBody
    @CreateLog(description = "modify user")
    public String updateOperator(Operator operator) {
        try {
            if (Strings.isNullOrEmpty(operator.getOpId())) {
                return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
            }
            int result = operatorService.updateOperator(operator);
            if (result == 1) {
                return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("user.userUpSuc"));
            } else {
                return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("user.userUpErr"));
            }
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:注销用户
     * @param operator
     * @return String
     */
    @RequestMapping("/logoffOperator")
    @ResponseBody
    @CreateLog(description = "delete user")
    public String logoffOperator(Operator operator,HttpSession session) {
        try {
            Operator currentOp = SessionUtils.getCurrentOp(session);
            if(operator.getOpId().equals(currentOp.getOpId())){
                return BackResult.back(false, CodeConst.ERROR, PropertyUtil.getValue("user.cannotDelSelf"));
            }
            OperatorDto operatorDto = operatorService.findOperatorById(operator.getOpId());
            String admin = "admin";
            if(operatorDto.getOpUsername().equals(PropertyUtil.getParam(admin))){
                return BackResult.back(false, CodeConst.ERROR,PropertyUtil.getValue("user.adminNoDelete"));
            }
            operator.setOpStatus(StatusConstants.OPERATPR_LOGOFF);
            int result = operatorService.updateOperator(operator);
            if (result == 1) {
                return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("user.userREMOVEOk"));
            } else {

                return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("user.userREMOVEErr"));
            }
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:解锁用户
     * @param operator
     * @return String
     */
    @RequestMapping("/unlockOperator")
    @ResponseBody
    @CreateLog(description = "unlock user")
    public String unlockOperator(Operator operator) {
        if (Strings.isNullOrEmpty(operator.getOpId())) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        operator.setOpStatus(StatusConstants.OPERATPR_NORMAL);
        try {
            int result = operatorService.updateOperator(operator);
            if (result == 1) {
                return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("user.userEnableOk"));
            } else {
                return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("user.userEnableErr"));
            }
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:重置用户密码为初始密码
     * @param operator
     * @return String
     */
    @RequestMapping("/resetPwd")
    @ResponseBody
    @CreateLog(description = "reset user")
    public String resetPwd(Operator operator) {
        if (Strings.isNullOrEmpty(operator.getOpId())) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        // 从配置文件中读取初始密码
        String defaultPwd = PropertyUtil.getParam("defaultPwd");
        String MD5DefaultPwd = DigestUtils.md5DigestAsHex(defaultPwd.getBytes());
        operator.setOpPwd(MD5DefaultPwd);
        try {
            int result = operatorService.updateOperator(operator);
            if (result == 1) {
                return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("user.resetPwdOk"));
            } else {
                return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("user.resetPwdErr"));
            }
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    @RequestMapping("/findAllOperator")
    @ResponseBody
    public String findAllOperator() {
        try {
            List<String> map = operatorService.findAll();
            return JSON.toJSONString(map);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**    
     * @Description:查找个人信息
     * @param session
     * @return String      
     */ 
    @RequestMapping("/findOperatorInfo")
    @ResponseBody
    @CreateLog(description = "query user info")
    public String findOperatorInfo(HttpSession session) {
        try {
            Operator operator = SessionUtils.getCurrentOp(session);
            OperatorDto operatorDto = operatorService.findOperatorById(operator.getOpId());
            return JSON.toJSONString(operatorDto);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
}
