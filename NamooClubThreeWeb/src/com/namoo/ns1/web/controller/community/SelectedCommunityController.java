package com.namoo.ns1.web.controller.community;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namoo.ns1.service.facade.ClubService;
import com.namoo.ns1.service.facade.CommunityService;
import com.namoo.ns1.service.factory.NamooClubServiceFactory;
import com.namoo.ns1.web.controller.DefaultController;
import com.namoo.ns1.web.controller.LogionRequired;
import com.namoo.ns1.web.controller.club.dto.ClubDto;

import dom.entity.Club;
import dom.entity.Community;
@WebServlet("/community/selectedCommunity.xhtml")
@LogionRequired
public class SelectedCommunityController extends DefaultController{

	private static final long serialVersionUID = 3681237291560288044L;

	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		String communityId = req.getParameter("communityId");
		CommunityService communityService = NamooClubServiceFactory.getInstance().getCommunityService();
		ClubService clubService = NamooClubServiceFactory.getInstance().getClubService();
		
		Community community = communityService.findCommunity(communityId);
		
		req.setAttribute("communityName", community.getName());
		req.setAttribute("description", community.getDescription());
		req.setAttribute("communityId", community.getId());
		
		List<Club> clubs = clubService.findClubById(communityId);
		req.setAttribute("clubs", clubs);

		
		List<ClubDto> clubDto = new ArrayList<>(); 
		
		for(Club club : clubs) {
			ClubDto dto = new ClubDto(club, userId);
			
			clubDto.add(dto);
		}
		
		req.setAttribute("clubDto", clubDto);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/selectedcommunity.jsp");
		dispatcher.forward(req, resp);
		
	}

}
