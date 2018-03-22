/**
 * 
 */
package com.sunyard.tms.service;

import java.util.List;

import com.sunyard.tms.entity.OperationLog;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.IPage;

/**     
 * @Description:操作日志服务层  
 * @author:zhangbin  
 * @date:2017年7月25日 下午4:04:40   
 */
public interface OperationLogService {

    /**    
     * @Description:添加日志信息
     * @param log void      
     */ 
    void addLog(OperationLog log);

    /**    
     * @Description:分页查询日志信息
     * @param operationLog
     * @param page
     * @return List<OperationLog>      
     */ 
    DataGrid<OperationLog> findAllLog(OperationLog operationLog, IPage page);

    List<OperationLog> findAllLogList();
}
