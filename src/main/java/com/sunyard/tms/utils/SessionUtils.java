/**
 * 
 */
package com.sunyard.tms.utils;

import javax.servlet.http.HttpSession;

import com.sunyard.tms.constant.SessionConstants;
import com.sunyard.tms.entity.Operator;

/**     
 * @Description:TODO  
 * @author:zhangbin  
 * @date:2017年8月17日 下午5:21:06   
 */
public class SessionUtils {
    public static Operator getCurrentOp(HttpSession session){
        Operator currentOp =  (Operator) session.getAttribute(SessionConstants.OPERATOR);
        return currentOp;
    }
}
