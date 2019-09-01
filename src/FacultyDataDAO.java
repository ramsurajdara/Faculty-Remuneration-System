import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyDataDAO {

	public ResultSet getData(String dept) throws SQLException {
		// TODO Auto-generated method stub
		Connection c;
		PreparedStatement ps=null;
		System.out.println("Entered");
		c=DBUtil.getConnection();
		System.out.println(dept);
		ps=c.prepareStatement("select * from timetable where dept=?");
		ps.setString(1, dept);
		ResultSet rs=ps.executeQuery();  
		return rs;
	}

}
