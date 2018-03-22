package com.sunyard.tms.controller;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sunyard.tms.aop.CreateLog;
import com.sunyard.tms.dto.DeviceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.constant.CommonConstants;
import com.sunyard.tms.entity.Brand;
import com.sunyard.tms.service.BrandService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.IPage;

/**
 * @Description:厂商管理 控制层
 * @author:zhangbo
 * @date:2017年11月30日 上午10:33:58
 */
@Controller
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    private static final Logger logger = LoggerFactory.getLogger(BrandController.class);

    /**
     * @Description:条件分页查询厂商信息
     * @param brand
     * @param page
     * @return String
     */
    @RequestMapping("/showBrand")
    @ResponseBody
    @CreateLog(description = "query brand")
    public String showBrandByPage(Brand brand, IPage page) {
        try {
            brand.setPage(page);
            DataGrid<Brand> brands = brandService.queryBrandByPage(brand);
            return JSON.toJSONString(brands);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:添加厂商信息
     * @param brand
     * @return String
     */
    @RequestMapping("/addBrand")
    @ResponseBody
    @CreateLog(description = "add brand")
    public String addBrand(Brand brand) {
        try {
            return brandService.addBrand(brand);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:修改厂商信息
     * @param brand
     * @return String
     */
    @RequestMapping("/updateBrand")
    @ResponseBody
    @CreateLog(description = "modify brand")
    public String updateBrand(Brand brand) {
        if (Strings.isNullOrEmpty(brand.getBrandId())) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        try {
            return brandService.updateBrand(brand);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:删除厂商信息(物理删除)
     * @param brand
     * @return String
     */
    @RequestMapping("/deleteBrand")
    @ResponseBody
    @CreateLog(description = "delete brand")
    public String deleteBrand(Brand brand) {
        try {
            if (Strings.isNullOrEmpty(brand.getBrandId())) {
                return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
            }
            return brandService.deleteBrand(brand);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:查询全部厂商信息
     * @return String
     */
    @RequestMapping("/allBrand")
    @ResponseBody
    public String showAllBrand() {
        try {
            List<Brand> brands = brandService.queryAllBrands();
            List<DeviceType> list = new ArrayList<>();
            list.add(new DeviceType("1","FIXED POS",new ArrayList<String>()));
            list.add(new DeviceType("2","Traditional POS",new ArrayList<String>()));
            list.add(new DeviceType("3","Intelligent POS",new ArrayList<String>()));
            for (Brand brand : brands) {
                brand.setChildren(list);
            }
            return JSON.toJSONString(brands, SerializerFeature.DisableCircularReferenceDetect);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
}