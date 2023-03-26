package com.library;

// 반납 관리
public class ReturnManager implements Manager {

	
	@Override 
	public void add() { //반납 처리
		// 회원id.csv 파일을 생성, 반납한 책 이력 기록
		// 책id.csv 파일을 생성, 반납한 책 이력 기록
	}

	@Override
	public void search() { //반납했는지 확인
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() { //반납 날짜 수정 : 연장
		// booklist.csv 파일을 수정. lendPossible 0 -> 1으로	
		// memberlist.csv 파일을 수정. lendPossible 0 -> 1으로
		
	}

	@Override
	public void delete() { // 
		// TODO Auto-generated method stub
		
	}

}
