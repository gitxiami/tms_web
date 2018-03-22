package com.sunyard.tms.dto;

import java.io.Serializable;


/**     
 * @Description:对外输出文件  
 * @author:zhangbin  
 * @date:2017年7月24日 下午5:39:11   
 */  
public class FileDto implements Serializable
{
	/**   
	 * 
	 */
	private static final long serialVersionUID = 2485375008326411692L;
	private String fileName ; 
	private byte [] steam;
	public String getFileName()
	{
		return fileName;
	}
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	public byte[] getSteam()
	{
		return steam;
	}
	public void setSteam(byte[] steam)
	{
		this.steam = steam;
	}
	
	
}
