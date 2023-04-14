package com.libraryPlus;

import java.util.Scanner;

// 도서관리
public class BookManager implements Manager {

	@Override
	public void add() { // 책 새로 등록
		// TODO Auto-generated method stub
		
	}

	@Override
	public int search() { 
		// 제목과 저자를 입력하면 책 정보 행 통째로 반환
		Scanner sc = new Scanner(System.in);
		System.out.println("책 조회를 시작합니다.");
		System.out.println("제목을 입력하세요 : ");
		String inputTitle = sc.next(); // 제목 입력
		System.out.println("저자 이름을 띄어 쓰기 없이 입력하세요 : ");
		String inputAuthor = sc.next(); // 전화번호 입력
		// 보유 중인 책이 아니면 0, 보유 중인 책이고 대출이 가능하면 1, 보유 중이고 현재 대출중이면(대출이 불가능하면) 2을 반환
		return 0;
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
