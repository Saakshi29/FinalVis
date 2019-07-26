package com.visa.training.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) throws SQLException {
		// checked exception
		Connection c = JdbcUtil.getconnection();
		DatabaseMetaData metaData = c.getMetaData();
		System.out.println("Product is" + metaData.getDatabaseProductName());
		System.out.println("version" + metaData.getDatabaseProductVersion());

	}

}
