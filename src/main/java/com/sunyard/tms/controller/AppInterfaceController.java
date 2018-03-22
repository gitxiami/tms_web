package com.sunyard.tms.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.constant.CommonConstants;
import com.sunyard.tms.dto.DeviceAppParaDto;
import com.sunyard.tms.dto.FileDto;
import com.sunyard.tms.entity.App;
import com.sunyard.tms.entity.AppPackage;
import com.sunyard.tms.entity.DeviceAppPara;
import com.sunyard.tms.entity.DeviceLog;
import com.sunyard.tms.entity.DeviceParam;
import com.sunyard.tms.entity.FirmWare;
import com.sunyard.tms.entity.PospParam;
import com.sunyard.tms.entity.TerminalKey;
import com.sunyard.tms.service.AppPackageService;
import com.sunyard.tms.service.DeviceAppParaService;
import com.sunyard.tms.service.DeviceLogService;
import com.sunyard.tms.service.DeviceParamService;
import com.sunyard.tms.service.DeviceService;
import com.sunyard.tms.service.FirmWareService;
import com.sunyard.tms.service.OrganizationService;
import com.sunyard.tms.service.PospParamService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.FileUtils;

/**
 * @Description:APP端接口整合 服务层
 * @author:zhangbo
 * @date:2017年12月7日 下午3:09:56
 */
@Controller
@RequestMapping("/appInterface")
public class AppInterfaceController {
	@Autowired
	private AppPackageService appPackageService;
	@Autowired
	private DeviceAppParaService deviceAppParaService;
	@Autowired
	private DeviceService deviceService;
	@Autowired
	private DeviceLogService deviceLogService;
	@Autowired
	private FirmWareService firmWareService;
	@Autowired
    private PospParamService pospParamService;
	@Autowired
    private OrganizationService orgService;
	@Autowired
    private DeviceParamService deviceParamService;
	
	private final static Logger logger = LoggerFactory.getLogger(AppInterfaceController.class);

	public JSONObject getData(String data)
	{
		JSONObject reqHeader = JSON.parseObject(data);
		return reqHeader;
	}
	
	/**
	 * @Description:查询全部应用信息及最新应用包信息
	 * @param devSn
	 * @param request
	 * @param response
	 * @return String
	 */
	@RequestMapping("/queryLatestVersionApp")
	@ResponseBody
	public String queryLatestVersionApp(@RequestBody String app, HttpServletRequest request, HttpServletResponse response) {
		String devSn = getData(app).getString("devSn");
		String appId = getData(app).getString("appId");
		String appName = getData(app).getString("appName");
		String orgName = getData(app).getString("orgName");
		String orgId = null;
		if (Strings.isNullOrEmpty(devSn)) {
			return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
		}
		if (!Strings.isNullOrEmpty(orgName)) {
			orgId = orgService.findOrgIdByName(orgName);
			if (Strings.isNullOrEmpty(orgId)) {
				return orgId;
			}
		}
		try {
			List<App> apps = appPackageService.queryLatestVersionApp(devSn, appId, appName, orgId);
			return JSONObject.toJSONString(apps);
		} catch (Exception e) {
			logger.error(CommonConstants.SYSTEM_ERROR, e);
			return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
		}
	}

	/**
	 * @Description:下载App应用包
	 */
	@RequestMapping("/downloadAppPkg")
	public String downloadAppPkg(AppPackage appPackage, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			FileDto fileDto = appPackageService.downloadAppPkg(appPackage);
			ServletContext servletContext = session.getServletContext();
			ServletOutputStream outputStream = response.getOutputStream();
			String filename = new String(fileDto.getFileName().getBytes("ISO-8859-1"), "UTF-8");
			filename = FileUtils.encodeDownloadFilename(filename, request.getHeader("user-agent"));
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

	/**
	 * @Description:查询最新固件信息
	 * @param request
	 * @param response
	 * @return String
	 */
	@RequestMapping("/queryLatestFirmWare")
	@ResponseBody
	public String queryLatestFirmWare(HttpServletRequest request, HttpServletResponse response) {
		try {
			FirmWare latestFirmWare = firmWareService.queryLatestFirmWare();
			return JSONObject.toJSONString(latestFirmWare);
		} catch (Exception e) {
			logger.error(CommonConstants.SYSTEM_ERROR, e);
			return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
		}
	}

	/**
	 * @Description:下载固件
	 * @param session
	 * @param request
	 * @param response
	 * @return String
	 */
	@RequestMapping("/downloadFirmWare")
	public String downloadFirmWare(FirmWare firmWare, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		if (Strings.isNullOrEmpty(firmWare.getFirmId())) {
			return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
		}
		try {
			FileDto fileDto = firmWareService.downloadFirmWare(firmWare);
			ServletContext servletContext = session.getServletContext();
			ServletOutputStream outputStream = response.getOutputStream();
			String filename = new String(fileDto.getFileName().getBytes("ISO-8859-1"), "UTF-8");
			filename = FileUtils.encodeDownloadFilename(filename, request.getHeader("user-agent"));
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

	/**
	 * @Description:根据终端序列号查询最新参数信息
	 * @param deviceAppPara
	 * @param request
	 * @param response
	 * @return String
	 */
	@RequestMapping("/queryLatestVersionPara")
	@ResponseBody
	public String queryLatestVersionPara(@RequestBody String deviceAppParaJson, HttpServletRequest request,
			HttpServletResponse response) {
		String deviceSn = getData(deviceAppParaJson).getString("devSn");
		DeviceAppPara deviceAppPara = new DeviceAppPara();
		deviceAppPara.setDeviceSn(deviceSn);
		if (Strings.isNullOrEmpty(deviceAppPara.getDeviceSn())) {
			return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
		}
		try {
			DeviceAppParaDto latestVersionPara = deviceAppParaService.queryLatestVersionPara(deviceAppPara);
			return JSONObject.toJSONString(latestVersionPara);
		} catch (Exception e) {
			logger.error(CommonConstants.SYSTEM_ERROR, e);
			return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
		}
	}
	
	/**
	 * @Description:根据终端序列号查询终端密钥
	 * @param devSn
	 * @param request
	 * @param response
	 * @return String
	 */
	@RequestMapping("/queryDevKey")
	@ResponseBody
	public String queryDevKey(@RequestBody String devSn, HttpServletRequest request, HttpServletResponse response) {
		devSn = getData(devSn).getString("devSn");
		if (Strings.isNullOrEmpty(devSn)) {
			return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
		}
		try {
			List<TerminalKey> keys = deviceService.queryDevKey(devSn);
			return JSONObject.toJSONString(keys);
		} catch (Exception e) {
			logger.error(CommonConstants.SYSTEM_ERROR, e);
			return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
		}
	}
	
	/**
	 * @Description:查询公钥和磁条卡参数
	 * @param pospParam
	 * @param request
	 * @param response
	 * @return String
	 */
	@RequestMapping("/queryPospParam")
	@ResponseBody
	public String queryPospParam(@RequestBody String pospParamJson, HttpServletRequest request, HttpServletResponse response) {
		String paramType = getData(pospParamJson).getString("paramType");
		String paramNo = getData(pospParamJson).getString("paramNo");
		PospParam pospParam = new PospParam();
		pospParam.setParamType(paramType);
		pospParam.setParamNo(paramNo);
		if (Strings.isNullOrEmpty(pospParam.getParamType())) {
			return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
		}
		try {
			List<PospParam> pospParams = pospParamService.queryPospParam(pospParam);
			return JSONObject.toJSONString(pospParams);
		} catch (Exception e) {
			logger.error(CommonConstants.SYSTEM_ERROR, e);
			return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
		}
	}
	
    /**
     * @Description:上传终端日志
     * @param deviceLog
     * @param uploadFile
     * @return String
     */
    @RequestMapping("/uploadDeviceLog")
    @ResponseBody
    public String uploadDeviceLog(@RequestBody String deviceLogJson, MultipartFile uploadFile) {
    	String deviceSn = getData(deviceLogJson).getString("deviceSn");
    	DeviceLog deviceLog = new DeviceLog();
    	deviceLog.setDeviceSn(deviceSn);
    	if (Strings.isNullOrEmpty(deviceLog.getDeviceSn())) {
			return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
		}
        try {
            String result = deviceLogService.uploadDeviceLog(deviceLog, uploadFile);
            return result;
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
    
	/**
	 * @Description:根据终端序列号查询终端参数
	 * @param devSn
	 * @param request
	 * @param response
	 * @return String
	 */
	@RequestMapping("/queryDevParaBySn")
	@ResponseBody
	public String queryDevParaBySn(@RequestBody String devSn, HttpServletRequest request, HttpServletResponse response) {
		devSn = getData(devSn).getString("devSn");
		if (Strings.isNullOrEmpty(devSn)) {
			return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
		}
		try {
			List<DeviceParam> params = deviceParamService.queryDevParaBySn(devSn);
			return JSONObject.toJSONString(params);
		} catch (Exception e) {
			logger.error(CommonConstants.SYSTEM_ERROR, e);
			return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
		}
	}
}