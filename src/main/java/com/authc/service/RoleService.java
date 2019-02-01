package com.authc.service;

import com.authc.entity.Permission;
import com.authc.entity.Role;
import java.util.List;

public interface RoleService {
	public List<Role> queryAllRoleInfo();
	public Role queryRoleByRoleName(String roleName);
	public Permission queryPermissionByRoleName(String roleName);
}
