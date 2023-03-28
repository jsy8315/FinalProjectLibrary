package com.library;

public class TotalRecorder implements Recorder {

	@Override
	public void add() { 	// Create 대출, 반납 이력추가
		// 기록 id, 책 id, 회원 id, 대출날짜(오늘날짜), 기본 반납예정날짜
	}

	@Override
	public void search() {	// Read 대출반납 이력조회
		// 기록 id return
	}

	@Override
	public void update() {	// Update 대출반납 이력수정(연장)
		// 기록 id, 책 id, 회원 id, 대출날짜(오늘날짜), 기본 반납예정날짜 , 실제 반납 날짜 기록
	}
	
	public void extendupdate() { // 연장처리
		// 기록 id, 책 id, 회원 id, 대출날짜(오늘날짜), 기본 반납예정날짜 , 실제 반납 날짜 기록
	}

	@Override
	public void delete() {	// Delete 이력삭제(안쓸거임, 이력 다 기록되게 설정할거니까)
		
	}

}
