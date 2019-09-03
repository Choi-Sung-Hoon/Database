package model;

public class model_Clubs
{
	private String club_name;
	
	public model_Clubs(String club_name)
	{
		this.setClubName(club_name);
	}

	public String getClubName()
	{
		return club_name;
	}

	public void setClubName(String club_name)
	{
		this.club_name = club_name;
	}

	@Override
	public String toString()
	{
		return "Members[club_name=" + getClubName() + "]";
	}
}