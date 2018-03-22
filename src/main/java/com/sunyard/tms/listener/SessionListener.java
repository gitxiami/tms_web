/**
 * 
 */
package com.sunyard.tms.listener;

import java.util.HashMap;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.sunyard.tms.entity.Operator;
import com.sunyard.tms.utils.SessionUtils;

/**
 * @Description:TODO
 * @author:zhangbin
 * @date:2017年8月21日 下午4:12:52
 */
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext context = session.getServletContext();
        Operator operator = SessionUtils.getCurrentOp(session);
        HashMap<String, HttpSession> sessionMap = (HashMap<String, HttpSession>) context.getAttribute("sessionMap");
        if (sessionMap != null) {
            sessionMap.remove(operator.getOpId());
        }
    }
}
