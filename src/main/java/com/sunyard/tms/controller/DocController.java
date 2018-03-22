package com.sunyard.tms.controller;

import com.alibaba.fastjson.JSONObject;
import com.sunyard.tms.aop.CreateLog;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.constant.CommonConstants;
import com.sunyard.tms.dto.FileDto;
import com.sunyard.tms.entity.Document;
import com.sunyard.tms.entity.FirmWare;
import com.sunyard.tms.service.DocumentService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.FileUtils;
import com.sunyard.tms.utils.IPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.DocumentName;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequestMapping("/doc")
@RestController
public class DocController {
    private final static Logger logger = LoggerFactory.getLogger(DocController.class);
    @Autowired
    private DocumentService documentService;

    @RequestMapping("/showDocByPage")
    @CreateLog(description = "query document")
    public String showDocByPage(Document document, IPage page) {
        try {
            DataGrid<Document> dataGrid = documentService.queryByPage(document, page);
            return JSONObject.toJSONString(dataGrid);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    @RequestMapping("/uploadDoc")
    @CreateLog(description = "upload document")
    public String uploadDoc(Document document, MultipartFile uploadFile) {
        try {
            String result = documentService.insert(document, uploadFile);
            return result;
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    @RequestMapping("/downloadDoc")
    @CreateLog(description = "download document")
    public String downloadDoc(Document document, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            FileDto fileDto = documentService.downloadDoc(document);
            return FileUtils.downloadFile(session, request, response, fileDto);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return null;
        }
    }

    @RequestMapping("/deleteDoc")
    @CreateLog(description = "delete document")
    public String deleteDoc(Document document){
        try {
            documentService.del(document);
            return BackResult.back(true, CodeConst.SUCCESS, "delelte success");
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
}
