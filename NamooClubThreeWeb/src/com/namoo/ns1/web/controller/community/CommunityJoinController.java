package com.namoo.ns1.web.controller.community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namoo.ns1.service.facade.CommunityService;
import com.namoo.ns1.service.factory.NamooClubServiceFactory;
import com.namoo.ns1.web.controller.DefaultController;
import com.namoo.ns1.web.controller.LogionRequired;
@WebServlet("/community/join.do")
@LogionRequired
public class CommunityJoinController extends DefaultController{
	private static final long serialVersionUID = -1966809149646068704L;

	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();

		String communityId = req.getParameter("communityId");
		String userId = (String) session.getAttribute("userId");

		CommunityService communityService = NamooClubServiceFactory.getInstance().getCommunityService();
		communityService.joinAsMember(communityId, userId);
		
		String communityName = communityService.findCommunity(communityId).getName();
		req.setAttribute("message", communityName+" 커뮤니티에 가입되었습니다.");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/common/joininfo.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	

}
