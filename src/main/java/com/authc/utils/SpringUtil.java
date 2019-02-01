package com.authc.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("springmvc.xml");
	public static Object getBean(String beanId)
	{
		return ctx.getBean(beanId);
	}
}
