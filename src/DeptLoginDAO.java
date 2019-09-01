import java.sql.*;

public class DeptLoginDAO {
	public boolean loginDept(String dept,String pswd) throws SQLException{
		Connection c;
		PreparedStatement ps=null;
		c=DBUtil.getConnection();
		ps=c.prepareStatement("select deptpswd from dept where deptname=?");
		ps.setString(1, dept);
		ResultSet rs=ps.executeQuery();  
		while(rs.next())
		{
			if(rs.getString(1).equals(pswd))
				return true;
		}
		return false;
	}
	public int getCount(String dept) throws SQLException
	{
		Connection c;
		PreparedStatement ps=null;
		c=DBUtil.getConnection();
		ps=c.prepareStatement("select count(*) from faculty where dept=?");
		ps.setString(1, dept);
		ResultSet rs=ps.executeQuery();
		rs.next();
		return rs.getInt(1);
	}
	
	public String[] getFaculty(String dept,int n) throws SQLException
	{
		Connection c;int i=0;
		PreparedStatement ps=null;
		c=DBUtil.getConnection();
		ps=c.prepareStatement("select fid from faculty where dept=?");
		ps.setString(1, dept);
		ResultSet rs=ps.executeQuery();
		String[] fids=new String[n]; 
		while(rs.next())
		{
			fids[i++]=rs.getString(1);
		}
		return fids;
		
		
	}
}
