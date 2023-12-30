import java.sql.CallableStatement;
import java.sql.ResultSet;

public class GiveNonFamousEventsClass {
	
	public int [] action(MainClass conn){
		ResultSet rs = null;
		CallableStatement cstmt = null;
		int data [] = null;
		
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.giveNonFamousEvents()}", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
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
			rs.beforeFirst();
			
			data = new int [count];
			int i=0;
			while (rs.next()) {
				data[i] = (rs.getInt("event_id"));	
				i = i + 1;
			}
				
			cstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}


}
