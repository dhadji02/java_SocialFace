import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ExportData {

	public void Export(String table, FileWriter myWriter, MainClass conn) throws SQLException, IOException {
		ResultSet rs = null;

		conn.getDBConnection().setHoldability(ResultSet.CLOSE_CURSORS_AT_COMMIT);
		Statement stmt = conn.getDBConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY, ResultSet.CLOSE_CURSORS_AT_COMMIT);

		rs = stmt.executeQuery("select * from [dhadji02].[".concat(table + "]"));
		boolean first = true;

		try {
			while (rs.next()) {
				ResultSetMetaData metadata = rs.getMetaData();
				int count = metadata.getColumnCount();

				if (first) {
					for (int i = 1; i <= count; i++) {
						if (first) {
							myWriter.append(metadata.getColumnLabel(i) + "\t");
						}
					}

					myWriter.append("\n");
				}

				first = false;

				for (int i = 1; i <= count; i++) {
					myWriter.append(rs.getString(i) + "\t");
				}

				myWriter.append("\n");
			}

		} catch (Exception e) {
			// Ignore the error and continues
		}
		myWriter.close();
	}

	public String[] name(MainClass conn) {

		ResultSet rs = null;
		CallableStatement cstmt = null;

		String tblName[] = null;
		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.Get_Table_Names ()}",
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
			tblName= new String[count];
			int i = 0;
			while (rs.next()) {
				tblName[i] = rs.getString("TABLE_NAME");
				i++;
			}

			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tblName;

	}

}
