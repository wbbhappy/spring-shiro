package com.authc.shiro;

import com.authc.entity.User;
import com.authc.service.Impl.UserServiceImpl;
import com.authc.service.PermissionService;
import com.authc.service.RoleService;
import com.authc.service.UserService;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

public class MyRealm extends AuthorizingRealm {
	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permService;

	private UserService userService = new UserServiceImpl();
	/* (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 * 为当前登录的Subject授予角色和权限 
     * @see 经测试:本例中该方法的调用时机为需授权资源被访问时 
     * @see 经测试:并且每次访问需授权资源时都会执行该方法中的逻辑,这表明本例中默认并未启用AuthorizationCache 
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//获取当前登录的用户名
		String username = (String) super.getAvailablePrincipal(principals);
		//根据用户名从数据库中获取用户信息
		User user = userService.queryUserByUserName(username);
		List<String> roleList = new ArrayList<String>();
		List<String> permList = new ArrayList<String>();
		System.out.println("对当前用户：["+username+"]进行授权！");
		if(null != user) {
			if(user.getRole()!=null && user.getRole().getRoleName()!=null)	{
				roleList.add(user.getRole().getRoleName());
				if(user.getRole().getPermission()!=null && user.getRole().getPermission().getPermName()!=null)	{
					permList.add(user.getRole().getPermission().getPermName());
					SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
					info.addRoles(roleList);
					info.addStringPermissions(permList);
					return info;
				}
			}
		}else {
			throw new AuthorizationException();
		}
		//若该方法什么都不做直接返回null的话,就会导致任何用户访问/admin/listUser.jsp时都会自动跳转到unauthorizedUrl指定的地址
		return null;
	}
	/* (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 * 验证当前登录的Subject 
     * @see 经测试:本例中该方法的调用时机为LoginController.login()方法中执行Subject.login()时 
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authToken;
		System.out.println("验证当前Subject时获取到token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));  
		User user = userService.queryUserByUserName(token.getUsername());
		if(user!=null) {
			AuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),getName());
			this.setSession("currentUser", user);
			return info;
		}
		return null;
	}
	/** 
     * 将一些数据放到ShiroSession中,以便于其它地方使用 
     * @see 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到 
     */  
	private void setSession(Object key,Object value) {
		Subject currSubject = SecurityUtils.getSubject();
		if(currSubject != null) {
			Session session = currSubject.getSession();
			System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
			if(session!=null) {
				session.setAttribute(key, value);
			}
		}
	}
}
