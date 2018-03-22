package com.sunyard.tms.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import com.sunyard.tms.entity.Document;
import com.sunyard.tms.entity.DocumentExample;
import com.sunyard.tms.utils.*;
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
import com.sunyard.tms.entity.FirmWare;
import com.sunyard.tms.entity.FirmWareExample;
import com.sunyard.tms.entity.FirmWareExample.Criteria;
import com.sunyard.tms.mapper.FirmWareMapper;
import com.sunyard.tms.service.FirmWareService;

/**
 * @Description:固件服务层实现类
 * @author:zhangbo
 * @date:2017年12月4日 下午5:09:09
 */
@Service
@Transactional(rollbackFor = Exception.class )
public class FirmWareServiceImpl implements FirmWareService {
    private static final Logger logger = LoggerFactory.getLogger(FirmWareServiceImpl.class);
    @Autowired
    private FirmWareMapper firmWareMapper;
    /**
     * ftp上传路径
     */
    private static final String APP_PATH = PropertyUtil.getParam("ftp.firmware.path");
    private String ip = PropertyUtil.getParam("ftp.app.ip");
    private int port = Integer.valueOf(PropertyUtil.getParam("ftp.app.port"));
    private String userName = PropertyUtil.getParam("ftp.app.userName");
    private String password = PropertyUtil.getParam("ftp.app.password");

    /**
     * @Description:分页查询固件
     * @param firmWare
     * @param page
     * @return DataGrid<FirmWare>
     */
    @Override
    public DataGrid<FirmWare> queryByPage(FirmWare firmWare, IPage page) {
        // 添加查询条件
        FirmWareExample example = new FirmWareExample();
        Criteria criteria = example.createCriteria();
        if (!Strings.isNullOrEmpty(firmWare.getFirmName())) {
            criteria.andFirmNameLike("%"+firmWare.getFirmName()+"%");
        }
        if (!Strings.isNullOrEmpty(firmWare.getFirmVer())) {
            criteria.andFirmVerLike("%"+firmWare.getFirmVer()+"%");
        }
        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<FirmWare> list = firmWareMapper.selectByExample(example);
        // 取分页信息
        PageInfo<FirmWare> pageInfo = new PageInfo<>(list);
        // 设置返回结果
        DataGrid<FirmWare> dataGrid = new DataGrid<>();
        long total = pageInfo.getTotal();
        dataGrid.setTotal(new Long(total).intValue());
        dataGrid.setRows(list);
        return dataGrid;
    }

    /**
     * @Description:添加固件,上传文件
     * @param firmWare
     * @param uploadFile
     * @return String
     */
    @Override
    public String insert(FirmWare firmWare, MultipartFile uploadFile){
        firmWare.setFirmId(PrimaryKeyUtil.getPrimaryKey("FW"));
        boolean flag = checkFirmVer(firmWare);
        if(!flag){
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("firmWare.verIsFull"));
        }
        firmWare.setFirmStatus(StatusConstants.FIRM_NOTONLINE);
        firmWare.setFirmLen(uploadFile.getSize() + "");
        firmWare.setFirmFolderPath(APP_PATH + "/" + firmWare.getFirmId() + "/");
        // 取文件的扩展名
        String originalFilename = uploadFile.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 设置固件的文件名
        String firmName = firmWare.getFirmName()+"V"+firmWare.getFirmVer()+extName;
        firmWare.setFirmFilePath(firmWare.getFirmFolderPath()+firmName);
        FtpFile ftpFile = null;
        try {
            ftpFile = new FtpFile(ip, port, userName, password);
            ftpFile.login();
            ftpFile.buildList(firmWare.getFirmFolderPath());
            String destination = new String(firmWare.getFirmFilePath().getBytes("utf-8"), "iso-8859-1");
            ftpFile.upFile(uploadFile.getBytes(),destination);
            String time = DateFormat.dateTimeFormat(new Date());
            firmWare.setCreatedDatetime(time);
            firmWare.setUpdateDatetime(time);
            firmWareMapper.insertSelective(firmWare);
            return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("firmWare.uploadSuc"));
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        } finally {
            try {
                ftpFile.logout();
            } catch (Exception e) {
                logger.error(CommonConstants.SYSTEM_ERROR, e);
                logger.warn("FTP has no normal exit");
            }
        }
    }


    /**    
     * @Description:校验新增固件版本号是否可用
     * @param firmWare
     * @return boolean      
     */ 
    private boolean checkFirmVer(FirmWare firmWare) {
        FirmWareExample example = new FirmWareExample();
        Criteria criteria = example.createCriteria();
        criteria.andFirmVerGreaterThanOrEqualTo(firmWare.getFirmVer());
        List<FirmWare> list = firmWareMapper.selectByExample(example);
        if(list.size()==0||list==null){
            //版本号可用
            return true;
        }
        //版本号重复或过低
        return false;
    }

    /**    
     * @Description:固件文件下载
     * @param firmWare
     * @return
     * @throws UnsupportedEncodingException FileDto
     */
    @Override
    public FileDto downloadFirmWare(FirmWare firmWare) throws UnsupportedEncodingException {
        firmWare = firmWareMapper.selectByPrimaryKey(firmWare.getFirmId());
        String sourceFileName = new String(firmWare.getFirmFilePath().getBytes("utf-8"), "iso-8859-1");
        FileDto fileDto = new FileDto();
        try {
            FtpFile ftpFile = new FtpFile(ip, port, userName, password);
            ftpFile.login();
            fileDto.setSteam(ftpFile.downFile(sourceFileName));
            ftpFile.logout();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        fileDto.setFileName(sourceFileName.replace(firmWare.getFirmFolderPath(), ""));
        return fileDto;
    }

    /**
	 * @Description:固件上线
	 * @param firmWare
	 * @return String
	 */
	@Override
	public String onlineFirmWare(FirmWare firmWare) {
		FirmWare oldFirm = firmWareMapper.selectByPrimaryKey(firmWare.getFirmId());
        if (oldFirm.getFirmStatus().equals(StatusConstants.FIRM_ONLINE)) {
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("firmWare.online.alreadyOnline"));
        }
        firmWare.setFirmStatus(StatusConstants.FIRM_ONLINE);
        Date date = new Date();
        firmWare.setUpdateDatetime(DateFormat.dateTimeFormat(date));
        int result = firmWareMapper.updateByPrimaryKeySelective(firmWare);
        if (result == 1) {
            return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("firmWare.online.ok"));
        } else {
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("firmWare.online.fail"));
        }
    }

	/**
	 * @Description:固件下线
	 * @param firmWare
	 * @return String
	 */
	@Override
	public String offlineFirmWare(FirmWare firmWare) {
		FirmWare oldFirm = firmWareMapper.selectByPrimaryKey(firmWare.getFirmId());
        if(!oldFirm.getFirmStatus().equals(StatusConstants.FIRM_ONLINE)){
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("firmWare.offline.notOnline"));
        }
        firmWare.setFirmStatus(StatusConstants.FIRM_OFFLINE);
        Date date = new Date();
        firmWare.setUpdateDatetime(DateFormat.dateTimeFormat(date));
        int result = firmWareMapper.updateByPrimaryKeySelective(firmWare);
        if (result == 1) {
            return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("firmWare.offline.ok"));
        } else {
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("firmWare.offline.fail"));
        }
    }

	/**
	 * @Description:查询最新固件信息
	 * @return FirmWare
	 */
	@Override
	public FirmWare queryLatestFirmWare() {
		// 获取最新固件信息
		FirmWareExample example = new FirmWareExample();
		Criteria criteria = example.createCriteria();
		criteria.andFirmStatusEqualTo(StatusConstants.FIRM_ONLINE);
		example.setOrderByClause("FIRM_VER DESC");
		List<FirmWare> firmWares = firmWareMapper.selectByExample(example);
		if (firmWares.size() > 0) {
			FirmWare firmWare = firmWares.get(0);
			return firmWare;
		} else {
			return null;
		}
	}

    @Override
    public void del(FirmWare firmWare) {
       FirmWareExample example = new FirmWareExample();
        FirmWareExample.Criteria criteria = example.createCriteria();
        criteria.andFirmIdEqualTo(firmWare.getFirmId());
        FirmWare queryFirmWare =firmWareMapper.selectByExample(example).get(0);
        try {
            FtpFile ftpFile = new FtpFile(ip, port, userName, password);
            ftpFile.login();
            ftpFile.deleteFile(queryFirmWare.getFirmFilePath());
            ftpFile.deleteFolder(queryFirmWare.getFirmFolderPath());
            ftpFile.logout();
            firmWareMapper.deleteByPrimaryKey(firmWare.getFirmId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}