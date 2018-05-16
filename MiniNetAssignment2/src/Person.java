/**
* This is Person class 
*
* @version 1.00 15 March 2018
* @author Yining Chen
*/
public class Person {
	private String Id;
	private String Name;
	private int Age;
	private String Status;
	
	public Person(String name, int age, String status) {
		Name = name;
		Age = age;
		Status = status;
	}
	
	public Person() {}

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
		return Name + ", " + Age + ", " + Status;
	}
	
}
