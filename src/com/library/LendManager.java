package com.library;

import java.util.Scanner;

// 대출 관리
public class LendManager implements Manager {

	@Override
	public void add() { // 원래 record.csv에 기록하는 기능을 넣으려고 했는데, 생각해보니 그냥 TotalRecorder란 클래스를 만들어서 Main에 바로 적용하는게 좋을듯
	}

	@Override
	public int search() { //안쓸꺼임
		return 0;
	}

	public void update(int outputBookId, int outputMemberId) { 
	// 찐 대출 기능 (수정이니까 update에 할당)
	// book에서 대출 가능을 false로 바꿈 (수정)
	// 나중에 대출 기능은 while문으로 수정해야할듯?
		
	// 기록은 Main에서 TotalRecorder.add 사용해서 기록하기
		
		// 1. 회원 조회, outputMemberId로 회원id 받아옴
		// 만약 회원의 lendPossible이 0이면 "이미 대출 중인 도서가 있습니다"--->나중에 기능 추가
		// 위 기능 main에서 구현
		
		// 2. 회원의 lendPossible을 1 -> 0으로
		FileManager changingMemberlendpossible = new FileManager();
		changingMemberlendpossible.lendMemberLendPossibleUpdate(outputMemberId);
		
		// 3. 책 조회, outputBookId로 책id 받아옴
		// 위 기능 main에서 구현
		
		// 4. 책의 lendPossible을 1 ->0으로
		FileManager changingBooklendpossible = new FileManager();
		changingBooklendpossible.lendBookLendPossibleUpdate(outputBookId);
		
		// 3. 대출한 책 이력 기록, TotalRecorder 사용해서 구현하고 Main에서 적자
		// 책 id, 회원 id, 대출날짜(오늘날짜), 반납예정날짜 기록
		// 기록은 TotalRecord에서 할거임
		
	}

	@Override
	public void delete() { //안쓸꺼임
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
