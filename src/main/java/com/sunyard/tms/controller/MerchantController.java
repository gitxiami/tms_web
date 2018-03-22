package com.sunyard.tms.controller;

import com.alibaba.fastjson.JSON;
import com.sunyard.tms.aop.CreateLog;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.constant.CommonConstants;
import com.sunyard.tms.constant.StatusConstants;
import com.sunyard.tms.dto.MerchantDto;
import com.sunyard.tms.entity.Device;
import com.sunyard.tms.entity.Merchant;
import com.sunyard.tms.service.DeviceService;
import com.sunyard.tms.service.MerchantService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.IPage;
import com.sunyard.tms.utils.PropertyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:商户管理
 * @author:zhangbin
 */
@RestController
@RequestMapping("/merchant")
public class MerchantController {
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private DeviceService deviceService;
    private final static Logger logger = LoggerFactory.getLogger(OperatorController.class);

    /**
     * @Description:条件查询,分页展示商户
     */
    @RequestMapping("/showMerchantByPage")
    @CreateLog(description = "query merchant")
    public String showMerchantByPage(Merchant merchant, IPage page) {
        DataGrid<Merchant> dataGrid = merchantService.showMerchantByPage(merchant, page);
        return JSON.toJSONString(dataGrid);
    }

    @RequestMapping("/findMerchantById")
    @CreateLog(description = "query merchant detail")
    public String findMerchantById(Merchant merchant) {
        Merchant queryMerchant = merchantService.findMerchantById(merchant);
        List<Device> list = deviceService.findByMerchantId(merchant);
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put("merchant", queryMerchant);
        map.put("device", list);
        return JSON.toJSONString(map);
    }

    /**
     * @Description:新增商户
     */
    @RequestMapping("/addMerchant")
    @CreateLog(description = "add merchant")
    public String addMerchant(Merchant merchant) {
        try {
            boolean flag = merchantService.checkMerchantId(merchant);
            if (flag) {
                return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("merchat.idIsFull"));
            }
            int i = merchantService.addMerchant(merchant);
            if (i == 1) {
                return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("merchat.addSuc"));
            } else {
                return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("merchat.addFail"));
            }
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }

    }

    /**
     * @Description:修改商户
     */
    @RequestMapping("/updateMerchant")
    @CreateLog(description = "modify merchant")
    public String updateMerchant(Merchant merchant) {
        try {
            if (!merchant.getMchntName().equals(merchantService.findMerchantById(merchant).getMchntName())) {
                boolean flag = merchantService.checkMerchantId(merchant);
                if (flag) {
                    return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("merchat.idIsFull"));
                }
            }
            int i = merchantService.updateMerchant(merchant);
            if (i == 1) {
                return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("merchat.updateSuc"));
            } else {
                return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("merchat.updateFail"));
            }
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:启用商户
     */
    @RequestMapping("/enableMerchant")
    @CreateLog(description = "enable merchant")
    public String enableMerchant(Merchant merchant) {
        try {
            merchant.setStatus(StatusConstants.MERCHAT_ENABLED);
            int i = merchantService.updateMerchant(merchant);
            if (i == 1) {
                return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("merchat.enableSuc"));
            } else {
                return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("merchat.enableFail"));
            }
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:停用商户
     */
    @RequestMapping("/disableMerchant")
    @CreateLog(description = "disable merchant")
    public String disableMerchant(Merchant merchant) {
        try {
            boolean flag = merchantService.checkTerminal(merchant);
            if (flag) {
                return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("merchat.hasTerminal"));
            }
            merchant.setStatus(StatusConstants.MERCHAT_STOP);
            int i = merchantService.updateMerchant(merchant);
            if (i == 1) {
                return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("merchat.disableSuc"));
            } else {
                return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("merchat.disableFail"));
            }
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:注销商户
     */
    @RequestMapping("/delMerchat")
    @CreateLog(description = "delete merchant")
    public String delMerchat(Merchant merchant) {
        try {
            merchant.setStatus(StatusConstants.MERCHAT_DEL);
            int i = merchantService.updateMerchant(merchant);
            if (i == 1) {
                return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("merchat.delSuc"));
            } else {
                return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("merchat.delFail"));
            }
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
}
