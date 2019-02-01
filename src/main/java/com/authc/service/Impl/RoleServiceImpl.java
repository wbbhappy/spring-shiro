package com.authc.service.Impl;

import com.authc.entity.Permission;
import com.authc.entity.Role;
import com.authc.service.RoleService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service("RoleService")
public class RoleServiceImpl implements RoleService {
	public List<Role> queryAllRoleInfo() {
		Permission perm = new Permission(1,"member:add");
		Role role = new Role();
		role.setRoleName("member");
		role.setPermission(perm);
		Permission perm1 = new Permission(2,"member:delete");
		Role role1 = new Role();
		role1.setRoleName("member");
		role1.setPermission(perm1);
		Permission perm2 = new Permission(3,"admin:manage");
		Role role2 = new Role();
		role2.setRoleName("admin");
		role2.setPermission(perm2);
		List<Role> roleList = new ArrayList<Role>();
		roleList.add(role);
		roleList.add(role1);
		roleList.add(role2);
		
		return roleList;
	}

	public Role queryRoleByRoleName(String roleName) {
		List<Role> roleList = queryAllRoleInfo();
		for (Role role : roleList) {
			if(role.getRoleName().equals(roleName))	{
				return role;
			}
		}
		return null;
	}

	public Permission queryPermissionByRoleName(String roleName) {
		List<Role> roleList = queryAllRoleInfo();
		for (Role role : roleList) {
			if(role.getRoleName().equals(roleName))	{
				return role.getPermission();
			}
		}
		return null;
	}
}
