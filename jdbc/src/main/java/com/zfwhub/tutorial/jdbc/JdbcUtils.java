package com.zfwhub.tutorial.jdbc;

import java.sql.*;

public final class JdbcUtils {
    
    private static final String url = "jdbc:mysql://localhost:3306/springboot_crud_demo";
    private static final String user = "root";
    private static final String password = "123456";
    
    private JdbcUtils() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    
    public static void free(ResultSet rs, Statement st, Connection conn) {
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
