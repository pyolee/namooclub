package com.namoo.ns1.web.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/join.xhtml")
public class JoinPageController extends HttpServlet{
	private static final long serialVersionUID = 5162821043501464250L;

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
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/join.jsp");
		dispatcher.forward(req, resp);
	}
	
	

}
