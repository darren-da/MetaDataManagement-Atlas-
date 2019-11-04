package com.gla.datacenter.intercepter;


import com.gla.auth.jwt.filter.JwtUtil;
import com.gla.datacenter.domain.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 存储用户信息
 */
public class ApplicationContextHolder {
	static Logger logger= LoggerFactory.getLogger(ApplicationContextHolder.class);
	public static ThreadLocal<UserInfo> context = new ThreadLocal<UserInfo>();
	public static ThreadLocal<String> token = new ThreadLocal<String>();
	public static UserInfo currentUser() {
		//此方法过慢需要找解决方案：如 redis存储
		logger.info("调用currentUser方法,token->{}",token.get());
		return  JwtUtil.getInstance().validateToken(token.get());
//		return context.get();
	}
	public static String currentToken() {
		return token.get();
	}
	public static void setToken(String tk) {
		token.set(tk);
	}
	public static void setUser(UserInfo userInfo) {
		context.set(userInfo);
	}
	public static void shutdownUser() {
		context.remove();
	}
	public static void shutdownToken() {
		token.remove();
	}


}
