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

public class MainWindows {

	private JFrame frame;
	private JTextField textFieldName;
	private JTextField textFieldAge;
	private JTextField textFieldStatus;
	private JTextField textFieldMother;
	private JTextField textFieldFather;
	private JTextField textFieldPerson1Name;
	private JTextField textFieldPerson2Name;
	private JTextField textFieldRelationship;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindows window = new MainWindows();
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
	public MainWindows() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1053, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblName = new JLabel("Name");
		panel.add(lblName);
		
		textFieldName = new JTextField();
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		panel.add(lblAge);
		
		textFieldAge = new JTextField();
		panel.add(textFieldAge);
		textFieldAge.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		panel.add(lblStatus);
		
		textFieldStatus = new JTextField();
		panel.add(textFieldStatus);
		textFieldStatus.setColumns(10);
		
		JLabel lblMother = new JLabel("Mother");
		panel.add(lblMother);
		
		textFieldMother = new JTextField();
		panel.add(textFieldMother);
		textFieldMother.setColumns(10);
		
		JLabel lblFather = new JLabel("Father");
		panel.add(lblFather);
		
		textFieldFather = new JTextField();
		panel.add(textFieldFather);
		textFieldFather.setColumns(10);
		
		JButton btnAddPerson = new JButton("Add Person");
		panel.add(btnAddPerson);
		
		JLabel lblAddpersonexception = new JLabel("*");
		panel.add(lblAddpersonexception);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JTextArea textFieldPersons = new JTextArea();
		textFieldPersons.setEditable(false);
		textFieldPersons.setLineWrap(true);
		textFieldPersons.setWrapStyleWord(true);
		textFieldPersons.setRows(10);
		textFieldPersons.setColumns(50);
		panel_1.add(textFieldPersons);
		
		
		JButton btnListpersons = new JButton("ListPersons");
		panel_1.add(btnListpersons);
		
		JButton btnListRelationship = new JButton("List Relationship");
		panel_1.add(btnListRelationship);
		
		JButton btnClearDatabase = new JButton("Clear Database");
		panel_1.add(btnClearDatabase);
		
		JButton btnAddtestdata = new JButton("AddTestData");
		panel_1.add(btnAddtestdata);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		
		JLabel lblPerson = new JLabel("Person1");
		panel_2.add(lblPerson);
		
		textFieldPerson1Name = new JTextField();
		panel_2.add(textFieldPerson1Name);
		textFieldPerson1Name.setColumns(10);
		
		JLabel lblPerson_1 = new JLabel("Person2");
		panel_2.add(lblPerson_1);
		
		textFieldPerson2Name = new JTextField();
		panel_2.add(textFieldPerson2Name);
		textFieldPerson2Name.setColumns(10);
		
		JLabel lblRelationship = new JLabel("Relationship");
		panel_2.add(lblRelationship);
		
		textFieldRelationship = new JTextField();
		panel_2.add(textFieldRelationship);
		textFieldRelationship.setColumns(10);
		
		JButton btnAddRelationship = new JButton("Add Relationship");

		panel_2.add(btnAddRelationship);
		
		JLabel lblAddRelationshipException = new JLabel("*");
		panel_2.add(lblAddRelationshipException);
		
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
									r.InserRelationship(new Relationship(p.getId(),father.getId(),"Child and Father"));
									r.InserRelationship(new Relationship(p.getId(),mother.getId(),"Child and Mother"));
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
							r.InserRelationship(new Relationship(p1.getId(),p2.getId(),textFieldRelationship.getText()));
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
							r.InserRelationship(new Relationship(p1.getId(),p2.getId(),textFieldRelationship.getText()));
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
		
		btnClearDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Repository r = new Repository();
				r.ClearDatabase();
				textFieldPersons.setText("Database is clear!");
			}
		});
		
		btnAddtestdata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Repository r = new Repository();
				r.AddTestData();
				textFieldPersons.setText("Test data added!");
			}
		});
 
	}

}
