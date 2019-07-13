package com.zfwhub.tutorial.jdbc;

import java.sql.*;

// Your first JDBC Test Application
public class JDBCFirst {
    
    public static void test() throws Exception {
        // define connection info
        String url = "jdbc:mysql://localhost:3306/springboot_crud_demo";
        String user = "root";
        String password = "123456";
        // register driver
        Class.forName("com.mysql.jdbc.Driver");
        // create Connection
        Connection conn = DriverManager.getConnection(url, user, password);
        // create Statement
        Statement st = conn.createStatement();
        // execute statement
        ResultSet rs = st.executeQuery("select * from department");
        // process result
        while (rs.next()) {
            System.out.println(rs.getObject(1) + "\t" + rs.getObject(2) + "\t" + rs.getObject(3));
        }
        // free resource
        rs.close();
        st.close();
        conn.close();
    }
    
    public static void main(String[] args) throws Exception {
        test();
    }

}
