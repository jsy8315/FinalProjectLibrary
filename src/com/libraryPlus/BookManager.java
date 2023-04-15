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
		
	}

	@Override
	public void search() { // 행 통째로 반환하기
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
		// 제목, 저자 입력하면 책id만 int 형태로 반환
		return 0;
	}
	
	public int searchResult() {
		// 책 제목과 저자를 입력하고
		// 보유 중인 책이 아니면 0, 보유 중인 책이고 대출이 가능하면 1, 보유 중이고 현재 대출중이면(대출이 불가능하면) 2을 반환
		Scanner sc = new Scanner(System.in);
		System.out.println("책 조회를 시작합니다.");
		System.out.println("제목을 입력하세요 : ");
		String inputTitle = sc.next(); // 제목 입력
		System.out.println("저자 이름을 띄어 쓰기 없이 입력하세요 : ");
		String inputAuthor = sc.next(); // 전화번호 입력
		// 보유 중인 책이 아니면 0, 보유 중인 책이고 대출이 가능하면 1, 보유 중이고 현재 대출중이면(대출이 불가능하면) 2을 반환
		return 0;
	}
	
	public 
	
	@Override
	public void update() { // U,  책 수정
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() { //책 목록에서 삭제
		// TODO Auto-generated method stub
		
	}

}
