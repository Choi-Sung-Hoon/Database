package model;

public class model_MultipleMajor
{
	private String id;
	private String major_name;
	
	public model_MultipleMajor(String id, String major_name)
	{
		this.setId(id);
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
		return "MultipleMajor[id=" + id + ", major_name=" + major_name + "]";
	}
}