import java.sql.CallableStatement;
import java.sql.ResultSet;

public class friendQrys {
	public String[][] takeFriendReq(int id, MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String data[][] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.friendRequests (?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, id);
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

			rs.last();
			int count = rs.getRow(), count1 = rs.getMetaData().getColumnCount();
			rs.beforeFirst();
			data = new String[count][count1];
			int i = 0;
			while (rs.next()) {
				data[i][0] = ((rs.getString("id")));
				data[i][1] = (rs.getString("username"));
				data[i][2] = (rs.getString("fullname"));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	public String[][] takeFriends(int id, MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String data[][] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.areFriends(?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, id);
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

			rs.last();
			int count = rs.getRow(), count1 = rs.getMetaData().getColumnCount();
			rs.beforeFirst();
			data = new String[count][count1];
			int i = 0;
			while (rs.next()) {
				data[i][0] = ((rs.getString("id")));
				data[i][1] = (rs.getString("username"));
				data[i][2] = (rs.getString("fullname"));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	public int avgAge (int id, MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		int age = 0;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.avgAge (?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, id);
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
			
			while (rs.next()) {
				age=rs.getInt(1);
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return age;
	}
	public String[][] takeIgnored(int id, MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String data[][] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.ignored(?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, id);
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

			rs.last();
			int count = rs.getRow(), count1 = rs.getMetaData().getColumnCount();
			rs.beforeFirst();
			data = new String[count][count1];
			int i = 0;
			while (rs.next()) {
				data[i][0] = ((rs.getString("id")));
				data[i][1] = (rs.getString("username"));
				data[i][2] = (rs.getString("fullname"));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	public String[][] famousFriends(int id, MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String data[][] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.famousFriends(?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, id);
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

			rs.last();
			int count = rs.getRow(), count1 = rs.getMetaData().getColumnCount();
			rs.beforeFirst();
			data = new String[count][count1];
			int i = 0;
			while (rs.next()) {
				data[i][0] = ((rs.getString("receiver_id")));
				data[i][1] = (rs.getString("friendCount"));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
