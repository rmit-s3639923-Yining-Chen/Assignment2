/**
* This is Person class 
*
* @version 1.00 21 May 2018
* @author Yining Chen
*/
public class Person {
	private String Id;
	private String Name;
	private int Age;
	private String Status;
	private String Gender;
	private String State;
	
	public Person(String name, int age, String status, String gender, String state) {
		Name = name;
		Age = age;
		Status = status;
		Gender = gender;
		State = state;
	}
	
	public Person() {}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}
	
	public String Print() 
	{
		return Name + ", " + Status + ", " + Gender + ", " + Age + ", " + State;
	}
	
}
