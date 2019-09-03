package model;

public class model_Took
{
	private String id;
	private String code;
	private String class_name;
	private String grade;
	
	public model_Took(String id, String code, String class_name, String grade)
	{
		this.setId(id);
		this.setCode(code);
		this.setClassName(class_name);
		this.setGrade(grade);
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}
	
	public String getClassName()
	{
		return class_name;
	}

	public void setClassName(String class_name)
	{
		this.class_name = class_name;
	}

	public String getGrade()
	{
		return grade;
	}

	public void setGrade(String grade)
	{
		this.grade = grade;
	}

	@Override
	public String toString()
	{
		return "Members[id=" + id + ", code=" + code + ", class_name=" + class_name + ", grade=" + grade + "]";
	}
}