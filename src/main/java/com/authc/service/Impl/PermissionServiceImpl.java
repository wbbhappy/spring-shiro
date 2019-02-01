package com.authc.service.Impl;

import com.authc.entity.Permission;
import com.authc.service.PermissionService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service("PermissionService")
public class PermissionServiceImpl implements PermissionService {
	public List<Permission> queryAllPermissionInfo() {
		Permission perm = new Permission(1,"member:add");
		Permission perm1 = new Permission(2,"member:delete");
		Permission perm2 = new Permission(3,"admin:manage");
		
		List<Permission> permList = new ArrayList<Permission>();
		permList.add(perm);
		permList.add(perm1);
		permList.add(perm2);
		
		return permList;
	}

	public Permission queryPermissionByPermId(int permId) {
		List<Permission> permList = queryAllPermissionInfo();
		for (Permission perm : permList) {
			if(perm.getPermId() == permId) {
				return perm;
			}
		}	
		return null;
	}
}
