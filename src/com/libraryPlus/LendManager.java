package com.libraryPlus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

// 대출 관리
public class LendManager implements Manager {
Scanner scanner = new Scanner(System.in);
MemberManager memberManager2 = new MemberManager(); //MemberManager 클래스를 사용해서 인스턴스 생성, 활용하도록 하자
BookManager bookManager2 = new BookManager();

	@Override
	public void add() { //lend 테이블에 행 삽입하기
		
	}

	@Override
	public void search() { //
	}

	@Override
	public void delete() { //
	}

	@Override
	public void update() {
	    // 회원 ID와 책 ID를 찾음
	    int memberID = memberManager2.searchID();
	    int bookID = bookManager2.searchID();

	    // 회원과 책의 대출 가능 여부를 변경함
	    try (Connection conn = Connector.getConnection()) {
	    	
	    	//MEMBER 테이블 UPDATE
	        String sql1 = "UPDATE MEMBER SET LENDPOSSIBLE = '대출불가회원' WHERE ID = ?";
	        try (PreparedStatement pstmt1 = conn.prepareStatement(sql1)) {
	            pstmt1.setInt(1, memberID);
	            pstmt1.executeUpdate();
	        }
	        //BOOK 테이블 UPDATE
	        String sql2 = "UPDATE BOOK SET LENDPOSSIBLE = '대출불가도서' WHERE ID = ?";
	        try (PreparedStatement pstmt2 = conn.prepareStatement(sql2)) {
	            pstmt2.setInt(1, bookID);
	            pstmt2.executeUpdate();
	        }
	        //LEND 테이블에 INSERT
	        String sql3 = "INSERT INTO LEND(LENDMEMBERID, LENDBOOKID) VALUES (?,?)";
	        try (PreparedStatement pstmt3 = conn.prepareStatement(sql3)) {
	            pstmt3.setInt(1, memberID);
	            pstmt3.setInt(2, bookID);
	            pstmt3.executeUpdate();
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}

