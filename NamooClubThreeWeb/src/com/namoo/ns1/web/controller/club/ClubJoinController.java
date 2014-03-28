package com.namoo.ns1.web.controller.club;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namoo.ns1.service.facade.ClubService;
import com.namoo.ns1.service.factory.NamooClubServiceFactory;
import com.namoo.ns1.web.controller.DefaultController;
import com.namoo.ns1.web.controller.LogionRequired;
@WebServlet("/club/clubjoin.do")
@LogionRequired
public class ClubJoinController extends DefaultController{
	private static final long serialVersionUID = -7211232794639879473L;

	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 
		
		HttpSession session = req.getSession();
		String userId = (String)session.getAttribute("userId");
		String clubId = req.getParameter("clubId");
		
		ClubService clubService = NamooClubServiceFactory.getInstance().getClubService();
		clubService.joinAsMember(clubId, userId);
		
		//쿼리 스트링
		String urlParam="communityId="+clubService.findClub(clubId).getCommunityId();
		resp.sendRedirect(req.getServletContext().getContextPath()+"/community/selectedCommunity.xhtml?"+urlParam);
	}

}
