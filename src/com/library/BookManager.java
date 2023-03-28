package com.library;

import java.util.Scanner;

// 도서관리
public class BookManager implements Manager {

	@Override
	public void add() { // C, 새로운 책 등록
		// TODO Auto-generated method stub
		
	}

	@Override
	public void search() { //R, 책 조회해서 id를 return해줌, 없으면 없다고 함
		// 책 조회 기능
		// 근데 이 스캐너 기능 다 main으로 돌려야됨
		Scanner sc = new Scanner(System.in);
		System.out.println("책 조회를 시작합니다.");
		System.out.println("제목을 입력하세요 : ");
		String inputTitle = sc.next(); // 제목 입력
		System.out.println("저자 이름을 띄어 쓰기 없이 입력하세요 : ");
		String inputAuthor = sc.next(); // 전화번호 입력
		FileManager filemanager = new FileManager(); //FileManager 클래스 인스턴스화
		filemanager.booksIdSearch(inputTitle, inputAuthor); // FileManager의 memberIdSearch 메소드 호출
	}

	@Override
	public void update() { // U,  책 수정
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() { //D
		// TODO Auto-generated method stub
		
	}

}
