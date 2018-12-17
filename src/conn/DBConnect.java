package conn;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect
{
	private static DBConnect db = new DBConnect();
	private Connection conn = null;
	
	String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	String jdbc_url = "jdbc:oracle:thin:@localhost:1521:oraknu";
	
	private DBConnect()
	{
	}
	
	public static DBConnect getInstance()
	{
		return db;
	}
	
	public Connection getConnection()
	{
		try
		{
			Class.forName(jdbc_driver);
			
			// get connection instance using database connection information
			conn = DriverManager.getConnection(jdbc_url, "tjdgns9246", "chl1903819");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return conn;
	}
}
