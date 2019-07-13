package com.zfwhub.tutorial.jdbc.base;

import java.sql.*;

public class CRUD {
    
    public static void main(String[] args) throws SQLException {
        // create();
        read();
        // update();
        // delete();
    }

    static void delete() throws SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            // conn = JdbcUtilsSing.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "delete from user where id>4";
            int i = st.executeUpdate(sql);
            System.out.println("i=" + i);
        } finally {
            JdbcUtils.free(rs, st, conn);
        }
    }

    static void update() throws SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql = "update user set money=money+10 ";
            int i = st.executeUpdate(sql);
            System.out.println("i=" + i);
        } finally {
            JdbcUtils.free(rs, st, conn);
        }
    }

    static void create() throws SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql = "insert into user(name,birthday, money) values ('name1', '1987-01-01', 400) ";
            int i = st.executeUpdate(sql);
            System.out.println("i=" + i);
        } finally {
            JdbcUtils.free(rs, st, conn);
        }
    }

    static void read() throws SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select id, name, money, birthday  from user");
            while (rs.next()) {
                System.out.println(rs.getObject("id") + "\t"
                        + rs.getObject("name") + "\t"
                        + rs.getObject("birthday") + "\t"
                        + rs.getObject("money"));
            }
        } finally {
            JdbcUtils.free(rs, st, conn);
        }
    }

}
