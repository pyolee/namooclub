package com.namoo.ns1.web.controller.club;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namoo.ns1.service.facade.ClubService;
import com.namoo.ns1.service.factory.NamooClubServiceFactory;
import com.namoo.ns1.web.controller.DefaultController;
import com.namoo.ns1.web.controller.LogionRequired;

@WebServlet("/club/clubwithdraw.do")
@LogionRequired
public class ClubWithdrawController extends DefaultController{
	private static final long serialVersionUID = -8896518358380997067L;

	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 
		HttpSession session = req.getSession();
		ClubService clubService = NamooClubServiceFactory.getInstance().getClubService();
		
		String clubId = req.getParameter("clubId");
		String userId = (String)session.getAttribute("userId");
		
		String message = "탈퇴되었습니다.";
		req.setAttribute("message", message);

		clubService.withdrawalClub(clubId, userId);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/common/info.jsp");
		dispatcher.forward(req, resp);
	}

}
