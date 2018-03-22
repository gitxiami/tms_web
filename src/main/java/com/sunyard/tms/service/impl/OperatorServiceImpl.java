/**
 * 
 */
package com.sunyard.tms.service.impl;

import java.util.Date;
import java.util.List;
import com.sunyard.tms.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.constant.StatusConstants;
import com.sunyard.tms.dto.OperatorDto;
import com.sunyard.tms.entity.Operator;
import com.sunyard.tms.entity.OperatorExample;
import com.sunyard.tms.entity.OperatorExample.Criteria;
import com.sunyard.tms.mapper.OperatorMapper;
import com.sunyard.tms.service.OperatorService;

/**
 * @Description:用户类服务层实现类
 * @author:zhangbin
 * @date:2017年7月11日 上午9:42:40
 */
@Service
@Transactional(rollbackFor = Exception.class )
public class OperatorServiceImpl implements OperatorService {
    @Autowired
    private OperatorMapper operatorMapper;

    /**
     * @Description:用户登录
     * @return TblOperator
     */
    @Override
    public Operator login(Operator operator) {
        // 验证用户名
        OperatorExample example = new OperatorExample();
        Criteria criteria = example.createCriteria();
        criteria.andOpUsernameEqualTo(operator.getOpUsername());
        criteria.andOpStatusNotEqualTo(StatusConstants.OPERATPR_LOGOFF);
        List<Operator> list = operatorMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            operator.setMessage(PropertyUtil.getValue("user.loginErrorNameOrPwd"));
            return operator;
        }
        Operator loginOperator = list.get(0);
        // 验证用户状态,0-正常,1-注销,2-锁定
        if (loginOperator.getOpStatus().equals(StatusConstants.OPERATPR_LOCK)) {
            loginOperator.setMessage(PropertyUtil.getValue("user.userFlagFalse"));
            return loginOperator;
        }
        // 将用户输入的密码替换成加密密码
        operator.setOpPwd(DigestUtils.md5DigestAsHex(operator.getOpPwd().getBytes()));
        // 验证用户密码
        if (!loginOperator.getOpPwd().equals(operator.getOpPwd())) {
            if (loginOperator.getOpUsername().equals(PropertyUtil.getParam("admin"))) {
                loginOperator.setMessage(PropertyUtil.getValue("user.loginErrorNameOrPwd"));
            } else {
                // 密码输入错误,进行错误次数累加操作
                // 用户登录多长时间内错误次数累加单位分钟
                int loginErrorTimeRang = Integer.parseInt(PropertyUtil.getParam("loginErrorTimeRang"));
                if (loginErrorTimeRang >= 0) {
                    long timeout = loginErrorTimeRang * 60;
                    String beginDate = loginOperator.getOpErrortime();
                    String endDate = DateFormat.dateTimeFormat(new Date());
                    if (beginDate != null && DateFormat.comPareDate(beginDate, endDate) < timeout) {
                        // 进行错误次数累加
                        loginOperator.setOpPwdErrnum(loginOperator.getOpPwdErrnum() + 1);
                    } else {
                        // 将错误次数重置为1，更新第一次错误时间
                        loginOperator.setOpPwdErrnum(1);
                        loginOperator.setOpErrortime(endDate);
                    }
                    // 从配置文件中取密码错误次数
                    int loginErrorCount = Integer.parseInt(PropertyUtil.getParam("loginErrorCount"));
                    loginOperator.setMessage(PropertyUtil.getValue("user.loginErrorNameOrPwd"));
                    // 密码错误次数超过上限,锁定用户
                    if (loginErrorCount >= 0 && loginOperator.getOpPwdErrnum() >= loginErrorCount) {
                        loginOperator.setOpStatus(StatusConstants.OPERATPR_LOCK);
                        loginOperator.setMessage(PropertyUtil.getValue("user.userFlagFalse"));
                    }
                    loginOperator.setUpdateDatetime(endDate);
                    operatorMapper.updateByPrimaryKeySelective(loginOperator);
                }
            }
            return loginOperator;
        }
        // 验证正确
        loginOperator.setOpPwdErrnum(0);
        loginOperator.setOpErrortime(null);
        loginOperator.setOpLastLoginTime(DateFormat.dateTimeFormat(new Date()));
        operatorMapper.updateByPrimaryKey(loginOperator);
        return loginOperator;
    }

    /**
     * @Description:用户修改自己的密码
     */
    @Override
    public int updateOperatorPwd(Operator operator) {
        // 将密码替换成MD5加密
        operator.setUpdateDatetime(DateFormat.dateTimeFormat(new Date()));
        int result = operatorMapper.updateByPrimaryKeySelective(operator);
        return result;
    }

    /**
     * @Description:条件查询,分页展示数据
     * @param operator
     * @return DataGrid<Operator>
     */
    @Override
    public DataGrid<OperatorDto> queryOperatorByPage(Operator operator, IPage page) {
        // 设置分页信息
        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        // 执行查询
        List<OperatorDto> list = operatorMapper.showOperator(operator);
        // 取分页信息
        PageInfo<OperatorDto> pageInfo = new PageInfo<>(list);
        // 设置返回结果
        DataGrid<OperatorDto> dataGrid = new DataGrid<>();
        long total = pageInfo.getTotal();
        dataGrid.setTotal(new Long(total).intValue());
        dataGrid.setRows(list);
        return dataGrid;
    }

    /**
     * @Description:新增用户
     * @param operator void
     * @return String
     */
    @Override
    public String addOperator(Operator operator) {
        // 验证用户名是否存在
        boolean flag = checkUsername(operator);
        if (!flag) {
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("user.validateName"));
        }
        // 取得默认密码
        String defalutPassword =PropertyUtil.getParam("defaultPwd");
        // 补全用户信息
        operator.setOpId(PrimaryKeyUtil.getPrimaryKey("OP"));
        operator.setOpPwd(DigestUtils.md5DigestAsHex(defalutPassword.getBytes()));
        operator.setOpStatus(StatusConstants.OPERATPR_NORMAL);
        Date date = new Date();
        operator.setCreatedDatetime(DateFormat.dateTimeFormat(date));
        operator.setUpdateDatetime(DateFormat.dateTimeFormat(date));
        int result = operatorMapper.insertSelective(operator);
        if (result == 1) {
            return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("user.userAddOK"));
        } else {
            return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("user.userAddErr"));
        }
    }

    /**
     * @Description:验证用户名是否存在
     * @param operator
     */
    public boolean checkUsername(Operator operator) {
        OperatorExample example = new OperatorExample();
        Criteria criteria = example.createCriteria();
        criteria.andOpUsernameEqualTo(operator.getOpUsername());
        criteria.andOpStatusNotEqualTo(StatusConstants.OPERATPR_LOGOFF);
        List<Operator> list = operatorMapper.selectByExample(example);
        return list == null || list.size() == 0;
    }

    /**
     * @Description:修改用户信息
     * @param operator
     * @return String
     */
    @Override
    public int updateOperator(Operator operator) {
        operator.setUpdateDatetime(DateFormat.dateTimeFormat(new Date()));
        int result = operatorMapper.updateByPrimaryKeySelective(operator);
        return result;
    }

    @Override
    public List<String> findAll() {
        List<String> map = operatorMapper.findAll();
        return map;
    }

    @Override
    public OperatorDto findOperatorById(String opId) {
        return operatorMapper.findOperatorById(opId);
    }

}
