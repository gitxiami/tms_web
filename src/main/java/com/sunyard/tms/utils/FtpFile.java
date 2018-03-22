package com.sunyard.tms.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
* @ClassName: FtpFile
* @Description: Ftp工具类
* @date 2016年7月14日
*
 */
public class FtpFile {
	
	private static final Logger log = LoggerFactory
			.getLogger(FtpFile.class);
	
	private FTPClient ftpClient;
	private String ip;
	private int port;
	private String userName;
	private String password;
	
	public FtpFile(String ip, int port, String userName, String password) throws IOException
	{
		super();
		this.ip = ip;
		this.port = port;
		this.userName = userName;
		this.password = password;
		ftpClient = new FTPClient();
		ftpClient.connect(ip, port);
	}

	/** 
	 * @Title login 
	 * @Description 登录FTP服务器
	 * @Param @throws Exception 
	 * @Return void 
	 * @Throws 
	 */ 
	public void login() throws Exception {
		ftpClient.login(userName, password);
	}

	/** 
	 * @Title logout 
	 * @Description 退出FTP服务器
	 * @Param @throws Exception 
	 * @Return void 
	 * @Throws 
	 */ 
	public void logout() throws Exception {
		ftpClient.logout();
	}

	/** 
	 * @Title buildList 
	 * @Description 在FTP服务器上建立指定的目录,当目录已经存在的情下不会影响目录下的文件,这样用以判断FTP
	 * 上传文件时保证目录的存在目录格式必须以"/"根目录开头
	 * @Param @param pathList
	 * @Param @throws Exception 
	 * @Return void 
	 * @Throws 
	 */ 
	public void buildList(String pathname) throws Exception {
		
		ftpClient.makeDirectory(pathname);
	}

	/** 
	 * @Title fileNames 
	 * @Description 取得指定目录下的所有文件名，不包括目录名称 分析nameList得到的输入流中的数，得到指定目录下的所有文件名
	 * @Param @param fullPath
	 * @Param @return
	 * @Param @throws Exception 
	 * @Return List<String> 
	 * @Throws 
	 */ 
	public List<String> fileNames(String pathname) throws Exception {
		
		return Arrays.asList(ftpClient.listNames(pathname));
	}
	
	/**
	 * 上传文件到FTP服务器,destination路径以FTP服务器的"/"开始，带文件名、 上传文件只能使用二进制模式，当文件存在时再次上传则会覆盖
	 * @param file
	 * @param destination
	 * @throws Exception
	 */
	public void upFile(File file, String destination) throws Exception {
		ftpClient.enterLocalPassiveMode();
		ftpClient.storeFile(destination, new FileInputStream(file));
	}

	/** 
	 * @Title upFile 
	 * @Description 上传文件到FTP服务器,destination路径以FTP服务器的"/"开始，带文件名、 上传文件只能使用二进制模式，当文件存在时再次上传则会覆盖
	 * @Param @param source
	 * @Param @param destination
	 * @Param @throws Exception 
	 * @Return void 
	 * @Throws 
	 */ 
	public void upFile(String source, String destination) throws Exception {
		ftpClient.storeFile(destination, new FileInputStream(source));
	}

	/** 
	 * @Title upFile 
	 * @Description JSP中的流上传到FTP服务器, 上传文件只能使用二进制模式，当文件存在时再次上传则会覆盖 字节数组做为文件的输入流,此方法适用于JSP中通过
	 * request输入流来直接上传文件在RequestUpload类中调用了此方法， destination路径以FTP服务器的"/"开始，带文件名
	 * @Param @param sourceData
	 * @Param @param destination
	 * @Param @throws Exception 
	 * @Return void 
	 * @Throws 
	 */ 
	public void upFile(byte[] sourceData, String destination) throws Exception {
            	ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		OutputStream storeFileStream = ftpClient.storeFileStream(destination);
		storeFileStream.write(sourceData);
		storeFileStream.close();
	}

	/** 
	 * @Title downFile 
	 * @Description 从FTP文件服务器上下载文件SourceFileName，到本地destinationFileName 所有的文件名中都要求包括完整的路径名在内
	 * @Param @param sourceFileName
	 * @Param @param destinationFileName
	 * @Param @throws Exception 
	 * @Return void 
	 * @Throws 
	 */ 
	public void downFile(String sourceFileName, String destinationFileName)
			throws Exception { 

		FileOutputStream fos = new FileOutputStream(destinationFileName);
		ftpClient.retrieveFile(sourceFileName, fos);
		fos.close();
	}

	/** 
	 * @Title downFile 
	 * @Description 从FTP文件服务器上下载文件，输出到字节数组中
	 * @Param @param sourceFileName
	 * @Param @return
	 * @Param @throws Exception 
	 * @Return byte[] 
	 * @Throws 
	 */
	public byte[] downFile(String sourceFileName) throws Exception {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
		ftpClient.retrieveFile(sourceFileName, bos);
		return bos.toByteArray();
	}
	
	/**
	 * @title download
	 * @description 下载服务器文件
	 * @author Nan Ou
	 * @email ou.nan@sunyard.com
	 * @param downTel
	 * @param basePath
	 * @param files
	 * @param response
	 */
	public void download(String downTel, String basePath, String files, HttpServletResponse response) {
		FileOutputStream out = null;
		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		FileInputStream fis = null;
//		OutputStream res = null;
//		OutputStream toClient = null;
		try {
			// path是指欲下载的文件的路径。
			files = URLDecoder.decode(files, "utf-8");
			// 以流的形式下载文件。
			InputStream fiss = new BufferedInputStream(new FileInputStream(files));
			byte[] buffer = new byte[fiss.available()];
			fiss.read(buffer);
			fiss.close();
			// 清空response
			response.reset();
		} catch (Exception e) {

		} finally {
			try {
				if (out != null) {
					out.close();
					out = null;
				}
				if (bos != null) {
					bos.close();
					bos = null;
				}
				if (bis != null) {
					bis.close();
					bis = null;
				}
				if (fis != null) {
					fis.close();
					fis = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * Description: 删除远程文件
	 * @throws IOException 
	 */
	public boolean deleteFile(String pathname) throws IOException
	{
		return ftpClient.deleteFile(pathname);
	}

	public boolean deleteFolder(String pathname) throws IOException
	{
		return ftpClient.removeDirectory(pathname);
	}
	
	/**
	 * 
	 * Description: 文件转二进制
	 * @param file
	 * @return
	 */
	public static byte[] getFileToByte(File file) {
        byte[] by = new byte[(int) file.length()];
        try {
            InputStream is = new FileInputStream(file);
            ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
            byte[] bb = new byte[2048];
            int ch;
            ch = is.read(bb);
            while (ch != -1) {
                bytestream.write(bb, 0, ch);
                ch = is.read(bb);
            }
            by = bytestream.toByteArray();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return by;
    }
	
	/**
	 * 上传文件到FTP服务器相对路径 ftpPath表示相对路径，name表示文件名
	 * @param file
	 * @param destination
	 * @throws Exception
	 */
	public void upFile(File file,String ftpPath, String name) throws Exception {
		ftpClient.enterLocalPassiveMode();
		ftpClient.changeWorkingDirectory(new String(ftpPath.getBytes()));
		ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
		ftpClient.storeFile(name, new FileInputStream(file));
	}
	
	/** 
	 * @Title downFile 
	 * @Description 从FTP文件服务器上下载文件，输出到字节数组中,ftpPath表示相对路径
	 * @Param @param sourceFileName
	 * @Param @return
	 * @Param @throws Exception 
	 * @Return byte[] 
	 * @Throws 
	 */ 
	public byte[] downFileRelative(String ftpPath,String sourceFileName) throws Exception {
		log.info("path:"+ftpPath+",fileName:"+sourceFileName);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ftpClient.changeWorkingDirectory(new String(ftpPath.getBytes()));
		ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
		ftpClient.retrieveFile(sourceFileName, bos);
		return bos.toByteArray();
	}
	
}