/**
 * 
 */
package com.sunyard.tms.aop;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.sunyard.tms.constant.SessionConstants;
import com.sunyard.tms.constant.StatusConstants;
import com.sunyard.tms.entity.OperationLog;
import com.sunyard.tms.entity.Operator;
import com.sunyard.tms.service.OperationLogService;
import com.sunyard.tms.service.OrganizationService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DateFormat;
import com.sunyard.tms.utils.IpUtils;
import com.sunyard.tms.utils.PrimaryKeyUtil;
import com.sunyard.tms.utils.SessionUtils;

/**
 * @Description:日志生成切面类
 * @author:zhangbin
 * @date:2017年7月25日 下午1:45:17
 */
@Aspect
@Component
public class SystemLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);
    @Autowired
    private OperationLogService operationLogService;
    @Autowired
    private OrganizationService organizationService;

    // Controller层切点
    @Pointcut("@annotation(com.sunyard.tms.aop.CreateLog)")
    public void controllerAspect() {

    }

    /**
     * 后置通知 用于拦截Controller层记录用户的操作,生成日志
     * 
     * @param joinPoint 切点
     */
    @AfterReturning(returning = "result", pointcut = "controllerAspect()")
    public void doBefore(JoinPoint joinPoint, String result) {
        try {
            HttpServletRequest request =
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();
            createLog(joinPoint, result, request, session);
        } catch (Exception e) {
            logger.error("日志信息记录出错", e);
        }
    }

    /**
     * @Description:生成日志信息,插入数据库
     * @param joinPoint
     * @param result
     * @param request
     * @param session
     * @throws Exception void
     */
    public void createLog(JoinPoint joinPoint, String result, HttpServletRequest request, HttpSession session)
            throws Exception {
        // 取得当前用户
        Operator operator = SessionUtils.getCurrentOp(session);
        if (operator != null) {
            OperationLog log = new OperationLog();
            // 日志Id
            log.setLogId(PrimaryKeyUtil.getPrimaryKey("LOG"));
            // 当前操作员Id
            log.setOpId(operator.getOpId());
            // 当前操作员用户名
            log.setOpUsername(operator.getOpUsername());
            // 当前操作员IP
            log.setOpIp(IpUtils.getIpAddr(request));
            // 当前操作员机构
            log.setOrgId(operator.getOrgId());
            log.setOrgName(organizationService.findOrgById(operator.getOrgId()).getOrgName());
            // 取得方法注解上的描述
            String description = getControllerMethodDescription(joinPoint);
            // 操作代码
            log.setLogCode(description);
            // 操作名称
            log.setLogName(description);
            // 判断返回值
            String message = "message";
            if (result instanceof String && result.contains(message)) {
                BackResult backResult = JSON.parseObject(result, BackResult.class);
                if (backResult.getType()) {
                    // 操作成功
                    log.setLogStatus(StatusConstants.LOG_SUCCESS);
                } else {
                    log.setLogStatus(StatusConstants.LOG_FAIL);
                }
                Date date = new Date();
                log.setUpdateDatetime(DateFormat.dateTimeFormat(date));
                log.setCreatedDatetime(DateFormat.dateTimeFormat(date));
                operationLogService.addLog(log);
            } else {
                // 不含message,即为正常查询或者文件下载
                log.setLogStatus(StatusConstants.LOG_SUCCESS);
                Date date = new Date();
                log.setUpdateDatetime(DateFormat.dateTimeFormat(date));
                log.setCreatedDatetime(DateFormat.dateTimeFormat(date));
                operationLogService.addLog(log);
            }
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     * 
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(CreateLog.class).description();
                    break;
                }
            }
        }
        return description;
    }
}
