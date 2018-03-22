package com.sunyard.tms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import com.sunyard.tms.aop.CreateLog;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.constant.CommonConstants;
import com.sunyard.tms.entity.Model;
import com.sunyard.tms.service.ModelService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.IPage;

/**
 * @Description:型号管理 控制层
 * @author:zhangbo
 * @date:2017年11月30日 上午10:33:58
 */
@Controller
@RequestMapping("/model")
public class ModelController {
    @Autowired
    private ModelService modelService;

    private static final Logger logger = LoggerFactory.getLogger(ModelController.class);

    /**
     * @Description:条件分页查询型号信息
     * @param model
     * @param page
     * @return String
     */
    @RequestMapping("/showModel")
    @ResponseBody
    @CreateLog(description = "query model")
    public String showModelByPage(Model model, IPage page) {
        try {
            model.setPage(page);
            DataGrid<Model> models = modelService.queryModelByPage(model);
            return JSON.toJSONString(models);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:添加型号信息
     * @param model
     * @return String
     */
    @RequestMapping("/addModel")
    @ResponseBody
    @CreateLog(description = "add model")
    public String addModel(Model model) {
        try {
            return modelService.addModel(model);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:修改型号信息
     * @param model
     * @return String
     */
    @RequestMapping("/updateModel")
    @ResponseBody
    @CreateLog(description = "modify model")
    public String updateModel(Model model) {
        if (Strings.isNullOrEmpty(model.getModelId())) {
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
        try {
            return modelService.updateModel(model);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:删除型号信息(物理删除)
     * @param model
     * @return String
     */
    @RequestMapping("/deleteModel")
    @ResponseBody
    @CreateLog(description = "delete model")
    public String deleteModel(Model model) {
        try {
            if (Strings.isNullOrEmpty(model.getModelId())) {
                return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
            }
            return modelService.deleteModel(model);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }

    /**
     * @Description:根据商场和类型查型号
     * @return String
     */
    @RequestMapping("/allModel")
    @ResponseBody
    public String showAllModel(Model model) {
        try {
            List<Model> models = modelService.queryAllModels(model);
            return JSON.toJSONString(models);
        } catch (Exception e) {
            logger.error(CommonConstants.SYSTEM_ERROR, e);
            return BackResult.back(false, CodeConst.ERROR, CommonConstants.SYSTEM_ERROR);
        }
    }
}