import java.sql.*;
public class FacultyLoginDAO {
	public boolean loginFaculty(Faculty f) throws SQLException{
		Connection c;
		PreparedStatement ps=null;
		c=DBUtil.getConnection();
		ps=c.prepareStatement("select pswd from faculty where fid=?");
		ps.setString(1, f.getID());
		ResultSet rs=ps.executeQuery();  
		while(rs.next())
		{
			if(rs.getString(1).equals(f.getPassword()))
				return true;
		}
		return false;
	}	
}
