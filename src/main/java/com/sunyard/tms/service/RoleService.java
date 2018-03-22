package com.sunyard.tms.service;

import java.util.List;

import com.sunyard.tms.entity.Role;
import com.sunyard.tms.utils.DataGrid;

/**
 * @Description:角色管理 服务层接口
 * @author:zhangbo
 * @date:2017年11月30日 上午10:34:18
 */
public interface RoleService {

	/**
	 * @Description:条件分页查询角色信息
	 * @param role
	 * @return DataGrid<Role>
	 */

	public DataGrid<Role> queryRoleByPage(Role role);

	/**
	 * @Description:添加角色信息
	 * @param role
	 * @return String
	 */
	public String addRole(Role role);

	/**
	 * @Description:修改角色信息
	 * @param role
	 * @return String
	 */
	public String updateRole(Role role);

	/**
	 * @Description:删除角色信息(物理删除)
	 * @param role
	 * @return String
	 */
	public String deleteRole(Role role);

	/**
	 * @Description:配置角色权限
	 * @param role
	 * @return String
	 */
	public String configRole(Role role);

	/**
	 * @Description:查询全部角色信息
	 * @return List<Role>
	 */
	public List<Role> queryAllRoles();

}
