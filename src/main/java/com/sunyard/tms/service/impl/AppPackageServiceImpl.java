/**
 * 
 */
package com.sunyard.tms.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import com.sunyard.tms.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.constant.CommonConstants;
import com.sunyard.tms.constant.StatusConstants;
import com.sunyard.tms.dto.FileDto;
import com.sunyard.tms.entity.AppPackageExample.Criteria;
import com.sunyard.tms.mapper.AppMapper;
import com.sunyard.tms.mapper.AppPackageMapper;
import com.sunyard.tms.service.AppPackageService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.DateFormat;
import com.sunyard.tms.utils.FtpFile;
import com.sunyard.tms.utils.IPage;
import com.sunyard.tms.utils.PropertyUtil;

/**
 * @Description:App应用包服务层实现类
 * @author:zhangbin
 * @date:2017年7月21日 下午1:51:30
 */
@Service
@Transactional(rollbackFor = Exception.class )
public class AppPackageServiceImpl implements AppPackageService {
    private static final Logger logger = LoggerFactory.getLogger(AppPackageServiceImpl.class);
    @Autowired
    private AppPackageMapper appPackageMapper;
    @Autowired
    private AppMapper appMapper;
    /**
     * ftp上传路径
     */
    private static final String APP_PATH = PropertyUtil.getParam("ftp.app.path");
    private String ip = PropertyUtil.getParam("ftp.app.ip");
    private int port = Integer.valueOf(PropertyUtil.getParam("ftp.app.port"));
    private String userName = PropertyUtil.getParam("ftp.app.userName");
    private String password = PropertyUtil.getParam("ftp.app.password");
    @Override
    public boolean isAppHasPackages(String appId) {
        AppPackageExample example = new AppPackageExample();
        Criteria criteria = example.createCriteria();
        criteria.andAppIdEqualTo(appId);
        int count = appPackageMapper.countByExample(example);
        return count > 0;
    }

    @Override
    public DataGrid<AppPackage> queryByPage(App app, AppPackage appPackage, IPage page) {
        // 查询出所属App
        App belongApp = appMapper.selectByPrimaryKey(app.getAppId());
        // 添加查询条件
        AppPackageExample example = new AppPackageExample();
        Criteria criteria = example.createCriteria();
        if (!Strings.isNullOrEmpty(appPackage.getAppPkgVer())) {
            criteria.andAppPkgVerEqualTo(appPackage.getAppPkgVer());
        }
        criteria.andAppIdEqualTo(app.getAppId());
        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<AppPackage> list = appPackageMapper.selectByExample(example);
        // 设置App包所属的应用名称
        for (AppPackage appPackage2 : list) {
            appPackage2.setAppName(belongApp.getAppName());
        }
        // 取分页信息
        PageInfo<AppPackage> pageInfo = new PageInfo<>(list);
        // 设置返回结果
        DataGrid<AppPackage> dataGrid = new DataGrid<>();
        long total = pageInfo.getTotal();
        dataGrid.setTotal(new Long(total).intValue());
        dataGrid.setRows(list);
        return dataGrid;
    }

    @Override
    public String insert(AppPackage appPackage, MultipartFile uploadFile){
        boolean flag = checkPkgVer(appPackage);
        if(!flag){
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("appPkg.verIsFull"));
        }
        App app = appMapper.selectByPrimaryKey(appPackage.getAppId());
        appPackage.setAppPkgStatus(StatusConstants.APP_PACKAGE_PUBLISH);
        appPackage.setAppPkgLen(uploadFile.getSize() + "");
        appPackage.setAppPkgFolderPath(APP_PATH + "/" + app.getAppId() + "/" + appPackage.getAppPkgVer() + "/");
        // 取文件的扩展名
//        String originalFilename = uploadFile.getOriginalFilename();
//        String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 设置App应用包的文件名
        String appPackageName = uploadFile.getOriginalFilename();
        appPackage.setAppPkgFilePath(appPackage.getAppPkgFolderPath() + appPackageName);
        FtpFile ftpFile = null;
        try {
            ftpFile = new FtpFile(ip, port, userName, password);
            ftpFile.login();
            ftpFile.buildList(APP_PATH + "/" + app.getAppId());
            ftpFile.buildList(appPackage.getAppPkgFolderPath());
            String destination =appPackage.getAppPkgFilePath();
            ftpFile.upFile(uploadFile.getBytes(),destination);
            String time = DateFormat.dateTimeFormat(new Date());
            appPackage.setCreatedDatetime(time);
            appPackage.setUpdateDatetime(time);
            appPackageMapper.insertSelective(appPackage);
            return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("appPkg.uploadSuc"));
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        } finally {
            try {
                ftpFile.logout();
            } catch (Exception e) {
                logger.error(CommonConstants.SYSTEM_ERROR, e);
                logger.warn("ftp没有正常退出");
            }
        }
    }


    /**    
     * @Description:根据Id和应用版本号查找应用包信息
     * @param appPackage
     * @return boolean      
     */ 
    private boolean checkPkgVer(AppPackage appPackage) {
        AppPackageExample example = new AppPackageExample();
        Criteria criteria = example.createCriteria();
        criteria.andAppIdEqualTo(appPackage.getAppId());
        criteria.andAppPkgVerGreaterThanOrEqualTo(appPackage.getAppPkgVer());
        List<AppPackage> list = appPackageMapper.selectByExample(example);
        return list.size() == 0 || list == null;
    }


    @Override
    public FileDto downloadAppPkg(AppPackage appPackage) throws UnsupportedEncodingException {
        AppPackageExample example = new AppPackageExample();
        Criteria criteria = example.createCriteria();
        criteria.andAppIdEqualTo(appPackage.getAppId());
        criteria.andAppPkgVerEqualTo(appPackage.getAppPkgVer());
        List<AppPackage> list = appPackageMapper.selectByExample(example);
        if(list.size()==0||list==null){
            return null;
        }
        AppPackage queryAppPkg = list.get(0);
        String sourceFileName = new String(queryAppPkg.getAppPkgFilePath().getBytes("utf-8"), "iso-8859-1");
        FileDto fileDto = new FileDto();
        try {
            FtpFile ftpFile = new FtpFile(ip, port, userName, password);
            ftpFile.login();
            fileDto.setSteam(ftpFile.downFile(sourceFileName));
            ftpFile.logout();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        fileDto.setFileName(sourceFileName.replace(queryAppPkg.getAppPkgFolderPath(), ""));
        return fileDto;
    }

    /**
	 * @Description:查询应用包信息
	 * @param key
	 * @return AppPackage
	 */
	@Override
	public AppPackage queryAppPkgByPrimaryKey(AppPackageKey key) {
		return appPackageMapper.selectByPrimaryKey(key);
	}

	/**
	 * @Description:查询全部应用信息及最新应用包信息
	 * @param devSn
	 * @param appId
	 * @param appName
	 * @param orgId 
	 * @return List<App>
	 */
	@Override
	public List<App> queryLatestVersionApp(String devSn, String appId, String appName, String orgId) {
		return appPackageMapper.selectLatestVersionApp(devSn, appId, appName, orgId);
	}

    @Override
    public void delete(AppPackage appPackage) {
        AppPackageExample example = new AppPackageExample();
        AppPackageExample.Criteria criteria = example.createCriteria();
        criteria.andAppIdEqualTo(appPackage.getAppId());
        criteria.andAppPkgVerEqualTo(appPackage.getAppPkgVer());
        AppPackage queryPkg = appPackageMapper.selectByExample(example).get(0);
        try {
            FtpFile ftpFile = new FtpFile(ip, port, userName, password);
            ftpFile.login();
            ftpFile.deleteFile(queryPkg.getAppPkgFilePath());
            ftpFile.deleteFolder(queryPkg.getAppPkgFolderPath());
            ftpFile.logout();
            appPackageMapper.deleteByExample(example);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
