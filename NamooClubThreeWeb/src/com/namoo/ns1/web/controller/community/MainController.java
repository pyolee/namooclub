package com.namoo.ns1.web.controller.community;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoo.ns1.service.facade.CommunityService;
import com.namoo.ns1.service.factory.NamooClubServiceFactory;

import dom.entity.Community;
@WebServlet("/community/main.xhtml")
public class MainController extends HttpServlet{
	private static final long serialVersionUID = 6386265767321202117L;

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
		CommunityService communityService = NamooClubServiceFactory.getInstance().getCommunityService();
		List<Community> communities = communityService.findAllCommunities();
		req.setAttribute("communities", communities);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/main.jsp");
		dispatcher.forward(req, resp);
	}
	
	

}
