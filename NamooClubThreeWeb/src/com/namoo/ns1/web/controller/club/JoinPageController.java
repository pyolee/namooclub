package com.namoo.ns1.web.controller.club;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoo.ns1.service.facade.ClubService;
import com.namoo.ns1.service.factory.NamooClubServiceFactory;
import com.namoo.ns1.web.controller.DefaultController;
import com.namoo.ns1.web.controller.LogionRequired;

import dom.entity.Club;
import dom.entity.Community;
@WebServlet("/club/clubjoin.xhtml")
@LogionRequired
public class JoinPageController extends DefaultController{

	private static final long serialVersionUID = 3215947772568454678L;

	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//
		
		String clubId = req.getParameter("clubId");
		
		ClubService clubService = NamooClubServiceFactory.getInstance().getClubService();
		Club club = clubService.findClub(clubId);

		
		Community community = NamooClubServiceFactory.getInstance().getCommunityService().findCommunity(club.getCommunityId());
		String communityName = community.getName();

		
		String description = club.getDescription();
		String clubName = club.getName();
		
		req.setAttribute("clubId", clubId);
		req.setAttribute("description", description);
		req.setAttribute("clubName", clubName);
		req.setAttribute("communityName", communityName);
		req.setAttribute("communityId", club.getCommunityId());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/club/clubjoin.xhtml");
		dispatcher.forward(req, resp);
		
	}

}
