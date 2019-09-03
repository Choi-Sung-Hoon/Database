package model;
import java.sql.Date;

public class model_Volunteer
{
	private String id;
	private String volunteer_name;
	private Date start_date;
	private Date end_date;
	
	public model_Volunteer(String id, String volunteer_name, Date start_date, Date end_date)
	{
		this.setId(id);
		this.setVolunteerName(volunteer_name);
		this.setStartDate(start_date);
		this.setEndDate(end_date);
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getVolunteerName()
	{
		return volunteer_name;
	}

	public void setVolunteerName(String company_name)
	{
		this.volunteer_name = company_name;
	}

	public Date getStartDate()
	{
		return start_date;
	}

	public void setStartDate(Date start_date)
	{
		this.start_date = start_date;
	}

	public Date getEndDate()
	{
		return end_date;
	}

	public void setEndDate(Date end_date)
	{
		this.end_date = end_date;
	}

	@Override
	public String toString()
	{
		return "Members[id=" + id + ", volunteer_name=" + volunteer_name + ", start_date=" + start_date + ", end_date=" + end_date + "]";
	}
}