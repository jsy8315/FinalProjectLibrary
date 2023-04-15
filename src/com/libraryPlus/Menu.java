package com.libraryPlus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Menu {
	Scanner sc = new Scanner(System.in);
	
	// 메인 while문 화면의 메뉴
	public int shouldContinue1Menu() { 
		System.out.println("도서 대출 프로그램을 시작합니다");
		System.out.println("1.대출/반납 업무 시작    2.회원관리    3.도서관리    4.종료");
		int shouldContinue1MenuInput = sc.nextInt();
		return shouldContinue1MenuInput;
	}
	
	public int shouldContinue11Menu() { 
		System.out.println("대출관리를 시작합니다");
		System.out.println("1.대출 해주기    2.반납 받기    3.반납 기한 연장    4.이전화면");
		int shouldContinue11MenuInput = sc.nextInt();
		return shouldContinue11MenuInput;
	}
	
	public int shouldContinue12Menu() { // 두번째 while문에서, 2.회원관리 다음의 메뉴
		System.out.println("회원관리를 시작합니다.");
		System.out.println("1.회원확인    2.회원가입    3.회원삭제    4.이전화면 ");
		int shouldContinue12MenuInput = sc.nextInt();
		return shouldContinue12MenuInput;
	}
	
	public int shouldContinue13Menu() { 
		System.out.println("도서관리를 시작합니다.");
		System.out.println("1.도서 검색   2.도서 추가   3.도서 삭제		4.대출 가능한 책 목록 확인		5.이전화면");
		int shouldContinue13MenuInput = sc.nextInt();
		return shouldContinue13MenuInput;
	}
}
