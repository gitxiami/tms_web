package com.sunyard.tms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.constant.CommonConstants;
import com.sunyard.tms.constant.StatusConstants;
import com.sunyard.tms.dto.FileDto;
import com.sunyard.tms.entity.Document;
import com.sunyard.tms.entity.DocumentExample;
import com.sunyard.tms.entity.FirmWare;
import com.sunyard.tms.mapper.DocumentMapper;
import com.sunyard.tms.service.DocumentService;
import com.sunyard.tms.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/**
 * @author zhangbin
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DocumentServiceImpl implements DocumentService{
    @Autowired
    private DocumentMapper documentMapper;

    private static final Logger logger = LoggerFactory.getLogger(DocumentServiceImpl.class);

    /**
     * ftp上传路径
     */
    private static final String APP_PATH = PropertyUtil.getParam("ftp.document.path");
    private String ip = PropertyUtil.getParam("ftp.app.ip");
    private int port = Integer.valueOf(PropertyUtil.getParam("ftp.app.port"));
    private String userName = PropertyUtil.getParam("ftp.app.userName");
    private String password = PropertyUtil.getParam("ftp.app.password");

    @Override
    public DataGrid<Document> queryByPage(Document document, IPage page) {
        DocumentExample example = new DocumentExample();
        DocumentExample.Criteria criteria = example.createCriteria();
        if (!Strings.isNullOrEmpty(document.getDocName())) {
            criteria.andDocNameLike("%"+document.getDocName()+"%");
        }
        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<Document> list = documentMapper.selectByExample(example);
        // 取分页信息
        PageInfo<Document> pageInfo = new PageInfo<>(list);
        // 设置返回结果
        DataGrid<Document> dataGrid = new DataGrid<>();
        long total = pageInfo.getTotal();
        dataGrid.setTotal(new Long(total).intValue());
        dataGrid.setRows(list);
        return dataGrid;
    }

    @Override
    public String insert(Document document, MultipartFile uploadFile) {
        document.setDocId(PrimaryKeyUtil.getPrimaryKey("DC"));
        document.setDocLen(uploadFile.getSize() + "");
        document.setDocFolderPath(APP_PATH + "/" + document.getDocId() + "/");
        String docName = uploadFile.getOriginalFilename();
        document.setDocFilePath(document.getDocFolderPath()+docName);
        FtpFile ftpFile = null;
        try {
            ftpFile = new FtpFile(ip, port, userName, password);
            ftpFile.login();
            ftpFile.buildList(document.getDocFolderPath());
            String destination = new String(document.getDocFilePath().getBytes("utf-8"), "iso-8859-1");
            ftpFile.upFile(uploadFile.getBytes(),destination);
            String time = DateFormat.dateTimeFormat(new Date());
            document.setCreatedDatetime(time);
            document.setUpdateDatetime(time);
            documentMapper.insertSelective(document);
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

    @Override
    public FileDto downloadDoc(Document document) throws UnsupportedEncodingException {
        document = documentMapper.selectByPrimaryKey(document.getDocId());
        String sourceFileName = new String(document.getDocFilePath().getBytes("utf-8"), "iso-8859-1");
        FileDto fileDto = new FileDto();
        try {
            FtpFile ftpFile = new FtpFile(ip, port, userName, password);
            ftpFile.login();
            fileDto.setSteam(ftpFile.downFile(sourceFileName));
            ftpFile.logout();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        fileDto.setFileName(sourceFileName.replace(document.getDocFolderPath(), ""));
        return fileDto;
    }

    @Override
    public void del(Document document) {
        DocumentExample example = new DocumentExample();
        DocumentExample.Criteria criteria = example.createCriteria();
        criteria.andDocIdEqualTo(document.getDocId());
        Document queryDoc = documentMapper.selectByExample(example).get(0);
        try {
            FtpFile ftpFile = new FtpFile(ip, port, userName, password);
            ftpFile.login();
            ftpFile.deleteFile(queryDoc.getDocFilePath());
            ftpFile.deleteFolder(queryDoc.getDocFolderPath());
            ftpFile.logout();
            documentMapper.deleteByPrimaryKey(document.getDocId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
