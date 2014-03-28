package dom.entity;

import com.namoo.ns1.common.Identifiable;

public class ClubMember implements Identifiable{

	private static final long serialVersionUID = -215982221160418599L;
	
	private String clubName;
	private SocialPerson rolePerson;

	//--------------------------------------------------------------------------
	// constructor
	public ClubMember(String clubName, SocialPerson rolePerson) {
		// 
		this.clubName = clubName;
		this.rolePerson = rolePerson;
	}
	
	//--------------------------------------------------------------------------
	// getter/setter
	
	public String getName() {
		return rolePerson.getName();
	}
	
	public String getEmail() {
		return rolePerson.getEmail();
	}
	
	@Override
	public String getOId() {
		// 
		return clubName+"|"+rolePerson.getEmail();
	}

}
