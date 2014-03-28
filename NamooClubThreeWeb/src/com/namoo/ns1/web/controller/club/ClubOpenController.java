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

@WebServlet("/club/open.do")
@LogionRequired
public class ClubOpenController extends DefaultController{
	private static final long serialVersionUID = 1688175123532640391L;

	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 
		HttpSession session = req.getSession();
		String communityId = req.getParameter("communityId");
		String clubName = req.getParameter("clubName");
		String description = req.getParameter("description");
		String userId = (String)session.getAttribute("userId");
		
		ClubService clubService = NamooClubServiceFactory.getInstance().getClubService();
		clubService.registClub(communityId, clubName, description, userId);
		
		//쿼리 스트링
		String urlParam="communityId="+communityId;
		
		
		resp.sendRedirect(req.getServletContext().getContextPath()+"/community/selectedCommunity.xhtml?"+urlParam);
		
	}

}
