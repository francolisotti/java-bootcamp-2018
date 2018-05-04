package Mipaquete;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOExample {
	private static DAOExample instance;
	private Connection connection;
	private String url = "jdbc:postgresql://localhost:5432/jdbc";
	private String username = "root";
	private String password = "localhost";

	private DAOExample() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
			this.connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static DAOExample getInstance() throws SQLException {
		if (instance == null) {
			instance = new DAOExample();
		} else if (instance.getConnection().isClosed()) {
			instance = new DAOExample();
		}

		return instance;
	}
}
