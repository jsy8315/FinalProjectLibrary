package com.libraryPlus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

// 도서관리
public class BookManager implements Manager {
	Scanner scanner = new Scanner(System.in);
	
	@Override
	public void add() { // 책 새로 등록
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

	        String sql = "INSERT INTO BOOK(TITLE, AUTHOR, PUBLISHER) VALUES (?,?,?)";
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

	@Override
	public void search() { // 책 제목과 저자를 입력하고, 행 통째로 반환하기
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null; // ResultSet 객체는 DB에서 검색한 결과를 담은 객체
	    

	    // 즉, rs 객체를 이용해서 데이터베이스에서 가져온 데이터를 Java 프로그램에서 활용할 수 있습니다.

	    // 여기서 pstmt는 미리 준비된(prepared) SQL 문장 객체를 나타냅니다. 
	    // 미리 준비된 SQL 문장 객체는 SQL 인젝션 공격을 방지하기 위해 매개 변수(?)를 사용하여 동적으로 생성할 수 있는 SQL문을 실행할 때 사용됩니다. 
	    // prepareStatement 메서드를 호출하여 미리 준비된 SQL 문장 객체를 생성하고, ? 자리에 바인딩할 값들을 setXXX 메서드를 사용하여 설정하고, executeQuery 메서드를 호출하여 SQL 문장을 실행합니다.

	    System.out.println("책 제목을 입력하세요 : ");
	    String title = scanner.nextLine();
	    System.out.println("책 저자를 입력하세요 : ");
	    String author = scanner.nextLine();

	    try {
	        conn = Connector.getConnection();

	        String sql = "SELECT * FROM BOOK WHERE TITLE = ? AND AUTHOR = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, title); // 첫 번째 물음표에 title 값을 바인딩
	        pstmt.setString(2, author); // 두 번째 물음표에 author 값을 바인딩
	        rs = pstmt.executeQuery(); // SQL 쿼리를 실행하고, 그 결과로 생성된 ResultSet 객체를 반환함

	        if (rs.next()) { // ResultSet 객체는 DB에서 검색한 결과를 담은 객체, next() 메소드를 호출하여 각 행을 하나하나 읽음
	            int ID = rs.getInt("ID");
	            String TITLE = rs.getString("TITLE");
	            String AUTHOR = rs.getString("AUTHOR");
	            String PUBLISHER = rs.getString("PUBLISHER");
	            String LENDPOSSIBLE = rs.getString("LENDPOSSIBLE");
	            System.out.println("ID: " + ID + ", TITLE: " + TITLE + ", AUTHOR: " + AUTHOR + ", PUBLISHER: " + PUBLISHER + ", LENDPOSSIBLE: " + LENDPOSSIBLE);
	        } else {
	            System.out.println("없는 책입니다.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        Connector.close(conn);
	    }
	}


	
	public int searchID() {
	    // 제목, 저자 입력하면 책id만 int 형태로 반환, 아니면 0을 반환
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null; // ResultSet 객체는 DB에서 검색한 결과를 담은 객체

	    System.out.println("도서를 조회하여 책ID를 반환합니다.");

	    System.out.println("먼저, 책 제목을 입력하세요 : ");
	    String title = scanner.nextLine();
	    System.out.println("책 저자를 입력하세요 : ");
	    String author = scanner.nextLine();

	    // 책 제목, 저자가 일치하고 대출이 가능하면 ID를 반환, 아니면 0을 반환
	    try {
	        conn = Connector.getConnection();

	        String sql = "SELECT * FROM BOOK WHERE TITLE = ? AND AUTHOR = ? AND LENDPOSSIBLE = '대출가능'";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, title); // 첫 번째 물음표에 title 값을 바인딩
	        pstmt.setString(2, author); // 두 번째 물음표에 author 값을 바인딩
	        rs = pstmt.executeQuery(); // SQL 쿼리를 실행하고, 그 결과로 생성된 ResultSet 객체를 반환함

	        if (rs.next()) { // ResultSet 객체는 DB에서 검색한 결과를 담은 객체, next() 메소드를 호출하여 각 행을 하나하나 읽음
	            int ID = rs.getInt("ID");
	            return ID;
	        } else {
	            System.out.println("등록되지 않은 도서거나, 대출 중인 도서입니다.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        Connector.close(conn);
	    }
	    return 0;
	}
	
	public int searchReID() {
	    // 제목, 저자 입력하면 책id만 int 형태로 반환, 아니면 0을 반환
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null; // ResultSet 객체는 DB에서 검색한 결과를 담은 객체

	    System.out.println("반납할 도서가 맞는 지 확인합니다.");

	    System.out.println("먼저, 책 제목을 입력하세요 : ");
	    String title = scanner.nextLine();
	    System.out.println("책 저자를 입력하세요 : ");
	    String author = scanner.nextLine();

	    // 책 제목, 저자가 일치하고 대출이 가능하면 ID를 반환, 아니면 0을 반환
	    try {
	        conn = Connector.getConnection();

	        String sql = "SELECT * FROM BOOK WHERE TITLE = ? AND AUTHOR = ? AND LENDPOSSIBLE = '대출불가도서'";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, title); // 첫 번째 물음표에 title 값을 바인딩
	        pstmt.setString(2, author); // 두 번째 물음표에 author 값을 바인딩
	        rs = pstmt.executeQuery(); // SQL 쿼리를 실행하고, 그 결과로 생성된 ResultSet 객체를 반환함

	        if (rs.next()) { // ResultSet 객체는 DB에서 검색한 결과를 담은 객체, next() 메소드를 호출하여 각 행을 하나하나 읽음
	            int ID = rs.getInt("ID");
	            return ID;
	        } else {
	            System.out.println("등록되지 않은 도서거나, 대출 중인 도서가 아닙니다.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        Connector.close(conn);
	    }
	    return 0;
	}

	
	public int searchResult() {
		// 책 제목과 저자를 입력하고
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null; // ResultSet 객체는 DB에서 검색한 결과를 담은 객체
	    
	    System.out.println("도서 대출 가능 조회를 시작합니다.");
	    
	    System.out.println("책 제목을 입력하세요 : ");
	    String title = scanner.nextLine();
	    System.out.println("책 저자를 입력하세요 : ");
	    String author = scanner.nextLine();
	    
		// 회원이 아니면 0, 회원이고 대출이 가능하면 1, 회원이고 현재 대출중이면(대출이 불가능하면) 2을 반환
		try {
	        conn = Connector.getConnection();

	        String sql = "SELECT * FROM MEMBER WHERE TITLE = ? AND AUTHOR = ? AND LENDPOSSIBLE = '대출가능'";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, title); // 첫 번째 물음표에 title 값을 바인딩
	        pstmt.setString(2, author); // 두 번째 물음표에 author 값을 바인딩
	        rs = pstmt.executeQuery(); // SQL 쿼리를 실행하고, 그 결과로 생성된 ResultSet 객체를 반환함

	        if (rs.next()) { // ResultSet 객체는 DB에서 검색한 결과를 담은 객체, next() 메소드를 호출하여 각 행을 하나하나 읽음
	            int ID = rs.getInt("ID");
	            String TITLE = rs.getString("TITLE");
	            String AUTHOR = rs.getString("AUTHOR");
	            String LENDPOSSIBLE = rs.getString("LENDPOSSIBLE");
	            System.out.println("대출 가능한 도서입니다.");
	            return 0;
	        } else {
	        	System.out.println("등록되지 않은 도서거나, 대출 중인 도서입니다.");
	        	return 1;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        Connector.close(conn);
	    }
		return 0;
	}
	
	public void searchLendPossibleBook() { //대출 가능한 책 목록 보여주기
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null; // ResultSet 객체는 DB에서 검색한 결과를 담은 객체

	    System.out.println("대출 가능한 책 목록을 조회합니다.");

	    try {
	        conn = Connector.getConnection();

	        String sql = "SELECT * FROM BOOK WHERE LENDPOSSIBLE = '대출가능'";
	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery(); // SQL 쿼리를 실행하고, 그 결과로 생성된 ResultSet 객체를 반환함
	        
	        while (rs.next()) { // ResultSet 객체는 DB에서 검색한 결과를 담은 객체, next() 메소드를 호출하여 각 행을 하나하나 읽음
	            int ID = rs.getInt("ID");
	            String TITLE = rs.getString("TITLE");
	            String AUTHOR = rs.getString("AUTHOR");
	            String PUBLISHER = rs.getString("PUBLISHER");
	            String LENDPOSSIBLE = rs.getString("LENDPOSSIBLE");
	            System.out.println("ID: " + ID + ", TITLE: " + TITLE + ", AUTHOR: " + AUTHOR + ", PUBLISHER: " + PUBLISHER + ", LENDPOSSIBLE: " + LENDPOSSIBLE);
	        } 

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        Connector.close(conn);
	    }
	}
	
	@Override
	public void update() { // U,  책 수정
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() { //책 목록에서 삭제
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    System.out.println("도서를 삭제합니다.");
	    System.out.println("책 제목을 입력하세요 : ");
	    String title = scanner.nextLine();
	    System.out.println("책 저자를 입력하세요 : ");
	    String author = scanner.nextLine();
	    System.out.println("책 출판사를 입력하세요 : ");
	    String publisher = scanner.nextLine();
	    
	    try {
	        conn = Connector.getConnection();

	        String sql = "DELETE FROM BOOK WHERE TITLE = ? AND AUTHOR = ? AND PUBLISHER = ?";
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

