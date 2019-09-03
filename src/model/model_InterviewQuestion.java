package model;

public class model_InterviewQuestion
{
	private String id;
	private String company_name;
	private String question;
	
	public model_InterviewQuestion(String id, String comapny_name, String question)
	{
		this.setId(id);
		this.setCompanyName(comapny_name);
		this.setQuestion(question);
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

	public String getQuestion()
	{
		return question;
	}

	public void setQuestion(String question)
	{
		this.question = question;
	}

	@Override
	public String toString()
	{
		return "InterviewQuestion[id=" + id + ", company_name=" + company_name + ", question=" + question + "]";
	}
}