package com.libraryPlus;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// 회원 관리
public  class MemberManager implements Manager {
	Scanner scanner = new Scanner(System.in);
	@Override
	public void add() { // DB INSERT
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    System.out.println("회원을 추가합니다.");
	    System.out.println("이름을 입력하세요 : ");
	    String name = scanner.nextLine();
	    System.out.println("주소를 입력하세요 : ");
	    String address = scanner.nextLine();
	    System.out.println("전화번호를 공백없이 입력하세요 예시) 01012345678 : ");
	    String phonenumber = scanner.nextLine();
	    System.out.println("생년월일을 다음과 같이 입력하세요  예시) 1999/08/09 : ");
	    String birthdayString = scanner.nextLine(); // 문자열을 Date 객체로 변환
	    LocalDate birthday = LocalDate.parse(birthdayString, DateTimeFormatter.ofPattern("yyyy/MM/dd"));


	    try {
	        conn = Connector.getConnection();

	        String sql = "INSERT INTO MEMBER (NAME, ADDRESS, PHONENUMBER, BIRTHDAY) VALUES (?,?,?,?)";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, name); // 첫 번째 물음표에 title 값을 바인딩
	        pstmt.setString(2, address); // 두 번째 물음표에 author 값을 바인딩
	        pstmt.setString(3, phonenumber); // 세번째 물음표에 publisher 값 받인딩
	        pstmt.setDate(4, Date.valueOf(birthday));
	        pstmt.executeUpdate(); 
	    }
	     catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        Connector.close(conn);
	    }
	}

	@Override
	public void search() { // DB SELECT
		// 회원 이름, 회원 전화번호를 입력하고
		// 이 입력값이 맞으면 행 전체 출력
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null; // ResultSet 객체는 DB에서 검색한 결과를 담은 객체
	    
	    System.out.println("회원 조회를 시작합니다.");
	    System.out.println("회원 이름을 입력하세요 : ");
	    String name = scanner.nextLine();
	    System.out.println("회원 전화번호를 입력하세요 예시) 01098890001 : ");
	    String phonenumber = scanner.nextLine();

	    try {
	        conn = Connector.getConnection();

	        String sql = "SELECT * FROM MEMBER WHERE NAME = ? AND PHONENUMBER = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, name); // 첫 번째 물음표에 title 값을 바인딩
	        pstmt.setString(2, phonenumber); // 두 번째 물음표에 author 값을 바인딩
	        rs = pstmt.executeQuery(); // SQL 쿼리를 실행하고, 그 결과로 생성된 ResultSet 객체를 반환함

	        if (rs.next()) { // ResultSet 객체는 DB에서 검색한 결과를 담은 객체, next() 메소드를 호출하여 각 행을 하나하나 읽음
	            int ID = rs.getInt("ID");
	            String NAME = rs.getString("NAME");
	            String ADDRESS = rs.getString("ADDRESS");
	            String PHONENUMBER = rs.getString("PHONENUMBER");
	            Date BIRTHDAY = rs.getDate("BIRTHDAY"); 
	            Date MEMBERDAY = rs.getDate("MEMBERDAY"); 
	            String LENDPOSSIBLE = rs.getString("LENDPOSSIBLE");
	            
	            
	            System.out.println("ID: " + ID + ", NAME: " + NAME + ", ADDRESS: " + ADDRESS + ", PHONENUMBER: " + PHONENUMBER
	            		+ ", BIRTHDAY"+ ", LENDPOSSIBLE: " + LENDPOSSIBLE);
	        } else {
	            System.out.println("회원이 아닙니다.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        Connector.close(conn);
	    }
	}
	    
	
	public int searchID() { // 회원을 조회해서, id를 반환함
		return 0;
	}
	
	public int searchResult() {
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null; // ResultSet 객체는 DB에서 검색한 결과를 담은 객체
	    
	    System.out.println("회원 대출 가능 조회를 시작합니다.");
	    System.out.println("회원 이름을 입력하세요 : ");
	    String name = scanner.nextLine();
	    System.out.println("회원 전화번호를 입력하세요 예시) 01098890001 : ");
	    String phonenumber = scanner.nextLine();
	    
		// 회원이 아니면 0, 회원이고 대출이 가능하면 1, 회원이고 현재 대출중이면(대출이 불가능하면) 2을 반환
		try {
	        conn = Connector.getConnection();

	        String sql = "SELECT * FROM MEMBER WHERE NAME = ? AND PHONENUMBER = ? AND LENDPOSSIBLE = '대출가능회원'";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, name); // 첫 번째 물음표에 title 값을 바인딩
	        pstmt.setString(2, phonenumber); // 두 번째 물음표에 author 값을 바인딩
	        rs = pstmt.executeQuery(); // SQL 쿼리를 실행하고, 그 결과로 생성된 ResultSet 객체를 반환함

	        if (rs.next()) { // ResultSet 객체는 DB에서 검색한 결과를 담은 객체, next() 메소드를 호출하여 각 행을 하나하나 읽음
	            int ID = rs.getInt("ID");
	            String NAME = rs.getString("NAME");
	            String PHONENUMBER = rs.getString("PHONENUMBER");
	            String LENDPOSSIBLE = rs.getString("LENDPOSSIBLE");
	            System.out.println("대출 가능한 회원입니다.");
	            return 0;
	        } else {
	        	System.out.println("회원이 아니거나, 대출 불가 회원입니다. ");
	        	return 1;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        Connector.close(conn);
	    }
		return 0;
	}

	@Override
	public void update() { // DB UPDATE
		// 회원 정보 수정
		System.out.println("회원 정보 수정을 시작합니다.");
	}

	@Override
	public void delete() { // DB DELETE
		// 회원 정보 삭제
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    System.out.println("회원 정보 삭제를 시작합니다.");
	    System.out.println("회원 이름을 입력하세요 : ");
	    String name = scanner.nextLine();
	    System.out.println("회원 전화번호를 입력하세요 예시) 01098890001: ");
	    String phonenumber = scanner.nextLine();
	    
	    try {
	        conn = Connector.getConnection();

	        String sql = "DELETE FROM MEMBER WHERE NAME = ? AND PHONENUMBER = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, name); // 첫 번째 물음표에 name 값을 바인딩
	        pstmt.setString(2, phonenumber); // 두 번째 물음표에 phonenumber 값을 바인딩
	        pstmt.executeUpdate(); 
	    }
	     catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        Connector.close(conn);
	    }
	}
}

