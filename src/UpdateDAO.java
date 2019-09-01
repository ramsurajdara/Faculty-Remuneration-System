import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDAO {

	public int setFaculty(String[] fac, String dept,String dt,String time) throws SQLException {
		// TODO Auto-generated method stub
		Connection c;
		PreparedStatement ps=null;
		c=DBUtil.getConnection();
		ps=c.prepareStatement("insert into availability values(?,?,?,?)");
		for(int i=0;i<fac.length;i++)
		{
			ps.setString(1, dt);
			ps.setString(2,fac[i]);
			ps.setString(3, time);
			ps.setString(4,dept);
			if(ps.executeUpdate()!=1)
				return 0;
		}
		return 1;
	}
}
