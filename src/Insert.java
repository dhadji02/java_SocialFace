import java.sql.CallableStatement;
import java.sql.ResultSet;

public class Insert {

	public void insertAlbumMethod(String name, String descr, String url, int count, int privacy, int owner,
			int location, MainClass conn) {
		CallableStatement cstmt = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.insertAlbum (?,?,?,?,?,?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1, name);
			cstmt.setString(2, descr);
			cstmt.setString(3, url);
			cstmt.setInt(4, count);
			cstmt.setInt(5, privacy);
			cstmt.setInt(6, owner);
			cstmt.setInt(7, location);
			cstmt.execute();
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertHappeningMethod(String name, String descr, String start, String end, int privacy, String city,
			int host, int location, MainClass conn) {
		CallableStatement cstmt = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.insertHappening (?,?,?,?,?,?,?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1, name);
			cstmt.setString(2, descr);
			cstmt.setString(3, start);
			cstmt.setString(4, end);
			cstmt.setInt(5, privacy);
			cstmt.setString(6, city);
			cstmt.setInt(7, host);
			cstmt.setInt(8, location);
			cstmt.execute();
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertLinkMethod(String name, String caption, String descr, String url, String message, int owner,
			MainClass conn) {
		CallableStatement cstmt = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.insertLink (?,?,?,?,?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1, name);
			cstmt.setString(2, caption);
			cstmt.setString(3, descr);
			cstmt.setString(4, url);
			cstmt.setString(5, message);
			cstmt.setInt(6, owner);
			cstmt.execute();
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertParticipateMethod(int event, int user, MainClass conn) {
		CallableStatement cstmt = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.insertParticipate (?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, event);
			cstmt.setInt(2, user);
			cstmt.execute();
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertPhotoMethod(String source, String url, float width, float height, int owner, int albumid,
			MainClass conn) {
		CallableStatement cstmt = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.insertPhoto (?,?,?,?,?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1, source);
			cstmt.setString(2, url);
			cstmt.setFloat(3, width);
			cstmt.setFloat(4, height);
			cstmt.setInt(5, owner);
			cstmt.setInt(6, albumid);
			cstmt.execute();
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertUserMethod(String full, String first, String last, String bdate, String email, boolean gender,
			String website, String url, boolean verified, int home, int location, String pass, String username,
			MainClass conn) {
		CallableStatement cstmt = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.insertUser (?,?,?,?,?,?,?,?,?,?,?,?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1, full);
			cstmt.setString(2, first);
			cstmt.setString(3, last);
			cstmt.setString(4, bdate);
			cstmt.setString(5, email);
			cstmt.setBoolean(6, gender);
			cstmt.setString(7, website);
			cstmt.setString(8, url);
			cstmt.setBoolean(9, verified);
			cstmt.setInt(10, home);
			cstmt.setInt(11, location);
			cstmt.setString(12, pass);
			cstmt.setString(13, username);
			cstmt.execute();
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertVideoMethod(String message, String descr, long length, int owner, MainClass conn) {
		CallableStatement cstmt = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.insertVideo (?,?,?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1, message);
			cstmt.setString(2, descr);
			cstmt.setLong(3, length);
			cstmt.setInt(4, owner);
			cstmt.execute();
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int giveID(MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		int id = 0;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.giveID ()}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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
				id=rs.getInt("usrID");
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
}
