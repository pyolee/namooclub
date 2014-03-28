package com.namoo.ns1.service.logic;

import java.util.ArrayList;
import java.util.List;

import com.namoo.ns1.data.EntityManager;
import com.namoo.ns1.service.facade.ClubService;
import com.namoo.ns1.service.logic.exception.NamooExceptionFactory;
import com.namoo.ns1.service.util.SequenceGenerator;

import dom.entity.Club;
import dom.entity.ClubMember;
import dom.entity.Community;
import dom.entity.SocialPerson;

public class ClubServiceLogic implements ClubService{
	
	private EntityManager em;
	
	public ClubServiceLogic() {
		//
		em = EntityManager.getInstance();
	}

	@Override
	public void registClub(String communityId, String clubName, String description,
			String email) {
		//
		if (em.find(Club.class, clubName) != null) {
			throw NamooExceptionFactory.createRuntime("이미 존재하는 클럽입니다.");
		}
		
		SocialPerson towner = em.find(SocialPerson.class, email);
		if (towner == null) {
			throw NamooExceptionFactory.createRuntime("존재하지 않는 주민입니다.");
		}
		
		String id = SequenceGenerator.getNextId(Club.class);
		
		Club club = new Club(clubName, description, towner, id, communityId);
		
		Community community = em.find(Community.class, communityId);
		community.addClub(club);
		em.store(community);
		
		em.store(club);
	}

	@Override
	public void joinAsMember(String clubId, String email) {
		// 
		Club club = em.find(Club.class, clubId);
		
		if (club == null) {
			throw NamooExceptionFactory.createRuntime("클럽이 존재하지 않습니다.");
		}
		
		SocialPerson towner = em.find(SocialPerson.class, email);
		if (towner == null) {
			throw NamooExceptionFactory.createRuntime("존재하지 않는 주민입니다.");
		}
		
		club.addMember(towner);
		em.store(club);
		
	}

	@Override
	public List<Club> findAllClubs() {
		// 
		return em.findAll(Club.class);
	}

	@Override
	public Club findClub(String clubId) {
		// 
		return em.find(Club.class, clubId);
	}

	@Override
	public ClubMember findClubMember(String clubId, String email) {
		// 
		Club club = em.find(Club.class, clubId);
		
		if (club == null) {
			throw NamooExceptionFactory.createRuntime("클럽이 존재하지 않습니다.");
		}
		
		for (ClubMember member : club.getMembers()) {
			if (member.getEmail().equals(email)) {
				return member;
			}
		}
		return null;
	}

	@Override
	public List<ClubMember> findAllClubMember(String clubId) {
		// 
		Club club = em.find(Club.class, clubId);
		
		if (club == null) {
			throw NamooExceptionFactory.createRuntime("클럽이 존재하지 않습니다.");
		}
		return club.getMembers();
	}

	@Override
	public int countMembers(String clubId) {
		// 
		Club club = em.find(Club.class, clubId);
		if (club != null) {
			return club.getMembers().size();
		}
		return 0;
	}

	@Override
	public void removeClub(String clubId) {
		// 
		em.remove(Club.class, clubId);
		
	}

	@Override
	public List<Club> findBelongClub(String email) {
		// 
		List<Club> clubs = em.findAll(Club.class);
		if (clubs == null) return null;
		
		List<Club> belongs = new ArrayList<>();
		for (Club club : clubs) {
			if (club.findMember(email) != null) {
				belongs.add(club);
			}
		}
		return belongs;
	}

	@Override
	public List<Club> findManagedClubs(String email) {
		// 
		List<Club> clubs = em.findAll(Club.class);
		if (clubs == null) return null;
		
		List<Club> manages = new ArrayList<>();
		for (Club club : clubs) {
			if (club.getManager().getEmail().equals(email)) {
				manages.add(club);
			}
		}
		return manages;
	}
	@Override
	public List<Club> findClubById(String communityId) {
		// 
		List<Club> clubs = em.findAll(Club.class);
		if(clubs == null) return null;
		
		List<Club> belongedClub = new ArrayList<>();
		for (Club club : clubs) {
			if(club.getCommunityId().equals(communityId)) {
				belongedClub.add(club);
			}
		}
		
		return belongedClub;
	}

	@Override
	public void withdrawalClub(String clubId, String email) {
		//
		Club club = em.find(Club.class, clubId);
		if (club == null) {
			throw NamooExceptionFactory.createRuntime("클럽이 존재하지 않습니다.");
		}
		
		if(email.equals(club.getManager().getEmail())) {
			throw new RuntimeException("관리자는 탈퇴할 수 없습니다.");
		}
		
		club.removeMember(email);
		em.store(club);
		
	}


}
