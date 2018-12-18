package model;
import java.sql.Date;

public class model_Article
{
	private String id;
	private int article_number;
	private String title;
	private String author;
	private Date write_date;
	
	public model_Article(String id, int article_number, String title, String author, Date write_date)
	{
		this.setId(id);
		this.setArticleNumber(article_number);
		this.setTitle(title);
		this.setAuthor(author);
		this.setWriteDate(write_date);
	}
	
	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public int getArticleNumber()
	{
		return article_number;
	}

	public void setArticleNumber(int article_number)
	{
		this.article_number = article_number;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public Date getWriteDate()
	{
		return write_date;
	}

	public void setWriteDate(Date write_date)
	{
		this.write_date = write_date;
	}

	@Override
	public String toString()
	{
		return "Members[id=" + getId() + ", article_number=" + getArticleNumber() + ", title=" + getTitle() + ", author="
				+ getAuthor() + ", write_date=" + getWriteDate() + "]";
	}
}