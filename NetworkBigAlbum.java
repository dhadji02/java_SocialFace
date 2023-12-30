import java.sql.CallableStatement;
import java.sql.ResultSet;

public class NetworkBigAlbum {
	
	public String[][] NetworkAlbums(int UserID, int CountPh ,MainClass conn) {
		
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String AlbumsNet [][] = null;
		
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.takeAlbumFromUsers (?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,UserID);	
			cstmt.setInt(2, CountPh);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
				if (results) { 
					rs = cstmt.getResultSet(); 
					break;
				}
				else  
				rowsAffected = cstmt.getUpdateCount();
			results = cstmt.getMoreResults();
			}
			
			int count = rs.getRow(), count1 = rs.getMetaData().getColumnCount();
			AlbumsNet = new String[count][count1];
			int i = 0;
			
			while (rs.next()) {
				AlbumsNet[i][0] = ((rs.getString("album_name") + "\n"));
				AlbumsNet[i][2] = (String.valueOf((rs.getInt("album_count") + "\n")));
				AlbumsNet[i][1] = ((rs.getString("album_owner") + "\n"));
				i++;	
			}
			
				
			cstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return AlbumsNet;

	}

}
