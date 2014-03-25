package com.namoo.ns1.service.logic;
import java.util.ArrayList;
import java.util.List;

import com.namoo.ns1.data.EntityManager;
import com.namoo.ns1.service.facade.CommunityService;
import com.namoo.ns1.service.logic.exception.NamooExceptionFactory;

import dom.entity.Community;
import dom.entity.CommunityMember;
import dom.entity.SocialPerson;

public class CommunityServiceLogic implements CommunityService {

	private EntityManager em;
	
	public CommunityServiceLogic() {
		//
		em = EntityManager.getInstance();
	}
	
	@Override
	@Deprecated
	public void registCommunity(String communityName, String adminName, String email, String password){
		//
		SocialPerson admin = createPerson(adminName, email, password);
		Community community = new Community(communityName, "", admin);
		
		em.store(community);
	}

	@Override
	public void registCommunity(String communityName, String description, String adminName, String email, String password) {
		//
		if (em.find(Community.class, communityName) != null) {
			throw NamooExceptionFactory.createRuntime("이미 존재하는 커뮤니티입니다.");
		}
		
		if (em.find(SocialPerson.class, email) != null) {
			throw NamooExceptionFactory.createRuntime("해당 주민이 이미 존재합니다.");
		}

		SocialPerson admin = createPerson(adminName, email, password);
		Community community = new Community(communityName, description, admin);
		
		em.store(community);
	}

	@Override
	public void registCommunity(String communityName, String description, String email) {
		//
		if (em.find(Community.class, communityName) != null) {
			throw NamooExceptionFactory.createRuntime("이미 존재하는 커뮤니티입니다.");
		}
		
		SocialPerson towner = em.find(SocialPerson.class, email);
		if (towner == null) {
			throw NamooExceptionFactory.createRuntime("존재하지 않는 주민입니다.");
		}
		
		Community community = new Community(communityName, description, towner);
		em.store(community);
	}

	private SocialPerson createPerson(String name, String email, String password) {
		// 
		SocialPerson person = new SocialPerson(name, email, password);
		em.store(person);
		
		return person;
	}

	@Override
	public Community findCommunity(String communityName){
		//
		return em.find(Community.class, communityName);
	}

	@Override
	public void joinAsMember(String communityName, String name, String email, String password){
		//
		Community community = em.find(Community.class, communityName);
		
		if (community == null) {
			throw NamooExceptionFactory.createRuntime("커뮤니티가 존재하지 않습니다.");
		}
	
		if (em.find(SocialPerson.class, email) != null) {
			throw NamooExceptionFactory.createRuntime("해당 주민이 이미 존재합니다.");
		}
		
		SocialPerson towner = createPerson(name, email, password);
		community.addMember(towner);
		
		em.store(community);
	}

	@Override
	public void joinAsMember(String communityName, String email) {
		// 
		Community community = em.find(Community.class, communityName);
		
		if (community == null) {
			throw NamooExceptionFactory.createRuntime("커뮤니티가 존재하지 않습니다.");
		}
		
		SocialPerson towner = em.find(SocialPerson.class, email);
		if (towner == null) {
			throw NamooExceptionFactory.createRuntime("존재하지 않는 주민입니다.");
		}
		
		community.addMember(towner);
		em.store(community);
	}

	@Override
	public CommunityMember findCommunityMember(String communityName, String email) {
		// 
		Community community = em.find(Community.class, communityName);
		
		if (community == null) {
			throw NamooExceptionFactory.createRuntime("커뮤니티가 존재하지 않습니다.");
		}
		
		for (CommunityMember member : community.getMembers()) {
			if (member.getEmail().equals(email)) {
				return member;
			}
		}
		
		return null;
	}

	@Override
	public List<CommunityMember> findAllCommunityMember(String communityName) {
		// 
		Community community = em.find(Community.class, communityName);
		
		if (community == null) {
			throw NamooExceptionFactory.createRuntime("커뮤니티가 존재하지 않습니다.");
		}
		return community.getMembers();
	}

	@Override
	public int countMembers(String communityName){
		//
		Community community = em.find(Community.class, communityName);
		if (community != null) {
			return community.getMembers().size();
		}
		
		return 0;
	}

	@Override
	public void removeCommunity(String communityName) {
		// 
		em.remove(Community.class, communityName);
	}

	@Override
	public List<Community> findAllCommunities() {
		// 
		return em.findAll(Community.class);
	}

	@Override
	public List<Community> findBelongCommunities(String email) {
		// 
		List<Community> commnities = em.findAll(Community.class);
		if (commnities == null) return null;
		
		List<Community> belongs = new ArrayList<>();
		for (Community community : commnities) {
			if (community.findMember(email) != null) {
				belongs.add(community);
			}
		}
		return belongs;
	}

	@Override
	public List<Community> findManagedCommnities(String email) {
		// 
		List<Community> commnities = em.findAll(Community.class);
		if (commnities == null) return null;
		
		List<Community> manages = new ArrayList<>();
		for (Community community : commnities) {
			if (community.getManager().getEmail().equals(email)) {
				manages.add(community);
			}
		}
		return manages;
	}

	@Override
	public void withdrawalCommunity(String communityName, String email) {
		//
		Community community = em.find(Community.class, communityName);
		if (community == null) {
			throw NamooExceptionFactory.createRuntime("커뮤니티가 존재하지 않습니다.");
		}
		
		community.removeMember(email);
		em.store(community);
	}
}