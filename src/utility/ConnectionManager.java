package utility;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class ConnectionManager
{
	 public static Connection getConnection() throws ClassNotFoundException, SQLException 
	 {
		 Class.forName("oracle.jdbc.OracleDriver");
		  Connection con = null;
		  con=DriverManager.getConnection("jdbc:oracle:thin:2localhost:1521:xe","SYSTEM","oracle");
		  if(con!=null)
		  {
			  System.out.println("connection established");
		  }
		  else
		  {
			  System.out.println("Check your connection");
		  }
		  return con;
	 }
	 public static Properties loadPropertiesFile() throws Exception
	 {
		 Properties prop = new Properties();	
			InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
			prop.load(in);
			in.close(); 
			return prop;
	 }
}


