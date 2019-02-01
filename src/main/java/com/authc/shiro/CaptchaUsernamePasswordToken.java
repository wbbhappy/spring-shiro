package com.authc.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 *com.authc.shiro.CaptchaUsernamePasswordToken
 *添加验证码进行验证
 */
public class CaptchaUsernamePasswordToken extends UsernamePasswordToken {
	private static final long serialVersionUID = 1L;
	private String captcha;
	
	public CaptchaUsernamePasswordToken(String username, char[] password, boolean rememberMe, String host,String captcha) {
		super(username,password,rememberMe,host);
		this.captcha = captcha;
	}

	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
}
