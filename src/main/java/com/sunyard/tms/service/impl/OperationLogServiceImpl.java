/**
 * 
 */
package com.sunyard.tms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.sunyard.tms.entity.OperationLog;
import com.sunyard.tms.entity.OperationLogExample;
import com.sunyard.tms.entity.OperationLogExample.Criteria;
import com.sunyard.tms.mapper.OperationLogMapper;
import com.sunyard.tms.service.OperationLogService;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.IPage;

/**
 * @Description:操作日志服务层实现类
 * @author:zhangbin
 * @date:2017年7月25日 下午4:05:03
 */
@Service
@Transactional(rollbackFor = Exception.class )
public class OperationLogServiceImpl implements OperationLogService {
    @Autowired
    private OperationLogMapper operationLogMapper;

    @Override
    public void addLog(OperationLog log) {
        operationLogMapper.insertSelective(log);
    }

    @Override
    public DataGrid<OperationLog> findAllLog(OperationLog operationLog, IPage page) {
        OperationLogExample example = new OperationLogExample();
        Criteria criteria = example.createCriteria();
        if (!Strings.isNullOrEmpty(operationLog.getOpUsername())) {
            criteria.andOpUsernameEqualTo(operationLog.getOpUsername());
        }
        if (!Strings.isNullOrEmpty(operationLog.getOrgName())) {
            criteria.andOrgNameEqualTo(operationLog.getOrgName());
        }
        if (!Strings.isNullOrEmpty(operationLog.getLogName())) {
            criteria.andLogNameEqualTo(operationLog.getLogName());
        }
        if (!Strings.isNullOrEmpty(operationLog.getLogStatus())) {
            criteria.andLogStatusEqualTo(operationLog.getLogStatus());
        }
        if(!Strings.isNullOrEmpty(operationLog.getCreatedDatetime())){
            criteria.andCreatedDatetimeGreaterThanOrEqualTo(operationLog.getCreatedDatetime().substring(0,10).trim());
            criteria.andCreatedDatetimeLessThanOrEqualTo(operationLog.getCreatedDatetime().substring(13, 23).trim());         
        }
        //按时间降序排列
        example.setOrderByClause("CREATED_DATETIME DESC");
        // 设置分页信息
        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<OperationLog> list = operationLogMapper.selectByExample(example);
        // 取分页信息
        PageInfo<OperationLog> pageInfo = new PageInfo<>(list);
        // 设置返回结果
        DataGrid<OperationLog> dataGrid = new DataGrid<>();
        long total = pageInfo.getTotal();
        dataGrid.setTotal(new Long(total).intValue());
        dataGrid.setRows(list);
        return dataGrid;
    }

    @Override
    public List<OperationLog> findAllLogList() {
        OperationLogExample example = new OperationLogExample();
        //按时间降序排列
        example.setOrderByClause("CREATED_DATETIME DESC");
        return operationLogMapper.selectByExample(example);
    }

}
