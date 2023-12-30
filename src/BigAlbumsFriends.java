import java.sql.CallableStatement;
import java.sql.ResultSet;

public class BigAlbumsFriends {
	
	public String[][] FriendsAlbum(int UserID, int CountPh ,MainClass conn) {
		
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String AlbumFriends [][] = null;
		
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.FriendBigAlbum (?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
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
			rs.last();
			int count = rs.getRow(), count1 = rs.getMetaData().getColumnCount();
			rs.beforeFirst();
			AlbumFriends = new String[count][count1];
			int i = 0;
			
			while (rs.next()) {
				AlbumFriends[i][0] = ((rs.getString("Closefriend") + "\n"));
				AlbumFriends[i][1] = ((rs.getString("album_name") + "\n"));
				AlbumFriends[i][2] = (String.valueOf((rs.getInt("album_count") + "\n")));
				i++;
			}
			
				
			cstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return AlbumFriends;

	}
	
	

}
