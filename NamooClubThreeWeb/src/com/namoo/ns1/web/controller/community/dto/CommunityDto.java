package com.namoo.ns1.web.controller.community.dto;

import java.util.Date;

import dom.entity.Community;

public class CommunityDto {
	//
	private boolean managed;
	private Community community;
	private int memberCount;
	private int clubCount;
	
	public CommunityDto (Community community, String userId) {
		//
		this.community = community;
		this.managed = managed(userId);
		this.memberCount = community.getMembers().size();
		this.clubCount = community.getClubs().size();

	}
	
	public int getClubCount() {
		return clubCount;
	}

	public void setClubCount(int clubCount) {
		this.clubCount = clubCount;
	}

	public boolean isManaged() {
		return managed;
	}

	public void setManaged(boolean managed) {
		this.managed = managed;
	}

	public Community getCommunity() {
		return community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}

	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}
	
	public Date getOpenDate() {
		return community.getOpenDate();
	}
	
	public String getManagerName() {
		return community.getManager().getName();
	}
	
	public String getCommunityId() {
		return community.getId();
	}
	
	public String getName() {
		return community.getName();
	}
	public String getDescription() {
		return community.getDescription();
	}

	private boolean managed(String userId) {
		// 
		if(userId.equals(community.getManager().getEmail())) {
			return managed = true;
		}
		return managed = false;
	}
}
