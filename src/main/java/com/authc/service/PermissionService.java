package com.authc.service;

import com.authc.entity.Permission;
import java.util.List;

public interface PermissionService {
	public List<Permission> queryAllPermissionInfo();
	public Permission queryPermissionByPermId(int permId);
}
