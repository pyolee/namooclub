package com.namoo.ns1.web.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namoo.ns1.service.facade.TownerService;
import com.namoo.ns1.service.factory.NamooClubServiceFactory;
@WebServlet("/user/login.do")
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 2672592270255348286L;

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
		TownerService townerService = NamooClubServiceFactory.getInstance().getTownerService();
		
		String loginId = req.getParameter("loginId");
		String loginPassword = req.getParameter("loginPassword");
		
		HttpSession session = req.getSession();
		
		if(townerService.loginAsTowner(loginId, loginPassword)) {
			
			session.setAttribute("userId", loginId);
			session.setAttribute("userName", townerService.findTowner(loginId).getName());
			resp.sendRedirect(req.getServletContext().getContextPath()+"/community/main.xhtml");
			
		} else if(!townerService.loginAsTowner(loginId, loginPassword)) {
			throw new RuntimeException("로그인에 실패하였습니다.  다시 로그인 해주세요.");
		}
		
	}
	
	

}
