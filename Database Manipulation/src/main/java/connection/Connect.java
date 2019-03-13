package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect {

	private static final Logger LOGGER = Logger.getLogger(Connect.class.getName());
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/warehouse";
	private static final String USER = "root";
	private static final String PASS = "";

	private static Connect singleInstance = new Connect();//used for getter

	public Connect() {
		try {
			Class.forName(DRIVER);//returns the class associated with the DRIVER string
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection createConnection() {//create connection to db
		Connection connection = null;
		System.out.println("Connecting to db..");
		try {
			connection = DriverManager.getConnection(DBURL, USER, PASS);
			System.out.println("Connection is successful");
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "An error occured while trying to connect to the database");
			throw new IllegalStateException("Cannot connect the database!", e);
		}
		return connection;
	}

	public static Connection getConnection() {//getter for connection
		return singleInstance.createConnection();
	}

	public static void close(Connection connection) {//close connection

		if (connection != null) {
			try {
				connection.close();
				System.out.println("Connection closed");
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "An error occured while trying to close the connection");
				throw new IllegalStateException("Cannot close the database!", e);
			}
		}
	}
	
	public static void close(Statement statement) {//close statement
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "An error occured while trying to close the statement");
			}
		}
	}

	public static void close(ResultSet resultSet) {//close resultSet
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "An error occured while trying to close the ResultSet");
			}
		}
	}


}
