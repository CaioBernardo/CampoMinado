import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

	private String url = "jdbc:mysql://localhost/campominado?useSSL=false";
	private String user = "root";
	private String password = "";
	Connection connection = null;

	public Connection getConnection() {
		try {
			if (connection == null)
				;

			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Até aqui OK!");
		} catch (SQLException e) {
			System.out.println("Algo não funcionou");
			e.printStackTrace();
		}
		return connection;
	}

}
