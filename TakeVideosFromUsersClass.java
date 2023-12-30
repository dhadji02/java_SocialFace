import java.sql.CallableStatement;
import java.sql.ResultSet;

public class TakeVideosFromUsersClass {
	
	public String[][] action(int id, long length,MainClass conn){
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String data [][] = null;
		
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.takeVideosFromUsers (?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,id);	
			cstmt.setLong(2, length);
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
			int count = rs.getRow(),count1 = rs.getMetaData().getColumnCount();
			rs.beforeFirst();
			
			data = new String [count][count1];
			int i=0;
			while (rs.next()) {
				data[i][0]=(String.valueOf((rs.getInt("id"))));
				data[i][1] = ((rs.getString("Video_Tittle")));
				i = i + 1;
			}
				
			cstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}
