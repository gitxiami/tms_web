package com.sunyard.tms.service;

import java.io.UnsupportedEncodingException;

import org.springframework.web.multipart.MultipartFile;

import com.sunyard.tms.dto.FileDto;
import com.sunyard.tms.entity.FirmWare;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.IPage;

/**     
 * @Description:固件服务层接口  
 * @author:zhangbo
 * @date:2017年12月4日 下午4:20:34
 */
public interface FirmWareService {

    /**
     * @Description:分页查询固件
     * @param firmWare
     * @param page
     * @return DataGrid<FirmWare>
     */
    DataGrid<FirmWare> queryByPage(FirmWare firmWare, IPage page);

    /**
     * @Description:添加固件,上传文件
     * @param firmWare
     * @param uploadFile
     * @return String
     */
    String insert(FirmWare firmWare, MultipartFile uploadFile);

    /**    
     * @Description:文件下载
     * @param firmWare
     * @return
     * @throws UnsupportedEncodingException FileDto
     */
    FileDto downloadFirmWare(FirmWare firmWare) throws UnsupportedEncodingException;

	/**
	 * @Description:固件上线
	 * @param firmWare
	 * @return String
	 */
	String onlineFirmWare(FirmWare firmWare);

	/**
	 * @Description:固件下线
	 * @param firmWare
	 * @return String
	 */
	String offlineFirmWare(FirmWare firmWare);

	/**
	 * @Description:查询最新固件信息
	 * @return FirmWare
	 */
	FirmWare queryLatestFirmWare();

    void del(FirmWare firmWare);
}
