package com.sunyard.tms.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

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
import com.sunyard.tms.dto.FileDto;
import com.sunyard.tms.entity.DeviceLog;
import com.sunyard.tms.entity.DeviceLogExample;
import com.sunyard.tms.entity.DeviceLogExample.Criteria;
import com.sunyard.tms.mapper.DeviceLogMapper;
import com.sunyard.tms.service.DeviceLogService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.DateFormat;
import com.sunyard.tms.utils.FtpFile;
import com.sunyard.tms.utils.IPage;
import com.sunyard.tms.utils.PrimaryKeyUtil;
import com.sunyard.tms.utils.PropertyUtil;

/**
 * @Description:终端日志 服务层实现类
 * @author:zhangbo
 * @date:2018年1月8日 上午10:33:49
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DeviceLogServiceImpl implements DeviceLogService {
	private static final Logger logger = LoggerFactory.getLogger(DeviceLogServiceImpl.class);
	@Autowired
    private DeviceLogMapper deviceLogMapper;
	
	/**
     * ftp上传路径
     */
    private static final String APPLOG_PATH = PropertyUtil.getParam("ftp.applog.path");
    private String ip = PropertyUtil.getParam("ftp.app.ip");
    private int port = Integer.valueOf(PropertyUtil.getParam("ftp.app.port"));
    private String userName = PropertyUtil.getParam("ftp.app.userName");
    private String password = PropertyUtil.getParam("ftp.app.password");

    /**
	 * @Description:上传终端日志
	 * @param deviceLog
	 * @param uploadFile
	 * @return String
	 */
	@Override
	public String uploadDeviceLog(DeviceLog deviceLog, MultipartFile uploadFile) {
		deviceLog.setDeviceLogId(PrimaryKeyUtil.getPrimaryKey("DL"));
		deviceLog.setDeviceLogFolderPath(APPLOG_PATH + "/" + deviceLog.getDeviceSn() + "/");
		// 设置终端日志文件名
        String deviceLogName = uploadFile.getOriginalFilename();
        deviceLog.setDeviceLogFilePath(deviceLog.getDeviceLogFolderPath() + deviceLogName);
        FtpFile ftpFile = null;
        try {
            ftpFile = new FtpFile(ip, port, userName, password);
            ftpFile.login();
            ftpFile.buildList(APPLOG_PATH + "/" + deviceLog.getDeviceSn());
            ftpFile.buildList(deviceLog.getDeviceLogFolderPath());
            String destination =deviceLog.getDeviceLogFilePath();
            ftpFile.upFile(uploadFile.getBytes(),destination);
            String time = DateFormat.dateTimeFormat(new Date());
            deviceLog.setCreatedDatetime(time);
            deviceLogMapper.insertSelective(deviceLog);
            return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("deviceLog.uploadSuc"));
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
	 * @Description:条件分页查询终端日志文件信息
	 * @param deviceLog
	 * @param page
	 * @return DataGrid<DeviceLog>
	 */
	@Override
	public DataGrid<DeviceLog> queryByPage(DeviceLog deviceLog, IPage page) {
        // 添加查询条件
		DeviceLogExample example = new DeviceLogExample();
        Criteria criteria = example.createCriteria();
        if (!Strings.isNullOrEmpty(deviceLog.getDeviceSn())) {
            criteria.andDeviceSnEqualTo(deviceLog.getDeviceSn());
        }
        if (!Strings.isNullOrEmpty(deviceLog.getCreatedDatetime())) {
            criteria.andCreatedDatetimeEqualTo(deviceLog.getCreatedDatetime());
        }
        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<DeviceLog> list = deviceLogMapper.selectByExample(example);
        // 取分页信息
        PageInfo<DeviceLog> pageInfo = new PageInfo<>(list);
        // 设置返回结果
        DataGrid<DeviceLog> dataGrid = new DataGrid<>();
        long total = pageInfo.getTotal();
        dataGrid.setTotal(new Long(total).intValue());
        dataGrid.setRows(list);
        return dataGrid;
	}

	/**
	 * @Description:下载终端日志文件
	 * @param deviceLog
	 * @return FileDto
	 */
	@Override
	public FileDto downloadDeviceLog(DeviceLog deviceLog) throws UnsupportedEncodingException {
		DeviceLogExample example = new DeviceLogExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeviceLogIdEqualTo(deviceLog.getDeviceLogId());
        deviceLog = deviceLogMapper.selectByPrimaryKey(deviceLog.getDeviceLogId());
        String sourceFileName = new String(deviceLog.getDeviceLogFilePath().getBytes("utf-8"), "iso-8859-1");
        FileDto fileDto = new FileDto();
        try {
            FtpFile ftpFile = new FtpFile(ip, port, userName, password);
            ftpFile.login();
            fileDto.setSteam(ftpFile.downFile(sourceFileName));
            ftpFile.logout();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        fileDto.setFileName(sourceFileName.replace(deviceLog.getDeviceLogFolderPath(), ""));
        return fileDto;
	}

}
