import java.sql.CallableStatement;
import java.sql.ResultSet;

public class UpdatesQry {

	public void updateAlbumMethod(int id,String name, String descr, String url, int count, int privacy, int owner,
			int location, MainClass conn) {
		CallableStatement cstmt = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.updateAlbum (?,?,?,?,?,?,?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1, name);
			cstmt.setString(2, descr);
			cstmt.setString(3, url);
			cstmt.setInt(4, count);
			cstmt.setInt(5, privacy);
			cstmt.setInt(6, owner);
			cstmt.setInt(7, location);
			cstmt.setInt(8, id);
			cstmt.execute();
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateHappeningMethod(String name, String descr, String start, String end, int privacy, String city, int host, int location,int id, MainClass conn) {
		CallableStatement cstmt = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.updateHappening (?,?,?,?,?,?,?,?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1, name);
			cstmt.setString(2, descr);
			cstmt.setString(3, start);
			cstmt.setString(4, end);
			cstmt.setInt(5, privacy);
			cstmt.setString(6, city);
			cstmt.setInt(7, host);
			cstmt.setInt(8, location);
			cstmt.setInt(9, id);
			cstmt.execute();
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateLinkMethod(String name, String caption, String descr, String url, String message, int owner,int id,
			MainClass conn) {
		CallableStatement cstmt = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.updateLink (?,?,?,?,?,?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1, name);
			cstmt.setString(2, caption);
			cstmt.setString(3, descr);
			cstmt.setString(4, url);
			cstmt.setString(5, message);
			cstmt.setInt(6, owner);
			cstmt.setInt(7, id);
			cstmt.execute();
			
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updatePhotoMethod(String source, String url, float width, float height, int owner, int albumid,int id,
			MainClass conn) {
		CallableStatement cstmt = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.updatePhoto (?,?,?,?,?,?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1, source);
			cstmt.setString(2, url);
			cstmt.setFloat(3, width);
			cstmt.setFloat(4, height);
			cstmt.setInt(5, owner);
			cstmt.setInt(6, albumid);
			cstmt.setInt(7, id);
			cstmt.execute();
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateUserMethod(String full, String first, String last, String bdate, String email, boolean gender,
			String website, String url, boolean verified, int home, int location, String pass, String username, int id,
			MainClass conn) {
		CallableStatement cstmt = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.updateUser (?,?,?,?,?,?,?,?,?,?,?,?,?,?)}",
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
			cstmt.setInt(14,id);
			cstmt.execute();
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateVideoMethod(String message, String descr, long length, int owner, int id, MainClass conn) {
		CallableStatement cstmt = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.updateVideo (?,?,?,?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1, message);
			cstmt.setString(2, descr);
			cstmt.setLong(3, length);
			cstmt.setInt(4, owner);
			cstmt.setInt(5, id);
			cstmt.execute();
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updateFriend( int receiver, int pending, int ignore,int sender, MainClass conn) {
		CallableStatement cstmt = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.updateFriend (?,?,?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, receiver);
			cstmt.setInt(3, pending);
			cstmt.setInt(2, ignore);
			cstmt.setInt(4, sender);
			cstmt.execute();
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updateCount( int user, int album, MainClass conn) {
		CallableStatement cstmt = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.updatecount (?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,user);
			cstmt.setInt(2, album);
			cstmt.execute();
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
