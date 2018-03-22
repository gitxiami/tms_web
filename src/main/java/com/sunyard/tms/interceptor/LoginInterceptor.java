package com.sunyard.tms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sunyard.tms.constant.SessionConstants;
import com.sunyard.tms.entity.Operator;
import com.sunyard.tms.utils.SessionUtils;

/**     
 * @Description:用户登录拦截器  
 * @author:zhangbin  
 * @date:2017年7月27日 上午10:42:22   
 */
public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURL().toString();
        if (uri.contains("login")||uri.contains("logout")||uri.contains("findPopedoms")||uri.contains("appInterface")) {
            return true;
        }
        // a)拦截用户请求，判断用户是否登录
        HttpSession session = request.getSession();
        Operator operator = SessionUtils.getCurrentOp(session);
        if (operator != null) {
            // b)如果用户已经登录。放行
            return true;
        }
        // c)如果用户未登录，跳转到登录页面。
        response.setStatus(403);
        return false;
    }


    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        
    }


    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        
    }


       
}
