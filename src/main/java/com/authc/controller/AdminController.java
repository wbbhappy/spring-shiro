package com.authc.controller;

import com.authc.entity.User;
import com.authc.service.Impl.UserServiceImpl;
import com.authc.service.UserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private UserService userService = new UserServiceImpl();
	
	@RequiresRoles("admin")
	@RequestMapping("/queryAllUserInfo")
	public String queryAllUserInfo(HttpServletRequest request)	{
		List<User> userList = userService.queryAllUserInfo();
		request.setAttribute("userList", userList);
		return "/admin";
	}
}
