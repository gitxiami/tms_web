package com.sunyard.tms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.sunyard.tms.constant.CodeConst;
import com.sunyard.tms.entity.Operator;
import com.sunyard.tms.entity.OperatorExample;
import com.sunyard.tms.entity.Role;
import com.sunyard.tms.entity.RoleExample;
import com.sunyard.tms.entity.RoleExample.Criteria;
import com.sunyard.tms.mapper.OperatorMapper;
import com.sunyard.tms.mapper.RoleMapper;
import com.sunyard.tms.service.RoleService;
import com.sunyard.tms.utils.BackResult;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.DateFormat;
import com.sunyard.tms.utils.PopedomHelper;
import com.sunyard.tms.utils.PrimaryKeyUtil;
import com.sunyard.tms.utils.PropertyUtil;

/**
 * @Description:角色管理 服务层接口实现类
 * @author:zhangbo
 * @date:2017年7月12日 下午2:19:17
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private OperatorMapper operatorMapper;

	/**
	 * @Description:条件分页查询角色信息
	 * @param role
	 * @return DataGrid<Role>
	 */
	@Override
	public DataGrid<Role> queryRoleByPage(Role role) {
		// 设置条件查询条件
		RoleExample example = new RoleExample();
		Criteria criteria = example.createCriteria();
		if (!Strings.isNullOrEmpty(role.getRoleName())) {
			criteria.andRoleNameLike("%" + role.getRoleName() + "%");
		}
		if (!Strings.isNullOrEmpty(role.getRoleType())) {
			criteria.andRoleTypeEqualTo(role.getRoleType());
		}
		example.setOrderByClause("ROLE_ID ASC");
		// 设置分页信息
		PageHelper.startPage(role.getPage().getPageNo(), role.getPage().getPageSize());
		// 执行查询
		List<Role> list = roleMapper.selectByExample(example);
		//获取角色权限
		for (Role r : list) {
			r.setPopedomIds(PopedomHelper.getPopedomIds(roleMapper.queryRolePopedomByRoleId(r.getRoleId())));
		}
		// 取分页信息
		PageInfo<Role> pageInfo = new PageInfo<>(list);
		// 设置返回结果
		DataGrid<Role> dataGrid = new DataGrid<>();
		long total = pageInfo.getTotal();
		dataGrid.setTotal(new Long(total).intValue());
		dataGrid.setRows(list);
		return dataGrid;
	}

	/**
	 * @Description:添加角色信息
	 * @param role
	 * @return String
	 */
	@Override
	public String addRole(Role role) {
		// 验证角色名称是否存在
		boolean flag = checkRolename(role);
		if (!flag) {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("role.RoleNameIsFull"));
		}
		// 补全角色信息
		role.setRoleId(PrimaryKeyUtil.getPrimaryKey("RO"));
		String time = DateFormat.dateTimeFormat(new Date());
		role.setCreatedDatetime(time);
		role.setUpdateDatetime(time);
		// 设置返回结果
		int result = roleMapper.insert(role);
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("role.insertRoleSuc"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("role.insertRoleFail"));
		}
	}

	/**
	 * @Description:验证角色名称是否存在
	 * @param role
	 * @return boolean
	 */
	public boolean checkRolename(Role role) {
        RoleExample example = new RoleExample();
        Criteria criteria = example.createCriteria();
        criteria.andRoleNameEqualTo(role.getRoleName());
        List<Role> list = roleMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return true;
        }
        return false;
    }

	/**
	 * @Description:修改角色信息
	 * @param role
	 * @return String
	 */
	@Override
	public String updateRole(Role role) {
		if (!role.getRoleName().equals(roleMapper.selectByPrimaryKey(role.getRoleId()).getRoleName())) {
			// 验证用户名称是否存在
			boolean flag = checkRolename(role);
			if (!flag) {
				return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("role.RoleNameIsFull"));
			}
		}
		String time = DateFormat.dateTimeFormat(new Date());
		role.setUpdateDatetime(time);
		// 设置返回结果
		int result = roleMapper.updateByPrimaryKeySelective(role);
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("role.updateRoleSuc"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("role.updateRoleFail"));
		}
	}

	/**
	 * @Description:删除角色信息(物理删除)
	 * @param role
	 * @return String
	 */
	@Override
	public String deleteRole(Role role) {
		String roleId = role.getRoleId();
		// 设置绑定用户的条件查询条件
		OperatorExample example = new OperatorExample();
		com.sunyard.tms.entity.OperatorExample.Criteria criteria= example.createCriteria();
		if (!Strings.isNullOrEmpty(roleId)) {
			criteria.andRoleIdLike("%" + roleId + "%");
		}
		// 执行查询
		List<Operator> list = operatorMapper.selectByExample(example);
		// 判断该角色是否绑定用户
		if (list.size() > 0) {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("role.getRoleByOper"));
		}
		// 设置返回结果
		int result = roleMapper.deleteByPrimaryKey(roleId);
		if (result == 1) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("role.deleteRoleSuc"));
		} else {
			return BackResult.back(false, CodeConst.FAIL, PropertyUtil.getValue("role.deleteRoleFail"));
		}
	}

	/**
	 * @Description:配置角色权限
	 * @param role
	 * @return String
	 */
	@Override
	public String configRole(Role role) {
		//前端传来的权限
		List<String> newPopedoms = role.getPopedomIdList();
		//查询角色现有权限
		List<String> oldPopedoms = roleMapper.queryPopedomById(role.getRoleId());
		//需要新增的权限
		List<String> insert = new ArrayList<>();
		//需要删除的权限
		List<String> delete = new ArrayList<>();
		for (String s : newPopedoms) {
			if (oldPopedoms.contains(s)) {
				continue;
			} else {
				insert.add(s);
			}
		}
		for (String s : oldPopedoms) {
			if (newPopedoms.contains(s)) {
				continue;
			} else {
				delete.add(s);
			}
		}
		// 设置返回结果
		int inResult = 0;
		int deResult = 0;
		//新增权限
		if (!CollectionUtils.isEmpty(insert)) {
			Role in = new Role();
			in.setRoleId(role.getRoleId());
			for (String s : insert) {
				int oneResult = 0;
				in.setPopedomIds(s);
				oneResult = roleMapper.addPopedom(in);
				inResult += oneResult;
			}
		}
		//删除权限
		if (!CollectionUtils.isEmpty(delete)) {
			Role de = new Role();
			de.setRoleId(role.getRoleId());
			de.setPopedomIdList(delete);
			deResult = roleMapper.deletePopedomById(de);
		}
		if (inResult != 0 && deResult != 0) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("role.updateRolePopeSuc"));
		} else if (inResult != 0 && deResult == 0) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("role.insertRolePopeSuc"));
		} else if (inResult == 0 && deResult != 0) {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("role.deleteRolePopeSuc"));
		} else {
			return BackResult.back(true, CodeConst.SUCCESS, PropertyUtil.getValue("role.updateRolePopeError"));
		}
	}

	/**
	 * @Description:查询全部角色信息
	 * @return List<Role>
	 */
	@Override
	public List<Role> queryAllRoles() {
		// 设置条件查询条件
		RoleExample example = new RoleExample();
		List<Role> list = roleMapper.selectByExample(example);
		return list;
	}

}
