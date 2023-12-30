import java.sql.CallableStatement;
import java.sql.ResultSet;

public class DeleteDBClass {

	public void DeleteDBMethod(MainClass conn) {
		CallableStatement cstmt = null;

		try {
			cstmt = conn.getDBConnection().prepareCall("{Call dhadji02.deleteDB ()}", ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			cstmt.execute();

			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
