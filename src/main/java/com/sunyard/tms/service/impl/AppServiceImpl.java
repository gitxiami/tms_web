
package com.sunyard.tms.service.impl;

import java.util.Date;
import java.util.List;
import com.sunyard.tms.dto.AppDto;
import com.sunyard.tms.service.AppPackageService;
import com.sunyard.tms.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.constant.StatusConstants;
import com.sunyard.tms.entity.App;
import com.sunyard.tms.entity.AppExample;
import com.sunyard.tms.entity.AppExample.Criteria;
import com.sunyard.tms.mapper.AppMapper;
import com.sunyard.tms.service.AppService;

/**
 * @Description:App应用管理服务层实现类
 * @author:zhangbin
 * @date:2017年7月20日 上午9:57:08
 */
@Service
@Transactional(rollbackFor = Exception.class )
public class AppServiceImpl implements AppService {
    @Autowired
    private AppMapper appMapper;
    @Autowired
    private AppPackageService appPackageService;
    /**    
     * @Description:分页条件查询App
     * @param app
     * @param page
     * @return DataGrid      
     */ 
    @Override
    public DataGrid<AppDto> queryByPage(App app, IPage page) {
        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<AppDto> list = appMapper.findAllAppByPage(app);
        // 取分页信息
        PageInfo<AppDto> pageInfo = new PageInfo<>(list);
        // 设置返回结果
        DataGrid<AppDto> dataGrid = new DataGrid<>();
        long total = pageInfo.getTotal();
        dataGrid.setTotal(new Long(total).intValue());
        dataGrid.setRows(list);
        return dataGrid;
    }
    /**    
     * @Description:添加App信息
     * @param app
     * @return String      
     */ 
    @Override
    public String addApp(App app) {
        boolean flag = checkAppName(app.getAppName());
        if (!flag) {
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("app.nameIsFull"));
        }
        app.setAppStatus(StatusConstants.APP_NOTONLINE);
        app.setAppId(PrimaryKeyUtil.getPrimaryKey("AP"));
        Date date = new Date();
        app.setCreatedDatetime(DateFormat.dateTimeFormat(date));
        app.setUpdateDatetime(DateFormat.dateTimeFormat(date));
        int result = appMapper.insertSelective(app);
        if (result == 1) {
            return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("app.insert.ok"));
        } else {
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("app.insert.err"));
        }
    }
    /**    
     * @Description:修改App信息
     * @param app
     * @return int      
     */ 
    @Override
    public int updateApp(App app) {
        Date date = new Date();
        app.setUpdateDatetime(DateFormat.dateTimeFormat(date));
        int result = appMapper.updateByPrimaryKeySelective(app);
        return result;
    }
    /**    
     * @Description:删除App
     * @param app
     * @return String      
     */
    @Override
    public String deleteApp(App app) {
        // 判断该App是否有应用包
        boolean flag = appPackageService.isAppHasPackages(app.getAppId());
        if (flag) {
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("app.hasPkg"));
        }
        app.setAppStatus(StatusConstants.APP_DELETE);
        int result = updateApp(app);
        if (result == 1) {
            return BackResult.back(true, CodeConst.SUCCESS,PropertyUtil.getValue("app.delete.ok"));
        } else {
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("app.delete.fail"));
        }
    }
    /**    
     * @Description:校验App名称
     * @param appName
     * @return boolean      
     */ 
    @Override
    public boolean checkAppName(String appName) {
        AppExample example = new AppExample();
        Criteria criteria = example.createCriteria();
        criteria.andAppNameEqualTo(appName);
        List<App> list = appMapper.selectByExample(example);
        return list.size() == 0;
    }
    /**    
     * @Description:上线App
     * @param app
     * @return String      
     */ 
    @Override
    public String onlineApp(App app) {
        App oldApp = appMapper.selectByPrimaryKey(app.getAppId());
        if (oldApp.getAppStatus().equals(StatusConstants.APP_ONLINE)) {
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("app.alreadyOnline"));
        }
        if (!appPackageService.isAppHasPackages(app.getAppId())) {
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("app.notHasPkg"));
        }
        app.setAppStatus(StatusConstants.APP_ONLINE);
        int result = updateApp(app);
        if (result == 1) {
            return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("app.online.ok"));
        } else {
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("app.online.fail"));
        }
    }

    /**    
     * @Description:下载App
     * @param app
     * @return String      
     */ 
    @Override
    public String offlineApp(App app) {
        App oldApp = appMapper.selectByPrimaryKey(app.getAppId());
        if(!oldApp.getAppStatus().equals(StatusConstants.APP_ONLINE)){
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("app.offline.notOnline"));
        }
        app.setAppStatus(StatusConstants.APP_OFFLINE);
        int result = updateApp(app);
        if (result == 1) {
            return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("app.offline.ok"));
        } else {
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("app.offline.fail"));
        }
    }

}
