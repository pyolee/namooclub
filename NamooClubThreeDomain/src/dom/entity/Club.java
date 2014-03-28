package dom.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.namoo.ns1.common.Identifiable;

public class Club implements Identifiable {

	private static final long serialVersionUID = -9203553406578338655L;
	
	private String name;
	private String description;
	private String id;
	private String communityId;
	private Date openDate;
	
	private ClubManager manager;
	private List<ClubMember> members;

	//--------------------------------------------------------------------------
	// constructors
	
	public Club (String clubName, String description, SocialPerson admin, String id, String communityId) {
		//
		this.name = clubName;
		this.description=description;
		this.openDate = new Date();
		this.members = new ArrayList<ClubMember>();
		this.id = id;
		this.communityId = communityId;
		
		setManager(admin);
		addMember(admin);
	}
	
	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public String getCommunityId() {
		return communityId;
	}

	@Override
	public String getOId() {
		// 
		return id;
	}
	//--------------------------------------------------------------------------
	// getter/setter
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ClubManager getManager() {
		return manager;
	}

	public void setManager(SocialPerson rolePerson) {
		//
		ClubManager manager = new ClubManager(name, rolePerson);
		this.manager = manager;
	}

	public String getId() {
		return id;
	}

	public List<ClubMember> getMembers() {
		return members;
	}
	
	//--------------------------------------------------------------------------
	// public methods
	
	public ClubMember findMember (String email) {
		//
		for (ClubMember member : members) {
			if(member.getEmail().equals(email)) {
				return member;
			};
		}
		return null;
	}
	
	public void addMember(SocialPerson rolePerson){
		//
		ClubMember member = new ClubMember(name, rolePerson);
		this.members.add(member);
	}
	
	public void removeMember(String email) {
		// 
		ClubMember found = null;
		for (ClubMember member : members) {
			if (member.getEmail().equals(email)) {
				found = member;
			}
		}
		if (found != null) {
			members.remove(found);
		}
	}

}
