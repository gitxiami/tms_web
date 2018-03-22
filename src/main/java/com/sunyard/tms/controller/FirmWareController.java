package com.sunyard.tms.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunyard.tms.aop.CreateLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.constant.CommonConstants;
import com.sunyard.tms.dto.FileDto;
import com.sunyard.tms.entity.FirmWare;
import com.sunyard.tms.service.FirmWareService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.FileUtils;
import com.sunyard.tms.utils.IPage;

/**
 * @Description:固件控制层
 * @author:zhangbo
 * @date:2017年12月4日 下午4:20:05
 */
@Controller
@RequestMapping("/firmWare")
public class FirmWareController {
    @Autowired
    private FirmWareService firmWareService;

    private final static Logger logger = LoggerFactory.getLogger(FirmWareController.class);

    /**
     * @Description:分页查询固件
     * @param firmWare
     * @param page
     * @return String
     */
    @RequestMapping("/showFirmWareByPage")
    @ResponseBody
    @CreateLog(description = "query firmware")
    public String showFirmWareByPage(FirmWare firmWare, IPage page) {
        try {
        	DataGrid<FirmWare> dataGrid = firmWareService.queryByPage(firmWare, page);
            return JSONObject.toJSONString(dataGrid);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:上传固件
     * @param firmWare
     * @param uploadFile
     * @return String
     */
    @RequestMapping("/uploadFirmWare")
    @ResponseBody
    @CreateLog(description = "upload firmware")
    public String uploadFirmWare(FirmWare firmWare, MultipartFile uploadFile) {
        try {
            String result = firmWareService.insert(firmWare, uploadFile);
            return result;
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:下载固件
     * @param firmWare
     * @param session
     * @param request
     * @param response
     * @return String
     */
    @RequestMapping("/downloadFirmWare")
    @CreateLog(description = "download firmware")
    public String downloadFirmWare(FirmWare firmWare, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            FileDto fileDto = firmWareService.downloadFirmWare(firmWare);
            return FileUtils.downloadFile(session, request, response, fileDto);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return null;
        }
    }
    
    /**
     * @Description:固件上线
     * @param firmWare
     * @return String
     */
    @RequestMapping("/onlineFirmWare")
    @ResponseBody
    @CreateLog(description = "online firmware")
    public String onlineFirmWare(FirmWare firmWare) {
        try {
            String backResult = firmWareService.onlineFirmWare(firmWare);
            return backResult;
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
    
    /**    
     * @Description:固件下线
     * @param firmWare
     * @return String      
     */ 
    @RequestMapping("/offlineFirmWare")
    @ResponseBody
    @CreateLog(description = "offline firmware")
    public String offlineFirmWare(FirmWare firmWare) {
        try {
            String result = firmWareService.offlineFirmWare(firmWare);
            return result;
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    @RequestMapping("/deleteFirmWare")
    @ResponseBody
    @CreateLog(description = "delete firmware")
    public String deleteFirmWare(FirmWare firmWare){
        try {
            firmWareService.del(firmWare);
            return BackResult.back(true, CodeConst.SUCCESS, "delelte success");
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
}