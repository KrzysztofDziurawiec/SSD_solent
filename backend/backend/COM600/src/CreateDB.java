import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB {
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String URL = "jdbc:derby:za;create=true";
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(URL);
		
		
		// create the tables
		connection.createStatement().execute("CREATE TABLE MEMBERSHIP_TYPE(id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), membership_type varchar(20))");
		connection.createStatement().execute("CREATE TABLE AGE_GROUP ( id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), age_group VARCHAR(20))");
		connection.createStatement().execute("CREATE TABLE QUALIFICATION (id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), qualification VARCHAR(20))");
		connection.createStatement().execute("CREATE TABLE MEMBER (id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), name VARCHAR(20), address VARCHAR(20), "
				+ "phone VARCHAR(20), sex VARCHAR(20), dob DATE,  username VARCHAR(20), password VARCHAR(20), membership_type_id INT,"
				+ " age_group_id INT, qualification_id INT, CONSTRAINT fk_member_type FOREIGN KEY (membership_type_id) REFERENCES MEMBERSHIP_TYPE(id), "
				+ "CONSTRAINT fk_member_age FOREIGN KEY (age_group_id) REFERENCES AGE_GROUP(id),"
				+ " CONSTRAINT fk_member_qualification FOREIGN KEY (qualification_id) REFERENCES QUALIFICATION(id) )");
		connection.createStatement().execute("CREATE TABLE MEMBERS_EVENTS (event_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), membership_id INT NOT NULL)");
		connection.createStatement().execute("CREATE TABLE EVENT_TYPE (id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), event_type VARCHAR(20) NOT NULL)");
		connection.createStatement().execute("CREATE TABLE EVENT (id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), event_type_id INT NOT NULL, transport VARCHAR(20),"
				+ " date DATE NOT NULL, CONSTRAINT fk_event_type FOREIGN KEY (event_type_id) REFERENCES EVENT_TYPE(id))");
//			connection.createStatement().execute("CREATE TABLE MEMBERS_TRAININGS (training_id INT PRIMARY KEY, CONSTRAINT membership_id FOREIGN KEY (id) REFERENCES MEMBER(id)");
		connection.createStatement().execute("CREATE TABLE MEMBERS_TRAININGS (training_id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), membership_id INT NOT NULL)");
		connection.createStatement().execute("CREATE TABLE DISCIPLINE_TRAINING (id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), discipline_type VARCHAR(20) NOT NULL)");
		connection.createStatement().execute("CREATE TABLE TRAINING_TYPE (id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), training_type VARCHAR(20) NOT NULL)");
		connection.createStatement().execute("CREATE TABLE TRAINING (id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), training_type_id INT NOT NULL, discipline_id INT NOT NULL,"
				+ "CONSTRAINT fk_discipline FOREIGN KEY (discipline_id) REFERENCES DISCIPLINE_TRAINING(id),"
				+ " CONSTRAINT fk_training FOREIGN KEY (training_type_id) REFERENCES TRAINING_TYPE(id))");
		
		
		// populate the tables
		connection.createStatement().execute("INSERT INTO MEMBERSHIP_TYPE (membership_type) VALUES ('Athelete')");
		connection.createStatement().execute("INSERT INTO MEMBERSHIP_TYPE (membership_type) VALUES ('Coach')");
		connection.createStatement().execute("INSERT INTO MEMBERSHIP_TYPE (membership_type) VALUES ('Official')");
		connection.createStatement().execute("INSERT INTO MEMBERSHIP_TYPE (membership_type) VALUES ('Administrator')");
		connection.createStatement().execute("INSERT INTO MEMBERSHIP_TYPE (membership_type) VALUES ('Support')");
		
		connection.createStatement().execute("INSERT INTO AGE_GROUP (age_group) VALUES ('U13')");
		connection.createStatement().execute("INSERT INTO AGE_GROUP (age_group) VALUES ('U15')");
		connection.createStatement().execute("INSERT INTO AGE_GROUP (age_group) VALUES ('U17')");
		connection.createStatement().execute("INSERT INTO AGE_GROUP (age_group) VALUES ('U20')");
		connection.createStatement().execute("INSERT INTO AGE_GROUP (age_group) VALUES ('Senior')");
		connection.createStatement().execute("INSERT INTO AGE_GROUP (age_group) VALUES ('Master')");
		
		connection.createStatement().execute("INSERT INTO QUALIFICATION (qualification) VALUES ('Coaching')");
		connection.createStatement().execute("INSERT INTO QUALIFICATION (qualification) VALUES ('Referee')");
		connection.createStatement().execute("INSERT INTO QUALIFICATION (qualification) VALUES ('Timekeeper')");
		connection.createStatement().execute("INSERT INTO QUALIFICATION (qualification) VALUES ('Starter')");
		
		connection.createStatement().execute("INSERT INTO DISCIPLINE_TRAINING (discipline_type) VALUES ('Hurdling')");
		connection.createStatement().execute("INSERT INTO DISCIPLINE_TRAINING (discipline_type) VALUES ('Sprinting')");
		connection.createStatement().execute("INSERT INTO DISCIPLINE_TRAINING (discipline_type) VALUES ('Jumping')");
		connection.createStatement().execute("INSERT INTO DISCIPLINE_TRAINING (discipline_type) VALUES ('Throwing')");
		connection.createStatement().execute("INSERT INTO DISCIPLINE_TRAINING (discipline_type) VALUES ('Boxing')");
		
		connection.createStatement().execute("INSERT INTO TRAINING_TYPE (training_type) VALUES ('Road')");
		connection.createStatement().execute("INSERT INTO TRAINING_TYPE (training_type) VALUES ('Country')");
		connection.createStatement().execute("INSERT INTO TRAINING_TYPE (training_type) VALUES ('Track')");
		connection.createStatement().execute("INSERT INTO TRAINING_TYPE (training_type) VALUES ('Field')");
		connection.createStatement().execute("INSERT INTO TRAINING_TYPE (training_type) VALUES ('Gym')");
		
		connection.createStatement().execute("INSERT INTO TRAINING(training_type_id, discipline_id) VALUES (1,2)");
		connection.createStatement().execute("INSERT INTO TRAINING(training_type_id, discipline_id) VALUES (3,1)");
		connection.createStatement().execute("INSERT INTO TRAINING(training_type_id, discipline_id) VALUES (4,4)");
		connection.createStatement().execute("INSERT INTO TRAINING(training_type_id, discipline_id) VALUES (5,5)");
		
		connection.createStatement().execute("INSERT INTO MEMBERS_TRAININGS(membership_id) VALUES (1)");
		connection.createStatement().execute("INSERT INTO MEMBERS_TRAININGS(membership_id) VALUES (1)");
		connection.createStatement().execute("INSERT INTO MEMBERS_TRAININGS(membership_id) VALUES (2)");
		connection.createStatement().execute("INSERT INTO MEMBERS_TRAININGS(membership_id) VALUES (2)");
		
		connection.createStatement().execute("INSERT INTO EVENT_TYPE (event_type) VALUES ('Tournament')");
		connection.createStatement().execute("INSERT INTO EVENT_TYPE (event_type) VALUES ('Home game')");
		connection.createStatement().execute("INSERT INTO EVENT_TYPE (event_type) VALUES ('Away game')");
		connection.createStatement().execute("INSERT INTO EVENT_TYPE (event_type) VALUES ('Promotional events')");
		connection.createStatement().execute("INSERT INTO EVENT_TYPE (event_type) VALUES ('Conferences')");
		connection.createStatement().execute("INSERT INTO EVENT_TYPE (event_type) VALUES ('Fundraising events')");
		
		connection.createStatement().execute("INSERT INTO EVENT (event_type_id, transport, date) VALUES (1,'Not Provided','01/04/2017')");
		connection.createStatement().execute("INSERT INTO EVENT (event_type_id, transport, date) VALUES (3,'Provided','01/05/2017')");
		connection.createStatement().execute("INSERT INTO EVENT (event_type_id, transport, date) VALUES (5,'Not Provided','01/06/2017')");
		connection.createStatement().execute("INSERT INTO EVENT (event_type_id, transport, date) VALUES (6,'Not Provided','01/07/2017')");
		
		connection.createStatement().execute("INSERT INTO MEMBERS_EVENTS (membership_id) VALUES (1)");
		connection.createStatement().execute("INSERT INTO MEMBERS_EVENTS (membership_id) VALUES (1)");
		connection.createStatement().execute("INSERT INTO MEMBERS_EVENTS (membership_id) VALUES (2)");
		connection.createStatement().execute("INSERT INTO MEMBERS_EVENTS (membership_id) VALUES (2)");
		
		connection.createStatement().execute("INSERT INTO MEMBER (name, address, phone, sex, dob, username, password, membership_type_id, age_group_id, qualification_id) VALUES ('Tom Test', '1 Test Rd SO50 5NX','07546374822','male','01/01/1980','test','test123', 2, 5 ,1)");
		connection.createStatement().execute("INSERT INTO MEMBER (name, address, phone, sex, dob, username, password, membership_type_id, age_group_id, qualification_id) VALUES ('Adam Admin', '1 Admin Rd SO50 5NX','07546374822','male','01/01/1980','sysadmin','password1', 4, 6 ,1)");
	}
}
