package com.zfwhub.tutorial.jdbc;

import java.sql.*;

public final class JdbcUtilsSingle {
    
    private static final String url = "jdbc:mysql://localhost:3306/springboot_crud_demo";
    private static final String user = "root";
    private static final String password = "123456";
    
    private JdbcUtilsSingle() {}
    
    // run only once, when class loaded.
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // even driver class can't loaded, you can't do anything.
            throw new ExceptionInInitializerError(e);
        }
    }
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    
    public void free(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (conn != null)
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
            }
        }
    }

}
