package com.sunyard.tms.controller;

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
import com.sunyard.tms.entity.DeviceAppPara;
import com.sunyard.tms.entity.DeviceAppParaMchnt;
import com.sunyard.tms.entity.DeviceAppParaTpdu;
import com.sunyard.tms.service.DeviceAppParaService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.IPage;

/**
 * @Description:终端应用参数管理 控制层
 * @author:zhangbo
 * @date:2017年12月5日 下午6:01:38
 */
@Controller
@RequestMapping("/deviceAppPara")
public class DeviceAppParaController {
    @Autowired
    private DeviceAppParaService deviceAppParaService;

    private static final Logger logger = LoggerFactory.getLogger(DeviceAppParaController.class);

    /**
     * @Description:条件分页查询终端应用参数信息
     * @param deviceAppPara
     * @param page
     * @return String
     */
    @RequestMapping("/showPara")
    @ResponseBody
    @CreateLog(description = "query device para")
    public String showParaByPage(DeviceAppPara deviceAppPara, IPage page) {
        try {
        	deviceAppPara.setPage(page);
            DataGrid<DeviceAppPara> paras = deviceAppParaService.queryParaByPage(deviceAppPara);
            return JSON.toJSONString(paras);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
    
    /**
     * @Description:根据关联键分页查询终端应用TPDU参数信息
     * @param paraId
     * @param page
     * @return String
     */
    @RequestMapping("/showTpduByPara")
    @ResponseBody
    @CreateLog(description = "query tpdu para")
    public String showTpduByPara(String paraId, IPage page) {
    	if (Strings.isNullOrEmpty(paraId)) {
			return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
		}
        try {
            DataGrid<DeviceAppParaTpdu> tpdus = deviceAppParaService.queryTpduByPara(paraId, page);
            return JSON.toJSONString(tpdus);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
    
    /**
     * @Description:根据关联键分页查询终端应用MCHNT参数信息
     * @param paraId
     * @param page
     * @return String
     */
    @RequestMapping("/showMchntByPara")
    @ResponseBody
    @CreateLog(description = "query mchnt para")
    public String showMchntByPara(String paraId, IPage page) {
    	if (Strings.isNullOrEmpty(paraId)) {
			return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
		}
        try {
            DataGrid<DeviceAppParaMchnt> mchnts = deviceAppParaService.queryMchntByPara(paraId, page);
            return JSON.toJSONString(mchnts);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
    
    /**
     * @Description:添加终端应用参数信息
     * @param deviceAppPara
     * @return String
     */
    @RequestMapping("/addPara")
    @ResponseBody
    @CreateLog(description = "add device para")
    public String addPara(DeviceAppPara deviceAppPara) {
        try {
            return deviceAppParaService.addPara(deviceAppPara);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
    
    /**
     * @Description:添加终端应用TPDU参数信息
     * @param deviceAppParaTpdu
     * @return String
     */
    @RequestMapping("/addTpdu")
    @ResponseBody
    @CreateLog(description = "add tpdu para")
    public String addTpdu(DeviceAppParaTpdu deviceAppParaTpdu) {
        try {
            return deviceAppParaService.addTpdu(deviceAppParaTpdu);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:添加终端应用MCHNT参数信息
     * @param deviceAppParaMchnt
     * @return String
     */
    @RequestMapping("/addMchnt")
    @ResponseBody
    @CreateLog(description = "add mchnt para")
    public String addMchnt(DeviceAppParaMchnt deviceAppParaMchnt) {
        try {
            return deviceAppParaService.addMchnt(deviceAppParaMchnt);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
    
    /**
     * @Description:修改终端应用MCHNT参数信息
     * @param deviceAppParaMchnt
     * @return String
     */
    @RequestMapping("/updateMchnt")
    @ResponseBody
    @CreateLog(description = "modify mchnt para")
    public String updateMchnt(DeviceAppParaMchnt deviceAppParaMchnt) {
        if (Strings.isNullOrEmpty(deviceAppParaMchnt.getMchntId())) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        try {
            return deviceAppParaService.updateMchnt(deviceAppParaMchnt);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:修改终端应用参数信息
     * @param deviceAppPara
     * @return String
     */
//    @RequestMapping("/updatePara")
//    @ResponseBody
//    public String updatePara(DeviceAppPara deviceAppPara) {
//        if (Strings.isNullOrEmpty(deviceAppPara.getDeviceSn())) {
//            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
//        }
//        if (Strings.isNullOrEmpty(deviceAppPara.getParaVer())) {
//            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
//        }
//        try {
//            return deviceAppParaService.updatePara(deviceAppPara);
//        } catch (Exception e) {
//            logger.error(CommonConstants.SYSTEM_ERROR, e);
//            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
//        }
//    }

    /**
     * @Description:删除终端应用参数信息(物理删除)
     * @param deviceAppPara
     * @return String
     */
//    @RequestMapping("/deletePara")
//    @ResponseBody
//    public String deletePara(DeviceAppPara deviceAppPara) {
//        try {
//        	if (Strings.isNullOrEmpty(deviceAppPara.getDeviceSn())) {
//                return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
//            }
//            if (Strings.isNullOrEmpty(deviceAppPara.getParaVer())) {
//                return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
//            }
//            return deviceAppParaService.deletePara(deviceAppPara);
//        } catch (Exception e) {
//            logger.error(CommonConstants.SYSTEM_ERROR, e);
//            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
//        }
//    }
}