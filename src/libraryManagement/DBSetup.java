package libraryManagement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSetup {
	
	public static void createDBAndTable() {
		try {
			Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			
			//For creating db
			stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS libraryManagement_db");
			stmt.executeUpdate("USE libraryManagement_db");
			
			//Create table
			String createTable = "CREATE TABLE IF NOT EXISTS books (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "title VARCHAR(100)," +
                    "author VARCHAR(100)," +
                    "year INT" +
                    ")";
            stmt.executeUpdate(createTable);
            
            System.out.println("DB and table ready");
			
		} catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
