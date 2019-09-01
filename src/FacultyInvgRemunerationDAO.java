import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyInvgRemunerationDAO {
	public int setInvgRemData(String dt, String time) throws SQLException {
		// TODO Auto-generated method stub
		Connection c;
		int ack=1;
		String id;
		PreparedStatement ps=null;
		c=DBUtil.getConnection();
		ps=c.prepareStatement("select fid1,fid2 from invigilation where dt=? and time=?");
		ps.setString(1, dt);
		ps.setString(2, time);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			id=rs.getString(1);
			ps=c.prepareStatement("insert into remuneration values(?,?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, dt);
			ps.setString(3, "Invigilation");
			ps.setInt(4, 140);
			ps.setString(5, "N");
			ack=ps.executeUpdate();
			if(ack!=1)		
				return ack;
			id=rs.getString(2);
			ps=c.prepareStatement("insert into remuneration values(?,?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, dt);
			ps.setString(3, "Invigilation");
			ps.setInt(4, 140);
			ps.setString(5, "N");
			ack=ps.executeUpdate();
			if(ack!=1)		
				return ack;
		}
		ps=c.prepareStatement("delete invigilation where dt=? and time=?");
		ps.setString(1, dt);
		ps.setString(2, time);
		ps.executeUpdate();
		//c.commit();
		return ack;
	}
}
