package com.library;

// 대출 관리
public class LendManager implements Manager {

	@Override
	public void add() { // 대출 이력 생성, Record에 기록
		
		// 1. 회원 조회, outputMemberId로 회원id 받아옴
		MemberManager membermanager = new MemberManager();
		membermanager.search();
		
		// 2. 회원의 lendPossible을 1 -> 0으로
		
		
		// 3. 책 조회, outputBookId로 책id 받아옴
		BookManager bookmanager = new BookManager();
		bookmanager.search();
		
		// 4. 책의 lendPossible을 1 ->0으로
		
		// 3.회원(id).csv 파일을 생성
		
		// 4. 대출한 책 이력 기록
		
		// 4.책(id).csv 파일을 생성, 대출한 책 이력 기록
		
		
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
