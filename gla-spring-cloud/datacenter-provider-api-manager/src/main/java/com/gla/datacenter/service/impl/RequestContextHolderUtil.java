package com.gla.datacenter.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class RequestContextHolderUtil {
	
	public HttpServletRequest getRequest() {
		return getRequestAttributes().getRequest();
	}

	public HttpServletResponse getResponse() {
		return getRequestAttributes().getResponse();
	}

	public HttpSession getSession() {
		return getRequest().getSession();
	}

	public ServletRequestAttributes getRequestAttributes() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
	}

	public ServletContext getServletContext() {
		return ContextLoader.getCurrentWebApplicationContext().getServletContext();
	}

}
