/**
* This is Relationship class.
*
* @version 1.00 15 March 2018
* @author Tianyu Tan(Terry)
*/
public class Relationship {
	private String Id;
	private String FirstPersonNameId;
	private String SecondPersonNameId;
	private String Relationship;
	
	public Relationship(String firstPersonNameId, String secondPersonNameId, String relationship) {
		FirstPersonNameId = firstPersonNameId;
		SecondPersonNameId = secondPersonNameId;
		Relationship = relationship;
	}
	
	public Relationship() {}

	public String getFirstPersonNameId() {
		return FirstPersonNameId;
	}

	public void setFirstPersonNameId(String firstPersonNameId) {
		FirstPersonNameId = firstPersonNameId;
	}

	public String getSecondPersonNameId() {
		return SecondPersonNameId;
	}

	public void setSecondPersonNameId(String secondPersonNameId) {
		SecondPersonNameId = secondPersonNameId;
	}

	public String getRelationship() {
		return Relationship;
	}

	public void setRelationship(String relationship) {
		Relationship = relationship;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}
	
	public String Print() 
	{
		Repository r = new Repository();
		Person p1 = r.GetPersonById(FirstPersonNameId);
		Person p2 = r.GetPersonById(SecondPersonNameId);
		return p1.getName() + ", " + p2.getName() + ", " + Relationship;
	}
		
}
