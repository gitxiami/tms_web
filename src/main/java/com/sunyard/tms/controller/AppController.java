/**
 * 
 */
package com.sunyard.tms.controller;

import com.alibaba.fastjson.JSON;
import com.sunyard.tms.aop.CreateLog;
import com.sunyard.tms.utils.PropertyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.constant.CommonConstants;
import com.sunyard.tms.dto.AppDto;
import com.sunyard.tms.entity.App;
import com.sunyard.tms.service.AppService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.IPage;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

/**
 * @Description:App应用控制层
 * @author:zhangbin
 * @date:2017年7月20日 上午9:36:58
 */
@RequestMapping("/app")
@Controller
public class AppController {
    @Autowired
    private AppService appService;
    private final static Logger logger = LoggerFactory.getLogger(AppController.class);

    /**
     * @Description:条件查询,分页展示App信息
     * @param app
     * @param page
     * @return String
     */
    @RequestMapping("/showAppByPage")
    @ResponseBody
    @CreateLog(description = "query app")
    public String showAppByPage(App app, IPage page) {
        try {
        	DataGrid<AppDto> dataGrid = appService.queryByPage(app, page);
            return JSON.toJSONString(dataGrid);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:新增App信息
     * @param app
     * @return String
     */
    @RequestMapping("/addApp")
    @ResponseBody
    @CreateLog(description = "add app")
    public String addApp(App app, MultipartFile file) {
        try {
            if(file.getSize()>=50*1024){
                return BackResult.back(false, CodeConst.ERROR, "The file cannot be greater than 50kb");
            }
            BASE64Encoder base64Encoder = new BASE64Encoder();
            String pic = base64Encoder.encode(file.getBytes());
            String originalFilename = file.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
            app.setAppIconType("data:image/"+extName+";base64,");
            app.setAppIcon(pic);
            String backResult = appService.addApp(app);
            return backResult;
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:修改App信息
     * @param app
     * @return String
     */
    @RequestMapping("/updateApp")
    @ResponseBody
    @CreateLog(description = "modify app")
    public String updateApp(App app,MultipartFile file) {
        try {
            BASE64Encoder base64Encoder = new BASE64Encoder();
            if (file!=null) {
                String pic = base64Encoder.encode(file.getBytes());
                String originalFilename = file.getOriginalFilename();
                String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
                app.setAppIconType("data:image/" + extName + ";base64,");
                app.setAppIcon(pic);
            }
            int result = appService.updateApp(app);
            if (result == 1) {
                return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("app.update.ok"));
            } else {
                return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("app.update.Fail"));
            }
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:删除App信息
     * @param app
     * @return String
     */
    @RequestMapping("/deleteApp")
    @ResponseBody
    @CreateLog(description = "delete app")
    public String deleteApp(App app) {
        try {
            String result = appService.deleteApp(app);
            return result;
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:上线App
     * @param app
     * @return String
     */
    @RequestMapping("/onlineApp")
    @ResponseBody
    @CreateLog(description = "online app")
    public String onlineApp(App app) {
        try {
            String backResult = appService.onlineApp(app);
            return backResult;
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**    
     * @Description:下线App
     * @param app
     * @return String      
     */ 
    @RequestMapping("/offlineApp")
    @ResponseBody
    @CreateLog(description = "offline app")
    public String offlineApp(App app) {
        try {
            String result = appService.offlineApp(app);
            return result;
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
}
