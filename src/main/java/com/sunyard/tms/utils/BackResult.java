/**
 * @Title BackResult.java
 * @Package com.sunyard.mp.entity
 * @Description 传到页面的提示框数据的实体类 
 * @Copyright ©2015 Sunyard Technology
 * @Author ou.nan@sunyard.com
 * @Date 2015年10月20日 下午7:42:01
 * @Version V1.0
 */
package com.sunyard.tms.utils;

import com.alibaba.fastjson.JSON;

/**
 * @Description:传到页面的提示框数据的实体类  
 * @author:zhangbin  
 * @date:2017年7月14日 上午11:27:35   
 */  
public class BackResult {
	private boolean type = true;
	private int code = 0;
	private String message;

	/**
	 * <p>
	 * Title:BackResult
	 * </p>
	 * <p>
	 * Description:构造函数，不带参数
	 * </p>
	 */
	public BackResult() {
	}

	/**
	 * <p>
	 * Title:BackResult
	 * </p>
	 * <p>
	 * Description:构造函数，带参数
	 * </p>
	 * 
	 * @param type
	 * @param code
	 * @param message
	 */
	public BackResult(boolean type, int code, String message) {
		this.type = type;
		this.code = code;
		this.message = message;
	}

	public static String back(boolean type, int code, Object message) {
		return new BackResult(type, code, message.toString()).toString();
	}

	
	public String backof(boolean type, int code, Object message) {
		return new BackResult(type, code, message.toString()).toString();
	}

	/**
	 * @return the (boolean)BackResult.type
	 */
	public boolean getType() {
		return type;
	}

	/**
	 * @param type
	 *            the (boolean)BackResult.type to set
	 */
	public void setType(boolean type) {
		this.type = type;
	}

	/**
	 * @return the (int)BackResult.code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the (int)BackResult.code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the (String)BackResult.message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the (String)BackResult.message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @Title setBackResult
	 * @Description 封装BackResult属性
	 * @Param @param type
	 * @Param @param code
	 * @Param @param message
	 * @Return void
	 * @Throws
	 */
	public void setBackResult(boolean type, int code, String message) {
		this.type = type;
		this.code = code;
		this.message = message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @title toString
	 * 
	 * @description 重写toString方法
	 * 
	 * @return
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
