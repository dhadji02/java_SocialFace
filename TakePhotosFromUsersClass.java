import java.sql.CallableStatement;
import java.sql.ResultSet;

public class TakePhotosFromUsersClass {
	
	public String [][] action(int id, float height,MainClass conn){
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String data [][] = null;
		
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.takePhotosFromUsers (?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,id);	
			cstmt.setFloat(2, height);
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
			int count = rs.getRow();
			int  count1 = rs.getMetaData().getColumnCount();
			rs.beforeFirst();
			
			data = new String [count][count1];
			int i=0;
			while (rs.next()) {
				data[i][1] = ((rs.getString("ph_source") + "\n"));	
				data[i][0] = (String.valueOf(rs.getInt("id")));
				i = i + 1;
			}
				
			cstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}
