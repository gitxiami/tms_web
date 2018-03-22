package com.sunyard.tms.service;

import java.io.UnsupportedEncodingException;

import org.springframework.web.multipart.MultipartFile;

import com.sunyard.tms.dto.FileDto;
import com.sunyard.tms.entity.DeviceLog;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.IPage;

/**
 * @Description:终端日志 服务层接口
 * @author:zhangbo
 * @date:2018年1月8日 上午10:33:54
 */
public interface DeviceLogService {

	/**
	 * @Description:上传终端日志
	 * @param deviceLog
	 * @param uploadFile
	 * @return String
	 */
	String uploadDeviceLog(DeviceLog deviceLog, MultipartFile uploadFile);

	/**
	 * @Description:条件分页查询终端日志文件信息
	 * @param deviceLog
	 * @param page
	 * @return DataGrid<DeviceLog>
	 */
	DataGrid<DeviceLog> queryByPage(DeviceLog deviceLog, IPage page);

	/**
	 * @Description:下载终端日志文件
	 * @param deviceLog
	 * @return FileDto
	 * @throws UnsupportedEncodingException 
	 */
	FileDto downloadDeviceLog(DeviceLog deviceLog) throws UnsupportedEncodingException;

}
