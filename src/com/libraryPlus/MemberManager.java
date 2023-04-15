package com.libraryPlus;

import java.util.ArrayList;
import java.util.Scanner;

// 회원 관리
public  class MemberManager implements Manager {

	@Override
	public void add() { // DB INSERT
		// 회원 가입
		ArrayList<Object> memberlist = new ArrayList<>(); //정보를 어레이 리스트 타입으로 받을거임
		Scanner sc = new Scanner(System.in);
		
		System.out.println("회원 가입을 시작합니다.");
		
		
	}

	@Override
	public int search() { // DB SELECT
		// 회원 이름, 회원 전화번호를 입력해서 맞으면 행 전체 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("회원 조회를 시작합니다.");
		System.out.println("이름을 입력하세요 : ");
		String inputName = sc.next(); // 이름 입력
		System.out.println("전화번호를 \"-\" 없이 입력하세요 : ");
		String inputPhonenumber = sc.next(); // 전화번호 입력
		return 0;
	    
	}
	
	public int searchID() { // 회원을 조회해서, id를 반환함
		return 0;
	}
	
	public int searchResult() {
		// 회원이 아니면 0, 회원이고 대출이 가능하면 1, 회원이고 현재 대출중이면(대출이 불가능하면) 2을 반환
		Scanner sc = new Scanner(System.in);
		System.out.println("회원 조회를 시작합니다.");
		System.out.println("이름을 입력하세요 : ");
		String inputName = sc.next(); // 이름 입력
		System.out.println("전화번호를 \"-\" 없이 입력하세요 : ");
		String inputPhonenumber = sc.next(); // 전화번호 입력
		// 회원이 아니면 0, 회원이고 대출이 가능하면 1, 회원이고 현재 대출중이면(대출이 불가능하면) 2을 반환
		return 0;
	}

	@Override
	public void update() { // DB UPDATE
		// 회원 정보 수정
		System.out.println("회원 정보 수정을 시작합니다.");
	}

	@Override
	public void delete() { // DB DELETE
		// 회원 정보 삭제
		System.out.println("회원 정보 삭제를 시작합니다. ");
	}

}
