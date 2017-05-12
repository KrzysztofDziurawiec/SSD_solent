import java.util.ArrayList;
import java.util.List;

public class DBTesting {

	public static void main(String[] args) {

		QueryDB query = new QueryDB();
		List<Member> members = new ArrayList<Member>(query.getMembers());
		List<Event> events = new ArrayList<Event>(query.getEvents());
		List<Training> trainings = new ArrayList<Training>(query.getTrainings());
		
		for(int i=0; i<members.size(); i++)
		{ // id, age, membership, name, address, phone, sex, username, password, dob));
			System.out.println("\nMemberID: " + members.get(i).getID());
			System.out.println("Age: " + members.get(i).getAge());
			System.out.println("Membership: " + members.get(i).getMembership());
			System.out.println("Name: " + members.get(i).getName());
			System.out.println("Address: " + members.get(i).getAddress());
			System.out.println("Phone: " + members.get(i).getPhone());
			System.out.println("SEX: " + members.get(i).getSex());
			System.out.println("Username: "  + members.get(i).getUsername());
			System.out.println("Password: " + members.get(i).getPassword());
			System.out.println("DOB: " + members.get(i).getDOB());
		}
		
		for(int i=0; i<events.size(); i++)
		{ // type, trasnport, date
			System.out.println("\nEventID: " + events.get(i).getID());
			System.out.println("Type: " + events.get(i).getTyper());
			System.out.println("Transport: " + events.get(i).getTransport());
			System.out.println("Date: " + events.get(i).getDate());
		}
		
		for(int i=0; i<trainings.size(); i++)
		{
			System.out.println("\nTrainingID: " + trainings.get(i).getID());
			System.out.println("Type: " + trainings.get(i).getType());
			System.out.println("Discipline: " + trainings.get(i).getDiscipline());
		}
		
		query.select("MEMBERSHIP_TYPE");

	}

}
