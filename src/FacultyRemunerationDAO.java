import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FacultyRemunerationDAO {
	int ack=0;
	public int updateDetails(String id, String billno, String type, String count) throws SQLException
	{
		Connection c;
		int pay=0;
		PreparedStatement ps=null;
		c=DBUtil.getConnection();
		if(type.equalsIgnoreCase("valuation"))
			pay=10;
		else if(type.equalsIgnoreCase("lab"))
			pay=10;
		else if(type.equalsIgnoreCase("key"))
			pay=100;
		else 
			pay=140;
		ps=c.prepareStatement("insert into remuneration values(?,?,?,?,?)");
		ps.setString(1, id);
		ps.setString(2, billno);
		ps.setString(3, type);
		if(count==null)
			ps.setInt(4, pay);
		else
			ps.setInt(4, pay*Integer.parseInt(count));
		ps.setString(5, "N");
		ack=ps.executeUpdate();
		return ack;
	}

}
