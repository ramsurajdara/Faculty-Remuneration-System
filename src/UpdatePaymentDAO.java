import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdatePaymentDAO {

	public int payInvg(String dt) throws SQLException {
		// TODO Auto-generated method stub
		Connection c;
		PreparedStatement ps=null;
		c=DBUtil.getConnection();
		ps=c.prepareStatement("update remuneration set status='Y' where billno=?");
		ps.setString(1, dt);
		int count=ps.executeUpdate();
		if(count>0)
			return 1;
		else
			return count;
	}
}
