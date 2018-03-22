package com.sunyard.tms.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.constant.CommonConstants;
import com.sunyard.tms.dto.FileDto;
import com.sunyard.tms.entity.DeviceLog;
import com.sunyard.tms.service.DeviceLogService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.FileUtils;
import com.sunyard.tms.utils.IPage;

/**
 * @Description:终端日志 控制层
 * @author:zhangbo
 * @date:2018年1月8日 上午11:36:30
 */
@Controller
@RequestMapping("/deviceLog")
public class DeviceLogController {
    @Autowired
    private DeviceLogService deviceLogService;

    private final static Logger logger = LoggerFactory.getLogger(DeviceLogController.class);

    /**
     * @Description:条件分页查询终端日志文件信息
     * @param deviceLog
     * @param page
     * @return String
     */
    @RequestMapping("/showDeviceLogByPage")
    @ResponseBody
    public String showDeviceLogByPage(DeviceLog deviceLog, IPage page) {
        try {
        	DataGrid<DeviceLog> dataGrid = deviceLogService.queryByPage(deviceLog, page);
            return JSONObject.toJSONString(dataGrid);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:下载终端日志文件
     * @param deviceLog
     * @param session
     * @param request
     * @param response
     * @return String
     */
    @RequestMapping("/downloadDeviceLog")
    public String downloadDeviceLog(DeviceLog deviceLog, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            FileDto fileDto = deviceLogService.downloadDeviceLog(deviceLog);
            ServletContext servletContext = session.getServletContext();
            ServletOutputStream outputStream = response.getOutputStream();
            String filename = new String(fileDto.getFileName().getBytes("ISO-8859-1"),"UTF-8");
            filename =
                    FileUtils.encodeDownloadFilename(filename,request.getHeader("user-agent"));
            String mimeType = servletContext.getMimeType(filename);
            response.setContentType(mimeType);
            response.setHeader("content-disposition", "attachment;filename=" + filename);
            outputStream.write(fileDto.getSteam());
            return null;
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return null;
        }
    }
}
