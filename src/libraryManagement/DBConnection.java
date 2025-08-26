package libraryManagement;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static Properties props;
    
    // Load properties once
    static {
        try {
            props = new Properties();
            FileInputStream fis = new FileInputStream("src/config.properties");
            props.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection() {
        try {
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");
            
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to db");
            return connection;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

