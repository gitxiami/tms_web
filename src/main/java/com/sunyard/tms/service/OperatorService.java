/**
 * 
 */
package com.sunyard.tms.service;

import java.util.LinkedHashMap;
import java.util.List;

import com.sunyard.tms.dto.OperatorDto;
import com.sunyard.tms.entity.Operator;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.IPage;

/**     
 * @Description:用户服务层接口  
 * @author:zhangbin  
 * @date:2017年7月11日 上午9:41:21   
 */
public interface OperatorService {

 
    /**    
     * @Description:用户登录
     * @return TblOperator      
     */ 
    public Operator login(Operator operator);

    /**    
     * @Description:用户修改密码
     * @param operator void      
     */ 
    public int updateOperatorPwd(Operator operator);

    
    /**    
     * @Description:条件查询,分页展示数据
     * @param operator
     * @return DataGrid<Operator>      
     */ 
    public DataGrid<OperatorDto> queryOperatorByPage(Operator operator, IPage page);

    /**    
     * @Description:新增用户
     * @param operator void      
     * @return 
     */ 
    public String addOperator(Operator operator);

    /**    
     * @Description:修改用户信息
     * @param operator
     * @return String      
     */ 
    public int updateOperator(Operator operator);

    /**    
     * @Description:查找所有用户,用于日志模块查询
     * @return List<OperatorDto>      
     */ 
    public List<String> findAll();

    /**    
     * @Description:TODO
     * @param opId
     * @return OperatorDto      
     */ 
    public OperatorDto findOperatorById(String opId);

}
