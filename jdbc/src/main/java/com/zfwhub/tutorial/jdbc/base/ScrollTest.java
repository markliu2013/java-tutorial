package com.zfwhub.tutorial.jdbc.base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollTest {

	public static void main(String[] args) throws SQLException {
		scroll();
	}

	static void scroll() throws SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = st
					.executeQuery("select id, name, money, birthday  from user limit 150, 10");
			while (rs.next()) {
				System.out.println(rs.getObject("id") + "\t"
						+ rs.getObject("name") + "\t"
						+ rs.getObject("birthday") + "\t"
						+ rs.getObject("money"));
			}

			System.out.println("------------");
			rs.absolute(150);
			int i = 0;
			while (rs.next() && i < 10) {
				i++;
				System.out.println(rs.getObject("id") + "\t"
						+ rs.getObject("name") + "\t"
						+ rs.getObject("birthday") + "\t"
						+ rs.getObject("money"));
			}

			// if (rs.previous())
			// System.out.println(rs.getObject("id") + "\t"
			// + rs.getObject("name") + "\t"
			// + rs.getObject("birthday") + "\t"
			// + rs.getObject("money"));

		} finally {
			JdbcUtils.free(rs, st, conn);
		}
	}
}
