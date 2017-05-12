
public class Member {
	
	private int id;
	private String membership, name, address, phone, sex, username, password, dob, age;
	
	public Member(int id, String age, String membership, String name, String address, String phone, String sex, String username, String password, String dob)
	{
		this.id = id;
		this.age = age;
		this.membership = membership;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.sex = sex;
		this.username = username;
		this.password = password;
		this.dob = dob;
	}
	
	public int getID()
	{
		return id;
	}
	public String getAge()
	{
		return age;
	}
	public String getMembership()
	{
		return membership;
	}
	public String getName()
	{
		return name;
	}
	public String getAddress()
	{
		return address;
	}
	public String getPhone()
	{
		return phone;
	}
	public String getSex()
	{
		return sex;
	}
	public String getUsername()
	{
		return username;
	}
	public String getPassword()
	{
		return password;
	}
	public String getDOB()
	{
		return dob;
	}
}