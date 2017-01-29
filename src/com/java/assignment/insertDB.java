package com.java.assignment;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

public class insertDB {
	private java.sql.Connection conn = null;

	public static void main(String[] args) {
		try {
			// create a mysql database connection
			// String myDriver = "org.gjt.mm.mysql.Driver";
			final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/java";
			Class.forName("com.mysql.jdbc.Driver");

			java.sql.Connection conn = DriverManager.getConnection(myUrl, "root", "admin");

			// the mysql insert statement
			String query = " insert into product (PRODUCTID, PRODUCTNAME,QUANTITY,PRICE,CATEGORY)"
					+ " values (?, ?, ?, ?, ?)";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, "2");
			preparedStmt.setString(2, "Rubble");
			preparedStmt.setInt(3, 10);
			preparedStmt.setDouble(4, 6.6);
			preparedStmt.setString(5, "test category");

			// execute the preparedstatement
			preparedStmt.execute();

			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}

}
