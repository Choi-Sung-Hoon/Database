package model;
import java.sql.Date;

public class model_Competition
{
	private String id;;
	private String competition_name;
	private String prize;
	private Date competition_date;
	
	public model_Competition(String id, String competition_name, String prize, Date competition_date)
	{
		this.setId(id);
		this.setCompetitionName(competition_name);
		this.setPrize(prize);
		this.setCompetitionDate(competition_date);
	}
	
	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getCompetitionName()
	{
		return competition_name;
	}

	public void setCompetitionName(String competition_name)
	{
		this.competition_name = competition_name;
	}
	
	public String getPrize()
	{
		return prize;
	}

	public void setPrize(String prize)
	{
		this.prize = prize;
	}
	
	public Date getCompetitionDate()
	{
		return competition_date;
	}

	public void setCompetitionDate(Date competition_date)
	{
		this.competition_date = competition_date;
	}

	@Override
	public String toString()
	{
		return "Competition[id=" + id + ", competition_name=" + competition_name + ", prize=" + prize + "]";
	}
}
