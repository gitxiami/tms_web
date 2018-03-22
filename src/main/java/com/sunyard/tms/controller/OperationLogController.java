/**
 * 
 */
package com.sunyard.tms.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sunyard.tms.aop.CreateLog;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.constant.CommonConstants;
import com.sunyard.tms.entity.OperationLog;
import com.sunyard.tms.service.OperationLogService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.DateFormat;
import com.sunyard.tms.utils.IPage;

/**
 * @Description:操作日志控制层
 * @author:zhangbin
 * @date:2017年7月26日 上午10:28:24
 */
@Controller
@RequestMapping("/log")
public class OperationLogController {
	@Autowired
	private OperationLogService operationLogService;
	private final static Logger logger = LoggerFactory.getLogger(OperationLogController.class);

	/**
	 * @Description:条件分页查询实时日志信息
	 * @param operationLog
	 * @param page
	 * @return String
	 */
	@RequestMapping("/showLiveLogByPage")
	@ResponseBody
	@CreateLog(description = "query living log")
	public String showLiveLogByPage(OperationLog operationLog, IPage page) {
		try {
			// 设置当天0点时间作为查询条件起始时间
			String startTime = DateFormat.dateTimeFormat(new Date()).substring(0,10).trim();
			// 设置第二天0点时间作为查询条件结束时间
			SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd");
			Calendar rightNow = Calendar.getInstance();
			rightNow.setTime(new Date());
			rightNow.add(Calendar.DAY_OF_YEAR, 1);
			String endTime = myFmt.format(rightNow.getTime()).substring(0,10).trim();
			// 将两个时间字符串进行拼接
			Object[] objects = {startTime, endTime};
			operationLog.setCreatedDatetime(StringUtils.join(objects, " - "));
			DataGrid<OperationLog> dataGrid = operationLogService.findAllLog(operationLog, page);
			return JSON.toJSONString(dataGrid);
		} catch (Exception e) {
			logger.error(CommonConstants.SYSTEM_ERROR, e);
			return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
		}
	}

	/**
	 * @Description:分页查询日志信息
	 */
	@RequestMapping("/showLogByPage")
	@ResponseBody
	@CreateLog(description = "query log")
	public String showLogByPage(OperationLog operationLog, IPage page) {
		DataGrid dataGrid = null;
		try {
			dataGrid = operationLogService.findAllLog(operationLog, page);
			return JSON.toJSONString(dataGrid);
		} catch (Exception e) {
			logger.error(CommonConstants.SYSTEM_ERROR, e);
			return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
		}
	}

	@RequestMapping("/findLogName")
	@ResponseBody
	public String findLogName() {
		return null;
	}
}
