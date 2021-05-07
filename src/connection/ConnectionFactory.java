package connection;
import java.sql.*;
public class ConnectionFactory {
	
	
	
	
	private static Connection con;
	private String database="ordermanagement";
	private String password="Stefan20mysql";
	private String user="root";
	
	public static ConnectionFactory singleinstance=new ConnectionFactory();
	
	
	
	ConnectionFactory()
	{
		if(singleinstance!=null)
		System.out.println("nu se repoate crea baza de date");
	
		
		
		
	}
	
	
	
	
	public void createConnection()
	{
		 try {
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database,user,password);
		 }
		catch(Exception e)
		{
			
			System.out.println("eroare nu ne putem conecta la baza de date" +e);
		}
	}
	public  Connection getConnection()
	{
		return con;
		
		
	}
	
	
	
	
	public static void close(Connection connection)
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void close(Statement statement)
	{
		try {
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void close(ResultSet resultSet)
	{
		try {
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

}
