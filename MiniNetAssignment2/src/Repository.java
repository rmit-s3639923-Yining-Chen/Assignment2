import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Repository {
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
			connection = DriverManager.getConnection(Hosting,Username,Password);  
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public ResultSet ExecuteQuery(String query) 
	{
		try
		{
			Statement stmt= connection.createStatement();   
			return stmt.executeQuery(query);  
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}	
	}
	
	public void Execute(String query) 
	{
		String person = "CREATE TABLE IF NOT EXISTS `Person` (\r\n" + 
				"  `Id` varchar(128) NOT NULL,\r\n" + 
				"  `Name` varchar(128) NOT NULL,\r\n" + 
				"	`Age` int(3) NOT NULL,\r\n" + 
				"	`Status` varchar(128) NOT NULL,\r\n" + 
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
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return p;
	}
	
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
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return p;
	}
	
	public void InserPerson(Person person) 
	{
		person.setId(java.util.UUID.randomUUID().toString());
		String insertPerson = "INSERT INTO person (Id, Name, Age, Status)\r\n" + 
				"VALUES ('" + person.getId() 
				+ "', '" + person.getName()
				+ "', '" + person.getAge()
				+ "','" + person.getStatus()
				+ "');";
		Execute(insertPerson);
	}
	
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
				persons.add(p);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return persons;
	}
	
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
	
	public void ClearDatabase()
	{
		String delete = "DELETE FROM Person\r\n" + 
				"WHERE Id IS NOT NULL";
		Execute(delete);
		 delete = "DELETE FROM Relationship\r\n" + 
					"WHERE Id IS NOT NULL";
		 Execute(delete);
	}
	
	public void AddTestData()
	{
		ClearDatabase();
		Person p1 = new Person("Cart",21,"Studing in RMIT");
		Person p2 = new Person("Terry",25,"Studing in RMIT");
		Person p3 = new Person("Tonny",15,"Studing");
		Person p4 = new Person("Lucy",14,"Studing in high shcool");
		Person p5 = new Person("Mao",8,"Studing in primary shcool");
		InserPerson(p1);
		InserPerson(p2);
		InserPerson(p3);
		InserPerson(p4);
		InserPerson(p5);
		InserRelationship(new Relationship(p1.getId(),p2.getId(),"Friend"));
	}
	
}
