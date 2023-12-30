import java.sql.CallableStatement;
import java.sql.ResultSet;

public class SearchName {

	public String[][] SearchAlbum(int UserId, String AlbumName, MainClass conn) {

		ResultSet rs = null;
		CallableStatement cstmt = null;
		String SearAlbum[][] = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.spSearchAlbum (?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, UserId);
			cstmt.setString(2, AlbumName);

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
			SearAlbum = new String[count][count1];
			int i = 0;

			while (rs.next()) {
				SearAlbum[i][0] = (String.valueOf((rs.getInt("id"))));
				SearAlbum[i][1] = ((rs.getString("album_name")));
				SearAlbum[i][2] = ((rs.getString("album_description")));
				SearAlbum[i][3] = ((rs.getString("album_url")));
				SearAlbum[i][4] = (String.valueOf((rs.getInt("album_count"))));
				i++;
			}

			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return SearAlbum;

	}

	public String[][] SearchPhoto(int UserId, String Photoname, MainClass conn) {

		ResultSet rs = null;
		CallableStatement cstmt = null;
		String photo[][] = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.spSearchPhoto (?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, UserId);
			cstmt.setString(2, Photoname);
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
				i++;

			}

			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return photo;

	}

	public String[][] SearchVideo(int UserId, String Videoname, MainClass conn) {

		ResultSet rs = null;
		CallableStatement cstmt = null;
		String video[][] = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.spSearchVideo (?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, UserId);
			cstmt.setString(2, Videoname);
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

	public String[][] SearchEvent(int UserId, String Eventname, MainClass conn) {

		ResultSet rs = null;
		CallableStatement cstmt = null;
		String event[][] = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.spSearchEvent (?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, UserId);
			cstmt.setString(2, Eventname);
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

	public String[][] SearchLink(int UserId, String Linkname, MainClass conn) {

		ResultSet rs = null;
		CallableStatement cstmt = null;
		String link[][] = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.spSearchLink (?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, UserId);
			cstmt.setString(2, Linkname);
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

	public String[][] AlbumDescription(int UserId, String AlbumDesc, MainClass conn) {
		// Album's Description

		ResultSet rs = null;
		CallableStatement cstmt = null;
		String AlbumD[][] = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.AlbumDescription (?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, UserId);
			cstmt.setString(2, AlbumDesc);
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
			AlbumD = new String[count][count1];
			int i = 0;

			while (rs.next()) {

				AlbumD[i][0] = (String.valueOf((rs.getInt("id") + "\n")));
				AlbumD[i][1] = ((rs.getString("album_name") + "\n"));
				AlbumD[i][2] = ((rs.getString("album_description") + "\n"));
				AlbumD[i][3] = ((rs.getString("album_url") + "\n"));
				AlbumD[i][4] = (String.valueOf((rs.getInt("album_count") + "\n")));

				i++;
			}

			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return AlbumD;

	}

	public String[][] PhotoHeight(int UserId, float height, MainClass conn) {
		// Photo's height

		ResultSet rs = null;
		CallableStatement cstmt = null;
		String photo[][] = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.PhotoHeight (?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, UserId);
			cstmt.setFloat(2, height);
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
			photo= new String[count][count1];
			int i = 0;

			while (rs.next()) {
				photo[i][0] = (String.valueOf((rs.getInt("id"))));
				photo[i][1] = ((rs.getString("ph_source")+"\n"));
				photo[i][2] = ((rs.getString("ph_url")+"\n"));
				i++;
			}

			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return photo;

	}

	public String[][] PhotoWidth(int UserId, float width, MainClass conn) {
		// Photo's width

		ResultSet rs = null;
		CallableStatement cstmt = null;
		String photo[][] = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.PhotoWidth (?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, UserId);
			cstmt.setFloat(2, width);
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
				i++;
			}

			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return photo;

	}

	public String[][] VideoDes(int UserId, String VideoDes, MainClass conn) {
		// Video's Description

		ResultSet rs = null;
		CallableStatement cstmt = null;
		String video[][] = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.VideoDescription (?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, UserId);
			cstmt.setString(2, VideoDes);
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

	public String[][] VideoLength(int UserId, long VideoLen, MainClass conn) {
		// Video's length

		ResultSet rs = null;
		CallableStatement cstmt = null;
		String video[][] = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.VideoLength (?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, UserId);
			cstmt.setLong(2, VideoLen);
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

	public String[][] EventDescription(int UserId, String EventDesc, MainClass conn) {
		// Event's description

		ResultSet rs = null;
		CallableStatement cstmt = null;
		String event[][] = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.EventDescription (?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, UserId);
			cstmt.setString(2, EventDesc);
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

	public String[][] LinkCaption(int UserId, String LinkCapt, MainClass conn) {
		// Link's caption

		ResultSet rs = null;
		CallableStatement cstmt = null;
		String link[][] = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.LinkCaption (?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, UserId);
			cstmt.setString(2, LinkCapt);
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

	public String[][] LinkUrl(int UserId, String Lurl, MainClass conn) {
		// Link's url

		ResultSet rs = null;
		CallableStatement cstmt = null;
		String link[][] = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.LinkURL (?,?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, UserId);
			cstmt.setString(2, Lurl);
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

}
