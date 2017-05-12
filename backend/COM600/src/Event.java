
public class Event {
	private int id;
	private String type, transport, date;
	
	Event(int id, String type, String transport, String date)
	{
		this.id = id;
		this.type = type;
		this.transport = transport;
		this.date = date;
	}
	
	public int getID()
	{
		return id;
	}
	public String getTyper()
	{
		return type;
	}
	public String getTransport()
	{
		return transport;
	}
	public String getDate()
	{
		return date;
	}
}
