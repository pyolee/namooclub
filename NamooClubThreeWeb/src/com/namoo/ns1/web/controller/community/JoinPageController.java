package com.namoo.ns1.web.controller.community;

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

@WebServlet("/community/join.xhtml")
@LogionRequired
public class JoinPageController extends DefaultController{
	private static final long serialVersionUID = 4245288193770606406L;


	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 
		String communityId = req.getParameter("communityId");

		
		CommunityService communityService = NamooClubServiceFactory.getInstance().getCommunityService();
		Community community = communityService.findCommunity(communityId);
		
		
		String description = community.getDescription();
		String communityName = community.getName();
		req.setAttribute("communityName", communityName);
		req.setAttribute("description", description);
		req.setAttribute("communityId", communityId);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/communityjoin.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	

}
