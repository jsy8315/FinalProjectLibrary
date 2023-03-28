package com.library;

import java.util.Scanner;

// 대출 관리
public class LendManager implements Manager {

	@Override
	public void add() { 
	// 대출 이력 생성, Record에 기록 (추가니까 create에 할당)
		
	}

	@Override
	public void search() { //안쓸꺼임
	}

	@Override
	public void update() { 
	// 찐 대출 기능 (수정이니까 update에 할당)
	// book에서 대출 가능을 false로 바꿈 (수정)
	// 나중에 대출 기능은 while문으로 수정해야할듯?
		
		// 1. 회원 조회, outputMemberId로 회원id 받아옴
		MemberManager membermanager = new MemberManager();
		membermanager.search();
		// 만약 회원의 lendPossible이 0이면 "이미 다출 중인 도서가 있습니다"
	
		// 2. 회원의 lendPossible을 1 -> 0으로
		FileManager changingMemberlendpossible = new FileManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("회원 id를 입력하세요");
		int a = sc.nextInt();
		changingMemberlendpossible.lendMemberLendPossibleUpdate(a);
		
		// 3. 책 조회, outputBookId로 책id 받아옴
		BookManager bookmanager = new BookManager();
		bookmanager.search();
		
		// 4. 책의 lendPossible을 1 ->0으로
		FileManager changingBooklendpossible = new FileManager();
		Scanner sc2 = new Scanner(System.in);
		System.out.println("책 id를 입력하세요");
		int b = sc.nextInt();
		changingBooklendpossible.lendBookLendPossibleUpdate(b);
		
		// 3. 대출한 책 이력 기록
		// 아 이거 어케하지.........
		// 책 id, 회원 id, 대출날짜(오늘날짜), 반납예정날짜 기록
	}

	@Override
	public void delete() { //안쓸꺼임
	}

}
