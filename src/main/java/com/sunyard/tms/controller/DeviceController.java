package com.sunyard.tms.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.base.Strings;
import com.sunyard.tms.aop.CreateLog;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.constant.CommonConstants;
import com.sunyard.tms.entity.Device;
import com.sunyard.tms.entity.TerminalKey;
import com.sunyard.tms.service.DeviceService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.IPage;
import com.sunyard.tms.utils.PrimaryKeyUtil;
import com.sunyard.tms.utils.PropertyUtil;
import com.sunyard.tms.utils.TerminalKeyUtil;

/**
 *  * @Description:终端管理 控制层  * @author:zhangbo  * @date:2017年11月30日 下午3:38:45  
 */
@Controller
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;
    

    private static final Logger logger = LoggerFactory.getLogger(DeviceController.class);

    /**
     * @Description:条件分页查询终端信息
     * @param device
     * @param page
     * @return String
     */
    @RequestMapping("/showDevice")
    @ResponseBody
    @CreateLog(description = "query terminal")
    public String showDeviceByPage(Device device, IPage page) {
        try {
            device.setPage(page);
            DataGrid<Device> devices = deviceService.queryDeviceByPage(device);
            return JSON.toJSONString(devices, SerializerFeature.WriteNullStringAsEmpty);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:添加终端信息
     * @param device
     * @return String
     */
    @RequestMapping("/addDevice")
    @ResponseBody
    @CreateLog(description = "add terminal")
    public String addDevice(Device device) {
        try {
            return deviceService.addDevice(device);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:修改终端信息
     * @param device
     * @return String
     */
    @RequestMapping("/updateDevice")
    @ResponseBody
    @CreateLog(description = "modify terminal")
    public String updateDevice(Device device) {
        if (Strings.isNullOrEmpty(device.getDeviceId())) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        try {
            return deviceService.updateDevice(device);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:禁用终端
     * @param device
     * @return String
     */
    @RequestMapping("/disableDevice")
    @ResponseBody
    @CreateLog(description = "disable terminal")
    public String disableDevice(Device device) {
        if (device.getDeviceId() == null) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        try {
            return deviceService.disableDevice(device);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:启用终端
     * @param device
     * @return String
     */
    @RequestMapping("/enableDevice")
    @ResponseBody
    @CreateLog(description = "enable terminal")
    public String enableDevice(Device device) {
        if (device.getDeviceId() == null) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        try {
            return deviceService.enableDevice(device);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:注销终端
     * @param device
     * @return String
     */
    @RequestMapping("/cancleDevice")
    @ResponseBody
    @CreateLog(description = "delete terminal")
    public String cancleDevice(Device device) {
        if (device.getDeviceId() == null) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        try {
            return deviceService.cancleDevice(device);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:查询没有绑定商户的终端
     * @param page
     * @return String
     */
    @RequestMapping("/showNoMerchantDevice")
    @ResponseBody
    public String showNoMerchantDevice(IPage page) {
        try {
            DataGrid<Device> devices = deviceService.showNoMerchantDevice(page);
            return JSON.toJSONString(devices);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
    
    @RequestMapping("/generateTmk")
    @ResponseBody
    @CreateLog(description = "import terminalKey")
    public String generateKey(MultipartFile file){
        try {
            TerminalKey terminalKey = new TerminalKey();
            String hexString = TerminalKeyUtil.BytesToString(file.getBytes());
            String dateTime = hexString.substring(0, 28);
            terminalKey.setCreateTime(dateTime);
            String description = hexString.substring(28, 148);
            terminalKey.setDescription(description);
            String code = hexString.substring(148,152);
            terminalKey.setTmsCode(code);
            String checksum = hexString.substring(hexString.length()-46,hexString.length()-6);
            terminalKey.setChecksum(checksum);
            String filter = hexString.substring(hexString.length()-6,hexString.length());
            terminalKey.setFiller(filter);
            String number = hexString.substring(152,162);
            byte[] bytes = TerminalKeyUtil.StringToBytes(number);
            int count = Integer.parseInt(new String(bytes));
            int i = 1;
            while(i<=count){
                String tmk = hexString.substring(162+80*(i-1),162+80*(i-1)+32);
                terminalKey.setTmk(tmk);
                String tak = hexString.substring(162+80*(i-1)+32,162+80*(i-1)+32+32);
                terminalKey.setTak(tak);
                String rnot = hexString.substring(162+80*(i-1)+32+32,162+80*(i-1)+32+32+16);
                terminalKey.setTmkReferenceNo(rnot);
                terminalKey.setKeyId(PrimaryKeyUtil.getPrimaryKey("TK"));
                terminalKey.setUseFlag("1");
                boolean flag =  deviceService.checkTmk(tmk);
                if (flag) {
                    deviceService.addTmk(terminalKey);
                }else {
                    logger.info("tmk已存在");
                }
                i++;
            }
            return BackResult.back(true, CodeConst.SUCCESS, "import terminal key success"); 
        } catch (IOException e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, "the file is not the TMK file");
        }
    }

    @RequestMapping("/showTerminalKey")
    @ResponseBody
    @CreateLog(description = "query terminalKey")
    public String showTerminalKey(IPage page,TerminalKey terminalKey){
        try {
            DataGrid<TerminalKey> dataGrid = deviceService.showTerminalKey(terminalKey,page);
            return JSON.toJSONString(dataGrid, SerializerFeature.WriteNullStringAsEmpty);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    @RequestMapping("/addTerminalKey")
    @ResponseBody
    @CreateLog(description = "add terminalKey")
    public String addTerminalKey(TerminalKey terminalKey){
        try {
            terminalKey.setUseFlag("1");
            terminalKey.setKeyId(PrimaryKeyUtil.getPrimaryKey("TK"));
            boolean flag =  deviceService.checkTmk(terminalKey.getTmk());
            if (!flag){
                logger.info("tmk已存在");
                return BackResult.back(false, CodeConst.FAIL, "the tmk is exsit");
            }else{
                deviceService.addTmk(terminalKey);
            }
            return BackResult.back(true, CodeConst.SUCCESS, "add terminal key success");
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    @RequestMapping("/deleteTerminalKey")
    @ResponseBody
    @CreateLog(description = "delete terminalKey")
    public String deleteTerminalKey(TerminalKey terminalKey){
        try {
            if ("0".equals(terminalKey.getUseFlag())){
                return BackResult.back(false, CodeConst.FAIL, "The key is in use");
            }
            deviceService.deleteTerminalKey(terminalKey);
            return BackResult.back(true, CodeConst.SUCCESS, "delete terminal key success");
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
}