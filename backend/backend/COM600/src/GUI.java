

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;

import javax.swing.*;

public class GUI extends JFrame implements ActionListener
{
	JTabbedPane generalTp = new JTabbedPane();
	JPanel mainPanel = new JPanel();
	String[] gender, monthsArray;
	ArrayList<Integer> years;
	ArrayList<String> months, days;
	QueryDB query = new QueryDB();
	List<Member> members = new ArrayList<Member>(query.getMembers());
	List<Event> events = new ArrayList<Event>(query.getEvents());
	List<Training> trainings = new ArrayList<Training>(query.getTrainings());
	
	//membership
	JButton addBtn;
	JTextField nametxt, addresstxt, phonetxt, usertxt, passtxt; 
	JComboBox memberCombo, qualitxt, genderCombo, typeCombo, ageCombo, dobDcombo, dobMcombo, dobYcombo;
	
	//event
	JComboBox eventTypeCombo, eventTransCombo, eventDaycombo, eventMonthcombo, eventYearcombo, eventAgeCombo, eventGenderCombo;
	JButton eventAddBtn;
	
	//training
	JComboBox trainAgeCombo, trainDiscCombo, trainTypeCombo;
	JButton trainAddBtn;
	JTextField trainNametxt;
	public GUI()
	{
		setSize(500, 400);
		setTitle("GUI");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(mainPanel);
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(generalTp);
		
		membershipContent();
		eventContent();
		trainingContent();
	}
	
	
	public void trainingContent()
	{
		
		JPanel gridbag = new JPanel();
		gridbag.setLayout(new GridBagLayout());
		
		//Name label
		JLabel namelbl = new JLabel("Training name");
		GridBagConstraints namelblC = new GridBagConstraints();
		namelblC.fill = GridBagConstraints.BOTH;
		namelblC.weightx = 1.0;
		namelblC.gridx = 0;
		namelblC.gridy = 0;
		gridbag.add(namelbl, namelblC);
		
		//Name text field
		trainNametxt = new JTextField();
		GridBagConstraints nametxtC = new GridBagConstraints();
		nametxtC.fill = GridBagConstraints.BOTH;
		nametxtC.weightx = 1.0;
		nametxtC.gridx = 1;
		nametxtC.gridy = 0;
		gridbag.add(trainNametxt, nametxtC);
		
		//type label
		JLabel typelbl = new JLabel("Type");
		GridBagConstraints typelblC = new GridBagConstraints();
		typelblC.fill = GridBagConstraints.BOTH;
		typelblC.weightx = 1.0;
		typelblC.gridx = 0;
		typelblC.gridy = 1;
		gridbag.add(typelbl, typelblC);
		
		ArrayList<String> trainType = new ArrayList<String>();
		ArrayList<String> trainDiscipline = new ArrayList<String>();

		for (int i = 0; i < trainings.size(); i++)
		{
			trainType.add(trainings.get(i).getType());
			trainDiscipline.add(trainings.get(i).getDiscipline());
		}
		
		//type combo
		trainTypeCombo = new JComboBox(trainType.toArray());
		GridBagConstraints typeComboC = new GridBagConstraints();
		typeComboC.weightx = 1.0;
		typeComboC.fill = GridBagConstraints.BOTH;
		typeComboC.gridx = 1;
		typeComboC.gridy = 1;
		gridbag.add(trainTypeCombo, typeComboC);
		
		//Discipline label
		JLabel disclbl = new JLabel("Discipline");
		GridBagConstraints disclblC = new GridBagConstraints();
		disclblC.fill = GridBagConstraints.BOTH;
		disclblC.weightx = 1.0;
		disclblC.gridx = 0;
		disclblC.gridy = 2;
		gridbag.add(disclbl, disclblC);
		
		//Discipline combo
		trainDiscCombo = new JComboBox();
		GridBagConstraints discComboC = new GridBagConstraints();
		discComboC.weightx = 1.0;
		discComboC.fill = GridBagConstraints.BOTH;
		discComboC.gridx = 1;
		discComboC.gridy = 2;
		gridbag.add(trainDiscCombo, discComboC);
		
		//Age group label
		JLabel agelbl = new JLabel("Age group");
		GridBagConstraints agelblC = new GridBagConstraints();
		agelblC.fill = GridBagConstraints.BOTH;
		agelblC.weightx = 1.0;
		agelblC.gridx = 0;
		agelblC.gridy = 3;
		gridbag.add(agelbl, agelblC);

		//Age group combo
		trainAgeCombo = new JComboBox(trainDiscipline.toArray());
		GridBagConstraints ageComboC = new GridBagConstraints();
		ageComboC.weightx = 1.0;
		ageComboC.fill = GridBagConstraints.BOTH;
		ageComboC.gridx = 1;
		ageComboC.gridy = 3;
		gridbag.add(trainAgeCombo, ageComboC);
		
		//add button
		trainAddBtn = new JButton("Add");
		trainAddBtn.setPreferredSize(new Dimension(80, 30));
		trainAddBtn.addActionListener(this);
		GridBagConstraints addBtnC = new GridBagConstraints();
		addBtnC.gridx = 1;
		addBtnC.gridy = 4;
		addBtnC.insets = new Insets(30,0,0,230);
		gridbag.add(trainAddBtn, addBtnC);
		
		
		generalTp.addTab("Training", gridbag);
	}
	
	public void eventContent()
	{
		JPanel gridbag = new JPanel();
		gridbag.setLayout(new GridBagLayout());
		
		//type label
		JLabel typelbl = new JLabel("Type");
		GridBagConstraints typelblC = new GridBagConstraints();
		typelblC.fill = GridBagConstraints.BOTH;
		typelblC.weightx = 1.0;
		typelblC.gridx = 0;
		typelblC.gridy = 0;
		gridbag.add(typelbl, typelblC);
		
		ArrayList<String> eventType = new ArrayList<String>();
		ArrayList<String> eventTransport = new ArrayList<String>();

		for (int i = 0; i < events.size(); i++)
		{
			eventType.add(events.get(i).getTyper());
			eventTransport.add(events.get(i).getTransport());
		}
		
		
		//type combo
		eventTypeCombo = new JComboBox(eventType.toArray());
		GridBagConstraints typeComboC = new GridBagConstraints();
		typeComboC.weightx = 1.0;
		typeComboC.fill = GridBagConstraints.BOTH;
		typeComboC.gridx = 1;
		typeComboC.gridy = 0;
		gridbag.add(eventTypeCombo, typeComboC);
		
		//transport label
		JLabel translbl = new JLabel("Transport");
		GridBagConstraints translblC = new GridBagConstraints();
		translblC.fill = GridBagConstraints.BOTH;
		translblC.weightx = 1.0;
		translblC.gridx = 0;
		translblC.gridy = 1;
		gridbag.add(translbl, translblC);
		
		//transport combo
		eventTransCombo = new JComboBox(eventTransport.toArray());
		GridBagConstraints transComboC = new GridBagConstraints();
		transComboC.weightx = 1.0;
		transComboC.fill = GridBagConstraints.BOTH;
		transComboC.gridx = 1;
		transComboC.gridy = 1;
		gridbag.add(eventTransCombo, transComboC);
		
		//Date of birth label
		JLabel doblbl = new JLabel("Date of event");
		GridBagConstraints doblblC = new GridBagConstraints();
		doblblC.fill = GridBagConstraints.BOTH;
		doblblC.weightx = 1.0;
		doblblC.gridx = 0;
		doblblC.gridy = 2;
		gridbag.add(doblbl, doblblC);
		
		ArrayList<String> days = new ArrayList<String>();
		
		for (int i = 1; i < 32; i++)
		{
			days.add(String.format("%02d", i));
		}
		
		eventDaycombo = new JComboBox(days.toArray());
		GridBagConstraints dobDC = new GridBagConstraints();
		dobDC.weightx = 0.0;
		//dobDC.fill = GridBagConstraints.BOTH;
		dobDC.gridx = 1;
		dobDC.gridy = 2;
		dobDC.insets = new Insets(0,0,0,200);
		gridbag.add(eventDaycombo, dobDC);
		
		ArrayList<String> eventMonths = new ArrayList<String>();
		monthsArray = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
		
		for (int i = 0; i < 12; i++)
		{
			eventMonths.add(monthsArray[i]);
			
		}
		
		eventMonthcombo = new JComboBox(months.toArray());
		GridBagConstraints dobMC = new GridBagConstraints();
		dobMC.weightx = 0.0;
		//dobMC.fill = GridBagConstraints.BOTH;
		dobMC.gridx = 1;
		dobMC.gridy = 2;
		dobMC.insets = new Insets(0,0,0,50);
		gridbag.add(eventMonthcombo, dobMC);
		
		ArrayList<Integer> years = new ArrayList<Integer>();
		
		for (int i = 2020; i > 1917; i--)
		{
			years.add(i);
		}
		
		eventYearcombo = new JComboBox(years.toArray());
		GridBagConstraints dobYC = new GridBagConstraints();
		dobYC.weightx = 0.0;
		//dobYC.fill = GridBagConstraints.BOTH;
		dobYC.gridx = 1;
		dobYC.gridy = 2;
		dobYC.insets = new Insets(0,120,0,0);
		gridbag.add(eventYearcombo, dobYC);
		
		//Age group label
		JLabel agelbl = new JLabel("Age group");
		GridBagConstraints agelblC = new GridBagConstraints();
		agelblC.fill = GridBagConstraints.BOTH;
		agelblC.weightx = 1.0;
		agelblC.gridx = 0;
		agelblC.gridy = 3;
		gridbag.add(agelbl, agelblC);

		//Age group combo box
		eventAgeCombo = new JComboBox();
		GridBagConstraints ageComboC = new GridBagConstraints();
		ageComboC.weightx = 1.0;
		ageComboC.fill = GridBagConstraints.BOTH;
		ageComboC.gridx = 1;
		ageComboC.gridy = 3;
		gridbag.add(eventAgeCombo, ageComboC);
		
//		//Gender label
//		gender = new String[]{"Male", "Female", "Other"};
//		JLabel genderlbl = new JLabel("Gender");
//		GridBagConstraints genderlblC = new GridBagConstraints();
//		genderlblC.fill = GridBagConstraints.BOTH;
//		genderlblC.weightx = 1.0;
//		genderlblC.gridx = 0;
//		genderlblC.gridy = 4;
//		gridbag.add(genderlbl, genderlblC);
//		
//		//Gender combo box
//		eventGenderCombo = new JComboBox(gender);
//		GridBagConstraints genderComboC = new GridBagConstraints();
//		genderComboC.weightx = 1.0;
//		genderComboC.fill = GridBagConstraints.BOTH;
//		genderComboC.gridx = 1;
//		genderlblC.gridy = 4;
//		gridbag.add(genderCombo, genderComboC);
		
		//add button
		eventAddBtn = new JButton("Add");
		eventAddBtn.setPreferredSize(new Dimension(80, 30));
		eventAddBtn.addActionListener(this);
		GridBagConstraints addBtnC = new GridBagConstraints();
		addBtnC.gridx = 1;
		addBtnC.gridy = 5;
		addBtnC.insets = new Insets(30,0,0,230);
		gridbag.add(eventAddBtn, addBtnC);
		
		generalTp.addTab("Event", gridbag);
		
	}
	
	public void membershipContent()
	{
		
		JPanel gridAdd = new JPanel();
		//gridAdd.getRootPane().add(membTp);
		//creating panel with gridbag layout
		JPanel gridbag = new JPanel();
		gridbag.setLayout(new GridBagLayout());
		
		
		
		//Membership type label
		JLabel membershiplbl = new JLabel("Membership type");
		GridBagConstraints membershiplblC = new GridBagConstraints();
		membershiplblC.fill = GridBagConstraints.BOTH;
		membershiplblC.weightx = 1.0;
		membershiplblC.gridx = 0;
		membershiplblC.gridy = 0;
		gridbag.add(membershiplbl, membershiplblC);
		
		
		ArrayList<String> membersMembership = new ArrayList<String>();
		ArrayList<String> membersAge = new ArrayList<String>();
		ArrayList<Integer> membersQuali = new ArrayList<Integer>();

		for (int i = 0; i < members.size(); i++)
		{
			membersMembership.add(members.get(i).getMembership());
			membersQuali.add(members.get(i).getID());
			membersAge.add(members.get(i).getAge());
		}
		
		//Membership type combo box
		memberCombo = new JComboBox(membersQuali.toArray());
		GridBagConstraints memberComboC = new GridBagConstraints();
		memberComboC.weightx = 1.0;
		memberComboC.fill = GridBagConstraints.BOTH;
		memberComboC.gridx = 1;
		memberComboC.gridy = 0;
		gridbag.add(memberCombo, memberComboC);
		
		//Age group label
		JLabel agelbl = new JLabel("Age group");
		GridBagConstraints agelblC = new GridBagConstraints();
		agelblC.fill = GridBagConstraints.BOTH;
		agelblC.weightx = 1.0;
		agelblC.gridx = 0;
		agelblC.gridy = 1;
		gridbag.add(agelbl, agelblC);
		
		//Age group combo box
		ageCombo = new JComboBox(membersQuali.toArray());
		GridBagConstraints ageComboC = new GridBagConstraints();
		ageComboC.weightx = 1.0;
		ageComboC.fill = GridBagConstraints.BOTH;
		ageComboC.gridx = 1;
		ageComboC.gridy = 1;
		gridbag.add(ageCombo, ageComboC);
		
	
		//Qualifications label
		JLabel qualilbl = new JLabel("Qualifications");
		GridBagConstraints qualilblC = new GridBagConstraints();
		qualilblC.fill = GridBagConstraints.BOTH;
		qualilblC.weightx = 1.0;
		qualilblC.gridx = 0;
		qualilblC.gridy = 2;
		gridbag.add(qualilbl, qualilblC);
		
		//Qualification combo
		qualitxt = new JComboBox(membersQuali.toArray());
		GridBagConstraints qualitxtC = new GridBagConstraints();
		qualitxtC.weightx = 1.0;
		qualitxtC.fill = GridBagConstraints.BOTH;
		qualitxtC.gridx = 1;
		qualitxtC.gridy = 2;
		gridbag.add(qualitxt, qualitxtC);
		
		//Name label
		JLabel namelbl = new JLabel("Name");
		GridBagConstraints namelblC = new GridBagConstraints();
		namelblC.fill = GridBagConstraints.BOTH;
		namelblC.weightx = 1.0;
		namelblC.gridx = 0;
		namelblC.gridy = 3;
		gridbag.add(namelbl, namelblC);
		
		//Name text field
		nametxt = new JTextField();
		GridBagConstraints nametxtC = new GridBagConstraints();
		nametxtC.fill = GridBagConstraints.BOTH;
		nametxtC.weightx = 1.0;
		nametxtC.gridx = 1;
		nametxtC.gridy = 3;
		gridbag.add(nametxt, nametxtC);
		
		//Address label
		JLabel addresslbl = new JLabel("Address");
		GridBagConstraints addresslblC = new GridBagConstraints();
		addresslblC.fill = GridBagConstraints.BOTH;
		addresslblC.weightx = 1.0;
		addresslblC.gridx = 0;
		addresslblC.gridy = 4;
		gridbag.add(addresslbl, addresslblC);
		
		//Address text field
		addresstxt = new JTextField();
		GridBagConstraints addresstxtC = new GridBagConstraints();
		addresstxtC.fill = GridBagConstraints.BOTH;
		addresstxtC.weightx = 1.0;
		addresstxtC.gridx = 1;
		addresstxtC.gridy = 4;
		gridbag.add(addresstxt, addresstxtC);
		
		//Phone label
		JLabel phonelbl = new JLabel("Phone");
		GridBagConstraints phonelblC = new GridBagConstraints();
		phonelblC.fill = GridBagConstraints.BOTH;
		phonelblC.weightx = 1.0;
		phonelblC.gridx = 0;
		phonelblC.gridy = 5;
		gridbag.add(phonelbl, phonelblC);
		
		//Phone text field
		phonetxt = new JTextField();
		GridBagConstraints phonetxtC = new GridBagConstraints();
		phonetxtC.fill = GridBagConstraints.BOTH;
		phonetxtC.weightx = 1.0;
		phonetxtC.gridx = 1;
		phonetxtC.gridy = 5;
		gridbag.add(phonetxt, phonetxtC);
		
		//Gender label
		gender = new String[]{"Male", "Female", "Other"};
		JLabel genderlbl = new JLabel("Gender");
		GridBagConstraints genderlblC = new GridBagConstraints();
		genderlblC.fill = GridBagConstraints.BOTH;
		genderlblC.weightx = 1.0;
		genderlblC.gridx = 0;
		genderlblC.gridy = 6;
		gridbag.add(genderlbl, genderlblC);
		
		//Gender combo box
		genderCombo = new JComboBox(gender);
		GridBagConstraints genderComboC = new GridBagConstraints();
		genderComboC.weightx = 1.0;
		genderComboC.fill = GridBagConstraints.BOTH;
		genderComboC.gridx = 1;
		genderlblC.gridy = 6;
		gridbag.add(genderCombo, genderComboC);
		
		//username label
		JLabel userlbl = new JLabel("Username");
		GridBagConstraints userlblC = new GridBagConstraints();
		userlblC.fill = GridBagConstraints.BOTH;
		userlblC.weightx = 1.0;
		userlblC.gridx = 0;
		userlblC.gridy = 7;
		gridbag.add(userlbl, userlblC);
		
		//username text field
		usertxt = new JTextField();
		GridBagConstraints usertxtC = new GridBagConstraints();
		usertxtC.fill = GridBagConstraints.BOTH;
		usertxtC.weightx = 1.0;
		usertxtC.gridx = 1;
		usertxtC.gridy = 7;
		gridbag.add(usertxt, usertxtC);
		
		//password label
		JLabel passlbl = new JLabel("Password");
		GridBagConstraints passlblC = new GridBagConstraints();
		passlblC.fill = GridBagConstraints.BOTH;
		passlblC.weightx = 1.0;
		passlblC.gridx = 0;
		passlblC.gridy = 8;
		gridbag.add(passlbl, passlblC);
		
		//password text field
		passtxt = new JTextField();
		GridBagConstraints passtxtC = new GridBagConstraints();
		passtxtC.fill = GridBagConstraints.BOTH;
		passtxtC.weightx = 1.0;
		passtxtC.gridx = 1;
		passtxtC.gridy = 8;
		gridbag.add(passtxt, passtxtC);
		
		//Date of birth label
		JLabel doblbl = new JLabel("Date of birth (e.g. 30/01/2000)");
		GridBagConstraints doblblC = new GridBagConstraints();
		doblblC.fill = GridBagConstraints.BOTH;
		doblblC.weightx = 1.0;
		doblblC.gridx = 0;
		doblblC.gridy = 9;
		gridbag.add(doblbl, doblblC);
		
		days = new ArrayList<String>();
		monthsArray = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
	
		
		for (int i = 1; i < 32; i++)
		{
			days.add(String.format("%02d", i));
		}
		
		dobDcombo = new JComboBox(days.toArray());
		GridBagConstraints dobDC = new GridBagConstraints();
		dobDC.weightx = 0.0;
		//dobDC.fill = GridBagConstraints.BOTH;
		dobDC.gridx = 1;
		dobDC.gridy = 9;
		dobDC.insets = new Insets(0,0,0,200);
		gridbag.add(dobDcombo, dobDC);
		
		months = new ArrayList<String>();
		monthsArray = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
		
		for (int i = 0; i < 12; i++)
		{
			months.add(monthsArray[i]);
			
		}
		
		dobMcombo = new JComboBox(months.toArray());
		GridBagConstraints dobMC = new GridBagConstraints();
		dobMC.weightx = 0.0;
		//dobMC.fill = GridBagConstraints.BOTH;
		dobMC.gridx = 1;
		dobMC.gridy = 9;
		dobMC.insets = new Insets(0,0,0,50);
		gridbag.add(dobMcombo, dobMC);
		
		years = new ArrayList<Integer>();
		
		for (int i = 2017; i > 1917; i--)
		{
			years.add(i);
		}
		
		dobYcombo = new JComboBox(years.toArray());
		GridBagConstraints dobYC = new GridBagConstraints();
		dobYC.weightx = 0.0;
		//dobYC.fill = GridBagConstraints.BOTH;
		dobYC.gridx = 1;
		dobYC.gridy = 9;
		dobYC.insets = new Insets(0,120,0,0);
		gridbag.add(dobYcombo, dobYC);
		
		//add button
		addBtn = new JButton("Add");
		addBtn.addActionListener(this);
		addBtn.setPreferredSize(new Dimension(80, 30));
		GridBagConstraints addBtnC = new GridBagConstraints();
		addBtnC.gridx = 1;
		addBtnC.gridy = 10;
		addBtnC.insets = new Insets(30,0,0,230);
		gridbag.add(addBtn, addBtnC);
		

		// membTp.setLocation(0, 100);
        generalTp.addTab("Membership", gridbag);
	}
	
	
	
	public static void main(String[] args)
	{
		new GUI();
		
	}

	//"INSERT INTO MEMBER (name, address, phone, sex, dob, username, password, membership_type_id, age_group_id, qualification_id) 
	//VALUES ('Tom Test', '1 Test Rd SO50 5NX',
	//'07546374822','male','01/01/1980','test','test123', 2, 5 ,1)");

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//3 ostatnie wartosci to cyferki
		//wszystko inne string
		//zobacz puste pola w dbtesting
		//zmien nazwy globalnych i lokalnych bo sa te same
		//zrob wszystki selecty combo boxow - wyzej jest przyklad
		//funkja update tak jak insert tylko zmien nazwe tabelki itp itd 
		//javaDB sql
		//za 1szym razem zalacz createDB - run -> java app

		if (e.getSource() == addBtn)
		{
			String queryMember = "INSERT INTO MEMBER (name, address, phone, sex, dob, username, password, membership_type_id, age_group_id, qualification_id) "
								+ "VALUES('" + nametxt.getText() + "','" 
								+ addresstxt.getText() + "','" 
								+ phonetxt.getText() + "','"
								+ genderCombo.getSelectedItem().toString() + "','"
								+ dobMcombo.getSelectedItem().toString() + "/"
								+ dobDcombo.getSelectedItem().toString() + "/"
								+ dobYcombo.getSelectedItem().toString() + "','"
								+ usertxt.getText() + "','" 
								+ passtxt.getText() + "',"
								+ memberCombo.getSelectedItem().toString() + ","
								+ ageCombo.getSelectedItem().toString() + ","
								+ qualitxt.getSelectedItem().toString() + ")";
			
//			System.out.println(addresstxt.getText());
//			System.out.println("coto");
//			System.out.println(phonetxt.getText());
//			System.out.println(genderCombo.getSelectedItem().toString());
//			System.out.println(dobMcombo.getSelectedItem().toString());
//			System.out.println(dobDcombo.getSelectedItem().toString());
//			System.out.println(dobYcombo.getSelectedItem().toString());
//			System.out.println(usertxt.getText());
//			System.out.println(passtxt.getText());
//			System.out.println(memberCombo.getSelectedItem().toString());
//			System.out.println(ageCombo.getSelectedItem().toString());
//			System.out.println(qualitxt.getSelectedItem().toString());

			if (nametxt.getText() != null || nametxt.getText() != "")
			{
				query.sendQuery(queryMember);
			}
			else
			{
				System.out.println("Field is empty");
			}
		}
		
		if (e.getSource() == eventAddBtn)
		{
			String queryEvent = "INSERT INTO EVENT (event_type_id, transport, date) "
					+ "VALUES('" 
					+ eventTypeCombo.getSelectedItem().toString() + "','" 
					+ eventTransCombo.getSelectedItem().toString() + "','" 
					+ eventMonthcombo.getSelectedItem().toString() + "/"
					+ eventDaycombo.getSelectedItem().toString() + "/"
					+ eventYearcombo.getSelectedItem().toString() + ")";
			
//			System.out.println(eventTypeCombo.getSelectedItem().toString());
//			System.out.println(eventTransCombo.getSelectedItem().toString());
//			System.out.println(eventMonthcombo.getSelectedItem().toString());
//			System.out.println(eventDaycombo.getSelectedItem().toString());
//			System.out.println(eventYearcombo.getSelectedItem().toString());

			query.select("event");
			query.sendQuery(queryEvent);

		}
		
		if (e.getSource() == trainAddBtn)
		{
			String queryTraining = "INSERT INTO TRAINING(training_type_id, discipline_id) "
								+ "VALUES('" 
								+ trainTypeCombo.getSelectedItem().toString() + "','" 
								+ trainDiscCombo.getSelectedItem().toString() +   ")";


			query.select("training");
			query.sendQuery(queryTraining);

		}
	}
}