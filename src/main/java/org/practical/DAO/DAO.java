package org.practical.DAO;

import org.practical.Exceptions.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    public Connection getConn() throws DAOException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/taskmanager";
        String username = "root";
        String password = "";
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {
            System.out.println("Failed to find driver class: " + e.getMessage());
            System.exit(1);
        } catch (SQLException exSql) {
            System.out.println("Connection failed: " + exSql.getMessage());
            System.exit(2);
        }
        return conn;
    }

    public void freeConnection(Connection conn) throws DAOException {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            System.out.println("Failed to free the connection: " + e.getMessage());
            System.exit(1);
        }
    }
}
