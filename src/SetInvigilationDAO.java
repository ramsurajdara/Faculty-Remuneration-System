import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SetInvigilationDAO {

	public int setFaculty(String dt, String room, String time, String dept1, String dept2) throws SQLException {
		Connection c;
		PreparedStatement ps=null;
		c=DBUtil.getConnection();
		String fid1,fid2;
		ps=c.prepareStatement("SELECT fid FROM(SELECT * FROM   availability ORDER BY DBMS_RANDOM.RANDOM)"
				+"WHERE dept!=? and dept!=? and time=? and dt=? and rownum<=2");
		ps.setString(1, dept1);
		ps.setString(2, dept2);
		ps.setString(3, time);
		ps.setString(4, dt);
		ResultSet rs=ps.executeQuery();
		if(rs.next()==true)
		{
			System.out.println("1");
			ps=c.prepareStatement("insert into invigilation values(?,?,?,?,?,?,?)");
			ps.setString(1,dt);
			ps.setString(2, time);
			ps.setString(3, room);
			ps.setString(4, dept1);
			ps.setString(5, dept2);
			fid1=rs.getString(1);
			ps.setString(6,fid1);
			if(rs.next()==true)
			{
				System.out.println("11T");
				fid2=rs.getString(1);
				ps.setString(7, fid2);
			}
			else
			{
				System.out.println("11F");
				PreparedStatement ps2=c.prepareStatement("select fid from availability where time=? and dt=? and rownum<=1");
				ps2.setString(1, time);
				ps2.setString(2, dt);
		       ResultSet rs2=ps2.executeQuery();
		       if(rs2.next()==true)
		       {
		    	   System.out.println("11FT");
				   fid2=rs2.getString(1);
		    	   ps.setString(7, fid2);
		       }
		       else
		    	   return 0;
			}
			System.out.println("11T--");
			int val=ps.executeUpdate();
			System.out.println(val);
			if(val==1)
			{
				ps=c.prepareStatement("delete from availability where time=? and dt=? and fid=? or fid=?");
				ps.setString(1, time);
				ps.setString(2, dt);
				ps.setString(3, fid1);
				ps.setString(4, fid2);
				val=ps.executeUpdate();
				if(val==2||val==1)
					return val-1;
				else
					return val;
			}
			else
				return val;
		}
		else
		{
			PreparedStatement ps2=c.prepareStatement("select fid from availability where time=? and dt=? and rownum<=2");
			ps2.setString(1, time);
			ps2.setString(2, dt);
			ResultSet rs2=ps2.executeQuery();
			if(rs2.next())
			{
				fid1=rs2.getString(1);
				if(rs2.next())
				{
					fid2=rs2.getString(1);
					ps2=c.prepareStatement("insert into invigilation values(?,?,?,?,?,?,?)");
					ps2.setString(1,dt);
					ps2.setString(2, time);
					ps2.setString(3, room);
					ps2.setString(4, dept1);
					ps2.setString(5, dept2);
					ps2.setString(6, fid1);
					ps2.setString(7, fid2);
					int val=ps2.executeUpdate();
					if(val==1)
					{
						ps2=c.prepareStatement("delete from availability where time=? and dt=? and (fid=? or fid=?)");
						ps2.setString(1, time);
						ps2.setString(2, dt);
						ps2.setString(3, fid1);
						ps2.setString(4, fid2);
						val=ps2.executeUpdate();
						if(val==2||val==1)
							return val-1;
						else
							return val;
					}
					else
						return val;
				}
				else
					return 0;
			}
			else
				return 0;
		}
	}
}
