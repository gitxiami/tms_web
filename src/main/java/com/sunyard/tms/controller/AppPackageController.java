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
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.sunyard.tms.aop.CreateLog;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.constant.CommonConstants;
import com.sunyard.tms.dto.FileDto;
import com.sunyard.tms.entity.App;
import com.sunyard.tms.entity.AppPackage;
import com.sunyard.tms.entity.AppPackageKey;
import com.sunyard.tms.service.AppPackageService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.FileUtils;
import com.sunyard.tms.utils.IPage;

import java.io.IOException;

/**
 * @Description:App应用包控制层
 * @author:zhangbin
 * @date:2017年7月21日 上午11:55:15
 */
@Controller
@RequestMapping("/appPkg")
public class AppPackageController {
    @Autowired
    private AppPackageService appPackageService;

    private final static Logger logger = LoggerFactory.getLogger(AppPackageController.class);

    /**
     * @param app
     * @param appPackage
     * @param page
     * @return String
     * @Description:分页查询App应用包
     */
    @RequestMapping("/showAppPkgByPage")
    @ResponseBody
    @CreateLog(description = "query appPackage")
    public String showAppPkgByPage(App app, AppPackage appPackage, IPage page) {
        try {
        	DataGrid<AppPackage> dataGrid = appPackageService.queryByPage(app, appPackage, page);
            return JSONObject.toJSONString(dataGrid);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @param appPackage
     * @param uploadFile
     * @return String
     * @Description:上传App应用包
     */
    @RequestMapping("/uploadAppPkg")
    @ResponseBody
    @CreateLog(description = "upload appPackage")
    public String uploadAppPkg(AppPackage appPackage, MultipartFile uploadFile) {
        try {
            String result = appPackageService.insert(appPackage, uploadFile);
            return result;
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @param appPackage
     * @return ResponseEntity<byte[]>
     * @Description:下载App应用包
     */
    @RequestMapping("/downloadAppPkg")
    @CreateLog(description = "download appPackage")
    public String downloadAppPkg(AppPackage appPackage, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            FileDto fileDto = appPackageService.downloadAppPkg(appPackage);
            return FileUtils.downloadFile(session, request, response, fileDto);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return null;
        }
    }



    /**
	 * @Description:根据主键查询应用包信息
	 * @param key
	 * @return String
	 */
	@RequestMapping("/queryAppPkgByPrimaryKey")
	@ResponseBody
	public String queryAppPkgByPrimaryKey(AppPackageKey key) {
		if (Strings.isNullOrEmpty(key.getAppId()) || Strings.isNullOrEmpty(key.getAppPkgVer())) {
			return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
		}
		try {
			AppPackage appPkg = appPackageService.queryAppPkgByPrimaryKey(key);
			return JSONObject.toJSONString(appPkg);
		} catch (Exception e) {
			logger.error(CommonConstants.SYSTEM_ERROR, e);
			return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
		}
	}

	@RequestMapping("/deleteAppPkg")
    @ResponseBody
    @CreateLog(description = "delete App package")
	public String deleteAppPkg(AppPackage appPackage){
        try {
            appPackageService.delete(appPackage);
            return BackResult.back(true, CodeConst.SUCCESS, "delelte success");
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
}
