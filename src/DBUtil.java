import java.sql.*;
public class DBUtil {
	
		public static Connection getConnection()
		{
			Connection con=null;
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@ localhost:1521:xe","system","system");
			}catch(Exception e)
			{
				System.out.println("The Exception:"+e);
			}
			return con;
		}
}
