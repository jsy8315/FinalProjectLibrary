package com.library;

import java.util.Scanner;

// 반납 관리
public class ReturnManager implements Manager {

	
	@Override 
	public void add() { //반납 처리
	}

	@Override
	public void search() { //반납했는지 확인
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() { //반납 
		
		// 1. 회원 조회, outputMemberId로 회원id 받아옴
		MemberManager membermanager = new MemberManager();
		membermanager.search();
		
		// 2. 회원의 lendPossible을 0 -> 1으로
		FileManager changingMemberlendpossible = new FileManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("회원 id를 입력하세요");
		int a = sc.nextInt();
		changingMemberlendpossible.returnMemberLendPossibleUpdate(a);
		
		// 3. 기록에서 회원이 빌린 책id를 받아옴, 이후 books.csv에서 검색
		
		
		// 4. 책의 lendPossible을 0 -> 1으로
		FileManager changingBooklendpossible = new FileManager();
		Scanner sc2 = new Scanner(System.in);
		System.out.println("책 id를 입력하세요");
		int b = sc.nextInt();
		changingBooklendpossible.returnBookLendPossibleUpdate(b);
		
		//5.기록하기
	}

	@Override
	public void delete() { // 
		// TODO Auto-generated method stub
		
	}

}
