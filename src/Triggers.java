import java.sql.CallableStatement;
import java.sql.ResultSet;

public class Triggers {
	public String[][] upAlbum(int user, int k, MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String updates[][] = null;
		try {
			
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.up_Album (?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, user);
			cstmt.setInt(2, k);
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
			updates = new String[count][count1];
			int i = 0;
			while (rs.next()) {
				updates[i][0] = (String.valueOf((rs.getInt("album_id"))));
				updates[i][1] = (((rs.getString("updated_at"))));
				updates[i][2] = (String.valueOf((rs.getString("operation"))));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updates;
	}

	public String[][] upHap(int user, int k, MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String updates[][] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.up_Hap (?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, user);
			cstmt.setInt(2, k);
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
			updates = new String[count][count1];
			int i = 0;
			while (rs.next()) {
				updates[i][0] = (String.valueOf((rs.getInt("happening_id"))));
				updates[i][1] = (((rs.getString("updated_at"))));
				updates[i][2] = (String.valueOf((rs.getString("operation"))));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updates;
	}

	public String[][] upLink(int user, int k, MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String updates[][] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.up_Link (?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, user);
			cstmt.setInt(2, k);
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
			updates = new String[count][count1];
			int i = 0;
			while (rs.next()) {
				updates[i][0] = (String.valueOf((rs.getInt("link_id"))));
				updates[i][1] = (rs.getString("updated_at"));
				updates[i][2] = ((rs.getString("operation")));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updates;
	}

	public String[][] upVideo(int user, int k, MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String updates[][] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.up_Video (?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, user);
			cstmt.setInt(2, k);
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
			updates = new String[count][count1];
			int i = 0;
			while (rs.next()) {
				updates[i][0] = (String.valueOf((rs.getInt("video_id"))));
				updates[i][1] = (((rs.getString("updated_at"))));
				updates[i][2] = (String.valueOf((rs.getString("operation"))));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updates;
	}

	public String[][] upPhoto(int user, int k, MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String updates[][] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.up_photo (?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, user);
			cstmt.setInt(2, k);
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
			updates = new String[count][count1];
			int i = 0;
			while (rs.next()) {
				updates[i][0] = (String.valueOf((rs.getInt("photo_id"))));
				updates[i][1] = (((rs.getString("updated_at"))));
				updates[i][2] = (String.valueOf((rs.getString("operation"))));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updates;
	}

	public String[][] upAll(int user, int k, MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String updates[][] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.up_all (?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, user);
			cstmt.setInt(2, k);
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
			updates = new String[count][count1];
			int i = 0;
			while (rs.next()) {
				updates[i][0] = (((rs.getString("updated_at"))));
				updates[i][1] = (String.valueOf((rs.getString("operation"))));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updates;
	}
}
