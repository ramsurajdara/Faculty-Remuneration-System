import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TimeTableDAO {


	@SuppressWarnings("resource")
	public int setData(String[][] data, String id) throws SQLException {
		// TODO Auto-generated method stub
		Connection c;
		PreparedStatement ps=null;
		c=DBUtil.getConnection();
		ps=c.prepareStatement("select dept from faculty where fid=?");
		ps.setString(1, id);
		ResultSet rsd=ps.executeQuery();
		rsd.next();
		String dept=rsd.getString(1);
		ps=c.prepareStatement("select count(*) from timetable where fid=?");
		ps.setString(1, id);
		ResultSet rs=ps.executeQuery();
		rs.next();
		String res;
		int ack=0;
		if(rs.getInt(1)==0)
		{ 
			ps=c.prepareStatement("insert into timetable values (?,?,?,?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, dept);
			res = String.join(",", data[0]);
			ps.setString(3, res);
			res = String.join(",", data[1]);
			ps.setString(4, res);
			res = String.join(",", data[2]);
			ps.setString(5, res);
			res = String.join(",", data[3]);
			ps.setString(6, res);
			res = String.join(",", data[4]);
			ps.setString(7, res);
			ack=ps.executeUpdate();
			return ack;
		}
		else
		{
			ps=c.prepareStatement("update timetable set monday=?,tuesday=?,wednesday=?,thursday=?,friday=? where fid=?");
			ps.setString(6, id);
			res = String.join(",", data[0]);
			ps.setString(1, res);
			res = String.join(",", data[1]);
			ps.setString(2, res);
			res = String.join(",", data[2]);
			ps.setString(3, res);
			res = String.join(",", data[3]);
			ps.setString(4, res);
			res = String.join(",", data[4]);
			ps.setString(5, res);
			ack=ps.executeUpdate();
			return ack;
		}
	}
	
}
