/**
 * 
 */
package com.sunyard.tms.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sunyard.tms.aop.CreateLog;
import com.sunyard.tms.entity.Popedom;
import com.sunyard.tms.service.PopedomService;
import com.sunyard.tms.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.constant.CommonConstants;
import com.sunyard.tms.constant.SessionConstants;
import com.sunyard.tms.entity.Operator;
import com.sunyard.tms.service.OperatorService;
import com.sunyard.tms.service.OrganizationService;

/**
 * @Description:用户登录相关控制层
 * @author:zhangbin
 * @date:2017年7月12日 下午5:48:02
 */
@Controller
public class LoginController {
    @Autowired
    private OperatorService operatorService;
    @Autowired
    private PopedomService popedomService;


    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * @Description:用户登录操作方法
     * @return String
     */
    @RequestMapping("/login")
    @ResponseBody
    @CreateLog(description = "login")
    public String login(HttpSession session, Operator operator) {

        try {
            Operator loginOperator = operatorService.login(operator);
            String message = loginOperator.getMessage();
            if (message == null) {
                return checkIsDefPwd(session, loginOperator);
            } else {
                return BackResult.back(false, CodeConst.FAIL, message);
            }
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:登录成功,判断是否需要修改面
     * @param session
     * @param loginOperator
     * @return String
     */
    public String checkIsDefPwd(HttpSession session, Operator loginOperator) {
        // 用户权限
        List<Popedom> opPopedom = popedomService.findByUserId(loginOperator.getOpId());
        if (opPopedom.size() <= 0) {
            return BackResult.back(false, CodeConst.FAIL, "没有任何管理权限,无法登陆");
        }
        // 从配置文件中读取初始密码
        String defaultPwd = PropertyUtil.getParam("defaultPwd");
        String MD5DefaultPwd = DigestUtils.md5DigestAsHex(defaultPwd.getBytes());
        if (loginOperator.getOpPwd().equals(MD5DefaultPwd)) {
            // 用户需要修改密码
            session.setAttribute(SessionConstants.OPERATOR, loginOperator);
            return BackResult.back(true, CodeConst.RESET, PropertyUtil.getValue("user.toUpdatePwd"));
        }
        session.setAttribute(SessionConstants.OPERATOR, loginOperator);
        session.setAttribute(SessionConstants.POPEDOM, opPopedom);
        checkIsLogin(session, loginOperator);
        return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("user.loginSuc"));
    }

    /**
     * @Description:校验此账号是否已经登录,踢掉上一个登录得人
     * @param session
     * @param loginOperator void
     */
    public void checkIsLogin(HttpSession session, Operator loginOperator) {
        ServletContext servletContext = session.getServletContext();
        HashMap<String, HttpSession> sessionMap =
                (HashMap<String, HttpSession>) servletContext.getAttribute("sessionMap");
        // 若sessionMap中的信息不为空,说明此时有人处于登陆状态
        if (null != sessionMap && null != sessionMap.get(loginOperator.getOpId())) {
            // 第一次登录的用户session销毁
            // 将第一次登录用户的信息从map中移除
            // 本次登录用户添加到map中
            HttpSession hs = sessionMap.get(loginOperator.getOpId());
            if (session != hs) {
                // 避免自己踢掉自己
                sessionMap.remove(loginOperator.getOpId());
                hs.invalidate();
                sessionMap.put(loginOperator.getOpId(), session);
                servletContext.setAttribute("sessionMap", sessionMap);
            }
        } else {
            // 以用户id为key键存入map中，以判断下一次登录的人
            sessionMap = new LinkedHashMap<>();
            sessionMap.put(loginOperator.getOpId(), session);
            servletContext.setAttribute("sessionMap", sessionMap);
        }
    }

    /**
     * @Description:用户退出登录
     * @param session
     */
    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpSession session) {
        try {
            // 取得当前用户
            Operator operator = SessionUtils.getCurrentOp(session);
            if (operator != null) {
                ServletContext servletContext = session.getServletContext();
                HashMap<String, HttpSession> sessionMap =
                        (HashMap<String, HttpSession>) servletContext.getAttribute("sessionMap");
                // 退出登录移除sessionMap中的信息
                sessionMap.remove(operator.getOpId());
                session.invalidate();
            } else {
                return BackResult.back(true, CodeConst.FAIL, PropertyUtil.getValue("user.loginNull"));
            }
            return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("user.logoutSuc"));
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
}
