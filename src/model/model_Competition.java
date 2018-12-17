package model;
import java.sql.Date;

public class model_Competition
{
	private int student_number;
	private String competition_name;
	private String prize;
	private Date competition_date;
	
	public model_Competition(int student_number, String competition_name, String prize, Date competition_date)
	{
		this.setStudentNumber(student_number);
		this.setCompetitionName(competition_name);
		this.setPrize(prize);
		this.setCompetitionDate(competition_date);
	}
	
	public int getStudentNumber()
	{
		return student_number;
	}
	
	public void setStudentNumber(int student_number)
	{
		this.student_number = student_number;
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
		return "Competition[student_number=" + student_number + ", competition_name=" + competition_name + ", prize=" + prize + "]";
	}
}
