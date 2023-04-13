package com.libraryPlus;

import java.util.ArrayList;
import java.util.Scanner;

// 회원 관리
public class MemberManager implements Manager {

	@Override
	public void add() {
		// 회원 가입
		ArrayList<Object> memberlist = new ArrayList<>(); //정보를 어레이 리스트 타입으로 받을거임
		Scanner sc = new Scanner(System.in);
		
		System.out.println("회원 가입을 시작합니다.");
		
		
	}

	@Override
	public int search() {
		// 회원 조회 기능
		// 회원이면 회원 id를 보여주고, 아니면 회원이 아닙니다, 문구를 출력
		// 회원이면 memberId를 리턴함
		Scanner sc = new Scanner(System.in);
		System.out.println("회원 조회를 시작합니다.");
		System.out.println("이름을 입력하세요 : ");
		String inputName = sc.next(); // 이름 입력
		System.out.println("전화번호를 \"-\" 없이 입력하세요 : ");
		String inputPhonenumber = sc.next(); // 전화번호 입력
		FileManager filemanager = new FileManager(); //FileManager 클래스 인스턴스화
		return filemanager.memberIdSearch(inputName, inputPhonenumber);
	    // 회원아니면  outputMemberId = -1로 리턴하고, 
	    // 회원이면 그 사람의 memberId를 outputMemberId로 리턴함
	}

	@Override
	public void update() {
		// 회원 정보 수정
		System.out.println("회원 정보 수정을 시작합니다.");
	}

	@Override
	public void delete() {
		// 회원 정보 삭제
		System.out.println("회원 정보 삭제를 시작합니다. ");
	}

}
