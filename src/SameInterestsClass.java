import java.sql.CallableStatement;
import java.sql.ResultSet;

public class SameInterestsClass {
	
	public int [] action(int id,MainClass conn){
		
	ResultSet rs = null;
	CallableStatement cstmt = null;
	int data [] = null;
	
	try {
		cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.sameInterests (?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		cstmt.setInt(1,id);	
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
			data[i] = rs.getInt("G.Closefriend");	
			i = i + 1;
		}
			
		cstmt.close();
	}catch (Exception e) {
		e.printStackTrace();
	}
		return data;
	
	}

}
