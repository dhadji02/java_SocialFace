import java.io.FileNotFoundException;
import java.sql.*;

public class MainClass {

	private static boolean dbDriverLoaded = false;
	private static Connection conn = null;

	Connection getDBConnection() {
		String dbConnString = "jdbc:sqlserver://mssql.cs.ucy.ac.cy:1433;databaseName=dhadji02;user=dhadji02;password=Ukqm5QvG\r\n"
				+ ";";

		if (!dbDriverLoaded)
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				dbDriverLoaded = true;
			} catch (ClassNotFoundException e) {
				System.out.println("Cannot load DB driver!");
				return null;
			}

		try {
			if (conn == null)
				conn = DriverManager.getConnection(dbConnString);
			else if (conn.isClosed())
				conn = DriverManager.getConnection(dbConnString);
		} catch (SQLException e) {
			System.out.print("Cannot connect to the DB!\nGot error: ");
			System.out.print(e.getErrorCode());
			System.out.print("\nSQL State: ");
			System.out.println(e.getSQLState());
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
		MainClass anObj = new MainClass();
		conn = anObj.getDBConnection();

		if (conn == null)
			return;
		
		Login net = new Login(anObj);
		net.setVisible(true);
		try {
			if (!conn.isClosed()) {
				// System.out.print("Disconnecting from database...");
				conn.close();
				// System.out.println("Done\n\nBye !");
			}
		} catch (Exception e) {
			// Ignore the error and continues
		}
	}
}
