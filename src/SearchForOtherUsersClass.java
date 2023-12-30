import java.sql.CallableStatement;
import java.sql.ResultSet;

public class SearchForOtherUsersClass {
	
	public String[][] action(int id, int parameter, String name,String city, String birth,MainClass conn){
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String[][] data = null;
		
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.searchForOtherUsers (?,?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,id);
			cstmt.setInt(2,parameter);
			cstmt.setString(3, name);
			cstmt.setString(4, city);
			cstmt.setString(5, birth);
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
				data[i][0]=(String.valueOf((rs.getInt("id"))));
				data[i][1] = ((rs.getString("fullname") + "\n"));	
				i = i + 1;
			}
				
			cstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}
