package com.authc.service;

import com.authc.entity.Role;
import com.authc.entity.User;
import java.util.List;

public interface UserService {
	public List<User> queryAllUserInfo();
	public User queryUserByUserName(String username);
	public Role queryUserRoleByUsername(String username);
}
