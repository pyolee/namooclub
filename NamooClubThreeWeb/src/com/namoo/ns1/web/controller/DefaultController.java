package com.namoo.ns1.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public abstract class DefaultController extends HttpServlet{

	private static final long serialVersionUID = 4882248444263287396L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 
		//현재 클래스에 loginAnnotation이 붙어있는지 체크
		if (this.getClass().getAnnotation(LogionRequired.class) != null) {
			//
			HttpSession session = req.getSession();
			if(session.getAttribute("userId") == null) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/common/loginsignerror.jsp");
				dispatcher.forward(req, resp);
				return;
			}
		}
		
		//
		process(req, resp);
	}
	
	protected abstract void process(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException;
	
	

}
