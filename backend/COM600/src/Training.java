
public class Training {
	private int id;
	private String type, discipline;
	
	Training(int id, String type, String discipline)
	{
		this.id = id;
		this.type = type;
		this.discipline = discipline;
	}
	
	public int getID()
	{
		return id;
	}
	public String getType()
	{
		return type;
	}
	public String getDiscipline()
	{
		return discipline;
	}
}
