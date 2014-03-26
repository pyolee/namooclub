package com.namoo.ns1.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns={"/*"},
	initParams={
		@WebInitParam(name="encoding", value="UTF-8")
	}
)

public class CharacterEncodingFilter implements Filter{

	private String encoding;
	
	@Override
	public void destroy() {
		//
		System.out.println("[destroy]");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filter) throws IOException, ServletException {
		//
		System.out.println("[doFilter]");
		req.setCharacterEncoding(encoding);
		resp.setContentType("text/html; charset=UTF-8");
		
		filter.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		//
		System.out.println("---------------------> [init]");
		this.encoding = config.getInitParameter("encoding");
	}

}
