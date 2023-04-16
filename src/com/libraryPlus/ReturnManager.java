package com.libraryPlus;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

// 반납 관리
public class ReturnManager implements Manager {

	
	@Override 
	public void add() { 
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() { //반납 
		
	}
	
	public void update2(int memberID, int bookID) {
	    // 회원 ID와 책 ID를 찾음

	    // 회원과 책의 대출 가능 여부를 변경함
	    try (Connection conn = Connector.getConnection()) {
	    	
	    	//MEMBER 테이블 UPDATE
	        String sql1 = "UPDATE MEMBER SET LENDPOSSIBLE = '대출가능회원' WHERE ID = ?";
	        try (PreparedStatement pstmt1 = conn.prepareStatement(sql1)) {
	            pstmt1.setInt(1, memberID);
	            pstmt1.executeUpdate();
	        }
	        //BOOK 테이블 UPDATE
	        String sql2 = "UPDATE BOOK SET LENDPOSSIBLE = '대출가능' WHERE ID = ?";
	        try (PreparedStatement pstmt2 = conn.prepareStatement(sql2)) {
	            pstmt2.setInt(1, bookID);
	            pstmt2.executeUpdate();
	        }
	        //LEND 테이블에 INSERT
	        String sql3 = "UPDATE LEND SET RETURNDAY = ? WHERE LENDMEMBERID = ?";
	        try (PreparedStatement pstmt3 = conn.prepareStatement(sql3)) {
	        	LocalDate today = LocalDate.now();
	            Date date = Date.valueOf(today);
	            SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
	            String formattedDate = sdf.format(date);
	            pstmt3.setString(1, formattedDate);
	            pstmt3.setInt(2, memberID);
	            pstmt3.executeUpdate();
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void delete() { // 
		// TODO Auto-generated method stub
		
	}

}
