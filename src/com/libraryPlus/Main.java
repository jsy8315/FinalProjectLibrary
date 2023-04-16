package com.libraryPlus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean shouldContinue1 = true;
        
        MemberManager memberManager1 = new MemberManager(); //MemberManager 클래스를 사용해서 인스턴스 생성, 활용하도록 하자
        BookManager bookManager1 = new BookManager(); //BookManager 사용
        LendManager lendManager1 = new LendManager();
        TotalRecorder totalRecorder1 = new TotalRecorder();
        ReturnManager returnManager1 = new ReturnManager();

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
                    	// "1.대출 해주기    2.반납 받기    3.반납 기한 연장    4.이전화면"
                    	
                    	switch (shouldContinue11Input) {
                    		case 1: // 1.대출 해주기
                    	        
                    			//1-1. 회원 이름, 폰번호 입력받아서 대출 가능이면 회원ID, 안되면 0을 리턴
                    			int memberID = memberManager1.searchID();
                    			
                    			//1-2. 책 저자, 책 제목 입력받아서 대출 가능이면 책ID, 안되면 0을 리턴
                    			int bookID = bookManager1.searchID();
                    			
                    			//1-3. 둘다 대출 가능이면 book 테이블, member 테이블의 lendpossible을 대출 불가로 변경(UPDATE)
                    			if (memberID != 0 && bookID !=0 ) {
                    				lendManager1.update(); //book 테이블, member 테이블의 lendpossible을 대출 불가로 변경(UPDATE), lend 테이블에 행 삽입
                    			} else {
                    				System.out.println("대출 불가능한 회원이거나, 대출 중인 도서입니다. 이전 화면으로 돌아갑니다.");
                    				break;
                    			}
                    			
                    			System.out.println("대출처리가 완료되었습니다.");
                    			
                    			// 1-4. 반납 날짜 알려주기
                    			LocalDate today = LocalDate.now(); // 현재 날짜 
                    			LocalDate futureDate = today.plusWeeks(2); // 현재 날짜에서 2주 뒤의 날짜를 계산
                    			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd"); // 포맷을 "yy/MM/dd"로 수정
                    			String formattedDate = futureDate.format(formatter); // 연월일 형식으로 변환
                    			System.out.println("반납 기한은 : " + formattedDate + "까지 입니다."); // formattedDate 변수 사용
                    			System.out.println("이전 화면으로 돌아갑니다.");
                    			break;
                    			
                    		case 2: // 2.반납 받기
                    			
                    			// 2-1. 회원 조회,책 조회
                					// 회원 명단에 있는지 없는지 (없으면 전단계로 보냄)
                					// 회원 명단에 있다면 반납이 가능한지 안가능한지 (불가능하면 전단계로 보냄)
                					// 즉, 회원 AND 대출 중이면 (조건을 설정하여 테이블 조회)->  회원번호를 RETURN
                					// 그 외 조건은(위 조건으로 조회가 안되는 경우) 전단계로 돌려보내는 코드를 여기 이클립스에 적으면 됨
                    			
                    			// 회원이 아니면 0, 회원이고 대출이 가능하면 1, 회원이고 현재 대출중이면(대출이 불가능하면) 2을 반환
                    			System.out.println("반납을 진행합니다. 먼저, 회원 조회를 시작합니다.");
                    			int memberID2 = memberManager1.searchID(); //MemberManager를 통해 회원 조회
                    			
                    			int bookID2 = bookManager1.searchID(); //MemberManager를 통해 회원 조회
                    			
                    			// 대출 테이블을 조회하여 memberID가 bookID가 일치하고 대출 중이면 1, 둘이 일치하지 않으면 0 반환
                    			int returnResult = totalRecorder1.search();
                    			// memberID와 bookID를 넣어서 작동하는 메소드를 TotalRecorder에 생성, 이후 사용
                    			if (returnResult == 1) {
                    				System.out.println("회원임을 확인하였습니다. 대출 중인 도서를 반납합니다.");
                    			} else {
                    				System.out.println("도서 정보가 일치하지 않습니다. 빌린 책 정보를 다시 확인해주세요. 이전화면으로 돌아갑니다.");
                    				shouldContinue11 = false; // 수정: shouldContinue 변수를 true로 변경
                                    break; // shouldContinue11 while문 탈출
                    			};
                    			
                    			// 2-2. 반납 처리
                					// 회원 테이블에 빌린 책 번호, 오늘 날짜, 반납 예정 날짜 추가, 회원 대출 중 표시 추가
                					// 책 테이블에 빌린 회원 번호, 오늘 날짜. 반납 예정 날짜 추가, 대출 중 표시 추가
                    			System.out.println("반납 처리를 시작합니다.");
                    			returnManager1.update();
                    			
                    			// 2-3. 반납 이력 record 테이블에 추가
                    			totalRecorder1.add();
                    			System.out.println("대출처리가 완료되었습니다.");
                    			break;
                    			
                    		case 3: // 반납 기한 연장
                    			// 반납연장은 대출 중인 상태 AND 연체가 아닐때 가능
                    			break;
                    			
                    		case 4: // 이전화면으로 돌아가기
                                System.out.println("이전화면으로 돌아갑니다.\n");
                                shouldContinue11 = false; // 수정: shouldContinue 변수를 true로 변경
                                break; // shouldContinue11 while문 탈출
                    	}
                    }
                    break;

                case 2: // 2.회원관리 		"1.회원확인    2.회원가입    3.회원삭제    4.이전화면"
                    boolean shouldContinue12 = true;
                    while (shouldContinue12) { //메인 while문 안의 while문 내 두번째 while문: 12
                        Menu memberMenu = new Menu();
                        int shouldContinue12Input = memberMenu.shouldContinue12Menu();

                        switch (shouldContinue12Input) {
                            case 1:
                            	// 1.회원 조회 SELECT
                            	memberManager1.search();
                            	System.out.println("회원조회가 완료되었습니다. 이전화면으로 돌아갑니다.");
                                break;

                            case 2:
                                // 2.회원가입 INSERT
                            	memberManager1.add();
                            	System.out.println("회원가입이 완료되었습니다. 이전화면으로 돌아갑니다.");
                                break;

                            case 3:
                                // 3.회원삭제 DELETE
                            	memberManager1.delete();
                            	System.out.println("회원삭제가 완료되었습니다. 이전화면으로 돌아갑니다.");
                                break;

                            case 4:
                                // 3.이전화면
                                System.out.println("이전화면으로 돌아갑니다.\n");
                                shouldContinue12 = false; // 수정: shouldContinue 변수를 true로 변경
                                break; // shouldContinue12 while문 탈출
                        }
                    }
                    break;

                case 3: // 3.도서관리 		"1.도서 검색   2.도서 추가   3.도서 삭제 	4. 대출 가능한 책 목록 확인 	5.이전화면"
                    boolean shouldContinue13 = true;
                    while (shouldContinue13) { //메인 while문 안의 세번째 while문 
                        Menu bookMenu = new Menu();
                    	int shouldContinue13Input = bookMenu.shouldContinue13Menu();
                    	
                    	switch (shouldContinue13Input) {
                    		case 1: // 3-1. 도서 검색
                    			bookManager1.search();
                    			System.out.println("검색을 마치고 이전화면으로 돌아갑니다.\n");
                                break; // shouldContinue13 while문 탈출
                    			
                    		case 2: // 3-2. 도서 추가
                    			bookManager1.add();
                    			System.out.println("도서가 추가되었습니다. 이전화면으로 돌아갑니다.\n");
                                break; // shouldContinue13 while문 탈출
                    			
                    		case 3: // 3-3. 도서 삭제
                    			bookManager1.delete();
                    			System.out.println("도서가 삭제되었습니다. 이전화면으로 돌아갑니다.\n");
                                break; // shouldContinue13 while문 탈출
                                
                    		case 4: // 3-4. 대출 가능한 책 목록 확인
                    			bookManager1.searchLendPossibleBook();
                    			System.out.println("대출 가능한 책 목록 조회를 완료하였습니다. 이전화면으로 돌아갑니다.\n");
                                break; // shouldContinue13 while문 탈출
                                
                    		case 5: // 3-5. 이전화면
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
