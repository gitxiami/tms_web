package com.sunyard.tms.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.sunyard.tms.utils.PopedomHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.constant.CommonConstants;
import com.sunyard.tms.constant.SessionConstants;
import com.sunyard.tms.constant.StatusConstants;
import com.sunyard.tms.entity.Popedom;
import com.sunyard.tms.service.PopedomService;
import com.sunyard.tms.utils.BackResult;

/**
 *  @Description:权限管理 控制层    @author:zhangbo    @date:2017年7月17日 上午9:30:03  
 */
@Controller
@RequestMapping("/popedom")
public class PopedomController {
    @Autowired
    private PopedomService popedomService;

    private static final Logger logger = LoggerFactory.getLogger(PopedomController.class);

    /**
     * @Description:获取所有权限
     * @return String
     */
    @RequestMapping(value = "/allPopedom")
    @ResponseBody
    public String allPopedom() {
        try {
            List<Popedom> popedoms = popedomService.queryAllPopedoms();
            return JSON.toJSONString(popedoms);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }


    /**
     * @Description:获取当前用户的权限
     * @return String
     */
    @RequestMapping(value = "/findPopedoms")
    @ResponseBody
    public String findPopedoms(HttpSession session) {
        try {
            List<Popedom> popedoms = (List<Popedom>) session.getAttribute(SessionConstants.POPEDOM);
            if (popedoms != null) {
                List<Popedom> menu = new ArrayList<>();
                List<Popedom> button = new ArrayList<>();
                for (Popedom popedom : popedoms) {
                    if (popedom.getPopedomType().equals(StatusConstants.POPEDOM_BUTTON)) {
                        button.add(popedom);
                    } else {
                        menu.add(popedom);
                    }
                }
                Map<String, List<Popedom>> map = new LinkedHashMap<>();
                map.put("menu", PopedomHelper.getTree(menu));
                map.put("button", button);
                logger.info(map.toString());
                return JSON.toJSONString(map);
            }
            return BackResult.back(false, CodeConst.ERROR, "获取权限信息失败,请重新登录!");
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, "获取权限信息失败,请重新登录!");
        }
    }
}
