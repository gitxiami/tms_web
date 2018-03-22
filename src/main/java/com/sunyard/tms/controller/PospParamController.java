package com.sunyard.tms.controller;

import javax.servlet.http.HttpSession;

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
import com.sunyard.tms.entity.PospParam;
import com.sunyard.tms.service.PospParamService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.IPage;
import com.sunyard.tms.utils.SessionUtils;

/**
 * @Description:POSP参数管理 控制层
 * @author:zhangbo
 * @date:2017年12月11日 下午3:09:12
 */
@Controller
@RequestMapping("/pospParam")
public class PospParamController {
    @Autowired
    private PospParamService pospParamService;

    private static final Logger logger = LoggerFactory.getLogger(PospParamController.class);

    /**
     * @Description:条件分页查询POSP参数信息
     * @param pospParam
     * @param page
     * @return String
     */
    @RequestMapping("/showPospParam")
    @ResponseBody
    @CreateLog(description = "query posp para")
    public String showPospParamByPage(PospParam pospParam, IPage page) {
        try {
        	pospParam.setPage(page);
            DataGrid<PospParam> params = pospParamService.queryPospParamByPage(pospParam);
            return JSON.toJSONString(params);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:添加POSP参数信息
     * @param pospParam
     * @return String
     */
    @RequestMapping("/addPospParam")
    @ResponseBody
    @CreateLog(description = "add posp para")
    public String addPospParam(PospParam pospParam, HttpSession session) {
    	pospParam.setCreateOprater(SessionUtils.getCurrentOp(session).getOpUsername());
        try {
            return pospParamService.addPospParam(pospParam);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:修改POSP参数信息
     * @param pospParam
     * @return String
     */
    @RequestMapping("/updatePospParam")
    @ResponseBody
    @CreateLog(description = "modify posp para")
    public String updatePospParam(PospParam pospParam) {
        if (Strings.isNullOrEmpty(pospParam.getParamType())) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        if (Strings.isNullOrEmpty(pospParam.getParamNo())) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        try {
            return pospParamService.updatePospParam(pospParam);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:删除POSP参数信息(物理删除)
     * @param deviceAppPara
     * @return String
     */
    @RequestMapping("/deletePospParam")
    @ResponseBody
    @CreateLog(description = "delete posp para")
    public String deletePospParam(PospParam pospParam) {
        try {
        	if (Strings.isNullOrEmpty(pospParam.getParamType())) {
                return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
            }
            if (Strings.isNullOrEmpty(pospParam.getParamNo())) {
                return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
            }
            return pospParamService.deletePospParam(pospParam);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
}