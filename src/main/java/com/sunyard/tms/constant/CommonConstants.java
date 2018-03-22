package com.sunyard.tms.constant;

import com.sunyard.tms.utils.BackResult;

public class CommonConstants {
	private CommonConstants() {
	}

	public final static String SYSTEM_ERROR = "System Exception";

	public final static String SUCCESS = "success";

	public final static String FAIL = "fail";

	public final static String IO_ERROR = "IO异常";

	public final static String ILLEGAL_PARAMETER = "非法参数";

	public final static String ERROR = "error";

	public final static String SUCCESS_RESULT = new BackResult(true, CodeConst.SUCCESS, "Success").toString();
	
	public final static String TIMEOUT = new BackResult(true, CodeConst.SUCCESS, "登录超时").toString();
	
	public final static String LOGOUT = new BackResult(true, CodeConst.SUCCESS, "登录被踢").toString();

	public final static String ERROR_RESULT = new BackResult(false, CodeConst.FAIL, "System Exception").toString();
	
}
