import java.sql.CallableStatement;
import java.sql.ResultSet;

public class Interests_Quotes_qry {
	public String[] showCity(MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String data[] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.disp_city()}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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
			int count = rs.getRow();
			rs.beforeFirst();
			data = new String[count];
			int i = 0;
			while (rs.next()) {
				data[i] = ((rs.getString("city_name") + "\n"));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	//////////////////////////////////////////////////////////////////
	public String[][] showEdu(int id,MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String data[][] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.disp_edu(?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,id);
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
			data = new String[count][count1];
			int i = 0;
			while (rs.next()) {
				data[i][0]=String.valueOf(rs.getInt("id"));
				data[i][1] = ((rs.getString("edu_name")));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	public String[][] showWork(int id, MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String data[][] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.disp_work(?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,id);
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
			data = new String[count][count1];
			int i = 0;
			while (rs.next()) {
				data[i][0]= String.valueOf(rs.getInt("id"));
				data[i][1] = ((rs.getString("workplace_name")));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	public String[][] showQuotes(int id, MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String data[][] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.disp_quotes(?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,id);
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
			data = new String[count][count1];
			int i = 0;
			while (rs.next()) {
				data[i][0]= String.valueOf(rs.getInt("id"));
				data[i][1] = ((rs.getString("quote_name") + "\n"));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	public String[][] showInt(int id, MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String data[][] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.disp_interest(?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,id);
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
			data = new String[count][count1];
			int i = 0;
			while (rs.next()) {
				data[i][0]= String.valueOf(rs.getInt("id"));
				data[i][1] = ((rs.getString("int_description") + "\n"));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	////////////////////////////////////////////////////////////////////////////////////////
	public String[] showIntusr(int id, MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String data[] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.disp_userinterest(?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,id);
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
			int count = rs.getRow();
			rs.beforeFirst();
			data = new String[count];
			int i = 0;
			while (rs.next()) {
				data[i] = ((rs.getString("int_description")));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	public String[] showWorkusr(int id, MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String data[] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.disp_userwork(?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,id);
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
			int count = rs.getRow();
			rs.beforeFirst();
			data = new String[count];
			int i = 0;
			while (rs.next()) {
				data[i] = ((rs.getString("workplace_name")));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	public String[] showEduusr(int id, MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String data[] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.disp_useredu(?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,id);
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
			int count = rs.getRow();
			rs.beforeFirst();
			data = new String[count];
			int i = 0;
			while (rs.next()) {
				data[i] = ((rs.getString("edu_name")));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	public String[] showQuotesUsr(int id, MainClass conn) {
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String data[] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.disp_userquotes(?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1,id);
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
			int count = rs.getRow();
			rs.beforeFirst();
			data = new String[count];
			int i = 0;
			while (rs.next()) {
				data[i] = ((rs.getString("quote_name") + "\n"));
				i++;
			}
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
