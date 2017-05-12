import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSetMetaData;

public class QueryDB {
	Connection conn;
	Statement stmt;
	
	
	QueryDB()
	{
		try
		{
			conn = DriverManager.getConnection(CreateDB.URL);
			stmt = conn.createStatement();
		}
		catch(Exception e)
		{
			System.out.println("QueryDB Constructor exception: " + e);
		}
	}
	public void dropTable(String table)
	{
		try
		{
			conn.createStatement().execute("DROP TABLE " + table);
		}
		catch(Exception e)
		{
			System.out.println("QueryDB --- dropTable() exception: " + e);
		}
	}
	public List<Member> getMembers()
	{
		List<Member> members = new ArrayList<Member>();;
		int id = 0;
		String membership = "", name = "", address = "", phone = "", sex = "", username = "", password = "", dob = "", age = "";
		try
		{
			ResultSet resultSet = stmt.executeQuery("SELECT MEMBER.id, name, address, phone, sex, dob, username, password, age_group, membership_type FROM MEMBER, AGE_GROUP, MEMBERSHIP_TYPE, "
					+ "QUALIFICATION WHERE AGE_GROUP.id = MEMBER.id AND MEMBERSHIP_TYPE.id = MEMBER.id AND QUALIFICATION.id = MEMBER.id");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();
			while(resultSet.next())
			{
				System.out.println("");
				for(int i=1; i<columnCount; i++)
				{
					if(i == 1) id = Integer.parseInt(resultSet.getString(i));
					else if(i == 2)  name = resultSet.getString(i);
					else if(i == 3) address = resultSet.getString(i);
					else if(i == 4) phone = resultSet.getString(i);
					else if(i == 5) sex = resultSet.getString(i);
					else if(i == 6) dob = resultSet.getString(i);
					else if(i == 7) username = resultSet.getString(i);
					else if(i == 8) password = resultSet.getString(i);
					else if(i == 9) age = resultSet.getString(i);
				}
				members.add(new Member(id, age, membership, name, address, phone, sex, username, password, dob));
			}
			return members;
		}
		catch(Exception e)
		{
			System.out.println("QueryDB --- getMembers exception: " + e);
			return members;
		}
	}
	public List<Training> getTrainings()
	{
		List<Training> trainings = new ArrayList<Training>();
		int id = 0;
		String type = "", discipline = "";
		try
		{
			ResultSet resultSet = stmt.executeQuery("SELECT TRAINING.id, TRAINING_TYPE.training_type, DISCIPLINE_TRAINING.discipline_type FROM TRAINING, TRAINING_TYPE, DISCIPLINE_TRAINING "
					+ "WHERE TRAINING_TYPE.id = TRAINING.training_type_id AND DISCIPLINE_TRAINING.id = TRAINING.discipline_id");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();
			while(resultSet.next())
			{
				System.out.println("");
				for(int i=1; i<columnCount; i++)
				{
					if(i == 1) id = Integer.parseInt(resultSet.getString(i));
					else if(i == 2)  type = resultSet.getString(i);
					else if(i == 3) discipline = resultSet.getString(i);
				}
				trainings.add(new Training(id, type, discipline));
			}
			return trainings;
		}
		catch(Exception e)
		{
			System.out.println("QueryDB --- getTrainings() exception: " + e);
			return trainings;
		}
	}
	public List<Event> getEvents()
	{
		List<Event> events = new ArrayList<Event>();
		int id = 0;
		String type = "", transport = "", date = "";
		try
		{
			ResultSet resultSet = stmt.executeQuery("SELECT EVENT.id, EVENT_TYPE.event_type, EVENT.transport, EVENT.date FROM EVENT, EVENT_TYPE WHERE EVENT_TYPE.id = EVENT.event_type_id");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();
			while(resultSet.next())
			{
				System.out.println("");
				for(int i=1; i<columnCount; i++)
				{
					if(i == 1) id = Integer.parseInt(resultSet.getString(i));
					else if(i == 2)  type = resultSet.getString(i);
					else if(i == 3) transport = resultSet.getString(i);
					else if(i == 4) date = resultSet.getString(i);
				}
				events.add(new Event(id, type, transport, date));
			}
			return events;
		}
		catch(Exception e)
		{
			System.out.println("QueryDB --- getEvents() exception: " + e);
			return events;
		}
	}
	public void sendQuery(String query)
	{
		try
		{
			conn.createStatement().execute(query);
		}
		catch(Exception e)
		{
			System.out.println("QueryDB --- sendQuery() exception: " + e);
		}
	}
	
	
	// method for testing purposes only
	public void select(String select)
	{
		try
		{
			ResultSet resultSet = stmt.executeQuery("SELECT  * FROM " + select);
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();
			while(resultSet.next())
			{
				System.out.println("");
				for(int i=1; i<columnCount; i++)
				{
					System.out.println(resultSet.getString(i));
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("QueryDB --- select() exception: " + e);
		}
	}
}