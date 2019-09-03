package model;

import java.sql.Date;

public class model_Participating
{
	private String id;	
	private String club_name;
	private Date start_date, end_date;

	public model_Participating(String id, String club_name, Date start_date, Date end_date)
	{
		this.setId(id);
		this.setClubName(club_name);
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

	public String getClubName()
	{
		return club_name;
	}
	
	public void setClubName(String club_name)
	{
		this.club_name = club_name;
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
		return "Participating[id=" + getId() + ", club_name=" + getClubName() + ", start_date=" + getStartDate() + ", end_date=" + getEndDate() + "]";
	}
}