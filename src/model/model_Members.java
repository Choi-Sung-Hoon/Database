package model;

public class model_Members
{
	private String id;
	private String password;
	private int student_number;
	private String student_name;
	private int degree;
	private String major_name;
	
	public model_Members(String id, String password, int student_number, String student_name, int degree, String major_name)
	{
		this.setId(id);
		this.setPassword(password);
		this.setStudentNumber(student_number);
		this.setStudentName(student_name);
		this.setDegree(degree);
		this.setMajorName(major_name);
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getStudentName()
	{
		return student_name;
	}

	public void setStudentName(String student_name)
	{
		this.student_name = student_name;
	}
	
	public int getStudentNumber()
	{
		return student_number;
	}

	public void setStudentNumber(int student_number)
	{
		this.student_number = student_number;
	}

	public int getDegree()
	{
		return degree;
	}

	public void setDegree(int degree)
	{
		this.degree = degree;
	}
	
	public String getMajorName()
	{
		return major_name;
	}

	public void setMajorName(String major_name)
	{
		this.major_name = major_name;
	}
	
	@Override
	public String toString()
	{
		return "Members[id=" + id + ", password=" + password + ", student_number=" + student_number + ", student_name="
				+ student_name + ", degree=" + degree + ", major_name=" + major_name + "]";
	}
}