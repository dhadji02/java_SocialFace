import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginQry {
	public int UserLogin(String username, String password, MainClass conn) throws SQLException {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		int user = -1, j = 0;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.splog (?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1, username);
			cstmt.setString(2, password);
			boolean results = cstmt.execute();
			int rowsAffected = 0;

			while (results || rowsAffected != -1) {
				if (results) {
					rs = cstmt.getResultSet();
					break;
				} else
					rowsAffected = cstmt.getUpdateCount();
				results = cstmt.getMoreResults();
			}
			while(rs.next()) {
			user = rs.getInt("id");
			j = rs.getRow();
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (j == 1)
			return user;
		return -1;
	}
}
