package com.sunyard.tms.service;

import com.sunyard.tms.dto.FileDto;
import com.sunyard.tms.entity.Document;
import com.sunyard.tms.entity.FirmWare;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.IPage;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;

public interface DocumentService {
    public DataGrid<Document> queryByPage(Document document, IPage page);

    String insert(Document document, MultipartFile uploadFile);

    FileDto downloadDoc(Document document) throws UnsupportedEncodingException;

    void del(Document document);
}
