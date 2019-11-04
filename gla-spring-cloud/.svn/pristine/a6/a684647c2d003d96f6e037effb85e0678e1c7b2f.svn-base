package com.gla.datacenter.intercepter;

import com.gla.auth.jwt.filter.JwtUtil;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class RestTemplateUserContextInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		String   token = ApplicationContextHolder.currentToken();
		request.getHeaders().add(JwtUtil.HEADER_AUTH,token);
		request.getHeaders().add(JwtUtil.HEADER_X_USER_TOKEN,token);
//		request.getHeaders().add("x-user-name",user.getAccount());
//		request.getHeaders().add("x-user-serviceName",request.getURI().getHost());
		return execution.execute(request, body);
	}
}
