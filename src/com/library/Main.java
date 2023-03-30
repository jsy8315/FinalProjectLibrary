package com.library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean shouldContinue1 = true;

        while (shouldContinue1) { // 메인 while문 시작
            Menu firstMenu = new Menu(); 
            // "도서 대출 프로그램을 시작합니다"
            // "1.대출시작    2.회원관리    3.도서관리		4.종료"
            int shouldContinue1MenuInput = firstMenu.shouldContinue1Menu();

            switch (shouldContinue1MenuInput) {
            
                case 1: // 1.대출 시작
                    boolean shouldContinue11 = true; //메인 while문 안의 while문 내 첫번째 while문: 11
                    while (shouldContinue11) {
                        Menu loanMenu = new Menu();
                    	int shouldContinue11Input = loanMenu.shouldContinue11Menu();
                    	
                    	switch (shouldContinue11Input) {
                    		case 1: // 1.대출 해주기
                    			LendManager lendmanager = new LendManager();
                    			lendmanager.update(); // 반납처리
                    			
                    			// 대출 이력 record.csv에 추가
                    			MemberManager membermanager = new MemberManager();
                    			int outputBookId = membermanager.search();
                    			int outputMemberId
                    			
                    	        int  bookId = int outputBookId; // 일단 0으로 세팅, outputBookId 받아올거임
                    	        int memberId = a; // 일단 0으로 세팅, outputMemberId 받아올거임
                    	        
                    			TotalRecorder totalrecorder = new TotalRecorder();
                    			totalrecorder.add();
                    			break;
                    			
                    		case 2: // 2.반납 받기
                    			break;
                    			
                    		case 3: // 반납 날짜 확인
                    			break;
                    			
                    		case 4: // 반납 기한 연장
                    			break;
                    			
                    		case 5: // 이전화면으로 돌아가기
                                System.out.println("이전화면으로 돌아갑니다.\n");
                                shouldContinue11 = false; // 수정: shouldContinue 변수를 true로 변경
                                break; // shouldContinue11 while문 탈출
                    	}
                    }
                    break;

                case 2: // 2.회원관리 
                    boolean shouldContinue12 = true;
                    while (shouldContinue12) { //메인 while문 안의 while문 내 두번째 while문: 12
                        Menu memberMenu = new Menu();
                        int shouldContinue12Input = memberMenu.shouldContinue12Menu();

                        switch (shouldContinue12Input) {
                            case 1:
                            	// 1.회원 조회
                                break;

                            case 2:
                                // 2.회원가입
                                break;

                            case 3:
                                // 3.회원삭제
                                break;

                            case 4:
                                // 4.직전회원삭제취소
                                break;

                            case 5:
                                // 5.이전화면
                                System.out.println("이전화면으로 돌아갑니다.\n");
                                shouldContinue12 = false; // 수정: shouldContinue 변수를 true로 변경
                                break; // shouldContinue12 while문 탈출
                        }
                    }
                    break;

                case 3: // 3.도서관리 
                    boolean shouldContinue13 = true;
                    while (shouldContinue13) { //메인 while문 안의 세번째 while문 
                        Menu bookMenu = new Menu();
                    	int shouldContinue13Input = bookMenu.shouldContinue13Menu();
                    	
                    	switch (shouldContinue13Input) {
                    		case 1: // 대출가능한 책 보여주기 (현재 가지고 있는 책)
                    			break;
                    			
                    		case 2: // 대출불가능한 책 보여주기 (현재 없는 책, 반납 기간이 임박한 순서대로 정렬하기)
                    			break;
                    			
                    		case 3: // 전체 책을 출간된 순서대로 보여주기
                                break; 
                                
                    		case 4: // 전체 책을 출간된 순서대로 보여주기
                    			System.out.println("이전화면으로 돌아갑니다.\n");
                                shouldContinue13 = false; // 수정: shouldContinue 변수를 true로 변경
                                break; // shouldContinue13 while문 탈출
                    	}
                    }
                    break;


                case 4:
                    // 종료
                    System.out.println("종료합니다.");
                    shouldContinue1 = false;
                    break;
            }
        }
    }
}
