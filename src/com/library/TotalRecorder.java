package com.library;

public class TotalRecorder implements Recorder {

	@Override
	public void add() { 	// Create 대출, 반납 이력추가
		// 연장횟수, 대출날짜(오늘날짜), 책 id, 회원 id, 기본 반납예정날짜
	}

	@Override
	public void search() {	// Read 대출반납 이력조회
		// 기록 id return
	}

	@Override
	public void update() {	// Update 대출반납 이력수정(연장)
		// 반납 날짜 기록
		// 연장횟수, 대출날짜(오늘날짜), 책 id, 회원 id, 기본 반납예정날짜 , 실제 반납 날짜 기록
	}
	
	public void extendupdate() { // 연장처리
		// 연장처리
		// 해당 책을 조회하고
		// 그 책
		// 연장횟수, 대출날짜(오늘날짜), 책 id, 회원 id, 연장 날짜로 바꾸기, 연장횟수 1이라 표시
	}

	@Override
	public void delete() {	// Delete 이력삭제(안쓸거임, 이력 다 기록되게 설정할거니까)
		
	}

}
