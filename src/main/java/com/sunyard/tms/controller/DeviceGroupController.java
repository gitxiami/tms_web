package com.sunyard.tms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.sunyard.tms.entity.Device;
import com.sunyard.tms.entity.DeviceGroup;
import com.sunyard.tms.service.DeviceGroupService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.IPage;
import com.sunyard.tms.utils.SessionUtils;

/**
 * @Description:终端组管理 控制层
 * @author:zhangbo
 * @date:2018年2月27日 上午11:18:25
 */
@Controller
@RequestMapping("/deviceGroup")
public class DeviceGroupController {
    @Autowired
    private DeviceGroupService deviceGroupService;

    private static final Logger logger = LoggerFactory.getLogger(DeviceGroupController.class);

    /**
     * @Description:条件分页查询终端组信息
     * @param deviceGroup
     * @param page
     * @return String
     */
    @RequestMapping("/showDeviceGroup")
    @ResponseBody
    public String showDeviceGroupByPage(DeviceGroup deviceGroup, IPage page) {
        try {
            DataGrid<DeviceGroup> dataGrid = deviceGroupService.queryDeviceGroupByPage(deviceGroup, page);
            return JSON.toJSONString(dataGrid);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:添加终端组信息及组内终端
     * @param deviceGroup
     * @param deviceIds
     * @param session
     * @return String
     */
    @RequestMapping("/addDeviceGroup")
    @ResponseBody
    public String addDeviceGroup(DeviceGroup deviceGroup, HttpSession session) {
        if (Strings.isNullOrEmpty(deviceGroup.getGroupName())) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        if (Strings.isNullOrEmpty(deviceGroup.getModelId())) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    	deviceGroup.setCreateOprater(SessionUtils.getCurrentOp(session).getOpUsername());
        try {
            return deviceGroupService.addDeviceGroup(deviceGroup, deviceGroup.getDeviceIds());
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:修改终端组内终端
     * @param deviceGroup
     * @param deviceIds
     * @return String
     */
    @RequestMapping("/updateDeviceGroup")
    @ResponseBody
    public String updateDeviceGroup(DeviceGroup deviceGroup) {
        if (Strings.isNullOrEmpty(deviceGroup.getGroupId())) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        if (deviceGroup.getDeviceIds().isEmpty() || deviceGroup.getDeviceIds().size() == 0) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        try {
            return deviceGroupService.updateDeviceGroup(deviceGroup, deviceGroup.getDeviceIds());
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:删除终端组信息(物理删除,组内终端移出)
     * @param groupId
     * @return String
     */
    @RequestMapping("/deleteDeviceGroup")
    @ResponseBody
    public String deleteDeviceGroup(String groupId) {
    	if (Strings.isNullOrEmpty(groupId)) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        try {
            return deviceGroupService.deleteDeviceGroup(groupId);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
    
    /**
     * @Description:根据终端类型查询全部终端组信息
     * @return String
     */
    @RequestMapping("/allDeviceGroupByModel")
    @ResponseBody
    public String allDeviceGroupByModel(String modelId) {
    	if (Strings.isNullOrEmpty(modelId)) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        try {
        	List<DeviceGroup> list = deviceGroupService.allDeviceGroupByModel(modelId);
            return JSON.toJSONString(list);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
    
    /**
     * @Description:根据终端组查询组全部终端
     * @param groupId
     * @return String
     */
    @RequestMapping("/showDeviceByGroup")
    @ResponseBody
    public String queryDeviceByGroup(String groupId) {
    	if (Strings.isNullOrEmpty(groupId)) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        try {
        	List<Device> devices = deviceGroupService.queryDeviceByGroup(groupId);
            return JSON.toJSONString(devices);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
    
    /**
     * @Description:根据终端型号和终端序列号查询全部未分组终端
     * @param modelId
     * @param deviceSn
     * @return String
     */
    @RequestMapping("/allDeviceWithoutGroup")
    @ResponseBody
    public String allDeviceWithoutGroup(String modelId, String deviceSn) {
    	if (Strings.isNullOrEmpty(modelId)) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        try {
        	List<Device> devices = deviceGroupService.showNoMerchantDevice(modelId, deviceSn);
            return JSON.toJSONString(devices);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
}