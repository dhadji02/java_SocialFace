import java.sql.CallableStatement;
import java.sql.ResultSet;

public class Delete {

	public void DeleteFriend(int UserId, int SenderId, MainClass conn) {
		CallableStatement cstmt = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.DeleteFriend (?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, UserId);
			cstmt.setInt(2, SenderId);
			cstmt.execute();
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void DeleteFriendReq(int UserId, int SenderId, MainClass conn) {

		CallableStatement cstmt = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.DeleteRequest (?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, UserId);
			cstmt.setInt(2, SenderId);
			cstmt.execute();
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
