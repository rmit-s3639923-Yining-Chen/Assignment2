/**
* This is NotBeClassmatesException class 
*
* @version 1.00 13 May 2018
* @author Yining Chen & Tianyu Tan
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Repository {
	//connecting string 
	private String Hosting = "jdbc:mysql://localhost:3306/MiniNet" 
            + "?verifyServerCertificate=false"
            + "&useSSL=false"
            + "&requireSSL=false";;
	private String Username = "root";
	private String Password = "";
	private Connection connection;
	
	public Repository() 
	{
		try
		{
			//System.setProperty("jdbc.drivers", "sun.jdbc.odbc.JdbcOdbcDriver");
			//create a instance connection
			connection = DriverManager.getConnection(Hosting,Username,Password);  
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	//ExcuteQuery with return value
	public ResultSet ExecuteQuery(String query) 
	{
		try
		{
			String person = "CREATE TABLE IF NOT EXISTS `Person` (\r\n" + 
					"  `Id` varchar(128) NOT NULL,\r\n" + 
					"  `Name` varchar(128) NOT NULL,\r\n" + 
					"	`Age` int(3) NOT NULL,\r\n" + 
					"	`Status` varchar(128) NOT NULL,\r\n" + 
					"	`Gender` varchar(128) NOT NULL,\r\n" + 
					"	`State` varchar(128) NOT NULL,\r\n" + 
					"  PRIMARY KEY (`Id`)\r\n" + 
					");";
			String relationship = "CREATE TABLE IF NOT EXISTS `Relationship` (\r\n" + 
					"	`Id` varchar(128) NOT NULL PRIMARY KEY,\r\n" + 
					"	`FirstPersonNameId` varchar(128) NOT NULL,\r\n" + 
					"	`SecondPersonNameId` varchar(128) NOT NULL,\r\n" + 
					"	`Relationship` varchar(128) NOT NULL,\r\n" + 
					"	FOREIGN KEY (`FirstPersonNameId`) REFERENCES `Person`(`Id`),\r\n" + 
					"	FOREIGN KEY (`SecondPersonNameId`) REFERENCES `Person`(`Id`)\r\n" + 
					");";
			
			Statement stmt= connection.createStatement();  
			stmt.execute(person); 
			stmt.execute(relationship); 
			return stmt.executeQuery(query);  
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}	
	}
	
	//ExcuteQuery without return value
	public void Execute(String query) 
	{
		String person = "CREATE TABLE IF NOT EXISTS `Person` (\r\n" + 
				"  `Id` varchar(128) NOT NULL,\r\n" + 
				"  `Name` varchar(128) NOT NULL,\r\n" + 
				"	`Age` int(3) NOT NULL,\r\n" + 
				"	`Status` varchar(128) NOT NULL,\r\n" + 
				"	`Gender` varchar(128) NOT NULL,\r\n" + 
				"	`State` varchar(128) NOT NULL,\r\n" + 
				"  PRIMARY KEY (`Id`)\r\n" + 
				");";
		String relationship = "CREATE TABLE IF NOT EXISTS `Relationship` (\r\n" + 
				"	`Id` varchar(128) NOT NULL PRIMARY KEY,\r\n" + 
				"	`FirstPersonNameId` varchar(128) NOT NULL,\r\n" + 
				"	`SecondPersonNameId` varchar(128) NOT NULL,\r\n" + 
				"	`Relationship` varchar(128) NOT NULL,\r\n" + 
				"	FOREIGN KEY (`FirstPersonNameId`) REFERENCES `Person`(`Id`),\r\n" + 
				"	FOREIGN KEY (`SecondPersonNameId`) REFERENCES `Person`(`Id`)\r\n" + 
				");";
		try
		{
			//if table is not EXISTS, create table
			Statement stmt= connection.createStatement();  
			stmt.execute(person); 
			stmt.execute(relationship); 
			stmt.execute(query);  
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}	
	}
	
	//get person details by Id
	public Person GetPersonById(String id) 
	{
		String getPersonById = "Select * From Person Where Id = '" + id + "';";
		ResultSet result = ExecuteQuery(getPersonById);
		Person p = new Person();
		try
		{
			while(result.next())  
			{
				p.setId(result.getString(1));
				p.setName(result.getString(2));
				p.setAge(result.getInt(3));
				p.setStatus(result.getString(4));
				p.setGender(result.getString(5));
				p.setState(result.getString(6));
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return p;
	}
	
	//get person details by name
	public Person GetPersonByName(String name) 
	{
		String getPersonById = "Select * From Person Where Name = '" + name + "';";
		ResultSet result = ExecuteQuery(getPersonById);
		Person p = new Person();
		try
		{
			while(result.next())  
			{
				p.setId(result.getString(1));
				p.setName(result.getString(2));
				p.setAge(result.getInt(3));
				p.setStatus(result.getString(4));
				p.setGender(result.getString(5));
				p.setState(result.getString(6));
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return p;
	}
	
	
	//Add a person to database
	public void InserPerson(Person person) 
	{
		person.setId(java.util.UUID.randomUUID().toString());
		String insertPerson = "INSERT INTO person (Id, Name, Age, Status, Gender, State)\r\n" + 
				"VALUES ('" + person.getId() 
				+ "', '" + person.getName()
				+ "', '" + person.getAge()
				+ "','" + person.getStatus()
				+ "', '" + person.getGender()
				+ "','" + person.getState()
				+ "');";
		Execute(insertPerson);
	}
	
	//add a relationship to database
	public void InserRelationship(Relationship relationship) 
	{
		relationship.setId(java.util.UUID.randomUUID().toString());
		String insertRelationship = "INSERT INTO relationship (Id, FirstPersonNameId , SecondPersonNameId , Relationship)\r\n" + 
				"VALUES ('" + relationship.getId() 
				+ "', '" + relationship.getFirstPersonNameId()
				+ "', '" + relationship.getSecondPersonNameId()
				+ "','" + relationship.getRelationship()
				+ "');";
		Execute(insertRelationship);
	}
	
	//get all the persons 
	public ArrayList<Person> GetPersons()
	{
		ArrayList<Person> persons = new ArrayList<Person>();
		String getPerson = "Select * From Person;";
		ResultSet result = ExecuteQuery(getPerson);
		try
		{
			while(result.next())  
			{
				Person p = new Person();
				p.setId(result.getString(1));
				p.setName(result.getString(2));
				p.setAge(result.getInt(3));
				p.setStatus(result.getString(4));
				p.setGender(result.getString(5));
				p.setState(result.getString(6));
				persons.add(p);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return persons;
	}
	
	public String GetRelationship(String Name1,String Name2) 
	{
		Repository r = new Repository();
		Person p1 = r.GetPersonByName(Name1);
		Person p2 = r.GetPersonByName(Name2);
		String result = "";
		System.out.println(result + "1");
		if(p1.getId() != null && p2.getId() != null) 
		{
			String P1Id = p1.getId();
			String P2Id = p2.getId();
			String getRelationship = "Select * From Relationship "
					+ "Where FirstPersonNameId = '" + P1Id + "' and SecondPersonNameId = '" + P2Id + "';";
			String getRelationship2 = "Select * From Relationship "
					+ "Where FirstPersonNameId = '" + P2Id + "' and SecondPersonNameId = '" + P1Id + "';";
			ResultSet result1 = ExecuteQuery(getRelationship);
			ResultSet result2 = ExecuteQuery(getRelationship2);
			try
			{
				while(result1.next())  
				{
					result  = result1.getString(4);
				}
				
				while(result2.next())  
				{
					result  = result2.getString(4);
				}
				if(result.equals("")) 
				{
					result = "No relationship!";
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				result = "No relationship!";
			}
		}
		else
		{
			result = "Person no found!";
		}
		
		return result;
	}
	
	//get all the relationships
	public ArrayList<Relationship> GetRelationships()
	{
		ArrayList<Relationship> relationships = new ArrayList<Relationship>();
		String getRelationship = "Select * From Relationship;";
		ResultSet result = ExecuteQuery(getRelationship);
		try
		{
			while(result.next())  
			{
				Relationship relationship = new Relationship();
				relationship.setId(result.getString(1));
				relationship.setFirstPersonNameId(result.getString(2));
				relationship.setSecondPersonNameId(result.getString(3));
				relationship.setRelationship(result.getString(4));
				relationships.add(relationship);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return relationships;
	}
	
	//clear the records in person and relationship table
	public void ClearDatabase()
	{
		String delete = "DELETE FROM Person\r\n" + 
				"WHERE Id IS NOT NULL";
		Execute(delete);
		 delete = "DELETE FROM Relationship\r\n" + 
					"WHERE Id IS NOT NULL";
		 Execute(delete);
	}
	
	//add the test data
	public void AddTestData()
	{
		ClearDatabase();
		Person p1 = new Person("Cart",21,"Studing in RMIT","M","VIC");
		Person p2 = new Person("Terry",25,"Studing in RMIT","M","VIC");
		Person p3 = new Person("Tonny",15,"Studing","M","VIC");
		Person p4 = new Person("Lucy",14,"Studing in high shcool","F","VIC");
		Person p5 = new Person("Mao",8,"Studing in primary shcool","M","VIC");
		InserPerson(p1);
		InserPerson(p2);
		InserPerson(p3);
		InserPerson(p4);
		InserPerson(p5);
		InserRelationship(new Relationship(p1.getId(),p2.getId(),"Friends"));
	}
	
}
