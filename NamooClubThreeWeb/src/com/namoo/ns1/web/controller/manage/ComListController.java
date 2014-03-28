package com.namoo.ns1.web.controller.manage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.namoo.ns1.web.controller.community.dto.CommunityDto;

import dom.entity.Community;

@LogionRequired
@WebServlet("/manage/comlist.do")
public class ComListController extends DefaultController {
	//
	private static final long serialVersionUID = 7279977473821028113L;

	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 
		HttpSession session = req.getSession();
		
		String userId = (String) session.getAttribute("userId");
		
		CommunityService communityService = NamooClubServiceFactory.getInstance().getCommunityService();
		
		List<Community> communities = communityService.findAllCommunities();
		List<Community> manageCom = new ArrayList<>();
		
		for (Community community : communities) {
			if(userId.equals(community.getManager().getEmail())) {
				manageCom.add(community);
				
			}
		}
		
		List<CommunityDto> communityDto = new ArrayList<>(); 
		
		for(Community community : manageCom) {
			
			
			CommunityDto dto = new CommunityDto(community, userId);
			
			communityDto.add(dto);
		}
		
		req.setAttribute("dto", communityDto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/management/commanagement.jsp");
		dispatcher.forward(req, resp);
	}

}
