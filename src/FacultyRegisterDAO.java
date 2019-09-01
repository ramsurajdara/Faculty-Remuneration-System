import java.sql.*;
public class FacultyRegisterDAO {
	
	int ack=0;
	
	
	public int RegFaculty(Faculty f)
	{
		try{
			Connection c;
			PreparedStatement ps=null;
			c=DBUtil.getConnection();
			ps=c.prepareStatement("insert into faculty values(?,?,?,?,?)");
			ps.setString(1, f.getID());
			ps.setString(2, f.getDept());
			ps.setString(3, f.getPassword());
			ps.setString(4, f.getEmail());
			ps.setString(5, f.getPhno());
			ack=ps.executeUpdate();
		}catch(Exception e)
		{
			ack=2;
		}
		return ack;
	}
}
