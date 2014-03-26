package com.namoo.ns1.web.controller.community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namoo.ns1.service.facade.CommunityService;
import com.namoo.ns1.service.factory.NamooClubServiceFactory;
@WebServlet("/community/withdraw.do")
public class WithdrawController extends HttpServlet{
	private static final long serialVersionUID = 4280073322963101754L;

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
		CommunityService communityService = NamooClubServiceFactory.getInstance().getCommunityService();
		
		String communityId = req.getParameter("communityId");
		String userId = (String)session.getAttribute("userId");
		
		String message = "탈퇴되었습니다.";
		req.setAttribute("message", message);
		
		communityService.withdrawalCommunity(communityId, userId);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/common/info.jsp");
		dispatcher.forward(req, resp);
	}
	
	

}
