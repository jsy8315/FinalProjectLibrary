package com.libraryPlus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

// 대출 관리
public class LendManager implements Manager {

	@Override
	public void add() { // 
	}

	@Override
	public void search() { //
	}

	@Override
	public void delete() { //
	}

	@Override
	public void update() {
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    System.out.println("도서를 추가합니다.");
	    System.out.println("책 제목을 입력하세요 : ");
	    String title = scanner.nextLine();
	    System.out.println("책 저자를 입력하세요 : ");
	    String author = scanner.nextLine();
	    System.out.println("책 출판사를 입력하세요 : ");
	    String publisher = scanner.nextLine();
	    
	    try {
	        conn = Connector.getConnection();

	        String sql = "INSERT BOOK SET LENDPOSSIBLE (TITLE, AUTHOR, PUBLISHER) VALUES (?,?,?)";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, title); // 첫 번째 물음표에 title 값을 바인딩
	        pstmt.setString(2, author); // 두 번째 물음표에 author 값을 바인딩
	        pstmt.setString(3, publisher); // 세번째 물음표에 publisher 값 받인딩
	        pstmt.executeUpdate(); 
	    }
	     catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        Connector.close(conn);
	    }
	}
	}

