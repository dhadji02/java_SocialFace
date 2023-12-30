import java.sql.CallableStatement;
import java.sql.ResultSet;

public class Show {
	public String[][] ShowAlbum(int UserId, MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String album[][] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.ShowAlbum (?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, UserId);
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
			album = new String[count][count1];
			int i = 0;
			while (rs.next()) {
				album[i][0] = (String.valueOf((rs.getInt("id"))));
				album[i][1] = ((rs.getString("album_name")));
				album[i][2] = ((rs.getString("album_description")));
				album[i][3] = ((rs.getString("album_url")));
				album[i][4] = (String.valueOf((rs.getInt("album_count"))));
				album[i][5] = (String.valueOf((rs.getInt("privacy"))));
				album[i][6] = (String.valueOf((rs.getInt("album_owner"))));
				album[i][7] = (String.valueOf((rs.getInt("album_location"))));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return album;
	}

	public String[][] ShowPhoto(int UserId, MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String photo[][] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.ShowPhoto (?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, UserId);
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
			photo = new String[count][count1];
			int i = 0;
			while (rs.next()) {
				photo[i][0] = (String.valueOf((rs.getInt("id"))));
				photo[i][1] = ((rs.getString("ph_source")));
				photo[i][2] = ((rs.getString("ph_url")));
				photo[i][3] = (String.valueOf((rs.getDouble("width"))));
				photo[i][4] = (String.valueOf((rs.getDouble("height"))));
				photo[i][5] = (String.valueOf((rs.getInt("ph_owner"))));
				photo[i][6] = (String.valueOf((rs.getInt("album_id"))));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return photo;
	}

	public String[][] ShowVideo(int UserId, MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String video[][] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.ShowVideo (?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, UserId);
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
			video = new String[count][count1];
			int i = 0;
			while (rs.next()) {
				video[i][0] = (String.valueOf((rs.getInt("id"))));
				video[i][1] = ((rs.getString("vid_message")));
				video[i][2] = ((rs.getString("vid_description")));
				video[i][3] = (String.valueOf((rs.getInt("vid_length"))));
				video[i][4] = (String.valueOf((rs.getInt("vid_owner"))));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return video;
	}

	public String[][] ShowEvent(int UserId, MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String event[][] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.ShowEvent (?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, UserId);
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
			event = new String[count][count1];
			int i = 0;
			while (rs.next()) {
				event[i][0] = (String.valueOf((rs.getInt("id"))));
				event[i][1] = ((rs.getString("hap_name")));
				event[i][2] = ((rs.getString("hap_description")));
				event[i][3] = ((rs.getString("start_time")));
				event[i][4] = ((rs.getString("end_time")));
				event[i][5] = (String.valueOf((rs.getInt("privacy"))));
				event[i][6] = (rs.getString("hap_city"));
				event[i][7] = (String.valueOf((rs.getInt("host"))));
				event[i][8] = (String.valueOf((rs.getInt("hap_location"))));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return event;
	}

	public String[][] ShowLink(int user, MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String link[][] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.ShowLink (?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, user);
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
			link = new String[count][count1];
			int i = 0;
			while (rs.next()) {
				link[i][0] = (String.valueOf((rs.getInt("id"))));
				link[i][1] = ((rs.getString("link_name")));
				link[i][2] = ((rs.getString("caption")));
				link[i][3] = ((rs.getString("link_description")));
				link[i][4] = ((rs.getString("link")));
				link[i][5] = ((rs.getString("link_message")));
				link[i][6] = (String.valueOf((rs.getInt("link_owner"))));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return link;
	}

	public String[][] ShowUser(int UserId, MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String user[][] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.UserProfile (?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, UserId);
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
			user = new String[count][count1];
			int i = 0;
			while (rs.next()) {
				user[i][0] = (String.valueOf((rs.getInt("id"))));
				user[i][1] = ((rs.getString("fullname")));
				user[i][2] = ((rs.getString("first_name")));
				user[i][3] = ((rs.getString("last_name")));
				user[i][4] = ((rs.getString("birthday")));
				user[i][5] = ((rs.getString("email")));
				user[i][6] = ((String.valueOf(rs.getInt("gender"))));
				user[i][7] = ((rs.getString("user_website")));
				user[i][8] = ((rs.getString("user_url")));
				user[i][9] = (String.valueOf((rs.getInt("verified"))));
				user[i][10] = (String.valueOf((rs.getInt("user_hometown"))));
				user[i][11] = (String.valueOf((rs.getInt("user_location"))));
				user[i][12] = ((rs.getString("username")));
				user[i][13] = (rs.getString("user_password"));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
