import java.sql.CallableStatement;
import java.sql.ResultSet;

public class ExtraSearch {

	public String[][] AlbumDescription(String AlbumDesc, MainClass conn) {

		ResultSet rs = null;
		CallableStatement cstmt = null;
		String AlbumD[][] = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.AlbumDescription (?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1, AlbumDesc);
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

			int count = rs.getRow(), count1 = rs.getMetaData().getColumnCount();
			AlbumD = new String[count][count1];
			int i = 0;

			while (rs.next()) {

				AlbumD[i][0] = (String.valueOf((rs.getInt("id") + "\n")));
				AlbumD[i][1] = ((rs.getString("album_name") + "\n"));
				AlbumD[i][2] = ((rs.getString("album_description") + "\n"));
				AlbumD[i][3] = ((rs.getString("album_url") + "\n"));
				AlbumD[i][4] = (String.valueOf((rs.getInt("album_count") + "\n")));
				AlbumD[i][5] = (String.valueOf((rs.getInt("privacy") + "\n")));
				AlbumD[i][6] = (String.valueOf((rs.getInt("album_owner") + "\n")));
				AlbumD[i][7] = (String.valueOf((rs.getInt("album_location") + "\n")));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AlbumD;

	}

	public String[][] PhotoHeight(double height, MainClass conn) {

		ResultSet rs = null;
		CallableStatement cstmt = null;
		String PhHeight[][] = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.PhotoHeight (?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setDouble(1, height);
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

			int count = rs.getRow(), count1 = rs.getMetaData().getColumnCount();
			PhHeight = new String[count][count1];
			int i = 0;

			while (rs.next()) {

				PhHeight[i][0] = (String.valueOf((rs.getInt("id") + "\n")));
				PhHeight[i][1] = ((rs.getString("ph_source") + "\n"));
				PhHeight[i][2] = ((rs.getString("ph_url") + "\n"));
				PhHeight[i][3] = (String.valueOf((rs.getInt("width") + "\n")));
				PhHeight[i][4] = (String.valueOf((rs.getInt("height") + "\n")));
				PhHeight[i][5] = (String.valueOf((rs.getInt("ph_owner") + "\n")));
				PhHeight[i][6] = (String.valueOf((rs.getInt("album_owner") + "\n")));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return PhHeight;
	}

	public String[][] PhotoWidth(double width, MainClass conn) {

		ResultSet rs = null;
		CallableStatement cstmt = null;
		String PhWidth[][] = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.PhotoWidth (?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setDouble(1, width);
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

			int count = rs.getRow(), count1 = rs.getMetaData().getColumnCount();
			PhWidth = new String[count][count1];
			int i = 0;

			while (rs.next()) {

				PhWidth[i][0] = (String.valueOf((rs.getInt("id") + "\n")));
				PhWidth[i][1] = ((rs.getString("ph_source") + "\n"));
				PhWidth[i][2] = ((rs.getString("ph_url") + "\n"));
				PhWidth[i][3] = (String.valueOf((rs.getInt("width") + "\n")));
				PhWidth[i][4] = (String.valueOf((rs.getInt("height") + "\n")));
				PhWidth[i][5] = (String.valueOf((rs.getInt("ph_owner") + "\n")));
				PhWidth[i][6] = (String.valueOf((rs.getInt("album_owner") + "\n")));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return PhWidth;

	}

	public String[][] VideoDes(String VideoDes, MainClass conn) {

		ResultSet rs = null;
		CallableStatement cstmt = null;
		String VDesc[][] = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.VideoDescription (?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1, VideoDes);
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

			int count = rs.getRow(), count1 = rs.getMetaData().getColumnCount();
			VDesc = new String[count][count1];
			int i = 0;

			while (rs.next()) {

				VDesc[i][0] = (String.valueOf((rs.getInt("id") + "\n")));
				VDesc[i][1] = ((rs.getString("vid_message") + "\n"));
				VDesc[i][2] = ((rs.getString("vid_description") + "\n"));
				VDesc[i][3] = (String.valueOf((rs.getInt("vid_length") + "\n")));
				VDesc[i][4] = (String.valueOf((rs.getInt("vid_owner") + "\n")));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return VDesc;
	}

	public String[][] VideoLength(int VideoLen, MainClass conn) {

		ResultSet rs = null;
		CallableStatement cstmt = null;
		String VLen[][] = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.VideoLength (?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, VideoLen);
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

			int count = rs.getRow(), count1 = rs.getMetaData().getColumnCount();
			VLen = new String[count][count1];
			int i = 0;

			while (rs.next()) {

				VLen[i][0] = (String.valueOf((rs.getInt("id") + "\n")));
				VLen[i][1] = ((rs.getString("vid_message") + "\n"));
				VLen[i][2] = ((rs.getString("vid_description") + "\n"));
				VLen[i][3] = (String.valueOf((rs.getInt("vid_length") + "\n")));
				VLen[i][4] = (String.valueOf((rs.getInt("vid_owner") + "\n")));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return VLen;
	}

	public String[][] EventDescription(String EventDesc, MainClass conn) {

		ResultSet rs = null;
		CallableStatement cstmt = null;
		String EvDesc[][] = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.EventDescription (?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1, EventDesc);
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

			int count = rs.getRow(), count1 = rs.getMetaData().getColumnCount();
			EvDesc = new String[count][count1];
			int i = 0;

			while (rs.next()) {

				EvDesc[i][0] = (String.valueOf((rs.getInt("id") + "\n")));
				EvDesc[i][1] = ((rs.getString("hap_name") + "\n"));
				EvDesc[i][2] = ((rs.getString("hap_description") + "\n"));
				EvDesc[i][3] = ((rs.getString("start_time") + "\n"));
				EvDesc[i][4] = ((rs.getString("end_time") + "\n"));
				EvDesc[i][5] = (String.valueOf((rs.getInt("privacy") + "\n")));
				EvDesc[i][6] = (String.valueOf((rs.getInt("hap_city") + "\n")));
				EvDesc[i][7] = (String.valueOf((rs.getInt("host") + "\n")));
				EvDesc[i][8] = (String.valueOf((rs.getInt("id") + "\n")));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EvDesc;

	}

	public String[][] LinkCaption(String LinkCapt, MainClass conn) {

		ResultSet rs = null;
		CallableStatement cstmt = null;
		String Lcapt[][] = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.LinkCaption (?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1, LinkCapt);
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

			int count = rs.getRow(), count1 = rs.getMetaData().getColumnCount();
			Lcapt = new String[count][count1];
			int i = 0;
			while (rs.next()) {

				Lcapt[i][0] = (String.valueOf((rs.getInt("id") + "\n")));
				Lcapt[i][1] = ((rs.getString("link_name") + "\n"));
				Lcapt[i][2] = ((rs.getString("caption") + "\n"));
				Lcapt[i][3] = ((rs.getString("link_description") + "\n"));
				Lcapt[i][4] = ((rs.getString("link") + "\n"));
				Lcapt[i][5] = ((rs.getString("link_message") + "\n"));
				Lcapt[i][6] = (String.valueOf((rs.getInt("link_owner") + "\n")));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Lcapt;
	}

	public String[][] LinkUrl(String Lurl, MainClass conn) {

		ResultSet rs = null;
		CallableStatement cstmt = null;
		String URL[][] = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.LinkURL (?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1, Lurl);
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

			int count = rs.getRow(), count1 = rs.getMetaData().getColumnCount();
			URL = new String[count][count1];
			int i = 0;

			while (rs.next()) {

				URL[i][0] = (String.valueOf((rs.getInt("id") + "\n")));
				URL[i][1] = ((rs.getString("link_name") + "\n"));
				URL[i][2] = ((rs.getString("caption") + "\n"));
				URL[i][3] = ((rs.getString("link_description") + "\n"));
				URL[i][4] = ((rs.getString("link") + "\n"));
				URL[i][5] = ((rs.getString("link_message") + "\n"));
				URL[i][6] = (String.valueOf((rs.getInt("link_owner") + "\n")));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return URL;
	}
}
