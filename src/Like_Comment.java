import java.sql.CallableStatement;
import java.sql.ResultSet;

public class Like_Comment {
	public String[] showCommentsA(int album,MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String data[] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.albumComments(?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,album);	
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
			int count = rs.getRow();
			rs.beforeFirst();
			data = new String[count];
			int i = 0;
			while (rs.next()) {
				data[i] = ((rs.getString("comment") + "\n"));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	public String[] showCommentsV(int video,MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String data[] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.videoComments(?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,video);	
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
			int count = rs.getRow();
			rs.beforeFirst();
			data = new String[count];
			int i = 0;
			while (rs.next()) {
				data[i] = ((rs.getString("comment") + "\n"));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	public int[] showLikes(int photo,MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		int data[] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.photosLikes(?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,photo);	
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
			int count = rs.getRow();
			rs.beforeFirst();
			data = new int[count];
			int i = 0;
			while (rs.next()) {
				data[i] = (rs.getInt("user_profile_id"));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	public int[] showPhotos(int user,int album,MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		int data[] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.photosAlbum(?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,user);	
			cstmt.setInt(2,album);
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
			int count = rs.getRow();
			rs.beforeFirst();
			data = new int[count];
			int i = 0;
			while (rs.next()) {
				data[i] = ((rs.getInt("id")));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	public int[] takeAlbumId(int user,MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		int data[] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.takeAlbums(?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,user);	
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
			int count = rs.getRow();
			rs.beforeFirst();
			data = new int[count];
			int i = 0;
			while (rs.next()) {
				data[i] = ((rs.getInt("id")));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	public void updatecount(int user,int id, MainClass conn) {
		CallableStatement cstmt = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.updatecount(?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,user);
			cstmt.setInt(2,id);
			cstmt.execute();
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
