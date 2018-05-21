/**
* This is Gui class 
*
* @version 1.00 16 May 2018
* @author Yining Chen & Tianyu Tan
*/
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

//all the elements in GUI are generated by WindowBuilder of Java Pack

public class Mininet {

	//main window menu
	private JFrame frame;
	//person name
	private JTextField textFieldName;
	//person age
	private JTextField textFieldAge;
	//person status
	private JTextField textFieldStatus;
	//person's mother name
	private JTextField textFieldMother;
	//person's father name
	private JTextField textFieldFather;
	//add relationship person 1 name
	private JTextField textFieldPerson1Name;
	//add relationship person 2 name
	private JTextField textFieldPerson2Name;
	private JTextField textFieldPersonDetails;
	private JComboBox comboBoxListPerson = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mininet window = new Mininet();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mininet() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//main frame window
		frame = new JFrame();
		frame.setBounds(100, 100, 1346, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//panel 1 
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		//label for person name
		JLabel lblName = new JLabel("Name");
		panel.add(lblName);
		
		//TextField for person name
		textFieldName = new JTextField();
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		//label for person Status
		JLabel lblStatus = new JLabel("Status");
		panel.add(lblStatus);
		
		//text for person Status
		textFieldStatus = new JTextField();
		panel.add(textFieldStatus);
		textFieldStatus.setColumns(10);
		
		//label for person Gender
		JLabel lblGender = new JLabel("Gender");
		panel.add(lblGender);
		
		//JComboBox for person Gender
		JComboBox comboBoxGender = new JComboBox();
		comboBoxGender.addItem("M");
		comboBoxGender.addItem("F");
		comboBoxGender.addItem("Other");
		panel.add(comboBoxGender);
		
		//label for person age
		JLabel lblAge = new JLabel("Age");
		panel.add(lblAge);
		
		//text field for person age
		textFieldAge = new JTextField();
		panel.add(textFieldAge);
		textFieldAge.setColumns(10);
		
		JComboBox comboBoxStates = new JComboBox();
		comboBoxStates.addItem("ACT");
		comboBoxStates.addItem("NSW");
		comboBoxStates.addItem("NT");
		comboBoxStates.addItem("QLD");
		comboBoxStates.addItem("SA");
		comboBoxStates.addItem("TAS");
		comboBoxStates.addItem("VIC");
		comboBoxStates.addItem("WA");
		panel.add(comboBoxStates);
		
		//label for person mother name
		JLabel lblMother = new JLabel("Mother");
		panel.add(lblMother);
		
		//text field for person mother name
		textFieldMother = new JTextField();
		panel.add(textFieldMother);
		textFieldMother.setColumns(10);
		
		//label for person father name
		JLabel lblFather = new JLabel("Father");
		panel.add(lblFather);
		
		//text field for person father name
		textFieldFather = new JTextField();
		panel.add(textFieldFather);
		textFieldFather.setColumns(10);
		
		//add person button
		JButton btnAddPerson = new JButton("Add Person");
		panel.add(btnAddPerson);
		
		//add person exception label
		JLabel lblAddpersonexception = new JLabel("*");
		panel.add(lblAddpersonexception);
		
		//panel 2 for display persons and relationships
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		//text area for displaying persons and relationships
		JTextArea textFieldPersons = new JTextArea();
		textFieldPersons.setEditable(false);
		textFieldPersons.setLineWrap(true);
		textFieldPersons.setWrapStyleWord(true);
		textFieldPersons.setRows(10);
		textFieldPersons.setColumns(30);
		panel_1.add(textFieldPersons);
		
		//list person
		JButton btnListpersons = new JButton("ListPersons");
		panel_1.add(btnListpersons);
		
		//list relationships
		JButton btnListRelationship = new JButton("List Relationship");
		panel_1.add(btnListRelationship);
		
		//clear records
		JButton btnClearDatabase = new JButton("Clear Database");
		panel_1.add(btnClearDatabase);
		
		//add test data
		JButton btnAddtestdata = new JButton("AddTestData");
		panel_1.add(btnAddtestdata);
		
		Repository r = new Repository();
		ArrayList<Person> persons = r.GetPersons();
		for(int i = 0; i< persons.size();i++) 
		{
			comboBoxListPerson.addItem(persons.get(i).getName());
		}
		panel_1.add(comboBoxListPerson);
		
		JButton btnSelectPerson = new JButton("SelectPerson");
		panel_1.add(btnSelectPerson);
		
		textFieldPersonDetails = new JTextField();
		panel_1.add(textFieldPersonDetails);
		textFieldPersonDetails.setColumns(25);
		
		//panel 3 (center)
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		
		//add person 1 label 
		JLabel lblPerson = new JLabel("Person1");
		panel_2.add(lblPerson);
		
		//person 1 name text field
		textFieldPerson1Name = new JTextField();
		panel_2.add(textFieldPerson1Name);
		textFieldPerson1Name.setColumns(10);
		
		//add person 2 label 
		JLabel lblPerson_1 = new JLabel("Person2");
		panel_2.add(lblPerson_1);
		
		////add person 2 name text field
		textFieldPerson2Name = new JTextField();
		panel_2.add(textFieldPerson2Name);
		textFieldPerson2Name.setColumns(10);
		
		//relationship label
		JLabel lblRelationship = new JLabel("Relationship");
		panel_2.add(lblRelationship);
		
		JComboBox comboBoxChooseRelationship = new JComboBox();
		comboBoxChooseRelationship.addItem("Friends");
		comboBoxChooseRelationship.addItem("Couple");
		comboBoxChooseRelationship.addItem("Parent");
		comboBoxChooseRelationship.addItem("Colleagues");
		comboBoxChooseRelationship.addItem("Other");
		panel_2.add(comboBoxChooseRelationship);
		
		//add relationship button
		JButton btnAddRelationship = new JButton("Add Relationship");
		panel_2.add(btnAddRelationship);
		
		JButton btnDisplayRelationship = new JButton("Display Relationship");
		panel_2.add(btnDisplayRelationship);
		
		//label for add relationship exception
		JLabel lblAddRelationshipException = new JLabel("*");
		panel_2.add(lblAddRelationshipException);
		
		
		
		//add person button event
		btnAddPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Repository r = new Repository();
				try {
					Person p = new Person();
					if(Integer.parseInt(textFieldAge.getText()) > 150) 
					{
						lblAddpersonexception.setText("Age is over 150!");
					}else 
					{
						if(Integer.parseInt(textFieldAge.getText()) > 16) 
						{
							p.setName(textFieldName.getText());
							p.setAge(Integer.parseInt(textFieldAge.getText()));
							p.setStatus(textFieldStatus.getText());
							p.setGender(comboBoxGender.getSelectedItem().toString());
							p.setState(comboBoxStates.getSelectedItem().toString());
							r.InserPerson(p);
							lblAddpersonexception.setText("Add " + p.getName() + " Successful!");
						}
						else 
						{
							Person father = r.GetPersonByName(textFieldFather.getText());
							Person mother = r.GetPersonByName(textFieldMother.getText());
							if(father.getId() != null && mother.getId() != null) 
							{
								try 
								{
									p.setName(textFieldName.getText());
									p.setAge(Integer.parseInt(textFieldAge.getText()));
									p.setStatus(textFieldStatus.getText());
									r.InserPerson(p);
									lblAddpersonexception.setText("Add " + p.getName() + " Successful!");
									r.InserRelationship(new Relationship(p.getId(),father.getId(),"Parent"));
									r.InserRelationship(new Relationship(p.getId(),mother.getId(),"Parent"));
									lblAddpersonexception.setText("Add " + p.getName() + " Successfully!");
								}
								catch(Exception ex) 
								{
									lblAddpersonexception.setText("Information error, check input!");
								}
								p.setName(textFieldName.getText());
								p.setAge(Integer.parseInt(textFieldAge.getText()));
								p.setStatus(textFieldStatus.getText());
								r.InserPerson(p);
								lblAddpersonexception.setText("Add " + p.getName() + " Successful!");
								r.InserRelationship(new Relationship(p.getId(),father.getId(),"Son and Father"));
								r.InserRelationship(new Relationship(p.getId(),mother.getId(),"Son and Mother"));
								lblAddpersonexception.setText("Add " + p.getName() + " Successfully!");
							}else 
							{
								lblAddpersonexception.setText("Canot find mother or father!");
							}
							
						}
					}
				}
				catch(Exception ex)
				{
					lblAddpersonexception.setText("Information error, check input!");
				}
			}
		});
		
		//add relationship button event
		btnAddRelationship.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Repository r = new Repository();
				Person p1 = new Person();
				Person p2 = new Person();
				try 
				{
					p1 = r.GetPersonByName(textFieldPerson1Name.getText());
					p2 = r.GetPersonByName(textFieldPerson2Name.getText());
					if(p1.getId() != null && p2.getId() != null) 
					{
						if(p1.getAge()> 16 && p2.getAge()>16)  
						{
							r.InserRelationship(new Relationship(p1.getId(),p2.getId(),comboBoxChooseRelationship.getSelectedItem().toString()));
							lblAddRelationshipException.setText("Add Relationship Successfully");
						}
						
						if((p1.getAge()> 16 && p2.getAge()<16) || (p1.getAge()< 16 && p2.getAge()>16))  
						{
							lblAddRelationshipException.setText("One person is teenager, cannot add relationship!");
						}
						
						if((p1.getAge() <= 16 && p2.getAge() <= 16) && ((p1.getAge()-p2.getAge() > 3 || (p1.getAge()-p2.getAge() < -3))))
						{
							lblAddRelationshipException.setText("Two persons are teenager, age gap over 3 years, cannot add relationship!");
						}
						
						if((p1.getAge() <= 16 && p2.getAge() <= 16) && ((p1.getAge()-p2.getAge() <= 3 && (p1.getAge()-p2.getAge() >= -3))))
						{
							r.InserRelationship(new Relationship(p1.getId(),p2.getId(),comboBoxChooseRelationship.getSelectedItem().toString()));
							lblAddRelationshipException.setText("Add Relationship Successfully");
						}
					}

					if(p1.getId() == null || p2.getId() == null)  
					{
						lblAddRelationshipException.setText("Persons cannot be found, check input!");
					}
				}
				catch(Exception ex) 
				{
					lblAddRelationshipException.setText("Information error, check input!");
				}
			}
		});
		

		//list persons button event
		btnListpersons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Repository r = new Repository();
				ArrayList<Person> persons = r.GetPersons();
				String list = "";
				for(int i = 0; i< persons.size();i++) 
				{
					list+= persons.get(i).Print() + "\n";
				}
				textFieldPersons.setText(list);
			}
		});
		
		//list relationships button event
		btnListRelationship.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Repository r = new Repository();
				ArrayList<Relationship> relationships = r.GetRelationships();
				String list = "";
				for(int i = 0; i< relationships.size();i++) 
				{
					list+= relationships.get(i).Print() + "\n";
				}
				textFieldPersons.setText(list);
			}
		});
		
		//clear database button event
		btnClearDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Repository r = new Repository();
				r.ClearDatabase();
				textFieldPersons.setText("Database is clear!");
				comboBoxListPerson.removeAllItems();
			}
		});
		
		//add test data event
		btnAddtestdata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Repository r = new Repository();
				r.AddTestData();
				textFieldPersons.setText("Test data added!");
				RefreshSelectPersonList();
			}
		});
		
		//add select person
		btnSelectPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Repository r = new Repository();
				Person p = r.GetPersonByName(comboBoxListPerson.getSelectedItem().toString());
				textFieldPersonDetails.setText(p.Print());
			}
		});
		
		//add display relationship
		btnDisplayRelationship.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Repository r = new Repository();
				String relationship = r.GetRelationship(textFieldPerson1Name.getText(),textFieldPerson2Name.getText());
				lblAddRelationshipException.setText(relationship);
			}
		});
 
	}
	
	public void RefreshSelectPersonList() 
	{
		comboBoxListPerson.removeAllItems();
		Repository r = new Repository();
		ArrayList<Person> persons = r.GetPersons();
		for(int i = 0; i< persons.size();i++) 
		{
			comboBoxListPerson.addItem(persons.get(i).getName());
		}
	}

}