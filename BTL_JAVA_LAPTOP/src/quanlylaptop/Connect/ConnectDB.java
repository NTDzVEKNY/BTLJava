package quanlylaptop.Connect;

import java.sql.*;

public class ConnectDB {
    
    public static Connection getConnection() {
    	final String username = "sa";
        final String password = "123";
        
        final String url = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=BTLJAVA;"
                + "encrypt=true;trustServerCertificate=true;"
                + "user=" + username
                + ";password=" + password;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Connect database success!");
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Connect database failure!");
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        return null;
    }
    

}
