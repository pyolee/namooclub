package com.namoo.ns1.web.controller.club;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoo.ns1.service.facade.CommunityService;
import com.namoo.ns1.service.factory.NamooClubServiceFactory;
import com.namoo.ns1.web.controller.DefaultController;
import com.namoo.ns1.web.controller.LogionRequired;

import dom.entity.Community;
@WebServlet("/club/clubopen.xhtml")
@LogionRequired
public class OpenPageController extends DefaultController{
	private static final long serialVersionUID = -5273521571258120115L;

	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 
		String communityId = req.getParameter("communityId");
		
		CommunityService communityService = NamooClubServiceFactory.getInstance().getCommunityService();
		Community community =  communityService.findCommunity(communityId);
		
		req.setAttribute("communityName", community.getName());
		req.setAttribute("description", community.getDescription());
		req.setAttribute("communityId", community.getId());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/club/clubopen.jsp");
		dispatcher.forward(req, resp);
	}

}
