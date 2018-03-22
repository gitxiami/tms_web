package com.sunyard.tms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.sunyard.tms.constant.StatusConstants;
import com.sunyard.tms.entity.Device;
import com.sunyard.tms.entity.DeviceExample;
import com.sunyard.tms.entity.Merchant;
import com.sunyard.tms.entity.MerchantExample;
import com.sunyard.tms.mapper.DeviceMapper;
import com.sunyard.tms.mapper.MerchantMapper;
import com.sunyard.tms.service.MerchantService;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.DateFormat;
import com.sunyard.tms.utils.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @author:zhangbin
 * @date:${date} ${time}
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    private MerchantMapper merchantMapper;
    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public int addMerchant(Merchant merchant) {
        merchant.setStatus(StatusConstants.MERCHAT_NOTENABLED);
        merchant.setCreateDatetime(DateFormat.dateTimeFormat(new Date()));
        int i = merchantMapper.insertSelective(merchant);
        for (String deviceId : merchant.getDeviceIds()) {
            Device device = new Device();
            device.setDeviceId(deviceId);
            device.setMerchantName(merchant.getMchntName());
            device.setMchntId(merchant.getMchntId());
            device.setUpdateDatetime(DateFormat.dateTimeFormat(new Date()));
            deviceMapper.updateByPrimaryKeySelective(device);
        }
        return i;
    }

    @Override
    public int updateMerchant(Merchant merchant) {
        if (merchant.getDeviceIds()!=null&&merchant.getDeviceIds().size()!=0){
            DeviceExample example = new DeviceExample();
            example.createCriteria().andMchntIdEqualTo(merchant.getMchntId());
            List<Device> devices = deviceMapper.selectByExample(example);
            for (Device device : devices) {
                if (!merchant.getDeviceIds().contains(device.getDeviceId())){
                    device.setMchntId(null);
                    device.setMerchantName(null);
                    deviceMapper.updateByPrimaryKey(device);
                }
            }
            for (String deviceId : merchant.getDeviceIds()) {
                Device device = new Device();
                device.setDeviceId(deviceId);
                device.setMchntId(merchant.getMchntId());
                device.setMerchantName(merchant.getMchntName());
                device.setUpdateDatetime(DateFormat.dateTimeFormat(new Date()));
                deviceMapper.updateByPrimaryKeySelective(device);
            }
        }
        merchant.setUpdateDatetime(DateFormat.dateTimeFormat(new Date()));
        return merchantMapper.updateByPrimaryKeySelective(merchant);
    }

    @Override
    public DataGrid<Merchant> showMerchantByPage(Merchant merchant, IPage page) {
        MerchantExample example = new MerchantExample();
        MerchantExample.Criteria criteria = example.createCriteria();
        criteria.andStatusNotEqualTo(StatusConstants.MERCHAT_DEL);
        if(!Strings.isNullOrEmpty(merchant.getMchntId())){
            criteria.andMchntIdLike("%"+merchant.getMchntId()+"%");
        }
        if(!Strings.isNullOrEmpty(merchant.getMchntName())){
            criteria.andMchntNameLike("%"+merchant.getMchntName()+"%");
        }
        if(!Strings.isNullOrEmpty(merchant.getStatus())){
            criteria.andStatusEqualTo(merchant.getStatus());
        }
        if(!Strings.isNullOrEmpty(merchant.getOrgId())){
            criteria.andOrgIdEqualTo(merchant.getOrgId());
        }
        PageHelper.startPage(page.getPageNo(),page.getPageSize());
        List<Merchant> list = merchantMapper.selectByExample(example);
        // 取分页信息
        PageInfo<Merchant> pageInfo = new PageInfo<>(list);
        // 设置返回结果
        DataGrid<Merchant> dataGrid = new DataGrid<>();
        long total = pageInfo.getTotal();
        dataGrid.setTotal(new Long(total).intValue());
        dataGrid.setRows(list);
        return dataGrid;
    }

    @Override
    public Merchant findMerchantById(Merchant merchant) {
        return merchantMapper.selectByPrimaryKey(merchant.getMchntId());
    }

    @Override
    public boolean checkTerminal(Merchant merchant) {
        DeviceExample example = new DeviceExample();
        DeviceExample.Criteria criteria = example.createCriteria();
        criteria.andMchntIdEqualTo(merchant.getMchntId());
        List<Device> list = deviceMapper.selectByExample(example);
        return list.size() != 0;
    }

    @Override
    public boolean checkMerchantId(Merchant merchant) {
        MerchantExample example = new MerchantExample();
        MerchantExample.Criteria criteria = example.createCriteria();
        criteria.andMchntIdEqualTo(merchant.getMchntId());
        List<Merchant> list = merchantMapper.selectByExample(example);
        return list.size() != 0;
    }
}
