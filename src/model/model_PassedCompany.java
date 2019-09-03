package model;

public class model_PassedCompany
{
	private String id;
	private String company_name;
	
	public model_PassedCompany(String id, String comapny_name)
	{
		this.setId(id);
		this.setCompanyName(comapny_name);
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getCompanyName()
	{
		return company_name;
	}

	public void setCompanyName(String company_name)
	{
		this.company_name = company_name;
	}

	@Override
	public String toString()
	{
		return "PassedCompany[id=" + id + ", company_name=" + company_name + "]";
	}
}