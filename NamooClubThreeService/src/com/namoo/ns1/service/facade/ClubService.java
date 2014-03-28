package com.namoo.ns1.service.facade;

import java.util.List;

import com.namoo.ns1.service.logic.exception.NamooRuntimeException;

import dom.entity.Club;
import dom.entity.ClubMember;

public interface ClubService {
	
	/**
	 * [주민으로 등록된 경우] 클럽 개설
	 * 
	 * 이미 주민으로 가입되어 있는 경우 이메일만 필요하다.
	 * 존재하지 않는 주민인 경우 예외가 발생한다. 
	 * 
	 * @param clubName
	 * @param description
	 * @param email
	 * 
	 * @throws NamooRuntimeException
	 */
	public void registClub(String communityId, String clubName, String description, String email);
	
	/**
	 * [주민으로 등록된 경우] 클럽 가입
	 * 
	 * 이미 주민으로 가입되어 있는 경우 이메일만 필요하다.
	 * 존재하지 않는 주민인 경우 예외가 발생한다. 
	 * 
	 * @param clubName
	 * @param email
	 * 
	 * @throws NamooRuntimeException
	 */
	public void joinAsMember( String clubId, String email);
	
	/**
	 * 전체 클럽 리스트
	 * @return
	 */
	public List<Club> findAllClubs();
	
	/**
	 * [클럽 찾기]
	 * 클럽 아이디를 이용하여 클럽을 찾는다.
	 * @param clubId
	 */
	public Club findClub( String clubId);
	/**
	 * 커뮤니티에 속한 클럽리스트 조회
	 * @param communityId
	 * @return
	 */
	public List<Club> findClubById(String communityId);
	
	/**
	 * 이메일로 클럽 회원 찾기
	 * 
	 * @param clubName
	 * @param email
	 * @return
	 */
	public ClubMember findClubMember( String clubId, String email);
	
	/**
	 * 클럽 회원목록 조회
	 * 
	 * @param clubId
	 * @return
	 */
	public List<ClubMember> findAllClubMember( String clubId);
	/**
	 * 클럽 회원수
	 * @param clubId
	 */
	public int countMembers( String clubId);
	/**
	 * 클럽 삭제
	 * @param clubId
	 */
	public void removeClub( String clubId);
	/**
	 * 자신이 회원으로 있는 클럽 목록조회
	 * 
	 * @param email
	 * @return
	 */
	public List<Club> findBelongClub( String email);
	
	/**
	 * 자신이 관리하는 클럽 목록조회
	 * 
	 * @param email
	 * @return
	 */
	public List<Club> findManagedClubs(String email);

	/**
	 * 클럽에서 탈퇴하기
	 * 
	 * @param clubId
	 * @param email
	 */
	public void withdrawalClub( String clubId, String email);
}
