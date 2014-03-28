package com.namoo.ns1.web.controller.club.dto;

import java.util.Date;

import dom.entity.Club;


public class ClubDto {
//원래 클럽객체랑
//가입된정보를 이용해서 비교해서\
	private boolean belong;
	private boolean managed;
	private Club club;
	private int memberCount;

	
	public ClubDto(Club club,  String userId) {
		this.club=club;
		this.belong = belong(userId);
		this.managed = managed(userId);
		this.memberCount=club.getMembers().size();
	}


	public int getMemberCount() {
		return memberCount;
	}


	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}


	public boolean isManaged() {
		return managed;
	}


	public void setManaged(boolean managed) {
		this.managed = managed;
	}


	public boolean isBelong() {
		return belong;
	}


	public void setBelong(boolean belong) {
		this.belong = belong;
	}


	public Club getClub() {
		return club;
	}


	public void setClub(Club club) {
		this.club = club;
	}

	public Date getOpenDate() {
		return club.getOpenDate();
	}
	
	public String getClubName() {
		return club.getName();
	}
	
	public String getDescription() {
		return club.getDescription();
	}
	
	public String getId() {
		return club.getId();
	}
	
	
	private boolean belong(String userId) {
		// 
		if(club.findMember(userId) != null) {
			return belong = true;
		}
		return belong = false;
	}
	
	private boolean managed(String userId) {
		//
		if(userId.equals(club.getManager().getEmail())) {
			return managed = true;
		}
		return managed = false;
	}
}
