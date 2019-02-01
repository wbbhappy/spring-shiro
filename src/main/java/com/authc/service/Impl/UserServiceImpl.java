package com.authc.service.Impl;

import com.authc.entity.Permission;
import com.authc.entity.Role;
import com.authc.entity.User;
import com.authc.service.UserService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {
	public List<User> queryAllUserInfo() {
		Permission perm = new Permission(1,"member:add");
		Role role = new Role();
		role.setRoleName("member");
		role.setPermission(perm);
		User user = new User();
		user.setUsername("liuyuxin");
		user.setPassword("111111");
		user.setRole(role);
		Permission perm1 = new Permission(2,"member:delete");
		Role role1 = new Role();
		role1.setRoleName("member");
		role1.setPermission(perm1);
		User user1 = new User();
		user1.setUsername("liudong");
		user1.setPassword("111111");
		user1.setRole(role1);
		Permission perm2 = new Permission(3,"admin:manage");
		Role role2 = new Role();
		role2.setRoleName("admin");
		role2.setPermission(perm2);
		User user2 = new User();
		user2.setUsername("liuhuan");
		user2.setPassword("111111");
		user2.setRole(role2);
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		userList.add(user1);
		userList.add(user2);
		
		return userList;
	}

	public User queryUserByUserName(String username) {
		List<User> userList = queryAllUserInfo();
		for (User user : userList) {
			if(user.getUsername().equals(username))	{
				return user;
			}
		}
		return null;
	}

	public Role queryUserRoleByUsername(String username) {
		List<User> userList = queryAllUserInfo();
		Role role = new Role();
		for (User user : userList) {
			if(user.getUsername().equals(username)) {
				role = user.getRole();
				return role;
			}
		}
		return null;
	}
}
