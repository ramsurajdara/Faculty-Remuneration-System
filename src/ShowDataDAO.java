import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ShowDataDAO {
	public ResultSet showData(String id) throws SQLException
	{
		Connection c;
		PreparedStatement ps=null;
		c=DBUtil.getConnection();
		ps=c.prepareStatement("select billno,type,pay,status from remuneration where fid=?");
		ps.setString(1, id);
		ResultSet rs=ps.executeQuery();
		return rs;
	}
}
