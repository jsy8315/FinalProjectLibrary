package com.library;

import java.util.Scanner;

// 대출 관리
public class LendManager implements Manager {

	@Override
	public void add() { // 대출 이력 생성, Record에 기록 
	// 나중에 대출 기능은 while문으로 수정해야할듯?
		
		// 1. 회원 조회, outputMemberId로 회원id 받아옴
		MemberManager membermanager = new MemberManager();
		membermanager.search();
	
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
		
		
		
	}

	@Override
	public void search() { //안쓸꺼임
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() { //book에서 대출 가능을 false로 바꿈 (수정)
		// 1. booklist.csv 파일을 수정. lendPossible 1 -> 0으로	
		
		// 2. memberlist.csv 파일을 수정. lendPossible 1 -> 0으로	
	}

	@Override
	public void delete() { //안쓸꺼임
		// TODO Auto-generated method stub
		
	}

}
