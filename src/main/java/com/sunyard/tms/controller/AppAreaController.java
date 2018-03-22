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
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.constant.CommonConstants;
import com.sunyard.tms.entity.AppArea;
import com.sunyard.tms.service.AppAreaService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.IPage;

/**
 * @Description:应用地区管理 控制层
 * @author:zhangbo
 * @date:2018年1月31日 上午10:45:59
 */
@Controller
@RequestMapping("/appArea")
public class AppAreaController {
    @Autowired
    private AppAreaService appAreaService;

    private static final Logger logger = LoggerFactory.getLogger(AppAreaController.class);

    /**
     * @Description:条件分页查询应用地区信息
     * @param appArea
     * @param page
     * @return String
     */
    @RequestMapping("/showAppArea")
    @ResponseBody
    public String showAppAreaByPage(AppArea appArea, IPage page) {
        try {
            DataGrid<AppArea> areas = appAreaService.queryAppAreaByPage(appArea, page);
            return JSON.toJSONString(areas);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:添加应用地区信息
     * @param appArea
     * @return String
     */
    @RequestMapping("/addAppArea")
    @ResponseBody
    public String addAppArea(AppArea appArea) {
        try {
            return appAreaService.addAppArea(appArea);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:修改应用地区信息
     * @param appArea
     * @return String
     */
    @RequestMapping("/updateAppArea")
    @ResponseBody
    public String updateAppArea(AppArea appArea) {
        if (Strings.isNullOrEmpty(appArea.getAppAreaId())) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        try {
            return appAreaService.updateAppArea(appArea);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:删除应用地区信息(物理删除)
     * @param appArea
     * @return String
     */
    @RequestMapping("/deleteAppArea")
    @ResponseBody
    public String deleteAppArea(AppArea appArea) {
        try {
        	if (Strings.isNullOrEmpty(appArea.getAppAreaId())) {
                return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
            }
            return appAreaService.deleteAppArea(appArea);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
    
    /**
     * @Description:查询全部应用地区
     * @param appArea
     * @return String
     */
    @RequestMapping("/showAllAppArea")
    @ResponseBody
    public String showAllAppArea(AppArea appArea) {
        try {
        	List<AppArea> areas = appAreaService.queryAllAppArea(appArea);
            return JSON.toJSONString(areas);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
}