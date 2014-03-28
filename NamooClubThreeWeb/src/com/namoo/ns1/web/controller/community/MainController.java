package com.namoo.ns1.web.controller.community;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
@WebServlet("/community/main.xhtml")
@LogionRequired
public class MainController extends DefaultController{
	private static final long serialVersionUID = 6386265767321202117L;


	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		
		CommunityService communityService = NamooClubServiceFactory.getInstance().getCommunityService();

		List<Community> communities = communityService.findAllCommunities();
		List<Community> myCommunities = communityService.findBelongCommunities(userId);
		
		//내가 가입한 커뮤니티의 Dto 생성 로직
		List<CommunityDto> myCommunityDto = new ArrayList<>(); 
		
		for(Community community : myCommunities) {
			
			
			CommunityDto dto = new CommunityDto(community, userId);
			
			myCommunityDto.add(dto);
		}
		
		// 미가입 커뮤니티 filtering.
		filterCommunities(communities, myCommunities);
		
		//미가입한 커뮤니티의 Dto 생성 로직
		List<CommunityDto> communityDto = new ArrayList<>(); 
		
		for(Community community : communities) {
			CommunityDto dto = new CommunityDto(community, userId);
			
			communityDto.add(dto);
		}
		
		req.setAttribute("myCommunityDto", myCommunityDto);
		req.setAttribute("communityDto", communityDto);
	
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/main.jsp");
		dispatcher.forward(req, resp);
	}

	private void filterCommunities(List<Community> communities,	List<Community> myCommunities) {
		List<Community> removed = new ArrayList<Community>();
		
		for(Community community : communities) {			
			for(Community myCommunity : myCommunities) {
				if(community.getName().equals(myCommunity.getName())) {
					removed.add(community);
				}
			}
		}
		
		if (!removed.isEmpty()) {
			communities.removeAll(removed);
		}
	}
	

}
