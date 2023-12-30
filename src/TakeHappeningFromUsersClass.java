import java.sql.CallableStatement;
import java.sql.ResultSet;

public class TakeHappeningFromUsersClass {
	
	public String [][] action(int id, String city,MainClass conn){
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String data [][] = null;
		
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.takeHappeningFromUsers (?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,id);	
			cstmt.setString(2, city);
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
				data[i][1] = ((rs.getString("hap_name")));	
				data[i][0] = ((rs.getString("id")));	
				i = i + 1;
			}
				
			cstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}


}
