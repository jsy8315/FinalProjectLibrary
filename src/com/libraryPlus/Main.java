package com.libraryPlus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean shouldContinue1 = true;

        while (shouldContinue1) { // 메인 while문 시작, 메인 while문을 돌리면서 진행이 되게끔 했음
            Menu firstMenu = new Menu(); 
            // "도서 대출 프로그램을 시작합니다"
            // "1.대출/반납 업무 시작    2.회원관리    3.도서관리    4.종료"
            int shouldContinue1MenuInput = firstMenu.shouldContinue1Menu();

            switch (shouldContinue1MenuInput) {
            
                case 1: // 1.대출/반납 업무 시작
                    boolean shouldContinue11 = true; //메인 while문 안의 while문 내 첫번째 while문: 11
                    while (shouldContinue11) { 
                        Menu loanMenu = new Menu();
                    	int shouldContinue11Input = loanMenu.shouldContinue11Menu();
                    	// "1.대출 해주기    2.반납 받기    3.반납 날짜 확인    4.반납 기한 연장   5.이전화면"
                    	
                    	switch (shouldContinue11Input) {
                    		case 1: // 1.대출 해주기
                    	        
                    			// 1-1. 회원 조회
                    				// 회원 명단에 있는지 없는지 (없으면 전단계로 보냄)
                    				// 회원 명단에 있다면 대출이 가능한지 안가능한지 (불가능하면 전단계로 보냄)
                    				// 즉, 회원 AND 대출 중이 아니면 (조건을 설정하여 테이블 조회)->  회원번호를 RETURN
                    				// 그 외 조건은(위 조건으로 조회가 안되는 경우) 전단계로 돌려보내는 코드를 여기 이클립스에 적으면 됨
                    			
                    			// 1-2. 책 조회
                    				// 책을 조회해서 명단에 있는지 없는지 확인
                    				// 대출이 가능한지 불가능한지 확인
                    				// 즉, 책이 있고 대출이 가능하다면 (조건을 설정하여 테이블 조회) -> 책의 번호를 RETURN
                    			// 그 외 조건은(위 조건으로 조회가 안되는 경우) 전단계로 돌려보내는 코드를 여기 이클립스에 적으면 됨
                    			
                    			
                    			// 1-3. 대출 처리 
                    				// 회원 테이블에 빌린 책 번호, 오늘 날짜, 반납 예정 날짜 추가, 회원 대출 중 표시 추가
                    				// 책 테이블에 빌린 회원 번호, 오늘 날짜. 반납 예쩡 날짜 추가, 대출 중 표시 추가
                    			
                    			// 1-4. 대출 이력 record 테이블에 추가
                    			
                    			break;
                    			
                    		case 2: // 2.반납 받기
                    			
                    			// 2-1. 회원 조회,
                					// 회원 명단에 있는지 없는지 (없으면 전단계로 보냄)
                					// 회원 명단에 있다면 반납이 가능한지 안가능한지 (불가능하면 전단계로 보냄)
                					// 즉, 회원 AND 대출 중이면 (조건을 설정하여 테이블 조회)->  회원번호를 RETURN
                					// 그 외 조건은(위 조건으로 조회가 안되는 경우) 전단계로 돌려보내는 코드를 여기 이클립스에 적으면 됨
                    			
                    			// 2-2. 대출 중인 책을 조회
                					// 책을 조회해서 명단에 있는지 없는지 확인
                					// 대출이 가능한지 불가능한지 확인
                					// 즉, 책이 있고 대출이 가능하다면 (조건을 설정하여 테이블 조회) -> 책의 번호를 RETURN
                    				// 그 외 조건은(위 조건으로 조회가 안되는 경우) 전단계로 돌려보내는 코드를 여기 이클립스에 적으면 됨
                    			
                    			// 2-3. 반납 처리
                					// 회원 테이블에 빌린 책 번호, 오늘 날짜, 반납 예정 날짜 추가, 회원 대출 중 표시 추가
                					// 책 테이블에 빌린 회원 번호, 오늘 날짜. 반납 예정 날짜 추가, 대출 중 표시 추가
                    			
                    			// 2-4. 반납 이력 record 테이블에 추가
                    			break;
                    			
                    		case 3: // 반납 날짜 확인
                    			// 3-1. 회원 조회,
                					// 회원 명단에 있는지 없는지 (없으면 대상자가 아니라며 전단계로 보냄)
                					// 회원 명단에 있다면 반납할 책이 있는지 없는지 확인 (없으면 전단계로 보냄)
                			
                    			// 3-2. 대출 중인 책을 조회
                    				// 회원 번호를 사용해 RECORD 테이블
                    			
                    			// 3-3. 반납 날짜 조회
                    			break;
                    			
                    		case 4: // 반납 기한 연장
                    			// 반납연장은 대출 중인 상태 AND 연체가 아닐때 가능
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
