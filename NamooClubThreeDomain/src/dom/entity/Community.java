package dom.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.namoo.ns1.common.Identifiable;

public class Community implements Identifiable {

	private static final long serialVersionUID = -1649818789572216203L;
	
	private String name;
	private String description;
	private String id;
	private Date openDate;

	private CommunityManager manager;
	private List<CommunityMember> members;
	private List<Club> clubs;

	//--------------------------------------------------------------------------
	// constructors
	
	/**
	 * 
	 * @param communityName
	 * @param admin
	 */
	public Community(String communityName, String description, SocialPerson admin, String id){
		//
		this.name = communityName;
		this.description = description;
		this.openDate = new Date();
		this.members = new ArrayList<CommunityMember>();
		this.id = id;
		
		this.clubs = new ArrayList<Club>();
		
		setManager(admin);
		addMember(admin);
	}

	//--------------------------------------------------------------------------
	// getter/setter
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CommunityManager getManager() {
		return manager;
	}
	/**
	 * 
	 * @param rolePerson
	 */
	public void setManager(SocialPerson rolePerson){
		//
		CommunityManager manager = new CommunityManager(name, rolePerson);
		this.manager = manager;
	}

	public List<CommunityMember> getMembers() {
		return members;
	}
	
	public List<Club> getClubs() {
		return clubs;
	}

	//--------------------------------------------------------------------------
	// public methods
	
	public CommunityMember findMember(String email) {
		//
		for (CommunityMember member : members) {
			if(member.getEmail().equals(email)) {
				return member;
			};
		}
		return null;
	}
	

	/**
	 * 
	 * @param rolePerson
	 */
	public void addMember(SocialPerson rolePerson){
		//
		CommunityMember member = new CommunityMember(name, rolePerson);
		this.members.add(member);
	}
	
	public void addClub(Club club) {
		//
		this.clubs.add(club);
	}

	@Override
	public String getOId() {
		// 
		return id;
	}

	public void removeMember(String email) {
		// 
		CommunityMember found = null;
		for (CommunityMember member : members) {
			if (member.getEmail().equals(email)) {
				found = member;
			}
		}
		if (found != null) {
			members.remove(found);
		}
	}
}