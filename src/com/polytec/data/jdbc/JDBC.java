package com.polytec.data.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
    
    public static void main(String[] args) {
        
        // 1. Oracle JDBC 드라이버를 로드합니다. 
        Connection conn = null;
        
        // 2. 데이터베이스에 연결합니다.
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@192.168.119.119:1521/dink";
            String user = "scott";
            String passwd = "tiger17";
            conn = DriverManager.getConnection(url, user, passwd);
            
            // 3. SQL 쿼리를 실행합니다.
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM EMP");
            
            // 4. 쿼리 결과를 처리합니다.
            while (rs.next()) {
               System.out.println(rs.getString("ENAME") + " " + rs.getString("HOWTOGO"));
            }
            
        } catch (ClassNotFoundException e) {
            // 드라이버 로드 중 예외가 발생한 경우 처리합니다.
            e.printStackTrace();
        } catch (SQLException e) {
         // 데이터베이스 연결 및 쿼리 실행 중 예외가 발생한 경우 처리합니다.
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // 연결 닫기 중 예외가 발생한 경우 처리합니다.
                e.printStackTrace();
            }
        }
    }
}
