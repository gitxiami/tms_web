/**
 * 
 */
package com.sunyard.tms.service;

import com.sunyard.tms.dto.AppDto;
import com.sunyard.tms.entity.App;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.IPage;

/**     
 * @Description:App应用管理服务层接口  
 * @author:zhangbin  
 * @date:2017年7月20日 上午9:56:27   
 */
public interface AppService {

    /**    
     * @Description:分页条件查询App
     * @param app
     * @param page
     * @return DataGrid      
     */ 
    DataGrid<AppDto> queryByPage(App app, IPage page);

    /**    
     * @Description:添加App信息
     * @param app
     * @return String      
     */ 
    String addApp(App app);

    /**    
     * @Description:修改App信息
     * @param app
     * @return int      
     */ 
    int updateApp(App app);
    
    /**    
     * @Description:校验App名称
     * @param appName
     * @return boolean      
     */ 
    boolean checkAppName(String appName);

    /**    
     * @Description:上线App
     * @param app
     * @return String      
     */ 
    String onlineApp(App app);

    /**    
     * @Description:删除App
     * @param app
     * @return String      
     */ 
    String deleteApp(App app);

    /**    
     * @Description:下线App
     * @param app 
     * @return String     
     */ 
    String offlineApp(App app);

}
