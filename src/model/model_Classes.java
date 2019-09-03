package model;

public class model_Classes
{
	private String code;
	private String class_name;
	
	public model_Classes(String code, String class_name)
	{
		this.setCode(code);
		this.setClassName(class_name);
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

	@Override
	public String toString()
	{
		return "Members[code=" + code + ", class_name=" + class_name + "]";
	}
}