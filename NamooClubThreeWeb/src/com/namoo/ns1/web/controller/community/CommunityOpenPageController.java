package com.namoo.ns1.web.controller.community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/community/open.xhtml")
public class CommunityOpenPageController extends HttpServlet{
	private static final long serialVersionUID = -852192481883357313L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/open.jsp");
		dispatcher.forward(req, resp);
	}
	

}
