/**
 * 
 */
package com.sunyard.tms.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sunyard.tms.dto.FileDto;
import com.sunyard.tms.entity.App;
import com.sunyard.tms.entity.AppPackage;
import com.sunyard.tms.entity.AppPackageKey;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.IPage;

/**     
 * @Description:App应用包服务层接口  
 * @author:zhangbin  
 * @date:2017年7月21日 下午1:49:04   
 */
public interface AppPackageService {

    /**    
     * @Description:判断App是否有应用包
     * @param appId
     * @return boolean      
     */ 
    boolean isAppHasPackages(String appId);

    /**    
     * @param appPackage 
     * @param app 
     * @param page 
     * @Description:分页查询App应用包
     * @return List<AppPackage>      
     */ 
    DataGrid<AppPackage> queryByPage(App app, AppPackage appPackage, IPage page);

    /**    
     * @Description:添加App应用包,上传文件
     * @param appPackage void      
     * @param uploadFile 
     */ 
    String insert(AppPackage appPackage, MultipartFile uploadFile);

    /**    
     * @Description:文件下载
     * @param appPackage void      
     * @return 
     * @throws UnsupportedEncodingException 
     */ 
    FileDto downloadAppPkg(AppPackage appPackage) throws UnsupportedEncodingException;

    /**
	 * @Description:查询应用包信息
	 * @param key
	 * @return AppPackage
	 */
	AppPackage queryAppPkgByPrimaryKey(AppPackageKey key);

	/**
	 * @Description:查询全部应用信息及最新应用包信息
	 * @param devSn
	 * @param appId
	 * @param appName
	 * @param orgId 
	 * @return List<App>
	 */
	List<App> queryLatestVersionApp(String devSn, String appId, String appName, String orgId);

    void delete(AppPackage appPackage);
}
