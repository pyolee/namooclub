package com.namoo.ns1.web.controller.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namoo.ns1.service.facade.CommunityService;
import com.namoo.ns1.service.factory.NamooClubServiceFactory;
@WebServlet("/community/open.do")
public class CommunityOpenController extends HttpServlet{
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
		HttpSession session = req.getSession();
		String communityName = req.getParameter("communityName");
		String description = req.getParameter("description");
		String userId = (String) session.getAttribute("userId");
		
		
		CommunityService communityService = NamooClubServiceFactory.getInstance().getCommunityService();
		communityService.registCommunity(communityName, description, userId);
		
		resp.sendRedirect(req.getServletContext().getContextPath()+"/community/main.xhtml");
	}
	
	

}
