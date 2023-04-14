package com.libraryPlus;

import java.util.Scanner;

// 도서관리
public class BookManager implements Manager {

	@Override
	public void add() { // C, 새로운 책 등록
		// TODO Auto-generated method stub
		
	}

	@Override
	public int search() { //R, 책 조회해서 id를 return해줌, 없으면 int 0을 리턴
		// 책 조회 기능
		// 근데 이 스캐너 기능 다 main으로 돌려야됨
		Scanner sc = new Scanner(System.in);
		System.out.println("책 조회를 시작합니다.");
		System.out.println("제목을 입력하세요 : ");
		String inputTitle = sc.next(); // 제목 입력
		System.out.println("저자 이름을 띄어 쓰기 없이 입력하세요 : ");
		String inputAuthor = sc.next(); // 전화번호 입력
		// File IO를 써야되나? 그냥 여기다가 쓰자. FileManager를 소환하는 방식으로 하기에는 너무 복잡함. 여기서 그냥 쓰자
		return 0;
	}

	@Override
	public void update() { // U,  책 수정
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() { //D
		// TODO Auto-generated method stub
		
	}

}
