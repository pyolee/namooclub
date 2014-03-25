package com.namoo.ns1.web.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoo.ns1.service.facade.TownerService;
import com.namoo.ns1.service.factory.NamooClubServiceFactory;

@WebServlet("/user/join.do")
public class JoinController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -257322423129072756L;

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
		
		TownerService townerService = NamooClubServiceFactory.getInstance().getTownerService();
		
		String joinName = req.getParameter("joinName");
		String joinEmail = req.getParameter("joinEmail");
		String joinPassword = req.getParameter("joinPassword");
		
		townerService.registTowner(joinName, joinEmail, joinPassword);
		
		resp.sendRedirect(req.getServletContext().getContextPath()+"/login.xhtml");

	}

}
