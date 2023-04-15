package com.libraryPlus;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class Connector {
	    public static Connection getConnection() {
	        Connection conn = null;
	        try {
	            // JDBC 드라이버 클래스를 로드합니다.
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            // 데이터베이스에 연결합니다.
	            conn = DriverManager.getConnection(
	                    "jdbc:oracle:thin:@192.168.119.119:1521:dink", 
	                    "scott", "tiger17");
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	        return conn;
	    }

	    public static void close(Connection conn) {
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
