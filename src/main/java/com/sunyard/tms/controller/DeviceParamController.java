package com.sunyard.tms.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.constant.CommonConstants;
import com.sunyard.tms.entity.Device;
import com.sunyard.tms.entity.DeviceParam;
import com.sunyard.tms.service.DeviceGroupService;
import com.sunyard.tms.service.DeviceParamService;
import com.sunyard.tms.utils.BackResult;

/**
 * @Description:终端参数管理 控制层
 * @author:zhangbo
 * @date:2018年3月2日 下午4:00:47
 */
@Controller
@RequestMapping("/deviceParam")
public class DeviceParamController {
    @Autowired
    private DeviceParamService deviceParamService;
    @Autowired
    private DeviceGroupService deviceGroupService;

    private static final Logger logger = LoggerFactory.getLogger(DeviceParamController.class);

    /**
     * @Description:条件分页查询终端参数信息
     * @param deviceParam
     * @return String
     */
    @RequestMapping("/showParamByDevice")
    @ResponseBody
    public String showParamByDevice(DeviceParam deviceParam) {
        try {
        	List<DeviceParam> deviceParams = deviceParamService.queryParamByDevice(deviceParam);
            return JSON.toJSONString(deviceParams);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
    
    /**
     * @Description:添加终端参数信息
     * @param deviceParam
     * @return String
     */
    @RequestMapping("/addDeviceParam")
    @ResponseBody
    public String addDeviceParam(DeviceParam deviceParam) {
        if (Strings.isNullOrEmpty(deviceParam.getDeviceId())) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        if (Strings.isNullOrEmpty(deviceParam.getParamName())) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        if (Strings.isNullOrEmpty(deviceParam.getParamValue())) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        if (Strings.isNullOrEmpty(deviceParam.getParamStatus())) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        if (Strings.isNullOrEmpty(deviceParam.getParameter())) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        try {
            return deviceParamService.addDeviceParam(deviceParam);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
    
    /**
     * @Description:根据主键批量修改参数值
     * @param deviceParams
     * @return String
     */
    @RequestMapping("/updateParam")
    @ResponseBody
    public String updateParam(String deviceParams) {
		List<DeviceParam> deviceParamList = JSON.parseArray(deviceParams,DeviceParam.class);
        if (deviceParamList.isEmpty() || deviceParamList.size() == 0) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        try {
            return deviceParamService.updateParam(deviceParamList);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
    
    /**    
     * @Description:根据主键批量删除参数(物理删除)
     * @param deviceParam
     * @return String
     */
    @RequestMapping("/deleteParam")
    @ResponseBody
    public String deleteParam(DeviceParam deviceParam) {
        if (deviceParam.getParamIds().isEmpty() || deviceParam.getParamIds().size() == 0) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        try {
            return deviceParamService.deleteParam(deviceParam.getParamIds());
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
    
    /**
     * @Description:参数文件解析并回显
     * @param uploadFile
     * @return String
     */
    @RequestMapping("/readParamFile")
    @ResponseBody
    public String readParamFile(MultipartFile uploadFile) {
    	// 判断是否为空
    	if (uploadFile.isEmpty()) {
			return null;
		}
        try {
        	List<DeviceParam> deviceParams = new ArrayList<DeviceParam>();
        	InputStream in = uploadFile.getInputStream();
        	InputStreamReader is = new InputStreamReader(in);
        	BufferedReader br = new BufferedReader(is);
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                line = line.trim();
                DeviceParam deviceParam = new DeviceParam();
                deviceParam.setParamStatus(StringUtils.substringBefore(line, "="));
                deviceParam.setParamName(StringUtils.substringBefore(StringUtils.substringAfter(line, "="), "="));
                deviceParam.setParamValue(StringUtils.substringBefore(StringUtils.substringAfterLast(line, "="), ";"));
                deviceParam.setParameter(StringUtils.substringAfter(line, ";"));
                deviceParams.add(deviceParam);
            }
            return JSON.toJSONString(deviceParams);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:终端组导入参数
     * @param groupId
     * @param deviceParams
     * @return String
     */
    @RequestMapping("/addParamByGroup")
    @ResponseBody
    public String addParamByGroup(String groupId, String deviceParams) {
        if (Strings.isNullOrEmpty(groupId)) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
		List<DeviceParam> deviceParamList = JSON.parseArray(deviceParams,DeviceParam.class);
        if (deviceParamList.isEmpty() || deviceParamList.size() == 0) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        try {
        	// 查询组内全部终端
        	List<Device> devices = deviceGroupService.queryDeviceByGroup(groupId);
        	// 导入参数
            return deviceParamService.addParamByGroup(devices, deviceParamList);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
}