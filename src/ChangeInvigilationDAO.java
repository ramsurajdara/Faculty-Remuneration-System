import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangeInvigilationDAO {

		public int replaceFaculty(String dt, String tm, String room, String fid, String rfid) throws SQLException {
		// TODO Auto-generated method stub			
			Connection c;
			PreparedStatement ps=null;
			c=DBUtil.getConnection();
			ps=c.prepareStatement("update invigilation set fid1=? where dt=? and time=? and roomno=? and fid1=?");
			ps.setString(1, rfid);
			ps.setString(2,dt);
			ps.setString(3, tm);
			ps.setString(4, room);
			ps.setString(5, fid);
			int ack=ps.executeUpdate();
			if(ack!=1)
			{
				ps=c.prepareStatement("update invigilation set fid2=? where dt=? and time=? and roomno=? and fid2=?");
				ps.setString(1, rfid);
				ps.setString(2,dt);
				ps.setString(3, tm);
				ps.setString(4, room);
				ps.setString(5, fid);
				ack=ps.executeUpdate();
			}
			return ack;
	}

}
